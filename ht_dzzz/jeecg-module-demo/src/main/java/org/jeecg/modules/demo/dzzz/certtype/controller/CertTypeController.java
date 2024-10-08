package org.jeecg.modules.demo.dzzz.certtype.controller;

import java.util.Arrays;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
/*import org.jeecg.modules.demo.dzzz.certmatadataversion.entity.CertMetadataVersion;
import org.jeecg.modules.demo.dzzz.certmatadataversion.service.ICertMetadataVersionService;*/
import org.jeecg.modules.demo.dzzz.certmode.entity.CertMode;
import org.jeecg.modules.demo.dzzz.certmode.service.ICertModeService;
import org.jeecg.modules.demo.dzzz.certtype.entity.CertType;
import org.jeecg.modules.demo.dzzz.certtype.service.ICertTypeService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecg.modules.demo.dzzz.homepage.service.IOtherPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;

 /**
 * @Description: 证照类型
 * @Author: jeecg-boot
 * @Date:   2024-03-19
 * @Version: V1.0
 */
@Api(tags="证照类型")
@RestController
@RequestMapping("/dzzz/certType")
@Slf4j
public class CertTypeController extends JeecgController<CertType, ICertTypeService> {
	@Autowired
	private ICertTypeService certTypeService;
	@Autowired
	private ICertModeService certModeService;
	@Autowired
	private IOtherPageService otherPageService;

	
	/**
	 * 分页列表查询
	 *
	 * @param certType
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "证照类型-分页列表查询")
	@ApiOperation(value="证照类型-分页列表查询", notes="证照类型-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<CertType>> queryPageList(CertType certType,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<CertType> queryWrapper = QueryGenerator.initQueryWrapper(certType, req.getParameterMap());
		Page<CertType> page = new Page<CertType>(pageNo, pageSize);
		IPage<CertType> pageList = certTypeService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param certType
	 * @return
	 */
	@AutoLog(value = "证照类型-添加")
	@ApiOperation(value="证照类型-添加", notes="证照类型-添加")
	/*@RequiresPermissions("dzzz:cert_type:add")*/
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody CertType certType) {
		certTypeService.save(certType);
		otherPageService.clearCache();
		return Result.OK("添加成功！");
	}

	 /**
	  *   捆绑添加添加
	  *
	  * @param certType
	  * @return
	  */
	 @AutoLog(value = "证照类型-添加")
	 @ApiOperation(value="证照类型-添加", notes="证照类型-添加")
	 /*@RequiresPermissions("dzzz:cert_type:add")*/
	 @PostMapping(value = "/addall")
	 public Result<String> addall(@RequestBody CertType certType) {
		 certType.setId(UUID.randomUUID().toString());
		 /*certMetadataVersion.setCertTypeId(certType.getId());
		 certMode.setCerttypeid(certType.getId());
		 certModeService.save(certMode);*/
		/* certMetadataVersionService.save();*/
		 certTypeService.save(certType);
		 otherPageService.clearCache();
		 return Result.OK("添加成功！");
	 }
	
	/**
	 *  编辑
	 *
	 * @param certType
	 * @return
	 */
	@AutoLog(value = "证照类型-编辑")
	@ApiOperation(value="证照类型-编辑", notes="证照类型-编辑")
/*	@RequiresPermissions("dzzz:cert_type:edit")*/
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody CertType certType) {
		certTypeService.updateById(certType);
		otherPageService.clearCache();
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "证照类型-通过id删除")
	@ApiOperation(value="证照类型-通过id删除", notes="证照类型-通过id删除")
/*	@RequiresPermissions("dzzz:cert_type:delete")*/
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		certTypeService.removeById(id);
		otherPageService.clearCache();
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "证照类型-批量删除")
	@ApiOperation(value="证照类型-批量删除", notes="证照类型-批量删除")
/*	@RequiresPermissions("dzzz:cert_type:deleteBatch")*/
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.certTypeService.removeByIds(Arrays.asList(ids.split(",")));
		otherPageService.clearCache();
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "证照类型-通过id查询")
	@ApiOperation(value="证照类型-通过id查询", notes="证照类型-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<CertType> queryById(@RequestParam(name="id",required=true) String id) {
		CertType certType = certTypeService.getById(id);
		System.out.println("进来了");
		if(certType==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(certType);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param certType
    */
    /*@RequiresPermissions("dzzz:cert_type:exportXls")*/
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, CertType certType) {
        return super.exportXls(request, certType, CertType.class, "证照类型");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    /*@RequiresPermissions("dzzz:cert_type:importExcel")*/
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
		Result<?> res = super.importExcel(request, response, CertType.class);
		otherPageService.clearCache();
		return res;
    }

}
