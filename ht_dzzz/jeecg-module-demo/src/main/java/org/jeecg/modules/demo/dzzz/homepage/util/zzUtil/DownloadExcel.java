package org.jeecg.modules.demo.dzzz.homepage.util.zzUtil;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class DownloadExcel {
    public void downInChargeOfTemplate(HttpServletResponse response,String fileName) throws IOException {
        String[] parts = fileName.split("\\.");
        String file = parts[0];
        String type = parts[1];
        responseSetting(response, file, "."+type,
                "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            // 读取文件的输入流
            inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("file/"+fileName);
            XSSFWorkbook wb = new XSSFWorkbook(inputStream);
            outputStream = response.getOutputStream();
            wb.write(outputStream);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != outputStream) {
                outputStream.flush();
                outputStream.close();
            }
        }
    }

    public void responseSetting(HttpServletResponse response, String fileName, String suffix, String contentType) {
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String newFileName = null;
        try {
            newFileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        // 当客户端请求的资源是一个可下载的资源（这里的“可下载”是指浏览器会弹出下载框或者下载界面）时，对这个可下载资源的描述（例如下载框中的文件名称）就是来源于该头域。
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + newFileName + suffix);
        // 服务器告诉浏览器它发送的数据属于什么文件类型，也就是响应数据的MIME类型
        response.setContentType(contentType);
        response.setCharacterEncoding("utf-8");
        // 关闭缓存（HTTP/1.1）
        response.setHeader("Cache-Control", "no-store");
        // 关闭缓存（HTTP/1.0）
        response.setHeader("Pragma", "no-cache");
        // 缓存有效时间
        response.setDateHeader("Expires", 0);
    }

}
