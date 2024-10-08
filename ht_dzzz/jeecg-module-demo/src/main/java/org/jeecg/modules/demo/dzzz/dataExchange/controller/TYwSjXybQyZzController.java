package org.jeecg.modules.demo.dzzz.dataExchange.controller;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.modules.demo.dzzz.dataExchange.entity.TYwSjXybQyZz;
import org.jeecg.modules.demo.dzzz.dataExchange.service.ITYwSjXybQyZzService;

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
 * @Description: t_yw_sj_xyb_qy_zz
 * @Author: jeecg-boot
 * @Date:   2024-09-23
 * @Version: V1.0
 */
@Api(tags="t_yw_sj_xyb_qy_zz")
@RestController
@RequestMapping("/dataExchange/tYwSjXybQyZz")
@Slf4j
public class TYwSjXybQyZzController extends JeecgController<TYwSjXybQyZz, ITYwSjXybQyZzService> {
	@Autowired
	private ITYwSjXybQyZzService tYwSjXybQyZzService;
	
	/**
	 * 分页列表查询
	 *
	 * @param tYwSjXybQyZz
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "t_yw_sj_xyb_qy_zz-分页列表查询")
	@ApiOperation(value="t_yw_sj_xyb_qy_zz-分页列表查询", notes="t_yw_sj_xyb_qy_zz-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<TYwSjXybQyZz>> queryPageList(TYwSjXybQyZz tYwSjXybQyZz,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<TYwSjXybQyZz> queryWrapper = QueryGenerator.initQueryWrapper(tYwSjXybQyZz, req.getParameterMap());
		Page<TYwSjXybQyZz> page = new Page<TYwSjXybQyZz>(pageNo, pageSize);
		IPage<TYwSjXybQyZz> pageList = tYwSjXybQyZzService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param tYwSjXybQyZz
	 * @return
	 */
	@AutoLog(value = "t_yw_sj_xyb_qy_zz-添加")
	@ApiOperation(value="t_yw_sj_xyb_qy_zz-添加", notes="t_yw_sj_xyb_qy_zz-添加")
	@RequiresPermissions("dataExchange:t_yw_sj_xyb_qy_zz:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody TYwSjXybQyZz tYwSjXybQyZz) {
		tYwSjXybQyZzService.save(tYwSjXybQyZz);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param tYwSjXybQyZz
	 * @return
	 */
	@AutoLog(value = "t_yw_sj_xyb_qy_zz-编辑")
	@ApiOperation(value="t_yw_sj_xyb_qy_zz-编辑", notes="t_yw_sj_xyb_qy_zz-编辑")
	@RequiresPermissions("dataExchange:t_yw_sj_xyb_qy_zz:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody TYwSjXybQyZz tYwSjXybQyZz) {
		tYwSjXybQyZzService.updateById(tYwSjXybQyZz);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "t_yw_sj_xyb_qy_zz-通过id删除")
	@ApiOperation(value="t_yw_sj_xyb_qy_zz-通过id删除", notes="t_yw_sj_xyb_qy_zz-通过id删除")
	@RequiresPermissions("dataExchange:t_yw_sj_xyb_qy_zz:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		tYwSjXybQyZzService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "t_yw_sj_xyb_qy_zz-批量删除")
	@ApiOperation(value="t_yw_sj_xyb_qy_zz-批量删除", notes="t_yw_sj_xyb_qy_zz-批量删除")
	@RequiresPermissions("dataExchange:t_yw_sj_xyb_qy_zz:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.tYwSjXybQyZzService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "t_yw_sj_xyb_qy_zz-通过id查询")
	@ApiOperation(value="t_yw_sj_xyb_qy_zz-通过id查询", notes="t_yw_sj_xyb_qy_zz-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<TYwSjXybQyZz> queryById(@RequestParam(name="id",required=true) String id) {
		TYwSjXybQyZz tYwSjXybQyZz = tYwSjXybQyZzService.getById(id);
		if(tYwSjXybQyZz==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(tYwSjXybQyZz);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param tYwSjXybQyZz
    */
    @RequiresPermissions("dataExchange:t_yw_sj_xyb_qy_zz:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, TYwSjXybQyZz tYwSjXybQyZz) {
        return super.exportXls(request, tYwSjXybQyZz, TYwSjXybQyZz.class, "t_yw_sj_xyb_qy_zz");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("dataExchange:t_yw_sj_xyb_qy_zz:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, TYwSjXybQyZz.class);
    }

}
