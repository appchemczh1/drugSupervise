package org.jeecg.modules.demo.dzzz.dataExchange.controller;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.modules.demo.dzzz.dataExchange.entity.TYwSjXyb;
import org.jeecg.modules.demo.dzzz.dataExchange.service.ITYwSjXybService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;

 /**
 * @Description: t_yw_sj_xyb
 * @Author: jeecg-boot
 * @Date:   2024-07-29
 * @Version: V1.0
 */
@Api(tags="t_yw_sj_xyb")
@RestController
@RequestMapping("/xyb")
@Slf4j
public class TYwSjXybController extends JeecgController<TYwSjXyb, ITYwSjXybService> {
	@Autowired
	private ITYwSjXybService tYwSjXybService;
	
	/**
	 * 分页列表查询
	 *
	 * @param tYwSjXyb
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "t_yw_sj_xyb-分页列表查询")
	@ApiOperation(value="t_yw_sj_xyb-分页列表查询", notes="t_yw_sj_xyb-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<TYwSjXyb>> queryPageList(TYwSjXyb tYwSjXyb,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<TYwSjXyb> queryWrapper = QueryGenerator.initQueryWrapper(tYwSjXyb, req.getParameterMap());
		Page<TYwSjXyb> page = new Page<TYwSjXyb>(pageNo, pageSize);
		IPage<TYwSjXyb> pageList = tYwSjXybService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param tYwSjXyb
	 * @return
	 */
	@AutoLog(value = "t_yw_sj_xyb-添加")
	@ApiOperation(value="t_yw_sj_xyb-添加", notes="t_yw_sj_xyb-添加")
	@RequiresPermissions("org.jeecg.modules.demo.dzzz.dataExchange:t_yw_sj_xyb:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody TYwSjXyb tYwSjXyb) {
		tYwSjXybService.save(tYwSjXyb);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param tYwSjXyb
	 * @return
	 */
	@AutoLog(value = "t_yw_sj_xyb-编辑")
	@ApiOperation(value="t_yw_sj_xyb-编辑", notes="t_yw_sj_xyb-编辑")
	@RequiresPermissions("org.jeecg.modules.demo.dzzz.dataExchange:t_yw_sj_xyb:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody TYwSjXyb tYwSjXyb) {
		tYwSjXybService.updateById(tYwSjXyb);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "t_yw_sj_xyb-通过id删除")
	@ApiOperation(value="t_yw_sj_xyb-通过id删除", notes="t_yw_sj_xyb-通过id删除")
	@RequiresPermissions("org.jeecg.modules.demo.dzzz.dataExchange:t_yw_sj_xyb:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		tYwSjXybService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "t_yw_sj_xyb-批量删除")
	@ApiOperation(value="t_yw_sj_xyb-批量删除", notes="t_yw_sj_xyb-批量删除")
	@RequiresPermissions("org.jeecg.modules.demo.dzzz.dataExchange:t_yw_sj_xyb:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.tYwSjXybService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "t_yw_sj_xyb-通过id查询")
	@ApiOperation(value="t_yw_sj_xyb-通过id查询", notes="t_yw_sj_xyb-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<TYwSjXyb> queryById(@RequestParam(name="id",required=true) String id) {
		TYwSjXyb tYwSjXyb = tYwSjXybService.getById(id);
		if(tYwSjXyb==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(tYwSjXyb);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param tYwSjXyb
    */
    @RequiresPermissions("org.jeecg.modules.demo.dzzz.dataExchange:t_yw_sj_xyb:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, TYwSjXyb tYwSjXyb) {
        return super.exportXls(request, tYwSjXyb, TYwSjXyb.class, "t_yw_sj_xyb");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("org.jeecg.modules.demo.dzzz.dataExchange:t_yw_sj_xyb:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, TYwSjXyb.class);
    }

}
