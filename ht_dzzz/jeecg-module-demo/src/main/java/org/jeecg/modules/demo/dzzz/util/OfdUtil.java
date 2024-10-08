
package org.jeecg.modules.demo.dzzz.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jeecg.common.util.ExceptionUtils;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertInfo;
import org.jeecg.modules.demo.dzzz.certinfo.entity.ResultBean;
import org.jeecg.modules.demo.dzzz.certmode.entity.CertMode;
import org.springframework.beans.factory.annotation.Value;

import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.suwell.ofd.custom.agent.ConvertException;
import com.suwell.ofd.custom.agent.HTTPAgent;
import com.suwell.ofd.custom.wrapper.Const;
import com.suwell.ofd.custom.wrapper.Const.PackType;
import com.suwell.ofd.custom.wrapper.Const.Target;
import com.suwell.ofd.custom.wrapper.PackEntry;
import com.suwell.ofd.custom.wrapper.PackException;
import com.suwell.ofd.custom.wrapper.Packet;
import com.suwell.ofd.custom.wrapper.io.FilenameUtils;
import com.suwell.ofd.custom.wrapper.io.IOTools;
import com.suwell.ofd.custom.wrapper.model.Common;
import com.suwell.ofd.custom.wrapper.model.Template;

//@Component
public class OfdUtil {
    @Value(value = "${jeecg.path.upload}")
    private static String uploadpath;
    private static final Log log = LogFactory.getLog(OfdUtil.class);

    public static OfdUtil ofdUtil;

    //@PostConstruct
    public void init() {
        ofdUtil = this;
    }

    public static HTTPAgent ha = new HTTPAgent("http://192.168.0.217:8090/convert-issuer/");
    // public static HTTPAgent ha = new HTTPAgent("http://49.4.0.153:7003/convert-issuer/");

    /**
     * @param ofdpath ofd文件路劲
     * @param certid  //证照信息表中的主键id
     * @return
     */
    public static String makeAttach(String duodu, String ofdpath, CertInfo certid, String rootpath, CertMode certMode, ResultBean resultBean) {
        return makeAttach(duodu, ofdpath, certid.getFj(), rootpath, certMode, resultBean);
    }

	public static String makeAttach(String duodu, String ofdpath, String fj, String rootpath, CertMode certMode, ResultBean resultBean) {
		if (StringUtils.isBlank(fj)) return "附件路径为空";
		Packet packet = new Packet(Const.PackType.COMMON, Const.Target.OFD);
		List<String> tempFiles = new ArrayList<>();
		try {
			packet.file(new Common(null, "ofd", new FileInputStream(duodu)));
			int idx = 1;
			for (String item : fj.split("[,]+")) {
				File file = new File(rootpath, item);
				if (!file.exists() || !file.isFile()) continue;
				String filename = org.apache.commons.io.FilenameUtils.getBaseName(item), ext,
					pdfFile = rootpath + "/temp/" + filename + "_.pdf",
					signFile = rootpath + "/temp/" + filename + "_sign.pdf";
				String error = toPdf(file.getAbsolutePath(), pdfFile, certMode, resultBean, true);
				if (!StringUtils.equals(error, "useSourceFile")) {
					if (StringUtils.isNotBlank(error)) return error;
					file = new File(pdfFile);
				}
				ext = org.apache.commons.io.FilenameUtils.getExtension(file.getName());
				packet.attach("附件" + idx, ext, new FileInputStream(file), true);
				tempFiles.add(pdfFile);
				idx++;
			}
			ha.convert(packet, new FileOutputStream(ofdpath));
		} catch (Throwable e) {
			e.printStackTrace();
			return StringUtils.defaultIfBlank(e.getMessage(), "附件合并失败");
		} finally {
			for (String item : tempFiles) FileUtils.deleteQuietly(new File(item));
			IOTools.closeQuietly(packet);
		}
		return null;
	}

	public static int template2Ofd(String xmlTemplate, String ofdTemplatePath, String ofdRsPath) {
		FileInputStream template = null;
		ByteArrayInputStream data = null;
		FileOutputStream out = null;
		try {
			template = new FileInputStream(ofdTemplatePath);
			data = new ByteArrayInputStream(xmlTemplate.getBytes());
			out = new FileOutputStream(ofdRsPath);
			ha.templateToOFD("ofd", template, data, out);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			IOTools.closeQuietly(out);
			FileUtils.deleteQuietly(new File(ofdRsPath));
			return 0;
		} finally {
			try {if (null != out) out.flush();} catch (IOException ignore) {}
			IOTools.closeQuietly(data, template, out);
		}
	}

