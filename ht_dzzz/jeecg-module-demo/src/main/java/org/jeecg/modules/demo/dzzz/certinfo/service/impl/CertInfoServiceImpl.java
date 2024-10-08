package org.jeecg.modules.demo.dzzz.certinfo.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import io.swagger.annotations.ApiModelProperty;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.jeecg.modules.demo.dzzz.attachinfo.entity.Attachinfo;
import org.jeecg.modules.demo.dzzz.attachinfo.service.IAttachinfoService;
import org.jeecg.modules.demo.dzzz.certInfoOperation.entity.CertInfoOperationDetail;
import org.jeecg.modules.demo.dzzz.certInfoOperation.entity.CertInfoOperationRecord;
import org.jeecg.modules.demo.dzzz.certInfoOperation.service.ICertInfoOperationDetailService;
import org.jeecg.modules.demo.dzzz.certInfoOperation.service.ICertInfoOperationRecordService;
import org.jeecg.modules.demo.dzzz.certWarning.dto.WgzWarnReqDto;
import org.jeecg.modules.demo.dzzz.certWarning.dto.WgzWarnResDto;
import org.jeecg.modules.demo.dzzz.certWarning.dto.YxqWarnReqDto;
import org.jeecg.modules.demo.dzzz.certWarning.dto.YxqWarnResDto;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertInfo;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildCkomyly;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildDylylqxscbapz;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildMzyphjsypddsc;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildYlqxcpckxs;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildYlqxscbaZb;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildYlqxwlxsba;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildYlqxwtbaZb;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildYpckxkz;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildYpckxszm;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildYpscSt;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildYpscWt;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildYpscZc;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchirdYlqxlcsyba;
import org.jeecg.modules.demo.dzzz.certinfo.entity.ResultBean;
import org.jeecg.modules.demo.dzzz.certinfo.mapper.CertInfoMapper;
import org.jeecg.modules.demo.dzzz.certinfo.mapper.CertchildCkomylyMapper;
import org.jeecg.modules.demo.dzzz.certinfo.mapper.CertchildDylylqxscbapzMapper;
import org.jeecg.modules.demo.dzzz.certinfo.mapper.CertchildMzyphjsypddscMapper;
import org.jeecg.modules.demo.dzzz.certinfo.mapper.CertchildYlqxcpckxsMapper;
import org.jeecg.modules.demo.dzzz.certinfo.mapper.CertchildYlqxscbaZbMapper;
import org.jeecg.modules.demo.dzzz.certinfo.mapper.CertchildYlqxwlxsbaMapper;
import org.jeecg.modules.demo.dzzz.certinfo.mapper.CertchildYlqxwtbaZbMapper;
import org.jeecg.modules.demo.dzzz.certinfo.mapper.CertchildYpckxkzMapper;
import org.jeecg.modules.demo.dzzz.certinfo.mapper.CertchildYpckxszmMapper;
import org.jeecg.modules.demo.dzzz.certinfo.mapper.CertchildYpscGmpMapper;
import org.jeecg.modules.demo.dzzz.certinfo.mapper.CertchildYpscStMapper;
import org.jeecg.modules.demo.dzzz.certinfo.mapper.CertchildYpscWtMapper;
import org.jeecg.modules.demo.dzzz.certinfo.mapper.CertchildYpscZcMapper;
import org.jeecg.modules.demo.dzzz.certinfo.mapper.CertchirdYlqxlcsybaMapper;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertInfoService;
import org.jeecg.modules.demo.dzzz.certinfo.vo.CertInfoPage;
import org.jeecg.modules.demo.dzzz.certmatadataversion.entity.CertMetadata;
import org.jeecg.modules.demo.dzzz.certmatadataversion.entity.CertMetadataVersion;
import org.jeecg.modules.demo.dzzz.certmatadataversion.service.ICertMetadataService;
import org.jeecg.modules.demo.dzzz.certmatadataversion.service.ICertMetadataVersionService;
import org.jeecg.modules.demo.dzzz.certmode.entity.CertMode;
import org.jeecg.modules.demo.dzzz.certmode.service.ICertModeService;
import org.jeecg.modules.demo.dzzz.certtype.entity.CertType;
import org.jeecg.modules.demo.dzzz.certtype.service.ICertTypeService;
import org.jeecg.modules.demo.dzzz.certtyperole.entity.CerttypeRole;
import org.jeecg.modules.demo.dzzz.certzminfo.entity.CertZminfo;
import org.jeecg.modules.demo.dzzz.constant.YwConstant;
import org.jeecg.modules.demo.dzzz.dataExchange.util.YwUtil;
import org.jeecg.modules.demo.dzzz.dept.entity.SDept;
import org.jeecg.modules.demo.dzzz.dept.service.ISDeptService;
import org.jeecg.modules.demo.dzzz.enums.YwlxEnum;
import org.jeecg.modules.demo.dzzz.sczz.ZsDto;
import org.jeecg.modules.demo.dzzz.spht.service.IBaQxwlxsbaZbLs2Service;
import org.jeecg.modules.demo.dzzz.spht.service.ITJcZsCkomylyZbLs2Service;
import org.jeecg.modules.demo.dzzz.spht.service.ITJcZsDylylqxscbapzZbLs2Service;
import org.jeecg.modules.demo.dzzz.spht.service.ITJcZsMzyphjsypddscpjZbLs2Service;
import org.jeecg.modules.demo.dzzz.spht.service.ITJcZsYlqxcpckxszmZbLs2Service;
import org.jeecg.modules.demo.dzzz.spht.service.ITJcZsYlqxlcsybaZbLs2Service;
import org.jeecg.modules.demo.dzzz.spht.service.ITJcZsYlqxscbaZbLs2Service;
import org.jeecg.modules.demo.dzzz.spht.service.ITJcZsYlqxwtscbaZbLs2Service;
import org.jeecg.modules.demo.dzzz.spht.service.ITJcZsYpckxszmZbLs2Service;
import org.jeecg.modules.demo.dzzz.spht.service.ITJcZsYpckzxzZbLs2Service;
import org.jeecg.modules.demo.dzzz.spht.service.ITJcZsYpscxkGmpLs2Service;
import org.jeecg.modules.demo.dzzz.spht.service.ITJcZsYpscxkStLs2Service;
import org.jeecg.modules.demo.dzzz.spht.service.ITJcZsYpscxkWtLs2Service;
import org.jeecg.modules.demo.dzzz.spht.service.ITJcZsYpscxkZcLs2Service;
import org.jeecg.modules.demo.dzzz.spht.service.ITYwZsNService;
import org.jeecg.modules.demo.dzzz.util.*;
import org.jeecg.modules.demo.dzzz.wgz.entity.ZsYwxxb;
import org.jeecg.modules.demo.dzzz.wgz.mapper.ZsYwxxbMapper;
import org.jeecg.modules.demo.dzzz.wgz.service.IZsYwxxbService;
import org.jeecg.modules.demo.spxt.service.ITYwZsLsNService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 电子证照源数据
 * @Author: jeecg-boot
 * @Date: 2024-03-27
 * @Version: V1.0
 */
@Service
@Slf4j
public class CertInfoServiceImpl extends ServiceImpl<CertInfoMapper, CertInfo> implements ICertInfoService {
    private static final Logger logger = LoggerFactory.getLogger(CertInfoServiceImpl.class);
    @Autowired
    ICertMetadataService iCertMetadataService;
    @Autowired
    private CertInfoMapper certInfoMapper;
    @Autowired
    private ICertTypeService iCertTypeService;
    @Autowired
    private CertchildYpscZcMapper certchildYpscZcMapper;
    @Autowired
    private CertchildYpscWtMapper certchildYpscWtMapper;
    @Autowired
    private CertchildYpscStMapper certchildYpscStMapper;
    @Autowired
    ICertMetadataVersionService iCertMetadataVersionService;
    @Autowired
    IAttachinfoService iAttachinfoService;
    @Autowired
    IZsYwxxbService iZsYwxxbService;
    @Autowired
    ICertModeService iCertModeService;
    @Autowired
    ZsYwxxbMapper zsYwxxbMapper;
    @Autowired
     ITYwZsNService itYwZsNService;
    @Autowired
    IBaQxwlxsbaZbLs2Service iBaQxwlxsbaZbLs2Service;
    @Autowired
    ITJcZsCkomylyZbLs2Service itJcZsCkomylyZbLs2Service;
    @Autowired
    ITJcZsDylylqxscbapzZbLs2Service itJcZsDylylqxscbapzZbLs2Service;
    @Autowired
    ITJcZsMzyphjsypddscpjZbLs2Service itJcZsMzyphjsypddscpjZbLs2Service;
    @Autowired
    ITJcZsYlqxcpckxszmZbLs2Service itJcZsYlqxcpckxszmZbLs2Service;
    @Autowired
    ITJcZsYlqxlcsybaZbLs2Service itJcZsYlqxlcsybaZbLs2Service;
    @Autowired
    ITJcZsYlqxscbaZbLs2Service itJcZsYlqxscbaZbLs2Service;
    @Autowired
    ITJcZsYlqxwtscbaZbLs2Service itJcZsYlqxwtscbaZbLs2Service;
    @Autowired
    ITJcZsYpckxszmZbLs2Service itJcZsYpckxszmZbLs2Service;
    @Autowired
    ITJcZsYpckzxzZbLs2Service itJcZsYpckzxzZbLs2Service;
    @Autowired
    ITJcZsYpscxkGmpLs2Service itJcZsYpscxkGmpLs2Service;
    @Autowired
    ITJcZsYpscxkStLs2Service itJcZsYpscxkStLs2Service;
    @Autowired
    ITJcZsYpscxkWtLs2Service itJcZsYpscxkWtLs2Service;
    @Autowired
    ITJcZsYpscxkZcLs2Service itJcZsYpscxkZcLs2Service;

    @Autowired
    ITYwZsLsNService itYwZsLsNService;
    @Autowired
    ICertInfoOperationRecordService certInfoOperationRecordService;
    @Autowired
    ICertInfoOperationDetailService certInfoOperationDetailService;
    @Autowired
    private CertchildYlqxwlxsbaMapper certchildYlqxwlxsbaMapper;
    @Autowired
    private CertchildDylylqxscbapzMapper certchildDylylqxscbapzMapper;

    @Autowired
    CertchildCkomylyMapper certchildCkomylyMapper;
    @Autowired
    CertchildMzyphjsypddscMapper certchildMzyphjsypddscMapper;
    @Autowired
    CertchildYlqxcpckxsMapper certchildYlqxcpckxsMapper;
    @Autowired
    CertchildYlqxscbaZbMapper certchildYlqxscbaZbMapper;
    @Autowired
    CertchildYlqxwtbaZbMapper certchildYlqxwtbaZbMapper;
    @Autowired
    CertchirdYlqxlcsybaMapper certchirdYlqxlcsybaMapper;
    @Autowired
    CertchildYpckxkzMapper certchildYpckxkzMapper;
    @Autowired
    CertchildYpckxszmMapper certchildYpckxszmMapper;
    @Autowired
    CertchildYpscGmpMapper certchildYpscGmpMapper;
    @Autowired

    @Value(value = "${jeecg.path.upload}")
    private String uploadpath;

    /**
     * 二维码服务地址
     */
    @Value("${qrcode.serverUrl}")
    private String serverUrl;

