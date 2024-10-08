package org.jeecg.modules.demo.dzzz.homepage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.DateUtils;
import org.jeecg.modules.demo.dzzz.attachinfo.entity.Attachinfo;
import org.jeecg.modules.demo.dzzz.certStatistics.entity.Zslxtj;
import org.jeecg.modules.demo.dzzz.certStatistics.mapper.ZslxtjMapper;
import org.jeecg.modules.demo.dzzz.certStatistics.service.IQylxtjService;
import org.jeecg.modules.demo.dzzz.certStatistics.util.zzUtil.ValidateUtil;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertInfo;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertInfoIsType;
import org.jeecg.modules.demo.dzzz.certinfo.entity.queryBean;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertInfoService;
import org.jeecg.modules.demo.dzzz.certmode.service.ICertModeService;
import org.jeecg.modules.demo.dzzz.certmulu.entity.ZsmlVo;
import org.jeecg.modules.demo.dzzz.certtype.entity.CertType;
import org.jeecg.modules.demo.dzzz.certtype.service.ICertTypeService;
import org.jeecg.modules.demo.dzzz.constant.YwConstant;
import org.jeecg.modules.demo.dzzz.enums.YwlxEnum;
import org.jeecg.modules.demo.dzzz.homepage.entity.ZsQydDto;
import org.jeecg.modules.demo.dzzz.homepage.mapper.OtherPageMapper;
import org.jeecg.modules.demo.dzzz.homepage.service.IOtherPageService;
import org.jeecg.modules.demo.dzzz.util.CertUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class OtherPageServiceImpl extends ServiceImpl<ZslxtjMapper, Zslxtj> implements IOtherPageService {


    @Autowired
    private IQylxtjService iQylxtjService;

    @Autowired
    private ICertInfoService certInfoService;

    @Autowired
    private AdminPageServiceImpl adminPageService;
    @Autowired
    ICertModeService iCertModeService;

    @Autowired
    private OtherPageMapper otherPageMapper;

    @Autowired
    private ICertTypeService certTypeService;

    List<ZsmlVo> zsmlVoList = new ArrayList<>();

    public void clearCache() {
        zsmlVoList.clear();
    }

    @Override
    public Map getTypeList(String type) {

        Map resultMap = new HashMap();
        String title = "";
        List<ZsmlVo> ypList = new ArrayList<>();
        List<ZsmlVo> ylList = new ArrayList<>();
        List<ZsmlVo> hzList = new ArrayList<>();
        if (ValidateUtil.isEmpty(zsmlVoList)) {
            zsmlVoList = adminPageService.getTree("4", null);
        }
        for (ZsmlVo zsmlVo : zsmlVoList) {
            title = zsmlVo.getTitle();
            if ("药品".equals(title)) {
                ypList = (List<ZsmlVo>) zsmlVo.getChildren();
            } else if ("医疗器械".equals(title)) {
                ylList = (List<ZsmlVo>) zsmlVo.getChildren();
            } else if ("化妆品".equals(title)) {
                hzList = (List<ZsmlVo>) zsmlVo.getChildren();
            }
        }
        if ("0".equals(type)) {//查药品
            resultMap.put("list", ypList.stream().filter(n -> "1".equals(n.getIsgs())).collect(Collectors.toList()));
        } else if ("1".equals(type)) {//医疗器械
            resultMap.put("list", ylList.stream().filter(n -> "1".equals(n.getIsgs())).collect(Collectors.toList()));
        } else {//化妆品
            resultMap.put("list", hzList.stream().filter(n -> "1".equals(n.getIsgs())).collect(Collectors.toList()));
        }
        return resultMap;
    }

    @Override
    public Map getListDetail(Map map) throws InvocationTargetException, IllegalAccessException {

        Map resultMap = new HashMap();

        Map otherParma = new HashMap();
        String pageNo = map.get("pageindex").toString();
        String pageSize = map.get("pagesize").toString();

        Integer pageNo1 = Integer.parseInt(map.get("pageindex").toString());
        Integer pageSize1 = Integer.parseInt(map.get("pagesize").toString());
        //组装参数，
        CertInfo certInfo = new CertInfo();
        queryBean queryBean = new queryBean();
        Map<String, String[]> parameterMap = new HashMap<>();
        parameterMap.put("column", new String[]{"fzrq"});
        parameterMap.put("order", new String[]{"desc"});
        parameterMap.put("pageNo", new String[]{pageNo});
        parameterMap.put("pageSize", new String[]{pageSize});
        parameterMap.put("zt", new String[]{"4"});
        String certtypeid = "";
        String[] zslb = new String[1];
        if (map.get("type") != null) {
            String type = map.get("type").toString();
            if ("0".equals(type)) {
                zslb[0] = "yp";
            } else if ("1".equals(type)) {
                zslb[0] = "ylqx";
            } else {
                zslb[0] = "hzp";
            }
        }
        parameterMap.put("zslb", zslb);
        if (!ValidateUtil.isEmpty(map.get("typeId"))) {
            String[] parts = map.get("typeId").toString().split("#");
            if (parts.length == 2) {
                certtypeid = parts[1];
                certInfo.setCerttypeid(certtypeid);
                parameterMap.put("certtypeid", new String[]{certtypeid});
            }
        }
        String keyWord = "";
        certInfo.setZt("4");
        if (!ValidateUtil.isEmpty(map.get("keyWord"))) {
            keyWord = map.get("keyWord").toString();
            boolean mat = keyWord.matches(".*\\d.*");
            if (mat) {//有数字
                map.put("value2", keyWord);
            } else {
                map.put("value1", keyWord);
            }
        }
        //组装querybean
        queryBean.setQymc(map.get("value1").toString());
        queryBean.setShxydm(map.get("value2").toString());
        queryBean.setZsbh(map.get("value3").toString());
        String xzqhStr = "";
        if (!ValidateUtil.isEmpty(map.get("value4"))) {
//            List deptIdList =(List) map.get("value4");
//            int length = deptIdList.size()-1;
            xzqhStr = map.get("value4").toString();
        }
        queryBean.setXzqh(xzqhStr);
        queryBean.setFzjg(map.get("value5").toString());
        // Date date = DateUtil.str2Date(map.get("value6").toString(),"yyyy-MM-dd");
        queryBean.setFzrq(map.get("value6").toString());
        queryBean.setChanping(map.get("value7").toString());
        queryBean.setDlzszt("0");
        if (ValidateUtil.isEmpty(map.get("isClick"))) {
            otherParma.put("isClick", true);
        }

        //查询list数据
        IPage<CertInfoIsType> certInfoIsTypeIPage = queryPageList(certInfo, queryBean, pageNo1, pageSize1, parameterMap, otherParma);

        List<CertInfoIsType> list = certInfoIsTypeIPage.getRecords();
        long total = certInfoIsTypeIPage.getTotal();

        // 查询所有证书类型
        LambdaQueryWrapper<CertType> certTypeQuery = new LambdaQueryWrapper();
        certTypeQuery.eq(CertType::getStatus, YwConstant.CERT_TYPE_STATUS_FB);
        certTypeQuery.eq(CertType::getIsgs, YwConstant.DENY);
        if (map.get("type") != null) {
            certTypeQuery.eq(CertType::getCerttypeClassification, zslb[0]);
        }
        List<CertType> certTypeList = certTypeService.list(certTypeQuery);
        Map<String, String> certTypeMap = new HashMap<>();
        for (CertType certType : certTypeList) {
            certTypeMap.put(certType.getId(), certType.getCerttypename());
        }

//        Map aampa = new HashMap();
        for (CertInfoIsType certInfoIsType : list) {
            String isType = certInfoIsType.getIsType();
            String certid = certInfoIsType.getCerttypeid();
//            aampa.put("certtypeid", certid);
//            List<Map<String, String>> aalist = otherPageMapper.getZSLX(aampa);
//            if (ValidateUtil.isNotEmpty(aalist)) {
//                String certtypename = aalist.get(0).get("certtypename");
//                certInfoIsType.setZslx(certtypename);
//            }
            String certtypename = certTypeMap.get(certid);
            certInfoIsType.setZslx(certtypename);

            String zsid = certInfoIsType.getId();
            List<Map<String, String>> handleList = new ArrayList<>();
            if (StringUtils.isNotEmpty(isType)) {
                Arrays.stream(isType.split(",")).filter(s -> !"附件".equals(s)).forEach(item -> {

                    handleList.add(createHandleMap(item, zsid));

                });
            }
            certInfoIsType.setHandle(handleList);
        }
        resultMap.put("total", total);
        resultMap.put("list", list);

        System.out.println(certInfoIsTypeIPage);
        return resultMap;
    }

    @Override
    public Map ListDetailByCertType(Map map) throws InvocationTargetException, IllegalAccessException {
        Map resultMap = new HashMap();
        resultMap.put("total", 0);
        resultMap.put("list", Lists.newArrayList());

        String pageNo = map.get("pageindex").toString();
        String pageSize = map.get("pagesize").toString();

        Integer pageNo1 = Integer.parseInt(map.get("pageindex").toString());
        Integer pageSize1 = Integer.parseInt(map.get("pagesize").toString());
        //组装参数，
        CertInfo certInfo = new CertInfo();
        String certTypeCode = "";
        if (!ValidateUtil.isEmpty(map.get("workCode"))) {
            certTypeCode = map.get("workCode").toString();
        }

        //组装querybean
        queryBean queryBean = new queryBean();
        queryBean.setQymc(map.get("value1").toString());
        queryBean.setShxydm(map.get("value2").toString());
        queryBean.setZsbh(map.get("value3").toString());
        String xzqhStr = "";
        if (!ValidateUtil.isEmpty(map.get("value4"))) {
            xzqhStr = map.get("value4").toString();
        }
        queryBean.setXzqh(xzqhStr);
        queryBean.setFzjg(map.get("value5").toString());
        queryBean.setFzrq(map.get("value6").toString());

        Map<String, String[]> parameterMap = new HashMap<>();
        parameterMap.put("column", new String[]{"fzrq"});
        parameterMap.put("order", new String[]{"desc"});
        parameterMap.put("pageNo", new String[]{pageNo});
        parameterMap.put("pageSize", new String[]{pageSize});
        certInfo.setYxzt("10");
        QueryWrapper<CertInfo> queryWrapper = QueryGenerator.initQueryWrapper(certInfo, parameterMap);
        queryWrapper.and(q -> q.eq("zt" , "4").or().eq("zt", "3"));
        CertType certTypeInfo;
        if (StringUtils.isNotBlank(certTypeCode)) {
            QueryWrapper queryCtByType = new QueryWrapper();
            queryCtByType.eq("certtype", certTypeCode);
            certTypeInfo =  certTypeService.getOne(queryCtByType);
            if (certTypeInfo != null) {
                String sql = "SELECT ci.id FROM CERT_INFO ci JOIN s_dept sd ON sd.dept_id = ci.fzjgid WHERE ci.CERTTYPEID = '" + certTypeInfo.getId() + "'";
                if (StringUtils.isNotBlank(queryBean.getQymc())) {
                    sql += " AND ci.qymc LIKE '%" + queryBean.getQymc() + "%'";
                }
                if (StringUtils.isNotBlank(queryBean.getShxydm())) {
                    sql += " AND ci.shxydm LIKE '%" + queryBean.getShxydm() + "%'";
                }
                if (StringUtils.isNotBlank(queryBean.getZsbh())) {
                    sql += " AND ci.zsbh LIKE '%" + queryBean.getZsbh() + "%'";
                }
                if (StringUtils.isNotBlank(queryBean.getFzjg())) {
                    sql += " AND ci.fzjg LIKE '%" + queryBean.getFzjg() + "%'";
                }
                if (StringUtils.isNotBlank(queryBean.getFzrq())) {
                    sql += " AND ci.fzrq = '" + queryBean.getFzrq() + "'";
                }
                if (StringUtils.isNotBlank(queryBean.getXzqh())) {
                    sql += " AND sd.dept_id = '" + queryBean.getXzqh() + "'";
                }
                if (StringUtils.isNotBlank(queryBean.getChanping())) {
                    sql += " AND ci.chanping LIKE '%" + queryBean.getChanping() + "%'";
                }
                sql += " AND sd.status = '0' ";
                queryWrapper.inSql("id", sql);
            } else {
                return resultMap;
            }
        } else {
            certTypeInfo = null;
            return resultMap;
        }

        //默认查询证书状态为1-核发、2-换发、3-变更
        List<String> zszt = Arrays.asList(YwlxEnum.HEFA.getCode(), YwlxEnum.HUANFA.getCode(), YwlxEnum.BIANGE.getCode(), YwlxEnum.BUFA.getCode(), YwlxEnum.QZWH.getCode());
        queryWrapper.in("zszt", zszt);

        queryWrapper.orderByDesc("id");
        Page<CertInfo> page = new Page<CertInfo>(pageNo1, pageSize1);
        IPage<CertInfo> pageList = certInfoService.page(page, queryWrapper);
        List<CertInfo> list = pageList.getRecords();
        long total = pageList.getTotal();
        List<CertInfoIsType> certInfoIsTypes = new ArrayList<>();
        if (total > 0 && CollectionUtils.isNotEmpty(list)) {
            list.stream().forEach(v -> {
                CertInfoIsType certInfoIsType = new CertInfoIsType();
                BeanUtils.copyProperties(v, certInfoIsType);
                certInfoIsType.setZslx(certTypeInfo.getCerttypename());
                certInfoIsTypes.add(certInfoIsType);
            });
        }
        resultMap.put("total", total);
        resultMap.put("list", certInfoIsTypes);
        return resultMap;
    }

	@Override
	public IPage<ZsQydDto> ListZsQydDto(Map map) throws InvocationTargetException, IllegalAccessException {
		Page<CertInfo> page = new Page<>(MapUtils.getIntValue(map, "pageindex", 1), MapUtils.getIntValue(map, "pagesize", 10));
		String shxydm = StringUtils.defaultIfBlank(MapUtils.getString(map, "shxydm"), MapUtils.getString(map, "value2")),
			qymc = StringUtils.defaultIfBlank(MapUtils.getString(map, "qymc"), MapUtils.getString(map, "value1")),
			zsbh = StringUtils.defaultIfBlank(MapUtils.getString(map, "zsbh"), MapUtils.getString(map, "value3")),
			zslx = MapUtils.getString(map, "zslx"),
			certTypeId = MapUtils.getString(map, "certTypeId"),
			zsid = MapUtils.getString(map, "zsid"),
			gzTimeBgn = MapUtils.getString(map, "gzTimeBgn"),
			gzTimeEnd = MapUtils.getString(map, "gzTimeEnd"),
			baseUrl = "https://zsgs.hubyjj.cn:8096/hbdzzz/sys/common/static";
		QueryWrapper<CertInfo> query = new QueryWrapper<>();
		query.eq("YXZT", "10");
		query.eq(StringUtils.isNotBlank(zslx), "ZSLX", zslx);
		query.eq(StringUtils.isNotBlank(certTypeId), "CERTTYPEID", certTypeId);
		query.in("ZSZT", YwlxEnum.HEFA.getCode(), YwlxEnum.HUANFA.getCode(), YwlxEnum.BIANGE.getCode(), YwlxEnum.QZWH.getCode());
		if (StringUtils.isNotBlank(zsid)) query.in("ZSID", Arrays.asList(zsid.split("[,]+")).toArray());
		query.eq(StringUtils.isNotBlank(shxydm), "SHXYDM", shxydm);
		if (StringUtils.isNotBlank(gzTimeBgn)) query.ge("GZTIME", org.jeecg.modules.demo.dzzz.util.DateUtils.parseDate(gzTimeBgn));
		if (StringUtils.isNotBlank(gzTimeEnd)) query.le("GZTIME", org.jeecg.modules.demo.dzzz.util.DateUtils.parseDate(gzTimeEnd));
		query.like(StringUtils.isNotBlank(zsbh), "ZSBH", zsbh);
		query.like(StringUtils.isNotBlank(qymc), "QYMC", qymc);
		query.inSql("CERTTYPEID", "SELECT ID FROM CERT_TYPE WHERE CERTTYPE_CLASSIFICATION IN ('yp','ylqx','hzp')");
		query.inSql("FZJGID", "SELECT DEPT_ID FROM S_DEPT WHERE STATUS='0'");
		query.orderByDesc("FZRQ");
		page = certInfoService.page(page, query);
		Page<ZsQydDto> resPage = new Page<>(page.getCurrent(), page.getSize());
		resPage.setTotal(page.getTotal());
		resPage.setPages(page.getPages());
		resPage.setRecords(new ArrayList<>());
		for (CertInfoIsType item : CertUtils.addAttachInfo(page.getRecords(), "QYD", CertInfoIsType.class, true)) {
			ZsQydDto bean = new ZsQydDto();
			BeanUtils.copyProperties(item, bean);
			bean.setZslxBm(bean.getZslx());
			bean.setZslx(item.getZslxName());
			bean.setCertTypeId(item.getCerttypeid());
			List<Map<String, String>> list = new ArrayList<>();
			for (String str : StringUtils.trimToEmpty(item.getIsType()).split("[,]+")) {
				if (StringUtils.isBlank(str)) continue;
				String[] ss = str.split("[;]");
				Map<String, String> m = new HashMap<>();
				String url = StringUtils.trimToEmpty(ss[1]);
				m.put("name", ss[0]);
				m.put("type", FilenameUtils.getExtension(url).toUpperCase());
				m.put("url", baseUrl + (StringUtils.startsWithAny(url, "\\", "/") ? "" : "/") + url);
				if (2 < ss.length) m.put("userName", ss[2]);
				if (3 < ss.length) {
					m.put("createTime", ss[3]);
					if (StringUtils.isBlank(bean.getGzTime()))
						bean.setGzTime(ss[3]);
				}
				list.add(m);
			}
			bean.setFiles(list);
			resPage.getRecords().add(bean);
		}
		return resPage;
	}


    public IPage<CertInfoIsType> queryPageList(CertInfo certInfo, queryBean queryBean,
                                               Integer pageNo,
                                               Integer pageSize,
                                               Map<String, String[]> parameterMap, Map otherMap) throws InvocationTargetException, IllegalAccessException {
        String cx = "";
        if ("cx".equals(certInfo.getZt()) && StringUtils.isNotBlank(certInfo.getZsdl())) {
            cx = certInfo.getZsdl();
            certInfo.setZt(null);
            certInfo.setZsdl(null);
        }

        //判断是否是点击
        String zslb = null;
        String[] zslbArray = parameterMap.get("zslb");
        if (zslbArray != null && zslbArray.length > 0) {
            zslb = zslbArray[0];
            cx = zslb;
        } else {
            cx = "all";
        }

        QueryWrapper<CertInfo> queryWrapper = QueryGenerator.initQueryWrapper(certInfo, parameterMap);

        if (queryBean.getBeginDate() != null) {
            queryWrapper.gt("fzrq", queryBean.getBeginDate());
        }
        if (StringUtils.isNotBlank(queryBean.getDlzslx())) {
            queryWrapper.eq("certtypeid", queryBean.getDlzslx());
        }
        if (StringUtils.isNotBlank(queryBean.getDlzszt())) {  //有效
            if ("0".equals(queryBean.getDlzszt())) {
                queryWrapper.eq("yxzt", "10");
            }
            if ("1".equals(queryBean.getDlzszt())) {

                queryWrapper.lt("yxqz", DateUtils.formatDate(new Date(), "yyyy-MM-dd hh:mm:ss"));
            }
            if ("2".equals(queryBean.getDlzszt())) {

                queryWrapper.eq("yxzt", "50");

            }

        }
//        if (queryBean.getEndDate()!=null)
//        {
//            queryWrapper.lt("fzrq",queryBean.getEndDate());
//        }
        if (StringUtils.isBlank(cx)) {
            queryWrapper.eq("yxzt", "10");

        }
        //默认查询证书状态为1-核发、2-换发、3-变更
        List<String> zszt = Arrays.asList(YwlxEnum.HEFA.getCode(), YwlxEnum.HUANFA.getCode(), YwlxEnum.BIANGE.getCode(), YwlxEnum.QZWH.getCode());
        queryWrapper.in("zszt", zszt);



        // 动态SQL查询
        if (StringUtils.isNotBlank(cx)) {
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT ci.id ")
                    .append("FROM CERT_INFO ci ")
                    .append("JOIN cert_type ct ON ci.CERTTYPEID = ct.id ")
                    .append("JOIN s_dept sd ON sd.dept_id = ci.fzjgid ");
//                    .append("WHERE ct.isgs='1' ");

            if ("all".equals(cx)) {
                sb.append("WHERE ct.isgs='1' AND ct.certtype_classification IN ('yp', 'ylqx', 'hzp')");
            } else {
                sb.append("WHERE ct.isgs='1' AND ct.certtype_classification = '").append(cx).append("'");
            }
            String sql = sb.toString();

            if (StringUtils.isNotBlank(queryBean.getQymc())) {
                sql += " AND ci.qymc LIKE '%" + queryBean.getQymc() + "%'";
            }
            if (StringUtils.isNotBlank(queryBean.getShxydm())) {
                sql += " AND ci.shxydm LIKE '%" + queryBean.getShxydm() + "%'";
            }
            if (StringUtils.isNotBlank(queryBean.getZsbh())) {
                sql += " AND ci.zsbh LIKE '%" + queryBean.getZsbh() + "%'";
            }
            if (StringUtils.isNotBlank(queryBean.getFzjg())) {
                sql += " AND ci.fzjg LIKE '%" + queryBean.getFzjg() + "%'";
            }
            if (StringUtils.isNotBlank(queryBean.getFzrq())) {
                sql += " AND ci.fzrq = '" + queryBean.getFzrq() + "'";
            }
            if (StringUtils.isNotBlank(queryBean.getXzqh())) {
                sql += " AND sd.dept_id = '" + queryBean.getXzqh() + "'";
            }
            if (StringUtils.isNotBlank(queryBean.getChanping())) {
                sql += " AND ci.chanping LIKE '%" + queryBean.getChanping() + "%'";
            }
            sql += " AND sd.status = '0' ";

            queryWrapper.inSql("id", sql);
        } else {
            queryWrapper.eq("yxzt", "10");
        }

//        if(StringUtils.isNotBlank(cx)){
//
//            String sql= " SELECT ci.id FROM CERT_INFO ci ,cert_type ct " +
//                    " WHERE  ci.CERTTYPEID =ct.id AND  ct.certtype_classification = '"+cx+"'";
//            queryWrapper.inSql("id",sql);
//        }
        queryWrapper.orderByDesc("id");
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


        resultList.setRecords(CertUtils.addAttachInfo(page.getRecords(), "GS", CertInfoIsType.class));
        return resultList;
    }

    private Map<String, String> createHandleMap(String name, String zsid) {
        Map<String, String> handleMap = new HashMap<>();
        handleMap.put("name", name);
        handleMap.put("zsid", zsid);
        return handleMap;
    }


    private Map<String, String> createFileHandleMap(String name, String zsid) {
        Map<String, String> handleMap = new HashMap<>();
        String ljurl = "https://zsgs.hubyjj.cn:8096/hbdzzz/sys/common/static/";
        Attachinfo attach = certInfoService.getAttachByCertid(zsid, name, "1");
        handleMap.put("name", name);
        handleMap.put("type", "OFD");
        if(null!=attach){
            handleMap.put("url",ljurl+attach.getModeUrl());
        }

        return handleMap;
    }

}


