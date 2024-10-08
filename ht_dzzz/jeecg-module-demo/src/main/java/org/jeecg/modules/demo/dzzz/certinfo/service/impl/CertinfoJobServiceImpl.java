package org.jeecg.modules.demo.dzzz.certinfo.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.jeecg.common.constant.CommonConstant;
import org.jeecg.common.util.CollectionUtils;
import org.jeecg.common.util.DateUtils;
import org.jeecg.modules.base.service.BaseCommonService;
import org.jeecg.modules.demo.dzzz.certInfoOperation.entity.CertInfoOperationDetail;
import org.jeecg.modules.demo.dzzz.certInfoOperation.entity.CertInfoOperationRecord;
import org.jeecg.modules.demo.dzzz.certInfoOperation.service.ICertInfoOperationDetailService;
import org.jeecg.modules.demo.dzzz.certInfoOperation.service.ICertInfoOperationRecordService;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertInfo;
import org.jeecg.modules.demo.dzzz.certinfo.mapper.CertInfoMapper;
import org.jeecg.modules.demo.dzzz.certinfo.mapper.CertSubTableMapper;
import org.jeecg.modules.demo.dzzz.certinfo.service.*;
import org.jeecg.modules.demo.dzzz.certmatadataversion.service.ICertMetadataVersionService;
import org.jeecg.modules.demo.dzzz.certtype.entity.CertType;
import org.jeecg.modules.demo.dzzz.certtype.mapper.CertTypeMapper;
import org.jeecg.modules.demo.dzzz.certtype.service.ICertTypeService;
import org.jeecg.modules.demo.dzzz.czmx.entity.TYwZsCzjlmxLsN;
import org.jeecg.modules.demo.dzzz.czmx.service.ITYwZsCzjlmxLsNService;
import org.jeecg.modules.demo.dzzz.dept.entity.SDept;
import org.jeecg.modules.demo.dzzz.dept.service.ISDeptService;
import org.jeecg.modules.demo.dzzz.information.entity.Information;
import org.jeecg.modules.demo.dzzz.information.service.IInformationService;
import org.jeecg.modules.demo.dzzz.lszb.service.*;
import org.jeecg.modules.demo.dzzz.spht.entity.GyEntbaseinfoNew;
import org.jeecg.modules.demo.dzzz.spht.service.IGyEntbaseinfoNewService;
import org.jeecg.modules.demo.dzzz.util.CertUtils;
import org.jeecg.modules.demo.dzzz.wgz.entity.ZsYwxxb;
import org.jeecg.modules.demo.dzzz.wgz.service.IZsYwxxbService;
import org.jeecg.modules.demo.spxt.entity.TYwZsCzjlLsN;
import org.jeecg.modules.demo.spxt.entity.TYwZsLsN;
import org.jeecg.modules.demo.spxt.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author huke
 * @date 2024年08月21日 11:22
 */
@Service
public class CertinfoJobServiceImpl extends ServiceImpl<CertInfoMapper, CertInfo> implements ICertinfoJobService {
    @Autowired
    ITYwZsLsNService itYwZsLsNService;
    @Autowired
    ITYwZsCzjlLsNService itYwZsCzjlLsNService;
    @Autowired
    ITJcZsCkomylyZbLsService itJcZsCkomylyZbLsService;
    @Autowired
    ITJcZsMzyphjsypddscpjZbLsService itJcZsMzyphjsypddscpjZbLsService;
    @Autowired
    ITJcZsYlqxcpckxszmZbLsService itJcZsYlqxcpckxszmZbLsService;
    @Autowired
    ITJcZsYlqxlcsybaZbLsService itJcZsYlqxlcsybaZbLsService;
    @Autowired
    ITJcZsYlqxscbaZbLsService itJcZsYlqxscbaZbLsService;
    @Autowired
    ITJcZsYlqxwtscbaZbLsService itJcZsYlqxwtscbaZbLsService;
    @Autowired
    ITJcZsYpckxszmZbLsService itJcZsYpckxszmZbLsService;
    @Autowired
    ITJcZsYpckzxzZbLsService itJcZsYpckzxzZbLsService;
    @Autowired
    ITJcZsYpscxkGmpLsService itJcZsYpscxkGmpLsService;
    @Autowired
    ITJcZsYpscxkStLsService itJcZsYpscxkStLsService;
    @Autowired
    ITJcZsYpscxkWtLsService itJcZsYpscxkWtLsService;
    @Autowired
    ITJcZsYpscxkZcLsService itJcZsYpscxkZcLsService;
    @Autowired
    ICertTypeService iCertTypeService;
    @Autowired
    ICertMetadataVersionService iCertMetadataVersionService;