	//生成多页模板
	public static int generaterMorePage(String xmlTemplate, String ofdTemplatePath, String ofdRsPath) {
		FileInputStream in = null;
		ByteArrayInputStream dataStream = null;
		FileOutputStream out = null;
		try {
			Packet packet = new Packet("common.template", Target.OFD);
			Map<String, InputStream> files = new HashMap<String, InputStream>();
			//续页。必须与模板里的定义相同。
			files.put("Files\\20-republic-add.ofd", new FileInputStream(new File(ofdTemplatePath)));
			//尾页
/*
            files.put("Files\\20-republic-tu-add.ofd",new FileInputStream(new File("D:\\Files\\20-republic-tu-add.ofd")));
*/
			ByteArrayInputStream data = null;
			//设置主页模板与数据源xml文件
			Template t = new Template("test", in = new FileInputStream(ofdTemplatePath), dataStream = new ByteArrayInputStream(xmlTemplate.getBytes()), files);
			packet.data(t);
			//调用转换接口生成合并后的ofd文件
			ha.convert(packet, out = new FileOutputStream(ofdRsPath));

			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			IOTools.closeQuietly(out);
			FileUtils.deleteQuietly(new File(ofdRsPath));
			return 0;
		} finally {
			try {if (null != out) out.flush();} catch (IOException ignore) {}
			IOTools.closeQuietly(dataStream, in, out);
		}
	}

    public static int generaterMorePageForDocx(String xmlTemplate, String ofdTemplatePath, String ofdRsPath) {
        try {
            Packet packet = new Packet("wps.template", Const.Target.OFD);
            PackEntry data = PackEntry.wrap(new File("D:/1.xml"));
            PackEntry temp = PackEntry.wrap(new File("D:/药品出口准许证（公文域版本）.docx"));
            Template template = new Template("title",Template.Type.DOCX,temp,data);
            packet.data(template);
            //调用转换接口生成合并后的ofd文件
            ha.convert(packet,new FileOutputStream(ofdRsPath));
            return 1;
        } catch (IOException e) {
            e.printStackTrace();
            return  0;
        } catch (ConvertException e) {
            e.printStackTrace();
            return  0;
        } catch (PackException e) {
            e.printStackTrace();
            return  0;
        } finally {

        }
    }
    /**
     * pfd转OFD
     *
     * @param pdfPath
     * @return
     */
    public static String pdf2Ofd(String pdfPath) throws Exception {
        FileOutputStream fos = null;
        String savePath = null;
        //加二维码
        try {
            File srcFile = new File(pdfPath);
            savePath = pdfPath.replace(".pdf", ".ofd");
            fos = new FileOutputStream(savePath);
            ha.officeToOFD(srcFile, fos);
            return savePath;
        } catch (Exception e) {
            log.error("pdf转ofd失败", e);
            throw new Exception("pdf转ofd失败", e);
        } finally {
            IOUtils.closeQuietly(fos);
            new File(pdfPath).delete();
        }
    }

	public static String ofd2Pfd(String ofdPath, boolean delete) throws Exception {
		List<File> deleteFiles = new ArrayList<>();
		FileOutputStream fos = null;
		String savePath = null;
		//加二维码
		try {
			File srcFile = new File(ofdPath);
			savePath = new File(srcFile.getParent(), FilenameUtils.getBaseName(ofdPath) + ".pdf").getAbsolutePath();
			fos = new FileOutputStream(savePath);
			ha.OFDToPDF(srcFile, fos);
			if (delete) deleteFiles.add(srcFile);
			return savePath;
		} catch (Exception e) {
			if (null != savePath) deleteFiles.add(new File(savePath));
			throw new Exception("ofd转pdf失败", e);
		} finally {
			IOUtils.closeQuietly(fos);
			for (File file : deleteFiles) FileUtils.deleteQuietly(file);
		}
	}

    public static boolean WordToOfd(String source, String target) {
        OutputStream out = null;
        try {
            ha.officeToOFD(new File(source), out = new FileOutputStream(target));
			return true;
        } catch (Throwable e) {
            e.printStackTrace();
            return false;
        } finally {
            IOTools.closeQuietly(out);
        }
    }

    public static boolean WordToPdf(String source, String target) {
        Packet packet = new Packet(PackType.COMMON, Target.PDF);
        FileInputStream in = null;
        OutputStream out = null;
        try {
            File file = new File(source);
            packet.file(new Common(file.getName(), FilenameUtils.getExtension(file.getName()), in = new FileInputStream(file)));
            ha.convert(packet, out = new FileOutputStream(target));
        } catch (Throwable e) {
            e.printStackTrace();
            return false;
        } finally {
            IOTools.closeQuietly(packet, out, in);
        }
        return true;
    }

