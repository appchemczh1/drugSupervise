package org.jeecg.modules.demo.dzzz.certdzyzpz.controller;

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
import org.jeecg.modules.demo.dzzz.certdzyzpz.entity.CertDzyzpz;
import org.jeecg.modules.demo.dzzz.certdzyzpz.service.ICertDzyzpzService;

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
 * @Description: 证书_电子印章配置
 * @Author: jeecg-boot
 * @Date:   2024-04-02
 * @Version: V1.0
 */
@Api(tags="证书_电子印章配置")
@RestController
@RequestMapping("/dzzz/certDzyzpz")
@Slf4j
public class CertDzyzpzController extends JeecgController<CertDzyzpz, ICertDzyzpzService> {
	@Autowired
	private ICertDzyzpzService certDzyzpzService;
	
	/**
	 * 分页列表查询
	 *
	 * @param certDzyzpz
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "证书_电子印章配置-分页列表查询")
	@ApiOperation(value="证书_电子印章配置-分页列表查询", notes="证书_电子印章配置-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<CertDzyzpz>> queryPageList(CertDzyzpz certDzyzpz,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<CertDzyzpz> queryWrapper = QueryGenerator.initQueryWrapper(certDzyzpz, req.getParameterMap());
		Page<CertDzyzpz> page = new Page<CertDzyzpz>(pageNo, pageSize);
		IPage<CertDzyzpz> pageList = certDzyzpzService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param certDzyzpz
	 * @return
	 */
	@AutoLog(value = "证书_电子印章配置-添加")
	@ApiOperation(value="证书_电子印章配置-添加", notes="证书_电子印章配置-添加")
	//@RequiresPermissions("dzzz:cert_dzyzpz:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody CertDzyzpz certDzyzpz) {
		certDzyzpzService.save(certDzyzpz);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param certDzyzpz
	 * @return
	 */
	@AutoLog(value = "证书_电子印章配置-编辑")
	@ApiOperation(value="证书_电子印章配置-编辑", notes="证书_电子印章配置-编辑")
	//@RequiresPermissions("dzzz:cert_dzyzpz:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody CertDzyzpz certDzyzpz) {
		certDzyzpzService.updateById(certDzyzpz);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "证书_电子印章配置-通过id删除")
	@ApiOperation(value="证书_电子印章配置-通过id删除", notes="证书_电子印章配置-通过id删除")
	//@RequiresPermissions("dzzz:cert_dzyzpz:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		certDzyzpzService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "证书_电子印章配置-批量删除")
	@ApiOperation(value="证书_电子印章配置-批量删除", notes="证书_电子印章配置-批量删除")
	//@RequiresPermissions("dzzz:cert_dzyzpz:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.certDzyzpzService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "证书_电子印章配置-通过id查询")
	@ApiOperation(value="证书_电子印章配置-通过id查询", notes="证书_电子印章配置-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<CertDzyzpz> queryById(@RequestParam(name="id",required=true) String id) {
		CertDzyzpz certDzyzpz = certDzyzpzService.getById(id);
		if(certDzyzpz==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(certDzyzpz);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param certDzyzpz
    */
    @RequiresPermissions("dzzz:cert_dzyzpz:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, CertDzyzpz certDzyzpz) {
        return super.exportXls(request, certDzyzpz, CertDzyzpz.class, "证书_电子印章配置");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("dzzz:cert_dzyzpz:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, CertDzyzpz.class);
    }

}
