package org.jeecg.modules.demo.dzzz.certzminfo.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.demo.dzzz.certzminfo.entity.CertZminfo;
import org.jeecg.modules.demo.dzzz.certzminfo.service.ICertZminfoService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;

 /**
 * @Description: cert_zminfo
 * @Author: jeecg-boot
 * @Date:   2024-06-13
 * @Version: V1.0
 */
@Api(tags="cert_zminfo")
@RestController
@RequestMapping("/dzzz.certzminfo/certZminfo")
@Slf4j
public class CertZminfoController extends JeecgController<CertZminfo, ICertZminfoService> {
	@Autowired
	private ICertZminfoService certZminfoService;
	
	/**
	 * 分页列表查询
	 *
	 * @param certZminfo
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "cert_zminfo-分页列表查询")
	@ApiOperation(value="cert_zminfo-分页列表查询", notes="cert_zminfo-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<CertZminfo>> queryPageList(CertZminfo certZminfo,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<CertZminfo> queryWrapper = QueryGenerator.initQueryWrapper(certZminfo, req.getParameterMap());
		Page<CertZminfo> page = new Page<CertZminfo>(pageNo, pageSize);
		IPage<CertZminfo> pageList = certZminfoService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param certZminfo
	 * @return
	 */
	@AutoLog(value = "cert_zminfo-添加")
	@ApiOperation(value="cert_zminfo-添加", notes="cert_zminfo-添加")
	@RequiresPermissions("dzzz.certzminfo:cert_zminfo:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody CertZminfo certZminfo) {
		certZminfoService.save(certZminfo);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param certZminfo
	 * @return
	 */
	@AutoLog(value = "cert_zminfo-编辑")
	@ApiOperation(value="cert_zminfo-编辑", notes="cert_zminfo-编辑")
	@RequiresPermissions("dzzz.certzminfo:cert_zminfo:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody CertZminfo certZminfo) {
		certZminfoService.updateById(certZminfo);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "cert_zminfo-通过id删除")
	@ApiOperation(value="cert_zminfo-通过id删除", notes="cert_zminfo-通过id删除")
	@RequiresPermissions("dzzz.certzminfo:cert_zminfo:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		certZminfoService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "cert_zminfo-批量删除")
	@ApiOperation(value="cert_zminfo-批量删除", notes="cert_zminfo-批量删除")
	@RequiresPermissions("dzzz.certzminfo:cert_zminfo:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.certZminfoService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "cert_zminfo-通过id查询")
	@ApiOperation(value="cert_zminfo-通过id查询", notes="cert_zminfo-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<CertZminfo> queryById(@RequestParam(name="id",required=true) String id) {
		CertZminfo certZminfo = certZminfoService.getById(id);
		if(certZminfo==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(certZminfo);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param certZminfo
    */
    @RequiresPermissions("dzzz.certzminfo:cert_zminfo:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, CertZminfo certZminfo) {
        return super.exportXls(request, certZminfo, CertZminfo.class, "cert_zminfo");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("dzzz.certzminfo:cert_zminfo:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, CertZminfo.class);
    }

}
