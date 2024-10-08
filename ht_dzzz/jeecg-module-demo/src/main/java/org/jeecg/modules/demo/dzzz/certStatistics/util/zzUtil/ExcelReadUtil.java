package org.jeecg.modules.demo.dzzz.certStatistics.util.zzUtil;


import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.*;

import static org.apache.poi.ss.usermodel.CellType.BLANK;

/**
 * @author classmateZhou
 * @date 2023-06-14
 * Description: excel解析工具类
 */


public class ExcelReadUtil {

    private static final String XLS = "xls";
    private static final String XLSX = "xlsx";
    private static Logger logger =  LoggerFactory.getLogger(ExcelReadUtil.class);
   private static final int CELL_TYPE_NUMERIC = 0;
   private static final int CELL_TYPE_STRING = 1;
   private static final int CELL_TYPE_FORMULA = 2;
   private static final int CELL_TYPE_BLANK = 3;
   private static final int CELL_TYPE_BOOLEAN = 4;
   private static final int CELL_TYPE_ERROR = 5;

    /**
     * 读取Excel文件内容
     * @param inputStream  Excel文件流
     * @param fileName 要读取的Excel文件名称
     * @param fieldNames Excel文件头部字段集，比如："loginId,name,sex"
     * @param sheetNum 工作表号，从0开始
     * @param rowNum 开始行号，从0开始
     * @param rowEnd 结束行号，默认最后一行
     * @param colNum 列号，从0开始
     * @param extendMap 需要放置到每一行数据里的额外参数
     * @return 读取结果列表，读取失败时返回null
     */
    public static List<Map> readExcel(InputStream inputStream, String fileName, List<String> fieldNames, Integer sheetNum, Integer rowNum, Integer rowEnd, Integer colNum, Map<String,Object> extendMap) throws Exception {

        try {
            //获取workbook
            Workbook workbook = WorkbookFactory.create(inputStream);
            List<Map> resultDataList = null;
            if(workbook != null){
                // 读取excel中的数据
                // 解析sheet
                //初始化数据
                sheetNum = sheetNum == null ? 0 : sheetNum;
                //获取sheet
                Sheet sheet = workbook.getSheetAt(sheetNum);
                resultDataList = parseExcel(sheet, fieldNames,rowNum,rowEnd,colNum,extendMap);
            }


            return resultDataList;
        } catch (Exception e) {
            logger.error("excel解析失败",e);
            throw e;
        } finally {
            try {
                if (null != inputStream) {
                    inputStream.close();
                }
            } catch (Exception e) {
                logger.error("关闭数据流出错！错误信息：" + e.getMessage());
            }
        }
    }




    /**
     * 解析Excel数据
     * @param sheet sheet页对象
     * @param fieldNames Excel文件头部字段集，比如："loginId,name,sex"
     * @param rowNum 开始行号，从0开始
     * @param rowEnd 结束行号，默认最后一行(负数则表示最后一行往前几行)
     * @param colNum 列号，从0开始
     * @param extendMap 需要放置到每一行数据里的额外参数
     * @return 解析结果
     */
    private static List<Map> parseExcel(Sheet sheet, List<String> fieldNames,  Integer rowNum, Integer rowEnd, Integer colNum,Map extendMap) throws IllegalAccessException, InstantiationException {

        rowNum = rowNum == null ? 0 : rowNum;
        colNum = colNum == null ? 0 : colNum;
        fieldNames = fieldNames == null ? new ArrayList<>() : fieldNames;
        List<Map> resultDataList = new ArrayList<>();

        // 校验sheet是否合法
        if (sheet == null) {
            return resultDataList;
        }
        rowEnd = rowEnd == null ? sheet.getPhysicalNumberOfRows() : rowEnd ;
        for (int r = rowNum; r <= rowEnd; r ++) {
            Row row = sheet.getRow(r);
            if (null == row) {
                continue;
            }
            Map resultData = convertRowToData(row,colNum,fieldNames,extendMap);
            //业务需求当有一行空数据时不再处理后续数据
            if (ValidateUtil.isEmpty(resultData)) {
                logger.error("第 " + row.getRowNum() + "行数据不合法，已终止后续数据解析！");
                break;
            }
            resultDataList.add(resultData);
        }
        return resultDataList;
    }

