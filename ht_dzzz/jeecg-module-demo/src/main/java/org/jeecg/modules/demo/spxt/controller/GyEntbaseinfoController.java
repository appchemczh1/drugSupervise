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
import org.jeecg.modules.demo.spxt.entity.GyEntbaseinfo;
import org.jeecg.modules.demo.spxt.service.IGyEntbaseinfoService;

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
 * @Description: gy_entbaseinfo
 * @Author: jeecg-boot
 * @Date:   2024-06-20
 * @Version: V1.0
 */
@Api(tags="gy_entbaseinfo")
@RestController
@RequestMapping("/spxt/gyEntbaseinfo")
@Slf4j
public class GyEntbaseinfoController extends JeecgController<GyEntbaseinfo, IGyEntbaseinfoService> {
	@Autowired
	private IGyEntbaseinfoService gyEntbaseinfoService;
	
	/**
	 * 分页列表查询
	 *
	 * @param gyEntbaseinfo
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "gy_entbaseinfo-分页列表查询")
	@ApiOperation(value="gy_entbaseinfo-分页列表查询", notes="gy_entbaseinfo-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<GyEntbaseinfo>> queryPageList(GyEntbaseinfo gyEntbaseinfo,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<GyEntbaseinfo> queryWrapper = QueryGenerator.initQueryWrapper(gyEntbaseinfo, req.getParameterMap());
		Page<GyEntbaseinfo> page = new Page<GyEntbaseinfo>(pageNo, pageSize);
		IPage<GyEntbaseinfo> pageList = gyEntbaseinfoService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param gyEntbaseinfo
	 * @return
	 */
	@AutoLog(value = "gy_entbaseinfo-添加")
	@ApiOperation(value="gy_entbaseinfo-添加", notes="gy_entbaseinfo-添加")
	@RequiresPermissions("spxt:gy_entbaseinfo:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody GyEntbaseinfo gyEntbaseinfo) {
		gyEntbaseinfoService.save(gyEntbaseinfo);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param gyEntbaseinfo
	 * @return
	 */
	@AutoLog(value = "gy_entbaseinfo-编辑")
	@ApiOperation(value="gy_entbaseinfo-编辑", notes="gy_entbaseinfo-编辑")
	@RequiresPermissions("spxt:gy_entbaseinfo:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody GyEntbaseinfo gyEntbaseinfo) {
		gyEntbaseinfoService.updateById(gyEntbaseinfo);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "gy_entbaseinfo-通过id删除")
	@ApiOperation(value="gy_entbaseinfo-通过id删除", notes="gy_entbaseinfo-通过id删除")
	@RequiresPermissions("spxt:gy_entbaseinfo:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		gyEntbaseinfoService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "gy_entbaseinfo-批量删除")
	@ApiOperation(value="gy_entbaseinfo-批量删除", notes="gy_entbaseinfo-批量删除")
	@RequiresPermissions("spxt:gy_entbaseinfo:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.gyEntbaseinfoService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "gy_entbaseinfo-通过id查询")
	@ApiOperation(value="gy_entbaseinfo-通过id查询", notes="gy_entbaseinfo-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<GyEntbaseinfo> queryById(@RequestParam(name="id",required=true) String id) {
		GyEntbaseinfo gyEntbaseinfo = gyEntbaseinfoService.getById(id);
		if(gyEntbaseinfo==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(gyEntbaseinfo);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param gyEntbaseinfo
    */
    @RequiresPermissions("spxt:gy_entbaseinfo:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, GyEntbaseinfo gyEntbaseinfo) {
        return super.exportXls(request, gyEntbaseinfo, GyEntbaseinfo.class, "gy_entbaseinfo");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("spxt:gy_entbaseinfo:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, GyEntbaseinfo.class);
    }

}
