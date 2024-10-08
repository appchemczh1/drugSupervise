package org.jeecg.modules.demo.dzzz.certInfoOperation.controller;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.apache.commons.lang.StringUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.demo.dzzz.certInfoOperation.entity.CertInfoOperationDetail;
import org.jeecg.modules.demo.dzzz.certInfoOperation.entity.CertInfoOperationRecord;
import org.jeecg.modules.demo.dzzz.certInfoOperation.service.ICertInfoOperationDetailService;
import org.jeecg.modules.demo.dzzz.certInfoOperation.service.ICertInfoOperationRecordService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.modules.demo.dzzz.certinfo.entity.queryBean;
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
 * @Description: 操作记录表
 * @Author: jeecg-boot
 * @Date:   2024-04-17
 * @Version: V1.0
 */
@Api(tags="操作记录表")
@RestController
@RequestMapping("/dzzz/certInfoOperationRecord")
@Slf4j
public class CertInfoOperationRecordController extends JeecgController<CertInfoOperationRecord, ICertInfoOperationRecordService> {
	@Autowired
	private ICertInfoOperationRecordService certInfoOperationRecordService;
	@Autowired
	private ICertInfoOperationDetailService certInfoOperationDetailService;

	/**
	 * 分页列表查询
	 *
	 * @param certInfoOperationRecord
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "操作记录表-分页列表查询")

	@ApiOperation(value="操作记录表-分页列表查询", notes="操作记录表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<CertInfoOperationRecord>> queryPageList(CertInfoOperationRecord certInfoOperationRecord,
																@RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
																@RequestParam(name="pageSize", defaultValue="10") Integer pageSize, queryBean queryBean,
								   HttpServletRequest req) {
		QueryWrapper<CertInfoOperationRecord> queryWrapper = QueryGenerator.initQueryWrapper(certInfoOperationRecord, req.getParameterMap());
	/*	queryWrapper.ne("STUTAS","20");//只有变更记录
		queryWrapper.ne("old_data_flag","20");//只有变更记录
		queryWrapper.ne("bglx","10");//*/
		queryWrapper.eq("STUTAS","20");
/*
		queryWrapper.lt("bglx","50");
*/

		/*queryWrapper.orderByAsc("CREATE_TIME");*/

       if(certInfoOperationRecord.getZsid()==null)
	   {
		   return  null;
	   }

		queryWrapper.orderByDesc("czsj");

		if("1".equals(queryBean.getIwgz())) {
			if (StringUtils.isNotBlank(queryBean.getIsdq())) {
				queryWrapper.and(q -> q.isNull("GZSTUTAS").or().ne("GZSTUTAS", "1"));
			}
			if (StringUtils.isBlank(queryBean.getIsdq())) {
				queryWrapper.eq("GZSTUTAS", "1");
			}
		}

		Page<CertInfoOperationRecord> page = new Page<CertInfoOperationRecord>(pageNo, pageSize);
		IPage<CertInfoOperationRecord> pageList = certInfoOperationRecordService.page(page, queryWrapper);
		if (!"false".equals(req.getParameter("mergeBgnr"))) {
			//拼接变更内容和变更原因
			List<CertInfoOperationRecord> records = pageList.getRecords();
			for (CertInfoOperationRecord record : records) {
				if (StringUtils.isNotBlank(record.getBgnr()) && StringUtils.isNotBlank(record.getBgyy())) {
					record.setBgnr(record.getBgnr() + record.getBgyy());
				} else if (StringUtils.isBlank(record.getBgnr()) && StringUtils.isNotBlank(record.getBgyy())) {
					record.setBgnr(record.getBgyy());
				}
			}
			pageList.setRecords(records);
		}
		/*List<CertInfoOperationRecord> records = pageList.getRecords();
		Iterator<CertInfoOperationRecord> iterator = records.iterator();
		while (iterator.hasNext())
		{
			CertInfoOperationRecord cert = iterator.next();
			if (StringUtils.isBlank(cert.getBgsj()))
			{
				if(StringUtils.isNotBlank(cert.getSjbgnr()))
				{
					cert.setBgsj(cert.getSjbgnr());//切换成实际变更内容
				}
				else{
				     iterator.remove();
			    }
			}
		}*/


		return Result.OK(pageList);
	}

	/**
	 *   添加
	 *
	 * @param certInfoOperationRecord
	 * @return
	 */
	@AutoLog(value = "操作记录表-添加")
	@ApiOperation(value="操作记录表-添加", notes="操作记录表-添加")
