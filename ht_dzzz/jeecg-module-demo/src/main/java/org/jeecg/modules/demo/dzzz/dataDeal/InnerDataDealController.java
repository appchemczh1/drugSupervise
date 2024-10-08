package org.jeecg.modules.demo.dzzz.dataDeal;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.jeecg.common.constant.CommonConstant;
import org.jeecg.common.util.RedisUtil;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertInfo;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildYlqxwlxsba;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertInfoService;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertchildYlqxwlxsbaService;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertinfoJobService;
import org.jeecg.modules.demo.dzzz.constant.YwConstant;
import org.jeecg.modules.demo.dzzz.dataExchange.service.ITYwSjXybService;
import org.jeecg.modules.demo.dzzz.dataExchange.util.YwUtil;
import org.jeecg.modules.demo.dzzz.information.entity.Information;
import org.jeecg.modules.demo.dzzz.information.service.IInformationService;
import org.jeecg.modules.demo.dzzz.util.BeanUtils;
import org.jeecg.modules.demo.dzzz.whsjZb.entity.BaQxwlxsbaZbZs;
import org.jeecg.modules.demo.dzzz.whsjZb.service.IBaQxwlxsbaZbZsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Api(tags="提供给内部的接口")
@RestController
@RequestMapping("/innerJk")
@Slf4j
public class InnerDataDealController {

    @Autowired
    private ITYwSjXybService tYwSjXybService;
    @Autowired
    private IInformationService informationService;
    @Autowired
    private ICertInfoService certInfoService;
    @Autowired
    private IBaQxwlxsbaZbZsService baQxwlxsbaZbZsService;
    @Autowired
    private ICertchildYlqxwlxsbaService certchildYlqxwlxsbaService;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private ICertinfoJobService certinfoJobService;

    @ApiOperation(value="信用办数据推送", notes="信用办数据推送")
    @PostMapping(value = "/xybDataPush")
    public String xybDataPush(String[] ids) {
        if (null == ids || ids.length == 0) {
            return "主键ID不能为空";
        }
        List<String> idList = Arrays.asList(ids);
        LambdaQueryWrapper<CertInfo> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.in(CertInfo :: getId, idList);
        List<CertInfo> list = certInfoService.list(queryWrapper);
        for (CertInfo certInfo : list) {
            tYwSjXybService.saveXyb(null, certInfo);
        }
        return "成功";
    }

    @ApiOperation(value="信用办数据推送", notes="信用办数据推送")
    @PostMapping(value = "/xybDataPushHis")
    public String xybDataPushHis() {
        List<CertInfo> list = certInfoService.xybData();
        for (CertInfo certInfo : list) {
            tYwSjXybService.saveXyb(null, certInfo);
        }
        return "成功";
    }

    @ApiOperation(value="信用办数据推送-发证日期", notes="信用办数据推送-发证日期")
    @PostMapping(value = "/xybDataPushFzrq")
    public String xybDataPushFzrq() {
        List<String> certTypeIds = Arrays.asList("4e7ff714f0cf4f81b46eb16c1155744f", "d2dd9f71f5f34145af595fd79504e683",
                "4957bebb1de340cc90502265a456d303", "5102457a62a04aee8c93ea0873c8a39e");
        LambdaQueryWrapper<CertInfo> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.notIn(CertInfo :: getCerttypeid, certTypeIds);
        queryWrapper.ge(CertInfo :: getFzrq, YwUtil.getDateStrByDay(-11, ""));
        List<CertInfo> list = certInfoService.list(queryWrapper);
        for (CertInfo certInfo : list) {
            // tYwSjXybService.saveXyb(null, certInfo);
        }
        return "成功";
    }

    @ApiOperation(value="处理过期证照", notes="处理过期证照")
    @GetMapping(value = "/dealCertExpireData")
    public String dealCertExpireData() {
        certInfoService.dealCertExpire();
        return "成功";
    }

    @ApiOperation(value="清除指定用户登录限制", notes="清除指定用户登录限制")
    @GetMapping(value = "/delLoginFail")
    public String delLoginFail(@RequestParam String username) {
        redisUtil.del(CommonConstant.LOGIN_FAIL + username);
        return "删除成功";
    }

    @ApiOperation(value="处理武汉市局-64-证书无子表", notes="处理武汉市局-64-证书无子表")
    @GetMapping(value = "/dealWhsjData")
    public String dealWhsjData() {
        LambdaQueryWrapper<CertInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CertInfo :: getJsly, "WHSJ");
        queryWrapper.eq(CertInfo :: getZslx, "64");
        queryWrapper.eq(CertInfo :: getYxzt, "10");
        queryWrapper.eq(CertInfo :: getZt, "4");
        queryWrapper.likeRight(CertInfo :: getGztime, "2024-08-30");
        List<CertInfo> certList = certInfoService.list(queryWrapper);