    public static boolean OfdToPdf(String source, String target) {
        OutputStream out = null;
        try {
            ha.OFDToPDF(new File(source), out = new FileOutputStream(target));
        } catch (Throwable e) {
            e.printStackTrace();
            return false;
        } finally {
            IOTools.closeQuietly(out);
        }
        return true;
    }

    public static boolean MergeFilesToOfd(List<File> files, String target) {
        Packet packet = new Packet(PackType.COMMON, Target.OFD);
        OutputStream out = null;
        try {
            for (File file : files) {
                packet.file(new Common(file.getName(), FilenameUtils.getExtension(file.getName()), new FileInputStream(file)));
            }
            ha.convert(packet, out = new FileOutputStream(target));
        } catch (Throwable e) {
            e.printStackTrace();
            return false;
        } finally {
            IOTools.closeQuietly(packet, out);
        }
        return true;
    }

	protected static int getPosition(float total, String val, boolean fromZero, int defaultVal) {
		boolean isPercent = StringUtils.contains(val, "%");
		int a = NumberUtils.toInt(StringUtils.trimToEmpty(val).replace("%", ""), -1);
		if (0 > a) return defaultVal;
		if (isPercent) a = (int) Math.floor(total * a / 100);
		return (int) Math.floor(fromZero ? a : (total - a));
	}

	/**
	 * 任意文件转pdf
	 * @param source            源文件
	 * @param target            目标文件
	 * @param certMode          证书模板
	 * @param stampInfo         印章信息，null标识不盖章
	 * @param ignoreSourceError 是否忽略源文件不存在的错误
	 * @return 错误信息，返回useSourceFile标识文件未正确转换或复制到目标文件
	 */
	public static String toPdf(String source, String target, CertMode certMode, ResultBean stampInfo, boolean ignoreSourceError) {
		File file = new File(source);
		if (!file.exists() || !file.isFile()) return ignoreSourceError ? null : "源文件不存在";
		boolean isConvert = true;
		List<String> tempFiles = new ArrayList<>();
		try {
			File destFile = new File(target);
			if (!destFile.getParentFile().exists() && !destFile.getParentFile().mkdirs())
				return "目录[" + destFile.getParentFile().getCanonicalPath() + "]创建失败";
			String rootPath = destFile.getParent();
			String filename = FilenameUtils.getBaseName(target),
				ext = org.apache.commons.io.FilenameUtils.getExtension(file.getName()),
				pdfFile = rootPath + "/" + filename + "_z.pdf",
				signFile = rootPath + "/" + filename + "_z_sign.pdf";
			if (StringUtils.equalsAnyIgnoreCase(ext, "png", "jpg", "jpeg", "gif")) {
				String error = ImgToPdfUtil.imageToPdf(file.getAbsolutePath(), pdfFile, certMode.getPapertype(), 4000, 4000);
				if (StringUtils.isNotBlank(error)) return error;
				file = new File(pdfFile);
			} else if (StringUtils.equalsAnyIgnoreCase(ext, "doc", "docx", "xls", "xlsx")) {
				if (WordToPdf(file.getAbsolutePath(), pdfFile))
					file = new File(pdfFile);
			} else if (StringUtils.equalsAnyIgnoreCase(ext, "ofd")) {
				if (OfdToPdf(file.getAbsolutePath(), pdfFile))
					file = new File(pdfFile);
			} else {
				isConvert = false;
			}
			ext = org.apache.commons.io.FilenameUtils.getExtension(file.getName());
			if (null != stampInfo && StringUtils.equalsAnyIgnoreCase(ext, "pdf")) {
				if (isConvert) tempFiles.add(file.getCanonicalPath());
				int x = 0, y = 0;
				PdfReader reader = null;
				try {
					reader = new PdfReader(file.getAbsolutePath());
					for (int page = 1; page <= reader.getNumberOfPages(); page++) {
						Rectangle size = reader.getPageSize(page);
						int a = getPosition(size.getWidth(), null, true, (int) Math.floor(size.getWidth() / 2)),
							b = getPosition(size.getHeight(), null, false, (int) size.getHeight() - 110);
						x = 0 < x ? Math.min(a, x) : a;
						y = 0 < y ? Math.min(b, y) : b;
					}
				} finally {
					if (null != reader) reader.close();
				}
				SignatureUtil.addSignPDF(file.getAbsolutePath(), target, x + "", y + "", null, null, null,
					"0", stampInfo.getSealCode(), stampInfo.getSealName());
			} else if (!StringUtils.equals(file.getCanonicalPath(), destFile.getCanonicalPath())) {
				if (isConvert) Files.move(Paths.get(file.getAbsolutePath()), Paths.get(target), StandardCopyOption.REPLACE_EXISTING);
				else return "useSourceFile";
			} else return "useSourceFile";
		} catch (Throwable e) {
			throw ExceptionUtils.unchecked(e);
		} finally {
			for (String item : tempFiles) FileUtils.deleteQuietly(new File(item));
		}
		return null;
	}

