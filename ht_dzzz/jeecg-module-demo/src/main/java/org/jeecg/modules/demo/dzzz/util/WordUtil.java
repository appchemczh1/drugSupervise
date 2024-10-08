/*
package org.jeecg.modules.demo.dzzz.util;
import cn.hutool.system.OsInfo;
import cn.hutool.system.SystemUtil;
import com.aspose.words.Document;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;
import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.exception.RenderException;
import com.deepoove.poi.policy.HackLoopTableRenderPolicy;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.Map;

public class WordUtil {
    */
/**
     * 填充word模板，并且转成pdf文件后返回:
     * @param datas: 填充数据
     * @param fileStream: 文件模板流 -- 可从OSS/FastDFS上获取流，直接传入；
     * @return
     * @throws IOException
     *//*

    public static byte[] fillWordToPDF(Map<String,Object> datas,InputStream fileStream) throws IOException {
        try {
            //先填充word:
            byte[] bytes = fillWord(datas, fileStream);

            //在word转pdf:
            return wordToPDF(new ByteArrayInputStream(bytes));
        } catch (IOException ex){
            log.error("系统异常::{}",ex);
            throw ex;
        }
    }

    */
/**
     * 填充word模板，获取填充后的word文件流:
     * @param datas: 填充数据
     * @param fileStream: 文件模板流 -- 可从OSS/FastDFS上获取流，直接传入；
     * @return
     * @throws IOException
     *//*

    public static byte[] fillWord(Map<String,Object> datas, InputStream fileStream) throws IOException {
        XWPFTemplate template = null;
        ByteArrayOutputStream wordOut = new ByteArrayOutputStream(1024);
        try {
            //设置占位符:
            Configure config = Configure.builder()
                    .buildGramer("${", "}") //设置模板中的占位符${}, 默认是{{}}
                    .setValidErrorHandler(new Configure.AbortHandler()) //若模板中占位符与填充属性不对应,则报错;
                    .bind("list", new HackLoopTableRenderPolicy()) //设置模板中表格的参数属性
                    .build();

            //填充文本域:
            template = XWPFTemplate.compile(fileStream, config).render(datas);
            template.write(wordOut);
        }catch (RenderException ex){
            log.error("模板填充失败，请保证模板文本域与参数保持一致。错误信息::{}",ex);
            throw ex;
        } catch (IOException ex){
            log.error("系统异常::{}",ex);
            throw ex;
        }finally {
            try {
                if (template != null){
                    template.close();
                }
            } catch (IOException ex) {
                log.error("关闭文件流资源异常::{}",ex);
            }
        }
        return wordOut.toByteArray();
    }

    */
/**
     * word转pdf
     * @param wordInStream: word文件输入流;
     *//*

    public static byte[] wordToPDF(InputStream wordInStream) {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream(1024);
        try {
            InputStream licenseIn = WordUtil.class.getClassLoader().getResourceAsStream("license.xml");
            License aposeLic = new License();
            aposeLic.setLicense(licenseIn);

            //因linux环境没有语言包,当项目部署到linux环境后,转成的pdf中的中文是类似乱码的,所以需要去加载此目录下的语言包;
            OsInfo osInfo = SystemUtil.getOsInfo();
//            if(osInfo.isLinux()){
//                //====================================== 注意 ============================================
//                //注意: 需要把项目中resource/fonts目录下的语言包全部放到linux中的此目录下,否则linux环境中处理是乱码;
//                //以下是我自己定义的目录,你可随意更改为你linux上的目录;
//                FontSettings.setFontsFolder("/usr/share/fonts/chinese", true);
//                //=======================================================================================
//            }

            //Address是将要被转化的word文档
            Document doc = new Document(wordInStream);
            //全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF,
            doc.save(byteOut, SaveFormat.PDF);
        } catch (Exception e) {
            log.error("word转pdf异常::{}",e);
            throw new RuntimeException("word转pdf异常");
        }
        return byteOut.toByteArray();
    }

    */
/**
     * word转pdf
     * @param wordInStream: word文件输入流;
     * @param pdfOutStream: pdf文件输出流;
     *//*

    public static void wordToPDF(InputStream wordInStream, OutputStream pdfOutStream) {
        try {
            InputStream licenseIn = WordUtil.class.getClassLoader().getResourceAsStream("license.xml");
            License aposeLic = new License();
            aposeLic.setLicense(licenseIn);

            //因linux环境没有语言包,当项目部署到linux环境后,转成的pdf中的中文是类似乱码的,所以需要去加载此目录下的语言包;
            OsInfo osInfo = SystemUtil.getOsInfo();
//            if(osInfo.isLinux()){
//                //====================================== 注意 ============================================
//                //注意: 需要把项目中resource/fonts目录下的语言包全部放到linux中的此目录下,否则linux环境中处理是乱码;
//                //以下是我自己定义的目录,你可随意更改为你linux上的目录;
//                FontSettings.setFontsFolder("/usr/share/fonts/chinese", true);
//                //=======================================================================================
//            }

            //Address是将要被转化的word文档
            Document doc = new Document(wordInStream);
            //全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF,
            doc.save(pdfOutStream, SaveFormat.PDF);
        } catch (Exception e) {
            log.error("word转pdf异常::{}",e);
            throw new RuntimeException("word转pdf异常");
        }

}
*/
