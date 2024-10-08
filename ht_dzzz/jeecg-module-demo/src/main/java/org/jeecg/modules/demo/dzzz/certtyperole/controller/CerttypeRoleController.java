package org.jeecg.modules.demo.dzzz.certtyperole.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.demo.dzzz.certtyperole.entity.CerttypeRole;
import org.jeecg.modules.demo.dzzz.certtyperole.service.ICerttypeRoleService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.modules.system.entity.SysRole;
import org.jeecg.modules.system.service.ISysRoleService;
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
 * @Description: 证照类型权限
 * @Author: jeecg-boot
 * @Date:   2024-04-24
 * @Version: V1.0
 */
@Api(tags="证照类型权限")
@RestController
@RequestMapping("/dzzz.certtyperole/certtypeRole")
@Slf4j
public class CerttypeRoleController extends JeecgController<CerttypeRole, ICerttypeRoleService> {
	@Autowired
	private ICerttypeRoleService certtypeRoleService;
	 @Autowired
	 private ISysRoleService sysRoleService;
	
	/**
	 * 分页列表查询
	 *
	 * @param certtypeRole
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "证照类型权限-分页列表查询")
	@ApiOperation(value="证照类型权限-分页列表查询", notes="证照类型权限-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<CerttypeRole>> queryPageList(CerttypeRole certtypeRole,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<CerttypeRole> queryWrapper = QueryGenerator.initQueryWrapper(certtypeRole, req.getParameterMap());
		Page<CerttypeRole> page = new Page<CerttypeRole>(pageNo, pageSize);
		IPage<CerttypeRole> pageList = certtypeRoleService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param certtypeRole
	 * @return
	 */
	@AutoLog(value = "证照类型权限-添加")
	@ApiOperation(value="证照类型权限-添加", notes="证照类型权限-添加")

	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody CerttypeRole certtypeRole) {
		if(!certtypeRole.getRolename().contains(",")) {
			certtypeRole.setId(UUID.randomUUID().toString());
			String rolename = certtypeRole.getRolename();
			SysRole byId = sysRoleService.getById(rolename);
			certtypeRole.setRolename(byId.getRoleName());
			certtypeRole.setRoleid(byId.getRoleCode());
			certtypeRoleService.save(certtypeRole);
		}
		else {
			String[] split = certtypeRole.getRolename().split(",");
			for (String roleid:split
				 ) {
				certtypeRole.setId(UUID.randomUUID().toString());
				SysRole byId = sysRoleService.getById(roleid);
				certtypeRole.setRolename(byId.getRoleName());
				certtypeRole.setRoleid(byId.getRoleCode());
				certtypeRoleService.save(certtypeRole);
			}
		}

		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param certtypeRole
	 * @return
	 */
	@AutoLog(value = "证照类型权限-编辑")
	@ApiOperation(value="证照类型权限-编辑", notes="证照类型权限-编辑")
//	@RequiresPermissions("dzzz.certtyperole:certtype_role:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody CerttypeRole certtypeRole) {
		certtypeRoleService.updateById(certtypeRole);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "证照类型权限-通过id删除")
	@ApiOperation(value="证照类型权限-通过id删除", notes="证照类型权限-通过id删除")
//	@RequiresPermissions("dzzz.certtyperole:certtype_role:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		certtypeRoleService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "证照类型权限-批量删除")
	@ApiOperation(value="证照类型权限-批量删除", notes="证照类型权限-批量删除")
//	@RequiresPermissions("dzzz.certtyperole:certtype_role:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.certtypeRoleService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "证照类型权限-通过id查询")
	@ApiOperation(value="证照类型权限-通过id查询", notes="证照类型权限-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<CerttypeRole> queryById(@RequestParam(name="id",required=true) String id) {
		CerttypeRole certtypeRole = certtypeRoleService.getById(id);
		if(certtypeRole==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(certtypeRole);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param certtypeRole
    */
//    @RequiresPermissions("dzzz.certtyperole:certtype_role:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, CerttypeRole certtypeRole) {
        return super.exportXls(request, certtypeRole, CerttypeRole.class, "证照类型权限");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
//    @RequiresPermissions("dzzz.certtyperole:certtype_role:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, CerttypeRole.class);
    }

}