    @Autowired
    private ISDeptService deptService;
    @Autowired
    private ICertTypeService certTypeService;

//    /**
//     * 二维码地址
//     * @param licenseId
//     * @return
//     */
//    public String getQrCodeValue(String licenseId) {
//        if (org.apache.commons.lang.StringUtils.isBlank(licenseId)) {
//            throw new BaseException(String.format("生成二维码地址失败：licenseId=%s", licenseId));
//        }
//        return String.format(serverUrl, licenseId);
//    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveMain(CertInfo certInfo, List<CertchildYpscZc> certchildYpscZcList, List<CertchildYpscWt> certchildYpscWtList, List<CertchildYpscSt> certchildYpscStList,
                         List<CertchildCkomyly> certchildCkomylies, List<CertchildMzyphjsypddsc> certchildMzyphjsypddscs, List<CertchildYlqxcpckxs> certchildYlqxcpckxs,
                         List<CertchildYlqxscbaZb> certchildYlqxscbaZbs, List<CertchildYlqxwtbaZb> certchildYlqxwlxsbaList, List<CertchildYpckxkz> certchildYpckxkzs,
                         List<CertchildYpckxszm> certchildYpckxszms, List<CertchildDylylqxscbapz> certchildDylylqxscbapzList,
                         List<CertchildYlqxwlxsba> certchildYlqxwlxsbas, List<CertchirdYlqxlcsyba> certchirdYlqxlcsybas
    ) {
        certInfoMapper.insert(certInfo);
        if (certchildYpscZcList != null && certchildYpscZcList.size() > 0) {
            for (CertchildYpscZc entity : certchildYpscZcList) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setZt("4");
                entity.setXzspid(certInfo.getId());
                entity.setCreateBy("已盖章");
                certchildYpscZcMapper.insert(entity);
            }
        }
        if (certchildYpscWtList != null && certchildYpscWtList.size() > 0) {
            for (CertchildYpscWt entity : certchildYpscWtList) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                                entity.setCreateBy("已盖章维护");

                entity.setZt("4");
                entity.setCreateBy("已盖章");
                entity.setXzspid(certInfo.getId());
                certchildYpscWtMapper.insert(entity);

            }
        }
        if (certchildYpscStList != null && certchildYpscStList.size() > 0) {
            for (CertchildYpscSt entity : certchildYpscStList) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setCreateBy("已盖章");
                entity.setZt("4");
                entity.setXzspid(certInfo.getId());
                certchildYpscStMapper.insert(entity);
            }
        }
        if (certchildYlqxwlxsbas != null && certchildYlqxwlxsbas.size() > 0) {
            for (CertchildYlqxwlxsba entity : certchildYlqxwlxsbas) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setSync("已盖章");
                entity.setZt("4");
                entity.setXzspid(certInfo.getId());
                certchildYlqxwlxsbaMapper.insert(entity);
            }
        }
        if (certchildYlqxscbaZbs != null && certchildYlqxscbaZbs.size() > 0) {
            for (CertchildYlqxscbaZb entity : certchildYlqxscbaZbs) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setCreateBy("已盖章");
                entity.setZt("4");
                entity.setXzspid(certInfo.getId());
                certchildYlqxscbaZbMapper.insert(entity);
            }
        }
        if (certchildCkomylies != null && certchildCkomylies.size() > 0) {
            for (CertchildCkomyly entity : certchildCkomylies) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setCreateBy("已盖章");
                entity.setZt("4");
                entity.setXzspid(certInfo.getId());
                certchildCkomylyMapper.insert(entity);
            }
        }
        if (certchildMzyphjsypddscs != null && certchildMzyphjsypddscs.size() > 0) {
            for (CertchildMzyphjsypddsc entity : certchildMzyphjsypddscs) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setCreateBy("已盖章");
                entity.setZt("4");
                entity.setXzspid(certInfo.getId());
                certchildMzyphjsypddscMapper.insert(entity);
            }
        }
        if (certchildYlqxcpckxs != null && certchildYlqxcpckxs.size() > 0) {
            for (CertchildYlqxcpckxs entity : certchildYlqxcpckxs) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setCreateBy("已盖章");
                entity.setZt("4");
                entity.setXzspid(certInfo.getId());
                certchildYlqxcpckxsMapper.insert(entity);
            }
        }
        if (certchildYlqxwlxsbaList != null && certchildYlqxwlxsbaList.size() > 0) {
            for (CertchildYlqxwtbaZb entity : certchildYlqxwlxsbaList) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setCreateBy("已盖章");
                entity.setZt("4");
                entity.setXzspid(certInfo.getId());
                certchildYlqxwtbaZbMapper.insert(entity);
            }
        }
        if (certchildYpckxkzs != null && certchildYpckxkzs.size() > 0) {
            for (CertchildYpckxkz entity : certchildYpckxkzs) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setCreateBy("已盖章");
                entity.setZt("4");
                entity.setXzspid(certInfo.getId());
                certchildYpckxkzMapper.insert(entity);
            }
        }
        if (certchildYpckxszms != null && certchildYpckxszms.size() > 0) {
            for (CertchildYpckxszm entity : certchildYpckxszms) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setCreateBy("已盖章");
                entity.setZt("4");
                entity.setXzspid(certInfo.getId());
                certchildYpckxszmMapper.insert(entity);
            }
        }
        if (certchildDylylqxscbapzList != null && certchildDylylqxscbapzList.size() > 0) {
            for (CertchildDylylqxscbapz entity : certchildDylylqxscbapzList) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setSync("已盖章");
                entity.setZt(BigDecimal.valueOf(4));
                entity.setXzspid(certInfo.getId());
                certchildDylylqxscbapzMapper.insert(entity);
            }
        }
        if (certchirdYlqxlcsybas != null && certchirdYlqxlcsybas.size() > 0) {
            for (CertchirdYlqxlcsyba entity : certchirdYlqxlcsybas) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setCreateBy("已盖章");
                entity.setZt("4");
                entity.setXzspid(certInfo.getId());
                certchirdYlqxlcsybaMapper.insert(entity);
            }
        }
    }

    public void saveMainwh(CertInfo certInfo, List<CertchildYpscZc> certchildYpscZcList, List<CertchildYpscWt> certchildYpscWtList, List<CertchildYpscSt> certchildYpscStList,
                         List<CertchildCkomyly> certchildCkomylies, List<CertchildMzyphjsypddsc> certchildMzyphjsypddscs, List<CertchildYlqxcpckxs> certchildYlqxcpckxs,
                         List<CertchildYlqxscbaZb> certchildYlqxscbaZbs, List<CertchildYlqxwtbaZb> certchildYlqxwlxsbaList, List<CertchildYpckxkz> certchildYpckxkzs,
                         List<CertchildYpckxszm> certchildYpckxszms, List<CertchildDylylqxscbapz> certchildDylylqxscbapzList,
                         List<CertchildYlqxwlxsba> certchildYlqxwlxsbas, List<CertchirdYlqxlcsyba> certchirdYlqxlcsybas
    ) {
        certInfoMapper.insert(certInfo);
        if (certchildYpscZcList != null && certchildYpscZcList.size() > 0) {
            for (CertchildYpscZc entity : certchildYpscZcList) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setCreateBy("已盖章维护");
                entity.setZt("4");
                entity.setXzspid(certInfo.getId());
                certchildYpscZcMapper.insert(entity);
            }
        }
        if (certchildYpscWtList != null && certchildYpscWtList.size() > 0) {
            for (CertchildYpscWt entity : certchildYpscWtList) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                                entity.setCreateBy("已盖章维护");

                entity.setZt("4");
                entity.setXzspid(certInfo.getId());
                certchildYpscWtMapper.insert(entity);
            }
        }
        if (certchildYpscStList != null && certchildYpscStList.size() > 0) {
            for (CertchildYpscSt entity : certchildYpscStList) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                                entity.setCreateBy("已盖章维护");

                entity.setZt("4");
                entity.setXzspid(certInfo.getId());
                certchildYpscStMapper.insert(entity);
            }
        }
        if (certchildYlqxwlxsbas != null && certchildYlqxwlxsbas.size() > 0) {
            for (CertchildYlqxwlxsba entity : certchildYlqxwlxsbas) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                                entity.setSync("已盖章维护");

                entity.setZt("4");
                entity.setXzspid(certInfo.getId());
                certchildYlqxwlxsbaMapper.insert(entity);
            }
        }
        if (certchildYlqxscbaZbs != null && certchildYlqxscbaZbs.size() > 0) {
            for (CertchildYlqxscbaZb entity : certchildYlqxscbaZbs) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                                entity.setCreateBy("已盖章维护");

                entity.setZt("4");
                entity.setXzspid(certInfo.getId());
                certchildYlqxscbaZbMapper.insert(entity);
            }
        }
        if (certchildCkomylies != null && certchildCkomylies.size() > 0) {
            for (CertchildCkomyly entity : certchildCkomylies) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                                entity.setCreateBy("已盖章维护");

                entity.setZt("4");
                entity.setXzspid(certInfo.getId());
                certchildCkomylyMapper.insert(entity);
            }
        }
        if (certchildMzyphjsypddscs != null && certchildMzyphjsypddscs.size() > 0) {
            for (CertchildMzyphjsypddsc entity : certchildMzyphjsypddscs) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                                entity.setCreateBy("已盖章维护");

                entity.setZt("4");
                entity.setXzspid(certInfo.getId());
                certchildMzyphjsypddscMapper.insert(entity);
            }
        }
        if (certchildYlqxcpckxs != null && certchildYlqxcpckxs.size() > 0) {
            for (CertchildYlqxcpckxs entity : certchildYlqxcpckxs) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                                entity.setCreateBy("已盖章维护");

                entity.setZt("4");
                entity.setXzspid(certInfo.getId());
                certchildYlqxcpckxsMapper.insert(entity);
            }
        }
        if (certchildYlqxwlxsbaList != null && certchildYlqxwlxsbaList.size() > 0) {
            for (CertchildYlqxwtbaZb entity : certchildYlqxwlxsbaList) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                                entity.setCreateBy("已盖章维护");

                entity.setZt("4");
                entity.setXzspid(certInfo.getId());
                certchildYlqxwtbaZbMapper.insert(entity);
            }
        }
        if (certchildYpckxkzs != null && certchildYpckxkzs.size() > 0) {
            for (CertchildYpckxkz entity : certchildYpckxkzs) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                                entity.setCreateBy("已盖章维护");

                entity.setZt("4");
                entity.setXzspid(certInfo.getId());
                certchildYpckxkzMapper.insert(entity);
            }
        }
        if (certchildYpckxszms != null && certchildYpckxszms.size() > 0) {
            for (CertchildYpckxszm entity : certchildYpckxszms) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                                entity.setCreateBy("已盖章维护");

                entity.setZt("4");
                entity.setXzspid(certInfo.getId());
                certchildYpckxszmMapper.insert(entity);
            }
        }
        if (certchildDylylqxscbapzList != null && certchildDylylqxscbapzList.size() > 0) {
            for (CertchildDylylqxscbapz entity : certchildDylylqxscbapzList) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                                entity.setSync("已盖章维护");

                entity.setZt(BigDecimal.valueOf(4));
                entity.setXzspid(certInfo.getId());
                certchildDylylqxscbapzMapper.insert(entity);
            }
        }
        if (certchirdYlqxlcsybas != null && certchirdYlqxlcsybas.size() > 0) {
            for (CertchirdYlqxlcsyba entity : certchirdYlqxlcsybas) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                                entity.setCreateBy("已盖章维护");

                entity.setZt("4");
                entity.setXzspid(certInfo.getId());
                certchirdYlqxlcsybaMapper.insert(entity);
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateMain(CertInfo certInfo, List<CertchildYpscZc> certchildYpscZcList, List<CertchildYpscWt> certchildYpscWtList, List<CertchildYpscSt> certchildYpscStList,
                           List<CertchildCkomyly> certchildCkomylies, List<CertchildMzyphjsypddsc> certchildMzyphjsypddscs, List<CertchildYlqxcpckxs> certchildYlqxcpckxs,
                           List<CertchildYlqxscbaZb> certchildYlqxscbaZbs, List<CertchildYlqxwtbaZb> certchildYlqxwlxsbaList, List<CertchildYpckxkz> certchildYpckxkzs,
                           List<CertchildYpckxszm> certchildYpckxszms, List<CertchildDylylqxscbapz> certchildDylylqxscbapzList,
                           List<CertchildYlqxwlxsba> certchildYlqxwlxsbas, List<CertchirdYlqxlcsyba> certchirdYlqxlcsybas) {
        certInfoMapper.updateById(certInfo);
        //1.先删除子表数据
        certchildYpscZcMapper.deleteByMainId(certInfo.getZsid(),certInfo.getId(),"4");
        certchildYpscWtMapper.deleteByMainId(certInfo.getZsid(),certInfo.getId(),"4");
        certchildYpscStMapper.deleteByMainId(certInfo.getZsid(),certInfo.getId(),"4");
        certchildCkomylyMapper.deleteByMainId(certInfo.getZsid(),certInfo.getId(),"4");
        certchildMzyphjsypddscMapper.deleteByMainId(certInfo.getZsid(),certInfo.getId(),"4");
        certchildYlqxcpckxsMapper.deleteByMainId(certInfo.getZsid(),certInfo.getId(),"4");
        certchildYlqxscbaZbMapper.deleteByMainId(certInfo.getZsid(),certInfo.getId(),"4");
        certchildYlqxwtbaZbMapper.deleteByMainId(certInfo.getZsid(),certInfo.getId(),"4");
        certchildYlqxwlxsbaMapper.deleteByMainId(certInfo.getZsid(),certInfo.getId(),"4");
        certchirdYlqxlcsybaMapper.deleteByMainId(certInfo.getZsid(),certInfo.getId(),"4");
        certchildYpckxkzMapper.deleteByMainId(certInfo.getZsid(),certInfo.getId(),"4");
        certchildYpckxszmMapper.deleteByMainId(certInfo.getZsid(),certInfo.getId(),"4");
        certchildDylylqxscbapzMapper.deleteByMainId(certInfo.getZsid(),certInfo.getId(),"4");
        //2.子表数据重新插入
        if (certchildYpscZcList != null && certchildYpscZcList.size() > 0) {
            for (CertchildYpscZc entity : certchildYpscZcList) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setZt("4");
                entity.setXzspid(certInfo.getId());
                entity.setCreateBy("已盖章变更");
                certchildYpscZcMapper.insert(entity);
            }
        }
        if (certchildYpscWtList != null && certchildYpscWtList.size() > 0) {
            for (CertchildYpscWt entity : certchildYpscWtList) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setZt("4");
                entity.setXzspid(certInfo.getId());
                entity.setCreateBy("已盖章变更");
                certchildYpscWtMapper.insert(entity);
            }
        }
        if (certchildYpscStList != null && certchildYpscStList.size() > 0) {
            for (CertchildYpscSt entity : certchildYpscStList) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setZt("4");
                entity.setXzspid(certInfo.getId());
                entity.setCreateBy("已盖章变更");
                certchildYpscStMapper.insert(entity);
            }
        }
        if (certchildYlqxwlxsbas != null && certchildYlqxwlxsbas.size() > 0) {
            for (CertchildYlqxwlxsba entity : certchildYlqxwlxsbas) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setZt("4");
                entity.setXzspid(certInfo.getId());
                entity.setSync("已盖章变更");
                certchildYlqxwlxsbaMapper.insert(entity);
            }
        }
        if (certchildYlqxscbaZbs != null && certchildYlqxscbaZbs.size() > 0) {
            for (CertchildYlqxscbaZb entity : certchildYlqxscbaZbs) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setZt("4");
                entity.setXzspid(certInfo.getId());
                entity.setCreateBy("已盖章变更");
                certchildYlqxscbaZbMapper.insert(entity);
            }
        }
        if (certchildCkomylies != null && certchildCkomylies.size() > 0) {
            for (CertchildCkomyly entity : certchildCkomylies) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setZt("4");
                entity.setXzspid(certInfo.getId());
                entity.setCreateBy("已盖章变更");
                certchildCkomylyMapper.insert(entity);
            }
        }
        if (certchildMzyphjsypddscs != null && certchildMzyphjsypddscs.size() > 0) {
            for (CertchildMzyphjsypddsc entity : certchildMzyphjsypddscs) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setZt("4");
                entity.setXzspid(certInfo.getId());
                entity.setCreateBy("已盖章变更");
                certchildMzyphjsypddscMapper.insert(entity);
            }
        }
        if (certchildYlqxcpckxs != null && certchildYlqxcpckxs.size() > 0) {
            for (CertchildYlqxcpckxs entity : certchildYlqxcpckxs) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setZt("4");
                entity.setXzspid(certInfo.getId());
                entity.setCreateBy("已盖章变更");
                certchildYlqxcpckxsMapper.insert(entity);
            }
        }
        if (certchildYlqxwlxsbaList != null && certchildYlqxwlxsbaList.size() > 0) {
            for (CertchildYlqxwtbaZb entity : certchildYlqxwlxsbaList) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setZt("4");
                entity.setXzspid(certInfo.getId());
                entity.setCreateBy("已盖章变更");
                certchildYlqxwtbaZbMapper.insert(entity);
            }
        }
        if (certchildYpckxkzs != null && certchildYpckxkzs.size() > 0) {
            for (CertchildYpckxkz entity : certchildYpckxkzs) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setZt("4");
                entity.setXzspid(certInfo.getId());
                entity.setCreateBy("已盖章变更");
                certchildYpckxkzMapper.insert(entity);
            }
        }
        if (certchildYpckxszms != null && certchildYpckxszms.size() > 0) {
            for (CertchildYpckxszm entity : certchildYpckxszms) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setZt("4");
                entity.setXzspid(certInfo.getId());
                entity.setCreateBy("已盖章变更");
                certchildYpckxszmMapper.insert(entity);
            }
        }
        if (certchildDylylqxscbapzList != null && certchildDylylqxscbapzList.size() > 0) {
            for (CertchildDylylqxscbapz entity : certchildDylylqxscbapzList) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setZt(BigDecimal.valueOf(4));
                entity.setXzspid(certInfo.getId());
                entity.setSync("已盖章变更");
                certchildDylylqxscbapzMapper.insert(entity);
            }
        }
        if (certchirdYlqxlcsybas != null && certchirdYlqxlcsybas.size() > 0) {
            for (CertchirdYlqxlcsyba entity : certchirdYlqxlcsybas) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setZt("4");
                entity.setXzspid(certInfo.getId());
                entity.setCreateBy("已盖章变更");
                certchirdYlqxlcsybaMapper.insert(entity);
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delMain(String id) {
        /*certchildYpscZcMapper.deleteByMainId(id);
        certchildYpscWtMapper.deleteByMainId(id);
        certchildYpscStMapper.deleteByMainId(id);*/
        certInfoMapper.deleteById(id);
    }

    @Override
    public CertInfo getByZsid(String zsid) {
        return certInfoMapper.getByzsid(zsid);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delBatchMain(Collection<? extends Serializable> idList) {
        for (Serializable id : idList) {
//            certchildYpscZcMapper.deleteByMainId(id.toString());
//            certchildYpscWtMapper.deleteByMainId(id.toString());
//            certchildYpscStMapper.deleteByMainId(id.toString());
            certInfoMapper.deleteById(id);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<CertMetadata> queryCertMetadateById(String id, String status) {
        return certInfoMapper.queryCertMetadateById(id, status);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<CertMetadata> queryCertMetadateByIdelse(String id, String status) {
        return certInfoMapper.queryCertMetadateByIdelse(id, status);
    }

    @Override
    public String batchGz(String[] zsids, String[] type, String signatureName, String keySn, HttpServletRequest request) {
        //下载路径
        String filepath = uploadpath + "/";
        //第一步 查询证照数据
        CertInfo certInfo = new CertInfo();
        for (String zsid : zsids) {
            //====================主表数据初始化======================
            //先从未盖章查询
            ZsYwxxb byId = iZsYwxxbService.getById(zsid);

            String fzjg = byId.getFzjg();
            //sealcode的值获取方式
            ResultBean realcode;
            //ukey盖章
            if (StringUtils.isNotBlank(keySn)) {
                if (keySn.length() > 16) keySn = keySn.substring(0, 16);
                realcode = iZsYwxxbService.getSealcodeByKeySn(keySn);
                if (realcode == null) return "未找到当前ukey所对应的章，无法盖章，请联系管理员";
            } else {//部门盖章
                realcode = iZsYwxxbService.getRealcodeByName(fzjg);
                if (realcode == null) {
                    realcode = new ResultBean();
                    realcode.setSealCode("");
                    realcode.setSealName("");
                }
            }
            try {
                //根据未盖章去
                CertInfo byId2 = getByZsid(byId.getZsid());
                //盖章生成新数据到落地表 ，并且是盖章操作，才会在结果表生成新的数据
                if (byId2 == null && (type == null || type.length == 0)) {
                    byId2 = new CertInfo();
                    BeanUtils.copyProperties(byId, byId2);
                    certInfo = byId2;
                } else if (byId2 != null && (type == null || type.length == 0)) {
                    BeanUtils.copyProperties(byId, certInfo);
                    certInfo.setId(byId2.getId());
                } else {
                    BeanUtils.copyProperties(byId, certInfo);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "存在两个以上相同编号的有效盖章数据";
            }
            //特殊情况处理 (二类医疗器械注册证，体外试剂)   变更 不改变主证信息 ，同时改变延续
            if ("3".equals(byId.getZslx()) && ("26".equals(byId.getZslx()) || "3".equals(byId.getZslx()))) {
                //找到结果信息表的有效 存在有效期之内的数据 并且根据时间排序 核发或者换发
                LambdaQueryWrapper<CertInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                lambdaQueryWrapper.ne(CertInfo::getIsgq, "1");
                lambdaQueryWrapper.eq(CertInfo::getZsid, byId.getZsid());
                //核发或者换发
                lambdaQueryWrapper.in(CertInfo::getZszt, "1", "2");
                lambdaQueryWrapper.eq(CertInfo::getZt, "4");
                lambdaQueryWrapper.orderByDesc(CertInfo::getFzrq);
                List<CertInfo> list = list(lambdaQueryWrapper);
                if (CollectionUtils.isNotEmpty(list))
                    certInfo = list.get(0);
                /*   return  "未找到核发或换发数据，请联系管理员";*/
            }
            //===================子表数据处理=========================
            ZsDto zsDtozb = new ZsDto();
            CertType certtype = iCertTypeService.getById(certInfo.getCerttypeid());
            CertUtils.initSubTable(zsDtozb, byId.getZsid(), byId.getId(), byId.getZt(), certtype);
            //第二部 将证照数据复制至新的对接对象
            ZsDto zsDto = new ZsDto();
            //第三步 处理对接对象的数
            //第四步  获取证照类型模型文件
            QueryWrapper<CertMode> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("certtypeid", certInfo.getCerttypeid());
            /*queryWrapper.eq("status","1");*/
            List<CertMode> certModes = iCertModeService.list(queryWrapper);
            //查询证书盖章模板
            Wrapper<CertMode> queryMm = Wrappers.<CertMode>lambdaQuery()
                .eq(CertMode::getCerttypeid, certInfo.getCerttypeid())
                .orderByAsc(CertMode::getTemplateType);
            //判断是否完整盖章
            int index = 0;
            //遍历模板
            for (CertMode certmode : certModes) {
                BeanUtils.copyProperties(certInfo, zsDto);
                //拼装路径
                if (StringUtils.isNotBlank(certmode.getFile())) {
                    if (!certmode.getFile().contains("temp")) certmode.setFile("temp/" + certmode.getFile());
                } else return "存在模板附件未上传附件，请检查证照类型配置，如不需要请禁用！";
                //证书模板地址
                String oldfile = uploadpath + "/" + certmode.getFile();
                File zsPdfDir = new File(oldfile);
                if (!zsPdfDir.exists() && !zsPdfDir.mkdirs()) return "目录[" + oldfile + "]创建失败";
                String timeStr = DateFormatUtils.format(new Date(), "yyyyMMddHHmmss");
                Integer thisMonth = DateUtils.getThisMonth();
                Integer thisYear = DateUtils.getThisYear();
                String attachurlroot = certtype.getCerttype() + "/" + thisYear + "/" + thisMonth;
                String foldpath = uploadpath + "/" + certtype.getCerttype() + "/" + thisYear + "/" + thisMonth;
                File file1 = new File(foldpath);
                if (!file1.exists() && !file1.mkdirs()) return "目录[" + foldpath + "]创建失败";
                //获取该证书配置的元数据，并装配处理
                List<CertMetadata> cardrecordlist = getRecordList(false, certInfo.getCerttypeid());
                if (cardrecordlist.size() == 0) {
                    return "未配置元数据，无法生成证照";
                }
                String templename = "";
                //正本//副本
                if ("1".equals(certmode.getTemplateType()) || "2".equals(certmode.getTemplateType())) {
                    String newfil = foldpath + "/" + certInfo.getId() + "_" + timeStr + "_" + (1) + "_zb.ofd"; //未盖章路径
                    String newfilfb = foldpath + "/" + certInfo.getId() + "_" + timeStr + "_" + (1) + "_fb.ofd"; //未盖章路径
                    String newgzfilzb = foldpath + "/" + certInfo.getId() + "_" + timeStr + "_zb.ofd";//盖章路径
                    String newgzfilfb = foldpath + "/" + certInfo.getId() + "_" + timeStr + "_fb.ofd";//盖章路径
                    //新生成ofd文件地址
                    //第五步  将模板文件，对接对象，文件地址 传给接口 获取接口返回的文件 完成
                    try {
                        //生成证照
                        //如果是word格式的 要特殊处理
                        if ("3".equals(certmode.getModeformat())) {
                            CertUtils.initSubTable(zsDto, byId.getZsid(), byId.getId(), byId.getZt(), certtype);
                            //填充word模板数据  已经生成证照了
                            XmlUtil xmlUtil = new XmlUtil();
                            xmlUtil.getWordToOfdByJH(oldfile, newfil, zsDto, cardrecordlist);
                            templename = "正本";
                            AddAttach(certInfo.getZsid() + "_wgz_.ofd", certmode.getTemplateName(), attachurlroot + "/" + certInfo.getId() + "_" + timeStr +
                                "_" + (1) + "_zb.ofd", zsid, "0");

                            // 添加附件
                            if (org.apache.commons.lang3.StringUtils.isNotBlank(certInfo.getFj())) {
                                String error = OfdUtil.makeAttach(newfil, newgzfilzb, certInfo, uploadpath, certmode, type == null ? realcode : null);
                                if (StringUtils.isNotBlank(error)) return "无法联合盖章:" + error;
                                Files.move(Paths.get(newgzfilzb), Paths.get(newfil), StandardCopyOption.REPLACE_EXISTING);
                            }
                            if (type == null) {//盖章
                                //坐标定位
                                if ("1".equals(certmode.getPostmethod())) {
                                    String s = SignatureUtil.addSignOfd(newfil, newgzfilzb, certmode.getPostleftX1(),
                                        certmode.getPostLeft1(), null, null, null, "0", realcode.getSealCode(), realcode.getSealName());
                                } else {//文本
                                    String s = SignatureUtil.addSignOfd(newfil, newgzfilzb, certmode.getPostleftX1(),
                                        certmode.getPostLeft1(), null, null, certmode.getWbpost(), "0", realcode.getSealCode(), realcode.getSealName());
                                }
                                AddAttach(certInfo.getId() + "_fy.ofd", certmode.getTemplateName(), attachurlroot + "/" + certInfo.getId() + "_"
                                    + timeStr + "_zb.ofd", certInfo.getId(), "1");
                                index++;
                            }
                        } else {
                            if ("2".equals(certmode.getTemplateType())) { //副本
                                String qrUrl = YwUtil.getQrCodeValue(zsDto.getZsid(), serverUrl);
                                zsDto.setQrcode(YwUtil.generateQRCodeImageOfd(qrUrl, 600, 600));
                                // zsDto.setQrcode(new Base64Util().base64Encoding());

                                int result = createOfdByTemplate(zsDto, cardrecordlist, oldfile, newfilfb, 0);
                                if (result == 0) {
                                    return "文件读取错误,请联系管理员确认是否配置证书模板文件";
                                }
                                templename = "副本";
                                //未盖章文件记录 //不盖章只生成
                                AddAttach(certInfo.getId() + "_wgz_fb.ofd", certmode.getTemplateName(),
                                    attachurlroot + "/" + certInfo.getId() + "_" + timeStr + "_" + (1) + "_fb.ofd", zsid, "0");
                                if (type == null) {
                                    String s = SignatureUtil.addSignOfd(newfilfb, newgzfilfb, certmode.getPostleftX1(), certmode.getPostLeft1(), null, null,
                                        certmode.getWbpost(), "0", realcode.getSealCode(), realcode.getSealName());

                                    AddAttach(certInfo.getId() + "_fb.ofd", certmode.getTemplateName(),
                                        attachurlroot + "/" + certInfo.getId() + "_" + timeStr + "_fb.ofd", certInfo.getId(), "1");
                                    index++;
                                }
                            }
                            if ("1".equals(certmode.getTemplateType())) { //正本
                                String qrUrl = YwUtil.getQrCodeValue(zsDto.getZsid(), serverUrl);
                                zsDto.setQrcode(YwUtil.generateQRCodeImageOfd(qrUrl, 600, 600));

                                String fj = zsDto.getFj();
                                if ("35".equals(certtype.getZslx())) {
                                    if (StringUtils.isNotBlank(zsDto.getFj()))
                                        zsDto.setFj(FilenameUtils.getBaseName(zsDto.getFj()).replaceAll("_\\d+$", ""));
                                }
                                //模板文件找不到
                                // zsDto.setQrcode(new Base64Util().base64Encoding());
                                int result = createOfdByTemplate(zsDto, cardrecordlist, oldfile, newfil, 0);
                                zsDto.setFj(fj);
                                if (result == 0) {
                                    return "文件读取错误,请联系管理员确认是否配置证书模板文件";
                                }
                                templename = "正本";
                                //未盖章文件记录 //不盖章只生成
                                AddAttach(certInfo.getId() + "_wgz_zb.ofd", certmode.getTemplateName(),
                                    attachurlroot + "/" + certInfo.getId() + "_" + timeStr + "_" + (1) + "_zb.ofd", zsid, "0");
                                if (type == null) {
                                    //如果是 广告证 要合并附件  ||  第二类医疗器械&&附件不为空时 合并附件盖章 ||  第二类体外诊断试剂&&附件不为空时 合并附件盖章
                                    if ("68".equals(certtype.getZslx()) || "69".equals(certtype.getZslx()) || "75".equals(certtype.getZslx()) || "35".equals(certtype.getZslx()) ||
                                        ("3".equals(certtype.getZslx()) && StringUtils.isNotBlank(certInfo.getFj())) || ("26".equals(certtype.getZslx()) && StringUtils.isNotBlank(certInfo.getFj()))) {
                                        // 如果是广告类 还要另外盖章 中间新加一个过度文件
                                        String guoduwenjian = uploadpath + "/test.ofd";
                                        String s = SignatureUtil.addSignOfd(newfil, guoduwenjian, certmode.getPostleftX1(), certmode.getPostLeft1(), null,
                                            null, null, "0", realcode.getSealCode(), realcode.getSealName());
                                        index++;

                                        //合并附件
                                        String error = OfdUtil.makeAttach(guoduwenjian, newgzfilzb, certInfo, uploadpath, certmode, realcode);
                                        if (StringUtils.isNotBlank(error)) {
                                            return "无法联合盖章:" + error;
                                        }
                                        //新给一个地址
                                    } else {
                                        String s = SignatureUtil.addSignOfd(newfil, newgzfilzb, certmode.getPostleftX1(), certmode.getPostLeft1(), null, null
                                            , null, "0", realcode.getSealCode(), realcode.getSealName());
                                    }
                                    AddAttach(certInfo.getId() + "_zb.ofd", certmode.getTemplateName(),
                                        attachurlroot + "/" + certInfo.getId() + "_" + timeStr + "_zb.ofd", certInfo.getId(), "1");
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        if("2".equals(certmode.getPostmethod()))
                        {
                            return "签章异常！文本定位未找到定位文字，生成模板配置错误 ";

                        }
                        else{ return "签章异常！ ";}
                    }
                }
                //附页
                if ("3".equals(certmode.getTemplateType())) {
                    templename="副页";
                    ZsDto zsDtozb1 = new ZsDto();
                    org.springframework.beans.BeanUtils.copyProperties(certInfo, zsDtozb1);
                    CertUtils.initSubTable(zsDtozb1, byId.getZsid(), byId.getId(), byId.getZt(), certtype);
                    String fyTemplate = "";
                    try {

                        String newfil = foldpath + "/" + certInfo.getId() + "_"
                                + timeStr + "_" + (1) + "_tempfy.ofd";
                        String newgzfil = foldpath + "/" + certInfo.getId() + "_"
                                + timeStr + "_fy.ofd";

                        //填充word模板数据  已经生成证照了
                        int wordByWord = XmlUtil.getWordByWord(oldfile, newfil, zsDtozb1, zsDto.getQymc());
                        if(wordByWord==0)
                        {
                            return "证书模板文件读取错误,请联系管理员确认是否配置证书模板文件";
                        }
                        AddAttach(certInfo.getZsid() + "_wgz_fy.ofd", certmode.getTemplateName(), attachurlroot + "/" + certInfo.getId() + "_" + timeStr + "_" + (1) + "_tempfy.ofd", zsid, "0");

                        if (type == null) {
                            //生成证照并盖章

                            String s = SignatureUtil.addSignOfd(newfil, newgzfil, certmode.getPostleftX1(), certmode.getPostLeft1(), null, null, null, "0", realcode.getSealCode(), realcode.getSealName());

                            AddAttach(certInfo.getId() + "_fy.ofd", certmode.getTemplateName(), attachurlroot + "/" + certInfo.getId() + "_"
                                    + timeStr + "_fy.ofd", certInfo.getId(), "1");
                            index++;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                //变更记录  如果是换发直接不生成
                if ("4".equals(certmode.getTemplateType()) && !"2".equals(certInfo.getZszt())) {
                    try {
                        String qrUrl = YwUtil.getQrCodeValue(zsDto.getZsid(), serverUrl);
                        zsDto.setQrcode(YwUtil.generateQRCodeImageOfd(qrUrl, 600, 600));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    templename="变更记录";
                    int yushu = 0;
                    //判断余数
                    if (StringUtils.isNotBlank(certmode.getPblx()) && "1".equals(certmode.getPblx())) {
                        yushu = 6;
                    } else if (StringUtils.isNotBlank(certmode.getPblx()) && "4".equals(certmode.getPblx())) {
                        yushu = 4;
                    } else if (StringUtils.isNotBlank(certmode.getPblx()) && "2".equals(certmode.getPblx())) {
                        yushu = 8;
                    }
                    else if (StringUtils.isNotBlank(certmode.getPblx()) && "3".equals(certmode.getPblx())) {
                        yushu = 1;
                    }

                    QueryWrapper queryWrapper1 = new QueryWrapper();
                    queryWrapper1.eq("zsid", certInfo.getZsid());
                    queryWrapper1.eq("BGLX", "3");//只有变更记录
                    queryWrapper1.eq("stutas", "20");//有效状态


                    List<CertInfoOperationRecord> opers = certInfoOperationRecordService.list(queryWrapper1);
                    if (opers != null && opers.size() > 0) {
                        //为什么删除最后一个  不考虑1吗
                      /*  if(opers.size()>1)
                        {
                        opers.remove(opers.size() - 1);
                        }*/
                    } else {
                        continue;
                    }
                     int size = opers.size();
                    //判断有多少条变更记录
                    opers.sort(Comparator.comparing(CertInfoOperationRecord::getCzsj));
                    //赋值
                    if (!opers.isEmpty()) {
                        for (int j = 0; j < opers.size(); j++) {
                            CertInfoOperationRecord vo = opers.get(j);
                            Date czsj = vo.getCzsj();
                            if("3".equals(certtype.getZslx())||"26".equals(certtype.getZslx())) {
                                try {
                                JavaReflect.setter(zsDto, "Bgnr", vo.getBgnr(), String.class);
                                JavaReflect.setter(zsDto, "Fzjg", certInfo.getFzjg(), String.class);
                                //JavaReflect.setter(zsDto, "Bz", certInfo.getBz(), String.class);
                                JavaReflect.setter(zsDto, "Cpmc", certInfo.getChanping(), String.class);
                                JavaReflect.setter(zsDto, "Zsbh", certInfo.getZsbh(), String.class);
                                JavaReflect.setter(zsDto, "Fzrq", certInfo.getFzrq(), String.class);
                                //备注信息改为操作信息表备注
                                LambdaQueryWrapper<CertInfoOperationDetail> queryWrapperOd=new LambdaQueryWrapper<>();
                                queryWrapperOd.eq(CertInfoOperationDetail::getZsid,certInfo.getZsid());
                                List<CertInfoOperationDetail> certInfoOperationDetails=certInfoOperationDetailService.list(queryWrapperOd);
                                if(certInfoOperationDetails.size()>0){
                                    String bz="";
                                    for (CertInfoOperationDetail od:certInfoOperationDetails
                                    ) {
                                        if("".equals(bz)){
                                            if(StringUtils.isNotBlank(od.getBz())){
                                                bz=od.getBz();
                                            }
                                        }else {
                                            if(StringUtils.isNotBlank(od.getBz())){
                                                if(bz.indexOf(od.getBz())<0){
                                                    System.out.println(bz.indexOf(od.getBz())<1);
                                                    bz=bz+";"+od.getBz();
                                                }

                                            }
                                        }
                                    }
                                    JavaReflect.setter(zsDto, "Bz", bz, String.class);
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }else {
                                //查询变更记录的内容
                                    try {
                                    JavaReflect.setter(zsDto, "Modifyinfo" + String.valueOf(j + 1), vo.getSjbgnr(), String.class);
                                    JavaReflect.setter(zsDto, "Modifytime" + String.valueOf(j + 1), czsj, Date.class);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }

                        }
                    }
                    String newfil = foldpath + "/" + certInfo.getId() + "_"
                            + timeStr + "_" + (1) + "_bgjl.ofd"; //未盖章路径 生成文件
                    String newgzfil = foldpath + "/" + certInfo.getId() + "_"
                            + timeStr + "_" + (1) + "_bgjl.ofd";//盖章路径
                    try {
                        //生成
                        int result = createBgPdf(certModes, certModes, zsDto, "", "", 1, "", "", 1, "ceshi", filepath + certmode.getFile(), newfil, yushu);
                        if (result == 0) {
                            return "未找到变更模板文件,请联系管理员检查配置";
                        }
                        AddAttach(certInfo.getId() + "_wgz_bgjl.ofd",certmode.getTemplateName(), attachurlroot + "/" + certInfo.getId() + "_" + timeStr + "_" + (1) + "_bgjl.ofd", zsid, "0");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //左一右一
                    String LeftX1 = certmode.getPostleftX1();
                    String LeftY1 = certmode.getPostLeft1();
                    String RightX1 = certmode.getPostrightX1();
                    String RightY1 = certmode.getPostRight1();
                    //左二右二
                    String LeftX2 = certmode.getPostleftX2();
                    String LeftY2 = certmode.getPostLeft2();
                    String RightX2 = certmode.getPostrightX2();
                    String RightY2 = certmode.getPostRight2();
                    //左三右三
                    String LeftX3 = certmode.getPostleftX3();
                    String LeftY3 = certmode.getPostLeft3();
                    String RightX3 = certmode.getPostrightX3();
                    String RightY3 = certmode.getPostRight3();
                    //左四右四
                    String LeftX4 = certmode.getPostleftX4();
                    String LeftY4 = certmode.getPostLeft4();
                    String RightX4 = certmode.getPostleftX4();
                    String RightY4 = certmode.getPostLeft4();

                    //判断是左三右三
                    if (StringUtils.isNotBlank(certmode.getPblx()) && "1".equals(certmode.getPblx()) && type == null) {  //盖章  循环盖章  根据有多少变更记录 就盖多少次
                        String testpath = uploadpath + "/templd.ofd";
                        String testpath1 = uploadpath + "/templd1.ofd";
                        String testpath2 = uploadpath + "/templd2.ofd";
                        String testpath3 = uploadpath + "/templd3.ofd";
                        String testpath4 = uploadpath + "/templd4.ofd";
                        String testpath5 = uploadpath + "/templd5.ofd";
                        String testpath6 = uploadpath + "/templd6.ofd";
                        //先判断要盖几页
                        int pagesize = size / 6;

                        String page = "";
                        int forpage = pagesize;
                        //如果不是刚好除尽，则要多盖一页
                        if (size % 6 != 0) {
                            forpage = pagesize + 1;
                        }
                        for (int i = 1; i <= forpage; i++) {
                            page += i + ",";
                        }

                        page = page.substring(0, page.length() - 1);
                        int i = size % 6;
                        String page2 = "";
                        String page3 = "";
                        String page4 = "";
                        String page5 = "";
                        String page6 = "";

                        //
                        if (i == 0) {
                            page2 = page;
                            page3 = page;
                            page4 = page;
                            page5 = page;
                            page6 = page;
                        }
                        if (i == 1) {
                            //排除只有一页的情况
                            if (page.length() > 1) {
                                page2 = page.substring(0, page.length() - (String.valueOf(pagesize).length() + 1));


                            } else {
                                page2 = "1";
                            }
                            page3 = page2;
                            page4 = page3;
                            page5 = page3;
                            page6 = page3;
                        }
                        if (i == 2) {
                            page2 = page;
                            //排除只有一页的情况
                            if (page.length() > 1) {
                                page3 = page.substring(0, page.length() - (String.valueOf(pagesize).length() + 1));

                            } else {
                                page3 = "1";
                            }
                            ;
                            page4 = page3;
                            page5 = page4;
                            page6 = page4;
                        }
                        if (i == 3) {
                            page2 = page;
                            page3 = page;
                            if (page.length() > 1) {
                                page4 = page.substring(0, page.length() - (String.valueOf(pagesize).length() + 1));

                            } else {
                                page4 = "1";
                            }
                            page5 = page4;
                            page6 = page4;
                        }
                        if (i == 4) {
                            page2 = page;
                            page3 = page;
                            page4 = page;
                            if (page.length() > 1) {
                                page5 = page.substring(0, page.length() - (String.valueOf(pagesize).length() + 1));
                            } else {
                                page5 = "1";
                            }
                            // page5 = page.substring(0, page.length() - (String.valueOf(pagesize).length() + 1));
                            page6 = page5;
                        }
                        if (i == 5) {
                            page2 = page;
                            page3 = page;
                            page4 = page;
                            page5 = page;
                            if (page.length() > 1) {
                                page6 = page.substring(0, page.length() - (String.valueOf(pagesize).length() + 1));

                            } else {
                                page6 = "1";
                            }
                            // page6 = page.substring(0, page.length() - (String.valueOf(pagesize).length() + 1));
                            ;
                        }
                        String testpath0 = newfil;
                        try {
                            if ("1".equals(page)) {
                                if (opers.size() == 1) {
                                    SignatureUtil.addSignOfd(newfil, newgzfil, LeftX1, LeftY1, null, null, null, page, realcode.getSealCode(), realcode.getSealName());

                                }
                                if (opers.size() == 2) {
                                    SignatureUtil.addSignOfd(newfil, testpath2, LeftX1, LeftY1, null, null, null, page, realcode.getSealCode(), realcode.getSealName());
                                    SignatureUtil.addSignOfd(testpath2, newgzfil, LeftX2, LeftY2, null, null, null, page2, realcode.getSealCode(), realcode.getSealName());

                                }
                                if (opers.size() == 3) {
                                    SignatureUtil.addSignOfd(newfil, testpath2, LeftX1, LeftY1, null, null, null, page, realcode.getSealCode(), realcode.getSealName());
                                    SignatureUtil.addSignOfd(testpath2, testpath3, LeftX2, LeftY2, null, null, null, page2, realcode.getSealCode(), realcode.getSealName());
                                    SignatureUtil.addSignOfd(testpath3, newgzfil, LeftX3, LeftY3, null, null, null, page3, realcode.getSealCode(), realcode.getSealName());

                                }
                                if (opers.size() == 4) {
                                    SignatureUtil.addSignOfd(newfil, testpath2, LeftX1, LeftY1, null, null, null, page, realcode.getSealCode(), realcode.getSealName());
                                    SignatureUtil.addSignOfd(testpath2, testpath3, LeftX2, LeftY2, null, null, null, page2, realcode.getSealCode(), realcode.getSealName());
                                    SignatureUtil.addSignOfd(testpath3, testpath4, LeftX3, LeftY3, null, null, null, page3, realcode.getSealCode(), realcode.getSealName());

                                    SignatureUtil.addSignOfd(testpath4, newgzfil, RightX1, RightY1, null, null, null, page4, realcode.getSealCode(), realcode.getSealName());

                                }
                                if (opers.size() == 5) {
                                    SignatureUtil.addSignOfd(newfil, testpath2, LeftX1, LeftY1, null, null, null, page, realcode.getSealCode(), realcode.getSealName());
                                    SignatureUtil.addSignOfd(testpath2, testpath3, LeftX2, LeftY2, null, null, null, page2, realcode.getSealCode(), realcode.getSealName());
                                    SignatureUtil.addSignOfd(testpath3, testpath4, LeftX3, LeftY3, null, null, null, page3, realcode.getSealCode(), realcode.getSealName());

                                    SignatureUtil.addSignOfd(testpath4, testpath5, RightX1, RightY1, null, null, null, page4, realcode.getSealCode(), realcode.getSealName());
                                    SignatureUtil.addSignOfd(testpath5, newgzfil, RightX2, RightY2, null, null, null, page5, realcode.getSealCode(), realcode.getSealName());

                                }
                                if (opers.size() == 6) {
                                    SignatureUtil.addSignOfd(newfil, testpath2, LeftX1, LeftY1, null, null, null, page, realcode.getSealCode(), realcode.getSealName());
                                    SignatureUtil.addSignOfd(testpath2, testpath3, LeftX2, LeftY2, null, null, null, page2, realcode.getSealCode(), realcode.getSealName());
                                    SignatureUtil.addSignOfd(testpath3, testpath4, LeftX3, LeftY3, null, null, null, page3, realcode.getSealCode(), realcode.getSealName());

                                    SignatureUtil.addSignOfd(testpath4, testpath5, RightX1, RightY1, null, null, null, page4, realcode.getSealCode(), realcode.getSealName());
                                    SignatureUtil.addSignOfd(testpath5, testpath6, RightX2, RightY2, null, null, null, page5, realcode.getSealCode(), realcode.getSealName());
                                    SignatureUtil.addSignOfd(testpath6, newgzfil, RightX3, RightY3, null, null, null, page6, realcode.getSealCode(), realcode.getSealName());

                                }
                            } else {
                                SignatureUtil.addSignOfd(newfil, testpath2, LeftX1, LeftY1, null, null, null, page, realcode.getSealCode(), realcode.getSealName());
                                SignatureUtil.addSignOfd(testpath2, testpath3, LeftX2, LeftY2, null, null, null, page2, realcode.getSealCode(), realcode.getSealName());
                                SignatureUtil.addSignOfd(testpath3, testpath4, LeftX3, LeftY3, null, null, null, page3, realcode.getSealCode(), realcode.getSealName());

                                SignatureUtil.addSignOfd(testpath4, testpath5, RightX1, RightY1, null, null, null, page4, realcode.getSealCode(), realcode.getSealName());
                                SignatureUtil.addSignOfd(testpath5, testpath6, RightX2, RightY2, null, null, null, page5, realcode.getSealCode(), realcode.getSealName());
                                SignatureUtil.addSignOfd(testpath6, newgzfil, RightX3, RightY3, null, null, null, page6, realcode.getSealCode(), realcode.getSealName());
                            }    /*FileUtils.deleteFile(testpath);
                             FileUtils.deleteFile(testpath1);*/
                            /* FileUtils.deleteFile(testpath2);
                             FileUtils.deleteFile(testpath3);
                             FileUtils.deleteFile(testpath4);
                             FileUtils.deleteFile(testpath5);
                             FileUtils.deleteFile(testpath6);*/
                            AddAttach(certInfo.getId() + "_" + (1) + "_bgjl.ofd", certmode.getTemplateName(), attachurlroot + "/" + certInfo.getId() + "_" + timeStr + "_" + (1) + "_bgjl.ofd", certInfo.getId(), "1");
                            index++;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return "盖章错误，变更记录模板问题,请联系管理员";
                        }

                    }
//判断是左四右四
                    if (StringUtils.isNotBlank(certmode.getPblx()) && "2".equals(certmode.getPblx()) && type == null) {  //盖章  循环盖章  根据有多少变更记录 就盖多少次
                        String testpath = uploadpath + "/templd.ofd";
                        String testpath1 = uploadpath + "/templd1.ofd";
                        String testpath2 = uploadpath + "/templd2.ofd";
                        String testpath3 = uploadpath + "/templd3.ofd";
                        String testpath4 = uploadpath + "/templd4.ofd";
                        String testpath5 = uploadpath + "/templd5.ofd";
                        String testpath6 = uploadpath + "/templd6.ofd";
                        String testpath7 = uploadpath + "/templd7.ofd";
                        String testpath8 = uploadpath + "/templd8.ofd";
                        int pagesize = size / 8;

                        String page = "";
                        int forpage = pagesize;
                        if (size % 8 != 0) {
                            forpage = pagesize + 1;
                        }
                        for (int i = 1; i <= forpage; i++) {
                            page += i + ",";
                        }

                        page = page.substring(0, page.length() - 1);
                        int i = size % 8;
                        String page2 = "";
                        String page3 = "";
                        String page4 = "";
                        String page5 = "";
                        String page6 = "";
                        String page7 = "";
                        String page8 = "";


                        if (i == 0) {
                            page2 = page;
                            page3 = page;
                            page4 = page;
                            page5 = page;
                            page6 = page;
                            page7 = page;
                            page8 = page;
                        }
                        if (i == 1) {
                            //排除只有一页的情况
                            if (page.length() > 1) {
                                page2 = page.substring(0, page.length() - (String.valueOf(pagesize).length() + 1));

                            } else {
                                page2 = "1";
                            }
                            page3 = page2;
                            page4 = page3;
                            page5 = page3;
                            page6 = page3;
                            page7 = page;
                            page8 = page;
                        }
                        if (i == 2) {
                            page2 = page;
                            //排除只有一页的情况
                            if (page.length() > 1) {
                                page3 = page.substring(0, page.length() - (String.valueOf(pagesize).length() + 1));

                            } else {
                                page3 = "1";
                            }
                            ;
                            page4 = page3;
                            page5 = page4;
                            page6 = page4;
                            page7 = page;
                            page8 = page;
                        }
                        if (i == 3) {
                            page2 = page;
                            page3 = page;
                            if (page.length() > 1) {
                                page4 = page.substring(0, page.length() - (String.valueOf(pagesize).length() + 1));

                            } else {
                                page4 = "1";
                            }
                            page5 = page4;
                            page6 = page4;
                            page7 = page;
                            page8 = page;
                        }
                        if (i == 4) {
                            page2 = page;
                            page3 = page;
                            page4 = page;
                            if (page.length() > 1) {
                                page5 = page.substring(0, page.length() - (String.valueOf(pagesize).length() + 1));
                            } else {
                                page5 = "1";
                            }
                            // page5 = page.substring(0, page.length() - (String.valueOf(pagesize).length() + 1));
                            page6 = page5;
                            page7 = page;
                            page8 = page;
                        }
                        if (i == 5) {
                            page2 = page;
                            page3 = page;
                            page4 = page;
                            page5 = page;
                            if (page.length() > 1) {
                                page6 = page.substring(0, page.length() - (String.valueOf(pagesize).length() + 1));

                            } else {
                                page6 = "1";
                            }
                            page7 = page;
                            page8 = page;
                            // page6 = page.substring(0, page.length() - (String.valueOf(pagesize).length() + 1));
                            ;
                        }
                        if (i == 6) {
                            page2 = page;
                            page3 = page;
                            page4 = page;
                            page5 = page;

                            page6 = page;
                            if (page.length() > 1) {
                                page7 = page.substring(0, page.length() - (String.valueOf(pagesize).length() + 1));

                            } else {
                                page7 = "1";
                            }
                            page8 = page;
                            // page6 = page.substring(0, page.length() - (String.valueOf(pagesize).length() + 1));
                            ;
                        }
                        if (i == 7) {
                            page2 = page;
                            page3 = page;
                            page4 = page;
                            page5 = page;

                            page6 = page;

                            page7 = page;
                            if (page.length() > 1) {
                                page8 = page.substring(0, page.length() - (String.valueOf(pagesize).length() + 1));

                            } else {
                                page8 = "1";
                            }
                            // page6 = page.substring(0, page.length() - (String.valueOf(pagesize).length() + 1));
                            ;
                        }
                        String testpath0 = newfil;
                        try {
                            if ("1".equals(page)) {
                                if (opers.size() == 1) {
                                    SignatureUtil.addSignOfd(newfil, newgzfil, LeftX1, LeftY1, null, null, null, page, realcode.getSealCode(), realcode.getSealName());

                                }
                                if (opers.size() == 2) {
                                    SignatureUtil.addSignOfd(newfil, testpath2, LeftX1, LeftY1, null, null, null, page, realcode.getSealCode(), realcode.getSealName());
                                    SignatureUtil.addSignOfd(testpath2, newgzfil, LeftX2, LeftY2, null, null, null, page2, realcode.getSealCode(), realcode.getSealName());

                                }
                                if (opers.size() == 3) {
                                    SignatureUtil.addSignOfd(newfil, testpath2, LeftX1, LeftY1, null, null, null, page, realcode.getSealCode(), realcode.getSealName());
                                    SignatureUtil.addSignOfd(testpath2, testpath3, LeftX2, LeftY2, null, null, null, page2, realcode.getSealCode(), realcode.getSealName());
                                    SignatureUtil.addSignOfd(testpath3, newgzfil, LeftX3, LeftY3, null, null, null, page3, realcode.getSealCode(), realcode.getSealName());

                                }
                                if (opers.size() == 4) {
                                    SignatureUtil.addSignOfd(newfil, testpath2, LeftX1, LeftY1, null, null, null, page, realcode.getSealCode(), realcode.getSealName());
                                    SignatureUtil.addSignOfd(testpath2, testpath3, LeftX2, LeftY2, null, null, null, page2, realcode.getSealCode(), realcode.getSealName());
                                    SignatureUtil.addSignOfd(testpath3, testpath4, LeftX3, LeftY3, null, null, null, page3, realcode.getSealCode(), realcode.getSealName());

                                    SignatureUtil.addSignOfd(testpath4, newgzfil, LeftX4, LeftY4, null, null, null, page4, realcode.getSealCode(), realcode.getSealName());

                                }
                                if (opers.size() == 5) {
                                    SignatureUtil.addSignOfd(newfil, testpath2, LeftX1, LeftY1, null, null, null, page, realcode.getSealCode(), realcode.getSealName());
                                    SignatureUtil.addSignOfd(testpath2, testpath3, LeftX2, LeftY2, null, null, null, page2, realcode.getSealCode(), realcode.getSealName());
                                    SignatureUtil.addSignOfd(testpath3, testpath4, LeftX3, LeftY3, null, null, null, page3, realcode.getSealCode(), realcode.getSealName());

                                    SignatureUtil.addSignOfd(testpath4, testpath5, LeftX4, LeftY4, null, null, null, page4, realcode.getSealCode(), realcode.getSealName());
                                    SignatureUtil.addSignOfd(testpath5, newgzfil, RightX1, RightY1, null, null, null, page5, realcode.getSealCode(), realcode.getSealName());

                                }
                                if (opers.size() == 6) {
                                    SignatureUtil.addSignOfd(newfil, testpath2, LeftX1, LeftY1, null, null, null, page, realcode.getSealCode(), realcode.getSealName());
                                    SignatureUtil.addSignOfd(testpath2, testpath3, LeftX2, LeftY2, null, null, null, page2, realcode.getSealCode(), realcode.getSealName());
                                    SignatureUtil.addSignOfd(testpath3, testpath4, LeftX3, LeftY3, null, null, null, page3, realcode.getSealCode(), realcode.getSealName());

                                    SignatureUtil.addSignOfd(testpath4, testpath5, LeftX4, LeftY4, null, null, null, page4, realcode.getSealCode(), realcode.getSealName());

                                    SignatureUtil.addSignOfd(testpath5, testpath6, RightX1, RightY1, null, null, null, page5, realcode.getSealCode(), realcode.getSealName());
                                    SignatureUtil.addSignOfd(testpath6, newgzfil, RightX2, RightY2, null, null, null, page6, realcode.getSealCode(), realcode.getSealName());

                                }
                                if (opers.size() == 7) {
                                    SignatureUtil.addSignOfd(newfil, testpath2, LeftX1, LeftY1, null, null, null, page, realcode.getSealCode(), realcode.getSealName());
                                    SignatureUtil.addSignOfd(testpath2, testpath3, LeftX2, LeftY2, null, null, null, page2, realcode.getSealCode(), realcode.getSealName());
                                    SignatureUtil.addSignOfd(testpath3, testpath4, LeftX3, LeftY3, null, null, null, page3, realcode.getSealCode(), realcode.getSealName());

                                    SignatureUtil.addSignOfd(testpath4, testpath5, LeftX4, LeftY4, null, null, null, page4, realcode.getSealCode(), realcode.getSealName());

                                    SignatureUtil.addSignOfd(testpath5, testpath6, RightX1, RightY1, null, null, null, page5, realcode.getSealCode(), realcode.getSealName());
                                    SignatureUtil.addSignOfd(testpath6, testpath7, RightX2, RightY2, null, null, null, page6, realcode.getSealCode(), realcode.getSealName());
                                    SignatureUtil.addSignOfd(testpath7, newgzfil, RightX3, RightY3, null, null, null, page7, realcode.getSealCode(), realcode.getSealName());

                                }
                                if (opers.size() == 8) {
                                    SignatureUtil.addSignOfd(newfil, testpath2, LeftX1, LeftY1, null, null, null, page, realcode.getSealCode(), realcode.getSealName());
                                    SignatureUtil.addSignOfd(testpath2, testpath3, LeftX2, LeftY2, null, null, null, page2, realcode.getSealCode(), realcode.getSealName());
                                    SignatureUtil.addSignOfd(testpath3, testpath4, LeftX3, LeftY3, null, null, null, page3, realcode.getSealCode(), realcode.getSealName());
                                    SignatureUtil.addSignOfd(testpath4, testpath5, LeftX4, LeftY4, null, null, null, page4, realcode.getSealCode(), realcode.getSealName());

                                    SignatureUtil.addSignOfd(testpath5, testpath6, RightX1, RightY1, null, null, null, page5, realcode.getSealCode(), realcode.getSealName());
                                    SignatureUtil.addSignOfd(testpath6, testpath7, RightX2, RightY2, null, null, null, page6, realcode.getSealCode(), realcode.getSealName());
                                    SignatureUtil.addSignOfd(testpath7, testpath8, RightX3, RightY3, null, null, null, page7, realcode.getSealCode(), realcode.getSealName());
                                    SignatureUtil.addSignOfd(testpath8, newgzfil, RightX4, RightY4, null, null, null, page8, realcode.getSealCode(), realcode.getSealName());


                                }
                            } else {
                                SignatureUtil.addSignOfd(newfil, testpath2, LeftX1, LeftY1, null, null, null, page, realcode.getSealCode(), realcode.getSealName());
                                SignatureUtil.addSignOfd(testpath2, testpath3, LeftX2, LeftY2, null, null, null, page2, realcode.getSealCode(), realcode.getSealName());
                                SignatureUtil.addSignOfd(testpath3, testpath4, LeftX3, LeftY3, null, null, null, page3, realcode.getSealCode(), realcode.getSealName());
                                SignatureUtil.addSignOfd(testpath4, testpath5, LeftX4, LeftY4, null, null, null, page4, realcode.getSealCode(), realcode.getSealName());

                                SignatureUtil.addSignOfd(testpath5, testpath6, RightX1, RightY1, null, null, null, page5, realcode.getSealCode(), realcode.getSealName());
                                SignatureUtil.addSignOfd(testpath6, testpath7, RightX2, RightY2, null, null, null, page6, realcode.getSealCode(), realcode.getSealName());
                                SignatureUtil.addSignOfd(testpath7, testpath8, RightX3, RightY3, null, null, null, page7, realcode.getSealCode(), realcode.getSealName());
                                SignatureUtil.addSignOfd(testpath8, newgzfil, RightX4, RightY4, null, null, null, page8, realcode.getSealCode(), realcode.getSealName());
                            }    /*FileUtils.deleteFile(testpath);
                             FileUtils.deleteFile(testpath1);*/
                            /* FileUtils.deleteFile(testpath2);
                             FileUtils.deleteFile(testpath3);
                             FileUtils.deleteFile(testpath4);
                             FileUtils.deleteFile(testpath5);
                             FileUtils.deleteFile(testpath6);*/
                            AddAttach(certInfo.getId() + "_" + (1) + "_bgjl.ofd",certmode.getTemplateName(), attachurlroot + "/" + certInfo.getId() + "_" + timeStr + "_" + (1) + "_bgjl.ofd", certInfo.getId(), "1");
                            index++;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                    //还是左二右二
                    if (StringUtils.isNotBlank(certmode.getPblx()) && "4".equals(certmode.getPblx()) && type == null) {
                        //盖章  循环盖章  根据有多少变更记录 就盖多少次

                        String testpath1 = uploadpath + "/templd1.ofd";
                        String testpath2 = uploadpath + "/templd2.ofd";
                        String testpath3 = uploadpath + "/templd3.ofd";
                        String testpath4 = uploadpath + "/templd4.ofd";
                        int pagesize = size / 4;
                        String page = "";
                        int forpage = pagesize;
                        if (size % 4 != 0) {
                            forpage = pagesize + 1;
                        }
                        for (int i = 1; i <= forpage; i++) {
                            page += i + ",";
                        }
                        page = page.substring(0, page.length() - 1);
                        int i = size % 4;
                        String page2 = "";
                        String page3 = "";
                        String page4 = "";

                        if (i == 0) {
                            page2 = page;
                            page3 = page;
                            page4 = page;

                        }
                        if (i == 1) {
                            if (page.length() > 1) {
                                page2 = page.substring(0, page.length() - (String.valueOf(pagesize).length() + 1));

                            } else {
                                page2 = "1";
                            }
//                            page2 = page.substring(0, page.length() - (String.valueOf(pagesize).length() + 1));
//                            ;
                            page3 = page2;
                            page4 = page3;

                        }
                        if (i == 2) {
                            page2 = page;
                            if (page.length() > 1) {
                                page3 = page.substring(0, page.length() - (String.valueOf(pagesize).length() + 1));

                            } else {
                                page3 = "1";
                            }
                            // page3 = page.substring(0, page.length() - (String.valueOf(pagesize).length() + 1));
                            page4 = page3;

                        }
                        if (i == 3) {
                            page2 = page;
                            page3 = page;
                            if (page.length() > 1) {
                                page4 = page.substring(0, page.length() - (String.valueOf(pagesize).length() + 1));

                            } else {
                                page4 = "1";
                            }
                            //  page4 = page.substring(0, page.length() - (String.valueOf(pagesize).length() + 1));

                        }
                        String newgzfils = foldpath + "/" + certInfo.getId() + "_"
                                + timeStr + "_" + (2) + "_bgjl.ofd";//盖章路径
                        try {
                            if ("1".equals(page)) {
                                if (opers.size() == 1) {
                                    SignatureUtil.addSignOfd(newfil, newgzfils, LeftX1, LeftY1, null, null, null, page, realcode.getSealCode(), realcode.getSealName());

                                }
                                if (opers.size() == 2) {
                                    SignatureUtil.addSignOfd(newfil, testpath2, LeftX1, LeftY1, null, null, null, page, realcode.getSealCode(), realcode.getSealName());
                                    SignatureUtil.addSignOfd(testpath2, newgzfils, LeftX2, LeftY2, null, null, null, page2, realcode.getSealCode(), realcode.getSealName());


                                }
                                if (opers.size() == 3) {
                                    SignatureUtil.addSignOfd(newfil, testpath2, LeftX1, LeftY1, null, null, null, page, realcode.getSealCode(), realcode.getSealName());
                                    SignatureUtil.addSignOfd(testpath2, testpath3, LeftX2, LeftY2, null, null, null, page2, realcode.getSealCode(), realcode.getSealName());

                                    SignatureUtil.addSignOfd(testpath3, newgzfils, RightX1, RightY1, null, null, null, page3, realcode.getSealCode(), realcode.getSealName());

                                }
                                if (opers.size() == 4) {
                                    SignatureUtil.addSignOfd(newfil, testpath2, LeftX1, LeftY1, null, null, null, page, realcode.getSealCode(), realcode.getSealName());
                                    SignatureUtil.addSignOfd(testpath2, testpath3, LeftX2, LeftY2, null, null, null, page2, realcode.getSealCode(), realcode.getSealName());

                                    SignatureUtil.addSignOfd(testpath3, testpath4, RightX1, RightY1, null, null, null, page3, realcode.getSealCode(), realcode.getSealName());
                                    SignatureUtil.addSignOfd(testpath4, newgzfils, RightX2, RightY2, null, null, null, page4, realcode.getSealCode(), realcode.getSealName());

                                }

                            } else {

                                SignatureUtil.addSignOfd(newfil, testpath2, LeftX1, LeftY1, null, null, null, page, realcode.getSealCode(), realcode.getSealName());
                                SignatureUtil.addSignOfd(testpath2, testpath3, LeftX2, LeftY2, null, null, null, page2, realcode.getSealCode(), realcode.getSealName());

                                SignatureUtil.addSignOfd(testpath3, testpath4, RightX1, RightY1, null, null, null, page3, realcode.getSealCode(), realcode.getSealName());
                                SignatureUtil.addSignOfd(testpath4, newgzfils, RightX2, RightY2, null, null, null, page4, realcode.getSealCode(), realcode.getSealName());

                            }//  SignatureUtil.addSignOfd(testpath5, testpath6,LeftY3 ,LeftX3,  null, null, null, "0", null, null);
                            //   SignatureUtil.addSignOfd(testpath6, newgzfil,RightY3 ,RightX3,  null, null, null, "0", null, null);
                            /*FileUtils.deleteFile(testpath);
                            FileUtils.deleteFile(testpath1);*/
                   /*         FileUtils.deleteFile(testpath2);
                            FileUtils.deleteFile(testpath3);
                            FileUtils.deleteFile(testpath4);*/
                            AddAttach(certInfo.getId() + "_" + (2) + "_bgjl.ofd",certmode.getTemplateName(), attachurlroot + "/" + certInfo.getId() + "_"
                                    + timeStr + "_" + (2) + "_bgjl.ofd", certInfo.getId(), "1");
                            index++;

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (StringUtils.isNotBlank(certmode.getPblx()) && "3".equals(certmode.getPblx()) && type == null) {
                        //盖章  循环盖章  根据有多少变更记录 就盖多少次

                       /* String testpath1 = uploadpath + "/templd1.ofd";
                        String testpath2 = uploadpath + "/templd2.ofd";
                        String testpath3 = uploadpath + "/templd3.ofd";
                        String testpath4 = uploadpath + "/templd4.ofd";
                        int pagesize = size / 4;
                        String page = "";
                        int forpage = pagesize;
                        if (size % 4 != 0) {
                            forpage = pagesize + 1;
                        }
                        for (int i = 1; i <= forpage; i++) {
                            page += i + ",";
                        }
                        page = page.substring(0, page.length() - 1);
                        int i = size % 4;
                        String page2 = "";
                        String page3 = "";
                        String page4 = "";

                        if (i == 0) {
                            page2 = page;
                            page3 = page;
                            page4 = page;

                        }
                        if (i == 1) {
                            if (page.length() > 1) {
                                page2 = page.substring(0, page.length() - (String.valueOf(pagesize).length() + 1));

                            } else {
                                page2 = "1";
                            }
//                            page2 = page.substring(0, page.length() - (String.valueOf(pagesize).length() + 1));
//                            ;
                            page3 = page2;
                            page4 = page3;

                        }
                        if (i == 2) {
                            page2 = page;
                            if (page.length() > 1) {
                                page3 = page.substring(0, page.length() - (String.valueOf(pagesize).length() + 1));

                            } else {
                                page3 = "1";
                            }
                            // page3 = page.substring(0, page.length() - (String.valueOf(pagesize).length() + 1));
                            ;
                            ;
                            page4 = page3;

                        }
                        if (i == 3) {
                            page2 = page;
                            page3 = page;
                            if (page.length() > 1) {
                                page4 = page.substring(0, page.length() - (String.valueOf(pagesize).length() + 1));

                            } else {
                                page4 = "1";
                            }
                            //  page4 = page.substring(0, page.length() - (String.valueOf(pagesize).length() + 1));

                        }*/
                        String newgzfils = foldpath + "/" + certInfo.getId() + "_"
                                + timeStr + "_" + (2) + "_bgjl.ofd";//盖章路径
                        try {
                          /*  if ("1".equals(page)) {
                                if (opers.size() == 1) {
                                    SignatureUtil.addSignOfd(newfil, newgzfils, LeftX1, LeftY1, null, null, null, page, realcode.getSealCode(), realcode.getSealName());

                                }
                                if (opers.size() == 2) {
                                    SignatureUtil.addSignOfd(newfil, testpath2, LeftX1, LeftY1, null, null, null, page, realcode.getSealCode(), realcode.getSealName());
                                    SignatureUtil.addSignOfd(testpath2, newgzfils, LeftX2, LeftY2, null, null, null, page2, realcode.getSealCode(), realcode.getSealName());


                                }
                                if (opers.size() == 3) {
                                    SignatureUtil.addSignOfd(newfil, testpath2, LeftX1, LeftY1, null, null, null, page, realcode.getSealCode(), realcode.getSealName());
                                    SignatureUtil.addSignOfd(testpath2, testpath3, LeftX2, LeftY2, null, null, null, page2, realcode.getSealCode(), realcode.getSealName());

                                    SignatureUtil.addSignOfd(testpath3, newgzfils, RightX1, RightY1, null, null, null, page3, realcode.getSealCode(), realcode.getSealName());

                                }
                                if (opers.size() == 4) {
                                    SignatureUtil.addSignOfd(newfil, testpath2, LeftX1, LeftY1, null, null, null, page, realcode.getSealCode(), realcode.getSealName());
                                    SignatureUtil.addSignOfd(testpath2, testpath3, LeftX2, LeftY2, null, null, null, page2, realcode.getSealCode(), realcode.getSealName());

                                    SignatureUtil.addSignOfd(testpath3, testpath4, RightX1, RightY1, null, null, null, page3, realcode.getSealCode(), realcode.getSealName());
                                    SignatureUtil.addSignOfd(testpath4, newgzfils, RightX2, RightY2, null, null, null, page4, realcode.getSealCode(), realcode.getSealName());

                                }

                            } else {

                                SignatureUtil.addSignOfd(newfil, testpath2, LeftX1, LeftY1, null, null, null, page, realcode.getSealCode(), realcode.getSealName());
                                SignatureUtil.addSignOfd(testpath2, testpath3, LeftX2, LeftY2, null, null, null, page2, realcode.getSealCode(), realcode.getSealName());

                                SignatureUtil.addSignOfd(testpath3, testpath4, RightX1, RightY1, null, null, null, page3, realcode.getSealCode(), realcode.getSealName());
                                SignatureUtil.addSignOfd(testpath4, newgzfils, RightX2, RightY2, null, null, null, page4, realcode.getSealCode(), realcode.getSealName());

                            }*///  SignatureUtil.addSignOfd(testpath5, testpath6,LeftY3 ,LeftX3,  null, null, null, "0", null, null);
                            //   SignatureUtil.addSignOfd(testpath6, newgzfil,RightY3 ,RightX3,  null, null, null, "0", null, null);
                            /*FileUtils.deleteFile(testpath);
                            FileUtils.deleteFile(testpath1);*/
                   /*         FileUtils.deleteFile(testpath2);
                            FileUtils.deleteFile(testpath3);
                            FileUtils.deleteFile(testpath4);*/
                            SignatureUtil.addSignOfd(newfil, newgzfils, LeftX1, LeftY1, null, null, null, "0", realcode.getSealCode(), realcode.getSealName());

                            AddAttach(certInfo.getId() + "_" + (2) + "_bgjl.ofd", certmode.getTemplateName(), attachurlroot + "/" + certInfo.getId() + "_"
                                    + timeStr + "_" + (2) + "_bgjl.ofd", certInfo.getId(), "1");
                            index++;

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                //判断是否完成起码四个步骤的盖章


            }
            //盖章成功 之后的操作======================================================
            // 1将所有有效的操作记录且未盖章的 更改盖章状态
            if (type == null || type.length == 0) {
                LambdaQueryWrapper<CertInfoOperationRecord> query = new LambdaQueryWrapper<>();
                query.eq(CertInfoOperationRecord::getZsid,certInfo.getId());
                query.eq(CertInfoOperationRecord::getStutas,"20");
                query.and(q -> q.isNull(CertInfoOperationRecord::getGzstutas).or().ne(CertInfoOperationRecord::getGzstutas, "1"));
                List<CertInfoOperationRecord> list = certInfoOperationRecordService.list(query);
                for (CertInfoOperationRecord cert : list
                ) {
                    //已盖章
                    cert.setGzstutas("1");
                    //盖章时间
                    cert.setGztime(new Date());
                    certInfoOperationRecordService.updateById(cert);


                }
            }
            //2如果是换发 且盖章
            if ("2".equals(certInfo.getZszt()) && certInfo.getIsxt() == null) {
                //盖章 才失效
                if ((type == null || type.length == 0)) {
                    QueryWrapper queryWrapperrecod1 = new QueryWrapper();
                    queryWrapperrecod1.eq("zsid", certInfo.getId());
                    List<CertInfoOperationRecord> list1 = certInfoOperationRecordService.list(queryWrapperrecod1);
                    for (CertInfoOperationRecord cert : list1
                    ) {
                        //除了换发，所有的操作类型设为失效
                        if (!"2".equals(cert.getBglx())) {
                            cert.setStutas("0");
                            certInfoOperationRecordService.updateById(cert);
                        }

                    }
                }
            }


            if ((type == null || type.length == 0) && certInfo != null) {
                //结果表数据
                certInfo.setZt("4");
                certInfo.setCzzt("zc");
                certInfo.setGztime(new Date());
                CertInfo byZsid = getByZsid(certInfo.getZsid());
                if(byZsid==null)
                {
                    saveMain(certInfo, zsDtozb.getCertchildYpscZcList(), zsDtozb.getCertchildYpscWtList(), zsDtozb.getCertchildYpscStList(),
                            zsDtozb.getCertchildCkomylyList(), zsDtozb.getCertchildMzyphjsypddscList(), zsDtozb.getCertchildYlqxcpckxsList(),
                            zsDtozb.getCertchildYlqxscbaZbList(), zsDtozb.getCertchildYlqxwtbaZbList(), zsDtozb.getCertchildYpckxkzList(),
                            zsDtozb.getCertchildYpckxszmList(), zsDtozb.getCertchildDylylqxscbapzList(), zsDtozb.getCertchildYlqxwlxsbaList()
                            , zsDtozb.getCertchirdYlqxlcsybaList());

                }
                else{
                    updateMain(certInfo, zsDtozb.getCertchildYpscZcList(), zsDtozb.getCertchildYpscWtList(), zsDtozb.getCertchildYpscStList(),
                            zsDtozb.getCertchildCkomylyList(), zsDtozb.getCertchildMzyphjsypddscList(), zsDtozb.getCertchildYlqxcpckxsList(),
                            zsDtozb.getCertchildYlqxscbaZbList(), zsDtozb.getCertchildYlqxwtbaZbList(), zsDtozb.getCertchildYpckxkzList(),
                            zsDtozb.getCertchildYpckxszmList(), zsDtozb.getCertchildDylylqxscbapzList(), zsDtozb.getCertchildYlqxwlxsbaList()
                            , zsDtozb.getCertchirdYlqxlcsybaList());
                }
                //未盖章数据设置为已盖章 且失效
                byId.setZt("4");
                byId.setYxzt("99");
                byId.setCzzt("zc");
                byId.setGztime(new Date());
                iZsYwxxbService.updateById(byId);
                //==========推送结果数据

                certInfo.setSjtbXzsp("0");
                if (YwConstant.JLLY_SSCJ.equals(certInfo.getJsly())) {
                    certInfo.setSjtbSscj(String.valueOf(YwConstant.CONFIRM));
                }
                updateById(certInfo);

                //审批数据回退
//                if("sp".equals(certInfo.getJsly()))
//                {    //
//                    String mianid="";
//                    //主表
//                   TYwZsN tYwZsLsN=new TYwZsN();
//                    if("3".equals(certtype.getZslx())&&("26".equals(certtype.getZslx())||"3".equals(certtype.getZslx())))
//                    {
//                        //二类证推送的是 最新的数据；
//                        BeanUtils.copyProperties(byId, tYwZsLsN);
//                        mianid=byId.getZsid();
//                        tYwZsLsN.setCp(byId.getChanping());
//                        tYwZsLsN.setGg(byId.getGuige());
//                        tYwZsLsN.setCs(byId.getChaosong());
//
//                    }
//                    else {
//                        BeanUtils.copyProperties(certInfo, tYwZsLsN);
//                        mianid=certInfo.getZsid();
//                        tYwZsLsN.setCp(certInfo.getChanping());
//                        tYwZsLsN.setGg(certInfo.getGuige());
//                        tYwZsLsN.setCs(certInfo.getChaosong());
//
//                    }
//                    tYwZsLsN.setJsly("99");
//                    tYwZsLsN.setZt("0");
//                    tYwZsLsN.setId(mianid);
//                    QueryWrapper queryWrappercx=new QueryWrapper();
//                    queryWrappercx.eq("id",mianid);
//
//                    List<TYwZsN> one = itYwZsNService.list(queryWrappercx);
//                    if(one==null||one.size()==0)
//                    {
//                        itYwZsNService.save(tYwZsLsN);
//
//                    }
//                    else {
//                        itYwZsNService.updateById(tYwZsLsN);
//                    }
//                    QueryWrapper queryWrapperzbgz=new QueryWrapper();
//                    queryWrapperzbgz.eq("zsid",certInfo.getZsid());
//                    queryWrapperzbgz.eq("xzspid",certInfo.getId());
//                    queryWrapperzbgz.eq("zt","4");
//                    //网络销售备案
//                    List<CertchildYlqxwlxsba> certchildYlqxwlxsbas = certchildYlqxwlxsbaMapper.selectList(queryWrapperzbgz);
//                    for (CertchildYlqxwlxsba cert:certchildYlqxwlxsbas
//                         ) {
//                        BaQxwlxsbaZbLs2 Ls2=new BaQxwlxsbaZbLs2();
//                        BeanUtils.copyProperties(cert,Ls2);
//                        iBaQxwlxsbaZbLs2Service.save(Ls2);
//
//                    }
//                    List<CertchildCkomyly> ckom = certchildCkomylyMapper.selectList(queryWrapperzbgz);
//                    for (CertchildCkomyly cert:ckom
//                    ) {
//                        TJcZsCkomylyZbLs2 Ls2=new TJcZsCkomylyZbLs2();
//                        BeanUtils.copyProperties(cert,Ls2);
//                        Ls2.setZt(1);
//                        itJcZsCkomylyZbLs2Service.save(Ls2);
//
//                    }
//                    List<CertchildDylylqxscbapz> dyl = certchildDylylqxscbapzMapper.selectList(queryWrapperzbgz);
//                    for (CertchildDylylqxscbapz cert:dyl
//                    ) {
//                        TJcZsDylylqxscbapzZbLs2 Ls2=new TJcZsDylylqxscbapzZbLs2();
//                        BeanUtils.copyProperties(cert,Ls2);
//                        Ls2.setZt(BigDecimal.valueOf(1));
//                        itJcZsDylylqxscbapzZbLs2Service.save(Ls2);
//
//                    }
//                    List<CertchildMzyphjsypddsc> mzyp = certchildMzyphjsypddscMapper.selectList(queryWrapperzbgz);
//                    for (CertchildMzyphjsypddsc cert:mzyp
//                    ) {
//                        TJcZsMzyphjsypddscpjZbLs2 Ls2=new TJcZsMzyphjsypddscpjZbLs2();
//                        BeanUtils.copyProperties(cert,Ls2);
//                        Ls2.setZt(1);
//                        itJcZsMzyphjsypddscpjZbLs2Service.save(Ls2);
//
//                    }
//                    List<CertchildYlqxcpckxs> qxck = certchildYlqxcpckxsMapper.selectList(queryWrapperzbgz);
//                    for (CertchildYlqxcpckxs cert:qxck
//                    ) {
//                        TJcZsYlqxcpckxszmZbLs2 Ls2=new TJcZsYlqxcpckxszmZbLs2();
//                        BeanUtils.copyProperties(cert,Ls2);
//                        Ls2.setZt(1);
//                        itJcZsYlqxcpckxszmZbLs2Service.save(Ls2);
//
//                    }
//                    List<CertchirdYlqxlcsyba> lcsyba = certchirdYlqxlcsybaMapper.selectList(queryWrapperzbgz);
//                    for (CertchirdYlqxlcsyba cert:lcsyba
//                    ) {
//                        TJcZsYlqxlcsybaZbLs2 Ls2=new TJcZsYlqxlcsybaZbLs2();
//                        BeanUtils.copyProperties(cert,Ls2);
//                        Ls2.setZt(1);
//                        itJcZsYlqxlcsybaZbLs2Service.save(Ls2);
//
//                    }
//                    List<CertchildYlqxscbaZb> syba =certchildYlqxscbaZbMapper .selectList(queryWrapperzbgz);
//                    for (CertchildYlqxscbaZb cert:syba
//                    ) {
//                        TJcZsYlqxscbaZbLs2 Ls2=new TJcZsYlqxscbaZbLs2();
//                        BeanUtils.copyProperties(cert,Ls2);
//                        Ls2.setZt(1);
//                        itJcZsYlqxscbaZbLs2Service.save(Ls2);
//
//                    }
//                    List<CertchildYlqxwtbaZb> qxwtba =certchildYlqxwtbaZbMapper .selectList(queryWrapperzbgz);
//                    for (CertchildYlqxwtbaZb cert:qxwtba
//                    ) {
//                        TJcZsYlqxwtscbaZbLs2 Ls2=new TJcZsYlqxwtscbaZbLs2();
//                        BeanUtils.copyProperties(cert,Ls2);
//                        Ls2.setZt(1);
//                        itJcZsYlqxwtscbaZbLs2Service.save(Ls2);
//
//                    }
//                    List<CertchildYpckxszm> ckxszm =certchildYpckxszmMapper .selectList(queryWrapperzbgz);
//                    for (CertchildYpckxszm cert:ckxszm
//                    ) {
//                        TJcZsYpckxszmZbLs2 Ls2=new TJcZsYpckxszmZbLs2();
//                        BeanUtils.copyProperties(cert,Ls2);
//                        Ls2.setZt(1);
//                        itJcZsYpckxszmZbLs2Service.save(Ls2);
//
//                    }
//                    List<CertchildYpckxkz> zkz =certchildYpckxkzMapper .selectList(queryWrapperzbgz);
//                    for (CertchildYpckxkz cert:zkz
//                    ) {
//                        TJcZsYpckzxzZbLs2 Ls2=new TJcZsYpckzxzZbLs2();
//                        BeanUtils.copyProperties(cert,Ls2);
//                        Ls2.setZt(1);
//                        itJcZsYpckzxzZbLs2Service.save(Ls2);
//
//                    }
//                    //gmp暂时取消
//                 /*   List<CertchildYpscGmp> gmp =certchildYpscGmpMapper .selectList(queryWrapperzbgz);
//                    for ( CertchildYpscGmp cert:gmp
//                    ) {
//                        TJcZsYpscxkGmpLs2 Ls2=new TJcZsYpscxkGmpLs2();
//                        BeanUtils.copyProperties(cert,Ls2);
//                        Ls2.setZt(String.valueOf(1));
//                        itJcZsYpscxkGmpLs2Service.save(Ls2);
//
//                    }*/
//                    List<CertchildYpscSt> st =certchildYpscStMapper .selectList(queryWrapperzbgz);
//                    for ( CertchildYpscSt cert:st
//                    ) {
//                        TJcZsYpscxkStLs2 Ls2=new TJcZsYpscxkStLs2();
//                        BeanUtils.copyProperties(cert,Ls2);
//                        Ls2.setZt(String.valueOf(1));
//                        Ls2.setProductionscopef(cert.getProductionscopeF());
//                        Ls2.setGzrq(DateUtils.parseDate(cert.getGztime(), YwConstant.YMDHMS));
//                        Ls2.setGgflag(cert.getGghjstatus());
//                        itJcZsYpscxkStLs2Service.save(Ls2);
//
//                    }
//                    List<CertchildYpscWt> wt =certchildYpscWtMapper .selectList(queryWrapperzbgz);
//                    for ( CertchildYpscWt cert:wt
//                    ) {
//                        TJcZsYpscxkWtLs2 Ls2=new TJcZsYpscxkWtLs2();
//                        BeanUtils.copyProperties(cert,Ls2);
//                        Ls2.setZt(String.valueOf(1));
//                        Ls2.setProductionscopef(cert.getProductionscopeF());
//                        Ls2.setGzrq(DateUtils.parseDate(cert.getGztime(), YwConstant.YMDHMS));
//                        Ls2.setGgflag(cert.getGghjstatus());
//
//                        itJcZsYpscxkWtLs2Service.save(Ls2);
//
//                    }
//                    List<CertchildYpscZc> zc =certchildYpscZcMapper .selectList(queryWrapperzbgz);
//                    for ( CertchildYpscZc cert:zc
//                    ) {
//                        TJcZsYpscxkZcLs2 Ls2=new TJcZsYpscxkZcLs2();
//                        BeanUtils.copyProperties(cert,Ls2);
//                        Ls2.setProductionscopef(cert.getProductionscopeF());
//                        Ls2.setZt(String.valueOf(1));
//                        Ls2.setGzrq(DateUtils.parseDate(cert.getGztime(), YwConstant.YMDHMS));
//                        Ls2.setGgflag(cert.getGghjstatus());
//
//
//                        itJcZsYpscxkZcLs2Service.save(Ls2);
//
//                    }
//                    certInfo.setSjtbXzsp("1");
//                    updateById(certInfo);
//                    // 子表
//
//                }

               /* return "盖章成功";*/
            }
        }
       if(type==null)
       {
           return "盖章成功";
       }
        return "生成证照成功";
    }

    @Override
    public Attachinfo getAttachByCertid(String id, String certmodetype, String isgz) {
        Attachinfo attachByCertid1 = certInfoMapper.getAttachByCertid(id, certmodetype, isgz);


        return attachByCertid1;
    }


    @Override
    @Transactional
    public String huanzheng(CertInfo certInfo, CertInfoPage certInfoPage) {
        CertInfo oldCertInfo = getById(certInfo.getId());
        if (null == oldCertInfo) {
            return "换证失败，未找到对应数据";
        }
        CertInfo newcertinfo = oldCertInfo;
        oldCertInfo.setYxzt("99");
        super.updateById(oldCertInfo);
        newcertinfo.setId(UUID.randomUUID().toString());
        newcertinfo.setYxzt("10");
        newcertinfo.setId(oldCertInfo.getId());
        newcertinfo.setZt("3");
        newcertinfo.setIsxt("1");//系统操作数据
        newcertinfo.setZszt("2");
/*
        certInfoMapper.insert(newcertinfo);
*/
        ZsYwxxb zsYwxxb=new ZsYwxxb();
        BeanUtils.copyProperties(certInfoPage,zsYwxxb);
        ZsYwxxb byId = iZsYwxxbService.getById(certInfoPage.getId());
        zsYwxxb.setYxzt("10");
        zsYwxxb.setId(oldCertInfo.getId());
        zsYwxxb.setZt("3");
        zsYwxxb.setIsxt("1");//系统操作数据
        zsYwxxb.setZszt("2");
        CertInfo oldcert = getById(certInfo.getId());

        zsYwxxb.setZsid(oldcert.getZsid());
        if(byId!=null)
        {  if("3".equals(byId.getZt())&&"10".equals(byId.getYxzt()))
        {
            return "error";

        }
        else{
            iZsYwxxbService.updateById(zsYwxxb);
        }
        }
        else{
            zsYwxxbMapper.insert(zsYwxxb);
        }
/*
        zsYwxxb.setId(UUID.randomUUID().toString());
*/

        mainOperationRecord(certInfo, newcertinfo, "换证", certInfoPage);

        certInfo.setZsid(oldcert.getZsid());
        if (certInfoPage.getCertchildYpscZcList() != null && certInfoPage.getCertchildYpscZcList().size() > 0) {
            for (CertchildYpscZc entity : certInfoPage.getCertchildYpscZcList()) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                certchildYpscZcMapper.updateById(entity);
            }
        }
        if (certInfoPage.getCertchildYpscWtList() != null && certInfoPage.getCertchildYpscWtList().size() > 0) {
            for (CertchildYpscWt entity : certInfoPage.getCertchildYpscWtList()) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                certchildYpscWtMapper.updateById(entity);
            }
        }
        if (certInfoPage.getCertchildYpscStList() != null && certInfoPage.getCertchildYpscStList().size() > 0) {
            for (CertchildYpscSt entity : certInfoPage.getCertchildYpscStList()) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                certchildYpscStMapper.updateById(entity);
            }
        }
        //换证取消之前所有变更记录
       /* LambdaQueryWrapper<CertInfoOperationRecord> lqw=new LambdaQueryWrapper();
        lqw.eq(CertInfoOperationRecord::getZsid,oldCertInfo.getId());
        lqw.orderByDesc(CertInfoOperationRecord::getCreateTime);
        List<CertInfoOperationRecord> list=certInfoOperationRecordService.list(lqw);
        if(list.size()>0){
            CertInfoOperationRecord certInfoOperationRecord=list.get(0);
            certInfoOperationRecord.setZsid(certInfo.getId());
            certInfoOperationRecordService.updateById(certInfoOperationRecord);
            LambdaQueryWrapper<CertInfoOperationDetail> queryWrapper=new LambdaQueryWrapper();
            queryWrapper.eq(CertInfoOperationDetail::getZsczjl,certInfoOperationRecord.getId());
            List<CertInfoOperationDetail> details=certInfoOperationDetailService.list(queryWrapper);
            if(details.size()>0){
                for (CertInfoOperationDetail detail :
                        details) {
                    detail.setZsid(certInfo.getId());
                    certInfoOperationDetailService.updateById(detail);
                }
            }

        }else {
            return "换证失败";
        }*/
        return null;
    }

    @Override
    @Transactional
    public String bianGeng(CertInfo certInfo, CertInfoPage certInfoPage) {
        CertInfo byId1 = getById(certInfoPage.getId());
        ZsYwxxb byId = iZsYwxxbService.getByZsid(byId1.getZsid());
        if (byId != null && YwConstant.GZ_SCZT_WGZ.equals(byId.getZt()) && YwlxEnum.BIANGE.getCode().equals(byId.getZszt())
                && YwConstant.ZSZT_YX.equals(byId.getYxzt())) {
            return "未盖章中存在相同证书编号待盖章数据，不能进行变更";
        }

        String s = mainOperationRecord(certInfo, null, "变更", certInfoPage);
         if (byId==null) {
             byId=new ZsYwxxb();
             BeanUtils.copyProperties(certInfoPage,byId);
             ZsYwxxb byId2 = iZsYwxxbService.getById(byId.getId());
             if(byId2!=null)
             {
                 iZsYwxxbService.updateById(byId2);
             }
             else {
                 iZsYwxxbService.save(byId);
             }
         }
        BeanUtils.copyProperties(certInfoPage,byId);
        byId.setZszt("3");
        byId.setZt("3");
        byId.setIsxt("1");
        byId.setZsid(byId1.getZsid());

        if (StringUtils.isBlank(s)) {
            iZsYwxxbService.updateMain(byId, certInfoPage.getCertchildYpscZcList(), certInfoPage.getCertchildYpscWtList(), certInfoPage.getCertchildYpscStList(),
                    certInfoPage.getCertchildCkomylyList(), certInfoPage.getCertchildMzyphjsypddscList(), certInfoPage.getCertchildYlqxcpckxsList(),
                    certInfoPage.getCertchildYlqxscbaZbList(), certInfoPage.getCertchildYlqxwtbaZbList(), certInfoPage.getCertchildYpckxkzList(),
                    certInfoPage.getCertchildYpckxszmList(), certInfoPage.getCertchildDylylqxscbapzList(), certInfoPage.getCertchildYlqxwlxsbaList()
                    , certInfoPage.getCertchirdYlqxlcsybaList()
            );
        }
        return null;
    }

    @Override
    public List<CerttypeRole> getCertlistByrole(String certtypeid, List<String> roleids) {
        StringBuffer sql = new StringBuffer();

        for (String roleid : roleids
        ) {
            sql.append(roleid + ",");
        }
        String substring = sql.toString().substring(0, sql.length() - 1);
        List<CerttypeRole> certroles = certInfoMapper.getCertroles(certtypeid, substring);
        return certroles;
    }

    @Override
    public CertZminfo getzminfodata(String id) {
        return certInfoMapper.getzminfodata(id);
    }

    @Override
    public IPage<ZsYwxxb> selectAll(String sql, String weiba) {
        String sql2 = "";
        sql2 = sql;
        int i = certInfoMapper.countselectAll(sql, sql2);
        List<ZsYwxxb> zsYwxxbs = 0 < i ? certInfoMapper.selectAll(sql, sql2, weiba) : new ArrayList<>();
        IPage<ZsYwxxb> iPage = new Page<>();
        iPage.setTotal(i);
        iPage.setRecords(zsYwxxbs);
        return iPage;
    }

    @Override
    public int countselectAll(String sql, String sql2) {
        return certInfoMapper.countselectAll(sql, sql2);
    }

    @Override
    public String weihu(CertInfoPage certInfoPage) {
        // 通过 certInfoPage.zt 来判断是盖章还是未盖章
        CertInfo certInfo = new CertInfo();
        org.springframework.beans.BeanUtils.copyProperties(certInfoPage, certInfo);
        ZsYwxxb zsYwxxb = new ZsYwxxb();
        org.springframework.beans.BeanUtils.copyProperties(certInfoPage, zsYwxxb);
        //维护中的数据 变更zsid用于维护时的展示
        zsYwxxb.setZsid(UUID.randomUUID().toString());
        certInfo.setZsid(UUID.randomUUID().toString());
        //维护前未盖章数据
        ZsYwxxb zsYwxxbold = null;
        //维护前已盖章数据
        CertInfo certInfoold = null;
        //维护产生的操作记录
        CertInfoOperationRecord record = new CertInfoOperationRecord();
        record.setId(UUID.randomUUID().toString());
        zsYwxxbold = iZsYwxxbService.getById(certInfoPage.getId());
        //判断是 未盖章   zt=3 yxzt=10 就存在有效数据
        if (zsYwxxbold == null || !("3".equals(zsYwxxbold.getZt()) && "10".equals(zsYwxxbold.getYxzt()))) {
            // 已盖章数据
            certInfoold = getById(certInfoPage.getId());
            if (certInfoold == null) {
                return "未找到对应数据";
            } else {
                record.setZsid(certInfo.getZsid());
            }
        }
        //只有zt=3 yxzt=10 的时候才会到这里

        else if ("3".equals(zsYwxxbold.getZt()) && "10".equals(zsYwxxbold.getYxzt())) {
            //未盖章数据 判断是否存在已盖章数据
            String yxzt = zsYwxxb.getYxzt();
            certInfoold = getById(certInfoPage.getId());
            if (certInfoold != null && "4".equals(certInfoold.getZt()) && certInfoPage.getZt() == 4) {
                return "未盖章中存在相同证书编号未盖章数据，不能进行维护";
            }
            record.setZsid(zsYwxxb.getZsid());
        }
        //已盖章数据维护，如果未盖章存在相同编号有效数据，则不能维护
        if (certInfoold != null) {
            QueryWrapper<ZsYwxxb> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("zsbh", certInfoold.getZsbh());
            queryWrapper.eq("zt", "3");
            queryWrapper.eq("yxzt", "10");
            List<ZsYwxxb> list = iZsYwxxbService.list(queryWrapper);
            if (CollectionUtils.isNotEmpty(list)) {
                return "未盖章中存在相同证书编号待盖章数据，不能进行维护";
            }
        }
        //新增变更记录
        record.setCzsj(new Date());
        record.setOperateNo("0");
        record.setYwlx("7");
        record.setCzrxm(certInfoPage.getBgr());
        record.setBgyy(certInfoPage.getBgyy());
        record.setGzstutas("0");
        record.setStutas("20");
        // 7 维护
        record.setBglx("7");
        record.setWhr(certInfoPage.getWhr());
        record.setWhyy(certInfoPage.getWhyy());
        record.setFj(certInfoPage.getFj());
        certInfoOperationRecordService.save(record);
        //证书操作记录 模板
        StringBuffer certinfoChange = new StringBuffer();
        String changeText = "fieldName由【oldValue】变更为【newValue】;";
        //=========================================子表批量处理
        String changeText_zs = "自产子表：fieldName由【oldValue】变更为【newValue】,数据序号为【num】;";
        String changeText_ws = "委托子表：fieldName由【oldValue】变更为【newValue】,数据序号为【num】;";
        String changeText_st = "受托子表：fieldName由【oldValue】变更为【newValue】,数据序号为【num】;";

        int addZcNum = 0;
        int addwtNum = 0;
        int addstNum = 0;
        StringBuffer ypscSB = new StringBuffer();
        for (CertchildYpscZc zc : certInfoPage.getCertchildYpscZcList()==null?new ArrayList<CertchildYpscZc>(): certInfoPage.getCertchildYpscZcList()
        ) {
            QueryWrapper queryWrapper=new QueryWrapper();
            queryWrapper.eq("id",zc.getId());
            CertchildYpscZc oldZc = certchildYpscZcMapper.selectOne(queryWrapper);
            if (null == oldZc) {
                addZcNum++;
            } else {
                StringBuffer sb = getChangeField(zc, oldZc, CertchildYpscZc.class, record, changeText_zs);
                if (null != sb) {
                    ypscSB.append(sb);
                }
            }
        }
        if (addZcNum > 0) {
            ypscSB.append("自产子表：").append("新增").append(addZcNum).append("条数据;");
        }
        for (CertchildYpscWt wt : certInfoPage.getCertchildYpscWtList() ==null?new ArrayList<CertchildYpscWt>(): certInfoPage.getCertchildYpscWtList()
        ) {
            CertchildYpscWt oldWt = certchildYpscWtMapper.selectById(wt.getId());
            if (null == oldWt) {
                addwtNum++;
            } else {
                StringBuffer sb = getChangeField(wt, oldWt, CertchildYpscWt.class, record, changeText_ws);
                if (null != sb) {
                    ypscSB.append(sb);
                }
            }
        }
        if (addwtNum > 0) {
            ypscSB.append("委托子表：").append("新增").append(addwtNum).append("条数据;");
        }
        for (CertchildYpscSt st : certInfoPage.getCertchildYpscStList()==null?new ArrayList<CertchildYpscSt>(): certInfoPage.getCertchildYpscStList()
        ) {
            CertchildYpscSt oldSt = certchildYpscStMapper.selectById(st.getId());
            if (null == oldSt) {
                addstNum++;
            } else {
                StringBuffer sb = getChangeField(st, oldSt, CertchildYpscSt.class, record, changeText_st);
                if (null != sb) {
                    ypscSB.append(sb);
                }
            }
        }
        if (addstNum > 0) {
            ypscSB.append("受托子表：").append("新增").append(addstNum).append("条数据;");
        }
        //子表操作记录（删除）
        int delNum_zc = 0;
        int delNum_wt = 0;
        int delNum_st = 0;
        List<CertchildYpscZc> zcList = certchildYpscZcMapper.selectByMainId(certInfo.getZsid(),certInfo.getId());
        List<CertchildYpscWt> wtList = certchildYpscWtMapper.selectByMainId(certInfo.getZsid(),certInfo.getId());
        List<CertchildYpscSt> stList = certchildYpscStMapper.selectByMainId(certInfo.getZsid(),certInfo.getId());
        for (CertchildYpscZc zc : zcList
        ) {
            Boolean isdel = true;
            for (CertchildYpscZc newZc : certInfoPage.getCertchildYpscZcList()==null?new ArrayList<CertchildYpscZc>(): certInfoPage.getCertchildYpscZcList()) {
                if (zc.getId().equals(newZc.getId())) {
                    isdel = false;
                }
            }
            if (isdel) {
                delNum_zc++;
            }
        }
        if (delNum_zc > 0) {
            ypscSB.append("自产子表：").append("删除").append(delNum_zc).append("条数据;");
        }
        for (CertchildYpscWt wt : wtList
        ) {
            Boolean isdel = true;
            for (CertchildYpscWt newWt : certInfoPage.getCertchildYpscWtList()==null?new ArrayList<CertchildYpscWt>(): certInfoPage.getCertchildYpscWtList()) {
                if (wt.getId().equals(newWt.getId())) {
                    isdel = false;
                }
            }
            if (isdel) {
                delNum_wt++;
            }
        }
        if (delNum_wt > 0) {
            ypscSB.append("自产子表：").append("删除").append(delNum_wt).append("条数据;");
        }
        for (CertchildYpscSt st : stList
        ) {
            Boolean isdel = true;
            for (CertchildYpscSt newSt : certInfoPage.getCertchildYpscStList()==null?new ArrayList<CertchildYpscSt>(): certInfoPage.getCertchildYpscStList()) {
                if (st.getId().equals(newSt.getId())) {
                    isdel = false;
                }
            }
            if (isdel) {
                delNum_st++;
            }
        }
        if (delNum_st > 0) {
            ypscSB.append("自产子表：").append("删除").append(delNum_st).append("条数据;");
        }
        if (ypscSB.length() > 0) {
            certinfoChange.append(ypscSB);
        }

        // 这样判断是防止 同编号 已盖章以及未盖章都有数据的情况下 如何区分当前维护数据是 已盖章还是未盖章
        if (zsYwxxbold != null && "3".equals(zsYwxxbold.getZt()) && "10".equals(zsYwxxbold.getYxzt())&&certInfoPage.getZt() == 3) {
            certinfoChange .append( getChangeField(zsYwxxb, zsYwxxbold, ZsYwxxb.class, record, changeText));
            zsYwxxb.setWhid(zsYwxxbold.getId());
            zsYwxxb.setId(UUID.randomUUID().toString());
            zsYwxxb.setZt("3");
            zsYwxxb.setYxzt("99");
            QueryWrapper queryWrapper1 = new QueryWrapper();
            queryWrapper1.eq("whid", zsYwxxb.getId());
            List<ZsYwxxb> list = iZsYwxxbService.list(queryWrapper1);
            if (list != null && list.size() > 0) {
                return "已存在未审核维护数据！";
            }
            //申请维护
            zsYwxxbold.setCzzt("sqwh");
            zsYwxxbold.setIswh("1");
            iZsYwxxbService.updateById(zsYwxxbold);
            //保存主表以及子表
            SaveWeiHuDateForZsywxxb(certInfoPage, zsYwxxb);
            //处理操作记录
            certinfoChange.append( ChuLiCZJL(zsYwxxb.getZsid(),certInfoPage.getCertoperationrecord()));
        }
        if (certInfoold != null&&certInfoPage.getZt() == 3) {
            //保留维护前数据
            CertInfo certInfo1 = new CertInfo();
            BeanUtils.copyProperties(certInfoold, certInfo1);
            //该方法调用之后会改变 维护前数据
            certinfoChange .append( getChangeField(certInfo, certInfoold, CertInfo.class, record, changeText));
            certInfo.setWhid(certInfoold.getId());
            certInfo.setId(UUID.randomUUID().toString());
            certInfo.setZt("4");
            certInfo.setYxzt("99");
            QueryWrapper queryWrapper1 = new QueryWrapper();
            queryWrapper1.eq("whid", zsYwxxb.getId());
            List<CertInfo> list = list(queryWrapper1);
            if (list != null && list.size() > 0) {
                return "已存在未审核维护数据！";
            }
            //申请维护
            certInfo1.setCzzt("sqwh");
            certInfo1.setIswh("1");
            updateById(certInfo1);
            SaveWeiHuDateForCertinfo(certInfoPage, certInfo);
            certinfoChange.append( ChuLiCZJL(certInfo.getZsid(), certInfoPage.getCertoperationrecord()));
        }

        if (certinfoChange.length() > 0) {
            record.setBgnr(certinfoChange.toString());
            certInfoOperationRecordService.updateById(record);
        } else {
            certInfoOperationRecordService.removeById(record);
            return "本次维护数据未发生变动！";
        }
        return "维护申请成功！请等待审核结果";
    }
    @Override
    public String Back(CertInfoPage certInfoPage)
    {

        //删掉维护中的数据
        if (certInfoPage.getZt()==3) {
            ZsYwxxb byId = iZsYwxxbService.getById(certInfoPage.getId());

            certchildYpscZcMapper.deleteByMainId(byId.getZsid(),byId.getId(),"3");
            certchildYpscWtMapper.deleteByMainId(byId.getZsid(),byId.getId(),"3");
            certchildYpscStMapper.deleteByMainId(byId.getZsid(),byId.getId(),"3");
            certchildCkomylyMapper.deleteByMainId(byId.getZsid(),byId.getId(),"3");
            certchildMzyphjsypddscMapper.deleteByMainId(byId.getZsid(),byId.getId(),"3");
            certchildYlqxcpckxsMapper.deleteByMainId(byId.getZsid(),byId.getId(),"3");
            certchildYlqxscbaZbMapper.deleteByMainId(byId.getZsid(),byId.getId(),"3");
            certchildYlqxwtbaZbMapper.deleteByMainId(byId.getZsid(),byId.getId(),"3");
            certchildYlqxwlxsbaMapper.deleteByMainId(byId.getZsid(),byId.getId(),"3");
            certchirdYlqxlcsybaMapper.deleteByMainId(byId.getZsid(),byId.getId(),"3");
            certchildYpckxkzMapper.deleteByMainId(byId.getZsid(),byId.getId(),"3");
            certchildYpckxszmMapper.deleteByMainId(byId.getZsid(),byId.getId(),"3");
            certchildDylylqxscbapzMapper.deleteByMainId(byId.getZsid(),byId.getId(),"3");


            LambdaQueryWrapper<CertInfoOperationRecord> queryWrapper=new LambdaQueryWrapper();
            queryWrapper.eq(CertInfoOperationRecord::getZsid,byId.getZsid());
            List<CertInfoOperationRecord> detailslistr = certInfoOperationRecordService.list(queryWrapper);
            for (CertInfoOperationRecord certr :detailslistr
                 ) {
                certInfoOperationRecordService.removeById(certr.getId());

            }
            LambdaQueryWrapper<CertInfoOperationDetail> queryWrapper1=new LambdaQueryWrapper();
            queryWrapper1.eq(CertInfoOperationDetail::getZsid,byId.getZsid());
            List<CertInfoOperationDetail> detailslistd = certInfoOperationDetailService.list(queryWrapper1);
            for (CertInfoOperationDetail certr :detailslistd
            ) {
                certInfoOperationDetailService.removeById(certr.getId());

            }
            //显示被隐藏的 维护前 数据
            String whid = byId.getWhid();
            ZsYwxxb byId1 =iZsYwxxbService.getById(whid);
            if(byId1!=null) {
                byId1.setIswh("0");
                iZsYwxxbService.updateById(byId1);
            }
            iZsYwxxbService.removeById(byId.getId());
        }
        if (certInfoPage.getZt()==4) {
             CertInfo byId =getById(certInfoPage.getId());

            certchildYpscZcMapper.deleteByMainId(byId.getZsid(),byId.getId(),"4");
            certchildYpscWtMapper.deleteByMainId(byId.getZsid(),byId.getId(),"4");
            certchildYpscStMapper.deleteByMainId(byId.getZsid(),byId.getId(),"4");
            certchildCkomylyMapper.deleteByMainId(byId.getZsid(),byId.getId(),"4");
            certchildMzyphjsypddscMapper.deleteByMainId(byId.getZsid(),byId.getId(),"4");
            certchildYlqxcpckxsMapper.deleteByMainId(byId.getZsid(),byId.getId(),"4");
            certchildYlqxscbaZbMapper.deleteByMainId(byId.getZsid(),byId.getId(),"4");
            certchildYlqxwtbaZbMapper.deleteByMainId(byId.getZsid(),byId.getId(),"4");
            certchildYlqxwlxsbaMapper.deleteByMainId(byId.getZsid(),byId.getId(),"4");
            certchirdYlqxlcsybaMapper.deleteByMainId(byId.getZsid(),byId.getId(),"4");
            certchildYpckxkzMapper.deleteByMainId(byId.getZsid(),byId.getId(),"4");
            certchildYpckxszmMapper.deleteByMainId(byId.getZsid(),byId.getId(),"4");
            certchildDylylqxscbapzMapper.deleteByMainId(byId.getZsid(),byId.getId(),"4");


            LambdaQueryWrapper<CertInfoOperationRecord> queryWrapper=new LambdaQueryWrapper();
            queryWrapper.eq(CertInfoOperationRecord::getZsid,byId.getZsid());
            List<CertInfoOperationRecord> detailslistr = certInfoOperationRecordService.list(queryWrapper);
            for (CertInfoOperationRecord certr :detailslistr
            ) {
                certInfoOperationRecordService.removeById(certr.getId());

            }
            LambdaQueryWrapper<CertInfoOperationDetail> queryWrapper1=new LambdaQueryWrapper();
            queryWrapper1.eq(CertInfoOperationDetail::getZsid,byId.getZsid());
            List<CertInfoOperationDetail> detailslistd = certInfoOperationDetailService.list(queryWrapper1);
            for (CertInfoOperationDetail certr :detailslistd
            ) {
                certInfoOperationDetailService.removeById(certr.getId());

            }
           //显示被隐藏的 维护前 数据
            String whid = byId.getWhid();
            CertInfo byId1 = getById(whid);
            if(byId1!=null) {
                byId1.setIswh("0");
                updateById(byId1);
            }
            removeById(byId.getId());

        }

       return "退回成功";

    }

    @Override
    public String shenhe(CertInfoPage certInfoPage) {
        try {

            CertInfo byId = getById(certInfoPage.getId());
            ZsYwxxb byId1 = new ZsYwxxb();
            if (certInfoPage.getZt()==3) {
                byId1 = iZsYwxxbService.getById(certInfoPage.getId());
                String whid = byId1.getWhid();
                ZsYwxxb byId2 = iZsYwxxbService.getById(whid);
                String id = byId2.getId();
                String yxzt = byId2.getYxzt();
                String zszt = byId2.getZszt();
                String zsid = byId2.getZsid();
                String zsid1 = byId1.getZsid();
                QueryWrapper queryWrapper = new QueryWrapper();
                queryWrapper.eq("zsid", zsid1);
                List<CertInfoOperationRecord> list = certInfoOperationRecordService.list(queryWrapper);
                CertInfoOperationRecord o = new CertInfoOperationRecord();
                if (list != null && list.size() > 0) {
                    o = list.get(0);
                    o.setZsid(zsid);
                    o.setGzstutas("0");
                    certInfoOperationRecordService.updateById(o);
                }
                BeanUtils.copyProperties(byId1, byId2);
                byId2.setId(id);
                byId2.setYxzt(yxzt);
                byId2.setZszt(zszt);
                byId2.setCzzt("whcg");
                byId2.setZsid(zsid);
                byId2.setWhid(null);
                byId2.setIswh("0");
                UpdataWeiHuDateForZsywxxb(certInfoPage, byId1.getZsid(),byId2);
                iZsYwxxbService.removeById(byId1);
                ChuLiShenHeDate(byId1.getZsid());
                //处理操作记录

                
            } else {
                //已盖章 变成未盖章  已盖章数据不变
                byId = getById(certInfoPage.getId());
                //之前的版本
                String whid = byId.getWhid();
                //拿到复制的版本

                CertInfo byId3 = getById(whid);
                ZsYwxxb byId2 = iZsYwxxbService.getById(whid);
                if (byId2 == null) {
                    byId2 = new ZsYwxxb();
                    BeanUtils.copyProperties(byId3, byId2);
                    iZsYwxxbService.save(byId2);
                }
                String id = byId2.getId();
                String yxzt = byId2.getYxzt();
                String zszt = byId2.getZszt();
                String zsid = byId2.getZsid();

                String zsid1 = byId.getZsid();
                QueryWrapper queryWrapper = new QueryWrapper();
                queryWrapper.eq("zsid", zsid1);
                List<CertInfoOperationRecord> list = certInfoOperationRecordService.list(queryWrapper);
                CertInfoOperationRecord o = new CertInfoOperationRecord();
                if (list != null && list.size() > 0) {
                    o = list.get(0);
                    o.setZsid(zsid);
                    certInfoOperationRecordService.updateById(o);
                }
                BeanUtils.copyProperties(byId, byId2);
                byId2.setId(id);
                byId2.setYxzt("10");
                byId2.setZszt(zszt);
                byId2.setCzzt("whcg");
                byId2.setZsid(zsid);
                byId2.setZt("3");
                byId2.setWhid(null);
                byId2.setIswh("0");
                //退回提示
                CertInfo byId4 = getById(whid);
                byId4.setCzzt("cxgz");

                updateById(byId4);
                UpdataWeiHuDateForZsywxxb(certInfoPage, byId.getZsid(), byId2);
                removeById(byId);
                ChuLiShenHeDate(byId.getZsid());

            }
        } catch (Exception e) {
            e.printStackTrace();
            return "审核失败：" + e;

        }

        return "审核成功";
    }
    // save通过当前 page对象产生新的对象，并且和临时表的主键进行关联

    public void SaveWeiHuDateForCertinfo(CertInfoPage certInfoPage, CertInfo certInfonew) {
        saveMainwh(certInfonew, certInfoPage.getCertchildYpscZcList(), certInfoPage.getCertchildYpscWtList(), certInfoPage.getCertchildYpscStList(),
                certInfoPage.getCertchildCkomylyList(), certInfoPage.getCertchildMzyphjsypddscList(), certInfoPage.getCertchildYlqxcpckxsList(),
                certInfoPage.getCertchildYlqxscbaZbList(), certInfoPage.getCertchildYlqxwtbaZbList(), certInfoPage.getCertchildYpckxkzList(),
                certInfoPage.getCertchildYpckxszmList(), certInfoPage.getCertchildDylylqxscbapzList(), certInfoPage.getCertchildYlqxwlxsbaList()
                , certInfoPage.getCertchirdYlqxlcsybaList()
        );
    }

    public void SaveWeiHuDateForZsywxxb(CertInfoPage certInfoPage, ZsYwxxb zsYwxxb) {
        iZsYwxxbService.saveMainwh(zsYwxxb, certInfoPage.getCertchildYpscZcList(), certInfoPage.getCertchildYpscWtList(), certInfoPage.getCertchildYpscStList(),
                certInfoPage.getCertchildCkomylyList(), certInfoPage.getCertchildMzyphjsypddscList(), certInfoPage.getCertchildYlqxcpckxsList(),
                certInfoPage.getCertchildYlqxscbaZbList(), certInfoPage.getCertchildYlqxwtbaZbList(), certInfoPage.getCertchildYpckxkzList(),
                certInfoPage.getCertchildYpckxszmList(), certInfoPage.getCertchildDylylqxscbapzList(), certInfoPage.getCertchildYlqxwlxsbaList()
                , certInfoPage.getCertchirdYlqxlcsybaList()
        );
    }

    // update 通过当前 whid 获取维护后的子表数据,并将子表数据的主键和 确定维护后的id 进行关联
    public void UpdataWeiHuDateForCertinfo(CertInfoPage certInfoPage, String zsid, CertInfo certinfoold) {
        // 要拿到子表数据
        certInfoPage.setCertchildYpscZcList(certchildYpscZcMapper.selectByMainId(zsid,certInfoPage.getId()));
        certInfoPage.setCertchildYpscWtList(certchildYpscWtMapper.selectByMainId(zsid,certInfoPage.getId()));
        certInfoPage.setCertchildYpscStList(certchildYpscStMapper.selectByMainId(zsid,certInfoPage.getId()));
        certInfoPage.setCertchildCkomylyList(certchildCkomylyMapper.selectByMainId(zsid,certInfoPage.getId()));
        certInfoPage.setCertchildMzyphjsypddscList(certchildMzyphjsypddscMapper.selectByMainId(zsid,certInfoPage.getId()));
        certInfoPage.setCertchildYlqxcpckxsList(certchildYlqxcpckxsMapper.selectByMainId(zsid,certInfoPage.getId()));
        certInfoPage.setCertchildYlqxscbaZbList(certchildYlqxscbaZbMapper.selectByMainId(zsid,certInfoPage.getId()));
        certInfoPage.setCertchildYlqxwtbaZbList(certchildYlqxwtbaZbMapper.selectByMainId(zsid,certInfoPage.getId()));
        certInfoPage.setCertchildYlqxwlxsbaList(certchildYlqxwlxsbaMapper.selectByMainId(zsid,certInfoPage.getId()));
        certInfoPage.setCertchirdYlqxlcsybaList(certchirdYlqxlcsybaMapper.selectByMainId(zsid,certInfoPage.getId()));
        certInfoPage.setCertchildYpckxkzList(certchildYpckxkzMapper.selectByMainId(zsid,certInfoPage.getId()));
        certInfoPage.setCertchildYpckxszmList(certchildYpckxszmMapper.selectByMainId(zsid,certInfoPage.getId()));
        certInfoPage.setCertchildDylylqxscbapzList(certchildDylylqxscbapzMapper.selectByMainId(zsid,certInfoPage.getId()));

        // 考虑审批系统子表
        updateMain(certinfoold, certInfoPage.getCertchildYpscZcList(), certInfoPage.getCertchildYpscWtList(), certInfoPage.getCertchildYpscStList(),
                certInfoPage.getCertchildCkomylyList(), certInfoPage.getCertchildMzyphjsypddscList(), certInfoPage.getCertchildYlqxcpckxsList(),
                certInfoPage.getCertchildYlqxscbaZbList(), certInfoPage.getCertchildYlqxwtbaZbList(), certInfoPage.getCertchildYpckxkzList(),
                certInfoPage.getCertchildYpckxszmList(), certInfoPage.getCertchildDylylqxscbapzList(), certInfoPage.getCertchildYlqxwlxsbaList()
                , certInfoPage.getCertchirdYlqxlcsybaList()
        );
    }

    public void UpdataWeiHuDateForZsywxxb(CertInfoPage certInfoPage, String zsid, ZsYwxxb certinfoold) {
        // 要拿到子表数据
        certInfoPage.setCertchildYpscZcList(certchildYpscZcMapper.selectByMainId(zsid,certInfoPage.getId()));
        certInfoPage.setCertchildYpscWtList(certchildYpscWtMapper.selectByMainId(zsid,certInfoPage.getId()));
        certInfoPage.setCertchildCkomylyList(certchildCkomylyMapper.selectByMainId(zsid,certInfoPage.getId()));
        certInfoPage.setCertchildMzyphjsypddscList(certchildMzyphjsypddscMapper.selectByMainId(zsid,certInfoPage.getId()));
        certInfoPage.setCertchildYlqxcpckxsList(certchildYlqxcpckxsMapper.selectByMainId(zsid,certInfoPage.getId()));
        certInfoPage.setCertchildYlqxscbaZbList(certchildYlqxscbaZbMapper.selectByMainId(zsid,certInfoPage.getId()));
        certInfoPage.setCertchildYlqxwtbaZbList(certchildYlqxwtbaZbMapper.selectByMainId(zsid,certInfoPage.getId()));
        certInfoPage.setCertchildYlqxwlxsbaList(certchildYlqxwlxsbaMapper.selectByMainId(zsid,certInfoPage.getId()));
        certInfoPage.setCertchirdYlqxlcsybaList(certchirdYlqxlcsybaMapper.selectByMainId(zsid,certInfoPage.getId()));
        certInfoPage.setCertchildYpckxkzList(certchildYpckxkzMapper.selectByMainId(zsid,certInfoPage.getId()));
        certInfoPage.setCertchildYpckxszmList(certchildYpckxszmMapper.selectByMainId(zsid,certInfoPage.getId()));
        certInfoPage.setCertchildDylylqxscbapzList(certchildDylylqxscbapzMapper.selectByMainId(zsid,certInfoPage.getId()));

        // 考虑审批系统子表
        iZsYwxxbService.updateMainWH(certinfoold,zsid, certInfoPage.getCertchildYpscZcList(), certInfoPage.getCertchildYpscWtList(), certInfoPage.getCertchildYpscStList(),
                certInfoPage.getCertchildCkomylyList(), certInfoPage.getCertchildMzyphjsypddscList(), certInfoPage.getCertchildYlqxcpckxsList(),
                certInfoPage.getCertchildYlqxscbaZbList(), certInfoPage.getCertchildYlqxwtbaZbList(), certInfoPage.getCertchildYpckxkzList(),
                certInfoPage.getCertchildYpckxszmList(), certInfoPage.getCertchildDylylqxscbapzList(), certInfoPage.getCertchildYlqxwlxsbaList()
                , certInfoPage.getCertchirdYlqxlcsybaList()
        );
    }

    /**
     * 处理操作纪律
     */
    public String ChuLiCZJL(String zsid,List<CertInfoOperationRecord> certInfoOperationRecord)
    {
        boolean flag=false;
        String bgnrnew="";
         int indexsum =1;
        //变更详情 是否也要变 ，如果要变  短时间变不了 要重新改变架构 设计功能
        for (CertInfoOperationRecord cert:certInfoOperationRecord
        ) {
            //维护时产生的临时数据+copy区分 并且记忆
            String id = cert.getId();
            cert.setId(cert.getId() + "copy");
            cert.setZsid(zsid);

            CertInfoOperationRecord byId = certInfoOperationRecordService.getById(id);
            if(byId!=null&&StringUtils.isNotBlank(byId.getBgnr())&&StringUtils.isNotBlank(cert.getBgnr())) {
                if (!byId.getBgnr().equals(cert.getBgnr())) {
                    flag = true;
                }
            }
            LambdaQueryWrapper<CertInfoOperationDetail> queryWrapper=new LambdaQueryWrapper();
            queryWrapper.eq(CertInfoOperationDetail::getCzsjid,id);
            List<CertInfoOperationDetail> detailslist = certInfoOperationDetailService.list(queryWrapper);
            String bgnr = cert.getBgnr();


            if(StringUtils.isNotBlank(bgnr)&&bgnr.contains(";"))
            {
                String[] split = bgnr.split(";");
                for (String nr:split
                ) {
                    //对变更内容进行拆分 匹配
                    if(org.apache.commons.lang.StringUtils.isNotBlank(nr)&&nr.contains("由")&&nr.contains("变更为"))
                    {
                        String[] nrs = nr.split("由");
                        String field = nrs[0];
                        String regex = "\\【(.*?)\\】";
                        Pattern pattern = Pattern.compile(regex);
                        Matcher matcher = pattern.matcher(nrs[1]);
                        String bgq="";
                        String bgh="";
                        int index=0;
                        while (matcher.find()) {
                            System.out.println(matcher.group(1));
                            if(index==0)
                            {

                                bgq=matcher.group(1);
                            }
                            if(index==1)
                            {

                                bgh=matcher.group(1);
                            }
                            index++;


                        }
                        //拆分后与变更详情相互比较
                        for (CertInfoOperationDetail certdetail:detailslist
                        ) {
                            if(field.equals(certdetail.getBgzdmc().trim()))
                            {
                                if(!bgq.equals(certdetail.getZdlszt()))
                                {
                                    flag=true;
                                    certdetail.setZdlszt(bgq);
                                }
                                if(!bgh.equals(certdetail.getZdxz()))
                                {
                                    flag=true;
                                    certdetail.setZdlszt(bgh);
                                }
                                certdetail.setZsid(zsid);
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

                        if(flag==true)
                        {
                            bgnrnew+="第"+indexsum+"次变更操作内容"+"由"+"【"+byId.getBgnr()+"】"+"变更为"+"【"+cert.getBgnr()+"】;";
                            indexsum++;
                        }
                        flag=false;

                    }
                }

                if(byId==null) {
                    certInfoOperationRecordService.save(cert);
                }
                else {
                    certInfoOperationRecordService.updateById(cert);

                }
            }



        }

        return bgnrnew;
    }

    /**
     * 处理审核的数据,参数为维护中的zsid
     */
   public String ChuLiShenHeDate(String zsid)
   {

       LambdaQueryWrapper<CertInfoOperationRecord> queryWrapperrecord=new LambdaQueryWrapper();
       queryWrapperrecord.eq(CertInfoOperationRecord::getZsid,zsid);
       queryWrapperrecord.eq(CertInfoOperationRecord::getStutas,"20");
       List<CertInfoOperationRecord> recordslist = certInfoOperationRecordService.list(queryWrapperrecord);
       for (CertInfoOperationRecord rec:recordslist
       ) {
           if(rec.getId().contains("copy")) {
               //维护前操作数据
               CertInfoOperationRecord oldrecord = certInfoOperationRecordService.getById(rec.getId().substring(0, rec.getId().length() - 4));
               if(oldrecord!=null) {
                   oldrecord.setBgnr(rec.getBgnr());
                   certInfoOperationRecordService.updateById(oldrecord);
               }
               else {
                   return "未找到数据";
               }
           }
       }
       LambdaQueryWrapper<CertInfoOperationDetail> queryWrapper2=new LambdaQueryWrapper();
       queryWrapper2.eq(CertInfoOperationDetail::getZsid,zsid);
       List<CertInfoOperationDetail> detailslist = certInfoOperationDetailService.list(queryWrapper2);
       for (CertInfoOperationDetail detail:detailslist
            ) {
           if(detail.getId().contains("copy")) {
               //维护前操作数据
               CertInfoOperationDetail oldrecord = certInfoOperationDetailService.getById(detail.getId().substring(0, detail.getId().length() - 4));
               if(oldrecord!=null) {
                   oldrecord.setZdlszt(detail.getZdlszt());
                   oldrecord.setZdxz(detail.getZdxz());
                   certInfoOperationDetailService.updateById(oldrecord);
               }

           }
       }
       return "审核成功";
   }
    @Transactional
    public String mainOperationRecord(CertInfo certInfo, CertInfo oldcertinfo, String businessType, CertInfoPage certInfoPage) {
        CertInfo oldCertInfo = super.getById(certInfo);
        if (null == oldCertInfo) {
            return "操作失败，未找到对应数据";
        }
        if ("换证".equals(businessType)) {
            oldCertInfo = oldcertinfo;
        }

        StringBuilder changeField = new StringBuilder();
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("MAX(OPERATE_NO) as OPERATE_NO");
        queryWrapper.eq("zsid", oldCertInfo.getZsid());
        queryWrapper.ne("STUTAS", "20");//只有变更记录
    /*    queryWrapper.ne("old_data_flag", "20");//只有变更记录
        queryWrapper.ne("bglx", "10");//*/
        List<CertInfoOperationRecord> list = certInfoOperationRecordService.list(queryWrapper);
        int index = 0;

        if (list != null && list.size() > 0) {
            if (list.get(0) != null) {
                index = Integer.parseInt(list.get(0).getOperateNo());
            }
        }
        CertInfoOperationRecord record = new CertInfoOperationRecord();
        //创建操作记录
        if ("换证".equals(businessType)) {
            record.setId(UUID.randomUUID().toString());
            record.setZsid(oldCertInfo.getZsid());
            record.setCzsj(new Date());
            record.setOperateNo("0");
            record.setYwlx(businessType);
            record.setCzrxm(certInfoPage.getBgr());
            record.setBgyy(certInfoPage.getBgyy());
            record.setStutas("20");
            record.setBglx("2");
            certInfoOperationRecordService.save(record);
        } else {

            record.setId(UUID.randomUUID().toString());
            record.setZsid(oldCertInfo.getZsid());
            record.setCzsj(new Date());
            record.setOperateNo(index + "");
            record.setYwlx(businessType);
            record.setCzrxm(certInfoPage.getBgr());
            record.setBgyy(certInfoPage.getBgyy());
            record.setStutas("20");
            record.setBglx("3");
            certInfoOperationRecordService.save(record);
        }
        //证书操作记录
        String changeText = "fieldName由【oldValue】变更为【newValue】;";
        StringBuffer certinfoChange = getChangeField(certInfo, oldCertInfo, CertInfo.class, record, changeText);
        //换证

        if (certinfoChange.length() > 0) {
            changeField.append(certinfoChange);
        }
        //子表操作记录（新增和修改）
        String changeText_zs = "自产子表：fieldName由【oldValue】变更为【newValue】,数据序号为【num】;";
        String changeText_ws = "委托子表：fieldName由【oldValue】变更为【newValue】,数据序号为【num】;";
        String changeText_st = "受托子表：fieldName由【oldValue】变更为【newValue】,数据序号为【num】;";

        int addZcNum = 0;
        int addwtNum = 0;
        int addstNum = 0;
        StringBuffer ypscSB = new StringBuffer();
        for (CertchildYpscZc zc : certInfoPage.getCertchildYpscZcList()==null?new ArrayList<CertchildYpscZc>():certInfoPage.getCertchildYpscZcList()
        ) {
            CertchildYpscZc oldZc = certchildYpscZcMapper.selectById(zc);
            if (null == oldZc) {
                addZcNum++;
            } else {
                StringBuffer sb = getChangeField(zc, oldZc, CertchildYpscZc.class, record, changeText_zs);
                if (null != sb) {
                    ypscSB.append(sb);
                }
            }
        }
        if (addZcNum > 0) {
            ypscSB.append("自产子表：").append("新增").append(addZcNum).append("条数据;");
        }
        for (CertchildYpscWt wt : certInfoPage.getCertchildYpscWtList()==null?new ArrayList<CertchildYpscWt>():certInfoPage.getCertchildYpscWtList()
        ) {
            CertchildYpscWt oldWt = certchildYpscWtMapper.selectById(wt);
            if (null == oldWt) {
                addwtNum++;
            } else {
                StringBuffer sb = getChangeField(wt, oldWt, CertchildYpscWt.class, record, changeText_ws);
                if (null != sb) {
                    ypscSB.append(sb);
                }
            }
        }
        if (addwtNum > 0) {
            ypscSB.append("委托子表：").append("新增").append(addwtNum).append("条数据;");
        }
        for (CertchildYpscSt st : certInfoPage.getCertchildYpscStList()==null?new ArrayList<CertchildYpscSt>():certInfoPage.getCertchildYpscStList()
        ) {
            CertchildYpscSt oldSt = certchildYpscStMapper.selectById(st);
            if (null == oldSt) {
                addstNum++;
            } else {
                StringBuffer sb = getChangeField(st, oldSt, CertchildYpscSt.class, record, changeText_st);
                if (null != sb) {
                    ypscSB.append(sb);
                }
            }
        }
        if (addstNum > 0) {
            ypscSB.append("受托子表：").append("新增").append(addstNum).append("条数据;");
        }
        //子表操作记录（删除）
        int delNum_zc = 0;
        int delNum_wt = 0;
        int delNum_st = 0;
        List<CertchildYpscZc> zcList = certchildYpscZcMapper.selectByMainId(certInfo.getZsid(),certInfo.getId());
        List<CertchildYpscWt> wtList = certchildYpscWtMapper.selectByMainId(certInfo.getZsid(),certInfo.getId());
        List<CertchildYpscSt> stList = certchildYpscStMapper.selectByMainId(certInfo.getZsid(),certInfo.getId());
        for (CertchildYpscZc zc : zcList
        ) {
            Boolean isdel = true;
            for (CertchildYpscZc newZc : certInfoPage.getCertchildYpscZcList()==null?new ArrayList<CertchildYpscZc>():certInfoPage.getCertchildYpscZcList()) {
                if (zc.getId().equals(newZc.getId())) {
                    isdel = false;
                }
            }
            if (isdel) {
                delNum_zc++;
            }
        }
        if (delNum_zc > 0) {
            ypscSB.append("自产子表：").append("删除").append(delNum_zc).append("条数据;");
        }
        for (CertchildYpscWt wt : wtList
        ) {
            Boolean isdel = true;
            for (CertchildYpscWt newWt : certInfoPage.getCertchildYpscWtList()==null?new ArrayList<CertchildYpscWt>():certInfoPage.getCertchildYpscWtList()) {
                if (wt.getId().equals(newWt.getId())) {
                    isdel = false;
                }
            }
            if (isdel) {
                delNum_wt++;
            }
        }
        if (delNum_wt > 0) {
            ypscSB.append("自产子表：").append("删除").append(delNum_wt).append("条数据;");
        }
        for (CertchildYpscSt st : stList
        ) {
            Boolean isdel = true;
            for (CertchildYpscSt newSt : certInfoPage.getCertchildYpscStList()==null?new ArrayList<CertchildYpscSt>():certInfoPage.getCertchildYpscStList()) {
                if (st.getId().equals(newSt.getId())) {
                    isdel = false;
                }
            }
            if (isdel) {
                delNum_st++;
            }
        }
        if (delNum_st > 0) {
            ypscSB.append("自产子表：").append("删除").append(delNum_st).append("条数据;");
        }
        if (ypscSB.length() > 0) {
            changeField.append(ypscSB);
        }
        if (changeField.length() > 0) {
            record.setBgnr(changeField.toString());
            certInfoOperationRecordService.updateById(record);
        } else {
            certInfoOperationRecordService.removeById(record);
            return "无数据变化";
        }
        return null;
    }


    @Transactional
    public StringBuffer getChangeField(Object newObject, Object oldObject, Class clazz, CertInfoOperationRecord record, String changeText) {
        if (newObject == null || oldObject == null) {
            return null;
        }
        String[] certMetadatalist = new String[0];
        List<CertMetadata> certMetadata = null;
        // 证书元-字段名称及描述map
        Map<String, String> fieldMap = new HashMap<>();

        if ("org.jeecg.modules.demo.dzzz.certinfo.entity.CertInfo".equals(clazz.getName()) || "org.jeecg.modules.demo.dzzz.wgz.entity.ZsYwxxb".equals(clazz.getName())) {
            String certtypeid = "";
            CertInfo certInfo = new CertInfo();
            BeanUtils.copyProperties(oldObject, certInfo);

            certMetadata = queryCertMetadateById(certInfo.getCerttypeid(), "1");


            certMetadatalist = new String[certMetadata.size()];
            for (int i = 0; i < certMetadata.size(); i++
            ) {
                String fieldZd = certMetadata.get(i).getYssx().toLowerCase(Locale.ROOT);
                String fieldMs = certMetadata.get(i).getLm();

                certMetadatalist[i] = fieldZd;
                fieldMap.put(fieldZd, fieldMs);
            }
        }

        StringBuffer changeField = new StringBuffer();
        //通过hutool BeanUtil工具将实体类转换为Map
        Map newMap = BeanUtil.beanToMap(newObject);
        Map oldMap = BeanUtil.beanToMap(oldObject);
        //通过类对象获取类字段
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            Class<?> type = field.getType();
            //判断是否有ApiModelProperty注解
            if (field.isAnnotationPresent(ApiModelProperty.class)) {
                ApiModelProperty fieldName = field.getAnnotation(ApiModelProperty.class);
                //空的和忽略的字段不进行处理
                String name = field.getName();
                boolean contains = true;
                if (clazz == CertInfo.class || clazz == ZsYwxxb.class) {
                    contains = Arrays.asList(certMetadatalist).contains(field.getName().toLowerCase(Locale.ROOT));
                }
                if (fieldName.required() && ObjectUtil.isEmpty(newMap.get(field.getName())) || !contains) {
                    continue;
                }
                String newValue;
                String oldValue;
                if ("java.util.Date".equals(type.getName())) {
                    newValue = newMap.get(field.getName()) == null ? "" : DateUtils.parseDateToStr("yyyy-MM-dd hh:mm:ss", (Date) newMap.get(field.getName()));
                    oldValue = oldMap.get(field.getName()) == null ? "" : DateUtils.parseDateToStr("yyyy-MM-dd hh:mm:ss", (Date) oldMap.get(field.getName()));
                } else {
                    newValue = newMap.get(field.getName()) == null ? "" : newMap.get(field.getName()).toString();
                    oldValue = oldMap.get(field.getName()) == null ? "" : oldMap.get(field.getName()).toString();
                }
                if (newValue.equals("")) {
                    continue;
                }
                //创建操作详情记录
                CertInfoOperationDetail detail = new CertInfoOperationDetail();
                //新旧记录内容不同，说明是修改过，因此记录起来
                if (!StringUtils.equals(newValue, oldValue)) {
                    if (clazz == CertInfo.class) {
                        Field declaredField;
                        try {
                          /*  declaredField = oldObject.getClass().getDeclaredField(field.getName());
                            declaredField.setAccessible(true);
                            declaredField.set(oldObject, newValue);
                            certInfoMapper.updateById((CertInfo) oldObject);*/
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    detail.setBgzdmc(field.getName());
                    TableName tableName = CertInfo.class.getAnnotation(TableName.class);
                    detail.setCzbm(tableName.value());

                    String fieldValue = fieldName.value();
                    if (fieldValue.contains("ylzd") && null != fieldMap) {
                        String fieldMs = fieldMap.get(fieldValue);
                        fieldValue = StringUtils.isNotBlank(fieldMs) ? fieldMs : fieldValue;
                    }

                    detail.setBgzdms(fieldValue);
                    detail.setCzsjid(record.getId());
//                    detail.setBgzdmc(fieldName.value());
                    detail.setBgr(record.getCzrxm());
                    detail.setBgyy(record.getBgyy());
                    detail.setCzsj(new Date());
                    detail.setDataFlg("1");
                    detail.setZsczjl(record.getId());
                    detail.setZsid(record.getZsid());
                    detail.setZdlszt(oldValue);
                    detail.setZdxz(newValue);
                    certInfoOperationDetailService.save(detail);
//                    String filenamezui = "";
//                    if(certMetadata!=null&&certMetadata.size()>0) {
//                        for (CertMetadata namess : certMetadata
//                        ) {
//                            if (fieldName.value().equals(namess.getYssx())) {
//                                filenamezui = namess.getLm();
//                            }
//                        }
//                    }

                    changeField.append(changeText.replaceAll("fieldName", fieldValue)
                            .replaceAll("oldValue", oldValue).replaceAll("num", newValue)
                            .replaceAll("newValue", newValue));
                }
            }
        }
        return changeField;
    }


    /**
     * 创造ofd
     *
     * @param zsDto
     * @param cardrecordlist
     * @param
     * @param
     * @throws FileNotFoundException
     */
    public int createOfdByTemplate(ZsDto zsDto, List<CertMetadata> cardrecordlist, String mobanpanth, String ofdpath, int yushu) throws FileNotFoundException {
        int ret = 0;
        try {
            /*String content = Signature.getQrcode() + "gyEntcardprint.id="
                    + zsDto.getId() + "&gyEntcardprint.cardtype="
                    + codeMapper.selectCodeByZslx(zsDto.getZslx());
            zsDto.setQrcode(content);*/
            //拼装xml模板

            String xmlTemplate = XmlUtil.createCardprintXMLForOFD(zsDto, cardrecordlist, yushu);
            long start = System.currentTimeMillis();
            // 生成查看的ofd
            if(StringUtils.isNotBlank(zsDto.getBgnr()))
            {
                ret = OfdUtil.template2Ofd(xmlTemplate, mobanpanth, ofdpath);

            }else{
                ret = OfdUtil.generaterMorePage(xmlTemplate, mobanpanth, ofdpath);
            }
            if (ret == 0) {
                return ret;
            }
           /* if (ret == 1) {
                int i = ofdpath.lastIndexOf("/");
                Attachinfo attachinfo = new Attachinfo();
                attachinfo.setId(UUID.randomUUID().toString());
                attachinfo.setCreateBy("生成证照ofd");
                attachinfo.setFileName(ofdpath.substring(i));
                attachinfo.setCreateTime(new Date());
                attachinfo.setZsid(zsDto.getId());
                attachinfo.setModeUrl(ofdpath);
                iAttachinfoService.save(attachinfo);
            }*/
            logger.error("生成OFD时间:{}", (System.currentTimeMillis() - start));

            if (ret == 1) {
                logger.info("证书【" + zsDto.getId() + "】生成OFD文件成功！");
            } else {
                logger.error("证书【" + zsDto.getId() + "】生成OFD文件失败！");
            }
            return ret;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * 组装变更字段
     *
     * @return
     * @throws Exception
     */
    public List<CertMetadata> getRecordList(boolean sfbg, String cardType) {
        List<CertMetadata> recordList = null;
        CertMetadataVersion certMetadataVersion = null;
        List<CertMetadataVersion> list = iCertMetadataVersionService.list(Wrappers.<CertMetadataVersion>lambdaQuery()
                .eq(CertMetadataVersion::getCertTypeId, cardType).eq(CertMetadataVersion::getStatus, "0"));
        if (!list.isEmpty() && list.size() > 0) {
            certMetadataVersion = list.get(0);
        } else {
            return recordList = new ArrayList<>();
        }
        if (!sfbg) {
            recordList = iCertMetadataService.list(Wrappers.<CertMetadata>lambdaQuery()
                    .eq(CertMetadata::getCertmetadataversionId, certMetadataVersion.getId())
                    .eq(CertMetadata::getZt, 0)
                    /*.eq(CertMetadata::getSfsc, 0)*/
                    .orderByAsc(CertMetadata::getPx));
        } else {
            recordList = new ArrayList<CertMetadata>();
            for (int i = 1; i < 70; i++) {
                CertMetadata record1 = new CertMetadata();
                record1.setYssx("modifyinfo" + i);
                recordList.add(record1);
                CertMetadata record2 = new CertMetadata();
                record2.setYssx("modifytime" + i);
                recordList.add(record2);
            }
        }
        return recordList;
    }


    /**
     * 创建变更pdf
     *
     * @param bgTemplateList
     * @param bgTemplateTdList
     * @param cardprint
     * @param pdfFolder
     * @param contextDir
     * @param adCode
     * @param signatureName
     * @param keySn
     * @param idx
     * @param
     * @throws Exception
     */
    public int createBgPdf(List<CertMode> bgTemplateList,
                           List<CertMode> bgTemplateTdList, ZsDto cardprint,
                           String pdfFolder, String contextDir, Integer adCode,
                           String signatureName, String keySn, int idx,
                           String operateId, String ofdtempath, String ofdpath, int yushu) throws Exception {
        int j = idx;
        if (bgTemplateList.size() == 0) {// 如果没有变更模板，则直接返回
            return 0;
        }


        final List<CertMetadata> cardrecordlist = getRecordList(true,
                cardprint.getCerttypeid());
        int result = createOfdByTemplate(cardprint, cardrecordlist,ofdtempath, ofdpath, yushu);
        return result;

    }


    public void AddAttach(String filename, String type, String fileurl, String zsid, String isgz) {

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("zsid", zsid);
        queryWrapper.eq("type", type);
        queryWrapper.eq("status", "1");
        List<Attachinfo> list = iAttachinfoService.list(queryWrapper);
        Attachinfo attachinfoByZSid = null;
        if (!list.isEmpty() && list.size() > 0) {
            attachinfoByZSid = list.get(0);
            attachinfoByZSid.setStatus("0");
            iAttachinfoService.updateById(attachinfoByZSid);
            Attachinfo attachinfo = new Attachinfo();
            attachinfo.setId(UUID.randomUUID().toString());
            attachinfo.setIsgz(isgz);
            attachinfo.setCreateBy("生成证照ofd");
            attachinfo.setType(type);
            attachinfo.setStatus("1");
            attachinfo.setFileName(filename);
            attachinfo.setCreateTime(new Date());
            attachinfo.setUserName("后台代码生成");
            attachinfo.setZsid(zsid);
            attachinfo.setModeUrl(fileurl);

            iAttachinfoService.save(attachinfo);
        } else {
            Attachinfo attachinfo = new Attachinfo();
            attachinfo.setId(UUID.randomUUID().toString());
            attachinfo.setCreateBy("生成证照ofd");
            attachinfo.setType(type);
            attachinfo.setStatus("1");
            attachinfo.setIsgz(isgz);
            attachinfo.setFileName(filename);
            attachinfo.setCreateTime(new Date());
            attachinfo.setUserName("后台代码生成");
            attachinfo.setZsid(zsid);
            attachinfo.setModeUrl(fileurl);

            iAttachinfoService.save(attachinfo);
        }


    }

    @Override
    public IPage<YxqWarnResDto> selectYxqWarningPageList(YxqWarnReqDto dto, IPage page) {
        return certInfoMapper.selectYxqWarningPageList(dto, page);
    }

    @Override
    public List<YxqWarnResDto> selectYxqWarningList(YxqWarnReqDto dto) {
        return certInfoMapper.selectYxqWarningList(dto);
    }

    @Override
    public IPage<WgzWarnResDto> selectWgzWarningPageList(WgzWarnReqDto dto, IPage page) {
        return certInfoMapper.selectWgzWarningPageList(dto, page);
    }

    @Override
    public List<WgzWarnResDto> selectWgzWarningList(WgzWarnReqDto dto) {
        return certInfoMapper.selectWgzWarningList(dto);
    }


    @Override
    public void dealCertExpire() {
        try {
            long start = System.currentTimeMillis();

            LambdaQueryWrapper<CertInfo> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(CertInfo :: getYxzt, YwConstant.ZSZT_YX);
            queryWrapper.lt(CertInfo :: getYxqz, YwUtil.getTodayStr());
            List<CertInfo> list = this.list(queryWrapper);
            if (CollectionUtils.isNotEmpty(list)) {
                // 省市场局‘四类证’过期的证书
                List<CertInfo> sscjCertList = list.stream().filter(certInfo ->
                        YwConstant.SSCJ_CERTTYPEID.contains(certInfo.getCerttypeid())).collect(Collectors.toList());
                if (CollectionUtils.isNotEmpty(sscjCertList)) {
                    List<CertInfo> updList = new ArrayList<>();
                    sscjCertList.forEach(certInfo -> {
                        CertInfo info = new CertInfo();
                        info.setId(certInfo.getId());
                        info.setJsly(YwConstant.JLLY_SSCJ);
                        info.setYxzt(YwConstant.ZSZT_GQ);
                        CertUtils.initSyncState(info);
                        updList.add(info);
                    });
                    log.info("省市场局‘四类证’过期的证书，数量有：{}", updList.size());
                    this.updateBatchById(updList);
                }

                // 其他过期的证书
                List<CertInfo> otherCertList = list.stream().filter(certInfo ->
                        !YwConstant.SSCJ_CERTTYPEID.contains(certInfo.getCerttypeid())).collect(Collectors.toList());
                if (CollectionUtils.isNotEmpty(otherCertList)) {
                    List<CertInfo> updList = new ArrayList<>();
                    otherCertList.forEach(certInfo -> {
                        CertInfo info = new CertInfo();
                        info.setId(certInfo.getId());
                        info.setYxzt(YwConstant.ZSZT_GQ);
                        CertUtils.initSyncState(info);
                        updList.add(info);
                    });
                    log.info("其他过期的证书，数量有：{}", updList.size());
                    this.updateBatchById(updList);
                }
            }
            long end = System.currentTimeMillis();
            log.info("定时任务：处理过期证照。总耗时：{}", (end - start));
        } catch (Exception e) {
            log.error("定时任务：处理过期证照，出错。错误信息：{}", e.getMessage());
        }
    }

    @Override
    public List<CertInfo> xybData() {
        return certInfoMapper.xybData();
    }

    @Override
    public String generateElectronicLicense(String certTypeId, String fzjgId, String version) {
        // 查询证书类型
        CertType certType = certTypeService.getById(certTypeId);
        if (certType == null || StringUtils.isEmpty(certType.getCerttypecode())) {
            log.error("生成电子证照唯一标识，未查询到证书类型 或 证书类型对应的code为空。certTypeId：{}", certTypeId);
            return "";
        }
        // 查询部门信息
        SDept dept = deptService.getDeptById(fzjgId);
        if (dept == null || StringUtils.isEmpty(dept.getVar2())) {
            log.error("生成电子证照唯一标识，未查询到发证机构对应的部门信息 或 部门ID对应的var2值为空。fzjgId：{}", fzjgId);
            return "";
        }
        // 生成电子证照
        String electronicLicense = LicenseUtils.createCertificateSourceId(certType.getCerttypecode(), dept.getVar2(), version);

        // 判断电子证照唯一标识是否重复，如果重复重新生成
        if (!checkElectronicLicense(electronicLicense)) {
            return generateElectronicLicense(certTypeId, fzjgId, version);
        }
        return electronicLicense;
    }

    @Override
    public Attachinfo getAttachByParamsForSp(String id) {
        return certInfoMapper.getAttachByParamsForSp(id);
    }

    @Override
    public List<Attachinfo> getAttachListByParamsForSp(String id) {
        return certInfoMapper.getAttachListByParamsForSp(id);
    }

    /**
     * 判断电子证照唯一标识是否重复，如果重复重新生成
     * @param electronicLicense
     * @return
     */
    private boolean checkElectronicLicense (String electronicLicense) {
        LambdaQueryWrapper<CertInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CertInfo :: getOldId, electronicLicense);
        List<CertInfo> certList = this.list(queryWrapper);
        return org.springframework.util.CollectionUtils.isEmpty(certList);
    }

}
