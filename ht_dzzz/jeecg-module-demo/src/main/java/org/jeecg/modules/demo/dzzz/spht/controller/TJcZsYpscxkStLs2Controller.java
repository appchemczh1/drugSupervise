package org.jeecg.modules.demo.dzzz.spht.controller;

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
import org.jeecg.modules.demo.dzzz.spht.entity.TJcZsYpscxkStLs2;
import org.jeecg.modules.demo.dzzz.spht.service.ITJcZsYpscxkStLs2Service;

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
 * @Description: t_jc_zs_ypscxk_st_ls2
 * @Author: jeecg-boot
 * @Date:   2024-08-01
 * @Version: V1.0
 */
@Api(tags="t_jc_zs_ypscxk_st_ls2")
@RestController
@RequestMapping("/dzzz.spht/tJcZsYpscxkStLs2")
@Slf4j
public class TJcZsYpscxkStLs2Controller extends JeecgController<TJcZsYpscxkStLs2, ITJcZsYpscxkStLs2Service> {
	@Autowired
	private ITJcZsYpscxkStLs2Service tJcZsYpscxkStLs2Service;
	
	/**
	 * 分页列表查询
	 *
	 * @param tJcZsYpscxkStLs2
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "t_jc_zs_ypscxk_st_ls2-分页列表查询")
	@ApiOperation(value="t_jc_zs_ypscxk_st_ls2-分页列表查询", notes="t_jc_zs_ypscxk_st_ls2-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<TJcZsYpscxkStLs2>> queryPageList(TJcZsYpscxkStLs2 tJcZsYpscxkStLs2,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<TJcZsYpscxkStLs2> queryWrapper = QueryGenerator.initQueryWrapper(tJcZsYpscxkStLs2, req.getParameterMap());
		Page<TJcZsYpscxkStLs2> page = new Page<TJcZsYpscxkStLs2>(pageNo, pageSize);
		IPage<TJcZsYpscxkStLs2> pageList = tJcZsYpscxkStLs2Service.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param tJcZsYpscxkStLs2
	 * @return
	 */
	@AutoLog(value = "t_jc_zs_ypscxk_st_ls2-添加")
	@ApiOperation(value="t_jc_zs_ypscxk_st_ls2-添加", notes="t_jc_zs_ypscxk_st_ls2-添加")
	@RequiresPermissions("dzzz.spht:t_jc_zs_ypscxk_st_ls2:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody TJcZsYpscxkStLs2 tJcZsYpscxkStLs2) {
		tJcZsYpscxkStLs2Service.save(tJcZsYpscxkStLs2);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param tJcZsYpscxkStLs2
	 * @return
	 */
	@AutoLog(value = "t_jc_zs_ypscxk_st_ls2-编辑")
	@ApiOperation(value="t_jc_zs_ypscxk_st_ls2-编辑", notes="t_jc_zs_ypscxk_st_ls2-编辑")
	@RequiresPermissions("dzzz.spht:t_jc_zs_ypscxk_st_ls2:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody TJcZsYpscxkStLs2 tJcZsYpscxkStLs2) {
		tJcZsYpscxkStLs2Service.updateById(tJcZsYpscxkStLs2);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "t_jc_zs_ypscxk_st_ls2-通过id删除")
	@ApiOperation(value="t_jc_zs_ypscxk_st_ls2-通过id删除", notes="t_jc_zs_ypscxk_st_ls2-通过id删除")
	@RequiresPermissions("dzzz.spht:t_jc_zs_ypscxk_st_ls2:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		tJcZsYpscxkStLs2Service.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "t_jc_zs_ypscxk_st_ls2-批量删除")
	@ApiOperation(value="t_jc_zs_ypscxk_st_ls2-批量删除", notes="t_jc_zs_ypscxk_st_ls2-批量删除")
	@RequiresPermissions("dzzz.spht:t_jc_zs_ypscxk_st_ls2:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.tJcZsYpscxkStLs2Service.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "t_jc_zs_ypscxk_st_ls2-通过id查询")
	@ApiOperation(value="t_jc_zs_ypscxk_st_ls2-通过id查询", notes="t_jc_zs_ypscxk_st_ls2-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<TJcZsYpscxkStLs2> queryById(@RequestParam(name="id",required=true) String id) {
		TJcZsYpscxkStLs2 tJcZsYpscxkStLs2 = tJcZsYpscxkStLs2Service.getById(id);
		if(tJcZsYpscxkStLs2==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(tJcZsYpscxkStLs2);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param tJcZsYpscxkStLs2
    */
    @RequiresPermissions("dzzz.spht:t_jc_zs_ypscxk_st_ls2:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, TJcZsYpscxkStLs2 tJcZsYpscxkStLs2) {
        return super.exportXls(request, tJcZsYpscxkStLs2, TJcZsYpscxkStLs2.class, "t_jc_zs_ypscxk_st_ls2");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("dzzz.spht:t_jc_zs_ypscxk_st_ls2:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, TJcZsYpscxkStLs2.class);
    }

}
