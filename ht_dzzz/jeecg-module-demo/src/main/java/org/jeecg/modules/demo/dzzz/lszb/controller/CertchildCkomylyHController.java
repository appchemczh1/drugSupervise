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
import org.jeecg.modules.demo.dzzz.lszb.entity.CertchildCkomylyH;
import org.jeecg.modules.demo.dzzz.lszb.service.ICertchildCkomylyHService;

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
 * @Description: certchild_ckomyly_h
 * @Author: jeecg-boot
 * @Date:   2024-07-03
 * @Version: V1.0
 */
@Api(tags="certchild_ckomyly_h")
@RestController
@RequestMapping("/dzzz.lszb/certchildCkomylyH")
@Slf4j
public class CertchildCkomylyHController extends JeecgController<CertchildCkomylyH, ICertchildCkomylyHService> {
	@Autowired
	private ICertchildCkomylyHService certchildCkomylyHService;
	
	/**
	 * 分页列表查询
	 *
	 * @param certchildCkomylyH
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "certchild_ckomyly_h-分页列表查询")
	@ApiOperation(value="certchild_ckomyly_h-分页列表查询", notes="certchild_ckomyly_h-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<CertchildCkomylyH>> queryPageList(CertchildCkomylyH certchildCkomylyH,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<CertchildCkomylyH> queryWrapper = QueryGenerator.initQueryWrapper(certchildCkomylyH, req.getParameterMap());
		Page<CertchildCkomylyH> page = new Page<CertchildCkomylyH>(pageNo, pageSize);
		IPage<CertchildCkomylyH> pageList = certchildCkomylyHService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param certchildCkomylyH
	 * @return
	 */
	@AutoLog(value = "certchild_ckomyly_h-添加")
	@ApiOperation(value="certchild_ckomyly_h-添加", notes="certchild_ckomyly_h-添加")
	@RequiresPermissions("dzzz.lszb:certchild_ckomyly_h:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody CertchildCkomylyH certchildCkomylyH) {
		certchildCkomylyHService.save(certchildCkomylyH);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param certchildCkomylyH
	 * @return
	 */
	@AutoLog(value = "certchild_ckomyly_h-编辑")
	@ApiOperation(value="certchild_ckomyly_h-编辑", notes="certchild_ckomyly_h-编辑")
	@RequiresPermissions("dzzz.lszb:certchild_ckomyly_h:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody CertchildCkomylyH certchildCkomylyH) {
		certchildCkomylyHService.updateById(certchildCkomylyH);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "certchild_ckomyly_h-通过id删除")
	@ApiOperation(value="certchild_ckomyly_h-通过id删除", notes="certchild_ckomyly_h-通过id删除")
	@RequiresPermissions("dzzz.lszb:certchild_ckomyly_h:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		certchildCkomylyHService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "certchild_ckomyly_h-批量删除")
	@ApiOperation(value="certchild_ckomyly_h-批量删除", notes="certchild_ckomyly_h-批量删除")
	@RequiresPermissions("dzzz.lszb:certchild_ckomyly_h:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.certchildCkomylyHService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "certchild_ckomyly_h-通过id查询")
	@ApiOperation(value="certchild_ckomyly_h-通过id查询", notes="certchild_ckomyly_h-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<CertchildCkomylyH> queryById(@RequestParam(name="id",required=true) String id) {
		CertchildCkomylyH certchildCkomylyH = certchildCkomylyHService.getById(id);
		if(certchildCkomylyH==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(certchildCkomylyH);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param certchildCkomylyH
    */
    @RequiresPermissions("dzzz.lszb:certchild_ckomyly_h:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, CertchildCkomylyH certchildCkomylyH) {
        return super.exportXls(request, certchildCkomylyH, CertchildCkomylyH.class, "certchild_ckomyly_h");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("dzzz.lszb:certchild_ckomyly_h:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, CertchildCkomylyH.class);
    }

}
