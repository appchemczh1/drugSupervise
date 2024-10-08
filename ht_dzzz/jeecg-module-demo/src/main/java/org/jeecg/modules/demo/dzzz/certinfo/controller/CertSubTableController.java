package org.jeecg.modules.demo.dzzz.certinfo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertSubTable;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertSubTableService;
import org.jeecg.modules.demo.dzzz.util.CertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>Created by Raofeicheng on 2024/8/26.</p>
 * @author Raofeicheng
 * @version 1.0
 */
@Api(tags = "电子证照-子表接口")
@RestController
@RequestMapping("/dzzz/certSubTable/{urlAbbr}")
@Slf4j
public class CertSubTableController {

	@ApiOperation(value = "分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<CertSubTable>> queryPageList(@PathVariable("urlAbbr") String urlAbbr,
													 @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
													 @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
													 HttpServletRequest req) {
		CertUtils.CertSubTableEnum subTableEnum = getSubTableEnum(urlAbbr);
		QueryWrapper<CertSubTable> query = createQuery(subTableEnum, null, req);
		IPage<CertSubTable> page = service.page(subTableEnum, req.getParameter("zt"), new Page<>(pageNo, pageSize), query);
		return Result.OK(page);
	}

	@ApiOperation(value = "列表查询")
	@GetMapping(value = "/listAll")
	public Result<List<CertSubTable>> queryList(@PathVariable("urlAbbr") String urlAbbr, HttpServletRequest req) {
		CertUtils.CertSubTableEnum subTableEnum = getSubTableEnum(urlAbbr);
		QueryWrapper<CertSubTable> query = createQuery(subTableEnum, null, req);
		List<CertSubTable> list = service.list(subTableEnum, req.getParameter("zt"), query);
		return Result.ok(list);
	}

	protected QueryWrapper<CertSubTable> createQuery(CertUtils.CertSubTableEnum subTableEnum, QueryWrapper<CertSubTable> query, HttpServletRequest req) {
		if (null == query) query = new QueryWrapper<>();
		String str = req.getParameter("zsid");
		query.eq(StringUtils.isNotBlank(str), "ZSID", str);
		str = req.getParameter("xzspid");
		query.eq(StringUtils.isNotBlank(str), "XZSPID", str);
		if (StringUtils.isNotBlank(subTableEnum.getOrderBy()))
			query.orderByAsc(subTableEnum.getOrderBy());
		return query;
	}

	public CertUtils.CertSubTableEnum getSubTableEnum(String urlAbbr) {
		return CertUtils.CertSubTableEnum.byAbbr(urlAbbr);
	}

	@Autowired
	public CertSubTableController(ICertSubTableService service) {
		this.service = service;
	}

	protected ICertSubTableService service;

}
