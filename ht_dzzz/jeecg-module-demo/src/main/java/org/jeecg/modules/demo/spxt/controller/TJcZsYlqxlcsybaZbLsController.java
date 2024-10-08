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
import org.jeecg.modules.demo.spxt.entity.TJcZsYlqxlcsybaZbLs;
import org.jeecg.modules.demo.spxt.service.ITJcZsYlqxlcsybaZbLsService;

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
 * @Description: t_jc_zs_ylqxlcsyba_zb_ls
 * @Author: jeecg-boot
 * @Date:   2024-06-20
 * @Version: V1.0
 */
@Api(tags="t_jc_zs_ylqxlcsyba_zb_ls")
@RestController
@RequestMapping("/spxt/tJcZsYlqxlcsybaZbLs")
@Slf4j
public class TJcZsYlqxlcsybaZbLsController extends JeecgController<TJcZsYlqxlcsybaZbLs, ITJcZsYlqxlcsybaZbLsService> {
	@Autowired
	private ITJcZsYlqxlcsybaZbLsService tJcZsYlqxlcsybaZbLsService;
	
	/**
	 * 分页列表查询
	 *
	 * @param tJcZsYlqxlcsybaZbLs
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "t_jc_zs_ylqxlcsyba_zb_ls-分页列表查询")
	@ApiOperation(value="t_jc_zs_ylqxlcsyba_zb_ls-分页列表查询", notes="t_jc_zs_ylqxlcsyba_zb_ls-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<TJcZsYlqxlcsybaZbLs>> queryPageList(TJcZsYlqxlcsybaZbLs tJcZsYlqxlcsybaZbLs,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<TJcZsYlqxlcsybaZbLs> queryWrapper = QueryGenerator.initQueryWrapper(tJcZsYlqxlcsybaZbLs, req.getParameterMap());
		Page<TJcZsYlqxlcsybaZbLs> page = new Page<TJcZsYlqxlcsybaZbLs>(pageNo, pageSize);
		IPage<TJcZsYlqxlcsybaZbLs> pageList = tJcZsYlqxlcsybaZbLsService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param tJcZsYlqxlcsybaZbLs
	 * @return
	 */
	@AutoLog(value = "t_jc_zs_ylqxlcsyba_zb_ls-添加")
	@ApiOperation(value="t_jc_zs_ylqxlcsyba_zb_ls-添加", notes="t_jc_zs_ylqxlcsyba_zb_ls-添加")
	@RequiresPermissions("spxt:t_jc_zs_ylqxlcsyba_zb_ls:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody TJcZsYlqxlcsybaZbLs tJcZsYlqxlcsybaZbLs) {
		tJcZsYlqxlcsybaZbLsService.save(tJcZsYlqxlcsybaZbLs);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param tJcZsYlqxlcsybaZbLs
	 * @return
	 */
	@AutoLog(value = "t_jc_zs_ylqxlcsyba_zb_ls-编辑")
	@ApiOperation(value="t_jc_zs_ylqxlcsyba_zb_ls-编辑", notes="t_jc_zs_ylqxlcsyba_zb_ls-编辑")
	@RequiresPermissions("spxt:t_jc_zs_ylqxlcsyba_zb_ls:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody TJcZsYlqxlcsybaZbLs tJcZsYlqxlcsybaZbLs) {
		tJcZsYlqxlcsybaZbLsService.updateById(tJcZsYlqxlcsybaZbLs);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "t_jc_zs_ylqxlcsyba_zb_ls-通过id删除")
	@ApiOperation(value="t_jc_zs_ylqxlcsyba_zb_ls-通过id删除", notes="t_jc_zs_ylqxlcsyba_zb_ls-通过id删除")
	@RequiresPermissions("spxt:t_jc_zs_ylqxlcsyba_zb_ls:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		tJcZsYlqxlcsybaZbLsService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "t_jc_zs_ylqxlcsyba_zb_ls-批量删除")
	@ApiOperation(value="t_jc_zs_ylqxlcsyba_zb_ls-批量删除", notes="t_jc_zs_ylqxlcsyba_zb_ls-批量删除")
	@RequiresPermissions("spxt:t_jc_zs_ylqxlcsyba_zb_ls:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.tJcZsYlqxlcsybaZbLsService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "t_jc_zs_ylqxlcsyba_zb_ls-通过id查询")
	@ApiOperation(value="t_jc_zs_ylqxlcsyba_zb_ls-通过id查询", notes="t_jc_zs_ylqxlcsyba_zb_ls-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<TJcZsYlqxlcsybaZbLs> queryById(@RequestParam(name="id",required=true) String id) {
		TJcZsYlqxlcsybaZbLs tJcZsYlqxlcsybaZbLs = tJcZsYlqxlcsybaZbLsService.getById(id);
		if(tJcZsYlqxlcsybaZbLs==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(tJcZsYlqxlcsybaZbLs);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param tJcZsYlqxlcsybaZbLs
    */
    @RequiresPermissions("spxt:t_jc_zs_ylqxlcsyba_zb_ls:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, TJcZsYlqxlcsybaZbLs tJcZsYlqxlcsybaZbLs) {
        return super.exportXls(request, tJcZsYlqxlcsybaZbLs, TJcZsYlqxlcsybaZbLs.class, "t_jc_zs_ylqxlcsyba_zb_ls");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("spxt:t_jc_zs_ylqxlcsyba_zb_ls:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, TJcZsYlqxlcsybaZbLs.class);
    }

}
