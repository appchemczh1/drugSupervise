package org.jeecg.modules.demo.dzzz.lszb.controller;

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
import org.jeecg.modules.demo.dzzz.lszb.entity.CertchirdYlqxlcsybaH;
import org.jeecg.modules.demo.dzzz.lszb.service.ICertchirdYlqxlcsybaHService;

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
 * @Description: certchird_ylqxlcsyba_h
 * @Author: jeecg-boot
 * @Date:   2024-07-03
 * @Version: V1.0
 */
@Api(tags="certchird_ylqxlcsyba_h")
@RestController
@RequestMapping("/dzzz.lszb/certchirdYlqxlcsybaH")
@Slf4j
public class CertchirdYlqxlcsybaHController extends JeecgController<CertchirdYlqxlcsybaH, ICertchirdYlqxlcsybaHService> {
	@Autowired
	private ICertchirdYlqxlcsybaHService certchirdYlqxlcsybaHService;
	
	/**
	 * 分页列表查询
	 *
	 * @param certchirdYlqxlcsybaH
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "certchird_ylqxlcsyba_h-分页列表查询")
	@ApiOperation(value="certchird_ylqxlcsyba_h-分页列表查询", notes="certchird_ylqxlcsyba_h-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<CertchirdYlqxlcsybaH>> queryPageList(CertchirdYlqxlcsybaH certchirdYlqxlcsybaH,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<CertchirdYlqxlcsybaH> queryWrapper = QueryGenerator.initQueryWrapper(certchirdYlqxlcsybaH, req.getParameterMap());
		Page<CertchirdYlqxlcsybaH> page = new Page<CertchirdYlqxlcsybaH>(pageNo, pageSize);
		IPage<CertchirdYlqxlcsybaH> pageList = certchirdYlqxlcsybaHService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param certchirdYlqxlcsybaH
	 * @return
	 */
	@AutoLog(value = "certchird_ylqxlcsyba_h-添加")
	@ApiOperation(value="certchird_ylqxlcsyba_h-添加", notes="certchird_ylqxlcsyba_h-添加")
	@RequiresPermissions("dzzz.lszb:certchird_ylqxlcsyba_h:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody CertchirdYlqxlcsybaH certchirdYlqxlcsybaH) {
		certchirdYlqxlcsybaHService.save(certchirdYlqxlcsybaH);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param certchirdYlqxlcsybaH
	 * @return
	 */
	@AutoLog(value = "certchird_ylqxlcsyba_h-编辑")
	@ApiOperation(value="certchird_ylqxlcsyba_h-编辑", notes="certchird_ylqxlcsyba_h-编辑")
	@RequiresPermissions("dzzz.lszb:certchird_ylqxlcsyba_h:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody CertchirdYlqxlcsybaH certchirdYlqxlcsybaH) {
		certchirdYlqxlcsybaHService.updateById(certchirdYlqxlcsybaH);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "certchird_ylqxlcsyba_h-通过id删除")
	@ApiOperation(value="certchird_ylqxlcsyba_h-通过id删除", notes="certchird_ylqxlcsyba_h-通过id删除")
	@RequiresPermissions("dzzz.lszb:certchird_ylqxlcsyba_h:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		certchirdYlqxlcsybaHService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "certchird_ylqxlcsyba_h-批量删除")
	@ApiOperation(value="certchird_ylqxlcsyba_h-批量删除", notes="certchird_ylqxlcsyba_h-批量删除")
	@RequiresPermissions("dzzz.lszb:certchird_ylqxlcsyba_h:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.certchirdYlqxlcsybaHService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "certchird_ylqxlcsyba_h-通过id查询")
	@ApiOperation(value="certchird_ylqxlcsyba_h-通过id查询", notes="certchird_ylqxlcsyba_h-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<CertchirdYlqxlcsybaH> queryById(@RequestParam(name="id",required=true) String id) {
		CertchirdYlqxlcsybaH certchirdYlqxlcsybaH = certchirdYlqxlcsybaHService.getById(id);
		if(certchirdYlqxlcsybaH==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(certchirdYlqxlcsybaH);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param certchirdYlqxlcsybaH
    */
    @RequiresPermissions("dzzz.lszb:certchird_ylqxlcsyba_h:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, CertchirdYlqxlcsybaH certchirdYlqxlcsybaH) {
        return super.exportXls(request, certchirdYlqxlcsybaH, CertchirdYlqxlcsybaH.class, "certchird_ylqxlcsyba_h");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("dzzz.lszb:certchird_ylqxlcsyba_h:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, CertchirdYlqxlcsybaH.class);
    }

}
