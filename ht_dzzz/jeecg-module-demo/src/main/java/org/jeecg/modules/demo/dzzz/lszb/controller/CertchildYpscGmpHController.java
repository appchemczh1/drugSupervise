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
import org.jeecg.modules.demo.dzzz.lszb.entity.CertchildYpscGmpH;
import org.jeecg.modules.demo.dzzz.lszb.service.ICertchildYpscGmpHService;

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
 * @Description: certchild_ypsc_gmp_h
 * @Author: jeecg-boot
 * @Date:   2024-07-03
 * @Version: V1.0
 */
@Api(tags="certchild_ypsc_gmp_h")
@RestController
@RequestMapping("/dzzz.lszb/certchildYpscGmpH")
@Slf4j
public class CertchildYpscGmpHController extends JeecgController<CertchildYpscGmpH, ICertchildYpscGmpHService> {
	@Autowired
	private ICertchildYpscGmpHService certchildYpscGmpHService;
	
	/**
	 * 分页列表查询
	 *
	 * @param certchildYpscGmpH
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "certchild_ypsc_gmp_h-分页列表查询")
	@ApiOperation(value="certchild_ypsc_gmp_h-分页列表查询", notes="certchild_ypsc_gmp_h-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<CertchildYpscGmpH>> queryPageList(CertchildYpscGmpH certchildYpscGmpH,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<CertchildYpscGmpH> queryWrapper = QueryGenerator.initQueryWrapper(certchildYpscGmpH, req.getParameterMap());
		Page<CertchildYpscGmpH> page = new Page<CertchildYpscGmpH>(pageNo, pageSize);
		IPage<CertchildYpscGmpH> pageList = certchildYpscGmpHService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param certchildYpscGmpH
	 * @return
	 */
	@AutoLog(value = "certchild_ypsc_gmp_h-添加")
	@ApiOperation(value="certchild_ypsc_gmp_h-添加", notes="certchild_ypsc_gmp_h-添加")
	@RequiresPermissions("dzzz.lszb:certchild_ypsc_gmp_h:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody CertchildYpscGmpH certchildYpscGmpH) {
		certchildYpscGmpHService.save(certchildYpscGmpH);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param certchildYpscGmpH
	 * @return
	 */
	@AutoLog(value = "certchild_ypsc_gmp_h-编辑")
	@ApiOperation(value="certchild_ypsc_gmp_h-编辑", notes="certchild_ypsc_gmp_h-编辑")
	@RequiresPermissions("dzzz.lszb:certchild_ypsc_gmp_h:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody CertchildYpscGmpH certchildYpscGmpH) {
		certchildYpscGmpHService.updateById(certchildYpscGmpH);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "certchild_ypsc_gmp_h-通过id删除")
	@ApiOperation(value="certchild_ypsc_gmp_h-通过id删除", notes="certchild_ypsc_gmp_h-通过id删除")
	@RequiresPermissions("dzzz.lszb:certchild_ypsc_gmp_h:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		certchildYpscGmpHService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "certchild_ypsc_gmp_h-批量删除")
	@ApiOperation(value="certchild_ypsc_gmp_h-批量删除", notes="certchild_ypsc_gmp_h-批量删除")
	@RequiresPermissions("dzzz.lszb:certchild_ypsc_gmp_h:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.certchildYpscGmpHService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "certchild_ypsc_gmp_h-通过id查询")
	@ApiOperation(value="certchild_ypsc_gmp_h-通过id查询", notes="certchild_ypsc_gmp_h-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<CertchildYpscGmpH> queryById(@RequestParam(name="id",required=true) String id) {
		CertchildYpscGmpH certchildYpscGmpH = certchildYpscGmpHService.getById(id);
		if(certchildYpscGmpH==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(certchildYpscGmpH);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param certchildYpscGmpH
    */
    @RequiresPermissions("dzzz.lszb:certchild_ypsc_gmp_h:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, CertchildYpscGmpH certchildYpscGmpH) {
        return super.exportXls(request, certchildYpscGmpH, CertchildYpscGmpH.class, "certchild_ypsc_gmp_h");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("dzzz.lszb:certchild_ypsc_gmp_h:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, CertchildYpscGmpH.class);
    }

}
