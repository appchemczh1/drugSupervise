package org.jeecg.modules.demo.dzzz.util;

import com.KGitextpdf.text.DocumentException;
import com.KGitextpdf.text.Image;
import com.KGitextpdf.text.Rectangle;
import com.KGitextpdf.text.pdf.PdfWriter;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.kinggrid.kgcore.enmu.KGServerTypeEnum;
import com.kinggrid.pdf.KGPdfHummer;
import com.kinggrid.pdf.KGPdfHummerUtils;
import com.kinggrid.pdf.executes.PdfElectronicSeal4KG;
import com.kinggrid.qr.KGQRCode;

import com.suwell.ofd.custom.wrapper.model.Group;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.jeecg.modules.demo.dzzz.sczz.ContrastKeySn;
import org.jeecg.modules.demo.dzzz.sczz.ZsDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Decoder;


import javax.imageio.ImageIO;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.awt.image.BufferedImage;
import java.io.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.*;

@Component
public class SignatureUtil {
    
    private static final Logger logger = LoggerFactory.getLogger(SignatureUtil.class);
    

    
    /*@Autowired
    private ZsCzjlMapper czjlMapper;
    数据库查询对应的数据
    @Autowired
    private KeySnMapper keySnMapper;*/
    


    private  static String OfdSignatureUrl="http://192.168.0.222:8090/iSignatureStamp";
    private  static String salt="2b44acb1f9f24a15b296784065667ddd";
    private  static String appid="0E9C2564B078457F8461E44316E071FD";
    private  static String Profile="D:/opt/file/image";
    private  static String dzzzsignatureName="湖北省药品监督管理局";
    private  static String dzzzkeysn="42010600015206";

    public static JSONObject createSignInfo(String x, String y, String offsetX, String offsetY, String text, String page, String sealCode, String sealName) {
        JSONObject json = new JSONObject();
        if (StringUtils.isBlank(sealCode) || StringUtils.isBlank(sealName)) {
            json.put("sealCode", dzzzkeysn); // 印章唯一赋码
            json.put("sealName", dzzzsignatureName); // 印章唯一赋码
        } else {
            json.put("sealCode", sealCode); // 印章唯一赋码
            json.put("sealName", sealName); // 印章唯一赋码
        }
        json.put("page", page); // 所有页
        String positionType = "";
        if (StringUtils.isNotEmpty(text)) {
            positionType = "2";
        } else if (StringUtils.isNotEmpty(x) && StringUtils.isNotEmpty(y)) {
            positionType = "1";
        }
        json.put("positionType", "3"); // 定位类型，1-坐标定位；2-文本定位 3-OFD坐标定位左下
        // 坐标定位盖章
        if ("1".equals(positionType)) {//横坐标
            //x = String.valueOf(Integer.valueOf(x)/3);
            //y = String.valueOf(Integer.valueOf(y)/3);
            json.put("x", x);
            json.put("y", y);
        } else if ("2".equals(positionType)) {
           /* json.put("x", "0");
            json.put("y", "0");*/

            json.put("text", text);
            json.put("positionType", positionType);
            if ("签字".equals(text)) {
                json.put("textOffsetX", "400");
            }
        }
        if (StringUtils.isNotEmpty(offsetX)) {//偏移量
            //offsetX = String.valueOf(Integer.valueOf(offsetX)/3);
            json.put("textOffsetX", offsetX);
        }
        if (StringUtils.isNotEmpty(offsetY)) {//偏移量
            //offsetY = String.valueOf(Integer.valueOf(offsetY)/3);
            json.put("textOffsetY", offsetY);
        }
        //json.put("xyUnit","0");
        return json;
    }

    public static String addSignOfd(String fromPath, String toPath, String x, String y, String offsetX, String offsetY, String text, String page,
                                    String sealCode, String sealName) throws Exception {
        return addSignOfd(fromPath, toPath, createSignInfo(x, y, offsetX, offsetY, text, page, sealCode, sealName));
    }

