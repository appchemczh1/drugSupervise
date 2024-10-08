package org.jeecg.modules.demo.dzzz.certStatistics.util.zzUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author classmateZhou
 * @date 2023-06-14
 * Description: excel解析控制器
 */




public class ExcelParseRest {
    private Logger logger = LoggerFactory.getLogger(ExcelParseRest.class);

    /**
     * 导出通用的excel
     *
     * @param file excel文件
     * @return
     */
    public List<Map> parseExcelComm(MultipartFile file, List<String> columnkeys, Integer startNo,Map<String,Object> extendMap) throws Exception {
        if (file == null) {
            throw new Exception("未获取到上传文件");
        }
        String originalFilename = file.getOriginalFilename();
        if (originalFilename.lastIndexOf(".xls") == -1) {
            throw new Exception("只能上传excel文件");
        }
        List<Map> excelData;
        try (InputStream is = file.getInputStream()) {
            excelData = ExcelReadUtil.readExcel(is, originalFilename, columnkeys, 0, Integer.valueOf(startNo), null, null, extendMap);
        } catch (Exception e) {
            logger.error("excel解析失败", e);
            throw new Exception("excel数据解析失败");
        }


        return excelData ;
    }

    @RequestMapping( "a11T01039Action!importData.do")
    public String importData(@RequestPart("theFile") MultipartFile theFile) throws Exception {
        if (theFile == null) {
            throw new Exception("未获取到上传文件");
        }
        String originalFilename = theFile.getOriginalFilename();
        if (originalFilename.lastIndexOf(".xls") == -1) {
            throw new Exception("只能上传excel文件");
        }
        List<String> columnKeys = Stream.of("caa600", "aae003", "aqk009","qlysf").collect(Collectors.toList());
        Map<String,Object> extendMap = new HashMap<>();
        extendMap.put("aae140","210");

        ExcelParseRest excelParseRest = new ExcelParseRest();
        List<Map> maps = excelParseRest.parseExcelComm(theFile, columnKeys, 1, extendMap);
       return null;
    }


}
