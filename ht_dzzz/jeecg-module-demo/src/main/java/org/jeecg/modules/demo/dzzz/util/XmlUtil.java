/**
 * xml工具类
 */
package org.jeecg.modules.demo.dzzz.util;



import cn.afterturn.easypoi.entity.ImageEntity;
import cn.afterturn.easypoi.word.WordExportUtil;

import com.suwell.ofd.custom.wrapper.io.IOTools;
import com.unfbx.chatgpt.exception.BaseException;
import com.xkcoding.http.util.StringUtil;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;


import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

import org.docx4j.TraversalUtil;

import org.docx4j.dml.wordprocessingDrawing.Inline;
import org.docx4j.finders.RangeFinder;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.BinaryPartAbstractImage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.org.apache.poi.util.IOUtils;
import org.docx4j.wml.*;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.jeecg.common.util.CollectionUtils;
import org.jeecg.common.util.PmsUtil;
import org.jeecg.common.util.StringUtils;
import org.jeecg.modules.demo.dzzz.certinfo.entity.*;
import org.jeecg.modules.demo.dzzz.certmatadataversion.entity.CertMetadata;
import org.jeecg.modules.demo.dzzz.dataExchange.util.YwUtil;
import org.jeecg.modules.demo.dzzz.sczz.ZsDto;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * 根据模板生成证书pdf文件时用到
 *
 */
@Component
public class XmlUtil {

    private static final Log LOG = LogFactory.getLog(XmlUtil.class);

    /**
     * 二维码服务地址
     */
    private static String serverUrl;
    /**
     * 二维码临时文件路径
     */
    private static String tempPath;

    @Value("${qrcode.serverUrl}")
    public void setServerUrl(String serverUrl) {
        XmlUtil.serverUrl = serverUrl;
    }

    @Value("${qrcode.tempPath}")
    public void setTempPath(String tempPath) {
        XmlUtil.tempPath = tempPath;
    }

    /**
     * 二维码地址
     * @param licenseId
     * @return
     */
    public String getQrCodeValue(String licenseId) {
        if (StringUtils.isBlank(licenseId)) {
            throw new BaseException(String.format("生成二维码地址失败：licenseId=%s", licenseId));
        }
        return String.format(serverUrl, licenseId);
    }

