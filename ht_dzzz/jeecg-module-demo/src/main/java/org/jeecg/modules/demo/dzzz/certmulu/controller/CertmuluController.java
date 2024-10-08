package org.jeecg.modules.demo.dzzz.certmulu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import org.apache.shiro.SecurityUtils;
import org.jeecg.common.system.vo.LoginUser;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertInfoService;
import org.jeecg.modules.demo.dzzz.certmulu.entity.ZsmlLIstVo;
import org.jeecg.modules.demo.dzzz.certtyperole.service.ICerttypeRoleService;
import org.jeecg.modules.demo.dzzz.constant.YwConstant;
import org.jeecg.modules.demo.dzzz.util.DateUtils;
import org.jeecg.modules.demo.dzzz.wgz.service.IZsYwxxbService;
import org.jeecg.modules.system.service.ISysDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecg.common.system.vo.DictModel;
import org.jeecg.modules.demo.dzzz.certmulu.entity.ZsmlVo;
import org.jeecg.modules.demo.dzzz.certtype.entity.CertType;
import org.jeecg.modules.demo.dzzz.certtype.service.ICertTypeService;
import org.jeecg.modules.system.service.impl.SysBaseApiImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;


@Api(tags="证照目录")
@RestController
@RequestMapping("/dzzz/certmulu")
@Slf4j
public class CertmuluController extends JeecgController<CertType, ICertTypeService> {
   @Autowired
   private ICertTypeService certTypeService;
   @Autowired
   private ICertInfoService certInfoService;
   @Autowired
   private ISysDictService sysDictService;
    @Autowired
    private SysBaseApiImpl sysBaseApi;
    @Autowired
    private IZsYwxxbService iZsYwxxbService;
    @Autowired
    private  ICertInfoService iCertInfoService;
    @Autowired
    private ICerttypeRoleService iCerttypeRoleService;
    @AutoLog(value = "证书目录-tree结构")
    @ApiOperation(value = "证书目录-tree结构", notes = "证书目录-tree结构")
    @GetMapping(value = "/queryList")
    public Result<?> queryList(HttpServletRequest req) {
        String zt = req.getParameter("lx");

        QueryWrapper lqw = new QueryWrapper<>();
        lqw.isNotNull("certtype_classification");
        lqw.eq("certtype_classification",zt);
        lqw.eq("status", "2");//1 起草、2 发布、3 注销、4 历史
        lqw.orderByAsc("ordernum");
        List<CertType> certTypes = certTypeService.list(lqw);
        List<ZsmlLIstVo> list=new ArrayList<>();
            for (CertType cert : certTypes) {
                ZsmlLIstVo zs=new ZsmlLIstVo();
                zs.setCerttypeid(cert.getId());
                zs.setKey(cert.getCerttypename());
                list.add(zs);
            }
        return Result.OK(list);
    }
    @AutoLog(value = "证书目录-tree结构")
    @ApiOperation(value = "证书目录-tree结构", notes = "证书目录-tree结构")
    @GetMapping(value = "/queryTree")
    public Result<?> queryTree(HttpServletRequest req) {
        String zt = req.getParameter("zt");
        String status = req.getParameter("status");
        // 是否显示职业药师（0：显示，1：不显示）
        String showZyys = req.getParameter("showZyys");
        List<ZsmlVo> list = new ArrayList<>();
        List<DictModel> dictModelList = sysDictService.queryDictItemsByCode("cert_type_lx");

        //获取当前登录用户角色对应的证书类型
        LoginUser loginUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
        List<String> roleIdsByUsername = sysBaseApi.getRolesByUsername(loginUser.getUsername());
        if (CollectionUtils.isEmpty(roleIdsByUsername)) {
            return Result.OK(list);
        }
        Map<String, Object> param = new HashMap<>();
        param.put("roleId", roleIdsByUsername.get(0));
        param.put("status", "2");
        List<CertType> certTypes = certTypeService.queryCerttypeByRole(param);
        /*LambdaQueryWrapper<CertType> lqw = new LambdaQueryWrapper<>();
        lqw.isNotNull(CertType::getCerttypeClassification);
        lqw.eq(CertType::getStatus, "2");//1 起草、2 发布、3 注销、4 历史
        lqw.orderByAsc(CertType::getOrdernum);
        List<CertType> certTypes = certTypeService.list(lqw);*/
        // 不显示‘执业药师’类型证书
        if ("1".equals(showZyys)) {
            List<CertType> zyys = certTypes.stream().filter(certType -> YwConstant.CERTTYPEID_ZYYS.equals(certType.getId())).collect(Collectors.toList());
            certTypes.remove(zyys.get(0));
        }
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
                zsmlVo.setZslx("0");
                zsmlVo.setChildren(childerNodeList(zsmlVo, dictModel.getValue(), certTypes, zt));
                list.add(zsmlVo);
            }
        }
        return Result.OK(list);
    }

    private List<ZsmlVo> childerNodeList(ZsmlVo parent, String keyName,List<CertType> list,String zt) {
        int total = 0;
        List<ZsmlVo> childrenList = new ArrayList<>();
        //获取当前登录用户
        LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
        //根据登陆用户查询用户部门
        List<String> departIdsByUsername  = sysBaseApi.getDepartIdsByUsername(sysUser.getUsername());
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
                        lambdaQueryWrapper.in("FZJGID", departIdsByUsername);
                    }
                }
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
                tree.setQty(count);
                tree.setZslx(certType.getZslx());
                childrenList.add(tree);
                total+=tree.getQty();
            }
        }

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
      /*  LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
        List<String> roleIdsByUsername = sysBaseApi.getRolesByUsername(sysUser.getUsername());
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
       /* LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
        List<String> roleIdsByUsername = sysBaseApi.getRolesByUsername(sysUser.getUsername());*/
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
                tree.setQty(count);
                childrenList.add(tree);
                total+=tree.getQty();

            }
        }

        parent.setQty(total);
        return childrenList;
    }
    private List<ZsmlVo> childerNodeLisxt(ZsmlVo parent, String keyName,List<CertType> list,String zt) {
        int total = 0;
        List<ZsmlVo> childrenList = new ArrayList<>();
        //获取当前登录用户
     /*   LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
        List<String> roleIdsByUsername = sysBaseApi.getRolesByUsername(sysUser.getUsername());
        System.out.println("1:"+ DateUtils.parseDateToStr("yyyy-MM-DD HH:mm:ss",new Date()));
*/
        //获取当前登录用户
        LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
        //根据登陆用户查询用户部门
        List<String> departIdsByUsername  = sysBaseApi.getDepartIdsByUsername(sysUser.getUsername());
        for (CertType certType : list) {
            if(keyName.equals(certType.getCerttypeClassification())){

                String sql="and certtypeid = '"+certType.getId()+"' ";
                sql+="and yxzt = '10' ";
                sql+="and isxt = '1' ";


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
                        String fzjgids = departIdsByUsername.stream()
                                .map(s -> "\'" + s + "\'")
                                .collect(Collectors.joining(", "));
                        sql += " and fzjgid in(" + fzjgids + ")";                    }
                }
                String sql1="";
                sql1=sql;

                int count =(int) iCertInfoService.countselectAll(sql1,sql) ;

                ZsmlVo tree = new ZsmlVo();
                tree.setKey(keyName + "#" +certType.getId());
                tree.setValue( certType.getCerttypename());
                tree.setTitle(certType.getCerttypename());
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
      /*  LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
        List<String> roleIdsByUsername = sysBaseApi.getRolesByUsername(sysUser.getUsername());
        System.out.println("1:"+ DateUtils.parseDateToStr("yyyy-MM-DD HH:mm:ss",new Date()));
*/
        //获取当前登录用户
        LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
        //根据登陆用户查询用户部门
        List<String> departIdsByUsername  = sysBaseApi.getDepartIdsByUsername(sysUser.getUsername());
        for (CertType certType : list) {
            if(keyName.equals(certType.getCerttypeClassification())){

                String sql="and certtypeid = '"+certType.getId()+"' ";
                sql+="and yxzt = '10' ";
                sql+="and isxt = '1' ";
              //  sql+="and zt = '3'";

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
                        String fzjgids = departIdsByUsername.stream()
                                .map(s -> "\'" + s + "\'")
                                .collect(Collectors.joining(", "));
                        sql += " and fzjgid in(" + fzjgids + ")";                    }
                }
                String sql1="";
                sql1=sql;

                int count =(int) iCertInfoService.countselectAll(sql1,sql) ;

                ZsmlVo tree = new ZsmlVo();
                tree.setKey(keyName + "#" +certType.getId());
                tree.setValue( certType.getCerttypename());
                tree.setTitle(certType.getCerttypename());
                tree.setQty(count);
                childrenList.add(tree);
                total+=tree.getQty();

            }
        }
        System.out.println("2："+ DateUtils.parseDateToStr("yyyy-MM-DD HH:mm:ss",new Date()));

        parent.setQty(total);
        return childrenList;
    }


}