    public static String addSignOfd(String fromPath, String toPath, JSONObject json) throws Exception {
        String res = "";
        String url = OfdSignatureUrl + "/api/stampSeal";
        //对应签章服务器应用管理里的授权码
        //业务系统生成的业务号，同一业务系统号下，所有业务号的编号必选唯一
        String orderId = "Test202001010001";
        //文档标题，方便以后查询使用
        String title = "Test File";
        JSONArray array = new JSONArray();
        array.add(json);
        String signList = array.toJSONString();
        String randomN = getRandom(OfdSignatureUrl);
        String code = Encrypt.encodeSHA256((randomN + salt).getBytes("UTF-8"));
        String code64 = Base64.createBase64().encode(code.getBytes("UTF-8"));
        
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
            File file = new File(fromPath);
            multipartEntityBuilder.addBinaryBody("file", file, ContentType.DEFAULT_BINARY, "123.ofd");
            multipartEntityBuilder.addTextBody("appid", appid);
            multipartEntityBuilder.addTextBody("orderId", orderId);
            multipartEntityBuilder.addTextBody("title",title,ContentType.MULTIPART_FORM_DATA);
            multipartEntityBuilder.addTextBody("fileType", "OFD");
            multipartEntityBuilder.addTextBody("checkCode", code64);
            multipartEntityBuilder.addTextBody("randomN", randomN);
            ContentType contentType = ContentType.create(HTTP.PLAIN_TEXT_TYPE, HTTP.UTF_8);
            StringBody stringBody = new StringBody(signList, contentType);
            multipartEntityBuilder.addPart("signList", stringBody);
            //multipartEntityBuilder.addTextBody("signList", signList ,ContentType.MULTIPART_FORM_DATA);
            httpPost.setEntity(multipartEntityBuilder.build());
    
            //越过ssl
            SSLContext sslContext = getSSLContext();
            Registry<ConnectionSocketFactory> socketFactoryRegistry =
                    RegistryBuilder.<ConnectionSocketFactory>create()
                            .register("http", PlainConnectionSocketFactory.INSTANCE)
                            .register("https", new SSLConnectionSocketFactory(sslContext)).build();
            PoolingHttpClientConnectionManager mananger = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
            mananger.setMaxTotal(100);
            mananger.setDefaultMaxPerRoute(20);
            //end
            // 执行http请求
            long start = System.currentTimeMillis();
            response = httpClient.execute(httpPost);
            logger.error("盖章时间:{}",(System.currentTimeMillis() - start));
            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode == HttpStatus.SC_OK){
                res = "签名成功";
                System.out.println("签名成功");
                InputStream in = response.getEntity().getContent();
                FileOutputStream fileOutputStream = new FileOutputStream(toPath);
                copy(in,fileOutputStream);
                in.close();
                fileOutputStream.close();

            }
            else if(statusCode == 700) {
                res = "签名失败";
                System.out.println("签名失败");
                InputStream in = response.getEntity().getContent();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                copy(in,byteArrayOutputStream);
                System.out.println(new String(byteArrayOutputStream.toByteArray(),"UTF-8"));
                throw new Exception("签名失败"+new String(byteArrayOutputStream.toByteArray(),"UTF-8"));
            } else {
                throw new Exception("系统异常，statusCode = " + statusCode);
            }




        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        } finally {
            try {
                if(response != null){
                  /*  response.close();*/
                }
              /*  FileUtils.deleteFile(fromPath);*/
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.toString());
            }
        }
        return res;
    }

    public static String addSignPDF(String fromPath,String toPath,String x,String y,String offsetX, String offsetY,String text,String page,String sealCode,String sealName) throws Exception{
        String res = "";
        String url = OfdSignatureUrl + "/api/stampSeal";
        //对应签章服务器应用管理里的授权码
        //业务系统生成的业务号，同一业务系统号下，所有业务号的编号必选唯一
        String orderId = "Test202001010001";
        //文档标题，方便以后查询使用
        String title = "Test File";
        JSONObject json = new JSONObject();
        if(StringUtils.isBlank(sealCode)||StringUtils.isBlank(sealName)) {
            json.put("sealCode", dzzzkeysn); // 印章唯一赋码
            json.put("sealName", dzzzsignatureName); // 印章唯一赋码
        }
        else {
            json.put("sealCode", sealCode); // 印章唯一赋码
            json.put("sealName", sealName); // 印章唯一赋码
        }
        json.put("page",page); // 所有页
        String positionType = "";
        if (StringUtils.isNotEmpty(text)){
            positionType = "2";
        }
        else if (StringUtils.isNotEmpty(x) && StringUtils.isNotEmpty(y)){
            positionType = "1";
        }
        json.put("positionType", "1"); // 定位类型，1-坐标定位；2-文本定位 3-OFD坐标定位左下
        // 坐标定位盖章
        if ("1".equals(positionType)){//横坐标
            //x = String.valueOf(Integer.valueOf(x)/3);
            //y = String.valueOf(Integer.valueOf(y)/3);
            json.put("x", x);
            json.put("y", y);
        }else if ("2".equals(positionType)){
           /* json.put("x", "0");
            json.put("y", "0");*/
            json.put("text", text);
            json.put("positionType", positionType);
        }
        if (StringUtils.isNotEmpty(offsetX)) {//偏移量
            //offsetX = String.valueOf(Integer.valueOf(offsetX)/3);
            json.put("textOffsetX", offsetX);
        }
        if (StringUtils.isNotEmpty(offsetY)) {//偏移量
            //offsetY = String.valueOf(Integer.valueOf(offsetY)/3);
            json.put("textOffsetY", offsetY);
        }
        //json.put("xyUnit","0");
        JSONArray array = new JSONArray();
        array.add(json);
        String signList = array.toJSONString();
        String randomN = getRandom(OfdSignatureUrl);
        String code = Encrypt.encodeSHA256((randomN + salt).getBytes("UTF-8"));
        String code64 = Base64.createBase64().encode(code.getBytes("UTF-8"));

        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
            File file = new File(fromPath);
            multipartEntityBuilder.addBinaryBody("file", file, ContentType.DEFAULT_BINARY, "123.pdf");
            multipartEntityBuilder.addTextBody("appid", appid);
            multipartEntityBuilder.addTextBody("orderId", orderId);
            multipartEntityBuilder.addTextBody("title",title,ContentType.MULTIPART_FORM_DATA);
            multipartEntityBuilder.addTextBody("fileType", "PDF");
            multipartEntityBuilder.addTextBody("checkCode", code64);
            multipartEntityBuilder.addTextBody("randomN", randomN);
            ContentType contentType = ContentType.create(HTTP.PLAIN_TEXT_TYPE, HTTP.UTF_8);
            StringBody stringBody = new StringBody(signList, contentType);
            multipartEntityBuilder.addPart("signList", stringBody);
            //multipartEntityBuilder.addTextBody("signList", signList ,ContentType.MULTIPART_FORM_DATA);
            httpPost.setEntity(multipartEntityBuilder.build());

            //越过ssl
            SSLContext sslContext = getSSLContext();
            Registry<ConnectionSocketFactory> socketFactoryRegistry =
                    RegistryBuilder.<ConnectionSocketFactory>create()
                            .register("http", PlainConnectionSocketFactory.INSTANCE)
                            .register("https", new SSLConnectionSocketFactory(sslContext)).build();
            PoolingHttpClientConnectionManager mananger = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
            mananger.setMaxTotal(100);
            mananger.setDefaultMaxPerRoute(20);
            //end
            // 执行http请求
            long start = System.currentTimeMillis();
            response = httpClient.execute(httpPost);
            logger.error("盖章时间:{}",(System.currentTimeMillis() - start));
            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode == HttpStatus.SC_OK){
                res = "签名成功";
                System.out.println("签名成功");
                InputStream in = response.getEntity().getContent();
                FileOutputStream fileOutputStream = new FileOutputStream(toPath);
                copy(in,fileOutputStream);
                in.close();
                fileOutputStream.close();

            }
            else if(statusCode == 700) {
                res = "签名失败";
                System.out.println("签名失败");
                InputStream in = response.getEntity().getContent();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                copy(in,byteArrayOutputStream);
                System.out.println(new String(byteArrayOutputStream.toByteArray(),"UTF-8"));
                throw new Exception("签名失败"+new String(byteArrayOutputStream.toByteArray(),"UTF-8"));
            } else {
                throw new Exception("系统异常，statusCode = " + statusCode);
            }




        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        } finally {
            try {
                if(response != null){
                    /*  response.close();*/
                }
                /*  FileUtils.deleteFile(fromPath);*/
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.toString());
            }
        }
        return res;
    }

    /**
     * @param fromPath
     * @param toPath
     * @param xys
     * @return 在同一文件上根据多个坐标位置盖章
     * @throws Exception
     */
    public static String addSignOfdArray(String fromPath,String toPath,JSONArray xys) throws Exception {
        String res = "";
        String url = OfdSignatureUrl + "/api/stampSeal";
        //对应签章服务器应用管理里的授权码
        //业务系统生成的业务号，同一业务系统号下，所有业务号的编号必选唯一
        String orderId = "Test202001010001";
        //文档标题，方便以后查询使用
        String title = "Test File";
        JSONArray array = new JSONArray();
        for (int i = 0; i < xys.size(); i++) {
            JSONObject json = (JSONObject) xys.get(i);
            json.put("page", "0"); // 所有页
            json.put("positionType", "3"); // 定位类型，1-坐标定位；2-文本定位 3-OFD坐标定位左下
            array.add(json);
        }
        String signList = array.toJSONString();
        String randomN = getRandom(OfdSignatureUrl);
        String code = Encrypt.encodeSHA256((randomN + salt).getBytes("UTF-8"));
        String code64 = Base64.createBase64().encode(code.getBytes("UTF-8"));
    
        //越过ssl
        SSLContext sslContext = getSSLContext();
        Registry<ConnectionSocketFactory> socketFactoryRegistry =
                RegistryBuilder.<ConnectionSocketFactory>create()
                        .register("http", PlainConnectionSocketFactory.INSTANCE)
                        .register("https", new SSLConnectionSocketFactory(sslContext)).build();
        PoolingHttpClientConnectionManager mananger = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        mananger.setMaxTotal(100);
        mananger.setDefaultMaxPerRoute(20);
        //end
        
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
            File file = new File(fromPath);
            multipartEntityBuilder.addBinaryBody("file", file, ContentType.DEFAULT_BINARY, "123.ofd");
            multipartEntityBuilder.addTextBody("appid", appid);
            multipartEntityBuilder.addTextBody("orderId", orderId);
            multipartEntityBuilder.addTextBody("title",title,ContentType.MULTIPART_FORM_DATA);
            multipartEntityBuilder.addTextBody("fileType", "OFD");
            multipartEntityBuilder.addTextBody("checkCode", code64);
            multipartEntityBuilder.addTextBody("randomN", randomN);
            ContentType contentType = ContentType.create(HTTP.PLAIN_TEXT_TYPE, HTTP.UTF_8);
            StringBody stringBody = new StringBody(signList, contentType);
            multipartEntityBuilder.addPart("signList", stringBody);
            //multipartEntityBuilder.addTextBody("signList", signList ,ContentType.MULTIPART_FORM_DATA);
            httpPost.setEntity(multipartEntityBuilder.build());
            
            // 执行http请求
            long start = System.currentTimeMillis();
            response = httpClient.execute(httpPost);
            logger.error("盖章时间(array):{}",(System.currentTimeMillis() - start));
            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode == HttpStatus.SC_OK){
                res = "签名成功";
                System.out.println("签名成功");
                InputStream in = response.getEntity().getContent();
                FileOutputStream fileOutputStream = new FileOutputStream(toPath);
                copy(in,fileOutputStream);
                in.close();
                fileOutputStream.close();
            } else if(statusCode == 700) {
                res = "签名失败";
                System.out.println("签名失败");
                InputStream in = response.getEntity().getContent();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                copy(in,byteArrayOutputStream);
                System.out.println(new String(byteArrayOutputStream.toByteArray(),"UTF-8"));
                throw new Exception("签名失败"+new String(byteArrayOutputStream.toByteArray(),"UTF-8"));
            } else {
                throw new Exception("系统异常，statusCode = " + statusCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        } finally {
            try {
                if(response != null){
                    response.close();
                }
                
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println(e.toString());
            }
        }
        return res;
    }
    
    public static String addSignOfd1(String ofdPath, String qrcodeContent, String position, String signatureName,
                                     String serialNum, ZsDto gyEntcardprint, Map fjmap) throws Exception {
        FileOutputStream fos = null;
        String savePath = null;
        String fileName = null;
        String fjpath = "";
        String tempPath = "";
        String oldPath = "";
        List<String> imgPdfs = new ArrayList<>();
        boolean vm = false;
        try {
            savePath = ofdPath.replace("_temp", "");
            if (ofdPath.contains("fy_temp")) {
                vm = true;
            }
            int fsidx = savePath.lastIndexOf("/");
            int feidx = savePath.lastIndexOf(".");
            fileName = savePath.substring(fsidx + 1, feidx);
            Integer zslx = Integer.valueOf(gyEntcardprint.getZslx());
            if (null != fjmap && fjmap.size() > 0 && (zslx.equals(68) || zslx.equals(69) || zslx.equals(3) || zslx.equals(26))) {
                //插入附件
                fjpath = ofdPath.replace("_temp", "_temp1");
                tempPath = ofdPath.replace("_temp", "_temp2");
                FileOutputStream fos1 = new FileOutputStream(fjpath);
                Set<String> keySet = fjmap.keySet();
                Iterator<String> it = keySet.iterator();
                int i = 1;
                List<Group> groupList = new ArrayList();
                String serverUrl = Signature.getServerUrl();
                List<String> fjPathList = new ArrayList<>();
                while (it.hasNext()) {
                    //得到每一个key
                    String name = it.next();
                    if (name.matches("keySn|keyName")){
                        continue;
                    }
                    //通过key获取对应的value
                    String url = (String) fjmap.get(name);
                    String[] arr = name.split(".");
                    //文件后缀
                    String suffix = arr[arr.length-1];
                    System.out.println(name + "=" + url);
                    if (suffix.matches("jpg|png|gif|JPG|PNG|GIF") && zslx != 3 && zslx != 26){
                        String keySn = (String) fjmap.get("keySn");
                        String keyName = (String) fjmap.get("keyName");
                        String tempPdf = OfdUtil.ofd2Pfd(ofdPath, false);
                        url=signImage(tempPdf,url,serverUrl,keySn,keyName);
                        //删除临时创建hunmer的文件
                        FileUtils.deleteQuietly(new File(tempPdf));
                        suffix = "pdf";
                        //将图片转换盖章的PDF放到待删除列表,集成到OFD文件后删除掉,避免多余空间占用
                        imgPdfs.add(url);
                    }else if ((zslx == 3 || zslx == 26) && suffix.matches("PDF|pdf")){
                        String keySn = (String) fjmap.get("keySn");
                        String keyName = (String) fjmap.get("keyName");
                        //String pdfName = url.substring(0, url.lastIndexOf("."));
                        //String temp ="_" + System.currentTimeMillis() + "";
                        //String pdfPath = pdfName + temp + ".pdf";
                        //String pdfPath = ofdPath.replace("_temp","_attach").replace(".ofd",".pdf");
                        String pdfPath = ofdPath.substring(0, ofdPath.lastIndexOf(".")).replace("_temp","_attach") + i + ".pdf";
                        FjPdfSign(url,pdfPath,serverUrl,keySn,keyName);
                        //imgPdfs.add(url);
                        int s1 = pdfPath.lastIndexOf("/");
                        pdfPath = "dy/" + DateUtils.parseDateToStr("yyyyMMdd", new Date()) + "/" + pdfPath.substring(s1 + 1, pdfPath.length());
                        fjPathList.add(pdfPath);
                    }
                    if (zslx != 3 && zslx != 26){
                        FileInputStream inputStream = new FileInputStream(url);
                        groupList.add(new Group<>(i+"",suffix,inputStream));
                    }
                    i++;
                }
                //二类医疗器械注册 附件
                gyEntcardprint.setFjPath(fjPathList);
                if (!groupList.isEmpty()){
                    //转成数组兼容obj...
                    Group[] groups = groupList.toArray(new Group[groupList.size()]);
                    OfdUtil.ha.addAttachment(new File(ofdPath),fos1,groups);
                    //path换为已经插入了文件的path 再去盖章
                    oldPath = ofdPath;
                    ofdPath = fjpath;
                }
            }
            String positions[] = position.split("_");
            if (positions.length > 0) {
                for (int i = 0; i < positions.length; i++) {
                    String[] xy = positions[i].split(",");
                    String text = null;
                    String x = null;
                    String y = null;
                    String offsetX = null;
                    String offsetY = null;
                    String page = "0";
                    if (zslx.equals(46)) {
                        text = "备案部门";
                        offsetX = "35";
                        offsetY = "0";
                    } else if (zslx.equals(47)) {
                        text = "备案部门";
                        offsetX = "35";
                        offsetY = "0";
                    } else if (zslx.equals(48)) {
                        text = "备案部门";
                        offsetX = "35";
                        offsetY = "0";
                    } else if (zslx.equals(49)) {
                        text = "备案部门";
                        offsetX = "35";
                        offsetY = "0";
                    } else if (zslx.equals(45)) {
                        text = "发证部门";
                        offsetX = "55";
                        offsetY = "0";
                    } else if (zslx.equals(31)) {
                        text = "备案部门";
                        offsetX = "35";
                        offsetY = "0";
                    } else if (zslx.equals(59)) {
                        page = "2";
                        x = xy[0];
                        y = xy[1]; // 设置印章加盖坐标XY
                    } else if (zslx.equals(62)) {
                        page = "2";
                        x = xy[0];
                        y = xy[1]; // 设置印章加盖坐标XY
                    } else if (zslx.equals(63)) {
                        text = "备案部门";
                        offsetX = "35";
                        offsetY = "0";
                    } else if (zslx.equals(52)) {
                        text = "负责人签字";
                        offsetX = "8";
                        offsetY = "-20";
                    } else if (zslx.equals(65) || zslx.equals(70) || zslx.equals(71)) {
                        //text = "签  字";
                        text = "签章与日期";
                        offsetX = "45";
                        offsetY = "-10";
                    } else if (zslx.equals(66)) {
                        text = "签发部门盖章与日期";
                        offsetX = "0";
                        offsetY = "0";
                    }else if (zslx.equals(73)) {
                        x = xy[0];
                        y = xy[1]; // 设置印章加盖坐标XY
                    } else {
                        x = xy[0];
                        y = xy[1]; // 设置印章加盖坐标XY
                    }
                    addSignOfd(ofdPath,savePath,x,y,offsetX,offsetY,text,page,serialNum,signatureName);
                }
            }
            if (vm && zslx.equals(8)) {//医疗器械生产产品登记表(医疗器械副页)是vm格式。盖章位置是发证机关
                addSignOfd(savePath,savePath,null,null,"40","0","发证部门（公章）","0",serialNum,signatureName);
            }
        } catch (Exception e) {
            e.printStackTrace();
            FileUtils.deleteQuietly(new File(savePath));
            throw new Exception("OFD盖章失败,证书编号为"+gyEntcardprint.getZsbh()+",证书ID为"+gyEntcardprint.getId(), e);
        } finally {
            File sourceFile = new File(ofdPath);
            sourceFile.delete();
            File sourceFile1 = new File(fjpath);
            sourceFile1.delete();
            if (StringUtils.isNotEmpty(oldPath)){
                File file = new File(oldPath);
                file.delete();
            }
            if (!imgPdfs.isEmpty()){
                imgPdfs.forEach(pdf -> {
                    FileUtils.deleteFile(pdf);
                });
            }
            if (gyEntcardprint.getZslx().equals(52)) {
                String delpath = ofdPath.replace("_temp", "_temp1");
                File sourceFile2 = new File(delpath);
                sourceFile2.delete();
            }
        }
        return fileName;
    }
    
    public static String addSignPdf(String pdfPath, String qrcodeContent, String position, String signatureName,
                                    String serialNum, ZsDto gyEntcardprint, Map fjmap) throws Exception {
        FileOutputStream fos = null;
        KGPdfHummer hummer = null;
        String savePath = null;
        String fileName = null;
        String fjpath = "";
        boolean vm = false;
        String signatureServerUrl = Signature.getServerUrl();// 签章服务器的地址
        try {
            savePath = pdfPath.replace("_temp", "");
            if (pdfPath.contains("fy_temp")) {
                vm = true;
            }
            int fsidx = savePath.lastIndexOf("/");
            int feidx = savePath.lastIndexOf(".");
            fileName = savePath.substring(fsidx + 1, feidx);
            fos = new FileOutputStream(savePath);
            Integer zslx = Integer.valueOf(gyEntcardprint.getZslx());
            if (null != fjmap && fjmap.size() > 0 && (zslx.equals(68) || zslx.equals(69))) {
                fjpath = pdfPath.replace("_temp", "_temp1");
                FileOutputStream fos1 = new FileOutputStream(new File(fjpath));
                KGPdfHummer hummer1 = KGPdfHummer.createInstance(pdfPath, null, true, fos1, true);
                KGPdfHummerUtils kgUtils = hummer1.getKGPdfHummerUtils();
                Set<String> keySet = fjmap.keySet();
                Iterator<String> it = keySet.iterator();
                int i = 1;
                while (it.hasNext()) {
                    //得到每一个key
                    String name = it.next();
                    //通过key获取对应的value
                    String url = (String) fjmap.get(name);
                    String[] aa = name.split(".");
                    System.out.println(name + "=" + url);
                    //url = signImage(kgUtils,url,signatureServerUrl,serialNum,signatureName);
                    FileInputStream inputStream = new FileInputStream(url);
                    kgUtils.addFileAttachment(inputStream, i + "." + aa[aa.length - 1], name);
                }
                
                hummer1.doExecute();
                hummer1.close();
                
                hummer = KGPdfHummer.createInstance(fjpath, null, true, fos, false);
            } else {
                hummer = KGPdfHummer.createInstance(pdfPath, null, true, fos, false);
            }
            String positions[] = position.split("_");
            if (positions.length > 0) {
                for (int i = 0; i < positions.length; i++) {
                    String[] xy = positions[i].split(",");
                    PdfElectronicSeal4KG pdfElectronicSeal4KG = new PdfElectronicSeal4KG(signatureServerUrl,
                            KGServerTypeEnum.AUTO, serialNum, "123456", signatureName);
                    if (zslx.equals(46)) {
                        pdfElectronicSeal4KG.setText("备案部门");
                        pdfElectronicSeal4KG.setTextOffset(95, 0);
                    } else if (zslx.equals(47)) {
                        pdfElectronicSeal4KG.setText("备案部门");
                        pdfElectronicSeal4KG.setTextOffset(95, 0);
                    } else if (zslx.equals(48)) {
                        pdfElectronicSeal4KG.setText("备案部门");
                        pdfElectronicSeal4KG.setTextOffset(95, 0);
                    } else if (zslx.equals(49)) {
                        pdfElectronicSeal4KG.setText("备案部门");
                        pdfElectronicSeal4KG.setTextOffset(95, 0);
                    } else if (zslx.equals(45)) {
                        pdfElectronicSeal4KG.setText("发证部门");
                        pdfElectronicSeal4KG.setTextOffset(135, 0);
                    } else if (zslx.equals(31)) {
                        pdfElectronicSeal4KG.setText("备案部门");
                        pdfElectronicSeal4KG.setTextOffset(95, 0);
                    } else if (zslx.equals(59)) {
                        pdfElectronicSeal4KG.setPagen(2);
                        pdfElectronicSeal4KG.setXY(Integer.parseInt(xy[0]), Integer.parseInt(xy[1])); // 设置印章加盖坐标XY
                    } else if (zslx.equals(62)) {
                        pdfElectronicSeal4KG.setPagen(2);
                        pdfElectronicSeal4KG.setXY(Integer.parseInt(xy[0]), Integer.parseInt(xy[1])); // 设置印章加盖坐标XY
                    } else if (zslx.equals(63)) {
                        pdfElectronicSeal4KG.setText("备案部门");
                        pdfElectronicSeal4KG.setTextOffset(95, 0);
                    } else if (zslx.equals(52)) {
                        pdfElectronicSeal4KG.setText("负责人签字");
                        pdfElectronicSeal4KG.setTextOffset(20, 55);
                    } else if (zslx.equals(65) || zslx.equals(70) || zslx.equals(71)) {
                        pdfElectronicSeal4KG.setText("签  字");
                        pdfElectronicSeal4KG.setTextOffset(95, 0);
                    } else if (zslx.equals(66)) {
                        pdfElectronicSeal4KG.setText("签发部门盖章与日期");
                        pdfElectronicSeal4KG.setTextOffset(0, 0);
                    }else if (zslx.equals(73)) {
                        /*KGPdfHummerUtils hummerUtils = hummer.getKGPdfHummerUtils();
                        List<Rectangle> rectangleList = hummerUtils.getPositionByText(1, "湖北省药品监督管理局", true);
                        if (rectangleList.size() > 0) {
                            pdfElectronicSeal4KG.setText("湖北省药品监督管理局");
                            pdfElectronicSeal4KG.setTextOffset(0, 0);
                        }else{*/
                            pdfElectronicSeal4KG.setXY(Integer.parseInt(xy[0]),Integer.parseInt(xy[1])); // 设置印章加盖坐标XY
                        /*}*/
                    } else {
                        pdfElectronicSeal4KG.setXY(Integer.parseInt(xy[0]), Integer.parseInt(xy[1])); // 设置印章加盖坐标XY
                    }
                    hummer.addExecute(pdfElectronicSeal4KG);
                }
            }
            if (vm && zslx.equals(8)) {//医疗器械生产产品登记表(医疗器械副页)是vm格式。盖章位置是发证机关
                PdfElectronicSeal4KG pdfElectronicSeal4KG = new PdfElectronicSeal4KG(signatureServerUrl,
                        KGServerTypeEnum.AUTO, serialNum, "123456", signatureName);
                pdfElectronicSeal4KG.setText("发证部门（公章）");
                pdfElectronicSeal4KG.setTextOffset(115, 0);
                hummer.addExecute(pdfElectronicSeal4KG);
            }
            // 加上二维码
            PdfElectronicSeal4KG pdfElectronicSeal4KG2 = new PdfElectronicSeal4KG(signatureServerUrl,
                    KGServerTypeEnum.AUTO, serialNum, "123456", signatureName);
            KGPdfHummerUtils hummerUtils = hummer.getKGPdfHummerUtils();
            List<Rectangle> rectangleList = hummerUtils.getPositionByText(1, "qrcode", true);
            if (rectangleList.size() > 0) {// 判断是否有qrcode的文字
                if (vm && zslx.equals(8)) {//医疗器械生产产品登记表(医疗器械副页)是vm格式。盖章位置是发证机关
                    byte[] imgb = KGQRCode.qrCode(qrcodeContent, 80, 80);
                    pdfElectronicSeal4KG2.setImage(imgb, "jpg", 80, 80);
                    pdfElectronicSeal4KG2.setXY(80, 80);
                    pdfElectronicSeal4KG2.setText("qrcode"); // 定位文本
                    pdfElectronicSeal4KG2.setTextOffset(-5, 15); // 设置相对文本位置的偏移量，PDF左下角为坐标原点。
                    hummer.addExecute(pdfElectronicSeal4KG2);
                } else if (zslx.equals(6) && gyEntcardprint.getEwm() != null) {
                    byte[] imgb = KGQRCode.qrCode(qrcodeContent, 80, 80);
//					String s = new String(gyEntcardprint.getQrcode());
//					generateImage(s,gyEntcardprint.getQrcodePath());
//					byte[] imgb = image2Bytes(gyEntcardprint.getQrcodePath());
                    pdfElectronicSeal4KG2.setImage(imgb, "jpg", 100, 100);
                    pdfElectronicSeal4KG2.setXY(100, 100);
                    pdfElectronicSeal4KG2.setText("qrcode"); // 定位文本
                    pdfElectronicSeal4KG2.setTextOffset(30, -40); // 设置相对文本位置的偏移量，PDF左下角为坐标原点。
                    hummer.addExecute(pdfElectronicSeal4KG2);
                } else if (getSignatureQrcodeXy(zslx)) {
                    byte[] imgb = KGQRCode.qrCode(qrcodeContent, 80, 80);
                    pdfElectronicSeal4KG2.setImage(imgb, "jpg", 80, 80);
                    pdfElectronicSeal4KG2.setXY(80, 80);
                    pdfElectronicSeal4KG2.setText("qrcode"); // 定位文本
                    pdfElectronicSeal4KG2.setTextOffset(30, -40); // 设置相对文本位置的偏移量，PDF左下角为坐标原点。
                    hummer.addExecute(pdfElectronicSeal4KG2);
                } else if (getSignatureQrcodeVm(zslx)) {
                    byte[] imgb = KGQRCode.qrCode(qrcodeContent, 80, 80);
                    pdfElectronicSeal4KG2.setImage(imgb, "jpg", 80, 80);
                    pdfElectronicSeal4KG2.setXY(80, 80);
                    pdfElectronicSeal4KG2.setText("qrcode"); // 定位文本
                    if (zslx.equals(31)) {
                        pdfElectronicSeal4KG2.setTextOffset(-5, 15); // 设置相对文本位置的偏移量，PDF左下角为坐标原点。
                    } else {
                        pdfElectronicSeal4KG2.setTextOffset(-5, 0); // 设置相对文本位置的偏移量，PDF左下角为坐标原点。
                    }
                    hummer.addExecute(pdfElectronicSeal4KG2);
                } else if (zslx.equals(3)) {
                    byte[] imgb = KGQRCode.qrCode(qrcodeContent, 80, 80);
                    pdfElectronicSeal4KG2.setImage(imgb, "jpg", 80, 80);
                    pdfElectronicSeal4KG2.setXY(80, 80);
                    pdfElectronicSeal4KG2.setText("qrcode"); // 定位文本
                    pdfElectronicSeal4KG2.setTextOffset(30, -40); // 设置相对文本位置的偏移量，PDF左下角为坐标原点。
                    hummer.addExecute(pdfElectronicSeal4KG2);
                } else if (zslx.equals(63)) {
                    byte[] imgb = KGQRCode.qrCode(qrcodeContent, 80, 80);
                    pdfElectronicSeal4KG2.setImage(imgb, "jpg", 80, 80);
                    pdfElectronicSeal4KG2.setXY(80, 80);
                    pdfElectronicSeal4KG2.setText("qrcode"); // 定位文本
                    pdfElectronicSeal4KG2.setTextOffset(-5, 0); // 设置相对文本位置的偏移量，PDF左下角为坐标原点。
                    hummer.addExecute(pdfElectronicSeal4KG2);
                } else if (zslx.equals(52)) {
                    byte[] imgb = KGQRCode.qrCode(qrcodeContent, 80, 80);
                    pdfElectronicSeal4KG2.setImage(imgb, "jpg", 80, 80);
                    pdfElectronicSeal4KG2.setXY(65, 65);
                    pdfElectronicSeal4KG2.setText("qrcode"); // 定位文本
                    //pdfElectronicSeal4KG2.setTextOffset(-5, 0); // 设置相对文本位置的偏移量，PDF左下角为坐标原点。
                    hummer.addExecute(pdfElectronicSeal4KG2);
                }else {
                    byte[] imgb = KGQRCode.qrCode(qrcodeContent, 110, 110);
                    pdfElectronicSeal4KG2.setImage(imgb, "jpg", 100, 100);
                    pdfElectronicSeal4KG2.setXY(100, 100);
                    pdfElectronicSeal4KG2.setText("qrcode"); // 定位文本
                    pdfElectronicSeal4KG2.setTextOffset(30, -40); // 设置相对文本位置的偏移量，PDF左下角为坐标原点。
                    hummer.addExecute(pdfElectronicSeal4KG2);
                }
            }
            Integer[] signArr = {65,66,70,71};
            if (Arrays.asList(signArr).contains(zslx)){
                //签名
                PdfElectronicSeal4KG pdfElectronicSeal4KG3 = new PdfElectronicSeal4KG(signatureServerUrl,KGServerTypeEnum.AUTO, serialNum, "123456", signatureName);
                String img = "2.png";
                if (zslx.equals(66)){//出口欧盟原料药
                    img = "1.png";
                    pdfElectronicSeal4KG3.setTextOffset(100, -20);
                }else{
                    pdfElectronicSeal4KG3.setTextOffset(130, 0); // 设置相对文本位置的偏移量，PDF左下角为坐标原点。
                }
                byte[] imgb = image2Bytes(Profile + "/" + img);
                pdfElectronicSeal4KG3.setImage(imgb, "png", 120, 80);
                pdfElectronicSeal4KG3.setText("Signature"); // 定位文本
                hummer.addExecute(pdfElectronicSeal4KG3);
            }
            hummer.encryptPdf("", "kingtake", PdfWriter.ALLOW_PRINTING);// 盖章之后将pdf文件加密
            hummer.doExecute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("盖章失败", e);
        } finally {
            hummer.close();
            IOUtils.closeQuietly(fos);
            File sourceFile = new File(pdfPath);
            sourceFile.delete();
            File sourceFile1 = new File(fjpath);
            sourceFile1.delete();
            if (gyEntcardprint.getZslx().equals(52)) {
                String delpath = pdfPath.replace("_temp", "_temp1");
                File sourceFile2 = new File(delpath);
                sourceFile2.delete();
            }
        }
        return fileName;
    }

    
    /*public static String addSignBgPdf(String pdfPath, String qrcodeContent, String position, String signatureName,
                                      String serialNum, ZsDto gyEntcardprint) {
        FileOutputStream fos = null;
        KGPdfHummer hummer = null;
        String savePath = null;
        String fileName = null;
        try {
            savePath = pdfPath.replace("_temp", "");
            int fsidx = savePath.lastIndexOf("/");
            int feidx = savePath.lastIndexOf(".");
            fileName = savePath.substring(fsidx + 1, feidx);
            fos = new FileOutputStream(new File(savePath));
            hummer = KGPdfHummer.createInstance(pdfPath, null, true, fos, false);
            String signatureServerUrl = Signature.getServerUrl();// 签章服务器的地址
            String positions[] = position.split("_");
            List<> czjlList = signatureUtil.czjlMapper.selectList(Wrappers.<TYwZsCzjl>lambdaQuery()
                    .eq(TYwZsCzjl::getZsid, gyEntcardprint.getId())
                    .eq(TYwZsCzjl::getYwlx,Constants.CZJL_YWLB_CHANGE)
                    .orderByDesc(TYwZsCzjl::getCzsj));
            //假设三条记录 倒序后 第一条是最新盖章的,最后一条是最旧的 循环时第一个盖章位置盖最旧的
            if (positions.length > 0) {
                for (int i = 0; i < positions.length; i++) {
                    String[] xy = positions[i].split(",");
                    //String keysn = (String) PropertyUtils.getProperty(gyEntcardprint, "modifykey" + (i + 1));
                    String keysn = czjlList.get(positions.length - i - 1).getQzid();
                    //String keyname = (String) PropertyUtils.getProperty(gyEntcardprint, "modifykeyname" + (i + 1));
                    String keyname = czjlList.get(positions.length - i - 1).getQzmc();
                    //String keysn = "T001";
                    //String keyname = "测试章";
                    if (StringUtils.isNotEmpty(keysn)) {
                        PdfElectronicSeal4KG pdfElectronicSeal4KG = new PdfElectronicSeal4KG(signatureServerUrl,
                                KGServerTypeEnum.AUTO, keysn, "123456", keyname);
                        pdfElectronicSeal4KG.setXY(Integer.parseInt(xy[0]), Integer.parseInt(xy[1])); // 设置印章加盖坐标XY
                        hummer.addExecute(pdfElectronicSeal4KG);
                    } else {
                        PdfElectronicSeal4KG pdfElectronicSeal4KG = new PdfElectronicSeal4KG(signatureServerUrl,
                                KGServerTypeEnum.AUTO, serialNum, "123456", signatureName);
                        pdfElectronicSeal4KG.setXY(Integer.parseInt(xy[0]), Integer.parseInt(xy[1])); // 设置印章加盖坐标XY
                        hummer.addExecute(pdfElectronicSeal4KG);
                    }
                }
            }
            hummer.encryptPdf("", "kingtake", PdfWriter.ALLOW_PRINTING);// 盖章之后将pdf文件加密
            hummer.doExecute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException("变更PDF盖章失败", e);
        } finally {
            hummer.close();
            IOUtils.closeQuietly(fos);
            File sourceFile = new File(pdfPath);
            sourceFile.delete();
        }
        return fileName;
    }
    */
  /*  public static String addSignBgOfd(String pdfPath, String qrcodeContent, String position, String signatureName,
                                      String serialNum, ZsDto gyEntcardprint,List<TYwZsCzjl> czjlList) {
        FileOutputStream fos = null;
        String savePath = null;
        String fileName = null;
        try {
            savePath = pdfPath.replace("_temp", "");
            int fsidx = savePath.lastIndexOf("/");
            int feidx = savePath.lastIndexOf(".");
            fileName = savePath.substring(fsidx + 1, feidx);
            fos = new FileOutputStream(new File(savePath));
            String positions[] = position.split("_");
            if (czjlList.isEmpty()){
                czjlList = signatureUtil.czjlMapper.selectList(Wrappers.<TYwZsCzjl>lambdaQuery()
                        .eq(TYwZsCzjl::getZsid, gyEntcardprint.getId())
                        .eq(TYwZsCzjl::getYwlx,Constants.CZJL_YWLB_CHANGE)
                        .orderByAsc(TYwZsCzjl::getCzsj));
            }
            if (positions.length > 0) {
                String tempPdfPath = pdfPath;
                JSONArray array = new JSONArray();
                for (int i = 0; i < positions.length; i++) {
                    JSONObject json = new JSONObject();
                    String[] xy = positions[i].split(",");
                    *//*String keysn = czjlList.get(positions.length - i - 1).getQzid();
                    String keyname = czjlList.get(positions.length - i - 1).getQzmc();*//*
                    String keysn = czjlList.get(i).getQzid();
                    String keyname = czjlList.get(i).getQzmc();
                    json.put("x",xy[0]);
                    json.put("y",xy[1]);
                    if (StringUtils.isNotEmpty(keysn)) {
                        //通过对照表将老key转为新key
                        ContrastKeySn newKey = contrastKeySn(keysn, keyname);
                        keysn = newKey.getKeySnOfd();
                        keyname = newKey.getKeyNameOfd();
                        *//*if ("T001".equals(keysn) || "B8D0E178EC01772C".equals(keysn)){
                            keysn = RuoYiConfig.getSealCode();
                            keyname="";
                        }*//*
                        json.put("sealCode",keysn);
                        json.put("sealName",keyname);
                    } else {
                        json.put("sealCode",serialNum);
                        json.put("sealName",signatureName);
                    }
                    array.add(json);
                }
                addSignOfdArray(tempPdfPath,savePath,array);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException("变更OFD盖章失败", e);
        } finally {
            IOUtils.closeQuietly(fos);
            File sourceFile = new File(pdfPath);
            sourceFile.delete();
        }
        return fileName;
    }
    */
    public static void encryptPdf(String pdfPath) {
        FileOutputStream fos = null;
        KGPdfHummer hummer = null;
        try {
            fos = new FileOutputStream(new File(pdfPath));
            hummer = KGPdfHummer.createInstance(pdfPath, null, true, fos, false);
            hummer.encryptPdf("", "kingtake", PdfWriter.ALLOW_PRINTING);// 盖章之后将pdf文件加密
            hummer.doExecute();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        } finally {
            hummer.close();
            IOUtils.closeQuietly(fos);
        }
    }
    
    public static void insertImageAsPDF() {
        KGPdfHummer hummer = null;
        FileOutputStream fileOutputStream = null;
        boolean center = true;
        try {
            fileOutputStream = new FileOutputStream("E:/药监/电子签章测试版/模板/3212.pdf");
            hummer = KGPdfHummer.createInstance("E:/药监/电子签章测试版/模板/4028ac81519a36b901519a5fe1b60004_20151213040553_1_无水印.pdf", null, true, fileOutputStream, true);
            
            PdfElectronicSeal4KG pdfElectronicSeal4KG = new PdfElectronicSeal4KG("E:/药监/Demo-iwebpdf/iSignature.key", 1, "123456");
            BufferedImage imgae = ImageIO.read(new File("E:/药监/电子签章测试版/模板/erweima.jpg"));
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ImageIO.write(imgae, "jpg", byteOut);
            byteOut.flush();
            pdfElectronicSeal4KG.setImage(byteOut.toByteArray(), "jpg", 100, 100);
            pdfElectronicSeal4KG.setXY(200, 200);
            pdfElectronicSeal4KG.setText("qrcode"); // 定位文本
            pdfElectronicSeal4KG.setTextOffset(30, -40); // 设置相对文本位置的偏移量，PDF左下角为坐标原点。
            pdfElectronicSeal4KG.setSealMsg("null", "湖北省食品药品监督管理局", "二维码", "null", "二维码"); // 设置印章相关信息
            hummer.addExecute(pdfElectronicSeal4KG);
            hummer.doExecute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
                if (hummer != null) {
                    hummer.close();
                }
            } catch (IOException e) {
                throw new BusinessException("生成二维码失败");
            }
        }
    }
    
    public static boolean getSignatureQrcodeVm(Integer cardtype) {
        boolean value = false;
        String xy = Signature.getCardtypeVm();
        String[] ct = xy.split(",");
        for (int i = 0; i < ct.length; i++) {
            if (cardtype.equals(Integer.valueOf(ct[i]))) {
                value = true;
            }
        }
        return value;
    }
    
    private static boolean getSignatureQrcodeXy(Integer cardtype) {
        boolean value = false;
        String xy = Signature.getQrcodeXYcardtype();
        String[] ct = xy.split(",");
        for (int i = 0; i < ct.length; i++) {
            if (cardtype.equals(Integer.valueOf(ct[i]))) {
                value = true;
            }
        }
        return value;
    }
    
    static byte[] image2Bytes(String imgSrc) throws Exception {
        FileInputStream fin = new FileInputStream(new File(imgSrc));
        //可能溢出,简单起见就不考虑太多,如果太大就要另外想办法，比如一次传入固定长度byte[]
        byte[] bytes = new byte[fin.available()];
        //将文件内容写入字节数组，提供测试的case
        fin.read(bytes);
        
        fin.close();
        return bytes;
    }
    
    public static boolean generateImage(String imgStr, String imgFile) throws Exception {// 对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) // 图像数据为空
        {
            return false;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }
            // 生成图片
            String imgFilePath = imgFile;// 新生成的图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    
    public static String addSignPdf(String pdfPath, String signatureName,
                                    String serialNum,String position, boolean b) {
        FileOutputStream fos = null;
        KGPdfHummer hummer = null;
        String savePath = null;
        String fileName = null;
        try {
            savePath = pdfPath.replace("_tmp", "");
            int fsidx = savePath.lastIndexOf("/");
            int feidx = savePath.lastIndexOf(".");
            fileName = savePath.substring(fsidx + 1, feidx);
            fos = new FileOutputStream(new File(savePath));
            hummer = KGPdfHummer
                    .createInstance(pdfPath, null, true, fos, false);
            String signatureServerUrl = Signature.getServerUrl();// 签章服务器的地址
            PdfElectronicSeal4KG pdfElectronicSeal4KG2 = new PdfElectronicSeal4KG(
                    signatureServerUrl, KGServerTypeEnum.AUTO, serialNum,
                    "123456", signatureName);
            if(b){
// 				pdfElectronicSeal4KG2.setText("中华人民共和国行政诉讼法");
// 				pdfElectronicSeal4KG2.setTextOffset(30, -73);
            }else{
                String xy[] = position.split(",");
                int px = Integer.parseInt(xy[0]);
                int py = Integer.parseInt(xy[1]);
                pdfElectronicSeal4KG2.setXY(px, py);
            }
            hummer.addExecute(pdfElectronicSeal4KG2);
            hummer.encryptPdf("", "kingtake", PdfWriter.ALLOW_PRINTING);// 盖章之后将pdf文件加密
            hummer.doExecute();
        } catch (Exception e) {
            throw new RuntimeException("盖章失败", e);
        } finally {
            hummer.close();
            IOUtils.closeQuietly(fos);
            File sourceFile = new File(pdfPath);
            sourceFile.delete();
        }
        return fileName;
    }
    
    
    public static String addSignPdf2Ofd(String pdfPath, String sealCode, String sealName, String position) {
        FileOutputStream fos = null;
        String savePath = null;
        String ofdPath = null;
        String fileName = null;
        try {
            JSONObject json = new JSONObject();
            JSONArray array = new JSONArray();
            ofdPath = OfdUtil.pdf2Ofd(pdfPath);
            savePath = ofdPath.replace("_tmp", "");
            int fsidx = savePath.lastIndexOf("/");
            int feidx = savePath.lastIndexOf(".");
            fileName = savePath.substring(fsidx + 1, feidx);
            fos = new FileOutputStream(new File(savePath));
            String xy[] = position.split(",");
            json.put("x",xy[0]);
            json.put("y",xy[1]);
            /*if (sealCode.equals("T001")){
                sealCode = RuoYiConfig.getSealCode();
            }*/
            json.put("sealCode",sealCode);
            json.put("sealName",sealName);
            array.add(json);
            addSignOfdArray(ofdPath,savePath,array);
        } catch (Exception e) {
            throw new RuntimeException("盖章失败", e);
        } finally {
            IOUtils.closeQuietly(fos);
            File sourceFile = new File(pdfPath);
            sourceFile.delete();
            File sourceFile1 = new File(ofdPath);
            sourceFile1.delete();
        }
        return fileName;
    }
    
    private static String getRandom(String BASE_URL) throws Exception {
        String url = BASE_URL + "/api/randomN";
        JSONObject json = new JSONObject();
        json.put("appid", appid);
        //越过ssl
        SSLContext sslContext = getSSLContext();
        Registry<ConnectionSocketFactory> socketFactoryRegistry =
                RegistryBuilder.<ConnectionSocketFactory>create()
                        .register("http", PlainConnectionSocketFactory.INSTANCE)
                        .register("https", new SSLConnectionSocketFactory(sslContext)).build();
        PoolingHttpClientConnectionManager mananger = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        mananger.setMaxTotal(100);
        mananger.setDefaultMaxPerRoute(20);
        //end
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        HttpPost httpPost = new HttpPost(url);
        StringEntity entity = new StringEntity(json.toJSONString(), ContentType.APPLICATION_JSON);
        httpPost.setEntity(entity);
        long start = System.currentTimeMillis();
        response = httpClient.execute(httpPost);
        logger.error("随机数获取时间:{}",(System.currentTimeMillis() - start));
        resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println("随机数：" + resultString);
        JSONObject ret = JSON.parseObject(resultString);
        return ret.getString("randomN");
    }
    
    private static SSLContext getSSLContext() {
        try {
            // 这里可以填两种值 TLS和LLS , 具体差别可以自行搜索
            SSLContext sc = SSLContext.getInstance("TLS");
            // 构建新对象
            X509TrustManager manager = new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                }
                
                @Override
                public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                }
                
                // 这里返回Null
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            sc.init(null, new TrustManager[]{manager}, null);
            return sc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    private static void copy(InputStream in, OutputStream out) throws IOException{
        int len = -1;
        byte[] buff = new byte[4096];
        while((len=in.read(buff)) != -1){
            out.write(buff, 0, len);
        }
    }
    
    public static String addQrcode(String pdfPath,String serialNum,String signatureName,String qrcodeContent,ZsDto gyEntcardprint) throws Exception {
        KGPdfHummer hummer = null;
        FileInputStream fis = null;
        FileOutputStream fos = null;
        boolean vm = false;
        String savePath = null;
        try {
            Integer zslx = Integer.valueOf(gyEntcardprint.getZslx());
            if (pdfPath.contains("fy_temp")) {
                vm = true;
            }
            savePath = pdfPath.replace("_temp", "_temp1");
            fos = new FileOutputStream(savePath);
            hummer = KGPdfHummer.createInstance(pdfPath, null, true, fos, false);
            
            String signatureServerUrl = Signature.getServerUrl();// 签章服务器的地址
            PdfElectronicSeal4KG pdfElectronicSeal4KG2 = new PdfElectronicSeal4KG(signatureServerUrl,
                    KGServerTypeEnum.AUTO, serialNum, "123456", signatureName);
            //特殊类型加签名 OFD
            Integer[] signArr = {65,66,70,71};
            if (Arrays.asList(signArr).contains(zslx)){
                //签名
                PdfElectronicSeal4KG pdfElectronicSeal4KG3 = new PdfElectronicSeal4KG(signatureServerUrl,KGServerTypeEnum.AUTO, serialNum, "123456", signatureName);
                String img = "2.png";
                if (zslx.equals(66)){//出口欧盟原料药
                    img = "1.png";
                    pdfElectronicSeal4KG3.setTextOffset(100, -20);
                }else{
                    pdfElectronicSeal4KG3.setTextOffset(130, 0); // 设置相对文本位置的偏移量，PDF左下角为坐标原点。
                }
                byte[] imgb = image2Bytes(Profile + "/" + img);
                pdfElectronicSeal4KG3.setImage(imgb, "png", 120, 80);
                pdfElectronicSeal4KG3.setText("Signature"); // 定位文本
                hummer.addExecute(pdfElectronicSeal4KG3);
            }
            //特殊类型加签名 OFD
            KGPdfHummerUtils hummerUtils = hummer.getKGPdfHummerUtils();
            List<Rectangle> rectangleList = hummerUtils.getPositionByText(1, "qrcode", true);
            if (rectangleList.size() > 0) {// 判断是否有qrcode的文字
                if (vm && zslx.equals(8)) {//医疗器械生产产品登记表(医疗器械副页)是vm格式。盖章位置是发证机关
                    byte[] imgb = KGQRCode.qrCode(qrcodeContent, 80, 80);
                    pdfElectronicSeal4KG2.setImage(imgb, "jpg", 80, 80);
                    pdfElectronicSeal4KG2.setXY(80, 80);
                    pdfElectronicSeal4KG2.setText("qrcode"); // 定位文本
                    pdfElectronicSeal4KG2.setTextOffset(-5, 15); // 设置相对文本位置的偏移量，PDF左下角为坐标原点。
                    hummer.addExecute(pdfElectronicSeal4KG2);
                } else if (zslx.equals(6) && gyEntcardprint.getEwm() != null) {
                    byte[] imgb = KGQRCode.qrCode(qrcodeContent, 80, 80);
//					String s = new String(gyEntcardprint.getQrcode());
//					generateImage(s,gyEntcardprint.getQrcodePath());
//					byte[] imgb = image2Bytes(gyEntcardprint.getQrcodePath());
                    pdfElectronicSeal4KG2.setImage(imgb, "jpg", 100, 100);
                    pdfElectronicSeal4KG2.setXY(100, 100);
                    pdfElectronicSeal4KG2.setText("qrcode"); // 定位文本
                    pdfElectronicSeal4KG2.setTextOffset(30, -40); // 设置相对文本位置的偏移量，PDF左下角为坐标原点。
                    hummer.addExecute(pdfElectronicSeal4KG2);
                } else if (getSignatureQrcodeXy(zslx)) {
                    byte[] imgb = KGQRCode.qrCode(qrcodeContent, 80, 80);
                    pdfElectronicSeal4KG2.setImage(imgb, "jpg", 80, 80);
                    pdfElectronicSeal4KG2.setXY(80, 80);
                    pdfElectronicSeal4KG2.setText("qrcode"); // 定位文本
                    pdfElectronicSeal4KG2.setTextOffset(30, -40); // 设置相对文本位置的偏移量，PDF左下角为坐标原点。
                    hummer.addExecute(pdfElectronicSeal4KG2);
                } else if (getSignatureQrcodeVm(zslx)) {
                    byte[] imgb = KGQRCode.qrCode(qrcodeContent, 80, 80);
                    pdfElectronicSeal4KG2.setImage(imgb, "jpg", 80, 80);
                    pdfElectronicSeal4KG2.setXY(80, 80);
                    pdfElectronicSeal4KG2.setText("qrcode"); // 定位文本
                    if (zslx.equals(31)) {
                        pdfElectronicSeal4KG2.setTextOffset(-5, 15); // 设置相对文本位置的偏移量，PDF左下角为坐标原点。
                    } else {
                        pdfElectronicSeal4KG2.setTextOffset(-5, 0); // 设置相对文本位置的偏移量，PDF左下角为坐标原点。
                    }
                    hummer.addExecute(pdfElectronicSeal4KG2);
                } else if (zslx.equals(3)) {
                    byte[] imgb = KGQRCode.qrCode(qrcodeContent, 80, 80);
                    pdfElectronicSeal4KG2.setImage(imgb, "jpg", 80, 80);
                    pdfElectronicSeal4KG2.setXY(80, 80);
                    pdfElectronicSeal4KG2.setText("qrcode"); // 定位文本
                    pdfElectronicSeal4KG2.setTextOffset(30, -40); // 设置相对文本位置的偏移量，PDF左下角为坐标原点。
                    hummer.addExecute(pdfElectronicSeal4KG2);
                } else if (zslx.equals(63)) {
                    byte[] imgb = KGQRCode.qrCode(qrcodeContent, 80, 80);
                    pdfElectronicSeal4KG2.setImage(imgb, "jpg", 80, 80);
                    pdfElectronicSeal4KG2.setXY(80, 80);
                    pdfElectronicSeal4KG2.setText("qrcode"); // 定位文本
                    pdfElectronicSeal4KG2.setTextOffset(-5, 0); // 设置相对文本位置的偏移量，PDF左下角为坐标原点。
                    hummer.addExecute(pdfElectronicSeal4KG2);
                } else if (zslx.equals(52)) {
                    byte[] imgb = KGQRCode.qrCode(qrcodeContent, 80, 80);
                    pdfElectronicSeal4KG2.setImage(imgb, "jpg", 80, 80);
                    pdfElectronicSeal4KG2.setXY(65, 65);
                    pdfElectronicSeal4KG2.setText("qrcode"); // 定位文本
                    //pdfElectronicSeal4KG2.setTextOffset(-5, 0); // 设置相对文本位置的偏移量，PDF左下角为坐标原点。
                    hummer.addExecute(pdfElectronicSeal4KG2);
                } else {
                    byte[] imgb = KGQRCode.qrCode(qrcodeContent, 110, 110);
                    pdfElectronicSeal4KG2.setImage(imgb, "jpg", 100, 100);
                    pdfElectronicSeal4KG2.setXY(100, 100);
                    pdfElectronicSeal4KG2.setText("qrcode"); // 定位文本
                    pdfElectronicSeal4KG2.setTextOffset(30, -40); // 设置相对文本位置的偏移量，PDF左下角为坐标原点。
                    hummer.addExecute(pdfElectronicSeal4KG2);
                }
                hummer.doExecute();
            }
            else{
                //不加二维码的话直接返回
                fis = new FileInputStream(pdfPath);
                IOUtils.copy(fis,fos);
            }
            return savePath;
        }catch (Exception e){
            logger.error("副页/批件添加二维码失败:{}",e.getMessage());
            throw new Exception("副页/批件添加二维码失败",e);
        }finally {
            hummer.close();
            IOUtils.closeQuietly(fos);
            IOUtils.closeQuietly(fis);
            File sourceFile = new File(pdfPath);
            sourceFile.delete();
        }
    }
    
   /* public static ContrastKeySn contrastKeySn(String keySn, String keyName){
        ContrastKeySn oldKeySn = new ContrastKeySn();
        oldKeySn.setKeySnOfd(keySn);
        oldKeySn.setKeyNameOfd(keyName);
        List<ContrastKeySn> list = signatureUtil.keySnMapper.selectList(Wrappers.<ContrastKeySn>lambdaQuery()
                .select(ContrastKeySn::getKeySnPdf,ContrastKeySn::getKeyNamePdf,
                        ContrastKeySn::getKeySnOfd, ContrastKeySn::getKeyNameOfd)
                .eq(ContrastKeySn::getKeySnPdf, keySn)
                .eq(ContrastKeySn::getKeyNamePdf, keyName));
        return list.isEmpty() ? oldKeySn : list.get(0);
    }*/
    
    public void addSignQm(String pdfPath,FileOutputStream fos,String zslx,String signatureServerUrl,String serialNum,String signatureName) throws Exception {
        KGPdfHummer hummer = null;
        hummer = KGPdfHummer.createInstance(pdfPath, null, true, fos, false);
        Integer[] signArr = {65,66,70,71};
        if (Arrays.asList(signArr).contains(zslx)){
            //签名
            PdfElectronicSeal4KG pdfElectronicSeal4KG3 = new PdfElectronicSeal4KG(signatureServerUrl,KGServerTypeEnum.AUTO, serialNum, "123456", signatureName);
            String img = "2.png";
            if (zslx.equals(66)){//出口欧盟原料药
                img = "1.png";
                pdfElectronicSeal4KG3.setTextOffset(100, -20);
            }else{
                pdfElectronicSeal4KG3.setTextOffset(130, 0); // 设置相对文本位置的偏移量，PDF左下角为坐标原点。
            }
            byte[] imgb = image2Bytes(Profile + "/" + img);
            pdfElectronicSeal4KG3.setImage(imgb, "png", 120, 80);
            pdfElectronicSeal4KG3.setText("Signature"); // 定位文本
            hummer.addExecute(pdfElectronicSeal4KG3);
        }
        hummer.encryptPdf("", "kingtake", PdfWriter.ALLOW_PRINTING);// 盖章之后将pdf文件加密
        hummer.doExecute();
    }
    
    
    public static String signImage(String tempPdf, String url, String signUrl, String keySn, String keyName) throws Exception {
        KGPdfHummer hummer = KGPdfHummer.createInstance(tempPdf, null, true);
        KGPdfHummerUtils kgUtils = hummer.getKGPdfHummerUtils();
        String pdfName = url.substring(0, url.lastIndexOf("."));
        String suffix = url.substring(url.lastIndexOf(".")+1,url.length());
        String temp ="_" + System.currentTimeMillis() + "";
        String pdfPath = pdfName + temp + ".pdf";
        String pdfRsPath = pdfName + temp + "_rs.pdf";
        String imgRs = pdfRsPath.replace(".pdf", "."+suffix);
        try {
            List<Image> images = new ArrayList<Image>();
            Image jpg = Image.getInstance(url);
            images.add(jpg);
            FileOutputStream fos = new FileOutputStream(pdfPath);
            //图片转PDF
            kgUtils.CreatePDF4ImageList(images, fos);
            fos.close();
            //对生成好的PDF文件盖章
            addApproveSign(pdfPath, pdfRsPath, signUrl,keySn,keyName);
            //转回图片
            /*KGPdf2Image pdf2Image = null;
            try {
                pdf2Image = new KGPdf2Image(pdfRsPath);
                // 按PDF高宽等比缩放图片，放大后图片清晰度更高
                pdf2Image.scalePercent(2.0F);
                for (int i = 1; i <= pdf2Image.getNumberOfPages(); i++) {
                    FileOutputStream fileOutputStream = new FileOutputStream(imgRs);
                    //将盖章后的PDF文件转换成图片
                    pdf2Image.save2Image(i, fileOutputStream, suffix);
                    IOUtils.closeQuietly(fileOutputStream);
                }
            } finally {
                if (pdf2Image != null) {
                    pdf2Image.close();
                }
            }*/
        } catch (Exception e) {
            throw e;
        }finally {
            hummer.close();
            /*File file = new File(pdfRsPath);
            if (file.exists()){
                boolean b = FileUtils.deleteQuietly(file);
            }*/
        }
        //return imgRs;
        return pdfRsPath;
    }
    
    public static void addApproveSign(String pdfPath, String savePath, String signUrl, String keySn, String keyName){
        FileOutputStream fos = null;
        KGPdfHummer hummer = null;
        try{
            fos = new FileOutputStream(savePath);
            hummer = KGPdfHummer.createInstance (pdfPath, null,true, fos,true);
            PdfElectronicSeal4KG pdfElectronicSeal4KG = new PdfElectronicSeal4KG(signUrl,KGServerTypeEnum.AUTO, keySn, "123456", keyName);
            //PdfElectronicSeal4KG pdfElectronicSeal4KG = new PdfElectronicSeal4KG(signUrl,KGServerTypeEnum.AUTO, "lzy", "123456", "公章");
            pdfElectronicSeal4KG.setXY(500, 320);
            hummer.addExecute(pdfElectronicSeal4KG);
            hummer.doExecute();
        }catch(Exception e){
            e.printStackTrace();
            hummer.close();
            IOUtils.closeQuietly(fos);
            logger.error("图片签章失败");
        }finally{
            hummer.close();
            IOUtils.closeQuietly(fos);
            FileUtils.deleteQuietly(new File(pdfPath));
        }
        logger.info("图片签章成功");
    }
    
    
    public static void FjPdfSign(String pdfPath, String savePath, String signUrl, String keySn, String keyName) throws DocumentException, IOException {
        FileOutputStream fos = null;
        KGPdfHummer hummer = null;
        try{
            fos = new FileOutputStream(savePath);
            hummer = KGPdfHummer.createInstance (pdfPath, null,true, fos,true);
            PdfElectronicSeal4KG pdfElectronicSeal4KG = new PdfElectronicSeal4KG(signUrl,KGServerTypeEnum.AUTO, keySn, "123456", keyName);
            //在线测试
            //PdfElectronicSeal4KG pdfElectronicSeal4KG = new PdfElectronicSeal4KG(signUrl,KGServerTypeEnum.AUTO, "lzy", "123456", "公章");
            pdfElectronicSeal4KG.setXY(300, 720);
            pdfElectronicSeal4KG.setPagen(0);
            hummer.addExecute(pdfElectronicSeal4KG);
            hummer.doExecute();
        }catch(Exception e){
            hummer.close();
            IOUtils.closeQuietly(fos);
            logger.error("附件签章失败");
            throw e;
        }finally{
            hummer.close();
            IOUtils.closeQuietly(fos);
            //不删除源文件
        }
        logger.info("附件签章成功");
    }
    
    

}
