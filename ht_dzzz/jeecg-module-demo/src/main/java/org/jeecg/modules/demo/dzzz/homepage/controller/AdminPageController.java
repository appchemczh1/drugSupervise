package org.jeecg.modules.demo.dzzz.homepage.controller;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.jeecg.modules.demo.dzzz.homepage.service.IAdminPageService;
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
@RequestMapping("/dzzz.homepage/adminpage")
@Slf4j
public class AdminPageController extends JeecgController<Zslxtj, IZslxtjService> {

	@javax.annotation.Resource
	ResourceLoader resourceLoader;
	@Autowired
	private IAdminPageService adminPageService;
	Map<String,String> queryMap = new HashMap<>();


	@PostMapping(value = "/stampCase")
	public Result<Map> queryPageList(HttpServletRequest request){
		queryMap = new HashMap<>();
		Map resultMap = new HashMap();
		Map<String,String[]> requestParameterMap =   request.getParameterMap();

		for(Map.Entry<String,String[]> entry:requestParameterMap.entrySet()){
			queryMap.put(entry.getKey(),entry.getValue()[0]);
		}
		if(ValidateUtil.isNotEmpty(queryMap.get("rq[0]"))){
			queryMap.put("startTime",queryMap.get("rq[0]"));
			queryMap.put("endTime",queryMap.get("rq[1]"));

		}
		//todo：查询待盖章情况
		 resultMap = adminPageService.getDgz();


		return Result.ok(resultMap);

	}
	@PostMapping(value = "/stampWarnList")
	public Result<Map> stampWarnList(HttpServletRequest request){
		queryMap = new HashMap<>();
		Map resultMap = new HashMap();
		Map<String,String[]> requestParameterMap =   request.getParameterMap();

		for(Map.Entry<String,String[]> entry:requestParameterMap.entrySet()){
			queryMap.put(entry.getKey(),entry.getValue()[0]);
		}
		if(ValidateUtil.isNotEmpty(queryMap.get("rq[0]"))){
			queryMap.put("startTime",queryMap.get("rq[0]"));
			queryMap.put("endTime",queryMap.get("rq[1]"));

		}
		resultMap = adminPageService.getstampWarnList();


		return Result.ok(resultMap);

	}




	@PostMapping(value = "/stampDistribution")
	public Result<Map> stampDistribution(HttpServletRequest request){
		queryMap = new HashMap<>();
		Map resultMap = new HashMap();
		Map<String,String[]> requestParameterMap =   request.getParameterMap();

		for(Map.Entry<String,String[]> entry:requestParameterMap.entrySet()){
			queryMap.put(entry.getKey(),entry.getValue()[0]);
		}
		if(ValidateUtil.isNotEmpty(queryMap.get("rq[0]"))){
			queryMap.put("startTime",queryMap.get("rq[0]"));
			queryMap.put("endTime",queryMap.get("rq[1]"));

		}
		//todo：查询证书分布
		resultMap = adminPageService.getZsfb();

		return Result.ok(resultMap);

	}


//查询证书排名
	@PostMapping(value = "/stampRank")
	public Result<Map> stampRank(HttpServletRequest request){
		queryMap = new HashMap<>();
		Map resultMap = new HashMap();
		Map<String,String[]> requestParameterMap =   request.getParameterMap();

		for(Map.Entry<String,String[]> entry:requestParameterMap.entrySet()){
			queryMap.put(entry.getKey(),entry.getValue()[0]);
		}
		if(ValidateUtil.isNotEmpty(queryMap.get("rq[0]"))){
			queryMap.put("startTime",queryMap.get("rq[0]"));
			queryMap.put("endTime",queryMap.get("rq[1]"));

		}
		//todo：查询待盖章情况
		resultMap = adminPageService.getStampRank();
		return Result.ok(resultMap);

	}


	@GetMapping(value = "/getinfo")
	public Result<Map> getinfo(HttpServletRequest request){
		queryMap = new HashMap<>();
		Map resultMap = new HashMap();
		Map<String,String[]> requestParameterMap =   request.getParameterMap();

		for(Map.Entry<String,String[]> entry:requestParameterMap.entrySet()){
			queryMap.put(entry.getKey(),entry.getValue()[0]);
		}
		if(ValidateUtil.isNotEmpty(queryMap.get("rq[0]"))){
			queryMap.put("startTime",queryMap.get("rq[0]"));
			queryMap.put("endTime",queryMap.get("rq[1]"));

		}
		String name = "";
		if(ValidateUtil.isNotEmpty(queryMap.get("name"))){
			name = queryMap.get("name");
		}
		//todo：查询待盖章情况
		resultMap = adminPageService.getinfo(name);
		return Result.ok(resultMap);

	}



//企业总览
	@PostMapping(value = "/firmInfo")
	public Result<Map> firmInfo(HttpServletRequest request){
		queryMap = new HashMap<>();
		Map resultMap = new HashMap();
		Map<String,String[]> requestParameterMap =   request.getParameterMap();

		for(Map.Entry<String,String[]> entry:requestParameterMap.entrySet()){
			queryMap.put(entry.getKey(),entry.getValue()[0]);
		}
		if(ValidateUtil.isNotEmpty(queryMap.get("rq[0]"))){
			queryMap.put("startTime",queryMap.get("rq[0]"));
			queryMap.put("endTime",queryMap.get("rq[1]"));

		}
		//todo：查询待盖章情况
		resultMap = adminPageService.getFirmInfo();
		return Result.ok(resultMap);

	}

//证书总览
	@PostMapping(value = "/stampInfo")
	public Result<Map> stampInfo(HttpServletRequest request){
		queryMap = new HashMap<>();
		Map resultMap = new HashMap();
		Map<String,String[]> requestParameterMap =   request.getParameterMap();

		for(Map.Entry<String,String[]> entry:requestParameterMap.entrySet()){
			queryMap.put(entry.getKey(),entry.getValue()[0]);
		}
		if(ValidateUtil.isNotEmpty(queryMap.get("rq[0]"))){
			queryMap.put("startTime",queryMap.get("rq[0]"));
			queryMap.put("endTime",queryMap.get("rq[1]"));

		}
		//todo：查询待盖章情况
		resultMap = adminPageService.stampInfo();
		return Result.ok(resultMap);

	}





}
