package org.jeecg.modules.demo.dzzz.homepage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.shiro.SecurityUtils;
import org.jeecg.common.system.vo.DictModel;
import org.jeecg.common.system.vo.LoginUser;
import org.jeecg.modules.demo.dzzz.certStatistics.entity.Qylxtj;
import org.jeecg.modules.demo.dzzz.certStatistics.mapper.QylxtjMapper;
import org.jeecg.modules.demo.dzzz.certStatistics.service.IQylxtjService;
import org.jeecg.modules.demo.dzzz.certStatistics.util.zzUtil.ValidateUtil;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertInfoService;
import org.jeecg.modules.demo.dzzz.certmulu.controller.CertmuluController;
import org.jeecg.modules.demo.dzzz.certmulu.entity.ZsmlVo;
import org.jeecg.modules.demo.dzzz.certtype.entity.CertType;
import org.jeecg.modules.demo.dzzz.certtype.service.ICertTypeService;
import org.jeecg.modules.demo.dzzz.homepage.mapper.AdminPageMapper;
import org.jeecg.modules.demo.dzzz.homepage.service.IAdminPageService;
import org.jeecg.modules.demo.dzzz.util.DateUtils;
import org.jeecg.modules.demo.dzzz.wgz.service.IZsYwxxbService;
import org.jeecg.modules.system.service.ISysDictService;
import org.jeecg.modules.system.service.impl.SysBaseApiImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class AdminPageServiceImpl extends ServiceImpl<QylxtjMapper, Qylxtj> implements IAdminPageService {


    @Autowired
    private AdminPageMapper adminPageMapper;
    @Autowired
    private ISysDictService sysDictService;

    @Autowired
    private ICertTypeService certTypeService;
    @Autowired
    private ICertInfoService certInfoService;
    @Autowired
    private SysBaseApiImpl sysBaseApi;
    @Autowired
    private IZsYwxxbService iZsYwxxbService;
    @Autowired
    private  ICertInfoService iCertInfoService;



    @Override
    public Map getDgz() {

        Map resultMap = new HashMap();
        //待盖章总量
        int count_dgz = adminPageMapper.getdgzCount();
        int count_yj = adminPageMapper.getYjCount();
        //待盖章证书类型
        List<Map> list = adminPageMapper.getDgzZs();
//        List<ZsmlVo> zsmlVoList = getTree("3",null);
//        for (ZsmlVo zsmlVo : zsmlVoList) {
//            Map map = new HashMap();
//            map.put("name",zsmlVo.getTitle());
//            map.put("value",zsmlVo.getQty());
//            list.add(map);
//        }

        resultMap.put("await_stamp",count_dgz);
        resultMap.put("warn_stamp",count_yj);
        resultMap.put("list",list);
        System.out.println(list);
        return resultMap;
    }

    @Override
    public Map getZsfb() {
        Map resultMap = new HashMap();

        //获取湖北省和省本级的证书数量
        List<ZsmlVo> zsmlVoList = getTree("4",null);
        List<Map> szspmList = adminPageMapper.getZsfb();
        List<Map<String, Object>> resultList = new ArrayList<>();

        if (szspmList.size() == 1) {
            Map<String, Object> originalMap = szspmList.get(0);

            for (Map.Entry<String, Object> entry : originalMap.entrySet()) {

                if("湖北省".equals(entry.getKey())){
                    resultMap.put("total",entry.getValue());
                }
                if("省本级".equals(entry.getKey())){
                    resultMap.put("pro_total",entry.getValue());
                }
                Map<String, Object> newMap = new HashMap<>();
                newMap.put("name", entry.getKey());
                newMap.put("value", entry.getValue());
                resultList.add(newMap);
            }
        }
        resultMap.put("list",resultList);
        for (ZsmlVo zsmlVo : zsmlVoList) {
            String title = zsmlVo.getTitle();
            if("药品".equals(title)){
                resultMap.put("drug_total",zsmlVo.getQty());
            }else if("医疗器械".equals(title)){
                resultMap.put("app_total",zsmlVo.getQty());
            }else if("化妆品".equals(title)){
                resultMap.put("cosmetics_total",zsmlVo.getQty());
            }
        }
        return resultMap;
    }

    @Override
    public Map getStampRank() {

        Map resultMap = new HashMap();
        //获取已盖章证书，
        List<Map<String,Long>> list = adminPageMapper.getYgzZs();
        int total = 10000;

        // 使用流操作计算占比并添加新的字段
        List<Map<String, Object>> result = list.stream()
                .map(item -> {
                    Map<String, Object> newItem = new HashMap<>(item);
                    Long value = item.get("VALUE");
                    double percentage = (value * 100.0) / total;
                    newItem.put("ratio", percentage);
                    return newItem;
                })
                .collect(Collectors.toList());
        //根据数量增加ratio字段
        resultMap.put("list",result);
        return resultMap;
    }

    @Override
    public Map getFirmInfo() {
        Map result = adminPageMapper.getFirmInfo();

        return result;
    }

    @Override
    public Map getinfo(String name) {
        Map resultMap = new HashMap();
        List<ZsmlVo> zsmlVoList = getTree("3",null);

        ZsmlVo zsmlVo = findZsmlVoByValue(zsmlVoList,name);
        resultMap.put("data",zsmlVo);
        return resultMap;
    }

    @Override
    public Map stampInfo() {
        //查询证书总览

        List<Map> resultList = new ArrayList<>();
        Map resultMap = new HashMap();
        Map queryMap = new HashMap();
        Map queryMap1 = new HashMap();
        Map queryMap2 = new HashMap();
        // 获取当前日期
        LocalDate currentDate = LocalDate.now();
        String formattedCurrentDate = currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // 获取当前月的第一天
        LocalDate firstDayOfMonth = currentDate.withDayOfMonth(1);
        String formattedFirstDayOfMonth = firstDayOfMonth.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // 获取当前月的最后一天
        YearMonth yearMonth = YearMonth.from(currentDate);
        LocalDate lastDayOfMonth = yearMonth.atEndOfMonth();
        String formattedLastDayOfMonth = lastDayOfMonth.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        queryMap1.put("startTime",formattedFirstDayOfMonth);
        queryMap1.put("endTime",formattedLastDayOfMonth);

        queryMap2.put("startTime",formattedCurrentDate);
        queryMap2.put("endTime",formattedCurrentDate);
        //查询总览信息
        List<Map> zszlList = adminPageMapper.getStampInfo(queryMap);

        //查询当前月
        List<Map> zszlListdy = adminPageMapper.getStampInfo(queryMap1);
        //查询当天数据
        List<Map> zszlListdt = adminPageMapper.getStampInfo(queryMap2);

        Map<String,String> qsMap = new HashMap<>();
        Map<String,String> sbjMap = new HashMap<>();
        Map<String,String> szMap = new HashMap<>();
        if(ValidateUtil.isNotEmpty(zszlList)){
            Map map = zszlList.get(0);
            qsMap.put("name","全省累计发证量");
            qsMap.put("total",map.get("湖北省").toString());
            sbjMap.put("name","省本级累计发证量");
            sbjMap.put("total",map.get("省本级").toString());
            szMap.put("name","市州累计发证量");
            szMap.put("total",map.get("市州").toString());
        }
        if(ValidateUtil.isNotEmpty(zszlListdy)){
            Map map = zszlListdy.get(0);
            qsMap.put("month_total",map.get("湖北省").toString());
            sbjMap.put("month_total",map.get("省本级").toString());
            szMap.put("month_total",map.get("市州").toString());
        }
        if(ValidateUtil.isNotEmpty(zszlListdt)){
            Map map = zszlListdt.get(0);
            qsMap.put("day_total",map.get("湖北省").toString());
            sbjMap.put("day_total",map.get("省本级").toString());
            szMap.put("day_total",map.get("市州").toString());
        }
        resultList.add(qsMap);
        resultList.add(sbjMap);
        resultList.add(szMap);
        resultMap.put("list",resultList);
        return resultMap;
    }

    @Override
    public Map getstampWarnList() {
        Map resultMap = new HashMap();

        List<Map> list =  adminPageMapper.getstampWarnList();
        resultMap.put("list",list);
        return resultMap;
    }


    public List<ZsmlVo> getTree( String zt,String status){
        List<ZsmlVo> list = new ArrayList<>();
        List<DictModel> dictModelList = sysDictService.queryDictItemsByCode("cert_type_lx");

        LambdaQueryWrapper<CertType> lqw = new LambdaQueryWrapper<>();
        lqw.isNotNull(CertType::getCerttypeClassification);
        lqw.eq(CertType::getStatus, "2");//1 起草、2 发布、3 注销、4 历史
        lqw.orderByAsc(CertType::getOrdernum);
        List<CertType> certTypes = certTypeService.list(lqw);
        if(StringUtils.isNotBlank(status)&&"wh".equals(status))
        {
            for (DictModel dictModel : dictModelList) {
                ZsmlVo zsmlVo=new ZsmlVo();
                zsmlVo.setKey(dictModel.getValue());
                zsmlVo.setValue(dictModel.getValue());
                zsmlVo.setTitle(dictModel.getText());
                zsmlVo.setChildren(childerNodeListwh(zsmlVo, dictModel.getValue(), certTypes, zt));
                list.add(zsmlVo);
            }
        }
        else if(StringUtils.isNotBlank(status)&&"xzdgz".equals(status))
        {
            for (DictModel dictModel : dictModelList) {
                ZsmlVo zsmlVo=new ZsmlVo();
                zsmlVo.setKey(dictModel.getValue());
                zsmlVo.setValue(dictModel.getValue());
                zsmlVo.setTitle(dictModel.getText());
                zsmlVo.setChildren(childerNodeLisxzdgz(zsmlVo, dictModel.getValue(), certTypes, zt));
                list.add(zsmlVo);
            }
        }
        else if(StringUtils.isNotBlank(status)&&"xz".equals(status))
        {
            for (DictModel dictModel : dictModelList) {
                ZsmlVo zsmlVo=new ZsmlVo();
                zsmlVo.setKey(dictModel.getValue());
                zsmlVo.setValue(dictModel.getValue());
                zsmlVo.setTitle(dictModel.getText());
                zsmlVo.setChildren(childerNodeLisxt(zsmlVo, dictModel.getValue(), certTypes, zt));
                list.add(zsmlVo);
            }
        }
        else if(StringUtils.isNotBlank(status)&&"1".equals(status))
        {
            for (DictModel dictModel : dictModelList) {
                ZsmlVo zsmlVo=new ZsmlVo();
                zsmlVo.setKey(dictModel.getValue());
                zsmlVo.setValue(dictModel.getValue());
                zsmlVo.setTitle(dictModel.getText());
                zsmlVo.setChildren(childerNodeList1(zsmlVo, dictModel.getValue(), certTypes, zt));
                list.add(zsmlVo);
            }
        }
        else {

            for (DictModel dictModel : dictModelList) {
                ZsmlVo zsmlVo = new ZsmlVo();
                zsmlVo.setKey(dictModel.getValue());
                zsmlVo.setValue(dictModel.getValue());
                zsmlVo.setTitle(dictModel.getText());
                zsmlVo.setChildren(childerNodeList(zsmlVo, dictModel.getValue(), certTypes, zt));
                list.add(zsmlVo);
            }
        }
        return list;
    }

    private List<ZsmlVo> childerNodeList(ZsmlVo parent, String keyName,List<CertType> list,String zt) {
        int total = 0;
        List<ZsmlVo> childrenList = new ArrayList<>();
        //获取当前登录用户
    /*    LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
        List<String> roleIdsByUsername = sysBaseApi.getRolesByUsername(sysUser.getUsername());
        System.out.println("1:"+ DateUtils.parseDateToStr("yyyy-MM-DD HH:mm:ss",new Date()));
*/
        for (CertType certType : list) {
            if(keyName.equals(certType.getCerttypeClassification())){
         /*       LambdaQueryWrapper<CerttypeRole> certroles=new LambdaQueryWrapper<>();
                certroles.eq(CerttypeRole::getCerttypeid,certType.getId());

                *//*for (String rolename:roleIdsByUsername
                     ) {
                    certroles.or().eq(CerttypeRole::getRoleid,rolename);
                }*//*
                iCerttypeRoleService.list(certroles);*/

                //配置了权限才能展示
                /*List<CerttypeRole> certlistByrole = certInfoService.getCertlistByrole(certType.getId(), roleIdsByUsername);
                if (certlistByrole.isEmpty()||certlistByrole.size()==0)
                {
                    continue;
                }*/
                QueryWrapper lambdaQueryWrapper=new QueryWrapper();
                lambdaQueryWrapper.eq("certtypeid",certType.getId());
                //10有效
                lambdaQueryWrapper.eq("yxzt","10");
                if(StringUtils.isNotBlank(zt)&&!"未传值".equals(zt))
                {
                    lambdaQueryWrapper.eq("zt",zt);

                }
            /*    if("6".equals(zt))
                {
                    lambdaQueryWrapper.eq(CertInfo::getIsbl,"1");
                }*/
               /* if("7".equals(zt))
                {
                    lambdaQueryWrapper.eq(CertInfo::getIsbf,"1");
                }*/
                int count=0;
                if(StringUtils.isNotBlank(zt)&&"3".equals(zt))
                {
                    count =(int) iZsYwxxbService.count(lambdaQueryWrapper);
                }
                else {
                    count = (int) certInfoService.count(lambdaQueryWrapper);
                }
                ZsmlVo tree = new ZsmlVo();
                tree.setKey(keyName + "#" +certType.getId());
                tree.setValue( certType.getCerttypename());
                tree.setTitle(certType.getCerttypename());
                tree.setIsgs(certType.getIsgs());
                tree.setQty(count);
                tree.setZslx(certType.getCerttype());
                childrenList.add(tree);
                total+=tree.getQty();
            }
        }
        System.out.println("2："+ DateUtils.parseDateToStr("yyyy-MM-DD HH:mm:ss",new Date()));

        parent.setQty(total);
        return childrenList;
    }

    /**
     * 默认显示页面，怕加载太慢 先处理这个
     * @param parent
     * @param keyName
     * @param list
     * @param zt
     * @return
     */
    private List<ZsmlVo> childerNodeList1(ZsmlVo parent, String keyName,List<CertType> list,String zt) {
        int total = 0;
        List<ZsmlVo> childrenList = new ArrayList<>();
        //获取当前登录用户
    /*    LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
        List<String> roleIdsByUsername = sysBaseApi.getRolesByUsername(sysUser.getUsername());
        System.out.println("1:"+ DateUtils.parseDateToStr("yyyy-MM-DD HH:mm:ss",new Date()));
*/
        for (CertType certType : list) {
            if(keyName.equals(certType.getCerttypeClassification())){
         /*       LambdaQueryWrapper<CerttypeRole> certroles=new LambdaQueryWrapper<>();
                certroles.eq(CerttypeRole::getCerttypeid,certType.getId());

                *//*for (String rolename:roleIdsByUsername
                     ) {
                    certroles.or().eq(CerttypeRole::getRoleid,rolename);
                }*//*
                iCerttypeRoleService.list(certroles);*/

                //配置了权限才能展示
                /*List<CerttypeRole> certlistByrole = certInfoService.getCertlistByrole(certType.getId(), roleIdsByUsername);
                if (certlistByrole.isEmpty()||certlistByrole.size()==0)
                {
                    continue;
                }*/

            /*    if("6".equals(zt))
                {
                    lambdaQueryWrapper.eq(CertInfo::getIsbl,"1");
                }*/
               /* if("7".equals(zt))
                {
                    lambdaQueryWrapper.eq(CertInfo::getIsbf,"1");
                }*/

                ZsmlVo tree = new ZsmlVo();
                tree.setKey(keyName + "#" +certType.getId());
                tree.setValue( certType.getCerttypename());
                tree.setTitle(certType.getCerttypename());
                tree.setIsgs(certType.getIsgs());
                childrenList.add(tree);

            }
        }
        System.out.println("2："+ DateUtils.parseDateToStr("yyyy-MM-DD HH:mm:ss",new Date()));

        parent.setQty(total);
        return childrenList;
    }
    private List<ZsmlVo> childerNodeListwh(ZsmlVo parent, String keyName,List<CertType> list,String zt) {
        int total = 0;
        List<ZsmlVo> childrenList = new ArrayList<>();
        //获取当前登录用户
    /*    LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
        List<String> roleIdsByUsername = sysBaseApi.getRolesByUsername(sysUser.getUsername());
        System.out.println("1:"+ DateUtils.parseDateToStr("yyyy-MM-DD HH:mm:ss",new Date()));
*/
        for (CertType certType : list) {
            if(keyName.equals(certType.getCerttypeClassification())){
         /*       LambdaQueryWrapper<CerttypeRole> certroles=new LambdaQueryWrapper<>();
                certroles.eq(CerttypeRole::getCerttypeid,certType.getId());

                *//*for (String rolename:roleIdsByUsername
                     ) {
                    certroles.or().eq(CerttypeRole::getRoleid,rolename);
                }*//*
                iCerttypeRoleService.list(certroles);*/

                //配置了权限才能展示
                /*List<CerttypeRole> certlistByrole = certInfoService.getCertlistByrole(certType.getId(), roleIdsByUsername);
                if (certlistByrole.isEmpty()||certlistByrole.size()==0)
                {
                    continue;
                }*/

            /*    if("6".equals(zt))
                {
                    lambdaQueryWrapper.eq(CertInfo::getIsbl,"1");
                }*/
               /* if("7".equals(zt))
                {
                    lambdaQueryWrapper.eq(CertInfo::getIsbf,"1");
                }*/
                String sql="and certtypeid = '"+certType.getId()+"' ";
                sql+="and yxzt = '10' ";

                String sql1="";
                sql1=sql;

                int count =(int) iCertInfoService.countselectAll(sql1,sql) ;

                ZsmlVo tree = new ZsmlVo();
                tree.setKey(keyName + "#" +certType.getId());
                tree.setValue( certType.getCerttypename());
                tree.setTitle(certType.getCerttypename());
                tree.setIsgs(certType.getIsgs());
                tree.setQty(count);
                childrenList.add(tree);
                total+=tree.getQty();

            }
        }
        System.out.println("2："+ DateUtils.parseDateToStr("yyyy-MM-DD HH:mm:ss",new Date()));

        parent.setQty(total);
        return childrenList;
    }
    private List<ZsmlVo> childerNodeLisxt(ZsmlVo parent, String keyName,List<CertType> list,String zt) {
        int total = 0;
        List<ZsmlVo> childrenList = new ArrayList<>();
        //获取当前登录用户
  /*      LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
        List<String> roleIdsByUsername = sysBaseApi.getRolesByUsername(sysUser.getUsername());
        System.out.println("1:"+ DateUtils.parseDateToStr("yyyy-MM-DD HH:mm:ss",new Date()));
*/
        for (CertType certType : list) {
            if(keyName.equals(certType.getCerttypeClassification())){

                String sql="and certtypeid = '"+certType.getId()+"' ";
                sql+="and yxzt = '10' ";
                sql+="and isxt = '1' ";

                String sql1="";
                sql1=sql;

                int count =(int) iCertInfoService.countselectAll(sql1,sql) ;

                ZsmlVo tree = new ZsmlVo();
                tree.setKey(keyName + "#" +certType.getId());
                tree.setValue( certType.getCerttypename());
                tree.setTitle(certType.getCerttypename());
                tree.setIsgs(certType.getIsgs());
                tree.setQty(count);
                childrenList.add(tree);
                total+=tree.getQty();

            }
        }
        System.out.println("2："+ DateUtils.parseDateToStr("yyyy-MM-DD HH:mm:ss",new Date()));

        parent.setQty(total);
        return childrenList;
    }
    private List<ZsmlVo> childerNodeLisxzdgz(ZsmlVo parent, String keyName,List<CertType> list,String zt) {
        int total = 0;
        List<ZsmlVo> childrenList = new ArrayList<>();
        //获取当前登录用户
   /*     LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
        List<String> roleIdsByUsername = sysBaseApi.getRolesByUsername(sysUser.getUsername());
        System.out.println("1:"+ DateUtils.parseDateToStr("yyyy-MM-DD HH:mm:ss",new Date()));
*/
        for (CertType certType : list) {
            if(keyName.equals(certType.getCerttypeClassification())){

                String sql="and certtypeid = '"+certType.getId()+"' ";
                sql+="and yxzt = '10' ";
                sql+="and isxt = '1' ";
                sql+="and zt = '3'";
                String sql1="";
                sql1=sql;

                int count =(int) iCertInfoService.countselectAll(sql1,sql) ;

                ZsmlVo tree = new ZsmlVo();
                tree.setKey(keyName + "#" +certType.getId());
                tree.setValue( certType.getCerttypename());
                tree.setTitle(certType.getCerttypename());
                tree.setIsgs(certType.getIsgs());
                tree.setQty(count);
                childrenList.add(tree);
                total+=tree.getQty();

            }
        }
        System.out.println("2："+ DateUtils.parseDateToStr("yyyy-MM-DD HH:mm:ss",new Date()));

        parent.setQty(total);
        return childrenList;
    }

        public  ZsmlVo findZsmlVoByValue(List<ZsmlVo> zsmlVoList, String name) {
            if (zsmlVoList == null || name == null) {
                return null;
            }
            for (ZsmlVo zsmlVo : zsmlVoList) {
                // 检查并转换 children 列表的类型
                if (zsmlVo.getChildren() != null) {
                    List<?> childrenList = zsmlVo.getChildren();
                    for (Object child : childrenList) {
                        if (child instanceof ZsmlVo) {
                            ZsmlVo childVo = (ZsmlVo) child;
                            if (name.equals(childVo.getValue())) {
                                return childVo;
                            }
                        }
                    }
                }
            }
            return null;
        }

}
