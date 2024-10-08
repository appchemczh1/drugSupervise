package org.jeecg.modules.demo.dzzz.certStatistics.controller;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecg.modules.demo.dzzz.certStatistics.entity.Qylxtj;
import org.jeecg.modules.demo.dzzz.certStatistics.entity.Zslxtj;
import org.jeecg.modules.demo.dzzz.certStatistics.service.IQylxtjService;
import org.jeecg.modules.demo.dzzz.certStatistics.service.IZslxtjService;
import org.jeecg.modules.demo.dzzz.certStatistics.util.zzUtil.JsonUtil;
import org.jeecg.modules.demo.dzzz.certStatistics.util.zzUtil.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.*;


@RestController
@RequestMapping("/dzzz.certStatistics/qylxtj")
@Slf4j
public class QylxtjController extends JeecgController<Zslxtj, IZslxtjService> {

	@javax.annotation.Resource
	ResourceLoader resourceLoader;
	@Autowired
	private IQylxtjService qylxtjService;
	Map<String,String> queryMap = new HashMap<>();


	@GetMapping(value = "/tjList")
	public Result<List<Map<String, Integer>>> queryPageList(HttpServletRequest request){
		queryMap = new HashMap<>();
		Map<String,String[]> requestParameterMap =   request.getParameterMap();

		for(Map.Entry<String,String[]> entry:requestParameterMap.entrySet()){
			queryMap.put(entry.getKey(),entry.getValue()[0]);
		}
		if(ValidateUtil.isNotEmpty(queryMap.get("rq[0]"))){
			queryMap.put("startTime",queryMap.get("rq[0]"));
			queryMap.put("endTime",queryMap.get("rq[1]"));

		}
		List<Qylxtj>  list=  qylxtjService.selectQylxtjList(queryMap);
		List<Map<String, Integer>>	 resultList = qylxtjService.ProcessData(list);
		return Result.ok(resultList);

	}

