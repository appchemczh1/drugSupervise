package org.jeecg.modules.demo.dzzz.dataExchange.controller;

import java.util.List;
import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.config.JeecgBaseConfig;
import org.jeecg.modules.demo.dzzz.certtype.service.ICertTypeService;
import org.jeecg.modules.demo.dzzz.constant.YwConstant;
import org.jeecg.modules.demo.dzzz.dataExchange.entity.TYwSjJlb;
import org.jeecg.modules.demo.dzzz.dataExchange.service.ITYwSjJlbService;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecg.modules.demo.dzzz.dataExchange.vo.SjjlbReqVo;
import org.jeecg.modules.demo.dzzz.dataExchange.vo.SjjlbResVo;
import org.jeecg.modules.demo.dzzz.enums.YwlxEnum;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

 /**
 * @Description: 数据交换情况
 * @Author: jeecg-boot
 * @Date:   2024-07-02
 * @Version: V1.0
 */
@Api(tags="数据交换情况")
@RestController
@RequestMapping("/dataExchange")
@Slf4j
public class TYwSjJlbController extends JeecgController<TYwSjJlb, ITYwSjJlbService> {
	 @Autowired
	 private ITYwSjJlbService tYwSjJlbService;
	 @Autowired
	 private ICertTypeService certTypeService;
	 @Resource
	 private JeecgBaseConfig jeecgBaseConfig;

	 /**
	  * 数据交换情况-分页列表查询
	  * @param vo
	  * @param pageNo
	  * @param pageSize
	  * @return
	  */
	 @ApiOperation(value="数据交换情况-分页列表查询", notes="数据交换情况-分页列表查询")
	 @GetMapping(value = "/queryPageList")
	 public Result<IPage<SjjlbResVo>> queryPageList(SjjlbReqVo vo,
													@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
													@RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
		 Page<SjjlbReqVo> page = new Page<>(pageNo, pageSize);
		 return this.selectPageList(vo, page);
	 }

	 /**
	  * 分页查询
	  * @param vo
	  * @param page
	  * @return
	  */
	 private Result<IPage<SjjlbResVo>> selectPageList(SjjlbReqVo vo, Page<SjjlbReqVo> page) {
		 IPage<SjjlbResVo> pageList = tYwSjJlbService.selectPageList(vo, page);
		 List<SjjlbResVo> recordList = pageList.getRecords();
		 recordList.forEach(bean -> {
			 // 业务类型翻译
			 if (StringUtils.isNotBlank(bean.getYwlx())) {
				 bean.setYwlxName(YwlxEnum.getYwlxName(bean.getYwlx()));
			 }
			 if (null != bean.getJlzt()) {
				 bean.setJlztName(YwConstant.CONFIRM == bean.getJlzt().intValue() ? YwConstant.SUCCESS_MSG : YwConstant.FAIL_MSG);
			 }
		 });
		 return Result.OK(pageList);
	 }

	 /**
	  * 导出excel
	  * @param vo
	  * @return
	  */
	 @ApiOperation(value = "数据交换情况-导出excel", notes = "数据交换情况-导出excel")
	 @RequestMapping(value = "/exportXls")
	 public ModelAndView exportXls(SjjlbReqVo vo) {
		 return dealExportXls(vo);
	 }

	 /**
	  * 导出Excel
	  * @param vo
	  * @return
	  */
	 private ModelAndView dealExportXls(SjjlbReqVo vo) {
		 List<SjjlbResVo> exportList = tYwSjJlbService.listByParams(vo);
		 exportList.forEach(bean -> {
			 // 业务类型翻译
			 if (StringUtils.isNotBlank(bean.getYwlx())) {
				 bean.setYwlxName(YwlxEnum.getYwlxName(bean.getYwlx()));
			 }
			 if (null != bean.getJlzt()) {
				 bean.setJlztName(YwConstant.CONFIRM == bean.getJlzt().intValue() ? YwConstant.SUCCESS_MSG : YwConstant.FAIL_MSG);
			 }
		 });
		 String title = YwConstant.JLLY_WHSJ.equals(vo.getJlly()) ? YwConstant.WHSJ_LOG : YwConstant.SSCJ_LOG;
		 ModelAndView mv = new ModelAndView(new JeecgEntityExcelView());
		 mv.addObject(NormalExcelConstants.FILE_NAME, title);
		 mv.addObject(NormalExcelConstants.CLASS, SjjlbResVo.class);
		 ExportParams exportParams = new ExportParams(title + "报表", null, title);
		 exportParams.setImageBasePath(jeecgBaseConfig.getPath().getUpload());
		 mv.addObject(NormalExcelConstants.PARAMS, exportParams);
		 mv.addObject(NormalExcelConstants.DATA_LIST, exportList);
		 return mv;
	 }

}