//	@RequiresPermissions("dzzz:cert_info_operation_record:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody CertInfoOperationRecord certInfoOperationRecord) {
		certInfoOperationRecordService.save(certInfoOperationRecord);
		return Result.OK("添加成功！");
	}

	/**
	 *  编辑
	 *
	 * @param certInfoOperationRecord
	 * @return
	 */
	@AutoLog(value = "操作记录表-编辑")
	@ApiOperation(value="操作记录表-编辑", notes="操作记录表-编辑")
//	@RequiresPermissions("dzzz:cert_info_operation_record:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody List<CertInfoOperationRecord> certInfoOperationRecord) {
		//变更详情 是否也要变 ，如果要变  短时间变不了 要重新改变架构 设计功能
		for (CertInfoOperationRecord cert:certInfoOperationRecord
			 ) {
			//维护时产生的临时数据+copy区分 并且记忆
			String id = cert.getId();
			cert.setId(cert.getId() + "copy");
			cert.setZsid(cert.getId() + "copy");

			CertInfoOperationRecord byId = certInfoOperationRecordService.getById(cert.getId());
			LambdaQueryWrapper<CertInfoOperationDetail> queryWrapper=new LambdaQueryWrapper();
			queryWrapper.eq(CertInfoOperationDetail::getCzsjid,id);
			List<CertInfoOperationDetail> detailslist = certInfoOperationDetailService.list(queryWrapper);
			String bgnr = cert.getBgnr();
			 if(bgnr.contains(";"))
			 {
				 String[] split = bgnr.split(";");
				 for (String nr:split
					  ) {
					 //对变更内容进行拆分 匹配
					 if(StringUtils.isNotBlank(nr)&&nr.contains("由")&&nr.contains("变更为"))
					 {
						 String[] nrs = nr.split("由");
						 String field = nrs[0];
						 String regex = "\\[(.*?)\\]";
						 Pattern pattern = Pattern.compile(regex);
						 Matcher matcher = pattern.matcher(nrs[1]);
                         String bgq="";
						 String bgh="";
						 while (matcher.find()) {
							 System.out.println(matcher.group(1));
							 bgq=matcher.group(1);
							 bgh=matcher.group(2);
							 System.out.println(matcher.group(2));
						 }
                         //拆分后与变更详情相互比较
						 for (CertInfoOperationDetail certdetail:detailslist
							  ) {
							  if(field.equals(certdetail.getBgzdmc().trim()))
							  {
								  if(!bgq.equals(certdetail.getZdlszt()))
								  {
									  certdetail.setZdlszt(bgq);
								  }
								  if(!bgh.equals(certdetail.getZdxz()))
								  {
									  certdetail.setZdlszt(bgh);
								  }
								  certdetail.setZsid(certdetail.getZsid()+"copy");
								  certdetail.setId(certdetail.getId()+"copy");
								  CertInfoOperationDetail certdetailnew = certInfoOperationDetailService.getById(certdetail.getId());
								 if(certdetailnew==null)
								 {
									 certInfoOperationDetailService.save(certdetail);
								 }
								 else {
									 certInfoOperationDetailService.updateById(certdetail);
								 }
							  }
						 }

					 }
				 }
			 }

			if(byId==null) {
				certInfoOperationRecordService.save(cert);
			}
			else {
				certInfoOperationRecordService.updateById(cert);

			}

		}

		return Result.OK("编辑成功!");
	}

	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "操作记录表-通过id删除")
	@ApiOperation(value="操作记录表-通过id删除", notes="操作记录表-通过id删除")
//	@RequiresPermissions("dzzz:cert_info_operation_record:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		certInfoOperationRecordService.removeById(id);
		return Result.OK("删除成功!");
	}

	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "操作记录表-批量删除")
	@ApiOperation(value="操作记录表-批量删除", notes="操作记录表-批量删除")
//	@RequiresPermissions("dzzz:cert_info_operation_record:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.certInfoOperationRecordService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}

	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "操作记录表-通过id查询")
	@ApiOperation(value="操作记录表-通过id查询", notes="操作记录表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<CertInfoOperationRecord> queryById(@RequestParam(name="id",required=true) String id) {
		CertInfoOperationRecord certInfoOperationRecord = certInfoOperationRecordService.getById(id);
		if(certInfoOperationRecord==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(certInfoOperationRecord);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param certInfoOperationRecord
    */
//    @RequiresPermissions("dzzz:cert_info_operation_record:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, CertInfoOperationRecord certInfoOperationRecord) {
        return super.exportXls(request, certInfoOperationRecord, CertInfoOperationRecord.class, "操作记录表");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
//    @RequiresPermissions("dzzz:cert_info_operation_record:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, CertInfoOperationRecord.class);
    }

}
