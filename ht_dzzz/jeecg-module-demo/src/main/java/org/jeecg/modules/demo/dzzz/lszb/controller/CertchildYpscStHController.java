package org.jeecg.modules.demo.dzzz.lszb.controller;

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
import org.jeecg.modules.demo.dzzz.lszb.entity.CertchildYpscStH;
import org.jeecg.modules.demo.dzzz.lszb.service.ICertchildYpscStHService;

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
 * @Description: certchild_ypsc_st_h
 * @Author: jeecg-boot
 * @Date:   2024-07-03
 * @Version: V1.0
 */
@Api(tags="certchild_ypsc_st_h")
@RestController
@RequestMapping("/dzzz.lszb/certchildYpscStH")
@Slf4j
public class CertchildYpscStHController extends JeecgController<CertchildYpscStH, ICertchildYpscStHService> {
	@Autowired
	private ICertchildYpscStHService certchildYpscStHService;
	
	/**
	 * 分页列表查询
	 *
	 * @param certchildYpscStH
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "certchild_ypsc_st_h-分页列表查询")
	@ApiOperation(value="certchild_ypsc_st_h-分页列表查询", notes="certchild_ypsc_st_h-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<CertchildYpscStH>> queryPageList(CertchildYpscStH certchildYpscStH,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<CertchildYpscStH> queryWrapper = QueryGenerator.initQueryWrapper(certchildYpscStH, req.getParameterMap());
		Page<CertchildYpscStH> page = new Page<CertchildYpscStH>(pageNo, pageSize);
		IPage<CertchildYpscStH> pageList = certchildYpscStHService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param certchildYpscStH
	 * @return
	 */
	@AutoLog(value = "certchild_ypsc_st_h-添加")
	@ApiOperation(value="certchild_ypsc_st_h-添加", notes="certchild_ypsc_st_h-添加")
	@RequiresPermissions("dzzz.lszb:certchild_ypsc_st_h:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody CertchildYpscStH certchildYpscStH) {
		certchildYpscStHService.save(certchildYpscStH);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param certchildYpscStH
	 * @return
	 */
	@AutoLog(value = "certchild_ypsc_st_h-编辑")
	@ApiOperation(value="certchild_ypsc_st_h-编辑", notes="certchild_ypsc_st_h-编辑")
	@RequiresPermissions("dzzz.lszb:certchild_ypsc_st_h:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody CertchildYpscStH certchildYpscStH) {
		certchildYpscStHService.updateById(certchildYpscStH);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "certchild_ypsc_st_h-通过id删除")
	@ApiOperation(value="certchild_ypsc_st_h-通过id删除", notes="certchild_ypsc_st_h-通过id删除")
	@RequiresPermissions("dzzz.lszb:certchild_ypsc_st_h:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		certchildYpscStHService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "certchild_ypsc_st_h-批量删除")
	@ApiOperation(value="certchild_ypsc_st_h-批量删除", notes="certchild_ypsc_st_h-批量删除")
	@RequiresPermissions("dzzz.lszb:certchild_ypsc_st_h:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.certchildYpscStHService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "certchild_ypsc_st_h-通过id查询")
	@ApiOperation(value="certchild_ypsc_st_h-通过id查询", notes="certchild_ypsc_st_h-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<CertchildYpscStH> queryById(@RequestParam(name="id",required=true) String id) {
		CertchildYpscStH certchildYpscStH = certchildYpscStHService.getById(id);
		if(certchildYpscStH==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(certchildYpscStH);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param certchildYpscStH
    */
    @RequiresPermissions("dzzz.lszb:certchild_ypsc_st_h:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, CertchildYpscStH certchildYpscStH) {
        return super.exportXls(request, certchildYpscStH, CertchildYpscStH.class, "certchild_ypsc_st_h");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("dzzz.lszb:certchild_ypsc_st_h:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, CertchildYpscStH.class);
    }

}
