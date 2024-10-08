package org.jeecg.modules.demo.dzzz.whsjZb.controller;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.modules.demo.dzzz.whsjZb.entity.BaQxwlxsbaZbZs;
import org.jeecg.modules.demo.dzzz.whsjZb.service.IBaQxwlxsbaZbZsService;

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
 * @Description: ba_qxwlxsba_zb_zs
 * @Author: jeecg-boot
 * @Date:   2024-09-01
 * @Version: V1.0
 */
@Api(tags="ba_qxwlxsba_zb_zs")
@RestController
@RequestMapping("/whsjZb/baQxwlxsbaZbZs")
@Slf4j
public class BaQxwlxsbaZbZsController extends JeecgController<BaQxwlxsbaZbZs, IBaQxwlxsbaZbZsService> {
	@Autowired
	private IBaQxwlxsbaZbZsService baQxwlxsbaZbZsService;
	
	/**
	 * 分页列表查询
	 *
	 * @param baQxwlxsbaZbZs
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "ba_qxwlxsba_zb_zs-分页列表查询")
	@ApiOperation(value="ba_qxwlxsba_zb_zs-分页列表查询", notes="ba_qxwlxsba_zb_zs-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<BaQxwlxsbaZbZs>> queryPageList(BaQxwlxsbaZbZs baQxwlxsbaZbZs,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<BaQxwlxsbaZbZs> queryWrapper = QueryGenerator.initQueryWrapper(baQxwlxsbaZbZs, req.getParameterMap());
		Page<BaQxwlxsbaZbZs> page = new Page<BaQxwlxsbaZbZs>(pageNo, pageSize);
		IPage<BaQxwlxsbaZbZs> pageList = baQxwlxsbaZbZsService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param baQxwlxsbaZbZs
	 * @return
	 */
	@AutoLog(value = "ba_qxwlxsba_zb_zs-添加")
	@ApiOperation(value="ba_qxwlxsba_zb_zs-添加", notes="ba_qxwlxsba_zb_zs-添加")
	@RequiresPermissions("whsjZb:ba_qxwlxsba_zb_zs:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody BaQxwlxsbaZbZs baQxwlxsbaZbZs) {
		baQxwlxsbaZbZsService.save(baQxwlxsbaZbZs);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param baQxwlxsbaZbZs
	 * @return
	 */
	@AutoLog(value = "ba_qxwlxsba_zb_zs-编辑")
	@ApiOperation(value="ba_qxwlxsba_zb_zs-编辑", notes="ba_qxwlxsba_zb_zs-编辑")
	@RequiresPermissions("whsjZb:ba_qxwlxsba_zb_zs:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody BaQxwlxsbaZbZs baQxwlxsbaZbZs) {
		baQxwlxsbaZbZsService.updateById(baQxwlxsbaZbZs);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "ba_qxwlxsba_zb_zs-通过id删除")
	@ApiOperation(value="ba_qxwlxsba_zb_zs-通过id删除", notes="ba_qxwlxsba_zb_zs-通过id删除")
	@RequiresPermissions("whsjZb:ba_qxwlxsba_zb_zs:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		baQxwlxsbaZbZsService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "ba_qxwlxsba_zb_zs-批量删除")
	@ApiOperation(value="ba_qxwlxsba_zb_zs-批量删除", notes="ba_qxwlxsba_zb_zs-批量删除")
	@RequiresPermissions("whsjZb:ba_qxwlxsba_zb_zs:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.baQxwlxsbaZbZsService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "ba_qxwlxsba_zb_zs-通过id查询")
	@ApiOperation(value="ba_qxwlxsba_zb_zs-通过id查询", notes="ba_qxwlxsba_zb_zs-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<BaQxwlxsbaZbZs> queryById(@RequestParam(name="id",required=true) String id) {
		BaQxwlxsbaZbZs baQxwlxsbaZbZs = baQxwlxsbaZbZsService.getById(id);
		if(baQxwlxsbaZbZs==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(baQxwlxsbaZbZs);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param baQxwlxsbaZbZs
    */
    @RequiresPermissions("whsjZb:ba_qxwlxsba_zb_zs:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, BaQxwlxsbaZbZs baQxwlxsbaZbZs) {
        return super.exportXls(request, baQxwlxsbaZbZs, BaQxwlxsbaZbZs.class, "ba_qxwlxsba_zb_zs");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("whsjZb:ba_qxwlxsba_zb_zs:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, BaQxwlxsbaZbZs.class);
    }

}