	@GetMapping(value = "/export")
	public Result<Object> exportEX(HttpServletResponse response, HttpServletRequest request, @RequestParam Map<String,Object> map) throws IOException, URISyntaxException, ParseException {
		List<Map> list = JsonUtil.jsonArr2List(map.get("List").toString(), Map.class);
		if(ValidateUtil.isEmpty(list)){
			return Result.error("导出数据不存在");
		}
		if(ValidateUtil.isEmpty(map.get("jzrq"))){
			return Result.error("截止日期不存在");
		}
		String rq =appendCurrentTime(map.get("jzrq").toString()) ;
		String pathName = "统计两品一械.xlsx";
		Resource realpath = resourceLoader.getResource("classpath:/file/统计两品一械.xlsx");
		String fileName = "统计两品一械.xlsx";
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

				CellStyle cellStyleCenter = workbook.createCellStyle();
				cellStyleCenter.setBorderTop(BorderStyle.THIN);
				cellStyleCenter.setBorderRight(BorderStyle.THIN);
				cellStyleCenter.setBorderBottom(BorderStyle.THIN);
				cellStyleCenter.setBorderLeft(BorderStyle.THIN);
				cellStyleCenter.setAlignment(HorizontalAlignment.CENTER);
				cellStyleCenter.setVerticalAlignment(VerticalAlignment.CENTER);
				cellStyleCenter.setWrapText(true);
				cellStyleCenter.setFont(headfont);

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
				row1.getCell(0).setCellValue( "统计截止时间："+rq);
				row1.getCell(15).setCellValue("单位：张");
				int startnum = 4;
				int count = startnum;
				for (Map<String, Object> map1 : list) {
					XSSFRow row = sheet.createRow(count);
					for (int i = 0; i < 17; i++) {
						row.createCell(i).setCellStyle(cellStyleCenter);
					}
					row.getCell(0).setCellValue(convertQhdm(map1.get("xzqh")));
					row.getCell(1).setCellValue(map1.get("ypschfsyp") != null ? map1.get("ypschfsyp").toString() : "");
					row.getCell(2).setCellValue(map1.get("ylzj") != null ? map1.get("ylzj").toString() : "");
					row.getCell(3).setCellValue(map1.get("ypjypf") != null ? map1.get("ypjypf").toString() : "");
					row.getCell(4).setCellValue(map1.get("ypjylszb") != null ? map1.get("ypjylszb").toString() : "");
					row.getCell(5).setCellValue(map1.get("ypjylsmd") != null ? map1.get("ypjylsmd").toString() : "");
					row.getCell(6).setCellValue(map1.get("ypjyls") != null ? map1.get("ypjyls").toString() : "");
					row.getCell(7).setCellValue(map1.get("fsxypjy") != null ? map1.get("fsxypjy").toString() : "");
					row.getCell(8).setCellValue(map1.get("fsxypsy") != null ? map1.get("fsxypsy").toString() : "");
					row.getCell(9).setCellValue(map1.get("xj1") != null ? map1.get("xj1").toString() : "");
					row.getCell(10).setCellValue(map1.get("ylylqxba") != null ? map1.get("ylylqxba").toString() : "");
					row.getCell(11).setCellValue(map1.get("rslylqx") != null ? map1.get("rslylqx").toString() : "");
					row.getCell(12).setCellValue(map1.get("slylqxpf") != null ? map1.get("slylqxpf").toString() : "");
					row.getCell(13).setCellValue(map1.get("slylqxls") != null ? map1.get("slylqxls").toString() : "");
					row.getCell(14).setCellValue(map1.get("xj2") != null ? map1.get("xj2").toString() : "");
					row.getCell(15).setCellValue(map1.get("hzpsc") != null ? map1.get("hzpsc").toString() : "");
					row.getCell(16).setCellValue(map1.get("zj") != null ? map1.get("zj").toString() : "");
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


	public static double processBigDecimal(BigDecimal input) {
		if (input == null) {
			return 0.0;
		} else {
			return input.doubleValue();
		}
	}


	public String convertQhdm(Object code){
		Map<String, String> xzqhDict = new HashMap<>();
		xzqhDict.put("1", "武汉市");
		xzqhDict.put("2", "黄石市");
		xzqhDict.put("3", "十堰市");
		xzqhDict.put("4", "宜昌市");
		xzqhDict.put("5", "襄阳市");
		xzqhDict.put("6", "鄂州市");
		xzqhDict.put("7", "荆门市");
		xzqhDict.put("8", "孝感市");
		xzqhDict.put("9", "荆州市");
		xzqhDict.put("10", "黄冈市");
		xzqhDict.put("11", "咸宁市");
		xzqhDict.put("12", "随州市");
		xzqhDict.put("13", "恩施市");
		xzqhDict.put("14", "仙桃市");
		xzqhDict.put("15", "潜江市");
		xzqhDict.put("16", "天门市");
		xzqhDict.put("17", "神农架");
		xzqhDict.put("18", "合计");
		String xzqhCode = code.toString();
		String xzqhValue = "";
		if (xzqhCode != null && xzqhDict.containsKey(xzqhCode)) {
			xzqhValue = xzqhDict.get(xzqhCode);
		}
		return xzqhValue;
	}
	public static String convertDate(String dateStr) throws ParseException {
		// 定义输入的日期格式
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
		// 解析日期字符串
		Date date = inputFormat.parse(dateStr);

		// 定义输出的日期格式
		SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy年M月d日");
		// 格式化日期
		return outputFormat.format(date);
	}

	public static String appendCurrentTime(String dateStr) {
		// 获取当前时间
		LocalDateTime now = LocalDateTime.now();

		// 定义日期时间格式
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(" HH:mm:ss");

		// 格式化当前时间
		String currentTime = now.format(timeFormatter);

		// 将当前时间拼接到日期字符串后面
		return dateStr + currentTime;
	}




}
