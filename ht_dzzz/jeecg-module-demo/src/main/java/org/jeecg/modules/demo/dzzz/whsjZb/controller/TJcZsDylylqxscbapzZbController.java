package org.jeecg.modules.demo.dzzz.whsjZb.controller;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.modules.demo.dzzz.whsjZb.entity.TJcZsDylylqxscbapzZb;
import org.jeecg.modules.demo.dzzz.whsjZb.service.ITJcZsDylylqxscbapzZbService;

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
 * @Description: t_jc_zs_dylylqxscbapz_zb
 * @Author: jeecg-boot
 * @Date:   2024-08-30
 * @Version: V1.0
 */
@Api(tags="t_jc_zs_dylylqxscbapz_zb")
@RestController
@RequestMapping("/whsjZb/tJcZsDylylqxscbapzZb")
@Slf4j
public class TJcZsDylylqxscbapzZbController extends JeecgController<TJcZsDylylqxscbapzZb, ITJcZsDylylqxscbapzZbService> {
	@Autowired
	private ITJcZsDylylqxscbapzZbService tJcZsDylylqxscbapzZbService;
	
	/**
	 * 分页列表查询
	 *
	 * @param tJcZsDylylqxscbapzZb
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "t_jc_zs_dylylqxscbapz_zb-分页列表查询")
	@ApiOperation(value="t_jc_zs_dylylqxscbapz_zb-分页列表查询", notes="t_jc_zs_dylylqxscbapz_zb-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<TJcZsDylylqxscbapzZb>> queryPageList(TJcZsDylylqxscbapzZb tJcZsDylylqxscbapzZb,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<TJcZsDylylqxscbapzZb> queryWrapper = QueryGenerator.initQueryWrapper(tJcZsDylylqxscbapzZb, req.getParameterMap());
		Page<TJcZsDylylqxscbapzZb> page = new Page<TJcZsDylylqxscbapzZb>(pageNo, pageSize);
		IPage<TJcZsDylylqxscbapzZb> pageList = tJcZsDylylqxscbapzZbService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param tJcZsDylylqxscbapzZb
	 * @return
	 */
	@AutoLog(value = "t_jc_zs_dylylqxscbapz_zb-添加")
	@ApiOperation(value="t_jc_zs_dylylqxscbapz_zb-添加", notes="t_jc_zs_dylylqxscbapz_zb-添加")
	@RequiresPermissions("whsjZb:t_jc_zs_dylylqxscbapz_zb:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody TJcZsDylylqxscbapzZb tJcZsDylylqxscbapzZb) {
		tJcZsDylylqxscbapzZbService.save(tJcZsDylylqxscbapzZb);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param tJcZsDylylqxscbapzZb
	 * @return
	 */
	@AutoLog(value = "t_jc_zs_dylylqxscbapz_zb-编辑")
	@ApiOperation(value="t_jc_zs_dylylqxscbapz_zb-编辑", notes="t_jc_zs_dylylqxscbapz_zb-编辑")
	@RequiresPermissions("whsjZb:t_jc_zs_dylylqxscbapz_zb:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody TJcZsDylylqxscbapzZb tJcZsDylylqxscbapzZb) {
		tJcZsDylylqxscbapzZbService.updateById(tJcZsDylylqxscbapzZb);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "t_jc_zs_dylylqxscbapz_zb-通过id删除")
	@ApiOperation(value="t_jc_zs_dylylqxscbapz_zb-通过id删除", notes="t_jc_zs_dylylqxscbapz_zb-通过id删除")
	@RequiresPermissions("whsjZb:t_jc_zs_dylylqxscbapz_zb:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		tJcZsDylylqxscbapzZbService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "t_jc_zs_dylylqxscbapz_zb-批量删除")
	@ApiOperation(value="t_jc_zs_dylylqxscbapz_zb-批量删除", notes="t_jc_zs_dylylqxscbapz_zb-批量删除")
	@RequiresPermissions("whsjZb:t_jc_zs_dylylqxscbapz_zb:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.tJcZsDylylqxscbapzZbService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "t_jc_zs_dylylqxscbapz_zb-通过id查询")
	@ApiOperation(value="t_jc_zs_dylylqxscbapz_zb-通过id查询", notes="t_jc_zs_dylylqxscbapz_zb-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<TJcZsDylylqxscbapzZb> queryById(@RequestParam(name="id",required=true) String id) {
		TJcZsDylylqxscbapzZb tJcZsDylylqxscbapzZb = tJcZsDylylqxscbapzZbService.getById(id);
		if(tJcZsDylylqxscbapzZb==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(tJcZsDylylqxscbapzZb);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param tJcZsDylylqxscbapzZb
    */
    @RequiresPermissions("whsjZb:t_jc_zs_dylylqxscbapz_zb:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, TJcZsDylylqxscbapzZb tJcZsDylylqxscbapzZb) {
        return super.exportXls(request, tJcZsDylylqxscbapzZb, TJcZsDylylqxscbapzZb.class, "t_jc_zs_dylylqxscbapz_zb");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("whsjZb:t_jc_zs_dylylqxscbapz_zb:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, TJcZsDylylqxscbapzZb.class);
    }

}
