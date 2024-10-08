package org.jeecg.modules.demo.dzzz.certinfo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.SecurityUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.jeecg.common.constant.CommonConstant;
import org.jeecg.common.system.api.ISysBaseAPI;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.vo.LoginUser;
import org.jeecg.common.util.RedisUtil;
import org.jeecg.common.util.UUIDGenerator;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.demo.dzzz.attachinfo.entity.Attachinfo;
import org.jeecg.modules.demo.dzzz.certInfoOperation.entity.CertInfoOperationRecord;
import org.jeecg.modules.demo.dzzz.certInfoOperation.service.ICertInfoOperationRecordService;
import org.jeecg.modules.demo.dzzz.certStatistics.service.IQylxtjService;
import org.jeecg.modules.demo.dzzz.certarea.entity.CertArea;
import org.jeecg.modules.demo.dzzz.certarea.service.ICertAreaService;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertInfo;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertInfoIsType;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildCkomyly;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildDylylqxscbapz;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildMzyphjsypddsc;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildYlqxcpckxs;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildYlqxscbaZb;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildYlqxwlxsba;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildYlqxwtbaZb;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildYpckxkz;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildYpckxszm;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildYpscGmp;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildYpscSt;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildYpscWt;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildYpscZc;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchirdYlqxlcsyba;
import org.jeecg.modules.demo.dzzz.certinfo.entity.queryBean;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertHandleService;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertInfoService;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertchildCkomylyService;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertchildDylylqxscbapzService;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertchildMzyphjsypddscService;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertchildYlqxcpckxsService;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertchildYlqxscbaZbService;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertchildYlqxwlxsbaService;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertchildYlqxwtbaZbService;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertchildYpckxkzService;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertchildYpckxszmService;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertchildYpscGmpService;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertchildYpscStService;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertchildYpscWtService;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertchildYpscZcService;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertchirdYlqxlcsybaService;
import org.jeecg.modules.demo.dzzz.certinfo.vo.CertInfoPage;
import org.jeecg.modules.demo.dzzz.certmatadataversion.entity.CertMetadata;
import org.jeecg.modules.demo.dzzz.certmatadataversion.service.ICertMetadataService;
import org.jeecg.modules.demo.dzzz.certmatadataversion.service.ICertMetadataVersionService;
import org.jeecg.modules.demo.dzzz.certmode.service.ICertModeService;
import org.jeecg.modules.demo.dzzz.certtype.entity.CertType;
import org.jeecg.modules.demo.dzzz.certtype.service.ICertTypeService;
import org.jeecg.modules.demo.dzzz.certzminfo.entity.CertZminfo;
import org.jeecg.modules.demo.dzzz.constant.YwConstant;
import org.jeecg.modules.demo.dzzz.dataExchange.exception.YwException;
import org.jeecg.modules.demo.dzzz.dataExchange.util.YwUtil;
import org.jeecg.modules.demo.dzzz.dept.service.ISDeptService;
import org.jeecg.modules.demo.dzzz.enums.YwlxEnum;
import org.jeecg.modules.demo.dzzz.spht.entity.TYwZsN;
import org.jeecg.modules.demo.dzzz.spht.service.ITYwZsNService;
import org.jeecg.modules.demo.dzzz.util.CertUtils;
import org.jeecg.modules.demo.dzzz.util.DateUtils;
import org.jeecg.modules.demo.dzzz.util.ExcelExportUtils;
import org.jeecg.modules.demo.dzzz.wgz.entity.ZsYwxxb;
import org.jeecg.modules.demo.dzzz.wgz.service.IZsYwxxbService;
import org.jeecg.modules.system.util.WebUtils;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


/**
 * @Description: 电子证照源数据
 * @Author: jeecg-boot
 * @Date: 2024-03-27
 * @Version: V1.0
 */
@Api(tags = "电子证照源数据")
@RestController
@RequestMapping("/dzzz.certinfo/certInfo")
@Slf4j
public class CertInfoController {
    private static final Logger logger = LoggerFactory.getLogger(CertInfoController.class);
    @Autowired
    ITYwZsNService itYwZsNService;
    @Autowired
    ICertModeService iCertModeService;
    @Autowired
    private ICertInfoService certInfoService;
    @Autowired
    private ICertHandleService certHandleService;
    @Autowired
    private IZsYwxxbService iZsYwxxbService;
    @Autowired
    private ICertchildYpscZcService certchildYpscZcService;
    @Autowired
    private ICertchildYpscWtService certchildYpscWtService;
    @Autowired
    private ICertchildYpscStService certchildYpscStService;
    @Autowired
    private ICertchildYlqxwtbaZbService certchildYlqxwtbaZbService;
    @Autowired
    private ICertchildYlqxscbaZbService certchildYlqxscbaZbService;
    @Autowired
    private ICertchildYpckxkzService certchildYpckxkzService;
    @Autowired
    private ICertchirdYlqxlcsybaService certchirdYlqxlcsybaService;
    @Autowired
    private ICertchildYlqxcpckxsService certchildYlqxcpckxsService;
    @Autowired
    private ICertchildMzyphjsypddscService certchildMzyphjsypddscService;
    @Autowired
    private ICertchildYpckxszmService certchildYpckxszmService;
    @Autowired
    private ICertchildYpscGmpService certchildYpscGmpService;
    @Autowired
    private ICertchildCkomylyService certchildCkomylyService;
    @Autowired
    private ICertMetadataService iCertMetadataService;
    @Autowired
    private ICertTypeService iCertTypeService;
    @Autowired
    private ICertMetadataVersionService iCertMetadataVersionService;

    @Autowired
    private ICertInfoOperationRecordService iCertInfoOperationRecordService;
    @Autowired
    ICertInfoOperationRecordService certInfoOperationRecordService;

    @Autowired
    private ICertchildYlqxwlxsbaService certchildYlqxwlxsbaService;
    @Autowired
    private ICertchildDylylqxscbapzService certchildDylylqxscbapzService;


    @Autowired
    private IQylxtjService iQylxtjService;

    @Autowired
    private ISysBaseAPI sysBaseApi;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private ISDeptService deptService;
    @Autowired
    private ICertAreaService iCertAreaService;

