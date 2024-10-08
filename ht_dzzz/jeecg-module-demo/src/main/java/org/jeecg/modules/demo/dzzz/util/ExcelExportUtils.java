package org.jeecg.modules.demo.dzzz.util;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * POI导出工具
 * 2024.08.16
 */
public class ExcelExportUtils {


    /**
     * 导出excel
     * @param workbook
     * @param sheetName
     * @param headers 头部标题
     * @param excelFields 自定义表头
     * @param dataList 数据
     * @return
     * @param <T>
     * @throws IOException
     * @throws IllegalAccessException
     */
    public static<T> Workbook exportToExcel(Workbook workbook, String sheetName, List<String> headers, List<String> excelFields, List<T> dataList) throws IOException, IllegalAccessException {
        if (workbook == null) {
            workbook = new HSSFWorkbook();
        }
        Sheet sheet = workbook.createSheet(sheetName); //创建sheet
        // 创建表头
        Row headerRow = sheet.createRow(0);
        // 创建表格样式
        HSSFCellStyle style = (HSSFCellStyle) workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        HSSFFont font = (HSSFFont) workbook.createFont();
        font.setBold(true); // 设置字体加粗
        style.setFont(font); // 将字体应用到样式中
        for (int i = 0; i < headers.size(); i++) {
            Cell headerCell = headerRow.createCell(i);
            headerCell.setCellValue(headers.get(i));
            headerCell.setCellStyle(style);
        }

        // 填充数据
        int rowNum = 1;
        if(CollectionUtils.isNotEmpty(dataList)) {
            for (T rowData : dataList) {
                Row row = sheet.createRow(rowNum);
                // 获取对象的属性集合
                Field[] fields = rowData.getClass().getDeclaredFields();

                for (int i = 0; i < excelFields.size(); i++) {
                    String filedName = excelFields.get(i);
                    Field findField = Arrays.stream(fields).filter(field -> filedName.equals(field.getName())).findFirst().orElse(null);
                    if (findField != null) {
                        findField.setAccessible(true);
                        Object object = findField.get(rowData);
                        String val = object != null ? String.valueOf(object) : "";
                        row.createCell(i).setCellValue(val);
                    } else {
                        row.createCell(i).setCellValue("");
                    }
                }
                rowNum++;
            }
        }
        return workbook;
    }


}