    /**
     * 根据不同的证书类型生成相应的xml字符串

     *            证书实体bean
     * @return
     */
  /*  public static String createCardprintXML(ZsDto cardprint, List<TYwZsZsy> columns) {
        String strXML = null;
        // 产生xml头，并指定根为items
        Document document = DocumentHelper.createDocument();
        Element items = document.addElement("items");
        try {
            // 填充证书数据
            fillData(items, cardprint, columns);
            // 将数据以字符串形式输出
            StringWriter strWtr = new StringWriter();
            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding("UTF-8");
            XMLWriter xmlWriter = new XMLWriter(strWtr, format);
            xmlWriter.write(document);
            strXML = strWtr.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException("组装xml失败:{}",e);
        }
        strXML=document.asXML();
        LOG.info("组装xml："+strXML);
        return strXML;
    }
    */
    public static int getWordByWord(String templatepath, String outpath, ZsDto zsDto, String qymc) {
        List<File> deleteFiles = new ArrayList<>();
        try {
            // 准备数据
            Map<String, Object> data = new HashMap<>();
            data.put("qymc", qymc);
            data.put("cert", zsDto);
            /* 药品生产许可证子表 */
            {
                data.put("zclist", zsDto.getSubMap().get("zc"));
                List<Map<String, Object>> listmap = new ArrayList<>();
                if (CollectionUtils.isNotEmpty(zsDto.getSubMap().get("wt"))) {
                    for (CertSubTable cert : zsDto.getSubMap().get("wt")) {
                        Map<String, Object> map = new HashMap<>();
                        map.put("protype", "委托");
                        map.put("refcompname", cert.getString("refcompname"));
                        //受托用注册地址  ，委托用生产地址  有限注册地址 其次生产地址
                        if (StringUtil.isNotEmpty(cert.getString("refcompaddr"))) {
                            map.put("refcompaddr", cert.getString("refcompaddr"));
                        } else {
                            map.put("refcompaddr", cert.getString("addrdetail"));
                        }
                        map.put("drugname", cert.getString("drugname"));
                        map.put("regnumb", cert.getString("regnumb"));
                        map.put("entrustvalidate", cert.getDate("entrustvalidate"));
                        listmap.add(map);
                    }
                }
                if (CollectionUtils.isNotEmpty(zsDto.getSubMap().get("st"))) {
                    for (CertSubTable cert : zsDto.getSubMap().get("st")) {
                        Map<String, Object> map = new HashMap<>();
                        map.put("protype", "受托");
                        map.put("refcompname", cert.getString("refcompname"));
                        //受托用注册地址  ，委托用生产地址  有限注册地址 其次生产地址
                        if (StringUtil.isNotEmpty(cert.getString("refcompaddr"))) {
                            map.put("refcompaddr", cert.getString("refcompaddr"));
                        } else {
                            map.put("refcompaddr", cert.getString("addrdetail"));
                        }
                        map.put("drugname", cert.getString("drugname"));
                        map.put("regnumb", cert.getString("regnumb"));
                        map.put("entrustvalidate", cert.getDate("entrustvalidate"));
                        listmap.add(map);
                    }
                }
                data.put("stwt", listmap);
            }
            /* 药品出口准许证 */
            if (CollectionUtils.isNotEmpty(zsDto.getSubMap().get("ypck"))) {
                List<Map<String, Object>> listckxkz = new ArrayList<>();
                for (CertSubTable cert : zsDto.getSubMap().get("ypck")) {
                    Map<String, Object> map = new HashMap<>();
                    map.put("ckypmc", cert.getString("ckywmc"));
                    map.put("spbm", cert.getString("spbm"));
                    //受托用注册地址  ，委托用生产地址  有限注册地址 其次生产地址
                    map.put("jx", cert.getString("jx"));
                    map.put("bzandgg", cert.getString("ckywgz"));
                    map.put("ckywsl", cert.getString("ckywsl"));
                    listckxkz.add(map);
                }
                data.put("ypckzbd", listckxkz);
            }

            XWPFDocument doc = WordExportUtil.exportWord07(templatepath, data);
            File file1 = new File(tempPath);
            if (!file1.exists()) {
                file1.mkdirs();
            }
            deleteFiles.add(file1 = new File(file1, FilenameUtils.getBaseName(outpath) + ".docx"));
            //用一个文件过渡
            FileOutputStream fos = new FileOutputStream(file1);
            doc.write(fos);
            fos.close();
            //内置转ofd
            if (OfdUtil.WordToOfd(file1.getAbsolutePath(), outpath))
                return 1;
            else {
                deleteFiles.add(new File(outpath));
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            deleteFiles.add(new File(outpath));
            return 0;
        } finally {
            for (File file : deleteFiles) FileUtils.deleteQuietly(file);
        }
    }

    /***
     *  聚合性word模板生成ofd
     * @param templatepath
     * @param outpath
     * @param zsDto
     */
    public int getWordToOfdByJH(String templatepath,String outpath,ZsDto zsDto,List<CertMetadata> certMetadataList) {
        List<File> deleteFiles = new ArrayList<>();
        FileOutputStream tmpOut = null;
        try {
            // 准备数据
            Map<String, Object> data = new HashMap<>();
            //先遍历证书元的数据
            for (CertMetadata metadata :certMetadataList) {
                Object value = null;
                try {
                    if (StringUtils.isNotBlank(metadata.getLbs()) && !StringUtils.equalsIgnoreCase(metadata.getLbs(), metadata.getYssx())) {
                        value = PropertyUtils.getProperty(zsDto, metadata.getLbs());
                    } else if ("cp".equals(metadata.getYssx().toLowerCase(Locale.ROOT))) {
                        value = PropertyUtils.getProperty(zsDto, "chanping");
                    } else if ("gg".equals(metadata.getYssx().toLowerCase(Locale.ROOT))) {
                        value = PropertyUtils.getProperty(zsDto, "guige");
                    } else if ("cs".equals(metadata.getYssx().toLowerCase(Locale.ROOT))) {
                        value = PropertyUtils.getProperty(zsDto, "chaosong");
                    } else {
                        value = PropertyUtils.getProperty(zsDto, metadata.getYssx().toLowerCase(Locale.ROOT));
                    }
                    if (value != null) {
                        Integer zslx = zsDto.getZslx();
                        String yssx = metadata.getYssx();
                        if (value instanceof Date || StringUtils.equalsAnyIgnoreCase(yssx, "yxqz", "yxqq", "fzrq")) {
                            Calendar cal = Calendar.getInstance();
                            if (value instanceof Date) {
                                cal.setTime((Date) value);
                            } else {
                                cal.setTime(DateUtils.parseDate(value));
                                data.put(metadata.getYssx(), value);
                            }
                            String year = String.valueOf(cal.get(Calendar.YEAR));
                            data.put(yssx.toLowerCase() + "_Y", year);
                            String month = cal.get(Calendar.MONTH) + 1 + "";
                            data.put(yssx.toLowerCase() + "_M", month);
                            String day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
                            data.put(yssx.toLowerCase() + "_D", day);
                        } else {
                            data.put(metadata.getYssx(), value);
                        }
                        if (StringUtils.equalsAnyIgnoreCase(yssx, "dh", "cz", "ylzd4")) {
                            data.put(yssx.toLowerCase() + "_MM", StringUtils.desensitize(value + ""));
                        }
                    }
                }
                catch (Exception e)
                {
                    System.out.println("======未找到对应数据");
                }
            }

            //封装子表数据
            //自产
            data.put("zclist", CollectionUtils.defaultIfEmpty(zsDto.getSubMap().get("zc"), new ArrayList<>()));
            //合并委托以及受托
            List<Map<String, Object>> listmap = new ArrayList<>();
            for (CertSubTable cert : CollectionUtils.defaultIfEmpty(zsDto.getSubMap().get("wt"), new ArrayList<>())) {
                Map<String, Object> map = new HashMap<>();
                map.put("protype", cert.getString("protype"));
                map.put("refcompname", cert.getString("refcompname"));
                //受托用注册地址  ，委托用生产地址  有限注册地址 其次生产地址
                if (StringUtil.isNotEmpty(cert.getString("refcompaddr"))) {
                    map.put("refcompaddr", cert.getString("refcompaddr"));
                } else {
                    map.put("refcompaddr", cert.getString("addrdetail"));
                }
                map.put("drugname", cert.getString("drugname"));
                map.put("regnumb", cert.getString("regnumb"));
                map.put("entrustvalidate", cert.getDate("entrustvalidate"));
                listmap.add(map);
            }
            for (CertSubTable cert : CollectionUtils.defaultIfEmpty(zsDto.getSubMap().get("st"), new ArrayList<>())) {
                Map<String, Object> map = new HashMap<>();
                map.put("protype", cert.getString("protype"));
                map.put("refcompname", cert.getString("refcompname"));
                //受托用注册地址  ，委托用生产地址  有限注册地址 其次生产地址
                if (StringUtil.isNotEmpty(cert.getString("refcompaddr"))) {
                    map.put("refcompaddr", cert.getString("refcompaddr"));
                } else {
                    map.put("refcompaddr", cert.getString("addrdetail"));
                }
                map.put("drugname", cert.getString("drugname"));
                map.put("regnumb", cert.getString("regnumb"));
                map.put("entrustvalidate", cert.getDate("entrustvalidate"));
                listmap.add(map);
            }
            if (CollectionUtils.isNotEmpty(listmap)) data.put("stwt", listmap);
            //药品出口准许证
            List<Map<String, Object>> listckxkz = new ArrayList<>();
            for (CertSubTable cert : CollectionUtils.defaultIfEmpty(zsDto.getSubMap().get("ypck"), new ArrayList<>())) {
                Map<String, Object> map = new HashMap<>();
                map.put("ckypmc", cert.getString("ckywmc") + " (" + cert.getString("ckywywmc") + ")");
                map.put("spbm", cert.getString("spbm"));
                //受托用注册地址  ，委托用生产地址  有限注册地址 其次生产地址
                map.put("jx", cert.getString("jx"));
                map.put("bzandgg", cert.getString("ckywbz") + " (" + cert.getString("ckywgz") + ")");
                map.put("ckywsl", cert.getString("ckywsl"));
                listckxkz.add(map);
            }
            if (CollectionUtils.isNotEmpty(listckxkz)) data.put("ypckzbd", listckxkz);
            //出口欧盟
            List<Map<String, Object>> listckoum = new ArrayList<>();
            for (CertSubTable cert : CollectionUtils.defaultIfEmpty(zsDto.getSubMap().get("om"), new ArrayList<>())) {
                Map<String, Object> map = new HashMap<>();
                map.put("yptymczwyw", StringUtils.format("%s  %s", cert.getString("yptymczw"), cert.getString("yptymcyw")));
                map.put("jgffzwyw", StringUtils.format("%s  %s", cert.getString("jgffzw"), cert.getString("jgffyw")));
                //受托用注册地址  ，委托用生产地址  有限注册地址 其次生产地址
                map.put("zgyppzwhzwyw", StringUtils.format("%s  %s", cert.getString("zgyppzwhzw"), cert.getString("zgyppzwhyw")));
                listckoum.add(map);
            }
            if (CollectionUtils.isNotEmpty(listckoum)) data.put("ckomzbd", listckoum);
            //第一类医疗器械委托生产备案
            data.put("ylqxwtscbazb", CollectionUtils.defaultIfEmpty(zsDto.getSubMap().get("dyl"), new ArrayList<>()));
            //二三类医疗器械生产许可证-副页V1
            data.put("eslylqxsczb", CollectionUtils.defaultIfEmpty(zsDto.getSubMap().get("qxxkz"), new ArrayList<>()));
            //ylqxwtscba二三类医疗器械委托生产备案凭证V1
            data.put("ylqxwtscba", CollectionUtils.defaultIfEmpty(zsDto.getSubMap().get("qxba23"), new ArrayList<>()));
            //麻醉药品和精神药品定点生产批件V2
            data.put("mzypjsypddscpc", CollectionUtils.defaultIfEmpty(zsDto.getSubMap().get("mz"), new ArrayList<>()));
            //药品出口销售证明（未在中国注册药品）
            data.put("ypckxszmzb-wzzgzcyp", CollectionUtils.defaultIfEmpty(zsDto.getSubMap().get("ypxs"), new ArrayList<>()));
            //药品出口销售证明已在中国批准上市药品
            data.put("ypckxszm", CollectionUtils.defaultIfEmpty(zsDto.getSubMap().get("ypxs"), new ArrayList<>()));
            //临床试验备案
            List<Map<String, Object>> listlcsy = new ArrayList<>();
            List<CertSubTable> list = zsDto.getSubMap().get("qxba");
            if (CollectionUtils.isNotEmpty(list)) {
                List<Map<String, Object>> map1List = new ArrayList<>();
                List<Map<String, Object>> map2List = new ArrayList<>();
                for (CertSubTable lcsy : list) {
                    if ("1".equals(lcsy.getString("lb"))) {
                        Map<String, Object> map = new HashMap<>();
                        map.put("mc1", lcsy.getString("mc"));
                        map.put("dz1", lcsy.getString("dz"));
                        map.put("lx1", lcsy.getString("lxr"));
                        map.put("dh1", lcsy.getString("dh"));
                        map1List.add(map);
                    }
                    if ("2".equals(lcsy.getString("lb"))) {
                        Map<String, Object> map = new HashMap<>();
                        map.put("mc2", lcsy.getString("mc"));
                        map.put("dz2", lcsy.getString("dz"));
                        map.put("lx2", lcsy.getString("lxr"));
                        map.put("dh2", lcsy.getString("dh"));
                        map2List.add(map);
                    }
                }
                // 取小
                int min = Math.min(map1List.size(), map2List.size());
                for (int i = 0; i < min; i++) {
                    Map<String, Object> map = map1List.get(i);
                    map.putAll(map2List.get(i));
                    listlcsy.add(map);
                }
                data.put("zbList", listlcsy);
            }
            //医疗器械网络销售备案模板(修订版V2）
            data.put("ylqxwlxsbazb", CollectionUtils.defaultIfEmpty(zsDto.getSubMap().get("wlxsba"), new ArrayList<>()));
            //医疗器械产品出口销售证明
            data.put("zmpro", CollectionUtils.defaultIfEmpty(zsDto.getSubMap().get("qxxs"), new ArrayList<>()));
            //药品出口销售证明已在中国批准上市药品 三个子表个性化
            if (CollectionUtils.isNotEmpty(zsDto.getSubMap().get("ypxs"))) {
                CertSubTable cert = zsDto.getSubMap().get("ypxs").get(0);
                data.put("jkg", cert.getString("jkgjzw"));
                data.put("jkgyw", cert.getString("jkgjyw"));
            }
            if ("0cfb0d0d33a641f0aa0a9592a37c2cbe".equals(zsDto.getCerttypeid())) {
                data.put("ylzd2jx", zsDto.getYlzd2() + "    " + zsDto.getJx());
                data.put("ylzd3ylzd4", zsDto.getYlzd3() + "    " + zsDto.getYlzd4());
                data.put("ylzd7gg", zsDto.getYlzd7() + "    (" + zsDto.getGuige() + ")");
                data.put("ylzd8ylzd9", zsDto.getYlzd8() + "    (" + zsDto.getYlzd9() + ")");
                data.put("ylzd14ylzd16", zsDto.getYlzd14() + "    " + zsDto.getYlzd16());
                data.put("ylzd15ylzd17", zsDto.getYlzd15() + "    " + zsDto.getYlzd17());
            }
            if ("29d3e61e5561488ca2410ed653d0350a".equals(zsDto.getCerttypeid())) {
                data.put("cpjx", StringUtils.defaultIfBlank(zsDto.getCp(), zsDto.getChanping()) + "     " + zsDto.getJx());
                data.put("ylzd2ylzd3", zsDto.getYlzd2() + "    " + zsDto.getYlzd3());
                data.put("ylzd6gg", zsDto.getYlzd6() + "    (" + zsDto.getGuige() + ")");
                data.put("ylzd7ylzd8", zsDto.getYlzd7() + "    (" + zsDto.getYlzd8() + ")");
                data.put("ylzd13ylzd15", zsDto.getYlzd13() + "    " + zsDto.getYlzd15());
                data.put("ylzd14ylzd16", zsDto.getYlzd14() + "    " + zsDto.getYlzd16());
                data.put("ylzd25ylzd26", zsDto.getYlzd25() + "    " + zsDto.getYlzd26());
            }
            if ("59dd64be4a0e462d9b1e86ef58d6567b".equals(zsDto.getCerttypeid())) {
                data.put("cpjx", zsDto.getYlzd1() + "     " + zsDto.getJx());
                data.put("ylzd2ylzd3", zsDto.getYlzd2() + "    " + zsDto.getYlzd3());
                data.put("ylzd6gg", zsDto.getYlzd6() + "    (" + zsDto.getGuige() + ")");
                data.put("ylzd7ylzd8", zsDto.getYlzd7() + "    (" + zsDto.getYlzd8() + ")");
                data.put("ylzd17ylzd18", zsDto.getYlzd17() + "    " + zsDto.getYlzd18());
                data.put("ylzd20ylzd21", zsDto.getYlzd20() + "    " + zsDto.getYlzd21());
            }

          String qrUrl = YwUtil.getQrCodeValue(zsDto.getZsid(), serverUrl);
          ImageEntity imageEntity=new ImageEntity(YwUtil.generateQRCodeImageByteDoc(qrUrl,150,150),75,75);
//            imageEntity.setHeight(100);
//            imageEntity.setWidth(100);
////            imageEntity.setUrl("E:/opt/upFiles/ewm/test.png");
//
//            imageEntity.setData();
//            imageEntity.setType(ImageEntity.URL);
            data.put("img",imageEntity);
            XWPFDocument doc = WordExportUtil.exportWord07(templatepath, data);

            File file1 = new File(tempPath);
            if (!file1.exists()) {
                file1.mkdirs();
            }
            deleteFiles.add(file1 = new File(file1, FilenameUtils.getBaseName(outpath) + ".docx"));
            //用一个文件过渡
            tmpOut = new FileOutputStream(file1);
            doc.write(tmpOut);
            tmpOut.close();
            //插入二维码 用文件二过度
/*
            setQrcodeToWord("/opt/temp/test.docx","/opt/temp/test1.docx",null);
*/
            //内置转ofd
            if (OfdUtil.WordToOfd(file1.getAbsolutePath(), outpath))
                return 1;
            else {
                deleteFiles.add(new File(outpath));
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            deleteFiles.add(new File(outpath));
            return 0;
        } finally {
            IOTools.closeQuietly(tmpOut);
            for (File file : deleteFiles) FileUtils.deleteQuietly(file);
        }
    }


    public static void setQrcodeToWord(String templatePath, String targetPath, String qrurl) {
        // 模板文件路径
        /*String templatePath = "C:\\Users\\Epoint\\Desktop\\doc模板\\doc含子表模板\\药品出口准许证.docx";
        // 生成的文件路径
        String targetPath = "C:\\Users\\Epoint\\Desktop\\doc模板\\doc含子表模板\\target.docx";*/
        // 书签名
        String bookmarkName = "qrcode";
        // 图片路径
        String imagePath = "/opt/upFiles/ewm/test.png";

        // 载入模板文件
        WordprocessingMLPackage wPackage = null;
        try {
            wPackage = WordprocessingMLPackage.load(new FileInputStream(templatePath));
        } catch (Docx4JException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 提取正文
        MainDocumentPart mainDocumentPart = wPackage.getMainDocumentPart();
        Document wmlDoc = (Document) mainDocumentPart.getJaxbElement();
        Body body = wmlDoc.getBody();
        // 提取正文中所有段落
        List<Object> paragraphs = body.getContent();
        // 提取书签并创建书签的游标
        RangeFinder rt = new RangeFinder("CTBookmark", "CTMarkupRange");
        new TraversalUtil(paragraphs, rt);

        // 遍历书签
        for (CTBookmark bm:rt.getStarts()) {
            // 这儿可以对单个书签进行操作，也可以用一个map对所有的书签进行处理
            if (bm.getName().equals(bookmarkName)){
                InputStream is=null;
                try {
                if(StringUtils.isNotBlank(qrurl))
                {
                    URL url =  new URL(qrurl);

                    //打开连接
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    //设置请求方式为"GET"
                    conn.setRequestMethod("GET");
                    //超时响应时间为10秒
                    conn.setConnectTimeout(10 * 1000);

                    is=conn.getInputStream();

                }
                else {
                    // 读入图片并转化为字节数组，因为docx4j只能字节数组的方式插入图片
                    is = new FileInputStream(imagePath);
                }
                byte[] bytes = IOUtils.toByteArray(is);
                // 穿件一个行内图片
                BinaryPartAbstractImage imagePart = BinaryPartAbstractImage.createImagePart(wPackage, bytes);

                // createImageInline函数的前四个参数我都没有找到具体啥意思，，，，
                // 最有一个是限制图片的宽度，缩放的依据  id1 类似放大倍数
                Inline inline = imagePart.createImageInline(null, null, 0,1, false, 1300);
                // 获取该书签的父级段落
             /*   P p = (P)(bm.getParent());

                ObjectFactory factory = new ObjectFactory();
                // R对象是匿名的复杂类型，然而我并不知道具体啥意思，估计这个要好好去看看ooxml才知道
                R run = factory.createR();
                // drawing理解为画布？
                Drawing drawing = factory.createDrawing();
                drawing.getAnchorOrInline().add(inline);
                run.getContent().add(drawing);
                p.getContent().add(run);*/
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            wPackage.save(new FileOutputStream(targetPath));
        } catch (Docx4JException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * 生成附页
     * @param cardprint
     * @param
     * @return
     */
    public static String createFyXML(ZsDto cardprint,String vmPath) throws Exception {
        String strXML = null;
        try {
            VelocityEngine ve = new VelocityEngine();
            int idx = vmPath.lastIndexOf("/");
            String prefix = vmPath.substring(0, idx);
            String vmFile = vmPath.substring(idx+1);
            ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "file");
            ve.setProperty("file.resource.loader.path",prefix);
            ve.setProperty(Velocity.ENCODING_DEFAULT, "GBK");
            ve.setProperty(Velocity.INPUT_ENCODING, "GBK");
            ve.setProperty(Velocity.OUTPUT_ENCODING, "GBK");
            ve.init();
            Template t = ve.getTemplate(vmFile);
            VelocityContext ctx = new VelocityContext();
            ctx.put("cardprint", cardprint);
            StringWriter sw = new StringWriter();
            t.merge(ctx, sw);
            strXML = sw.toString();
        } catch (Exception e1) {
            e1.printStackTrace();
            throw new Exception("生成副页XML失败");
        }
        LOG.info("组装xml："+strXML);
        return strXML;
    }
    /**
     * 生成附页
     * @param cardprint
     * @param columns
     * @return
     */


    /**
     * 根据不同的证书类型填充数据
     *
     * @param items
     * @param cardtype
     * @param cardprint
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
 /*   private static void fillData(Element items, ZsDto cardprint,
            List<CertMetadata> columns) throws Exception {
        int i = 0;
        for (CertMetadata cardRecord : columns) {
            Object value = null;
            try{
                //if (cardRecord.getYssx().contains("modifyinfo")){
                //    value = JavaReflect.getter(cardprint,"Modifyinfo"+String.valueOf(i+1));
                //}else if(cardRecord.getYssx().contains("modifytime")){
                //    value = JavaReflect.getter(cardprint,"Modifytime"+String.valueOf(i+1));
                //}else{
                    value = PropertyUtils.getProperty(cardprint, cardRecord.getYssx());
                //}
                i+=1;
            }catch(Exception e){
                e.printStackTrace();
                throw new BusinessException("数据填充失败:{}",e);
            }
            if (value != null) {
                Integer zslx = cardprint.getZslx();
                String yssx = cardRecord.getYssx();
                if (value instanceof Date) {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime((Date) value);
                    Date fzrq = cardprint.getFzrq();
                    Date yxqq = cardprint.getYxqq();
                    Date yxqz = cardprint.getYxqz();
                    if(zslx.equals(51) || zslx.equals(52)){//药品进/出口准许证，发证日期用yyyy-MM-dd
                        if (null != fzrq) {
                            cardprint.setFzrq_y(DateUtils.parseDateToStr("yyyy-MM-dd",fzrq));
                            setField(items, "fzrq_Y", cardprint.getFzrq_y());
                        }
                        if (null != yxqq) {
                            cardprint.setYxqq_y(DateUtils.parseDateToStr("yyyy-MM-dd",yxqq));
                            setField(items, "yxqq_Y", cardprint.getYxqq_y());
                        }
                    }else {
                        String year = String.valueOf(cal.get(Calendar.YEAR));
                        setField(items, yssx.toLowerCase() + "_Y", year);
                        String month = cal.get(Calendar.MONTH)+1+"";
                        setField(items, yssx.toLowerCase() + "_M", month);
                        String day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
                        setField(items, yssx.toLowerCase() + "_D", day);
				    }
                } else {
                    String dataValue = value.toString();
                    setField(items, yssx.replaceAll("\\.", "_").toLowerCase(), dataValue);
                }
         }
       }
    }
   */
    /**
     * 放射性药品使用许可证截取号
     * @param cardid
     * @return
     */
    private static String[] getCardidByRegex(String cardid) {
        String[] cardidArr= {"",""};
        try {
            cardid = cardid.replace("（", "(");
            cardid = cardid.replace("）", ")");
            int idxl = cardid.indexOf("(");
            int idxr = cardid.indexOf(")");
            String cardid1 = cardid.substring(idxl + 1, idxr);
            cardidArr[0] = cardid1;
            idxl = cardid.lastIndexOf("第");
            idxr = cardid.lastIndexOf("号");
            String cardid2 = cardid.substring(idxl + 1, idxr);
            cardidArr[1] = cardid2;
        } catch (Exception e) {
            LOG.error("放射性药品使用许可证截取证号失败", e);
        }
        return cardidArr;
    }

    /**
     * 设置item的属性和值
     *
     * @param items
     * @param fieldName
     *            字段名称
     * @param fieldValue
     *            字段值
     */
    private static void setField(Element items, String fieldName, String fieldValue) {
        Element item = items.addElement("item");
        item.addAttribute("name", fieldName);
        item.addAttribute("type", "Tx");
        item.addText(fieldValue);
    }

    /**
     * OFD属性设置
     * @param items
     * @param fieldName
     * @param fieldValue
     */
    private static void setFieldForOFD(Element items, String fieldName, String fieldValue,int yushu) {
        /*Element item = items.addElement("DataInfo");
        item.addAttribute("Name", fieldName);
        item.addAttribute("Value", fieldValue);*/
         if(fieldName.contains("modifyinfo"))
         {
            String num= fieldName.substring(10);
            int nums=Integer.parseInt(num);
             int i=0;

                if(nums % yushu==0)
                {
                    i = yushu ;
                }
                else{ i = (nums % yushu) ;}

             fieldName="modifyinfo"+i;
         }
         if(fieldName.contains("modifytime"))
         {
             String[] modifytime = fieldName.split("_");
             String num= modifytime[0].substring(10);
             int nums=Integer.parseInt(num);
             int i=0;

             if(nums % yushu==0)
             {
                 i = yushu ;
             }
             else{ i = (nums % yushu) ;}

             fieldName="modifytime"+i+(1 < modifytime.length ? "_"+modifytime[1] : "");
         }
        Element item = items.addElement(fieldName);
        item.addText(null == fieldValue ? "" : fieldValue);
    }


    public static String createCardprintXMLForOFD(ZsDto cardprint, List<CertMetadata> columns, int yushu) {
        String strXML = null;
        // 产生xml头，并指定根为items
        org.dom4j.Document document = DocumentHelper.createDocument();
        //Element items = document.addElement("DataRoot");
        //items.addAttribute("xmlns:xsi","http://www.w3.org/2001/XMLSchema-instance");
        Element items = document.addElement("root");
        try {
            // 填充证书数据
            fillDataForOFD(items, cardprint, columns, yushu);
            // 将数据以字符串形式输出
            StringWriter strWtr = new StringWriter();
            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding("UTF-8");
            XMLWriter xmlWriter = new XMLWriter(strWtr, format);
            xmlWriter.write(document);
            strXML = strWtr.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException("组装xml失败:{}",e);
        }
        strXML=document.asXML();
        LOG.info("组装xml："+strXML);
        return strXML;
    }

    /**
     * OFD数据填充
     * @param items
     * @param cardprint
     * @param columns
     */
    private static void fillDataForOFD(Element items, ZsDto cardprint, List<CertMetadata> columns,int yushu) {
      /*  if (StringUtil.isNotEmpty(cardprint.getQrcode())){
            setFieldForOFD(items,"qrcode",cardprint.getQrcode());
        }*/
        if(StringUtils.isNotBlank(cardprint.getQrcode()))
        {
            setFieldForOFD(items, "qrcode", cardprint.getQrcode(),yushu);

        }
        if(StringUtils.isNotBlank(cardprint.getBgnr()))
        {
            setFieldForOFD(items, "zsbh", cardprint.getZsbh(),yushu);
            setFieldForOFD(items, "ylzd36", cardprint.getBgnr(),yushu);
            setFieldForOFD(items, "cp", cardprint.getCpmc(),yushu);
            setFieldForOFD(items, "bz", cardprint.getBz(),yushu);
            setFieldForOFD(items, "fzjg", cardprint.getFzjg(),yushu);
            Calendar cal = Calendar.getInstance();
            if(StringUtils.isNotBlank(cardprint.getFzrq())) {
                cal.setTime(DateUtils.parseDate(cardprint.getFzrq(), "yyyy-MM-dd"));
            }
            String year = String.valueOf(cal.get(Calendar.YEAR));
            setFieldForOFD(items, "fzrq" + "_Y", year,yushu);
            String month = cal.get(Calendar.MONTH)+1+"";
            setFieldForOFD(items, "fzrq" + "_M", month,yushu);
            String day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
            setFieldForOFD(items, "fzrq" + "_D", day,yushu);
        }
        if (CollectionUtils.isNotEmpty(cardprint.getModifyinfoList())) {
            boolean isFirst = true;
            for (Map<String, Object> map : cardprint.getModifyinfoList()) {
                if (!isFirst) setFieldForOFD(items, "qrcode", cardprint.getQrcode(), yushu);
                isFirst = false;
                setFieldForOFD(items, "zsbh", cardprint.getZsbh(), yushu);
                setFieldForOFD(items, "ylzd36", MapUtils.getString(map, "modifyinfo"), yushu);
                setFieldForOFD(items, "cp", cardprint.getChanping(), yushu);
                setFieldForOFD(items, "bz", MapUtils.getString(map, "bz"), yushu);
                setFieldForOFD(items, "fzjg", cardprint.getFzjg(), yushu);
                Date modifyTime = (Date) MapUtils.getObject(map, "modifytime");
                if (null != modifyTime) {
                    setFieldForOFD(items, "fzrq" + "_Y", DateFormatUtils.format(modifyTime, "yyyy"), yushu);
                    setFieldForOFD(items, "fzrq" + "_M", DateFormatUtils.format(modifyTime, "M"), yushu);
                    setFieldForOFD(items, "fzrq" + "_D", DateFormatUtils.format(modifyTime, "d"), yushu);
                }
            }
        }
        for (CertMetadata cardRecord : columns) {
            String lbs = StringUtils.trimToEmpty(cardRecord.getLbs()),
                yssx = StringUtils.trimToEmpty(cardRecord.getYssx());
            Object value;
            boolean useLbs = false;
            try {
                if (StringUtils.isNotBlank(lbs) && !StringUtils.equalsIgnoreCase(lbs, yssx)) {
                    value = PropertyUtils.getProperty(cardprint, lbs);
                    useLbs = true;
                } else if ("cp".equalsIgnoreCase(yssx)) {
                    value = PropertyUtils.getProperty(cardprint, "chanping");
                } else if ("gg".equalsIgnoreCase(yssx)) {
                    value = PropertyUtils.getProperty(cardprint, "guige");
                } else if ("cs".equalsIgnoreCase(yssx)) {
                    value = PropertyUtils.getProperty(cardprint, "chaosong");
                } else {
                    value = PropertyUtils.getProperty(cardprint, yssx.toLowerCase());
                }
                if (StringUtils.startsWithIgnoreCase(yssx, "photo")) {
                    String uploadPath = PmsUtil.getUploadPath();
                    for (String str : StringUtils.trimToEmpty(null != value ? value + "" : "").split("[,]+")) {
                        File file = new File(uploadPath, str);
                        if (StringUtils.endsWithAny(str.toLowerCase(), ".jpg", ".jpeg", ".png", ".gif", ".bmp")
                            && file.exists() && file.isFile()) {
                            byte[] bytes = ImgToPdfUtil.scaleToBytes(file.getAbsolutePath(), 2000, 2000);
                            if (null == bytes) bytes = FileUtils.readFileToByteArray(file);
                            value = Base64.encodeBase64String(bytes);
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new BusinessException("数据填充失败:{}", e);
            }
            if (null == value) continue;
            Integer zslx = cardprint.getZslx();
            if (value instanceof Date || "yxqz".equalsIgnoreCase(lbs) || "yxqq".equalsIgnoreCase(lbs) || "fzrq".equalsIgnoreCase(lbs)) {
                Date date = DateUtils.parseDate(value);
                if (!useLbs) yssx = yssx.toLowerCase();
                setFieldForOFD(items, yssx, DateFormatUtils.format(date, "yyyy-MM-dd"), yushu);
                setFieldForOFD(items, yssx + "_Y", DateFormatUtils.format(date, "yyyy"), yushu);
                setFieldForOFD(items, yssx + "_M", DateFormatUtils.format(date, "M"), yushu);
                setFieldForOFD(items, yssx + "_D", DateFormatUtils.format(date, "d"), yushu);
            } else {
                yssx = yssx.replace(".", "_");
                if (!useLbs) yssx = yssx.toLowerCase();
                String dataValue = value.toString();
                setFieldForOFD(items, yssx, dataValue, yushu);
                if ("ylzd14".equals(yssx) && StringUtils.isNotBlank(dataValue)) {
                    try {
                        Date date = DateUtils.parseDate(dataValue);
                        setFieldForOFD(items, yssx + "_Y", DateFormatUtils.format(date, "yyyy"), yushu);
                        setFieldForOFD(items, yssx + "_M", DateFormatUtils.format(date, "M"), yushu);
                        setFieldForOFD(items, yssx + "_D", DateFormatUtils.format(date, "d"), yushu);
                    } catch (Exception ignore) {}
                }
            }
        }
    }

    public static void OutputXml(Document doc,String filename){
        OutputFormat format = OutputFormat.createPrettyPrint();
        /** 指定XML编码 */
        format.setEncoding("GBK");
        /** 将document中的内容写入文件中 */
        XMLWriter writer;
        try {
            writer = new XMLWriter(new FileWriter(new File(filename)), format);
            writer.write(doc);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private static class CustomXWPFDocumentOutputStream extends Writer {
        public CustomXWPFDocumentOutputStream(OutputStream outputStream) {
        }

        @Override
        public void write(@NotNull char[] cbuf, int off, int len) throws IOException {

        }

        @Override
        public void flush() throws IOException {

        }

        @Override
        public void close() throws IOException {

        }
    }
}
