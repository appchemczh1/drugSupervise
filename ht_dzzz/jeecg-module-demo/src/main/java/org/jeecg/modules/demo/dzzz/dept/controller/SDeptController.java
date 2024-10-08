package org.jeecg.modules.demo.dzzz.dept.controller;

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
import org.jeecg.modules.demo.dzzz.dept.entity.SDept;
import org.jeecg.modules.demo.dzzz.dept.service.ISDeptService;

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
 * @Description: s_dept
 * @Author: jeecg-boot
 * @Date:   2024-07-11
 * @Version: V1.0
 */
@Api(tags="s_dept")
@RestController
@RequestMapping("/dzzz.dept/sDept")
@Slf4j
public class SDeptController extends JeecgController<SDept, ISDeptService> {
	@Autowired
	private ISDeptService sDeptService;
	
	/**
	 * 分页列表查询
	 *
	 * @param sDept
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "s_dept-分页列表查询")
	@ApiOperation(value="s_dept-分页列表查询", notes="s_dept-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<SDept>> queryPageList(SDept sDept,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<SDept> queryWrapper = QueryGenerator.initQueryWrapper(sDept, req.getParameterMap());
		Page<SDept> page = new Page<SDept>(pageNo, pageSize);
		IPage<SDept> pageList = sDeptService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param sDept
	 * @return
	 */
	@AutoLog(value = "s_dept-添加")
	@ApiOperation(value="s_dept-添加", notes="s_dept-添加")
	@RequiresPermissions("dzzz.dept:s_dept:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody SDept sDept) {
		sDeptService.save(sDept);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param sDept
	 * @return
	 */
	@AutoLog(value = "s_dept-编辑")
	@ApiOperation(value="s_dept-编辑", notes="s_dept-编辑")
	@RequiresPermissions("dzzz.dept:s_dept:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody SDept sDept) {
		sDeptService.updateById(sDept);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "s_dept-通过id删除")
	@ApiOperation(value="s_dept-通过id删除", notes="s_dept-通过id删除")
	@RequiresPermissions("dzzz.dept:s_dept:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		sDeptService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "s_dept-批量删除")
	@ApiOperation(value="s_dept-批量删除", notes="s_dept-批量删除")
	@RequiresPermissions("dzzz.dept:s_dept:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.sDeptService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "s_dept-通过id查询")
	@ApiOperation(value="s_dept-通过id查询", notes="s_dept-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<SDept> queryById(@RequestParam(name="id",required=true) String id) {
		SDept sDept = sDeptService.getById(id);
		if(sDept==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(sDept);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param sDept
    */
    @RequiresPermissions("dzzz.dept:s_dept:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, SDept sDept) {
        return super.exportXls(request, sDept, SDept.class, "s_dept");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("dzzz.dept:s_dept:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, SDept.class);
    }

}
