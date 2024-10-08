package org.jeecg.modules.demo.dzzz.information.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.val;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.jeecg.common.api.vo.Result;
import org.jeecg.modules.demo.dzzz.certStatistics.util.zzUtil.ValidateUtil;
import org.jeecg.modules.demo.dzzz.constant.YwConstant;
import org.jeecg.modules.demo.dzzz.information.entity.Information;
import org.jeecg.modules.demo.dzzz.information.entity.InformationZ;
import org.jeecg.modules.demo.dzzz.information.service.IInformationService;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;

 /**
 * @Description: 企业信息表
 * @Author: jeecg-boot
 * @Date:   2024-04-16
 * @Version: V1.0
 */
@Api(tags="企业信息表")
@RestController
@RequestMapping("/dzzz.information/information")
@Slf4j
public class InformationController extends JeecgController<Information, IInformationService> {
	@Autowired
	private IInformationService informationService;
	
	/**
	 * 分页列表查询
	 *
	 * @param information
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "企业信息表-分页列表查询")
	@ApiOperation(value="企业信息表-分页列表查询", notes="企业信息表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Information>> queryPageList(Information information,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) throws InvocationTargetException, IllegalAccessException {

		LambdaQueryWrapper<Information> queryWrapper = new LambdaQueryWrapper<>();
		if (null != information) {
			if (StringUtils.isNotBlank(information.getAdmindivision())) {
				String admindivision = information.getAdmindivision();
				if (YwConstant.HBS_CODE.equals(admindivision)) {
					queryWrapper.likeRight(Information :: getAdmindivision, YwConstant.HBS_LIKE);
				} else if (YwConstant.WHS_CODE.equals(admindivision)) {
					queryWrapper.likeRight(Information :: getAdmindivision, YwConstant.WHS_LIKE);
				} else {
					queryWrapper.eq(Information :: getAdmindivision, admindivision);
				}
			}

			if (StringUtils.isNotBlank(information.getEntzzjgdm())) {
				queryWrapper.like(Information :: getEntzzjgdm, information.getEntzzjgdm());
			}
			if (StringUtils.isNotBlank(information.getEntname())) {
				queryWrapper.like(Information :: getEntname, information.getEntname());
			}
		}
		queryWrapper.isNotNull(Information :: getAdmindivision);

//		QueryWrapper<Information> queryWrapper = QueryGenerator.initQueryWrapper(information, req.getParameterMap());
		/*if(StringUtils.isNotBlank(information.getZslx())){
			String sql= " SELECT ci.QYID FROM \"JEECG-BOOT\".\"CERT_INFO\" ci ,\"JEECG-BOOT\".\"cert_type\" ct " +
					" WHERE  ci.CERTTYPEID =ct.id AND  ct.\"certtype_classification\" = '"+information.getZslx()+"'";
			queryWrapper.inSql("id",sql);
		}*/

		Page<Information> page = new Page<Information>(pageNo, pageSize);
		IPage<Information> pageList = informationService.page(page, queryWrapper);
		List<Information> informationList = pageList.getRecords();
		informationList.forEach(bean -> {
			int zsNum = informationService.selectZsCount(bean.getEntzzjgdm());
			bean.setZsNum(zsNum);
		});

//		List<InformationZ> informationListz = new ArrayList<>();
//		BeanUtilsBean notNull = new BeanUtilsBean() {
//			@Override
//			public void copyProperty(Object dest, String name, Object value) throws IllegalAccessException, InvocationTargetException, InvocationTargetException, InvocationTargetException {
//				if (!"records".equals(name)) {
//					super.copyProperty(dest, name, value);
//				}
//			}
//		};
//		IPage<InformationZ> resultList = new Page<>();
//		notNull.copyProperties(resultList, pageList);
//		resultList.setCurrent(pageList.getCurrent());
//		resultList.setSize(pageList.getSize());
//		resultList.setTotal(pageList.getTotal());
//		for (Information information1 : informationList) {
//			StringBuffer stringBuffer = new StringBuffer();
//			String shxydm = information1.getEntzzjgdm();
//			List<Map> rMap = informationService.getZsbh(shxydm);
//			if(ValidateUtil.isNotEmpty(rMap)){
//				for (Map map : rMap) {
//					String zsbh = map.get("zsbh").toString();
//					stringBuffer.append(zsbh);
//					stringBuffer.append(",");
//				}
//			}
//			InformationZ informationZ = new InformationZ();
//			BeanUtils.copyProperties(information1,informationZ );
//			if(!ValidateUtil.isEmpty(stringBuffer)){
//				informationZ.setZsbh(String.valueOf(stringBuffer));
//			}
//			informationListz.add(informationZ);
//			System.out.println(rMap);
//		}
//		resultList.setRecords(informationListz);
		return Result.OK(pageList);
	}

	 /**
	  * 导出excel
	  *
	  * @param request
	  * @param information
	  */
//    @RequiresPermissions("dzzz.information:information:exportXls")
	 @RequestMapping(value = "/exportXls")
	 public ModelAndView exportXls(HttpServletRequest request, Information information) {
		 return super.exportXls(request, information, Information.class, "企业信息表");
	 }

	/**
	 *   添加
	 *
	 * @param information
	 * @return
	 */
	@AutoLog(value = "企业信息表-添加")
	@ApiOperation(value="企业信息表-添加", notes="企业信息表-添加")
//	@RequiresPermissions("dzzz.information:information:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Information information) {
		informationService.save(information);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param information
	 * @return
	 */
	@AutoLog(value = "企业信息表-编辑")
	@ApiOperation(value="企业信息表-编辑", notes="企业信息表-编辑")
//	@RequiresPermissions("dzzz.information:information:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Information information) {
		informationService.updateById(information);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "企业信息表-通过id删除")
	@ApiOperation(value="企业信息表-通过id删除", notes="企业信息表-通过id删除")
//	@RequiresPermissions("dzzz.information:information:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		informationService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "企业信息表-批量删除")
	@ApiOperation(value="企业信息表-批量删除", notes="企业信息表-批量删除")
//	@RequiresPermissions("dzzz.information:information:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.informationService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "企业信息表-通过id查询")
	@ApiOperation(value="企业信息表-通过id查询", notes="企业信息表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Information> queryById(@RequestParam(name="id",required=true) String id) {
		Information information = informationService.getById(id);
		if(information==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(information);
	}

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
//    @RequiresPermissions("dzzz.information:information:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Information.class);
    }

}
