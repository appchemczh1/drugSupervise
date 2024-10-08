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
import org.jeecg.modules.demo.dzzz.lszb.entity.CertchildYlqxcpckxsH;
import org.jeecg.modules.demo.dzzz.lszb.service.ICertchildYlqxcpckxsHService;

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
 * @Description: certchild_ylqxcpckxs_h
 * @Author: jeecg-boot
 * @Date:   2024-07-03
 * @Version: V1.0
 */
@Api(tags="certchild_ylqxcpckxs_h")
@RestController
@RequestMapping("/dzzz.lszb/certchildYlqxcpckxsH")
@Slf4j
public class CertchildYlqxcpckxsHController extends JeecgController<CertchildYlqxcpckxsH, ICertchildYlqxcpckxsHService> {
	@Autowired
	private ICertchildYlqxcpckxsHService certchildYlqxcpckxsHService;
	
	/**
	 * 分页列表查询
	 *
	 * @param certchildYlqxcpckxsH
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "certchild_ylqxcpckxs_h-分页列表查询")
	@ApiOperation(value="certchild_ylqxcpckxs_h-分页列表查询", notes="certchild_ylqxcpckxs_h-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<CertchildYlqxcpckxsH>> queryPageList(CertchildYlqxcpckxsH certchildYlqxcpckxsH,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<CertchildYlqxcpckxsH> queryWrapper = QueryGenerator.initQueryWrapper(certchildYlqxcpckxsH, req.getParameterMap());
		Page<CertchildYlqxcpckxsH> page = new Page<CertchildYlqxcpckxsH>(pageNo, pageSize);
		IPage<CertchildYlqxcpckxsH> pageList = certchildYlqxcpckxsHService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param certchildYlqxcpckxsH
	 * @return
	 */
	@AutoLog(value = "certchild_ylqxcpckxs_h-添加")
	@ApiOperation(value="certchild_ylqxcpckxs_h-添加", notes="certchild_ylqxcpckxs_h-添加")
	@RequiresPermissions("dzzz.lszb:certchild_ylqxcpckxs_h:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody CertchildYlqxcpckxsH certchildYlqxcpckxsH) {
		certchildYlqxcpckxsHService.save(certchildYlqxcpckxsH);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param certchildYlqxcpckxsH
	 * @return
	 */
	@AutoLog(value = "certchild_ylqxcpckxs_h-编辑")
	@ApiOperation(value="certchild_ylqxcpckxs_h-编辑", notes="certchild_ylqxcpckxs_h-编辑")
	@RequiresPermissions("dzzz.lszb:certchild_ylqxcpckxs_h:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody CertchildYlqxcpckxsH certchildYlqxcpckxsH) {
		certchildYlqxcpckxsHService.updateById(certchildYlqxcpckxsH);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "certchild_ylqxcpckxs_h-通过id删除")
	@ApiOperation(value="certchild_ylqxcpckxs_h-通过id删除", notes="certchild_ylqxcpckxs_h-通过id删除")
	@RequiresPermissions("dzzz.lszb:certchild_ylqxcpckxs_h:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		certchildYlqxcpckxsHService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "certchild_ylqxcpckxs_h-批量删除")
	@ApiOperation(value="certchild_ylqxcpckxs_h-批量删除", notes="certchild_ylqxcpckxs_h-批量删除")
	@RequiresPermissions("dzzz.lszb:certchild_ylqxcpckxs_h:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.certchildYlqxcpckxsHService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "certchild_ylqxcpckxs_h-通过id查询")
	@ApiOperation(value="certchild_ylqxcpckxs_h-通过id查询", notes="certchild_ylqxcpckxs_h-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<CertchildYlqxcpckxsH> queryById(@RequestParam(name="id",required=true) String id) {
		CertchildYlqxcpckxsH certchildYlqxcpckxsH = certchildYlqxcpckxsHService.getById(id);
		if(certchildYlqxcpckxsH==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(certchildYlqxcpckxsH);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param certchildYlqxcpckxsH
    */
    @RequiresPermissions("dzzz.lszb:certchild_ylqxcpckxs_h:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, CertchildYlqxcpckxsH certchildYlqxcpckxsH) {
        return super.exportXls(request, certchildYlqxcpckxsH, CertchildYlqxcpckxsH.class, "certchild_ylqxcpckxs_h");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("dzzz.lszb:certchild_ylqxcpckxs_h:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, CertchildYlqxcpckxsH.class);
    }

}
