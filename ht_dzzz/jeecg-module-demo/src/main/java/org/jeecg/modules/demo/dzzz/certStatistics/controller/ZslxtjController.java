package org.jeecg.modules.demo.dzzz.certStatistics.controller;




import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.jeecg.common.api.vo.Result;
import org.jeecg.modules.demo.dzzz.certStatistics.entity.Zslxtj;
import org.jeecg.modules.demo.dzzz.certStatistics.service.IZslxtjService;




import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecg.modules.demo.dzzz.certStatistics.util.zzUtil.JsonUtil;
import org.jeecg.modules.demo.dzzz.certStatistics.util.zzUtil.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.jeecg.modules.demo.dzzz.certStatistics.controller.QylxtjController.convertDate;


@RestController
@RequestMapping("/dzzz.certStatistics/zslxtj")
@Slf4j
public class ZslxtjController extends JeecgController<Zslxtj, IZslxtjService> {
	@Autowired
	private IZslxtjService zslxtjService;

	@javax.annotation.Resource
	ResourceLoader resourceLoader;

	@GetMapping(value = "/tjList")
	public Result<List<Zslxtj>> queryPageList(@RequestParam(name="yxqq" ) String startTime,
											  @RequestParam(name="yxqz") String endTime,
											  HttpServletRequest req){
		List<Zslxtj>  list=  zslxtjService.selectZslxtjList(startTime,endTime);
		return Result.ok(list);
	}