        if (CollectionUtils.isEmpty(certList)) {
            return "数据为空";
        }

//        List<String> zsidList = certList.stream().map(CertInfo::getZsid).collect(Collectors.toList());
        for (CertInfo cert : certList) {
            String zsid = cert.getZsid();
            String id = cert.getId();
            String zsbh = cert.getZsbh();
            List<BaQxwlxsbaZbZs> zbList = baQxwlxsbaZbZsService.list(new LambdaQueryWrapper<BaQxwlxsbaZbZs>().eq(BaQxwlxsbaZbZs::getZsid, zsid));
            log.info("新子表不为空，不需要做插入操作。zsbh：｛｝， zsid：{}, id：{}", zsbh, zsid, id);

            if (CollectionUtils.isEmpty(zbList)) {
                List<CertchildYlqxwlxsba> oldZbList = certchildYlqxwlxsbaService.selectByMainId(zsid, id);
                if (CollectionUtils.isEmpty(oldZbList)) {
                    log.info("原子表为空，也不需要做插入操作。zsbh：｛｝， zsid：{}, id：{}", zsbh, zsid, id);
                }
                log.info("原子表不为空，后续插入。长度为：{}。zsbh：｛｝，zsid：{}, id：{}", oldZbList.size(), zsbh, zsid, id);
                List<BaQxwlxsbaZbZs> newZbList = new ArrayList<>();
                // 将原子表的数据，copy到新子表
                for (CertchildYlqxwlxsba oldZb : oldZbList) {
                    BaQxwlxsbaZbZs newZb = new BaQxwlxsbaZbZs();
                    BeanUtils.copyProperties(oldZb, newZb);

                    newZbList.add(newZb);
                }
                baQxwlxsbaZbZsService.saveBatch(newZbList);
                log.info("保存成功，长度为：{}。zsbh：｛｝，zsid：{}, id：{}", newZbList.size(), zsbh, zsid, id);
            }
        }
        return "成功";
    }

    @ApiOperation(value="处理电子证照唯一标识为空的记录", notes="处理电子证照唯一标识为空的记录")
    @GetMapping(value = "/dealDzzzOldIdIsNUll")
    public String dealDzzzOldIdIsNUll() {
        long start = System.currentTimeMillis();
        LambdaQueryWrapper<CertInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.ne(CertInfo :: getYxzt, YwConstant.ZSZT_ZF);
        queryWrapper.isNull(CertInfo :: getOldId);
        queryWrapper.eq(CertInfo::getZsbh, "鄂仙桃食药监械出20240044");
        List<CertInfo> certList = certInfoService.list(queryWrapper);
        if (CollectionUtils.isEmpty(certList)) {
            return "暂无数据处理";
        }

        List<CertInfo> updCertList = new ArrayList<>();
        for (CertInfo certInfo : certList) {
            String electronicLicense = certInfoService.generateElectronicLicense(certInfo.getCerttypeid(), certInfo.getFzjgid(), null);

            CertInfo updCert = new CertInfo();
            updCert.setId(certInfo.getId());
            updCert.setOldId(electronicLicense);
            updCert.setUpdateTime(new Date());
            updCertList.add(updCert);
        }
        // certInfoService.updateBatchById(updCertList);

        long end = System.currentTimeMillis();
        log.info("处理电子证照唯一标识为空的记录，总条数：{}，总耗时：{}", updCertList.size(), (end - start));
        return "成功" + certList.size();
    }

    @ApiOperation(value="处理已盖章表企业ID为空的记录", notes="处理已盖章表企业ID为空的记录")
    @GetMapping(value = "/dealQyIdIsNull")
    public String dealQyIdIsNull() {
        LambdaQueryWrapper<CertInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.ne(CertInfo :: getYxzt, YwConstant.ZSZT_ZF);
        queryWrapper.isNull(CertInfo::getQyid);
        List<CertInfo> certList = certInfoService.list(queryWrapper);

        List<CertInfo> updCertList = new ArrayList<>();
        for (CertInfo certInfo : certList) {
            LambdaQueryWrapper<Information> queryQy = new LambdaQueryWrapper<>();
            queryQy.eq(Information :: getEntzzjgdm, certInfo.getShxydm());
            Information info = informationService.getOne(queryQy);
            if (null != info && StringUtils.isNotBlank(info.getId())) {
                CertInfo updCert = new CertInfo();
                updCert.setId(certInfo.getId());
                updCert.setQyid(info.getId());
                updCertList.add(updCert);
            }
        }
        certInfoService.updateBatchById(updCertList);
        return "成功，批量处理数量为：" + updCertList.size();
    }


    @ApiOperation(value="手动同步行政审批数据", notes="手动同步行政审批数据")
    @GetMapping(value = "/manualSyncXzspData")
    public String manualSyncXzspData(String xzspslh) {
        certinfoJobService.xzspToZsxt(xzspslh);
        return "同步成功";
    }

}
