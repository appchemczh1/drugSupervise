package org.jeecg.modules.demo.dzzz.certzdgz.controller;

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
import org.jeecg.modules.demo.dzzz.certzdgz.entity.CertZdgz;
import org.jeecg.modules.demo.dzzz.certzdgz.service.ICertZdgzService;

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
 * @Description: 证书-自动盖章
 * @Author: jeecg-boot
 * @Date:   2024-04-03
 * @Version: V1.0
 */
@Api(tags="证书-自动盖章")
@RestController
@RequestMapping("/dzzz/certZdgz")
@Slf4j
public class CertZdgzController extends JeecgController<CertZdgz, ICertZdgzService> {
	@Autowired
	private ICertZdgzService certZdgzService;
	
	/**
	 * 分页列表查询
	 *
	 * @param certZdgz
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "证书-自动盖章-分页列表查询")
	@ApiOperation(value="证书-自动盖章-分页列表查询", notes="证书-自动盖章-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<CertZdgz>> queryPageList(CertZdgz certZdgz,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<CertZdgz> queryWrapper = QueryGenerator.initQueryWrapper(certZdgz, req.getParameterMap());
		Page<CertZdgz> page = new Page<CertZdgz>(pageNo, pageSize);
		IPage<CertZdgz> pageList = certZdgzService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param certZdgz
	 * @return
	 */
	@AutoLog(value = "证书-自动盖章-添加")
	@ApiOperation(value="证书-自动盖章-添加", notes="证书-自动盖章-添加")
	//@RequiresPermissions("dzzz:cert_zdgz:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody CertZdgz certZdgz) {
		certZdgzService.save(certZdgz);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param certZdgz
	 * @return
	 */
	@AutoLog(value = "证书-自动盖章-编辑")
	@ApiOperation(value="证书-自动盖章-编辑", notes="证书-自动盖章-编辑")
	//@RequiresPermissions("dzzz:cert_zdgz:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody CertZdgz certZdgz) {
		certZdgzService.updateById(certZdgz);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "证书-自动盖章-通过id删除")
	@ApiOperation(value="证书-自动盖章-通过id删除", notes="证书-自动盖章-通过id删除")
	//@RequiresPermissions("dzzz:cert_zdgz:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		certZdgzService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "证书-自动盖章-批量删除")
	@ApiOperation(value="证书-自动盖章-批量删除", notes="证书-自动盖章-批量删除")
	//@RequiresPermissions("dzzz:cert_zdgz:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.certZdgzService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "证书-自动盖章-通过id查询")
	@ApiOperation(value="证书-自动盖章-通过id查询", notes="证书-自动盖章-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<CertZdgz> queryById(@RequestParam(name="id",required=true) String id) {
		CertZdgz certZdgz = certZdgzService.getById(id);
		if(certZdgz==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(certZdgz);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param certZdgz
    */
    //@RequiresPermissions("dzzz:cert_zdgz:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, CertZdgz certZdgz) {
        return super.exportXls(request, certZdgz, CertZdgz.class, "证书-自动盖章");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("dzzz:cert_zdgz:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, CertZdgz.class);
    }

}
