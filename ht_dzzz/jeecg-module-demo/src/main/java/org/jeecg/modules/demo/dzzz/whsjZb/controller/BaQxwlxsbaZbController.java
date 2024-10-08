package org.jeecg.modules.demo.dzzz.whsjZb.controller;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecg.common.system.query.QueryGenerator;

import lombok.extern.slf4j.Slf4j;

import org.jeecg.modules.demo.dzzz.whsjZb.entity.BaQxwlxsbaZb;
import org.jeecg.modules.demo.dzzz.whsjZb.service.IBaQxwlxsbaZbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;

 /**
 * @Description: ba_qxwlxsba_zb
 * @Author: jeecg-boot
 * @Date:   2024-08-30
 * @Version: V1.0
 */
@Api(tags="ba_qxwlxsba_zb")
@RestController
@RequestMapping("/whsjZb/baQxwlxsbaZb")
@Slf4j
public class BaQxwlxsbaZbController extends JeecgController<BaQxwlxsbaZb, IBaQxwlxsbaZbService> {
	@Autowired
	private IBaQxwlxsbaZbService baQxwlxsbaZbService;
	
	/**
	 * 分页列表查询
	 *
	 * @param baQxwlxsbaZb
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "ba_qxwlxsba_zb-分页列表查询")
	@ApiOperation(value="ba_qxwlxsba_zb-分页列表查询", notes="ba_qxwlxsba_zb-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<BaQxwlxsbaZb>> queryPageList(BaQxwlxsbaZb baQxwlxsbaZb,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<BaQxwlxsbaZb> queryWrapper = QueryGenerator.initQueryWrapper(baQxwlxsbaZb, req.getParameterMap());
		Page<BaQxwlxsbaZb> page = new Page<BaQxwlxsbaZb>(pageNo, pageSize);
		IPage<BaQxwlxsbaZb> pageList = baQxwlxsbaZbService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param baQxwlxsbaZb
	 * @return
	 */
	@AutoLog(value = "ba_qxwlxsba_zb-添加")
	@ApiOperation(value="ba_qxwlxsba_zb-添加", notes="ba_qxwlxsba_zb-添加")
	@RequiresPermissions("whsjZb:ba_qxwlxsba_zb:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody BaQxwlxsbaZb baQxwlxsbaZb) {
		baQxwlxsbaZbService.save(baQxwlxsbaZb);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param baQxwlxsbaZb
	 * @return
	 */
	@AutoLog(value = "ba_qxwlxsba_zb-编辑")
	@ApiOperation(value="ba_qxwlxsba_zb-编辑", notes="ba_qxwlxsba_zb-编辑")
	@RequiresPermissions("whsjZb:ba_qxwlxsba_zb:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody BaQxwlxsbaZb baQxwlxsbaZb) {
		baQxwlxsbaZbService.updateById(baQxwlxsbaZb);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "ba_qxwlxsba_zb-通过id删除")
	@ApiOperation(value="ba_qxwlxsba_zb-通过id删除", notes="ba_qxwlxsba_zb-通过id删除")
	@RequiresPermissions("whsjZb:ba_qxwlxsba_zb:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		baQxwlxsbaZbService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "ba_qxwlxsba_zb-批量删除")
	@ApiOperation(value="ba_qxwlxsba_zb-批量删除", notes="ba_qxwlxsba_zb-批量删除")
	@RequiresPermissions("whsjZb:ba_qxwlxsba_zb:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.baQxwlxsbaZbService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "ba_qxwlxsba_zb-通过id查询")
	@ApiOperation(value="ba_qxwlxsba_zb-通过id查询", notes="ba_qxwlxsba_zb-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<BaQxwlxsbaZb> queryById(@RequestParam(name="id",required=true) String id) {
		BaQxwlxsbaZb baQxwlxsbaZb = baQxwlxsbaZbService.getById(id);
		if(baQxwlxsbaZb==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(baQxwlxsbaZb);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param baQxwlxsbaZb
    */
    @RequiresPermissions("whsjZb:ba_qxwlxsba_zb:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, BaQxwlxsbaZb baQxwlxsbaZb) {
        return super.exportXls(request, baQxwlxsbaZb, BaQxwlxsbaZb.class, "ba_qxwlxsba_zb");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("whsjZb:ba_qxwlxsba_zb:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, BaQxwlxsbaZb.class);
    }

}
