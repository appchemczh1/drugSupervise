package org.jeecg.modules.demo.dzzz.certInfoOperation.controller;

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
import org.jeecg.modules.demo.dzzz.certInfoOperation.entity.CertInfoOperationDetail;
import org.jeecg.modules.demo.dzzz.certInfoOperation.service.ICertInfoOperationDetailService;

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
 * @Description: 操作详情表
 * @Author: jeecg-boot
 * @Date:   2024-04-17
 * @Version: V1.0
 */
@Api(tags="操作详情表")
@RestController
@RequestMapping("/dzzz/certInfoOperationDetail")
@Slf4j
public class CertInfoOperationDetailController extends JeecgController<CertInfoOperationDetail, ICertInfoOperationDetailService> {
	@Autowired
	private ICertInfoOperationDetailService certInfoOperationDetailService;
	
	/**
	 * 分页列表查询
	 *
	 * @param certInfoOperationDetail
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "操作详情表-分页列表查询")
	@ApiOperation(value="操作详情表-分页列表查询", notes="操作详情表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<CertInfoOperationDetail>> queryPageList(CertInfoOperationDetail certInfoOperationDetail,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<CertInfoOperationDetail> queryWrapper = QueryGenerator.initQueryWrapper(certInfoOperationDetail, req.getParameterMap());

		Page<CertInfoOperationDetail> page = new Page<CertInfoOperationDetail>(pageNo, pageSize);
		IPage<CertInfoOperationDetail> pageList = certInfoOperationDetailService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param certInfoOperationDetail
	 * @return
	 */
	@AutoLog(value = "操作详情表-添加")
	@ApiOperation(value="操作详情表-添加", notes="操作详情表-添加")
//	@RequiresPermissions("dzzz:cert_info_operation_detail:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody CertInfoOperationDetail certInfoOperationDetail) {
		certInfoOperationDetailService.save(certInfoOperationDetail);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param certInfoOperationDetail
	 * @return
	 */
	@AutoLog(value = "操作详情表-编辑")
	@ApiOperation(value="操作详情表-编辑", notes="操作详情表-编辑")
//	@RequiresPermissions("dzzz:cert_info_operation_detail:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody CertInfoOperationDetail certInfoOperationDetail) {
		certInfoOperationDetailService.updateById(certInfoOperationDetail);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "操作详情表-通过id删除")
	@ApiOperation(value="操作详情表-通过id删除", notes="操作详情表-通过id删除")
//	@RequiresPermissions("dzzz:cert_info_operation_detail:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		certInfoOperationDetailService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "操作详情表-批量删除")
	@ApiOperation(value="操作详情表-批量删除", notes="操作详情表-批量删除")
//	@RequiresPermissions("dzzz:cert_info_operation_detail:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.certInfoOperationDetailService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "操作详情表-通过id查询")
	@ApiOperation(value="操作详情表-通过id查询", notes="操作详情表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<CertInfoOperationDetail> queryById(@RequestParam(name="id",required=true) String id) {
		CertInfoOperationDetail certInfoOperationDetail = certInfoOperationDetailService.getById(id);
		if(certInfoOperationDetail==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(certInfoOperationDetail);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param certInfoOperationDetail
    */
//    @RequiresPermissions("dzzz:cert_info_operation_detail:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, CertInfoOperationDetail certInfoOperationDetail) {
        return super.exportXls(request, certInfoOperationDetail, CertInfoOperationDetail.class, "操作详情表");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
//    @RequiresPermissions("dzzz:cert_info_operation_detail:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, CertInfoOperationDetail.class);
    }

}