    /**
     * 分页列表查询
     *
     * @param certInfo
     * @param pageNo
     * @param pageSize
     * @param req
     * @return
     */
    //@AutoLog(value = "电子证照源数据-分页列表查询")
    @ApiOperation(value = "电子证照源数据-分页列表查询", notes = "电子证照源数据-分页列表查询")
    @GetMapping(value = "/list")
    public Result<IPage<CertInfoIsType>> queryPageList(CertInfo certInfo, queryBean queryBean,
                                                       @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                       @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                       HttpServletRequest req) throws InvocationTargetException, IllegalAccessException {
        String cx = "";
        if ("cx".equals(certInfo.getZt()) && StringUtils.isNotBlank(certInfo.getZsdl())) {
            cx = certInfo.getZsdl();
            certInfo.setZt(null);
            certInfo.setZsdl(null);
        }
        QueryWrapper<CertInfo> queryWrapper = QueryGenerator.initQueryWrapper(certInfo, req.getParameterMap());

        /**
         * 如果证书类型为空，则判断证书大类是否为空，不为空则查询大类下的所有证书类型
         */
        LoginUser loginUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
        if (StringUtils.isBlank(certInfo.getCerttypeid())) {
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
        // 如果用户所属的部门ID列表不为空
        if (CollectionUtils.isNotEmpty(departIdsByUsername)) {
            // 默认机构标志，用于标识是否属于默认机构
            boolean isJgyh = false;
            // 将常量数组转换为List，用于后续比较
            List<String> jgyhList = Arrays.stream(YwConstant.FZJGID).collect(Collectors.toList());
            // 遍历用户所属的部门ID列表，检查是否包含默认机构的ID
            for (String departId : departIdsByUsername) {
                // 如果列表中包含当前部门ID，则标记为默认机构并终止循环
                if (jgyhList.contains(departId)) {
                    isJgyh = true;
                    break;
                }
            }
            // 如果用户不属于默认机构，则在查询条件中加入用户所属的部门ID列表
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
        if (StringUtils.isNotBlank(queryBean.getDlzslx())) {
            queryWrapper.eq("certtypeid", queryBean.getDlzslx());
        }
        if (StringUtils.isNotBlank(queryBean.getDlzszt())) {  //有效
            if ("0".equals(queryBean.getDlzszt())) {
                queryWrapper.eq("yxzt", "10");
            }
            if ("1".equals(queryBean.getDlzszt())) {// 过期
                // queryWrapper.lt("yxqz", DateUtils.formatDate(new Date(), "yyyy-MM-dd"));
                queryWrapper.eq("yxzt", "60");
            }
            if ("2".equals(queryBean.getDlzszt())) {// 注销
                queryWrapper.eq("yxzt", "50");
            }
        }
        if (StringUtils.isNotBlank(queryBean.getBeginDate())) {
            queryWrapper.ge("fzrq", queryBean.getBeginDate() + YwConstant.DATE_HMS_Q);
        }
        if (StringUtils.isNotBlank(queryBean.getEndDate())) {
            queryWrapper.le("fzrq", queryBean.getEndDate() + YwConstant.DATE_HMS_Z);
        }
        if (StringUtils.isBlank(cx)) {
            queryWrapper.eq("yxzt", "10");

        }
        String from = req.getParameter("_from");
        if ("ygz".equals(from)) queryWrapper.and(q -> q.isNotNull("GZTIME").or().isNull("isxt").or().ne("isxt", "1"));
        else if ("wgz".equals(from)) queryWrapper.and(q -> q.isNull("isxt").or().ne("isxt", "1"));
        Map<String, CertType> certTypeMap = new HashMap<>();
        if (StringUtils.isNotBlank(cx)) {
            queryWrapper.ne("yxzt", "99");

            QueryWrapper queryCertType = new QueryWrapper();
            queryCertType.eq("certtype_classification", cx);
            List<CertType> certtypes = iCertTypeService.list(queryCertType);

            if (CollectionUtils.isNotEmpty(certtypes)) {
                certTypeMap = certtypes.stream().collect(Collectors.toMap(CertType::getId, Function.identity()));
                List<String> certtypeIds = certtypes.stream().map(CertType::getId).collect(Collectors.toList());
                queryWrapper.in("CERTTYPEID", certtypeIds);
            }
			/*String sql= " SELECT ci.id FROM CERT_INFO ci ,cert_type ct " +
					" WHERE  ci.CERTTYPEID =ct.id AND  ct.certtype_classification = '"+cx+"'";
			queryWrapper.inSql("id",sql);*/
        }
        queryWrapper.orderByDesc("fzrq");
        Page<CertInfo> page = new Page<CertInfo>(pageNo, pageSize);

        IPage<CertInfo> pageList = certInfoService.page(page, queryWrapper);

        IPage<CertInfoIsType> resultList = new Page<>();
        // 使用自定义的 BeanUtilsBean 来忽略特定属性
        BeanUtilsBean notNull = new BeanUtilsBean() {
            @Override
            public void copyProperty(Object dest, String name, Object value) throws IllegalAccessException, InvocationTargetException, InvocationTargetException, InvocationTargetException {
                if (!"records".equals(name)) {
                    super.copyProperty(dest, name, value);
                }
            }
        };

        notNull.copyProperties(resultList, pageList);
        resultList.setCurrent(pageList.getCurrent());
        resultList.setSize(pageList.getSize());
        resultList.setTotal(pageList.getTotal());
        Map queryDropMap = new HashMap();
        //定义type和isall的关系

        //查询certmode

        resultList.setRecords(CertUtils.addAttachInfo(pageList.getRecords(), "YGZ", CertInfoIsType.class));
        return Result.OK(resultList);
    }

    @ApiOperation(value = "电子证照源数据-分页列表查询", notes = "电子证照源数据-分页列表查询")
    @GetMapping(value = "/alllist")
    public Result<IPage<CertInfoIsType>> queryALLPageList(CertInfo certInfo, queryBean queryBean,
                                                       @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                       @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                       HttpServletRequest req) throws InvocationTargetException, IllegalAccessException {
        // 是否显示职业药师（0：显示，1：不显示）
        String showZyys = req.getParameter("showZyys");
        QueryWrapper<CertInfo> query = QueryGenerator.initQueryWrapper(certInfo, req.getParameterMap(), "iswh", "whid", "certtypeid");
        Date date = DateUtils.parseDate(queryBean.getBeginDate());
        query.ge(null != date, "fzrq", date);
        query.le(null != (date = DateUtils.parseDate(queryBean.getEndDate())), "fzrq", date);
        if (StringUtils.isNotBlank(certInfo.getIswh())) query.isNotNull("whid");
        else query.eq("yxzt", "10");
        query.and(StringUtils.isNotBlank(certInfo.getWhid()), (q) -> q.isNull("iswh").or().eq("iswh", "0"));
        String str = req.getParameter("_from");
        //if ("blgz".equals(str)) query.isNull("GZTIME");
        LoginUser loginUser = WebUtils.getLoginUser();
        if (StringUtils.isNotBlank(certInfo.getCerttypeid())) {
            query.eq("certtypeid", certInfo.getCerttypeid());
        } else if (StringUtils.isNotBlank(queryBean.getZslb())) {
            List<String> roleIdsByUsername = sysBaseApi.getRolesByUsername(loginUser.getUsername());
            if (CollectionUtils.isEmpty(roleIdsByUsername)) {
                return Result.OK(new Page<>());
            }
            Map<String, Object> param = new HashMap<>();
            param.put("roleId", roleIdsByUsername.get(0));
            param.put("status", "2");
            param.put("classification", queryBean.getZslb());
            List<String> certTypeIds = iCertTypeService.getCerttypeIdByClassificationAndRole(param);
            // 不显示‘执业药师’类型证书
            if ("1".equals(showZyys)) {
                List<String> zyys = certTypeIds.stream().filter(YwConstant.CERTTYPEID_ZYYS::equals).collect(Collectors.toList());
                certTypeIds.remove(zyys.get(0));
            }
            if (CollectionUtils.isNotEmpty(certTypeIds)) {
                query.in("certtypeid", certTypeIds);
            } else {
                return Result.OK(new Page<>());
            }
        }
        List<String> departIdsByUsername = sysBaseApi.getDepartIdsByUsername(loginUser.getUsername());
        if (CollectionUtils.isNotEmpty(departIdsByUsername)) {
            List<String> jgyhList = Arrays.stream(YwConstant.FZJGID).collect(Collectors.toList());
            if (departIdsByUsername.stream().filter(jgyhList::contains).count() == 0)
                query.in("fzjgid", departIdsByUsername);
        }
        query.eq(StringUtils.isNotBlank(certInfo.getIsxt()), "isxt", certInfo.getIsxt());
        query.orderByDesc("fzrq");
        query.orderByDesc("gztime");
        //同步数据服务 单独的
        IPage<CertInfo> pageList = certHandleService.pageAll(new Page<>(pageNo, pageSize), query);
        IPage<CertInfoIsType> resultList = new Page<>();
        if (pageList.getTotal() == 0) {
            return Result.OK(resultList);
        }

        // 使用自定义的 BeanUtilsBean 来忽略特定属性
        BeanUtilsBean notNull = new BeanUtilsBean() {
            @Override
            public void copyProperty(Object dest, String name, Object value) throws IllegalAccessException, InvocationTargetException, InvocationTargetException, InvocationTargetException {
                if (!"records".equals(name)) {
                    super.copyProperty(dest, name, value);
                }
            }
        };

        notNull.copyProperties(resultList, pageList);
        resultList.setCurrent(pageList.getCurrent());
        resultList.setSize(pageList.getSize());
        resultList.setTotal(pageList.getTotal());
        resultList.setRecords(CertUtils.addAttachInfo(pageList.getRecords(), "YGZ", CertInfoIsType.class));
        return Result.OK(resultList);
    }

    /**
     * 批量盖章
     *
     * @param ids
     * @param signatureName
     * @param keySn
     * @param request
     * @return
     */
    @AutoLog(value = "批量生成证照")
    @ApiOperation(value = "批量生成证照", notes = "批量生成证照")
    @GetMapping("/batchGz")
    public Result<String> batchGz(String ids, String signatureName, String keySn, HttpServletRequest request) {
        Map resultMap = new HashMap();
        String[] ids1 = null;
        String[] sczz = null;//用来区分是否盖章
        String message = "";
        String[] keysn = null;
        try {
            Map<String, String[]> parameterMap = request.getParameterMap();
            if (parameterMap.get("ids[]") != null) {
                ids1 = parameterMap.get("ids[]");
                keysn = parameterMap.get("keysn");
            } else {
                ids1 = parameterMap.get("ids");
                sczz = parameterMap.get("type");
            }
            if (keysn != null && keysn.length >= 0) {
                keySn = keysn[0];
            }
            if (ids1 != null && ids1.length > 0) {
                for (String zsid : ids1) {
                    boolean check = cacheKey(zsid);
                    if (check) { //存在盖章中的数据直接返回前端
                        return Result.error("当前存在正在盖章中的数据，请稍后查询再试！");
                    }
                }
                for (String zsid : ids1) {
                    setCache(zsid); //给勾选的数据设置缓存锁
                }
//                message = certInfoService.batchGz(ids1, sczz, signatureName, keySn, request);
                String type = null != sczz && 0 < sczz.length ? sczz[0] : null;
                if ("4".equals(request.getParameter("zt")))
                    message = certHandleService.batchGzFromYgz(ids1, type, signatureName, keySn, request);
                else
                    message = certHandleService.batchGzFromWgz(ids1, type, signatureName, keySn, request);
            } else {
                return Result.OK();
            }
            resultMap.put("message", message);
            if (!message.contains("成功")) {
                delCacheList(ids1);
                Result.error(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("批量盖章异常:{},证书ID:{},详细信息:{}", e.getMessage(), e);
            return Result.error(e.getMessage());
        } finally {
            delCacheList(ids1); //不管失败与否 直接清掉缓存。
        }
        return Result.OK(message);
    }

    @AutoLog(value = "批量取消盖章")
    @ApiOperation(value = "批量取消盖章", notes = "批量取消盖章")
    @GetMapping("/cancleGz")
    public Result<String> cancleGz(@RequestParam(name = "ids", required = false) String ids, String signatureName, String keySn, HttpServletRequest request) {
        String[] ids1 = null;
        String message = "";
        try {
            Map<String, String[]> parameterMap = request.getParameterMap();
            if (parameterMap.get("ids[]") != null) {
                ids1 = parameterMap.get("ids[]");
            } else {
                ids1 = parameterMap.get("ids");
            }
            if (ArrayUtils.isEmpty(ids1)) return Result.OK(message);
            List<CertInfo> certInfoList = certInfoService.list(new LambdaQueryWrapper<CertInfo>().in(CertInfo::getId, Arrays.asList(ids1).toArray()));
            List<Object> zsbhList = certInfoList.stream().map(CertInfo::getZsbh).collect(Collectors.toList());
            List<ZsYwxxb> zsYwxxbList = iZsYwxxbService.list(new LambdaQueryWrapper<ZsYwxxb>().in(ZsYwxxb::getZsbh, zsbhList).eq(ZsYwxxb::getYxzt, "10"));
            if (CollectionUtils.isNotEmpty(zsYwxxbList)) {
                return Result.error("未盖章中存在相同证书编号待盖章数据，不能进行取消盖章");
            }
            for (CertInfo zsCert : certInfoList) {
                certHandleService.cancelGz(zsCert, request.getParameter("whyy"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("批量取消盖章异常:{},证书ID:{},详细信息:{}", e.getMessage(), ids1[0], e);
            return Result.error(e.getMessage());
        }
        return Result.OK(message);
    }


    @GetMapping("/getzminfodata")
    public Result<CertZminfo> getzminfodata(@RequestParam(name = "id", required = false) String id, HttpServletRequest request) {
        String[] ids1 = null;
        CertZminfo byId;

        try {


            byId = certInfoService.getzminfodata(id);
            //未盖章状态


        } catch (Exception e) {
            e.printStackTrace();
            logger.error("批量取消盖章异常:{},证书ID:{},详细信息:{}", e.getMessage(), ids1[0], e);
            return null;
        }
        return Result.OK(byId);
    }

    /**
     * 添加
     *
     * @param certInfoPage
     * @return
     */
    @AutoLog(value = "电子证照源数据-添加")
    @ApiOperation(value = "电子证照源数据-添加", notes = "电子证照源数据-添加")
//    @RequiresPermissions("dzzz.certinfo:cert_info:add")
    @PostMapping(value = "/add")
    public Result<String> add(@RequestBody CertInfoPage certInfoPage) throws InvocationTargetException, IllegalAccessException {
        // 对发证机构做校验
        try {
            certInfoPage.setFzjgid(YwUtil.fzjgValid(certInfoPage.getFzjg(), deptService));
        } catch (YwException e) {
            return Result.error(e.getMessage());
        }
        if (StringUtils.isNotBlank(certInfoPage.getWhr())) {
            CertInfoOperationRecord record = new CertInfoOperationRecord();
            record.setId(UUIDGenerator.generate());
            record.setZsid(certInfoPage.getId());
            record.setCzsj(new Date());
            record.setOperateNo("0");
            record.setYwlx("4");
            record.setCzrxm(certInfoPage.getWhr());
            record.setWhr(certInfoPage.getWhyy());
            record.setWhyy(certInfoPage.getWhyy());
            record.setFj(certInfoPage.getFj());
            record.setStutas("20");
            record.setBglx("4");
            iCertInfoOperationRecordService.save(record);
        }
        if (StringUtils.isNotBlank(certInfoPage.getQxgzr())) {
            CertInfoOperationRecord record = new CertInfoOperationRecord();
            record.setId(UUIDGenerator.generate());
            record.setZsid(certInfoPage.getId());
            record.setCzsj(new Date());
            record.setOperateNo("0");
            record.setYwlx("5");
            record.setCzrxm(certInfoPage.getQxgzr());
            record.setQxgzr(certInfoPage.getQxgzr());
            record.setQxgzyy(certInfoPage.getQxgzyy());
            record.setFj(certInfoPage.getFj());
            record.setStutas("20");
            record.setBglx("5");
            iCertInfoOperationRecordService.save(record);
        }
        CertInfo certInfo = new CertInfo();
        if ("bf".equals(certInfoPage.getZt())) {
            CertInfo byId = certInfoService.getById(certInfoPage.getId());
			/*byId.setBfyy(certInfoPage.getBfyy());
			byId.setBfzzwd(certInfoPage.getBfzzwd());*/
            byId.setZszt(YwlxEnum.BUFA.getCode());
            byId.setYwlb(YwlxEnum.BUFA.getCode());
            certInfoService.updateById(byId);
            return Result.OK("成功！");
        }
        if ("1".equals(certInfoPage.getIsxt())) {
            ZsYwxxb zsYwxxb = new ZsYwxxb();
            BeanUtils.copyProperties(certInfoPage, zsYwxxb);
            zsYwxxb.setId(UUIDGenerator.generate());
            zsYwxxb.setZsid(UUIDGenerator.generate());
            zsYwxxb.setZt("3");
            zsYwxxb.setYxzt("10");
            zsYwxxb.setZszt(YwlxEnum.HEFA.getCode());
            zsYwxxb.setYwlb(YwlxEnum.HEFA.getCode());

            LambdaQueryWrapper<ZsYwxxb> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(ZsYwxxb::getShxydm, zsYwxxb.getShxydm());
            queryWrapper.eq(ZsYwxxb::getZsbh, zsYwxxb.getZsbh());
            queryWrapper.eq(ZsYwxxb::getZt, "3");
            queryWrapper.eq(ZsYwxxb::getYxzt, "10");
            List<ZsYwxxb> list = iZsYwxxbService.list(queryWrapper);
            if (list != null && list.size() > 0) {
                return Result.error("存在相同企业相同编号数据，不能新增！");
            }
            //添加证书类型
            CertType byId = iCertTypeService.getById(zsYwxxb.getCerttypeid());
            zsYwxxb.setZslx(byId.getZslx());
            if ("95".equals(zsYwxxb.getZslx())) {
                // 执业范围
                zsYwxxb.setYlzd4(YwUtil.zyYsZyFwConvert(zsYwxxb.getYlzd4()));
                // 执业类别
                zsYwxxb.setYlzd13(YwUtil.zyYsZyLbConvert((zsYwxxb.getYlzd13())));
                CertArea area = iCertAreaService.selectAreaByAreaCode(zsYwxxb.getYlzd12());
                if (null == area) {
                    return Result.error("执业地区有误，请联系管理员！areaCode：【" + zsYwxxb.getYlzd12() + "】");
                }
                // 执业地区
                zsYwxxb.setYlzd12(area.getAreaname());
            }
            iZsYwxxbService.saveMain(zsYwxxb, certInfoPage.getCertchildYpscZcList(), certInfoPage.getCertchildYpscWtList(), certInfoPage.getCertchildYpscStList(),
                    certInfoPage.getCertchildCkomylyList(), certInfoPage.getCertchildMzyphjsypddscList(), certInfoPage.getCertchildYlqxcpckxsList(),
                    certInfoPage.getCertchildYlqxscbaZbList(), certInfoPage.getCertchildYlqxwtbaZbList(), certInfoPage.getCertchildYpckxkzList(),
                    certInfoPage.getCertchildYpckxszmList(), certInfoPage.getCertchildDylylqxscbapzList(), certInfoPage.getCertchildYlqxwlxsbaList()
                    , certInfoPage.getCertchirdYlqxlcsybaList()
            );
            //添加核發記錄
            CertInfoOperationRecord record = new CertInfoOperationRecord();
            record.setId(UUIDGenerator.generate());
            record.setZsid(zsYwxxb.getZsid());
            record.setCzsj(new Date());
            record.setOperateNo("0");
            record.setYwlx("1");
            record.setCzrxm("管理员");
            record.setBgyy(certInfoPage.getBgyy());
            record.setStutas("20");
            record.setBglx("1");
            certInfoOperationRecordService.save(record);
            return Result.OK("添加成功！");
        }
        BeanUtils.copyProperties(certInfoPage, certInfo);
        //取消盖章人 为什么要保存结果表数据
        if (!StringUtils.isNotBlank(certInfoPage.getQxgzr())) {
            certInfoService.saveMain(certInfo, certInfoPage.getCertchildYpscZcList(), certInfoPage.getCertchildYpscWtList(), certInfoPage.getCertchildYpscStList(),
                    certInfoPage.getCertchildCkomylyList(), certInfoPage.getCertchildMzyphjsypddscList(), certInfoPage.getCertchildYlqxcpckxsList(),
                    certInfoPage.getCertchildYlqxscbaZbList(), certInfoPage.getCertchildYlqxwtbaZbList(), certInfoPage.getCertchildYpckxkzList(),
                    certInfoPage.getCertchildYpckxszmList(), certInfoPage.getCertchildDylylqxscbapzList(), certInfoPage.getCertchildYlqxwlxsbaList()
                    , certInfoPage.getCertchirdYlqxlcsybaList()
            );
        }
        return Result.OK("添加成功！");
    }


    @AutoLog(value = "电子证照源数据-编辑")
    @ApiOperation(value = "电子证照源数据-编辑", notes = "电子证照源数据-编辑")
//    @RequiresPermissions("dzzz.certinfo:cert_info:edit")
    @RequestMapping(value = "/editdetial", method = {RequestMethod.PUT, RequestMethod.POST})
    public Result<String> editdetial(@RequestBody CertInfoPage certInfoPage) {
        ZsYwxxb certInfo = new ZsYwxxb();
        BeanUtils.copyProperties(certInfoPage, certInfo);
        ZsYwxxb byId = iZsYwxxbService.getById(certInfo.getId());
/*
		CertInfo certInfoEntity = certInfoService.getById(certInfo.getId());
*/
        if (byId == null) {
            return Result.error("未找到对应数据");
        }
        iZsYwxxbService.updateMain(certInfo, certInfoPage.getCertchildYpscZcList(), certInfoPage.getCertchildYpscWtList(), certInfoPage.getCertchildYpscStList(),
                certInfoPage.getCertchildCkomylyList(), certInfoPage.getCertchildMzyphjsypddscList(), certInfoPage.getCertchildYlqxcpckxsList(),
                certInfoPage.getCertchildYlqxscbaZbList(), certInfoPage.getCertchildYlqxwtbaZbList(), certInfoPage.getCertchildYpckxkzList(),
                certInfoPage.getCertchildYpckxszmList(), certInfoPage.getCertchildDylylqxscbapzList(), certInfoPage.getCertchildYlqxwlxsbaList()
                , certInfoPage.getCertchirdYlqxlcsybaList()
        );
        return Result.OK("保存成功!");
    }

    @AutoLog(value = "电子证照源数据-修改附件")
    @ApiOperation(value = "电子证照源数据-修改附件", notes = "电子证照源数据-修改附件")
    @RequestMapping(value = "/updateFj", method = {RequestMethod.PUT, RequestMethod.POST})
    public Result<String> updateFj(@RequestBody CertInfoPage certInfoPage) {
        LambdaUpdateWrapper<ZsYwxxb> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.set(ZsYwxxb::getFj, certInfoPage.getFj());
        updateWrapper.eq(ZsYwxxb::getId, certInfoPage.getId());
        boolean res = iZsYwxxbService.update(updateWrapper);
        return res ? Result.OK("保存成功!") : Result.error("未找到对应数据");
    }

    /**
     * 编辑
     *
     * @param certInfoPage
     * @return
     */
    @AutoLog(value = "电子证照源数据-编辑")
    @ApiOperation(value = "电子证照源数据-编辑", notes = "电子证照源数据-编辑")
//    @RequiresPermissions("dzzz.certinfo:cert_info:edit")
    @RequestMapping(value = "/edit", method = {RequestMethod.PUT, RequestMethod.POST})
    public Result<String> edit(@RequestBody CertInfoPage certInfoPage) {
	/*	String zsbh = certInfoPage.getZsbh();

		QueryWrapper queryWrapper=new QueryWrapper();
		queryWrapper.eq("id",certInfoPage.getId());
		queryWrapper.eq("zt","3");
		ZsYwxxb zsYwxxb=new ZsYwxxb();
		CertInfo certInfo=new CertInfo();
		List<ZsYwxxb> listzs = iZsYwxxbService.list(queryWrapper);
		if(listzs==null||listzs.size()==0)
		{
			QueryWrapper queryWrapper1=new QueryWrapper();
			queryWrapper1.eq("zsbh",certInfoPage.getId());
			queryWrapper1.eq("zt","4");
			List<CertInfo> listcert = certInfoService.list(queryWrapper);
			if(listcert==null||listcert.size()==0)
			{
				return Result.error("未找到对应数据");
			}
			else {
				listcert.get(0);
			}
		}
		else {

		}*/
        String weihu = certInfoService.weihu(certInfoPage);
        if ("维护申请成功！请等待审核结果".equals(weihu)) {
            return Result.OK(weihu);
        } else {
            return Result.error(weihu);
        }
    }

    @AutoLog(value = "电子证照源数据-维护申请")
    @ApiOperation(value = "电子证照源数据-维护申请", notes = "电子证照源数据-维护申请")
    @RequestMapping(value = "/maintainApply", method = {RequestMethod.PUT, RequestMethod.POST})
    public Result<String> maintainApply(@RequestBody CertInfoPage certInfoPage) {
        try {
            String error = certHandleService.maintainApply(certInfoPage);
            if (StringUtils.contains(error, "成功")) {
                return Result.OK(error);
            } else {
                return Result.error(error);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Result.error(StringUtils.defaultIfBlank(e.getMessage(), "操作失败"));
        }
    }

    @AutoLog(value = "维护审核通过")
    @ApiOperation(value = "维护审核通过", notes = "维护审核通过")
    @RequestMapping(value = "/shenhe", method = {RequestMethod.PUT, RequestMethod.POST})
    public Result<String> shenhe(@RequestBody CertInfoPage certInfoPage) {
        String weihu = certHandleService.maintainPass(certInfoPage); //certInfoService.shenhe(certInfoPage);
        return StringUtils.contains(weihu, "成功") ? Result.OK(weihu) : Result.error(weihu);
    }

    @AutoLog(value = "维护审核通退回")
    @ApiOperation(value = "维护审核通退回", notes = "维护审核通退回")
    @RequestMapping(value = "/back", method = {RequestMethod.PUT, RequestMethod.POST})
    public Result<String> back(@RequestBody CertInfoPage certInfoPage) {
        String weihu = certHandleService.maintainBack(certInfoPage); //certInfoService.Back(certInfoPage);
        return StringUtils.contains(weihu, "成功") ? Result.OK(weihu) : Result.error(weihu);
    }

    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    @AutoLog(value = "电子证照源数据-通过id删除")
    @ApiOperation(value = "电子证照源数据-通过id删除", notes = "电子证照源数据-通过id删除")
//    @RequiresPermissions("dzzz.certinfo:cert_info:delete")
    @DeleteMapping(value = "/delete")
    public Result<String> delete(@RequestParam(name = "id", required = true) String id) {
        certInfoService.delMain(id);
        return Result.OK("删除成功!");
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @AutoLog(value = "电子证照源数据-批量删除")
    @ApiOperation(value = "电子证照源数据-批量删除", notes = "电子证照源数据-批量删除")
//    @RequiresPermissions("dzzz.certinfo:cert_info:deleteBatch")
    @DeleteMapping(value = "/deleteBatch")
    public Result<String> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
        this.certInfoService.delBatchMain(Arrays.asList(ids.split(",")));
        return Result.OK("批量删除成功！");
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    //@AutoLog(value = "电子证照源数据-通过id查询")
    @ApiOperation(value = "电子证照源数据-通过id查询", notes = "电子证照源数据-通过id查询")
    @GetMapping(value = "/queryById")
    public Result<CertInfo> queryById(@RequestParam(name = "id", required = true) String id) {
        CertInfo certInfo = certInfoService.getById(id);
        if (certInfo == null) {
            return Result.error("未找到对应数据");
        }
        return Result.OK(certInfo);

    }

    /**
     * 通过zdid查询
     *
     * @param zsid
     * @return
     */
    @ApiOperation(value = "电子证照源数据-通过zsid查询", notes = "电子证照源数据-通过zsid查询")
    @GetMapping(value = "/queryByZsId")
    public Result<CertInfo> queryByZsId(@RequestParam(name = "zsid", required = true) String zsid) {
        LambdaQueryWrapper<CertInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CertInfo::getZsid, zsid);
        queryWrapper.ne(CertInfo::getYxzt, YwConstant.ZSZT_ZF);
        CertInfo certInfo = certInfoService.getOne(queryWrapper);
        if (certInfo == null) {
            return Result.error("未找到对应数据");
        }
        return Result.OK(certInfo);
    }

    /**
     * 通过id对应证照文件
     *
     * @param id
     * @return
     */
    //@AutoLog(value = "电子证照源数据-通过id查询")
    @ApiOperation(value = "电子证照源数据-通过id查询", notes = "电子证照源数据-通过id查询")
    @GetMapping(value = "/getAttachByCertid")
    public Result<Attachinfo> getAttachByCertid(@RequestParam(name = "id", required = true) String id, @RequestParam(name = "certmodetype", required = true) String certmodetype, @RequestParam(name = "isgz", required = true) String isgz) {

        Attachinfo attachinfo = certInfoService.getAttachByCertid(id, certmodetype, isgz);
        if (attachinfo == null) {
            return Result.error("未找到对应数据,请生成证照，再点击预览");
        }
        return Result.OK(attachinfo);

    }

    @ApiOperation(value = "证照配置元数据-通过id查询", notes = "电子证照源数据-通过id查询")
    @GetMapping(value = "/queryCertMetadateById")
    public Result<List<CertMetadata>> queryCertMetadateById(@RequestParam(name = "id", required = true) String id, @RequestParam(name = "status", required = false) String status) {
        List<CertMetadata> CertMetadatalist = certInfoService.queryCertMetadateById(id, status);
        if (CertMetadatalist == null) {
            return Result.error("未找到对应数据");
        }
        return Result.OK(CertMetadatalist);

    }

    @ApiOperation(value = "证照配置元数据-通过id查询", notes = "电子证照源数据-通过id查询")
    @GetMapping(value = "/queryCertMetadateByIdelse")
    public Result<List<CertMetadata>> queryCertMetadateByIdelse(@RequestParam(name = "id", required = true) String id, @RequestParam(name = "status", required = false) String status) {
        List<CertMetadata> CertMetadatalist = certInfoService.queryCertMetadateByIdelse(id, status);
        if (CertMetadatalist == null) {
            return Result.error("未找到对应数据");
        }
        return Result.OK(CertMetadatalist);

    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    //@AutoLog(value = "药品生产子表自产通过主表ID查询")
    @ApiOperation(value = "药品生产子表自产主表ID查询", notes = "药品生产子表自产-通主表ID查询")
    @GetMapping(value = "/queryCertchildYpscZcByMainId")
    public Result<List<CertchildYpscZc>> queryCertchildYpscZcListByMainId(@RequestParam(name = "id", required = true) String id, String zt) {
	/*	CertInfo byZsid = certInfoService.getByZsid(id);
		QueryWrapper queryWrapper =new QueryWrapper();
		queryWrapper.eq("zsid",byZsid.getZsid());
		List<CertInfoOperationRecord> list = certInfoOperationRecordService.list(queryWrapper);
		if(list!=null&&list.size()>0)
		{
			String xzspslh = list.get(0).getXzspslh();
			if(StringUtils.isNotBlank(xzspslh))
			{

			}
		}*/
        String glid = "";

        if ("3".equals(zt)) {
            ZsYwxxb byZsid = iZsYwxxbService.getByZsid(id);
            glid = byZsid.getId();

        } else if ("4".equals(zt)) {
            CertInfo byZsid = certInfoService.getByZsid(id);
            glid = byZsid.getId();
        } else {
            return Result.error("状态值为空 无法确定查询类型");

        }
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("zsid", id);
        queryWrapper.eq("xzspid", glid);
        queryWrapper.eq("zt", zt);
        List<CertchildYpscZc> certchildYpscZcList = certchildYpscZcService.list(queryWrapper);
        return Result.OK(certchildYpscZcList);
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    //@AutoLog(value = "药品生产子表委托通过主表ID查询")
    @ApiOperation(value = "药品生产子表委托主表ID查询", notes = "药品生产子表委托-通主表ID查询")
    @GetMapping(value = "/queryCertchildYpscWtByMainId")
    public Result<List<CertchildYpscWt>> queryCertchildYpscWtListByMainId(@RequestParam(name = "id", required = true) String id, String zt) {
        String glid = "";

        if ("3".equals(zt)) {
            ZsYwxxb byZsid = iZsYwxxbService.getByZsid(id);
            glid = byZsid.getId();

        } else if ("4".equals(zt)) {
            CertInfo byZsid = certInfoService.getByZsid(id);
            glid = byZsid.getId();
        } else {
            return Result.error("状态值为空 无法确定查询类型");

        }
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("zsid", id);
        queryWrapper.eq("xzspid", glid);
        queryWrapper.eq("zt", zt);
        List<CertchildYpscWt> certchildYpscWtList = certchildYpscWtService.list(queryWrapper);
        return Result.OK(certchildYpscWtList);
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    //@AutoLog(value = "药品生产子表受托通过主表ID查询")
    @ApiOperation(value = "药品生产子表受托主表ID查询", notes = "药品生产子表受托-通主表ID查询")
    @GetMapping(value = "/queryCertchildYpscStByMainId")
    public Result<List<CertchildYpscSt>> queryCertchildYpscStListByMainId(@RequestParam(name = "id", required = true) String id, String zt) {
        String glid = "";

        if ("3".equals(zt)) {
            ZsYwxxb byZsid = iZsYwxxbService.getByZsid(id);
            glid = byZsid.getId();

        } else if ("4".equals(zt)) {
            CertInfo byZsid = certInfoService.getByZsid(id);
            glid = byZsid.getId();
        } else {
            return Result.error("状态值为空 无法确定查询类型");

        }
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("zsid", id);
        queryWrapper.eq("xzspid", glid);
        queryWrapper.eq("zt", zt);
        List<CertchildYpscSt> certchildYpscStList = certchildYpscStService.list(queryWrapper);
        return Result.OK(certchildYpscStList);
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    //@AutoLog(value = "第二三类医疗器械委托备案子表通过主表ID查询")
    @ApiOperation(value = "第二三类医疗器械委托备案子表主表ID查询", notes = "第二三类医疗器械委托备案子表-通主表ID查询")
    @GetMapping(value = "/queryCertchildYlqxwtbaZbByMainId")
    public Result<List<CertchildYlqxwtbaZb>> queryCertchildYlqxwtbaZbListByMainId(@RequestParam(name = "id", required = true) String id, String zt) {
        String glid = "";

        if ("3".equals(zt)) {
            ZsYwxxb byZsid = iZsYwxxbService.getByZsid(id);
            glid = byZsid.getId();

        } else if ("4".equals(zt)) {
            CertInfo byZsid = certInfoService.getByZsid(id);
            glid = byZsid.getId();
        } else {
            return Result.error("状态值为空 无法确定查询类型");

        }
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("zsid", id);
        queryWrapper.eq("xzspid", glid);
        queryWrapper.eq("zt", zt);
        List<CertchildYlqxwtbaZb> certchildYlqxwtbaZbList = certchildYlqxwtbaZbService.list(queryWrapper);
        return Result.OK(certchildYlqxwtbaZbList);
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    //@AutoLog(value = "二三类医疗机械生产子表通过主表ID查询")
    @ApiOperation(value = "二三类医疗机械生产子表主表ID查询", notes = "二三类医疗机械生产子表-通主表ID查询")
    @GetMapping(value = "/queryCertchildYlqxscbaZbByMainId")
    public Result<List<CertchildYlqxscbaZb>> queryCertchildYlqxscbaZbListByMainId(@RequestParam(name = "id", required = true) String id, String zt) {
        String glid = "";

        if ("3".equals(zt)) {
            ZsYwxxb byZsid = iZsYwxxbService.getByZsid(id);
            glid = byZsid.getId();

        } else if ("4".equals(zt)) {
            CertInfo byZsid = certInfoService.getByZsid(id);
            glid = byZsid.getId();
        } else {
            return Result.error("状态值为空 无法确定查询类型");

        }
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("zsid", id);
        queryWrapper.eq("xzspid", glid);
        queryWrapper.eq("zt", zt);
        List<CertchildYlqxscbaZb> certchildYlqxscbaZbList = certchildYlqxscbaZbService.list(queryWrapper);
        return Result.OK(certchildYlqxscbaZbList);
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    //@AutoLog(value = "药品出口准许证通过主表ID查询")
    @ApiOperation(value = "药品出口准许证主表ID查询", notes = "药品出口准许证-通主表ID查询")
    @GetMapping(value = "/queryCertchildYpckxkzByMainId")
    public Result<List<CertchildYpckxkz>> queryCertchildYpckxkzListByMainId(@RequestParam(name = "id", required = true) String id, String zt) {
        String glid = "";

        if ("3".equals(zt)) {
            ZsYwxxb byZsid = iZsYwxxbService.getByZsid(id);
            glid = byZsid.getId();

        } else if ("4".equals(zt)) {
            CertInfo byZsid = certInfoService.getByZsid(id);
            glid = byZsid.getId();
        } else {
            return Result.error("状态值为空 无法确定查询类型");

        }
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("zsid", id);
        queryWrapper.eq("xzspid", glid);
        queryWrapper.eq("zt", zt);
        List<CertchildYpckxkz> certchildYpckxkzList = certchildYpckxkzService.list(queryWrapper);
        return Result.OK(certchildYpckxkzList);
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    //@AutoLog(value = "医疗器械临床试验备案通过主表ID查询")
    @ApiOperation(value = "医疗器械临床试验备案主表ID查询", notes = "医疗器械临床试验备案-通主表ID查询")
    @GetMapping(value = "/queryCertchirdYlqxlcsybaByMainId")
    public Result<List<CertchirdYlqxlcsyba>> queryCertchirdYlqxlcsybaListByMainId(@RequestParam(name = "id", required = true) String id, String zt) {
        String glid = "";

        if ("3".equals(zt)) {
            ZsYwxxb byZsid = iZsYwxxbService.getByZsid(id);
            glid = byZsid.getId();

        } else if ("4".equals(zt)) {
            CertInfo byZsid = certInfoService.getByZsid(id);
            glid = byZsid.getId();
        } else {
            return Result.error("状态值为空 无法确定查询类型");

        }
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("zsid", id);
        queryWrapper.eq("xzspid", glid);
        queryWrapper.eq("zt", zt);
        List<CertchirdYlqxlcsyba> certchirdYlqxlcsybaList = certchirdYlqxlcsybaService.list(queryWrapper);
        return Result.OK(certchirdYlqxlcsybaList);
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    //@AutoLog(value = "医疗器械产品出口销售证明通过主表ID查询")
    @ApiOperation(value = "医疗器械产品出口销售证明主表ID查询", notes = "医疗器械产品出口销售证明-通主表ID查询")
    @GetMapping(value = "/queryCertchildYlqxcpckxsByMainId")
    public Result<List<CertchildYlqxcpckxs>> queryCertchildYlqxcpckxsListByMainId(@RequestParam(name = "id", required = true) String id, String zt) {
        String glid = "";

        if ("3".equals(zt)) {
            ZsYwxxb byZsid = iZsYwxxbService.getByZsid(id);
            glid = byZsid.getId();

        } else if ("4".equals(zt)) {
            CertInfo byZsid = certInfoService.getByZsid(id);
            glid = byZsid.getId();
        } else {
            return Result.error("状态值为空 无法确定查询类型");

        }
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("zsid", id);
        queryWrapper.eq("xzspid", glid);
        queryWrapper.eq("zt", zt);
        List<CertchildYlqxcpckxs> certchildYlqxcpckxsList = certchildYlqxcpckxsService.list(queryWrapper);
        return Result.OK(certchildYlqxcpckxsList);
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    //@AutoLog(value = "麻醉药品和精神药品定点生产批件通过主表ID查询")
    @ApiOperation(value = "麻醉药品和精神药品定点生产批件主表ID查询", notes = "麻醉药品和精神药品定点生产批件-通主表ID查询")
    @GetMapping(value = "/queryCertchildMzyphjsypddscByMainId")
    public Result<List<CertchildMzyphjsypddsc>> queryCertchildMzyphjsypddscListByMainId(@RequestParam(name = "id", required = true) String id, String zt) {
        String glid = "";

        if ("3".equals(zt)) {
            ZsYwxxb byZsid = iZsYwxxbService.getByZsid(id);
            glid = byZsid.getId();

        } else if ("4".equals(zt)) {
            CertInfo byZsid = certInfoService.getByZsid(id);
            glid = byZsid.getId();
        } else {
            return Result.error("状态值为空 无法确定查询类型");

        }
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("zsid", id);
        queryWrapper.eq("xzspid", glid);
        queryWrapper.eq("zt", zt);
        List<CertchildMzyphjsypddsc> certchildMzyphjsypddscList = certchildMzyphjsypddscService.list(queryWrapper);
        return Result.OK(certchildMzyphjsypddscList);
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    //@AutoLog(value = "药品出口销售证明通过主表ID查询")
    @ApiOperation(value = "药品出口销售证明主表ID查询", notes = "药品出口销售证明-通主表ID查询")
    @GetMapping(value = "/queryCertchildYpckxszmByMainId")
    public Result<List<CertchildYpckxszm>> queryCertchildYpckxszmListByMainId(@RequestParam(name = "id", required = true) String id, String zt) {
        String glid = "";

        if ("3".equals(zt)) {
            ZsYwxxb byZsid = iZsYwxxbService.getByZsid(id);
            glid = byZsid.getId();

        } else if ("4".equals(zt)) {
            CertInfo byZsid = certInfoService.getByZsid(id);
            glid = byZsid.getId();
        } else {
            return Result.error("状态值为空 无法确定查询类型");

        }
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("zsid", id);
        queryWrapper.eq("xzspid", glid);
        queryWrapper.eq("zt", zt);
        List<CertchildYpckxszm> certchildYpckxszmList = certchildYpckxszmService.list(queryWrapper);
        return Result.OK(certchildYpckxszmList);
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    //@AutoLog(value = "药瓶生产子表gmp通过主表ID查询")
    @ApiOperation(value = "药瓶生产子表gmp主表ID查询", notes = "药瓶生产子表gmp-通主表ID查询")
    @GetMapping(value = "/queryCertchildYpscGmpByMainId")
    public Result<List<CertchildYpscGmp>> queryCertchildYpscGmpListByMainId(@RequestParam(name = "id", required = true) String id, String zt) {
        String glid = "";

        if ("3".equals(zt)) {
            ZsYwxxb byZsid = iZsYwxxbService.getByZsid(id);
            glid = byZsid.getId();

        } else if ("4".equals(zt)) {
            CertInfo byZsid = certInfoService.getByZsid(id);
            glid = byZsid.getId();
        } else {
            return Result.error("状态值为空 无法确定查询类型");

        }
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("zsid", id);
        //queryWrapper.eq("xzspid", glid);
        queryWrapper.eq("zt", zt);
        List<CertchildYpscGmp> certchildYpscGmpList = certchildYpscGmpService.list(queryWrapper);
        return Result.OK(certchildYpscGmpList);
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    //@AutoLog(value = "出口欧盟原料通过主表ID查询")
    @ApiOperation(value = "出口欧盟原料主表ID查询", notes = "出口欧盟原料-通主表ID查询")
    @GetMapping(value = "/queryCertchildCkomylyByMainId")
    public Result<List<CertchildCkomyly>> queryCertchildCkomylyListByMainId(@RequestParam(name = "id", required = true) String id, String zt) {
        String glid = "";

        if ("3".equals(zt)) {
            ZsYwxxb byZsid = iZsYwxxbService.getByZsid(id);
            glid = byZsid.getId();

        } else if ("4".equals(zt)) {
            CertInfo byZsid = certInfoService.getByZsid(id);
            glid = byZsid.getId();
        } else {
            return Result.error("状态值为空 无法确定查询类型");

        }
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("zsid", id);
        queryWrapper.eq("xzspid", glid);
        queryWrapper.eq("zt", zt);
        List<CertchildCkomyly> certchildCkomylyList = certchildCkomylyService.list(queryWrapper);
        return Result.OK(certchildCkomylyList);
    }

    //@AutoLog(value = "certchild_ylqxwlxsba通过主表ID查询")
    @ApiOperation(value = "certchild_ylqxwlxsba主表ID查询", notes = "certchild_ylqxwlxsba-通主表ID查询")
    @GetMapping(value = "/queryCertchildYlqxwlxsbaByMainId")
    public Result<List<CertchildYlqxwlxsba>> queryCertchildYlqxwlxsbaListByMainId(@RequestParam(name = "id", required = true) String id, String zt) {
        String glid = "";

        if ("3".equals(zt)) {
            ZsYwxxb byZsid = iZsYwxxbService.getByZsid(id);
            glid = byZsid.getId();

        } else if ("4".equals(zt)) {
            CertInfo byZsid = certInfoService.getByZsid(id);
            glid = byZsid.getId();
        } else {
            return Result.error("状态值为空 无法确定查询类型");

        }
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("zsid", id);
        queryWrapper.eq("xzspid", glid);
        queryWrapper.eq("zt", zt);
        List<CertchildYlqxwlxsba> certchildYlqxwlxsbaList = certchildYlqxwlxsbaService.list(queryWrapper);
        return Result.OK(certchildYlqxwlxsbaList);
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    //@AutoLog(value = "certchild_dylylqxscbapz通过主表ID查询")
    @ApiOperation(value = "certchild_dylylqxscbapz主表ID查询", notes = "certchild_dylylqxscbapz-通主表ID查询")
    @GetMapping(value = "/queryCertchildDylylqxscbapzByMainId")
    public Result<List<CertchildDylylqxscbapz>> queryCertchildDylylqxscbapzListByMainId(@RequestParam(name = "id", required = true) String id, String zt) {
        String glid = "";

        if ("3".equals(zt)) {
            ZsYwxxb byZsid = iZsYwxxbService.getByZsid(id);
            glid = byZsid.getId();

        } else if ("4".equals(zt)) {
            CertInfo byZsid = certInfoService.getByZsid(id);
            glid = byZsid.getId();
        } else {
            return Result.error("状态值为空 无法确定查询类型");

        }
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("zsid", id);
        queryWrapper.eq("xzspid", glid);
        queryWrapper.eq("zt", zt);
        List<CertchildDylylqxscbapz> certchildDylylqxscbapzList = certchildDylylqxscbapzService.list(queryWrapper);
        return Result.OK(certchildDylylqxscbapzList);
    }

    /**
     * 导出excel
     *
     * @param request
     * @param certInfo
     */
//    @RequiresPermissions("dzzz.certinfo:cert_info:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, CertInfo certInfo) {
        // Step.1 组装查询条件查询数据
        QueryWrapper<CertInfo> queryWrapper = QueryGenerator.initQueryWrapper(certInfo, request.getParameterMap());
        LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();

        //配置选中数据查询条件
        String selections = request.getParameter("selections");
        if (oConvertUtils.isNotEmpty(selections)) {
            List<String> selectionList = Arrays.asList(selections.split(","));
            queryWrapper.in("id", selectionList);
        }
        //Step.2 获取导出数据
        List<CertInfo> certInfoList = certInfoService.list(queryWrapper);

        // Step.3 组装pageList
        List<CertInfoPage> pageList = new ArrayList<CertInfoPage>();
        for (CertInfo main : certInfoList) {
            CertInfoPage vo = new CertInfoPage();
            BeanUtils.copyProperties(main, vo);

            List<CertchildYpscZc> certchildYpscZcList = certchildYpscZcService.selectByMainId(main.getId(), main.getZsid());
            vo.setCertchildYpscZcList(certchildYpscZcList);
            List<CertchildYpscWt> certchildYpscWtList = certchildYpscWtService.selectByMainId(main.getId(), main.getZsid());
            vo.setCertchildYpscWtList(certchildYpscWtList);
            List<CertchildYpscSt> certchildYpscStList = certchildYpscStService.selectByMainId(main.getId(), main.getZsid());
            vo.setCertchildYpscStList(certchildYpscStList);
            List<CertchildYlqxwtbaZb> certchildYlqxwtbaZbList = certchildYlqxwtbaZbService.selectByMainId(main.getId(), main.getZsid());
            vo.setCertchildYlqxwtbaZbList(certchildYlqxwtbaZbList);
            List<CertchildYlqxscbaZb> certchildYlqxscbaZbList = certchildYlqxscbaZbService.selectByMainId(main.getId(), main.getZsid());
            vo.setCertchildYlqxscbaZbList(certchildYlqxscbaZbList);
            List<CertchildYpckxkz> certchildYpckxkzList = certchildYpckxkzService.selectByMainId(main.getId(), main.getZsid());
            vo.setCertchildYpckxkzList(certchildYpckxkzList);
            List<CertchirdYlqxlcsyba> certchirdYlqxlcsybaList = certchirdYlqxlcsybaService.selectByMainId(main.getId(), main.getZsid());
            vo.setCertchirdYlqxlcsybaList(certchirdYlqxlcsybaList);
            List<CertchildYlqxcpckxs> certchildYlqxcpckxsList = certchildYlqxcpckxsService.selectByMainId(main.getId(), main.getZsid());
            vo.setCertchildYlqxcpckxsList(certchildYlqxcpckxsList);
            List<CertchildMzyphjsypddsc> certchildMzyphjsypddscList = certchildMzyphjsypddscService.selectByMainId(main.getId(), main.getZsid());
            vo.setCertchildMzyphjsypddscList(certchildMzyphjsypddscList);
            List<CertchildYpckxszm> certchildYpckxszmList = certchildYpckxszmService.selectByMainId(main.getId(), main.getZsid());
            vo.setCertchildYpckxszmList(certchildYpckxszmList);
            List<CertchildYpscGmp> certchildYpscGmpList = certchildYpscGmpService.selectByMainId(main.getId(), main.getZsid());
            vo.setCertchildYpscGmpList(certchildYpscGmpList);
            List<CertchildCkomyly> certchildCkomylyList = certchildCkomylyService.selectByMainId(main.getId(), main.getZsid());
            vo.setCertchildCkomylyList(certchildCkomylyList);
            pageList.add(vo);
        }

        // Step.4 AutoPoi 导出Excel
        ModelAndView mv = new ModelAndView(new JeecgEntityExcelView());
        mv.addObject(NormalExcelConstants.FILE_NAME, "电子证照源数据列表");
        mv.addObject(NormalExcelConstants.CLASS, CertInfoPage.class);
        mv.addObject(NormalExcelConstants.PARAMS, new ExportParams("电子证照源数据数据", "导出人:" + sysUser.getRealname(), "电子证照源数据"));
        mv.addObject(NormalExcelConstants.DATA_LIST, pageList);
        return mv;
    }

    /**
     * 已盖章 导出excel
     *
     * @param req
     * @param queryBean
     * @param certInfo
     */
    @RequestMapping(value = "/exportYgzXls")
    public ResponseEntity exportYgzXls(HttpServletRequest req, queryBean queryBean, CertInfo certInfo) throws IOException, IllegalAccessException {
        if (certInfo.getCerttypeid() == null) {
            return ResponseEntity.ok().build();
        }
        String cx = "";
        if ("cx".equals(certInfo.getZt()) && StringUtils.isNotBlank(certInfo.getZsdl())) {
            cx = certInfo.getZsdl();
            certInfo.setZt(null);
            certInfo.setZsdl(null);
        }
        // Step.1 组装查询条件查询数据
        QueryWrapper<CertInfo> queryWrapper = QueryGenerator.initQueryWrapper(certInfo, req.getParameterMap());

        LoginUser loginUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
        //根据登陆用户查询用户部门
        List<String> departIdsByUsername = sysBaseApi.getDepartIdsByUsername(loginUser.getUsername());
        // 如果用户所属的部门ID列表不为空
        if (CollectionUtils.isNotEmpty(departIdsByUsername)) {
            // 默认机构标志，用于标识是否属于默认机构
            boolean isJgyh = false;
            // 将常量数组转换为List，用于后续比较
            List<String> jgyhList = Arrays.stream(YwConstant.FZJGID).collect(Collectors.toList());
            // 遍历用户所属的部门ID列表，检查是否包含默认机构的ID
            for (String departId : departIdsByUsername) {
                // 如果列表中包含当前部门ID，则标记为默认机构并终止循环
                if (jgyhList.contains(departId)) {
                    isJgyh = true;
                    break;
                }
            }
            // 如果用户不属于默认机构，则在查询条件中加入用户所属的部门ID列表
            if (!isJgyh){
                queryWrapper.in("FZJGID", departIdsByUsername);
            }
        }

        if (StringUtils.isNotBlank(queryBean.getDlzslx())) {
            queryWrapper.eq("certtypeid", queryBean.getDlzslx());
        }
        if (StringUtils.isNotBlank(queryBean.getDlzszt())) {  //有效
            if ("0".equals(queryBean.getDlzszt())) {
                queryWrapper.eq("yxzt", "10");
            }
            if ("1".equals(queryBean.getDlzszt())) {// 过期
                queryWrapper.eq("yxzt", "60");
            }
            if ("2".equals(queryBean.getDlzszt())) {// 注销
                queryWrapper.eq("yxzt", "50");
            }
        }
        if (StringUtils.isNotBlank(queryBean.getBeginDate())) {
            queryWrapper.ge("fzrq", queryBean.getBeginDate() + YwConstant.DATE_HMS_Q);
        }
        if (StringUtils.isNotBlank(queryBean.getEndDate())) {
            queryWrapper.le("fzrq", queryBean.getEndDate() + YwConstant.DATE_HMS_Z);
        }
        if (StringUtils.isBlank(cx)) {
            queryWrapper.eq("yxzt", "10");
        }

        if (StringUtils.isNotBlank(cx)) {
            queryWrapper.ne("yxzt", "99");
            QueryWrapper queryCertType = new QueryWrapper();
            queryCertType.eq("certtype_classification", cx);
            List<CertType> certtypes = iCertTypeService.list(queryCertType);

            if (CollectionUtils.isNotEmpty(certtypes)) {
                List<String> certtypeIds = certtypes.stream().map(CertType::getId).collect(Collectors.toList());
                queryWrapper.in("CERTTYPEID", certtypeIds);
            }
        }
        queryWrapper.orderByDesc("fzrq");

        //Step.2 获取导出数据
        List<CertInfo> certInfoList = certInfoService.list(queryWrapper);

        List<String> excelHeaders = new ArrayList<>();
        List<String> excelFields = new ArrayList<>();
        List<CertMetadata> certMetadataList = iCertMetadataService.selectZsyByCertTypeId(certInfo.getCerttypeid());
        certMetadataList.stream().forEach(v -> {
            if ("0".equals(v.getSfsc())) {
                excelHeaders.add(v.getLm());
                String yssx = v.getYssx().toLowerCase();//将属性字段转成小写
                //证照元数据映射属性转换 cp -> chanping, gg->guige, cs -> chaosong
                if ("cp".equals(yssx)) {
                    yssx = "chanping";
                }
                if ("gg".equals(yssx)) {
                    yssx = "guige";
                }
                if ("cs".equals(yssx)) {
                    yssx = "chaosong";
                }
                excelFields.add(yssx);
            }
        });
        String sheetName = "已盖章数据";
        Workbook workbook = ExcelExportUtils.exportToExcel(null, sheetName, excelHeaders, excelFields, certInfoList);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=" + URLEncoder.encode("证书管理-已盖章数据列表.xlsx","UTF-8"));
        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(outputStream.toByteArray());
    }


    /**
     * 通过excel导入数据
     *
     * @param request
     * @param response
     * @return
     */
//    @RequiresPermissions("dzzz.certinfo:cert_info:importExcel")
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
                List<CertInfoPage> list = ExcelImportUtil.importExcel(file.getInputStream(), CertInfoPage.class, params);
                for (CertInfoPage page : list) {
                    CertInfo po = new CertInfo();
                    BeanUtils.copyProperties(page, po);
                    certInfoService.saveMain(po, page.getCertchildYpscZcList(), page.getCertchildYpscWtList(), page.getCertchildYpscStList(),
                            page.getCertchildCkomylyList(), page.getCertchildMzyphjsypddscList(), page.getCertchildYlqxcpckxsList(),
                            page.getCertchildYlqxscbaZbList(), page.getCertchildYlqxwtbaZbList(), page.getCertchildYpckxkzList(),
                            page.getCertchildYpckxszmList(), page.getCertchildDylylqxscbapzList(), page.getCertchildYlqxwlxsbaList()
                            , page.getCertchirdYlqxlcsybaList()
                    );
                }
                return Result.OK("文件导入成功！数据行数:" + list.size());
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                return Result.error("文件导入失败:" + e.getMessage());
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

    @RequestMapping(value = "/bianGeng", method = {RequestMethod.PUT, RequestMethod.POST})
    public Result<String> bianGeng(@RequestBody CertInfoPage certInfoPage) {
        CertInfo certInfo = new CertInfo();
        BeanUtils.copyProperties(certInfoPage, certInfo);
        String s = certInfoService.bianGeng(certInfo, certInfoPage);
        return null == s ? Result.OK("变更成功!") : Result.error(s);
    }

    @RequestMapping(value = "/huanZheng", method = {RequestMethod.PUT, RequestMethod.POST})
    public Result<String> huanZheng(@RequestBody CertInfoPage certInfoPage) {
        CertInfo certInfo = new CertInfo();
        BeanUtils.copyProperties(certInfoPage, certInfo);
        String s = certInfoService.huanzheng(certInfo, certInfoPage);
        if ("error".equals(s)) {
            return Result.error("换证失败！存在未盖章");
        }
        return null == s ? Result.OK("换证成功!") : Result.error(s);
    }

    @RequestMapping(value = "/zhuXiao", method = {RequestMethod.PUT, RequestMethod.POST})
    public Result<String> zhuXiao(@RequestBody CertInfoPage certInfoPage) {
        CertInfo certInfo = new CertInfo();
        BeanUtils.copyProperties(certInfoPage, certInfo);
        String msg = certHandleService.zhuXiao(certInfoPage);
        if (!StringUtils.contains(msg, "成功")) return Result.error(msg);
        TYwZsN tYwZsLsN = new TYwZsN();
        org.jeecg.modules.demo.dzzz.util.BeanUtils.copyProperties(certInfo, tYwZsLsN);
        tYwZsLsN.setJsly("99");
        tYwZsLsN.setZt("1");
        tYwZsLsN.setId(certInfo.getZsid());
        tYwZsLsN.setCp(certInfo.getChanping());
        tYwZsLsN.setGg(certInfo.getGuige());
        tYwZsLsN.setCs(certInfo.getChaosong());
        if (CollectionUtils.isEmpty(itYwZsNService.list(new LambdaQueryWrapper<TYwZsN>().eq(TYwZsN::getId, certInfo.getZsid())))) {
            itYwZsNService.save(tYwZsLsN);
        } else {
            itYwZsNService.updateById(tYwZsLsN);
        }
        return Result.OK("注销成功!");
    }


    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    private boolean cacheKey(String key) {
        boolean flag = false;
        Object obj = null;
        try {
            obj = redisUtil.get(CommonConstant.BATCH_GZ_CACHE_KEY + key);
            if (obj != null) {
                int gzsl = (int) obj;
                if (gzsl > 0) { //判断是否存在盖章中的数据
                    return true;
                }
            }
        } catch (Exception e) {
            logger.error("批量盖章获取redis异常", e.getMessage(), e);
        }
        return flag;
    }

    /**
     * 设置缓存 默认5分钟
     *
     * @param key
     */
    private void setCache(String key) {
        try {
            redisUtil.set(CommonConstant.BATCH_GZ_CACHE_KEY + key, 1, 5 * 60); //设置缓存并5分钟失效
        } catch (Exception e) {
            logger.error("批量盖章设置redis异常", e.getMessage(), e);
        }
    }

    /**
     * 批量清除缓存
     *
     * @param keys
     */
    private void delCacheList(String[] keys) {
        if (keys != null && keys.length > 0) {
            for (String key : keys) {
                delCache(key);
            }
        }
    }

    private void delCache(String key) {
        try {
            redisUtil.del(CommonConstant.BATCH_GZ_CACHE_KEY + key); //删除缓存
        } catch (Exception e) {
            logger.error("批量盖章设置redis异常", e.getMessage(), e);
        }
    }

    @AutoLog(value = "电子证照数据-补录")
    @ApiOperation(value = "电子证照数据-补录", notes = "电子证照数据-补录")
    @PostMapping(value = "/saveBl")
    public Result<String> saveBl(@RequestBody CertInfoPage certInfoPage) {
        String msg = certHandleService.saveOrUpdateBl(certInfoPage);
        return StringUtils.contains(msg, "成功") ? Result.OK(msg) : Result.error(msg);
    }

}
