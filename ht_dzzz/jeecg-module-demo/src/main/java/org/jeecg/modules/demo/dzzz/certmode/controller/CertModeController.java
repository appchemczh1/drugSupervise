package org.jeecg.modules.demo.dzzz.certmode.controller;

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
import org.jeecg.modules.demo.dzzz.certmode.entity.CertMode;
import org.jeecg.modules.demo.dzzz.certmode.service.ICertModeService;

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
 * @Description: 证书模板
 * @Author: jeecg-boot
 * @Date:   2024-03-20
 * @Version: V1.0
 */
@Api(tags="证书模板")
@RestController
@RequestMapping("/dzzz.certmode/certMode")
@Slf4j
public class CertModeController extends JeecgController<CertMode, ICertModeService> {
	@Autowired
	private ICertModeService certModeService;
	
	/**
	 * 分页列表查询
	 *
	 * @param certMode
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "证书模板-分页列表查询")
	@ApiOperation(value="证书模板-分页列表查询", notes="证书模板-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<CertMode>> queryPageList(CertMode certMode,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<CertMode> queryWrapper = QueryGenerator.initQueryWrapper(certMode, req.getParameterMap());
		Page<CertMode> page = new Page<CertMode>(pageNo, pageSize);
		IPage<CertMode> pageList = certModeService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param certMode
	 * @return
	 */
	@AutoLog(value = "证书模板-添加")
	@ApiOperation(value="证书模板-添加", notes="证书模板-添加")
/*
	@RequiresPermissions("dzzz.certmode:cert_mode:add")
*/
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody CertMode certMode) {
		/*certMode.setFjpostX(certMode.getFjpostY()+","+certMode.getFjpostY());
		certMode.setPostLeft1(certMode.getPostleftX1()+","+certMode.getPostLeft1());
		certMode.setPostLeft2(certMode.getPostleftX2()+","+certMode.getPostLeft2());
		certMode.setPostLeft3(certMode.getPostleftX3()+","+certMode.getPostLeft3());
		certMode.setPostLeft4(certMode.getPostleftX4()+","+certMode.getPostLeft4());
		certMode.setPostRight1(certMode.getPostrightX1()+","+certMode.getPostRight1());
		certMode.setPostRight2(certMode.getPostrightX2()+","+certMode.getPostRight2());
		certMode.setPostRight3(certMode.getPostrightX3()+","+certMode.getPostRight3());
		certMode.setPostRight4(certMode.getPostrightX4()+","+certMode.getPostRight4());*/

		certModeService.save(certMode);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param certMode
	 * @return
	 */
	@AutoLog(value = "证书模板-编辑")
	@ApiOperation(value="证书模板-编辑", notes="证书模板-编辑")
/*
	@RequiresPermissions("dzzz.certmode:cert_mode:edit")
*/
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody CertMode certMode) {
		certModeService.updateById(certMode);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "证书模板-通过id删除")
	@ApiOperation(value="证书模板-通过id删除", notes="证书模板-通过id删除")
/*
	@RequiresPermissions("dzzz.certmode:cert_mode:delete")
*/
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		certModeService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "证书模板-批量删除")
	@ApiOperation(value="证书模板-批量删除", notes="证书模板-批量删除")
/*
	@RequiresPermissions("dzzz.certmode:cert_mode:deleteBatch")
*/
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.certModeService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "证书模板-通过id查询")
	@ApiOperation(value="证书模板-通过id查询", notes="证书模板-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<CertMode> queryById(@RequestParam(name="id",required=true) String id) {
		CertMode certMode = certModeService.getById(id);
		if(certMode==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(certMode);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param certMode
    */
/*
    @RequiresPermissions("dzzz.certmode:cert_mode:exportXls")
*/
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, CertMode certMode) {
        return super.exportXls(request, certMode, CertMode.class, "证书模板");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
/*
    @RequiresPermissions("dzzz.certmode:cert_mode:importExcel")
*/
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, CertMode.class);
    }

}
