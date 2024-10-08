package org.jeecg.modules.demo.dzzz.wgz.controller;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.shiro.SecurityUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.api.ISysBaseAPI;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.vo.LoginUser;
import org.jeecg.common.util.DateUtils;
import org.jeecg.modules.demo.dzzz.certStatistics.service.IQylxtjService;
import org.jeecg.modules.demo.dzzz.certinfo.entity.queryBean;
import org.jeecg.modules.demo.dzzz.certmode.entity.CertMode;
import org.jeecg.modules.demo.dzzz.certmode.service.ICertModeService;
import org.jeecg.modules.demo.dzzz.certtype.service.ICertTypeService;
import org.jeecg.modules.demo.dzzz.constant.YwConstant;
import org.jeecg.modules.demo.dzzz.util.CertUtils;
import org.jeecg.modules.demo.dzzz.wgz.entity.ZsYwxxb;
import org.jeecg.modules.demo.dzzz.wgz.entity.ZsYwxxbdrop;
import org.jeecg.modules.demo.dzzz.wgz.service.IZsYwxxbService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.commons.beanutils.BeanUtils;

 /**
 * @Description: zs_ywxxb
 * @Author: jeecg-boot
 * @Date:   2024-06-27
 * @Version: V1.0
 */
@Api(tags="zs_ywxxb")
@RestController
@RequestMapping("/dzzz.wgz/zsYwxxb")
@Slf4j
public class ZsYwxxbController extends JeecgController<ZsYwxxb, IZsYwxxbService> {
	@Autowired
	private IZsYwxxbService zsYwxxbService;


	@Autowired
	private IQylxtjService iQylxtjService;
	 @Autowired
	 ICertModeService iCertModeService;

	 @Autowired
	 private ISysBaseAPI sysBaseApi;

	 @Autowired
	 private ICertTypeService iCertTypeService;

	/**
	 * 分页列表查询
	 *
	 * @param zsYwxxb
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "zs_ywxxb-分页列表查询")
	@ApiOperation(value="zs_ywxxb-分页列表查询", notes="zs_ywxxb-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<ZsYwxxbdrop>> queryPageList(ZsYwxxb zsYwxxb, queryBean queryBean,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
												HttpServletRequest req) throws IllegalAccessException, InvocationTargetException {
		String cx="";
		if("cx".equals(zsYwxxb.getZt())&& StringUtils.isNotBlank(zsYwxxb.getZsdl()))
		{
			cx=zsYwxxb.getZsdl();
			zsYwxxb.setZt(null);
			zsYwxxb.setZsdl(null);
		}
		QueryWrapper<ZsYwxxb> queryWrapper = QueryGenerator.initQueryWrapper(zsYwxxb, req.getParameterMap());
		Page<ZsYwxxb> page = new Page<ZsYwxxb>(pageNo, pageSize);

		/**
		 * 如果证书类型为空，则判断证书大类是否为空，不为空则查询大类下有权限的证书类型
		 */
		LoginUser loginUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
		if (StringUtils.isBlank(zsYwxxb.getCerttypeid())) {
			if (StringUtils.isNotBlank(queryBean.getZslb())) {
				//获取当前登录用户角色

				List<String> roleIdsByUsername = sysBaseApi.getRolesByUsername(loginUser.getUsername());
				if (CollectionUtils.isEmpty(roleIdsByUsername)) {
					return Result.OK(new Page<>());
				}
				Map<String, Object> param = new HashMap<>();
				param.put("roleId", roleIdsByUsername.get(0));
				param.put("status", "2");
				param.put("classification", queryBean.getZslb());
				List<String> certtypeIds = iCertTypeService.getCerttypeIdByClassificationAndRole(param);
				if (CollectionUtils.isNotEmpty(certtypeIds)) {
					queryWrapper.in("CERTTYPEID", certtypeIds);
				} else {
					return Result.OK(new Page<>());
				}
			}
		}

