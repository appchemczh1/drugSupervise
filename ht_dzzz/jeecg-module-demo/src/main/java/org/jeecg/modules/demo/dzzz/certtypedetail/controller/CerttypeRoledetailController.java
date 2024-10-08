package org.jeecg.modules.demo.dzzz.certtypedetail.controller;

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
import org.jeecg.common.util.CollectionUtils;
import org.jeecg.common.util.SpringContextUtils;
import org.jeecg.common.util.StringUtils;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.demo.dzzz.certtypedetail.entity.CerttypeRoledetail;
import org.jeecg.modules.demo.dzzz.certtypedetail.service.ICerttypeRoledetailService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.modules.system.service.ISysUserService;
import org.jeecg.modules.system.util.WebUtils;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.stream.Record;
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
 * @Description: 证照类型权限详细描述
 * @Author: jeecg-boot
 * @Date:   2024-04-26
 * @Version: V1.0
 */
@Api(tags="证照类型权限详细描述")
@RestController
@RequestMapping("/dzzz.certtypedetail/certtypeRoledetail")
@Slf4j
public class CerttypeRoledetailController extends JeecgController<CerttypeRoledetail, ICerttypeRoledetailService> {
	@Autowired
	private ICerttypeRoledetailService certtypeRoledetailService;
	
	/**
	 * 分页列表查询
	 *
	 * @param certtypeRoledetail
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "证照类型权限详细描述-分页列表查询")
	@ApiOperation(value="证照类型权限详细描述-分页列表查询", notes="证照类型权限详细描述-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<CerttypeRoledetail>> queryPageList(CerttypeRoledetail certtypeRoledetail,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<CerttypeRoledetail> queryWrapper = QueryGenerator.initQueryWrapper(certtypeRoledetail, req.getParameterMap());
		Page<CerttypeRoledetail> page = new Page<CerttypeRoledetail>(pageNo, pageSize);
		IPage<CerttypeRoledetail> pageList = certtypeRoledetailService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param certtypeRoledetail
	 * @return
	 */
	@AutoLog(value = "证照类型权限详细描述-添加")
	@ApiOperation(value = "证照类型权限详细描述-添加", notes = "证照类型权限详细描述-添加")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody CerttypeRoledetail certtypeRoledetail) {
		if (StringUtils.isNotBlank(certtypeRoledetail.getId())) {
			certtypeRoledetailService.updateById(certtypeRoledetail);
		} else {
			certtypeRoledetailService.save(certtypeRoledetail);
		}
		return Result.OK("操作成功！");
	}

	 @AutoLog(value = "获取证照类型权限详细描述")
	 @ApiOperation(value = "获取证照类型权限详细描述", notes = "获取证照类型权限详细描述")
	 @PostMapping(value = "/getDetail")
	 public Result<Object> getDetail(@RequestBody CerttypeRoledetail entity) {
		 QueryWrapper<CerttypeRoledetail> query = new QueryWrapper<>();
		 query.eq("certtypeid", entity.getCerttypeid());
		 List<CerttypeRoledetail> list = certtypeRoledetailService.list(query);
		 return Result.OK(CollectionUtils.isNotEmpty(list) ? list.get(0) : null);
	 }

	 @AutoLog(value = "获取证照类型权限详细描述")
	 @ApiOperation(value = "获取证照类型权限详细描述", notes = "获取证照类型权限详细描述")
	 @PostMapping(value = "/getDetailInner")
	 public Result<Object> getDetailInner(@RequestBody CerttypeRoledetail entity) {
		 boolean hasRoleIds = StringUtils.isNotBlank(entity.getRoleId());
		 QueryWrapper<CerttypeRoledetail> query = new QueryWrapper<>();
		 query.eq("certtypeid", entity.getCerttypeid());
		 if (hasRoleIds) {
			 query.eq("ROLE_ID", entity.getRoleId());
		 } else {
			 List<String> roleCodes = SpringContextUtils.getBean(ISysUserService.class).getRole(WebUtils.getLoginUser().getUsername());
			 if (CollectionUtils.isNotEmpty(roleCodes)) query.in("ROLE_ID", roleCodes);
			 else query.eq("ROLE_ID", "------------------");
		 }
		 List<CerttypeRoledetail> list = certtypeRoledetailService.list(query);
		 if (hasRoleIds) return Result.OK(CollectionUtils.isNotEmpty(list) ? list.get(0) : null);
		 else {
			 CerttypeRoledetail res = new CerttypeRoledetail();
			 for (CerttypeRoledetail item : list) {
				 res.setBg(StringUtils.join(res.getBg(), item.getBg(), ","));
				 res.setHz(StringUtils.join(res.getHz(), item.getHz(), ","));
				 res.setZsjc(StringUtils.join(res.getZsjc(), item.getZsjc(), ","));
				 res.setSjwh(StringUtils.join(res.getSjwh(), item.getSjwh(), ","));
			 }
			 return Result.OK(res);
		 }
	 }

	/**
	 *  编辑
	 *
	 * @param certtypeRoledetail
	 * @return
	 */
	@AutoLog(value = "证照类型权限详细描述-编辑")
	@ApiOperation(value="证照类型权限详细描述-编辑", notes="证照类型权限详细描述-编辑")
//	@RequiresPermissions("dzzz.certtypedetail:certtype_roledetail:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody CerttypeRoledetail certtypeRoledetail) {
		certtypeRoledetailService.updateById(certtypeRoledetail);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "证照类型权限详细描述-通过id删除")
	@ApiOperation(value="证照类型权限详细描述-通过id删除", notes="证照类型权限详细描述-通过id删除")
//	@RequiresPermissions("dzzz.certtypedetail:certtype_roledetail:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		certtypeRoledetailService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "证照类型权限详细描述-批量删除")
	@ApiOperation(value="证照类型权限详细描述-批量删除", notes="证照类型权限详细描述-批量删除")
//	@RequiresPermissions("dzzz.certtypedetail:certtype_roledetail:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.certtypeRoledetailService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "证照类型权限详细描述-通过id查询")
	@ApiOperation(value="证照类型权限详细描述-通过id查询", notes="证照类型权限详细描述-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<CerttypeRoledetail> queryById(@RequestParam(name="id",required=true) String id) {
		CerttypeRoledetail certtypeRoledetail = certtypeRoledetailService.getById(id);
		if(certtypeRoledetail==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(certtypeRoledetail);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param certtypeRoledetail
    */
//    @RequiresPermissions("dzzz.certtypedetail:certtype_roledetail:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, CerttypeRoledetail certtypeRoledetail) {
        return super.exportXls(request, certtypeRoledetail, CerttypeRoledetail.class, "证照类型权限详细描述");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
//    @RequiresPermissions("dzzz.certtypedetail:certtype_roledetail:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, CerttypeRoledetail.class);
    }

}