	@PostMapping(value = "/export")
	public Result<Object> exportEX(HttpServletResponse response, HttpServletRequest request, @RequestBody Map<String,Object> map) throws IOException, URISyntaxException, ParseException {
		List<Map> list = JsonUtil.jsonArr2List(map.get("List").toString(), Map.class);

		String jzrq = "";
		if(ValidateUtil.isEmpty(list)){
			return Result.error("导出数据不存在");
		}
		if(ValidateUtil.isEmpty(map.get("jzrq"))){
			LocalDateTime now = LocalDateTime.now();

			// 定义日期时间格式
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

			// 格式化日期时间
			 jzrq = now.format(formatter);
		}else {
			jzrq=convertDate(map.get("jzrq").toString()) ;
		}
		String pathName = "证书类型统计.xlsx";
		Resource realpath = resourceLoader.getResource("classpath:/file/证书类型统计.xlsx");
		String fileName = "证书类型统计.xlsx";
		String CONTENT_TYPE = "application/vnd.ms-excel"; // 更新此处的MIME类型
		fileName = new String(fileName.getBytes("GBK"), "ISO-8859-1");
//		response.setContentType(CONTENT_TYPE);
//		String fileName = URLEncoder.encode("统计两品一械.xlsx", "UTF-8");
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-disposition", "attachment; fileName=" + fileName);
		response.setHeader("Access-Control-Allow-Origin", "*"); // 确保跨域请求允许
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Expose-Headers", "Content-Disposition"); // 确保前端能获取到这个头部

		if (!realpath.exists()) {
			throw new FileNotFoundException("文件不存在");
		} else {
			try (XSSFWorkbook workbook = new XSSFWorkbook(realpath.getInputStream());
				 OutputStream outputStream = response.getOutputStream()) {
				XSSFFont headfont = workbook.createFont();
				headfont.setFontName("仿宋_GB2312");
				headfont.setFontHeightInPoints((short) 12);
//除去第一列的下面的单元格的样式
				CellStyle cellStyleCenter = workbook.createCellStyle();
				cellStyleCenter.setBorderTop(BorderStyle.THIN);
				cellStyleCenter.setBorderRight(BorderStyle.THIN);
				cellStyleCenter.setBorderBottom(BorderStyle.THIN);
				cellStyleCenter.setBorderLeft(BorderStyle.THIN);
				cellStyleCenter.setAlignment(HorizontalAlignment.CENTER);
				cellStyleCenter.setVerticalAlignment(VerticalAlignment.CENTER);
				cellStyleCenter.setWrapText(true);
				cellStyleCenter.setFont(headfont);


//单独设置第一列的左对齐样式
				CellStyle cellStyleLeft = workbook.createCellStyle();
				cellStyleLeft.setBorderTop(BorderStyle.THIN);
				cellStyleLeft.setBorderRight(BorderStyle.THIN);
				cellStyleLeft.setBorderBottom(BorderStyle.THIN);
				cellStyleLeft.setBorderLeft(BorderStyle.THIN);
				cellStyleLeft.setAlignment(HorizontalAlignment.LEFT); // 左对齐
				cellStyleLeft.setVerticalAlignment(VerticalAlignment.CENTER);
				cellStyleLeft.setWrapText(true);
				cellStyleLeft.setFont(headfont);

				CellStyle style = workbook.createCellStyle();
				style.setBorderTop(BorderStyle.THIN);
				style.setBorderRight(BorderStyle.THIN);
				style.setBorderBottom(BorderStyle.THIN);
				style.setBorderLeft(BorderStyle.THIN);
				style.setAlignment(HorizontalAlignment.CENTER);
				style.setVerticalAlignment(VerticalAlignment.CENTER);
				style.setWrapText(true);
				style.setFont(headfont);

				CreationHelper createHelper = workbook.getCreationHelper();
				style.setDataFormat(createHelper.createDataFormat().getFormat("yyyy-mm-dd"));


				XSSFSheet sheet = workbook.getSheetAt(0);
				XSSFRow row1 = sheet.createRow(1);
				// 检查并移除现有的合并区域
				int numMergedRegions = sheet.getNumMergedRegions();
				for (int i = 0; i < numMergedRegions; i++) {
					CellRangeAddress mergedRegion = sheet.getMergedRegion(i);
					if (mergedRegion.getFirstRow() == 1 && mergedRegion.getLastRow() == 1 &&
							mergedRegion.getFirstColumn() == 0 && mergedRegion.getLastColumn() == 4) {
						sheet.removeMergedRegion(i);
						break; // 假设每个区域只会被合并一次
					}
				}
				sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 4));
//				sheet.addMergedRegion(new CellRangeAddress(1, 1, 15, 16));
				XSSFCellStyle cellStyle = workbook.createCellStyle();
				cellStyle.setAlignment(HorizontalAlignment.CENTER);// 水平居中
				cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);// 垂直居中
				XSSFFont headfont2 = workbook.createFont();
				headfont2.setFontName("黑体");
				headfont2.setFontHeightInPoints((short) 12);// 字体大小
				cellStyle.setFont(headfont2);
				for (int i = 0; i < 20; i++) {
					row1.createCell(i);
					row1.getCell(i).setCellStyle(cellStyle);
				}
				row1.getCell(0).setCellValue( "统计截止时间："+jzrq);
				row1.getCell(15).setCellValue("单位：张");
				int startnum = 3;
				int count = startnum;
				for (Map<String, Object> map1 : list) {
					XSSFRow row = sheet.createRow(count);
					for (int i = 0; i < 20; i++) {
						if(i==0){
							//对第一列设置左对齐
							row.createCell(i).setCellStyle(cellStyleLeft);
						}else {
							row.createCell(i).setCellStyle(cellStyleCenter);
						}


					}
					row.getCell(0).setCellValue(map1.get("zsmc") != null ? map1.get("zsmc").toString() : "");
					row.getCell(1).setCellValue(map1.get("sbNum") != null ? map1.get("sbNum").toString() : "");
					row.getCell(2).setCellValue(map1.get("whNum") != null ? map1.get("whNum").toString() : "");
					row.getCell(3).setCellValue(map1.get("hsNum") != null ? map1.get("hsNum").toString() : "");
					row.getCell(4).setCellValue(map1.get("syNum") != null ? map1.get("syNum").toString() : "");
					row.getCell(5).setCellValue(map1.get("ycNum") != null ? map1.get("ycNum").toString() : "");
					row.getCell(6).setCellValue(map1.get("xyNum") != null ? map1.get("xyNum").toString() : "");
					row.getCell(7).setCellValue(map1.get("ezNum") != null ? map1.get("ezNum").toString() : "");
					row.getCell(8).setCellValue(map1.get("jmNum") != null ? map1.get("jmNum").toString() : "");
					row.getCell(9).setCellValue(map1.get("xgNum") != null ? map1.get("xgNum").toString() : "");
					row.getCell(10).setCellValue(map1.get("jzNum") != null ? map1.get("jzNum").toString() : "");
					row.getCell(11).setCellValue(map1.get("hgNum") != null ? map1.get("hgNum").toString() : "");
					row.getCell(12).setCellValue(map1.get("xnNum") != null ? map1.get("xnNum").toString() : "");
					row.getCell(13).setCellValue(map1.get("szNum") != null ? map1.get("szNum").toString() : "");
					row.getCell(14).setCellValue(map1.get("esNum") != null ? map1.get("esNum").toString() : "");
					row.getCell(15).setCellValue(map1.get("xtNum") != null ? map1.get("xtNum").toString() : "");
					row.getCell(16).setCellValue(map1.get("qjNum") != null ? map1.get("qjNum").toString() : "");
					row.getCell(17).setCellValue(map1.get("tmNum") != null ? map1.get("tmNum").toString() : "");
					row.getCell(18).setCellValue(map1.get("snjNum") != null ? map1.get("snjNum").toString() : "");
					row.getCell(19).setCellValue(map1.get("totalNum") != null ? map1.get("totalNum").toString() : "");
					count++;
				}
				workbook.write(outputStream);
				outputStream.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}


}