		//根据登陆用户查询用户部门
		List<String> departIdsByUsername = sysBaseApi.getDepartIdsByUsername(loginUser.getUsername());
		if (org.apache.commons.collections4.CollectionUtils.isNotEmpty(departIdsByUsername)) {
			// 默认机构为f
			boolean isJgyh = false;
			//把枚举转行成list
			List<String> jgyhList = Arrays.stream(YwConstant.FZJGID).collect(Collectors.toList());
			for (String departId : departIdsByUsername) {
				//判断是否包含
				if (jgyhList.contains(departId)) {
					isJgyh = true;
					break;
				}
			}
			if (!isJgyh){
				queryWrapper.in("FZJGID", departIdsByUsername);
			}
		}
		//同步数据服务 单独的
		/*List<CertType> typelist = iCertTypeService.list(null);
		for (CertType cert:typelist
			 ) {
			String zslx = cert.getZslx();
			QueryWrapper queryWrapper1=new QueryWrapper();
			queryWrapper1.eq("zslx",zslx);
			List <CertMetadata> certmetalist = iCertMetadataService.list(queryWrapper1);
			for (CertMetadata CertMetadata:certmetalist
				 ) {
				QueryWrapper queryWrapper2=new QueryWrapper();
				queryWrapper2.eq("id",CertMetadata.getBbid());
				List<CertMetadataVersion> certMetadataVersionslist = iCertMetadataVersionService.list(queryWrapper2);
				if(certMetadataVersionslist!=null&&certMetadataVersionslist.size()>0)
				{
					CertMetadataVersion certMetadataVersion = certMetadataVersionslist.get(0);
					CertMetadata.setCertmetadataversionId(certMetadataVersion.getId());
					iCertMetadataService.updateById(CertMetadata);
					System.out.println("成功");
				}

			}
		}*/
		if(StringUtils.isNotBlank(queryBean.getDlzslx()))
		{
			queryWrapper.eq("certtypeid",queryBean.getDlzslx());
		}
		if(StringUtils.isNotBlank(queryBean.getDlzszt()))
		{  //有效
			if("0".equals(queryBean.getDlzszt()))
			{
				queryWrapper.eq("yxzt","10");
			}
			if("1".equals(queryBean.getDlzszt()))
			{

				queryWrapper.lt("yxqz", DateUtils.formatDate(new Date(),"yyyy-MM-dd hh:mm:ss"));
			}
			if("2".equals(queryBean.getDlzszt()))
			{

				queryWrapper.eq("yxzt","50" );

			}

		}
		if (StringUtils.isNotBlank(queryBean.getBeginDate())) {
			queryWrapper.ge("fzrq",queryBean.getBeginDate());
		}
		if (StringUtils.isNotBlank(queryBean.getEndDate())) {
			queryWrapper.le("fzrq",queryBean.getEndDate());
		}
		if(StringUtils.isBlank(cx))
		{
			queryWrapper.eq("yxzt","10");

		}
		if(StringUtils.isNotBlank(cx)){

			String sql= " SELECT ci.id FROM CERT_INFO ci ,cert_type ct " +
					" WHERE  ci.CERTTYPEID =ct.id AND  ct.certtype_classification = '"+cx+"'";
			queryWrapper.inSql("id",sql);
		}
		queryWrapper.orderByDesc("fzrq");


		IPage<ZsYwxxb> pageList = zsYwxxbService.page(page, queryWrapper);
		IPage<ZsYwxxbdrop> resultList = new Page<>();
		// 使用自定义的 BeanUtilsBean 来忽略特定属性
		BeanUtilsBean notNull = new BeanUtilsBean() {
			@Override
			public void copyProperty(Object dest, String name, Object value) throws IllegalAccessException, InvocationTargetException, InvocationTargetException {
				if (!"records".equals(name)) {
					super.copyProperty(dest, name, value);
				}
			}
		};

		notNull.copyProperties(resultList, pageList);
		resultList.setCurrent(pageList.getCurrent());
		resultList.setSize(pageList.getSize());
		resultList.setTotal(pageList.getTotal());

		//定义type和isall的关系

		resultList.setRecords(CertUtils.addAttachInfo(pageList.getRecords(), "WGZ", ZsYwxxbdrop.class));


		//todo:在这边的record里面添加一个返回字段，用于前端来判断下拉选的内筒
		return Result.OK(resultList);
	}

	/**
	 *   添加
	 *
	 * @param zsYwxxb
	 * @return
	 */
	@AutoLog(value = "zs_ywxxb-添加")
	@ApiOperation(value="zs_ywxxb-添加", notes="zs_ywxxb-添加")
	@RequiresPermissions("dzzz.wgz:zs_ywxxb:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody ZsYwxxb zsYwxxb) {
		zsYwxxbService.save(zsYwxxb);
		return Result.OK("添加成功！");
	}

	/**
	 *  编辑
	 *
	 * @param zsYwxxb
	 * @return
	 */
	@AutoLog(value = "zs_ywxxb-编辑")
	@ApiOperation(value="zs_ywxxb-编辑", notes="zs_ywxxb-编辑")
	@RequiresPermissions("dzzz.wgz:zs_ywxxb:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody ZsYwxxb zsYwxxb) {
		zsYwxxbService.updateById(zsYwxxb);
		return Result.OK("编辑成功!");
	}

	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "zs_ywxxb-通过id删除")
	@ApiOperation(value="zs_ywxxb-通过id删除", notes="zs_ywxxb-通过id删除")
	@RequiresPermissions("dzzz.wgz:zs_ywxxb:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		zsYwxxbService.removeById(id);
		return Result.OK("删除成功!");
	}

	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "zs_ywxxb-批量删除")
	@ApiOperation(value="zs_ywxxb-批量删除", notes="zs_ywxxb-批量删除")
	@RequiresPermissions("dzzz.wgz:zs_ywxxb:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.zsYwxxbService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}

	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "zs_ywxxb-通过id查询")
	@ApiOperation(value="zs_ywxxb-通过id查询", notes="zs_ywxxb-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<ZsYwxxb> queryById(@RequestParam(name="id",required=true) String id) {
		ZsYwxxb zsYwxxb = zsYwxxbService.getById(id);
		if(zsYwxxb==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(zsYwxxb);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param zsYwxxb
    */
    @RequiresPermissions("dzzz.wgz:zs_ywxxb:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, ZsYwxxb zsYwxxb) {
        return super.exportXls(request, zsYwxxb, ZsYwxxb.class, "zs_ywxxb");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("dzzz.wgz:zs_ywxxb:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, ZsYwxxb.class);
    }


}
