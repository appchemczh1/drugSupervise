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
import org.jeecg.modules.demo.dzzz.lszb.entity.CertchildYpscWtH;
import org.jeecg.modules.demo.dzzz.lszb.service.ICertchildYpscWtHService;

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
 * @Description: certchild_ypsc_wt_h
 * @Author: jeecg-boot
 * @Date:   2024-07-03
 * @Version: V1.0
 */
@Api(tags="certchild_ypsc_wt_h")
@RestController
@RequestMapping("/dzzz.lszb/certchildYpscWtH")
@Slf4j
public class CertchildYpscWtHController extends JeecgController<CertchildYpscWtH, ICertchildYpscWtHService> {
	@Autowired
	private ICertchildYpscWtHService certchildYpscWtHService;
	
	/**
	 * 分页列表查询
	 *
	 * @param certchildYpscWtH
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "certchild_ypsc_wt_h-分页列表查询")
	@ApiOperation(value="certchild_ypsc_wt_h-分页列表查询", notes="certchild_ypsc_wt_h-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<CertchildYpscWtH>> queryPageList(CertchildYpscWtH certchildYpscWtH,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<CertchildYpscWtH> queryWrapper = QueryGenerator.initQueryWrapper(certchildYpscWtH, req.getParameterMap());
		Page<CertchildYpscWtH> page = new Page<CertchildYpscWtH>(pageNo, pageSize);
		IPage<CertchildYpscWtH> pageList = certchildYpscWtHService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param certchildYpscWtH
	 * @return
	 */
	@AutoLog(value = "certchild_ypsc_wt_h-添加")
	@ApiOperation(value="certchild_ypsc_wt_h-添加", notes="certchild_ypsc_wt_h-添加")
	@RequiresPermissions("dzzz.lszb:certchild_ypsc_wt_h:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody CertchildYpscWtH certchildYpscWtH) {
		certchildYpscWtHService.save(certchildYpscWtH);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param certchildYpscWtH
	 * @return
	 */
	@AutoLog(value = "certchild_ypsc_wt_h-编辑")
	@ApiOperation(value="certchild_ypsc_wt_h-编辑", notes="certchild_ypsc_wt_h-编辑")
	@RequiresPermissions("dzzz.lszb:certchild_ypsc_wt_h:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody CertchildYpscWtH certchildYpscWtH) {
		certchildYpscWtHService.updateById(certchildYpscWtH);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "certchild_ypsc_wt_h-通过id删除")
	@ApiOperation(value="certchild_ypsc_wt_h-通过id删除", notes="certchild_ypsc_wt_h-通过id删除")
	@RequiresPermissions("dzzz.lszb:certchild_ypsc_wt_h:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		certchildYpscWtHService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "certchild_ypsc_wt_h-批量删除")
	@ApiOperation(value="certchild_ypsc_wt_h-批量删除", notes="certchild_ypsc_wt_h-批量删除")
	@RequiresPermissions("dzzz.lszb:certchild_ypsc_wt_h:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.certchildYpscWtHService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "certchild_ypsc_wt_h-通过id查询")
	@ApiOperation(value="certchild_ypsc_wt_h-通过id查询", notes="certchild_ypsc_wt_h-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<CertchildYpscWtH> queryById(@RequestParam(name="id",required=true) String id) {
		CertchildYpscWtH certchildYpscWtH = certchildYpscWtHService.getById(id);
		if(certchildYpscWtH==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(certchildYpscWtH);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param certchildYpscWtH
    */
    @RequiresPermissions("dzzz.lszb:certchild_ypsc_wt_h:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, CertchildYpscWtH certchildYpscWtH) {
        return super.exportXls(request, certchildYpscWtH, CertchildYpscWtH.class, "certchild_ypsc_wt_h");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("dzzz.lszb:certchild_ypsc_wt_h:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, CertchildYpscWtH.class);
    }

}
