package org.jeecg.modules.demo.dzzz.certmatadataversion.controller;

import java.io.UnsupportedEncodingException;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.vo.LoginUser;
import org.apache.shiro.SecurityUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.demo.dzzz.certmatadataversion.entity.CertMetadata;
import org.jeecg.modules.demo.dzzz.certmatadataversion.entity.CertMetadataVersion;
import org.jeecg.modules.demo.dzzz.certmatadataversion.vo.CertMetadataVersionPage;
import org.jeecg.modules.demo.dzzz.certmatadataversion.service.ICertMetadataVersionService;
import org.jeecg.modules.demo.dzzz.certmatadataversion.service.ICertMetadataService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;


 /**
 * @Description: 证书元数据版本
 * @Author: jeecg-boot
 * @Date:   2024-03-25
 * @Version: V1.0
 */
@Api(tags="证书元数据版本")
@RestController
@RequestMapping("/dzzz/certMetadataVersion")
@Slf4j
public class CertMetadataVersionController {
	@Autowired
	private ICertMetadataVersionService certMetadataVersionService;
	@Autowired
	private ICertMetadataService certMetadataService;
	
	/**
	 * 分页列表查询
	 *
	 * @param certMetadataVersion
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "证书元数据版本-分页列表查询")
	@ApiOperation(value="证书元数据版本-分页列表查询", notes="证书元数据版本-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<CertMetadataVersion>> queryPageList(CertMetadataVersion certMetadataVersion,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {

		QueryWrapper<CertMetadataVersion> queryWrapper = QueryGenerator.initQueryWrapper(certMetadataVersion, req.getParameterMap());
		Page<CertMetadataVersion> page = new Page<CertMetadataVersion>(pageNo, pageSize);
		IPage<CertMetadataVersion> pageList = certMetadataVersionService.page(page, queryWrapper);
		return Result.OK(pageList);
	}

	/**
	 *   添加
	 *
	 * @param certMetadataVersionPage
	 * @return
	 */
	@AutoLog(value = "证书元数据版本-添加")
	@ApiOperation(value="证书元数据版本-添加", notes="证书元数据版本-添加")
/*
    @RequiresPermissions("dzzz.certmatadataversion:cert_metadata_version:add")
*/
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody CertMetadataVersionPage certMetadataVersionPage,HttpServletRequest req) {
		CertMetadataVersion certMetadataVersion = new CertMetadataVersion();
		BeanUtils.copyProperties(certMetadataVersionPage, certMetadataVersion);

		QueryWrapper<CertMetadataVersion> queryWrapper =new QueryWrapper<>();
		queryWrapper.eq("cert_type_id",certMetadataVersion.getCertTypeId());
		//判断在用版本
		queryWrapper.eq("status","1");
		List<CertMetadataVersion> list = certMetadataVersionService.list(queryWrapper);
		boolean flag=true;
		if("1".equals(certMetadataVersion.getStatus())) {
			for (CertMetadataVersion cer : list
			) {
				if ("1".equals(cer.getStatus())) {
					flag = false;
				}
			}
		}
		if(flag) {
			certMetadataVersionService.saveMain(certMetadataVersion, certMetadataVersionPage.getCertMetadataList());

			return Result.OK("添加成功！");
		}
		else {
			return Result.error(500,"新增版本失败，已存在启用版本，可先保存为待用，将启用版本禁用，再将本版本启用");
		}
	}
	
	/**
	 *  编辑
	 *
	 * @param certMetadataVersionPage
	 * @return
	 */
	@AutoLog(value = "证书元数据版本-编辑")
	@ApiOperation(value="证书元数据版本-编辑", notes="证书元数据版本-编辑")
//    @RequiresPermissions("dzzz.certmatadataversion:cert_metadata_version:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody CertMetadataVersionPage certMetadataVersionPage) {
		CertMetadataVersion certMetadataVersion = new CertMetadataVersion();
		BeanUtils.copyProperties(certMetadataVersionPage, certMetadataVersion);
		CertMetadataVersion certMetadataVersionEntity = certMetadataVersionService.getById(certMetadataVersion.getId());
		if(certMetadataVersionEntity==null) {
			return Result.error("未找到对应数据");
		}
		certMetadataVersionService.updateMain(certMetadataVersion, certMetadataVersionPage.getCertMetadataList());
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "证书元数据版本-通过id删除")
	@ApiOperation(value="证书元数据版本-通过id删除", notes="证书元数据版本-通过id删除")
//    @RequiresPermissions("dzzz.certmatadataversion:cert_metadata_version:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		certMetadataVersionService.delMain(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "证书元数据版本-批量删除")
	@ApiOperation(value="证书元数据版本-批量删除", notes="证书元数据版本-批量删除")
