package org.jeecg.modules.demo.spxt.controller;

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
import org.jeecg.modules.demo.spxt.entity.TYwZsCzjlLsN;
import org.jeecg.modules.demo.spxt.service.ITYwZsCzjlLsNService;

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
 * @Description: t_yw_zs_czjl_ls_n
 * @Author: jeecg-boot
 * @Date:   2024-06-20
 * @Version: V1.0
 */
@Api(tags="t_yw_zs_czjl_ls_n")
@RestController
@RequestMapping("/spxt/tYwZsCzjlLsN")
@Slf4j
public class TYwZsCzjlLsNController extends JeecgController<TYwZsCzjlLsN, ITYwZsCzjlLsNService> {
	@Autowired
	private ITYwZsCzjlLsNService tYwZsCzjlLsNService;
	
	/**
	 * 分页列表查询
	 *
	 * @param tYwZsCzjlLsN
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "t_yw_zs_czjl_ls_n-分页列表查询")
	@ApiOperation(value="t_yw_zs_czjl_ls_n-分页列表查询", notes="t_yw_zs_czjl_ls_n-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<TYwZsCzjlLsN>> queryPageList(TYwZsCzjlLsN tYwZsCzjlLsN,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<TYwZsCzjlLsN> queryWrapper = QueryGenerator.initQueryWrapper(tYwZsCzjlLsN, req.getParameterMap());
		Page<TYwZsCzjlLsN> page = new Page<TYwZsCzjlLsN>(pageNo, pageSize);
		IPage<TYwZsCzjlLsN> pageList = tYwZsCzjlLsNService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param tYwZsCzjlLsN
	 * @return
	 */
	@AutoLog(value = "t_yw_zs_czjl_ls_n-添加")
	@ApiOperation(value="t_yw_zs_czjl_ls_n-添加", notes="t_yw_zs_czjl_ls_n-添加")
	@RequiresPermissions("spxt:t_yw_zs_czjl_ls_n:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody TYwZsCzjlLsN tYwZsCzjlLsN) {
		tYwZsCzjlLsNService.save(tYwZsCzjlLsN);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param tYwZsCzjlLsN
	 * @return
	 */
	@AutoLog(value = "t_yw_zs_czjl_ls_n-编辑")
	@ApiOperation(value="t_yw_zs_czjl_ls_n-编辑", notes="t_yw_zs_czjl_ls_n-编辑")
	@RequiresPermissions("spxt:t_yw_zs_czjl_ls_n:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody TYwZsCzjlLsN tYwZsCzjlLsN) {
		tYwZsCzjlLsNService.updateById(tYwZsCzjlLsN);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "t_yw_zs_czjl_ls_n-通过id删除")
	@ApiOperation(value="t_yw_zs_czjl_ls_n-通过id删除", notes="t_yw_zs_czjl_ls_n-通过id删除")
	@RequiresPermissions("spxt:t_yw_zs_czjl_ls_n:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		tYwZsCzjlLsNService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "t_yw_zs_czjl_ls_n-批量删除")
	@ApiOperation(value="t_yw_zs_czjl_ls_n-批量删除", notes="t_yw_zs_czjl_ls_n-批量删除")
	@RequiresPermissions("spxt:t_yw_zs_czjl_ls_n:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.tYwZsCzjlLsNService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "t_yw_zs_czjl_ls_n-通过id查询")
	@ApiOperation(value="t_yw_zs_czjl_ls_n-通过id查询", notes="t_yw_zs_czjl_ls_n-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<TYwZsCzjlLsN> queryById(@RequestParam(name="id",required=true) String id) {
		TYwZsCzjlLsN tYwZsCzjlLsN = tYwZsCzjlLsNService.getById(id);
		if(tYwZsCzjlLsN==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(tYwZsCzjlLsN);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param tYwZsCzjlLsN
    */
    @RequiresPermissions("spxt:t_yw_zs_czjl_ls_n:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, TYwZsCzjlLsN tYwZsCzjlLsN) {
        return super.exportXls(request, tYwZsCzjlLsN, TYwZsCzjlLsN.class, "t_yw_zs_czjl_ls_n");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("spxt:t_yw_zs_czjl_ls_n:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, TYwZsCzjlLsN.class);
    }

}