    @Autowired
    ICertInfoOperationRecordService iCertInfoOperationRecordService;
    @Autowired
    ICertInfoOperationDetailService iCertInfoOperationDetailService;
    @Autowired
    ICertchildCkomylyService iCertchildCkomylyService;
    @Autowired
    ICertchildMzyphjsypddscService iCertchildMzyphjsypddscService;
    @Autowired
    ICertchildYlqxcpckxsService iCertchildYlqxcpckxsService;
    @Autowired
    ICertchildYlqxscbaZbService iCertchildYlqxscbaZbService;
    @Autowired
    ICertchildYpckxkzService iCertchildYpckxkzService;
    @Autowired
    ICertchildYlqxwtbaZbService iCertchildYlqxwtbaZbService;
    @Autowired
    ICertchildYpckxszmService iCertchildYpckxszmService;
    @Autowired
    ICertchildYpscGmpService iCertchildYpscGmpService;
    @Autowired
    ICertchildYpscStService iCertchildYpscStService;
    @Autowired
    ICertchildYpscWtService iCertchildYpscWtService;
    @Autowired
    ICertchildYpscZcService iCertchildYpscZcService;
    @Autowired
    ICertchirdYlqxlcsybaService iCertchirdYlqxlcsybaService;
    @Autowired
    IZsYwxxbService iZsYwxxbService;
    @Autowired
    ICertInfoService iCertInfoService;

    @Autowired
    ICertchildCkomylyHService iCertchildCkomylyHService;
    @Autowired
    ICertchildMzyphjsypddscHService iCertchildMzyphjsypddscHService;
    @Autowired
    ICertchildYlqxcpckxsHService iCertchildYlqxcpckxsHService;
    @Autowired
    ICertchildYlqxscbaZbHService iCertchildYlqxscbaZbHService;
    @Autowired
    ICertchildYpckxkzHService iCertchildYpckxkzHService;
    @Autowired
    ICertchildYlqxwtbaZbHService iCertchildYlqxwtbaZbHService;
    @Autowired
    ICertchildYpckxszmHService iCertchildYpckxszmHService;
    @Autowired
    ICertchildYpscGmpHService iCertchildYpscGmpHService;
    @Autowired
    ICertchildYpscStHService iCertchildYpscStHService;
    @Autowired
    ICertchildYpscWtHService iCertchildYpscWtHService;
    @Autowired
    ICertchildYpscZcHService iCertchildYpscZcHService;
    @Autowired
    ICertchirdYlqxlcsybaHService iCertchirdYlqxlcsybaHService;
    @Autowired
    ISDeptService isDeptService;
    @Autowired
    ITYwZsCzjlmxLsNService itYwZsCzjlmxLsNService;

    @Autowired
    private IInformationService iInformationService;

    @Autowired
    private ICertHandleService certHandleService;

    @Autowired
    private BaseCommonService baseCommonService;