  /*  public static String wpsFileTask(File moudelfile, File xmlfile, String rsPath) throws Exception {
        String body = wpsFileTask(moudelfile, xmlfile);
        ObjectNode node = new ObjectMapper().readValue(body, ObjectNode.class);
        if ("0".equals(node.get("statusCode").toString())) {
            log.info("文件上传成功 执行查询方法");
            String id = node.get("data").toString().replace("\"", ""); //获取ticket
            //String condition = "1";
            while (true) { //循环查询文件转换状态
                String reflushOfdBody = reflushOfd(id);
                ObjectNode reflushOfdNode = new ObjectMapper().readValue(reflushOfdBody, ObjectNode.class);
                //log.info(reflushOfdNode.get("statusCode").toString());
                if ("0".equals(reflushOfdNode.get("statusCode").toString())) { //转换成功下载
                    log.info("下载准备就绪 执行下载方法");
                    String name = node.get("data").toString().replace("\"", "");
                    saveUrlAs(OfdConfig.getBaseUrl() + "/download?ticket=" + name, rsPath, name, "GET");
                    //condition = "2";
                    break;
                }

            }D
        }
        return body;
    }
*/

    // wps 模板转换
 /*   public static String wpsFileTask(File moudelfile, File xmlfile) {
        String ticket = "";
        String body = "";
        try {

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
            MultiValueMap<String, Object> param = new LinkedMultiValueMap<String, Object>();
            FileSystemResource resource1 = new FileSystemResource(moudelfile);
            FileSystemResource resource2 = new FileSystemResource(xmlfile);
            param.add("moudleFile", resource1);
            param.add("xmlFile", resource2);

            HttpEntity<MultiValueMap<String, Object>> formEntity = new HttpEntity<MultiValueMap<String, Object>>(param, headers);

            // 模板转换controller
            String url = "http://192.168.0.217:8095/convert-issuer/" + "/wpsMoudleConvertTask.do";

            ResponseEntity<String> responseEntity = null;
            RestTemplate restTemplate = new RestTemplate();
            try {
                responseEntity = restTemplate.postForEntity(url, formEntity, String.class);
            } catch (Exception e) {
                System.out.println(" 接口调用失败，错误信息：" + e.getMessage() + "，错误堆栈：" + e.getStackTrace());
                e.printStackTrace();
            }
            if (responseEntity == null) {
                System.out.println(" 接口调用失败，返回responseEntity为空");
            }
            log.info("调用三方splitFileTask接口出参StatusCode（200为成功）：" + responseEntity.getStatusCodeValue());
            if (200 != responseEntity.getStatusCodeValue()) {
                System.out.println(" 接口调用失败，responseEntity.getStatusCodeValue()!=200");
            }
            body = responseEntity.getBody();
            if (StringUtils.isBlank(body)) {
                System.out.println(" 接口调用失败，responseEntity.getBody()为空");
            }
            OfdResult outputDTO = new OfdResult();
            try {
                ObjectNode node = new ObjectMapper().readValue(body, ObjectNode.class);

                System.out.println(body);

                ticket = node.get("data").toString();
                System.out.println(ticket);
                ObjectMapper objectMapper = new ObjectMapper();
                outputDTO = objectMapper.readValue(body, OfdResult.class);

            } catch (Exception e) {

                System.out.println(
                        "JSON转换失败，三方 接口返回的数据不是定义的JSON格式，错误信息：" + e.getMessage() + "，错误堆栈：" + e.getStackTrace());
            }
            if (outputDTO.getStatusCode() == null || 0 != outputDTO.getStatusCode()) {
                System.out.println("三方 接口调用失败，出参statusCode不为0；异常描述信息：" + outputDTO.getMessage());
            }
            ticket = outputDTO.getData();
            if (StringUtils.isBlank(ticket)) {
                System.out.println("三方 接口调用失败，出参statusCode为0时，data值为空（规范要求此时ticket不可为空）；");
            }
            log.info("三方 接口调用成功，出参ticket为：" + ticket);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return body;
    }*/