//    @RequiresPermissions("dzzz.certmatadataversion:cert_metadata_version:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.certMetadataVersionService.delBatchMain(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功！");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "证书元数据版本-通过id查询")
	@ApiOperation(value="证书元数据版本-通过id查询", notes="证书元数据版本-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<CertMetadataVersion> queryById(@RequestParam(name="id",required=true) String id) {
		CertMetadataVersion certMetadataVersion = certMetadataVersionService.getById(id);
		if(certMetadataVersion==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(certMetadataVersion);

	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "证书元数据表通过主表ID查询")
	@ApiOperation(value="证书元数据表主表ID查询", notes="证书元数据表-通主表ID查询")
	@GetMapping(value = "/queryCertMetadataByMainId")
	public Result<List<CertMetadata>> queryCertMetadataListByMainId(@RequestParam(name="id",required=true) String id) {
		List<CertMetadata> certMetadataList = certMetadataService.selectByMainId(id);
		return Result.OK(certMetadataList);
	}

	 /**
	  * 通过id查询
	  *
	  * @param
	  * @return
	  */
	 //@AutoLog(value = "证书元数据表通过主表ID查询")
	 @ApiOperation(value="证书元数据表主表ID查询", notes="证书元数据表-通主表ID查询")
	 @GetMapping(value = "/queryCertinfoColumns")
	 public Result<List<CertMetadata>> queryCertinfoColumns(@RequestParam(name="lm",required=false) String lm) {
		 List<CertMetadata> certMetadataList = certMetadataService.querycertinfo(lm);
		 for (CertMetadata item : certMetadataList) {
			 item.setLbs(oConvertUtils.camelName(item.getLbs()));
			 item.setYssx(item.getLbs());
		 }
		 return Result.OK(certMetadataList);
	 }

    /**
    * 导出excel
    *
    * @param request
    * @param certMetadataVersion
    */
//    @RequiresPermissions("dzzz.certmatadataversion:cert_metadata_version:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, CertMetadataVersion certMetadataVersion) {
      // Step.1 组装查询条件查询数据
      QueryWrapper<CertMetadataVersion> queryWrapper = QueryGenerator.initQueryWrapper(certMetadataVersion, request.getParameterMap());
      LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();

      //配置选中数据查询条件
      String selections = request.getParameter("selections");
      if(oConvertUtils.isNotEmpty(selections)) {
         List<String> selectionList = Arrays.asList(selections.split(","));
         queryWrapper.in("id",selectionList);
      }
      //Step.2 获取导出数据
      List<CertMetadataVersion> certMetadataVersionList = certMetadataVersionService.list(queryWrapper);

      // Step.3 组装pageList
      List<CertMetadataVersionPage> pageList = new ArrayList<CertMetadataVersionPage>();
      for (CertMetadataVersion main : certMetadataVersionList) {
          CertMetadataVersionPage vo = new CertMetadataVersionPage();
          BeanUtils.copyProperties(main, vo);
          List<CertMetadata> certMetadataList = certMetadataService.selectByMainId(main.getId());
          vo.setCertMetadataList(certMetadataList);
          pageList.add(vo);
      }

      // Step.4 AutoPoi 导出Excel
      ModelAndView mv = new ModelAndView(new JeecgEntityExcelView());
      mv.addObject(NormalExcelConstants.FILE_NAME, "证书元数据版本列表");
      mv.addObject(NormalExcelConstants.CLASS, CertMetadataVersionPage.class);
      mv.addObject(NormalExcelConstants.PARAMS, new ExportParams("证书元数据版本数据", "导出人:"+sysUser.getRealname(), "证书元数据版本"));
      mv.addObject(NormalExcelConstants.DATA_LIST, pageList);
      return mv;
    }

    /**
    * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
//    @RequiresPermissions("dzzz.certmatadataversion:cert_metadata_version:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
      MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
      Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
      for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
          // 获取上传文件对象
          MultipartFile file = entity.getValue();
          ImportParams params = new ImportParams();
          params.setTitleRows(2);
          params.setHeadRows(1);
          params.setNeedSave(true);
          try {
              List<CertMetadataVersionPage> list = ExcelImportUtil.importExcel(file.getInputStream(), CertMetadataVersionPage.class, params);
              for (CertMetadataVersionPage page : list) {
                  CertMetadataVersion po = new CertMetadataVersion();
                  BeanUtils.copyProperties(page, po);
                  certMetadataVersionService.saveMain(po, page.getCertMetadataList());
              }
              return Result.OK("文件导入成功！数据行数:" + list.size());
          } catch (Exception e) {
              log.error(e.getMessage(),e);
              return Result.error("文件导入失败:"+e.getMessage());
          } finally {
              try {
                  file.getInputStream().close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
      }
      return Result.OK("文件导入失败！");
    }

}