    @Autowired
    private CertSubTableMapper certSubTableMapper;
    @Autowired
    private CertTypeMapper certTypeMapper;
    @Autowired
    private IGyEntbaseinfoNewService gyEntbaseinfoNewService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void xzspToZsxt(String parameter) {
        LambdaQueryWrapper<TYwZsCzjlLsN> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotEmpty(parameter)) {
            queryWrapper.in(TYwZsCzjlLsN::getXzspslh, parameter.split(","));
        } else {
            queryWrapper.eq(TYwZsCzjlLsN::getIssc, '0');
        }
        List<TYwZsCzjlLsN> list = itYwZsCzjlLsNService.list(queryWrapper);
        for (TYwZsCzjlLsN tYwZsCzjlLsN : list) {
            baseCommonService.addLog("同步数据开始》行政审批受理号：" + tYwZsCzjlLsN.getXzspslh(), CommonConstant.LOG_TYPE_2, 5);
            TYwZsLsN tYwZsLsN = null;
            try {
                tYwZsLsN = itYwZsLsNService.getOne(new LambdaQueryWrapper<TYwZsLsN>().eq(TYwZsLsN::getXzspid, tYwZsCzjlLsN.getXzspslh()));
                if (tYwZsCzjlLsN.getYwlx() != 4&&null == tYwZsLsN) {
                    baseCommonService.addLog("同步数据开始》证书数据查询失败：" + tYwZsCzjlLsN.getXzspslh(), CommonConstant.LOG_TYPE_2, 5);
                    continue;
                }
            } catch (Exception e) {
                log.error("同步数据异常》行政审批受理号：" + tYwZsCzjlLsN.getXzspslh(), e);
                baseCommonService.addLog("同步数据异常》行政审批受理号：" + tYwZsCzjlLsN.getXzspslh(), CommonConstant.LOG_TYPE_2, 5);
                continue;
            }
            System.out.println("行政审批受理号:"+tYwZsCzjlLsN.getXzspslh());
            //同步操作记录及明细
            initCzjl(tYwZsCzjlLsN);
            if (tYwZsCzjlLsN.getYwlx() == 4) {
                //注销不推送证书信息
                certHandleService.certInfoZx(tYwZsCzjlLsN.getZsid());
                continue;
            }

            //业务类型，1是核发，2是换发，3是变更，4是注销
            SDept sDept= isDeptService.getDeptByName(tYwZsLsN.getFzjg());
            if (StringUtils.isEmpty(tYwZsLsN.getFzjg()) || sDept == null) {
                //发证机构必须存在
                baseCommonService.addLog("发证机关查询不到：" + tYwZsCzjlLsN.getXzspslh(), CommonConstant.LOG_TYPE_2, 5);
                continue;
            }
            //处理企业信息表
            initQyxx(tYwZsLsN);
            //同步主表
            initZsYwxxb(tYwZsLsN, tYwZsCzjlLsN, sDept);
            //同步子表
            initChirld(tYwZsCzjlLsN, String.valueOf(tYwZsLsN.getZslx()));
            TYwZsLsN finalTYwZsLsN = tYwZsLsN;
            if (Arrays.stream(ZDGZ_ZSLX).anyMatch(item -> item == finalTYwZsLsN.getZslx())) {
                //自动盖章
                String message = certHandleService.batchGzFromWgz(new String[]{tYwZsCzjlLsN.getXzspslh()}, null, "", "", null);
                baseCommonService.addLog(tYwZsLsN.getZsbh() + ":自动盖章情况>>" + message, CommonConstant.LOG_TYPE_2, null);
            }
            //修改临时表标为1
            tYwZsLsN.setIssc(ISSC_HQ);
            itYwZsLsNService.updateById(tYwZsLsN);
        }
        System.out.println(" --- 1111111同步任务调度结束 --- ");
    }

    /**
     * 初始化企业信息
     *
     * @param tYwZsLsN
     * @author huke
     * @date 2024-8-21 15:14
     */
    private void initQyxx(TYwZsLsN tYwZsLsN) {
        LambdaQueryWrapper<Information> infoQw = new LambdaQueryWrapper();
        infoQw.eq(Information::getEntzzjgdm, tYwZsLsN.getShxydm());
        List<Information> informationList = iInformationService.list(infoQw);
        if (informationList == null || informationList.size() == 0) {
            // 从行政审批系统查询企业信息，进行新增
            LambdaQueryWrapper<GyEntbaseinfoNew> spInfo = new LambdaQueryWrapper();
            spInfo.eq(GyEntbaseinfoNew::getEntzzjgdm, tYwZsLsN.getShxydm());
            List<GyEntbaseinfoNew> spInfoList = gyEntbaseinfoNewService.selectList(tYwZsLsN.getShxydm());
            if (CollectionUtils.isNotEmpty(spInfoList)) {
                Information information = new Information();
                GyEntbaseinfoNew gyEntbaseinfo = spInfoList.get(0);
                BeanUtils.copyProperties(gyEntbaseinfo, information);
                information.setCreator("审批同步服务自动新增企业");
                information.setSynctime(DateUtils.formatDateTime());
                iInformationService.save(information);
                return;
            }
            Information information = new Information();
            information.setId(UUID.randomUUID().toString());
            information.setCreator("审批同步服务自动新增企业");
            information.setEntzzjgdm(tYwZsLsN.getShxydm());
            information.setEntname(tYwZsLsN.getQymc());
            information.setSynctime(DateUtils.formatDateTime());
            iInformationService.save(information);
        } else {
            Information information = informationList.get(0);
            information.setEntzzjgdm(tYwZsLsN.getShxydm());
            information.setEntname(tYwZsLsN.getQymc());
            information.setSynctime(DateUtils.formatDateTime());
            iInformationService.updateById(information);
        }
    }

    /**
     * 初始话操作记录及明细表
     *
     * @param tYwZsCzjlLsN
     * @author huke
     * @date 2024-8-21 15:08
     */
    private void initCzjl(TYwZsCzjlLsN tYwZsCzjlLsN) {
        CertInfoOperationRecord certInfoOperationRecord = new CertInfoOperationRecord();
        BeanUtils.copyProperties(tYwZsCzjlLsN, certInfoOperationRecord);
        certInfoOperationRecord.setBgnr(tYwZsCzjlLsN.getBgjl());
        certInfoOperationRecord.setBgyy(tYwZsCzjlLsN.getBzjl());
        certInfoOperationRecord.setStutas("20");
        certInfoOperationRecord.setBglx(String.valueOf(tYwZsCzjlLsN.getYwlx()));
        certInfoOperationRecord.setGzstutas("0");
        iCertInfoOperationRecordService.saveOrUpdate(certInfoOperationRecord);
        QueryWrapper<TYwZsCzjlmxLsN> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("ZSCZJLID", tYwZsCzjlLsN.getId());
        //未同步到yw表中的数据
        List<TYwZsCzjlmxLsN> tYwZsCzjlmxLsNS = itYwZsCzjlmxLsNService.list(queryWrapper);
        for (TYwZsCzjlmxLsN mx : tYwZsCzjlmxLsNS) {
            CertInfoOperationDetail certInfoOperationDetail = new CertInfoOperationDetail();
            certInfoOperationDetail.setId(mx.getId());
            certInfoOperationDetail.setZsid(tYwZsCzjlLsN.getZsid());
            certInfoOperationDetail.setZsczjl(tYwZsCzjlLsN.getId());
            //变更前
            certInfoOperationDetail.setZdlszt(mx.getJz());
            //变更后
            certInfoOperationDetail.setZdxz(mx.getXz());
            //变更字段
            certInfoOperationDetail.setBgzdmc(mx.getZdmc());
            certInfoOperationDetail.setBgzdms(mx.getZdzwmc());
            certInfoOperationDetail.setCzsj(mx.getCzsj());
            certInfoOperationDetail.setBz(mx.getBz());
            iCertInfoOperationDetailService.saveOrUpdate(certInfoOperationDetail);
            //改明细标识为1
            mx.setIssc(ISSC_HQ);
            itYwZsCzjlmxLsNService.updateById(mx);
        }
        //清除操作记录
        tYwZsCzjlLsN.setIssc(ISSC_HQ);
        itYwZsCzjlLsNService.updateById(tYwZsCzjlLsN);
    }

    /**
     * 初始话落地表
     *
     * @param ywzb
     * @param tYwZsCzjlLsN
     * @param dept
     * @return org.jeecg.modules.demo.dzzz.wgz.entity.ZsYwxxb
     * @author huke
     * @date 2024-8-21 15:29
     */
    private void initZsYwxxb(TYwZsLsN ywzb, TYwZsCzjlLsN tYwZsCzjlLsN, SDept dept) {
        /******************************清空待盖章表******************************/
        LambdaQueryWrapper<ZsYwxxb> zsYwxxbLambdaQw = new LambdaQueryWrapper<>();
        zsYwxxbLambdaQw.eq(ZsYwxxb::getZsid, tYwZsCzjlLsN.getZsid());
        iZsYwxxbService.remove(zsYwxxbLambdaQw);
        ZsYwxxb zsYwxxb = new ZsYwxxb();
        BeanUtils.copyProperties(ywzb, zsYwxxb);
        //新逻辑 一条记录对应一条行政审批
        zsYwxxb.setId(tYwZsCzjlLsN.getXzspslh());
        zsYwxxb.setZsid(tYwZsCzjlLsN.getZsid());
        zsYwxxb.setZslx(String.valueOf(ywzb.getZslx()));
        zsYwxxb.setZt(ZSZT_WGZ);//未盖章状态
        zsYwxxb.setYxzt("10");//有效状态
        zsYwxxb.setSynctime(new Date());
        LambdaQueryWrapper<CertType> typeWrapper = new LambdaQueryWrapper<>();
        typeWrapper.eq(CertType::getZslx, ywzb.getZslx());
        List<CertType> certtypelist = iCertTypeService.list(typeWrapper);
        CertType certType = certtypelist.get(0);
        zsYwxxb.setCerttypeid(certType.getId());
        if (ywzb.getFzrq() != null) {
            zsYwxxb.setFzrq(DateUtils.formatDate(ywzb.getFzrq(), "yyyy-MM-dd"));
        }
        if (ywzb.getYxqq() != null) {
            zsYwxxb.setYxqq(DateUtils.formatDate(ywzb.getYxqq(), "yyyy-MM-dd"));
        }
        if (ywzb.getYxqz() != null) {
            zsYwxxb.setYxqz(DateUtils.formatDate(ywzb.getYxqz(), "yyyy-MM-dd"));
        }
        zsYwxxb.setJsly("sp");
        zsYwxxb.setZszt(String.valueOf(tYwZsCzjlLsN.getYwlx()));
        zsYwxxb.setFzjgid(dept.getDeptId());
        iZsYwxxbService.saveOrUpdate(zsYwxxb);
    }

    /**
     * 同步子表
     *
     * @param tYwZsCzjlLsN
     * @param zslx
     * @author huke
     * @date 2024-8-21 15:54
     */
    private void initChirld(TYwZsCzjlLsN tYwZsCzjlLsN, String zslx) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("zsid", tYwZsCzjlLsN.getZsid());
        CertType certType = certTypeMapper.selectOne(new LambdaQueryWrapper<CertType>().eq(CertType::getZslx, zslx).isNotNull(CertType::getZszb));
        if (null != certType) {
            //如果有证书子表
            Arrays.stream(certType.getZszb().split(",")).forEach(item -> {
                //遍历子表
                CertUtils.CertSubTableEnum certSubTableEnum = CertUtils.CertSubTableEnum.byAbbr(item);
                certSubTableMapper.delete(certSubTableEnum.getTableName(), queryWrapper);
                if (zslx.equals("6") || zslx.equals("23")) {
                    //药品生产需要过滤状态
                    queryWrapper.in("zt", new String[]{"1", "3", "7"});
                }
                certSubTableMapper.copyToSave(certSubTableEnum.getTableName("1"), certSubTableEnum.getTableName(), tYwZsCzjlLsN.getXzspslh(), queryWrapper, certSubTableEnum.getColumns());
                certSubTableMapper.delete(certSubTableEnum.getTableName("1"), queryWrapper);

            });
        }


    }

    //未盖章
    private static final String ZSZT_WGZ = "3";
    //数据获取后的值
    private static final String ISSC_HQ = "1";
    //自动盖章证书类型
    private static final int[] ZDGZ_ZSLX = new int[]{27, 30, 28, 64, 46,33};


}