    /**
     * 提取每一行中需要的数据，根据字段集合构造成为一个结果数据对象
     * 当该行中有单元格的数据为空或不合法时，忽略该行的数据
     *
     * @param row 行数据
     * @param colNum 起始行号
     * @param fieldNames 字段集合
     * @param extendMap 需要额外放置到每一列的数据
     * @return 解析后的行数据对象，行数据错误时返回null
     */
    private static Map convertRowToData(Row row, Integer colNum, List<String> fieldNames,Map extendMap) {
        Map resultData = new HashMap();
        int colNums = fieldNames.size();
        Cell cell;
        int a =0;
        for(int c = 0 ; c < colNums ; c++){
            cell = row.getCell(colNum+c);
            String aaa = "";
            if((cell == null) || (cell.getCellType()==(BLANK))){
                a++;
            }
            if("aac040".equals(fieldNames.get(c))){
                resultData.put(fieldNames.get(c),convertCellValueToString(cell,fieldNames.get(c)));
            }else{
                resultData.put(fieldNames.get(c),convertCellValueToString(cell));
            }
        }
        if(!ValidateUtil.isEmpty(extendMap)){
            resultData.putAll(extendMap);
        }
        if(colNums == a){
            return null;
        }else{
            return resultData;
        }
    }
    /**
     * 将单元格内容转换为字符串
     * @param cell 数据
     * @return
     */
    private static String convertCellValueToString(Cell cell) {
        if(cell==null){
            return null;
        }
        String returnValue = null;
        switch (cell.getCellType()) {
            case NUMERIC:
                if(HSSFDateUtil.isCellDateFormatted(cell)){
                    Date date = cell.getDateCellValue();
                    returnValue = DateFormatUtils.format(date,"yyyy-MM-dd");
                }else{
                    //数字
                    Double doubleValue = cell.getNumericCellValue();

                    // 格式化科学计数法，取一位整数
                    DecimalFormat df = new DecimalFormat("0");
                    returnValue = df.format(doubleValue);
                }
                break;
            case STRING:
                //字符串
                returnValue = ValidateUtil.isEmpty(cell.getStringCellValue()) ? "" : cell.getStringCellValue().trim();
                break;
            case BOOLEAN:
                //布尔
                boolean booleanValue = cell.getBooleanCellValue();
                returnValue = Boolean.toString(booleanValue);
                break;
            case BLANK:
                // 空值
                break;
            case FORMULA:
                // 公式
                returnValue = cell.getCellFormula();
                break;
            case ERROR:
                // 故障
                break;
            default:
                break;
        }
        return returnValue;
    }

    private static String convertCellValueToString(Cell cell,String columnName) {
        if(cell==null){
            return null;
        }
        String returnValue = null;
        switch (cell.getCellType()) {
             case NUMERIC:
                if(HSSFDateUtil.isCellDateFormatted(cell)){
                    Date date = cell.getDateCellValue();
                    returnValue = DateFormatUtils.format(date,"yyyy-MM-dd");
                }else{
                    //数字
                    Double doubleValue = cell.getNumericCellValue();
                    if("aac040".equals(columnName)){
                        return doubleValue.toString();
                    }
                    // 格式化科学计数法，取一位整数
                    DecimalFormat df = new DecimalFormat("0");
                    returnValue = df.format(doubleValue);
                }
                break;
            case STRING:
                //字符串
                returnValue = ValidateUtil.isEmpty(cell.getStringCellValue()) ? "" : cell.getStringCellValue().trim();
                break;
            case BOOLEAN:
                //布尔
                boolean booleanValue = cell.getBooleanCellValue();
                returnValue = Boolean.toString(booleanValue);
                break;
            case BLANK:
                // 空值
                break;
            case FORMULA:
                // 公式
                returnValue = cell.getCellFormula();
                break;
            case ERROR:
                // 故障
                break;
            default:
                break;
        }
        return returnValue;
    }
    /**
     * 根据文件后缀名类型获取对应的工作簿对象
     * @param inputStream 读取文件的输入流
     * @param fileName 文件名称
     * @return 包含文件数据的工作簿对象
     * @throws IOException
     */
    private static Workbook getWorkbook(InputStream inputStream, String fileName) throws IOException {
        // 获取Excel后缀名
        String fileType = fileName.substring(fileName.lastIndexOf('.') + 1, fileName.length());
        Workbook workbook = null;
        if (fileType.equalsIgnoreCase(XLS)) {
            workbook = new HSSFWorkbook(inputStream);
        } else if (fileType.equalsIgnoreCase(XLSX)) {
            workbook = new XSSFWorkbook(inputStream);
        }
        return workbook;
    }
}
