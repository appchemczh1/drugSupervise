package org.jeecg.modules.demo.dzzz.attachinfo.controller;

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
import org.jeecg.modules.demo.dzzz.attachinfo.entity.Attachinfo;
import org.jeecg.modules.demo.dzzz.attachinfo.service.IAttachinfoService;

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
 * @Description: 附件储存表
 * @Author: jeecg-boot
 * @Date:   2024-04-07
 * @Version: V1.0
 */
@Api(tags="附件储存表")
@RestController
@RequestMapping("/dzzz.attachinfo/attachinfo")
@Slf4j
public class AttachinfoController extends JeecgController<Attachinfo, IAttachinfoService> {
	@Autowired
	private IAttachinfoService attachinfoService;
	
	/**
	 * 分页列表查询
	 *
	 * @param attachinfo
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "附件储存表-分页列表查询")
	@ApiOperation(value="附件储存表-分页列表查询", notes="附件储存表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Attachinfo>> queryPageList(Attachinfo attachinfo,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<Attachinfo> queryWrapper = QueryGenerator.initQueryWrapper(attachinfo, req.getParameterMap());
		Page<Attachinfo> page = new Page<Attachinfo>(pageNo, pageSize);
		IPage<Attachinfo> pageList = attachinfoService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param attachinfo
	 * @return
	 */
	@AutoLog(value = "附件储存表-添加")
	@ApiOperation(value="附件储存表-添加", notes="附件储存表-添加")
	@RequiresPermissions("dzzz.attachinfo:attachinfo:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Attachinfo attachinfo) {
		attachinfoService.save(attachinfo);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param attachinfo
	 * @return
	 */
	@AutoLog(value = "附件储存表-编辑")
	@ApiOperation(value="附件储存表-编辑", notes="附件储存表-编辑")
	@RequiresPermissions("dzzz.attachinfo:attachinfo:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Attachinfo attachinfo) {
		attachinfoService.updateById(attachinfo);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "附件储存表-通过id删除")
	@ApiOperation(value="附件储存表-通过id删除", notes="附件储存表-通过id删除")
	@RequiresPermissions("dzzz.attachinfo:attachinfo:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		attachinfoService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "附件储存表-批量删除")
	@ApiOperation(value="附件储存表-批量删除", notes="附件储存表-批量删除")
	@RequiresPermissions("dzzz.attachinfo:attachinfo:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.attachinfoService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "附件储存表-通过id查询")
	@ApiOperation(value="附件储存表-通过id查询", notes="附件储存表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Attachinfo> queryById(@RequestParam(name="id",required=true) String id) {
		Attachinfo attachinfo = attachinfoService.getById(id);
		if(attachinfo==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(attachinfo);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param attachinfo
    */
    @RequiresPermissions("dzzz.attachinfo:attachinfo:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Attachinfo attachinfo) {
        return super.exportXls(request, attachinfo, Attachinfo.class, "附件储存表");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("dzzz.attachinfo:attachinfo:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Attachinfo.class);
    }

}