    public static void saveUrlAs(String url, String filePath, String fileName, String method) {
        FileOutputStream fileOut = null;
        HttpURLConnection conn = null;
        InputStream inputStream = null;
        //创建不同的文件夹目录
        File file = new File(filePath);
        //判断文件夹是否存在
        if (!file.exists()) {
            //如果文件夹不存在，则创建新的的文件夹
            file.mkdirs();
        }
        try {
            // 建立链接
            URL httpUrl = new URL(url);
            conn = (HttpURLConnection) httpUrl.openConnection();
            //以Post方式提交表单，默认get方式
            conn.setRequestMethod(method);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            // post方式不能使用缓存
            conn.setUseCaches(false);
            //连接指定的资源
            conn.connect();
            //获取网络输入流
            inputStream = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(inputStream);
            //判断文件的保存路径后面是否以/结尾
            if (!filePath.endsWith("/")) {
                filePath += "/";
            }
            //写入到文件（注意文件保存路径的后面一定要加上文件的名称）
            fileOut = new FileOutputStream(filePath + fileName + ".ofd");
            BufferedOutputStream bos = new BufferedOutputStream(fileOut);

            byte[] buf = new byte[4096];
            int length = bis.read(buf);
            //保存文件
            while (length != -1) {
                bos.write(buf, 0, length);
                length = bis.read(buf);
            }
            bos.close();
            bis.close();
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("抛出异常！！");
        }
    }

    //查询执行状态
   /* public static String reflushOfd(String ticket) {

        // 拼接下载地址url
        String url = OfdConfig.getBaseUrl() + "/queryConvertTask.do" + "?jsonInfo=" + ticket;

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        String body = responseEntity.getBody();
        //log.info("查询返回body" + body);
        ObjectNode node = null;
        try {
            node = new ObjectMapper().readValue(body, ObjectNode.class);
        } catch (Exception e) {
            log.error("下载状态异常:", e);
            System.out.println(e.getMessage());
        }

        String downloadurl = node.get("data").toString();

        //log.info("下载地址----" + downloadurl);
        return body;

    }

    public static void mergeOfd(String filePath1, String filePath2, String savePath) throws Exception {
        Packet packet = new Packet(Const.PackType.COMMON, Const.Target.OFD);
        FileOutputStream fos = null;
        List<File> list = new ArrayList<>();
        try {
            fos = new FileOutputStream(savePath);
            list.add(new File(filePath1));
            list.add(new File(filePath2));
            ha.officesToOFD(list, fos);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        } finally {
            fos.flush();
            fos.close();
        }

    }
*/
    public static void main(String[] args) throws Exception {
        FileInputStream template = null;
        ByteArrayInputStream data = null;
        FileOutputStream out = null;
        try {
            String xmlTemplate = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<root><qrcode>http://59.175.169.148/zscx/zscx/ZscxAction.do?operate=searchZsxxInfoByQrcode&amp;operPage=zsxx_view&amp;gyEntcardprint.id=402809817d8f1220017d8f1b86d90018&amp;gyEntcardprint.cardtype=14</qrcode><cardid>零售test001</cardid><name>﹡﹡﹡张岚</name><address>随州市曾都区天后宫</address><nameeng>92421303MA4D3X029Y</nameeng><corpname>法定代表人</corpname><chargename>张岚</chargename><quaname>质量管理人</quaname><addrstorge>仓库地址</addrstorge><range>范围</range><makedept>湖北省药品监督管理局</makedept><makedate_Y>2021</makedate_Y><makedate_M>12</makedate_M><makedate_D>6</makedate_D><admtimeto_Y>2026</admtimeto_Y><admtimeto_M>12</admtimeto_M><admtimeto_D>5</admtimeto_D><gyentbaseinfo_id>4028804b65a215c00165c28b90130cc2</gyentbaseinfo_id><monitororg>湖北省药品监督管理局</monitororg><signedperson>111</signedperson></root>";

            String ofdTemplatePath = "F:\\svnProject\\hbfda_cardprint\\out\\artifacts\\hbfda_cardprint_war_exploded\\file\\PubTemplate\\202112\\402809817d8f1220017d8f140e470002_20211206052956_1.ofd";
            String ofdRsPath = "F:/zsxt/file/zsPdfFiles/sj/4213/dy/20211206/402809817d8f1220017d8f1b86d90018_20211206174255_1_temp.ofd";
            template = new FileInputStream(ofdTemplatePath);
            data = new ByteArrayInputStream(xmlTemplate.getBytes());
            out = new FileOutputStream(ofdRsPath);
            ha.templateToOFD("ofd", template, data, out);
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            out.flush();
            out.close();
            data.close();
            template.close();
        }
    }
}
