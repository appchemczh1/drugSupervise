package org.jeecg.modules.demo.dzzz.dataExchange.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.jeecg.common.util.UUIDGenerator;
import org.jeecg.modules.demo.dzzz.certInfoOperation.entity.CertInfoOperationDetail;
import org.jeecg.modules.demo.dzzz.certInfoOperation.entity.CertInfoOperationRecord;
import org.jeecg.modules.demo.dzzz.certInfoOperation.service.ICertInfoOperationDetailService;
import org.jeecg.modules.demo.dzzz.certInfoOperation.service.ICertInfoOperationRecordService;
import org.jeecg.modules.demo.dzzz.certarea.entity.CertArea;
import org.jeecg.modules.demo.dzzz.certarea.service.ICertAreaService;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertInfo;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertHandleService;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertInfoService;
import org.jeecg.modules.demo.dzzz.certmatadataversion.entity.CertMetadata;
import org.jeecg.modules.demo.dzzz.certmatadataversion.service.ICertMetadataService;
import org.jeecg.modules.demo.dzzz.certtype.entity.CertType;
import org.jeecg.modules.demo.dzzz.certtype.service.ICertTypeService;
import org.jeecg.modules.demo.dzzz.constant.YwConstant;
import org.jeecg.modules.demo.dzzz.dataExchange.dto.*;
import org.jeecg.modules.demo.dzzz.dataExchange.entity.TYwSjJlb;
import org.jeecg.modules.demo.dzzz.dataExchange.exception.ErrorMsg;
import org.jeecg.modules.demo.dzzz.dataExchange.exception.ErrorUtil;
import org.jeecg.modules.demo.dzzz.dataExchange.exception.YwException;
import org.jeecg.modules.demo.dzzz.dataExchange.service.ITYwSjJlbService;
import org.jeecg.modules.demo.dzzz.dataExchange.util.YwUtil;
import org.jeecg.modules.demo.dzzz.dataExchange.vo.DataResult;
import org.jeecg.modules.demo.dzzz.dept.service.ISDeptService;
import org.jeecg.modules.demo.dzzz.enums.YwlxEnum;
import org.jeecg.modules.demo.dzzz.information.entity.Information;
import org.jeecg.modules.demo.dzzz.information.service.IInformationService;
import org.jeecg.modules.demo.dzzz.util.BeanUtils;
import org.jeecg.modules.demo.dzzz.util.DateUtils;
import org.jeecg.modules.demo.dzzz.wgz.entity.ZsYwxxb;
import org.jeecg.modules.demo.dzzz.wgz.service.IZsYwxxbService;
import org.jeecg.modules.demo.dzzz.whsjZb.entity.BaQxwlxsbaZb;
import org.jeecg.modules.demo.dzzz.whsjZb.entity.TJcZsDylylqxscbapzZb;
import org.jeecg.modules.demo.dzzz.whsjZb.service.IBaQxwlxsbaZbService;
import org.jeecg.modules.demo.dzzz.whsjZb.service.ITJcZsDylylqxscbapzZbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;


@Api(tags="数据流转-武汉市局")
@RestController
@RequestMapping("/licenseDs")
@Slf4j
public class WhsjController {

    @Autowired
    private ICertMetadataService iCertMetadataService;
    @Autowired
    private ITYwSjJlbService tYwSjJlbService;
    @Autowired
    private IZsYwxxbService zsYwxxbService;
    @Autowired
    private ICertTypeService certTypeService;
    @Autowired
    private IInformationService informationService;
    @Autowired
    private ICertInfoOperationRecordService operationRecordService;
    @Autowired
    private ICertInfoService certInfoService;
    @Autowired
    private ICertHandleService certHandleService;
    @Autowired
    private ISDeptService deptService;
    @Autowired
    private ICertInfoOperationDetailService certInfoOperationDetailService;
    @Autowired
    private IBaQxwlxsbaZbService baQxwlxsbaZbService;
    @Autowired
    private ITJcZsDylylqxscbapzZbService itJcZsDylylqxscbapzZbService;
    @Autowired
    private ICertAreaService certAreaService;

    // 武汉市局证书类型List
    private List<String> zslxList = Arrays.asList("27", "28", "30", "32", "33", "46", "47", "64");

    /**
     * 证书元获取
     * 接口地址：{host}/licenseDs/{API标识}?type=api
     */
    @ApiOperation(value="数据-根据证书类型获取证书元集合", notes="数据-根据证书类型获取证书元集合")
    @GetMapping(value = "/getZsy")
    public DataResult getZsy(@RequestParam String zslx) {
        if (StringUtils.isEmpty(zslx)) {
            return DataResult.error(ErrorMsg.ZSLX_NOT_NULL);
        }
        if (!zslxList.contains(zslx)) {
            return DataResult.error(ErrorMsg.ZS_LX_NOT_FIND);
        }
        return DataResult.ok(buildWhsjZsy(zslx));
    }

    @ApiOperation(value="数据-地市数据获取", notes="数据-地市数据获取")
    @PostMapping(value = "/lesaveLicense")
    public DataResult lesaveLicense(@RequestBody Map<String, Object> params) {
        if (null == params) {
            return DataResult.error("请求参数不能为空");
        }
        return dataValidAndWrite(params);
    }

    /**
     * 数据校验 + 数据入库 + 自动盖章
     * @param params
     * @return
     */
    private DataResult dataValidAndWrite(Map<String, Object> params) {
        WhsjDataReqDto dto = null;
        try {
            dto = JSONObject.parseObject(JSONObject.toJSONString(params), WhsjDataReqDto.class);
            // 数据校验
            DataResult validResult = validateData(dto, params);
            if (!validResult.isSuccess()) {
                return validResult;
            }

            if (YwlxEnum.ZHUXIAO.getCode().equals(dto.getYwlx())) {
                CertInfo certInfo = (CertInfo) validResult.getData();
                // 更新为注销状态
                CertInfo updInfo = new CertInfo();
                updInfo.setId(certInfo.getId());
                updInfo.setYxzt(YwConstant.ZSZT_ZX);
                updInfo.setZszt(YwlxEnum.ZHUXIAO.getCode());
                updInfo.setSjzx(String.valueOf(YwConstant.CONFIRM));
                certInfoService.updateById(updInfo);
                // 保存-操作记录表
                saveCzjl(dto, UUIDGenerator.generate());
                return dataResultOk(certInfo.getZsid());
            }

            // 保存-企业信息，存在则更新
            String qyId = saveOrUpdateQyxx(params, dto);
            // 保存-未盖章信息表
            ZsYwxxb wgzInfo = saveZsYwxxb(dto, qyId);
            if (YwlxEnum.HUANFA.getCode().equals(dto.getYwlx()) || YwlxEnum.BIANGE.getCode().equals(dto.getYwlx())) {
                // 保存-操作记录和明细
                saveCzjlAndMx(dto, wgzInfo.getCerttypeid());
            } else {
                // 保存-操作记录
                saveCzjl(dto, UUIDGenerator.generate());
            }
            // 有子表的证照，保存子表信息
            saveZb(dto, wgzInfo.getId());

            // 证书类型为“医疗器械网络销售备案”是自动盖章，其他是手动盖章
            if ((YwConstant.ZSLX_YLQXWLXSBA.equals(dto.getZslx()))) {
                String resMsg = certHandleService.batchGzFromWgz(new String[]{ wgzInfo.getId() }, null, "", "", null);
                log.info("武汉市局自动盖章结果：{}", resMsg);
                // 盖章错误信息返回给用户
                if (!YwConstant.GZ_SUCCESS.equals(resMsg) && !YwConstant.SC_ZS_SUCCESS.equals(resMsg)) {
                    validResult.setMsg(resMsg);
                }
            }
            return validResult;
        } catch (Exception e) {
            DataResult validResult = DataResult.error(e.getMessage());
            // 保存-推送数据记录表
            saveTYwSjJlb(params, dto, validResult);
            return validResult;
        }
    }

    /**
     * 校验数据
     * @return
     */
    private DataResult validateData (WhsjDataReqDto dto, Map<String, Object> params) {
        DataResult validResult;
        try {
            // 公共的校验
            this.valid(dto, params);
            String ywlx = dto.getYwlx();
            // 查询是否有重复的推送
            LambdaQueryWrapper<ZsYwxxb> queryWrapper = new LambdaQueryWrapper();
            queryWrapper.eq(ZsYwxxb :: getZsid, dto.getLicenseId());
            queryWrapper.eq(ZsYwxxb :: getZszt, ywlx);
            queryWrapper.eq(ZsYwxxb :: getZsbh, dto.getZsbh());
//            queryWrapper.ne(ZsYwxxb :: getYxzt, YwConstant.ZSZT_ZF);
            List<ZsYwxxb> zsList = zsYwxxbService.list(queryWrapper);
            ErrorUtil.assertFailure(!CollectionUtils.isEmpty(zsList), String.format(ErrorMsg.ZSBH_ZSLX_ZSID_REPEAT, dto.getZsbh()));

            // 按照证书类型、证书编号，查询是否存在，不存在则未查询到历史数据；
            LambdaQueryWrapper<CertType> certTypeQuery = new LambdaQueryWrapper();
            certTypeQuery.eq(CertType::getZslx, dto.getZslx());
            certTypeQuery.eq(CertType::getStatus, YwConstant.CERT_TYPE_STATUS_FB);
            List<CertType> certTypeList = certTypeService.list(certTypeQuery);
            ErrorUtil.assertFailure(CollectionUtils.isEmpty(certTypeList), ErrorMsg.ZS_LX_NOT_FIND);

            // 查询是否有证书记录，如果有给zsid赋值；所有业务zsid为核发时的ID
            LambdaQueryWrapper<CertInfo> queryWrapperOne = new LambdaQueryWrapper();
            queryWrapperOne.eq(CertInfo::getZsbh, dto.getZsbh());
            queryWrapperOne.eq(CertInfo::getCerttypeid, certTypeList.get(0).getId());
            queryWrapperOne.ne(CertInfo::getYxzt, YwConstant.ZSZT_ZF);
            List<CertInfo> certList = certInfoService.list(queryWrapperOne);
            CertInfo certInfo = null;
            if (!CollectionUtils.isEmpty(certList)) {
                certInfo = certList.get(0);
                dto.setLicenseId(certInfo.getZsid());
            }

            if (YwlxEnum.ZHUXIAO.getCode().equals(ywlx)) {
                // 根据证书编号查询是否有证书记录，没有给出提示
                ErrorUtil.assertFailure(null == certInfo || StringUtils.isBlank(certInfo.getId()), ErrorMsg.ZS_NO_EXIST);
                // 如果当前已经为注销状态，给出提示
                ErrorUtil.assertFailure(YwConstant.ZSZT_ZX.equals(certInfo.getYxzt()), ErrorMsg.ZS_YZX);

                // 保存-推送数据记录表
                saveTYwSjJlb(params, dto, dataResultOk(dto.getLicenseId()));
                return DataResult.ok(certInfo);
            } else {
                if (!YwlxEnum.HEFA.getCode().equals(ywlx)) {
                    String zslxMc = YwConstant.ZSLX_WHSJ.get(dto.getZslx());
                    // 非核发业务，如果不存在则提示：查不到历史证书!
                    ErrorUtil.assertFailure(CollectionUtils.isEmpty(certList), String.format(ErrorMsg.NO_HF_ZX_NO_FIND_HISTORY,
                            zslxMc, dto.getZsbh(), dto.getQymc(), dto.getShxydm()));
                }
                validResult = dataResultOk(dto.getLicenseId());
            }
        } catch (YwException e) {
            validResult = DataResult.error(e.getErrorMsg());
            log.error(e.getMessage());
        }
        // 保存-推送数据记录表
        saveTYwSjJlb(params, dto, validResult);
        return validResult;
    }

    /**
     * 保存-未盖章证书信息表
     * @param dto 请求参数
     */
    private ZsYwxxb saveZsYwxxb(WhsjDataReqDto dto, String qyId) {
        LambdaQueryWrapper<CertType> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(CertType :: getZslx, dto.getZslx());
        lambdaQueryWrapper.eq(CertType :: getStatus, YwConstant.CERT_TYPE_STATUS_FB);
        CertType certType = certTypeService.getOne(lambdaQueryWrapper);
        ErrorUtil.assertFailure(null == certType || StringUtils.isBlank(certType.getId()), ErrorMsg.ZS_LX_NOT_EXIST);

        ZsYwxxb bean = this.buildZsYwxxb(dto, certType.getId());
        bean.setChanping(dto.getCp());
        bean.setQyid(qyId);

        log.info("武汉市局，未盖章证书表：{}", JSONObject.toJSONString(bean));
        zsYwxxbService.save(bean);
        return bean;
    }

    /**
     * 构建未盖章证书信息
     * @param dto 请求参数
     * @param certTypeId 证书类型ID
     * @return
     */
    public ZsYwxxb buildZsYwxxb(WhsjDataReqDto dto, String certTypeId) {
        ZsYwxxb bean = new ZsYwxxb();
        BeanUtils.copyProperties(dto, bean);
        bean.setId(UUIDGenerator.generate());
        bean.setYwlb(dto.getYwlx());
        bean.setZsid(dto.getLicenseId());
        bean.setCerttypeid(certTypeId);
        bean.setZt(YwConstant.GZ_SCZT_WGZ);
        bean.setJsly(YwConstant.JLLY_WHSJ);
        bean.setZszt(dto.getYwlx());
        bean.setYxzt(YwConstant.ZSZT_YX);
        bean.setSynctime(new Date());
        bean.setSync("0");
        bean.setFzrq(YwUtil.dateSubStr(dto.getFzrq()));
        bean.setYxqz(YwUtil.dateSubStr(dto.getYxqz()));
        bean.setYxqq(YwUtil.dateSubStr(dto.getYxqq()));
        return bean;
    }

    /**
     * 保存或更新-企业信息表
     * @param dto 请求参数
     * @param params 请求参数
     */
    private String saveOrUpdateQyxx(Map<String, Object> params, WhsjDataReqDto dto) {
        LambdaQueryWrapper<Information> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Information :: getEntzzjgdm, dto.getShxydm());
        Information info = informationService.getOne(queryWrapper);
        if (null != info && StringUtils.isNotBlank(info.getId())) {
            log.info("武汉市局，已存在企业信息，进行更新企业信息");
        }
        Information qyInfo = this.buildQyxx(info, dto);
        informationService.saveOrUpdate(qyInfo);
        return qyInfo.getId();
    }

    /**
     * 构建企业信息
     * @param bean
     * @return
     */
    public Information buildQyxx(Information bean, WhsjDataReqDto dto) {
        String qyId = UUIDGenerator.generate();
        if (null == bean || StringUtils.isEmpty(bean.getId())) {
            bean = new Information();
        } else {
            qyId = bean.getId();
        }
        bean.setId(qyId);
        bean.setEntname(dto.getQymc());
        bean.setEntzzjgdm(dto.getShxydm());
        bean.setEntregaddr(StringUtils.isEmpty(dto.getZcdz()) ? dto.getZs() : dto.getZcdz());
        // 省市区
        CertArea area = certAreaService.selectAreaByAreaCode(dto.getAreaCode());
        if (null != area) {
            bean.setEngx(area.getAreaname());
            bean.setAdmindivision(area.getAreacode());
            CertArea twoArea = certAreaService.getById(area.getParentid());
            if (null != twoArea) {
                bean.setEntd(twoArea.getAreaname());
                CertArea oneLevel = certAreaService.getById(twoArea.getParentid());
                if (null != oneLevel) {
                    bean.setEnts(oneLevel.getAreaname());
                }
            }
        } else {
            bean.setAdmindivision(dto.getAreaCode());
            bean.setEngx(dto.getAreaName());
        }
        bean.setEntby7(dto.getFw());
        bean.setEntlinkname(dto.getLxr());
        bean.setEntlinktel(dto.getLxdh());
        bean.setCorpname(dto.getFddbr());
        bean.setEntby14(dto.getFddbrsfz());
        bean.setScdz(dto.getScdz());
        bean.setSynctime(DateUtils.getTodayStr());
        bean.setSync("0");
        return bean;
    }

    /**
     * 保存-操作记录和明细
     * @param dto
     */
    public void saveCzjlAndMx(WhsjDataReqDto dto, String certTypeId) {
        String recordId = UUIDGenerator.generate();

        StringBuilder bgnr = new StringBuilder();
        List<WhsjBgmxDataReqDto> bgmxList = dto.getBgmxList();
        bgmxList.forEach(bgmx -> {
            CertInfoOperationDetail mxBean = new CertInfoOperationDetail();
            mxBean.setId(bgmx.getId());
            mxBean.setCreateBy(YwConstant.JLLY_WHSJ);
            mxBean.setCreateTime(new Date());
            TableName tableName = CertInfo.class.getAnnotation(TableName.class);
            mxBean.setCzbm(tableName.value());
            mxBean.setBgzdms(bgmx.getColumnDesc());
            CertMetadata certMeta = iCertMetadataService.selectCertMetaByParams(certTypeId, bgmx.getColumnName());
            if (null != certMeta) {
                mxBean.setBgzdmc(certMeta.getId());
            } else {
                mxBean.setBgzdmc(bgmx.getColumnName());
            }
            mxBean.setBgr(dto.getCzrid());
            mxBean.setBgyy(dto.getBz());
            mxBean.setCzsj(DateUtils.parseDate(dto.getCzsj(), "yyyy-MM-dd HH:mm:ss"));
            mxBean.setDataFlg("1");
            mxBean.setCzsjid(recordId);
            mxBean.setZsczjl(recordId);
            mxBean.setZsid(dto.getLicenseId());
            mxBean.setZdlszt(bgmx.getBeforeValue());
            mxBean.setZdxz(bgmx.getAfterValue());
            certInfoOperationDetailService.save(mxBean);

            // 变更内容拼接
            bgnr.append(bgmx.getColumnDesc() + "由【" + bgmx.getBeforeValue() + "】变更为【" + bgmx.getAfterValue() + "】;");
        });
        dto.setBgnr(bgnr.toString());
        // 保存-操作记录
        saveCzjl(dto, recordId);
    }

    /**
     * 保存-操作记录
     * @param dto 请求参数
     * @param recordId
     */
    private void saveCzjl(WhsjDataReqDto dto, String recordId) {
        CertInfoOperationRecord bean = new CertInfoOperationRecord();
        bean.setId(recordId);
        bean.setCreateBy(YwConstant.JLLY_WHSJ);
        bean.setCreateTime(new Date());
        bean.setYwlx(dto.getYwlx());
        bean.setBglx(dto.getYwlx());
        bean.setZsid(dto.getLicenseId());
        bean.setSjly(YwConstant.JLLY_WHSJ);
        bean.setStutas("20");
        bean.setCzsj(new Date());
        bean.setCzrxm(dto.getCzrxm());
        bean.setCzryid(dto.getCzrid());

        // 换发、变更，写入变更信息
        if (YwlxEnum.HUANFA.getCode().equals(dto.getYwlx()) || YwlxEnum.BIANGE.getCode().equals(dto.getYwlx())) {
            bean.setBgnr(dto.getBgnr());
            bean.setCzrq(dto.getBgsj());
            // bean.setUpdateTime( StringUtils.isEmpty(dto.getBgsj()) ? null : DateUtils.dateTime("yyyy-MM-dd", dto.getBgsj()));
            bean.setBgcs(dto.getBgs());
        }
        operationRecordService.save(bean);
    }

    /**
     * 保存-推送数据记录表
     * @param params
     * @param dto 请求参数
     * @param result
     */
    private void saveTYwSjJlb(Map<String, Object> params, WhsjDataReqDto dto, DataResult result) {
        try {
            TYwSjJlb jlb = new TYwSjJlb();
            jlb.setJlly(YwConstant.JLLY_WHSJ);
            jlb.setZsid(StringUtils.isEmpty(dto.getLicenseId()) ? "" : dto.getLicenseId());
            jlb.setZsbh(StringUtils.isEmpty(dto.getZsbh()) ? "" : dto.getZsbh());
            jlb.setJlInJson(null == params ? null : JSONObject.toJSONString(params));
            jlb.setJlsj(DateUtils.getTodayStr());
            jlb.setZslx(StringUtils.isBlank(dto.getZslx()) ? "" : dto.getZslx());
            jlb.setJlzt(result.isSuccess() ? YwConstant.CONFIRM : YwConstant.DENY);
            jlb.setYwlx(StringUtils.isBlank(dto.getYwlx()) ? "" : dto.getYwlx());
            jlb.setYwid(StringUtils.isEmpty(dto.getLicenseId()) ? "" : dto.getLicenseId());
            jlb.setJlOutJson(JSONObject.toJSONString(result));
            jlb.setOutId(StringUtils.isBlank(dto.getLicenseVid()) ? "" : dto.getLicenseVid());
            tYwSjJlbService.save(jlb);
        } catch (Exception ex) {
            log.error("武汉市局-推送数据-业务记录表，写入失败！", ex);
        }
    }

    /**
     * 组装证书元信息
     * @param zslx
     * @return
     */
    private WhsjLicenseZsyDto buildWhsjZsy (String zslx) {
        WhsjLicenseZsyDto whsjDto = new WhsjLicenseZsyDto();
        // 证书元集合
        List<WhsjZsyDto> zsyList = new ArrayList<>();
        List<CertMetadata> certMetadataList = iCertMetadataService.selectZsyByZslx(zslx);
        TableName tableDyl = ZsYwxxb.class.getAnnotation(TableName.class);
        certMetadataList.stream().forEach(certMeta->{
            WhsjZsyDto zsy = new WhsjZsyDto();
            BeanUtils.copyProperties(certMeta, zsy);
            zsy.setZzyssx(certMeta.getYssx());
            zsy.setBbid(certMeta.getCertmetadataversionId());
            zsy.setVar1(tableDyl.value());
            zsyList.add(zsy);
        });
        whsjDto.setZsyList(zsyList);

        if (YwConstant.ZSLX_YLQXWLXSBA.equals(zslx)) {
            // 医疗器械网络销售备案(有子表)
            whsjDto.setZbList(ylqxWlxsBaZb());
        } else if (YwConstant.ZSLX_DYLYLQXSCBA.equals(zslx)) {
            // 第一类医疗器械生产备案(有子表)
            whsjDto.setZbList(dylYlqxScBaZb());
        } else {
            whsjDto.setZbList(new ArrayList<>());
        }
        return whsjDto;
    }

    /**
     * 公共的校验
     * @return
     */
    public void valid (WhsjDataReqDto dto, Map<String, Object> params) {
        ErrorUtil.assertFailure(null == dto, ErrorMsg.PARAMS_NOT_NULL);
        // 证书类型校验
        String zslx = dto.getZslx();
        ErrorUtil.assertStringIsBlank(zslx, ErrorMsg.ZSLX_NOT_NULL);
        // 业务类型校验，并获取证书类型对应的名称
        String ywlx = dto.getYwlx();
        ErrorUtil.assertStringIsBlank(ywlx, ErrorMsg.YWLX_NOT_NULL);
        String zslxMc = YwConstant.ZSLX_WHSJ.get(zslx);
        // 证书编号校验
        String zsbh = dto.getZsbh();
        ErrorUtil.assertStringIsBlank(zsbh, ErrorMsg.ZSBH_NOT_NULL);
        // 社会信用代码校验
        String shxydm = dto.getShxydm();
        ErrorUtil.assertStringIsBlank(shxydm, String.format(ErrorMsg.SHXYDM_WHSJ_NOT_NULL, zslxMc));
        // 证书类型为‘第一类医疗器械生产备案’时，企业类型=‘一类’
        if (YwConstant.DYLYLQXSCBA.equals(zslx)) {
            ErrorUtil.assertStringIsBlank(dto.getQylx(), ErrorMsg.QYLX_WHSJ_NOT_NULL);
            ErrorUtil.assertFailure(!YwConstant.YL.equals(dto.getQylx()), ErrorMsg.QYLX_WHSJ_ERROR);
        }

        // TODO 统一社会信用代码不能为空 dto.getShxydm()
        ErrorUtil.assertFailure(shxydm.length() < 18, String.format(ErrorMsg.SHXYDM_LENGTH, zslxMc));
        ErrorUtil.assertFailure(!zslxList.contains(zslx), String.format(ErrorMsg.ZS_LX_WHSJ_NOT_FIND, zslxMc, zsbh, shxydm));
        ErrorUtil.assertFailure(!Arrays.asList(YwConstant.YWLX_LIST).contains(ywlx), String.format(ErrorMsg.YW_LX_WHSJ_NOT_FIND, zslxMc, zsbh, shxydm));
        // ErrorUtil.assertStringIsBlank(dto.getBbid(), ErrorMsg.BB_ID_NOT_NULL);
        // 发证机关校验
        String fzjg = StringUtils.isNotEmpty(dto.getFzjg()) ? dto.getFzjg() : dto.getYlzd31();
        ErrorUtil.assertStringIsBlank(fzjg, String.format(ErrorMsg.FZJG_WHSJ_NOT_NULL, zslxMc));
        String fzjgId = YwUtil.fzjgValid(dto.getFzjg(), deptService);
        dto.setFzjgid(fzjgId);
        // licenseId校验
        String licenseId = dto.getLicenseId();
        ErrorUtil.assertStringIsBlank(licenseId, String.format(ErrorMsg.LICENSE_ID_NOT_NULL, zslxMc, zsbh, shxydm));
        ErrorUtil.assertFailure(licenseId.length() > 32, ErrorMsg.LICENSE_ID_LENGTH);
        // 发证日期校验
        String fzrq = dto.getFzrq();
        ErrorUtil.assertStringIsBlank(fzrq, String.format(ErrorMsg.FZRQ_WHSJ_NOT_NULL, zslxMc, zsbh, shxydm));
        ErrorUtil.assertFailure(!YwUtil.checkDate(fzrq), String.format(ErrorMsg.FZRQ_WHSJ_PATTERN, zslxMc, zsbh, shxydm));
        Date fzrqDate = fzrq.length() > 10 ? YwUtil.strToDate(fzrq, YwConstant.YMDHMS) : YwUtil.strToDate(fzrq, YwConstant.YMD);
        ErrorUtil.assertFailure(null == fzrqDate, String.format(ErrorMsg.FZRQ_WHSJ_PATTERN, zslxMc, zsbh, shxydm));
        // 有效期至校验
        String yxqz = dto.getYxqz();
        if (YwConstant.ZSLX_MZYP_AND_JSYPYJZM.equals(zslx)) {
            ErrorUtil.assertStringIsBlank(yxqz, String.format(ErrorMsg.YXQZ_NOT_NULL, zslxMc, zsbh, shxydm));
        }
        // 有些证没有有效期至，只有发证日期
        Date yxqzDate = null;
        if (StringUtils.isNotEmpty(yxqz)) {
            ErrorUtil.assertFailure(!YwUtil.checkDate(yxqz), String.format(ErrorMsg.YXQZ_WHSJ_PATTERN, zslxMc, zsbh, shxydm));
            yxqzDate = yxqz.length() > 10 ? YwUtil.strToDate(yxqz, YwConstant.YMDHMS) : YwUtil.strToDate(yxqz, YwConstant.YMD);
            if (YwConstant.ZSLX_MZYP_AND_JSYPYJZM.equals(zslx)) {
                ErrorUtil.assertFailure(null == yxqzDate, String.format(ErrorMsg.YXQZ_WHSJ_PATTERN, zslxMc, zsbh, shxydm));
            }
        }
        //发证日期 跟有效期至 判断是否有效
        if (!YwlxEnum.ZHUXIAO.getCode().equals(ywlx)) {
            ErrorUtil.assertDateStrNotMoreThanCurrentDate(DateUtils.parseDateToStr("yyyy-MM-dd", fzrqDate),
                    String.format(ErrorMsg.FZ_RQ, zslxMc, zsbh, shxydm));
            if (null != yxqzDate) {
                ErrorUtil.assertDateStrNotLessThanCurrentDate(DateUtils.parseDateToStr("yyyy-MM-dd", yxqzDate),
                        String.format(ErrorMsg.JZ_RQ, zslxMc, zsbh, shxydm));
            }
        }
        ErrorUtil.assertStringIsBlank(dto.getQymc(), String.format(ErrorMsg.ZSLX_ZSBH_SHXYDM, zslxMc, zsbh, shxydm) + ErrorMsg.QYMC_NOT_NULL);
        ErrorUtil.assertSpecialChar(dto.getQymc(), String.format(ErrorMsg.ZSLX_ZSBH_SHXYDM, zslxMc, zsbh, shxydm) + "企业名称" + ErrorMsg.TS_ZF);

        // 【第一类医疗器械产品备案】、【麻醉药品、第一类精神药品运输证明】、【麻醉药品和精神药品邮寄证明】没有法人
        if (!Arrays.asList(YwConstant.DYLCPBA_MZ_JSYP).contains(zslx)) {
            String fddbr = dto.getFddbr();
            ErrorUtil.assertStringIsBlank(fddbr, String.format(ErrorMsg.ZSLX_ZSBH_SHXYDM, zslxMc, zsbh, shxydm) + ErrorMsg.FDDBR_NOT_NULL);
            ErrorUtil.assertSpecialChar(fddbr, String.format(ErrorMsg.ZSLX_ZSBH_SHXYDM, zslxMc, zsbh, shxydm) + "法人代表人" + ErrorMsg.TS_ZF);
        }
        // 住所校验-20240822-林*让加
        if (YwConstant.WHSJ_DYLYLQXSCBA.equals(zslx)) {
            ErrorUtil.assertStringIsBlank(dto.getZcdz(), ErrorMsg.ZC_NOT_NULL);
        }
        // 地区信息校验
        ErrorUtil.assertFailure(StringUtils.isEmpty(dto.getAreaCode()) || StringUtils.isEmpty(dto.getAreaName()),
                String.format(ErrorMsg.AREA_INFO_NOT_NULL, zslxMc, zsbh, shxydm));
        // 办件编码或事项编码校验
        ErrorUtil.assertFailure(StringUtils.isEmpty(dto.getProjectNo()) || StringUtils.isEmpty(dto.getTaskCode()),
                String.format(ErrorMsg.BJBM_SXBM_NOT_NULL, zslxMc, zsbh, shxydm));

        // 变更明细校验
        if (YwlxEnum.HUANFA.getCode().equals(ywlx) || YwlxEnum.BIANGE.getCode().equals(ywlx)) {
            List<WhsjBgmxDataReqDto> bgmxList = dto.getBgmxList();
            ErrorUtil.assertFailure(CollectionUtils.isEmpty(bgmxList) , ErrorMsg.BGMX_LIST_NOT_NULL);

            // 变更明细重复校验
            for (WhsjBgmxDataReqDto bgmx : bgmxList) {
                CertInfoOperationDetail mxDb = certInfoOperationDetailService.getById(bgmx.getId());
                ErrorUtil.assertFailure(null != mxDb, String.format(ErrorMsg.WHSJ_BGMX_REPEAT, zslxMc, zsbh, shxydm));
                // 变更明细字段值不能为空
                ErrorUtil.assertFailure((StringUtils.isEmpty(bgmx.getAfterValue()) || StringUtils.isEmpty(bgmx.getBeforeValue())
                        || StringUtils.isEmpty(bgmx.getColumnName()) || StringUtils.isEmpty(bgmx.getColumnDesc())),
                        String.format(ErrorMsg.WHSJ_BGMX_FEILD_NOT_NULL, zslxMc, zsbh, shxydm));
            }
        }
        // 子表校验（非注销 且 证书类型为“医疗器械网络销售备案” 校验子表不能为空）
        if (!YwlxEnum.ZHUXIAO.getCode().equals(dto.getYwlx()) && YwConstant.ZSLX_YLQXWLXSBA.equals(dto.getZslx())) {
            ErrorUtil.assertFailure(CollectionUtils.isEmpty(dto.getZbList()), ErrorMsg.YJQXWLXSBA_ZBLIST_IS_NULL);
        }
    }

    /**
     * 保存-子表信息
     * 64-医疗器械网络销售备案(有子表)-自动盖章
     * 46-第一类医疗器械生产备案(有子表)-手动盖章
     * @param dto
     * @param wgzId
     */
    private void saveZb(WhsjDataReqDto dto, String wgzId) {
        if (YwConstant.ZSLX_YLQXWLXSBA.equals(dto.getZslx())) {
            // 根据证书ID查询是否有老数据，如果有直接删除
            List<BaQxwlxsbaZb> oldList = baQxwlxsbaZbService.selectByMainId(dto.getLicenseId());
            if (!CollectionUtils.isEmpty(oldList)) {
                baQxwlxsbaZbService.removeBatchByIds(oldList);
            }
            // 医疗器械网络销售备案(有子表)-64
            List<BaQxwlxsbaZb> inZbList = new ArrayList<>();
            List<WhsjZbDataReqDto> outZbList = dto.getZbList();
            if (!CollectionUtils.isEmpty(outZbList)) {
                WhsjZbDataReqDto zbData = outZbList.get(0);
                List<Map<String, Object>> zbDataList = zbData.getData();
                for (Map<String, Object> map : zbDataList) {
                    JSONObject outZb = new JSONObject(map);
                    BaQxwlxsbaZb inZb = JSONObject.parseObject(outZb.toJSONString(), BaQxwlxsbaZb.class);
                    if (StringUtils.isEmpty(inZb.getZsid())) {
                        inZb.setZsid(dto.getLicenseId());
                    }
                    inZb.setShxydm(dto.getShxydm());
                    inZb.setDsfptbafptmc(null == outZb.get("ptmc") ? "" : outZb.get("ptmc").toString());
                    inZb.setXzspid(wgzId);
                    if (StringUtils.isEmpty(inZb.getNum())) {
                        inZb.setNum(null == outZb.get("xh") ? "" : outZb.get("xh").toString());
                    }
                    inZbList.add(inZb);
                }
                baQxwlxsbaZbService.saveBatch(inZbList);
            }
        } else if (YwConstant.ZSLX_DYLYLQXSCBA.equals(dto.getZslx())) {
            // 根据证书ID查询是否有老数据，如果有直接删除
            List<TJcZsDylylqxscbapzZb> oldList = itJcZsDylylqxscbapzZbService.selectByMainId(dto.getLicenseId());
            if (!CollectionUtils.isEmpty(oldList)) {
                itJcZsDylylqxscbapzZbService.removeBatchByIds(oldList);
            }
            // 第一类医疗器械生产备案(有子表)-46
            List<TJcZsDylylqxscbapzZb> inZbList = new ArrayList<>();
            List<WhsjZbDataReqDto> outZbList = dto.getZbList();
            if (!CollectionUtils.isEmpty(outZbList)) {
                WhsjZbDataReqDto zbData = outZbList.get(0);
                List<Map<String, Object>> zbDataList = zbData.getData();
                for (Map<String, Object> map : zbDataList) {
                    JSONObject outZb = new JSONObject(map);
                    TJcZsDylylqxscbapzZb inZb = JSONObject.parseObject(outZb.toJSONString(), TJcZsDylylqxscbapzZb.class);
                    if (StringUtils.isEmpty(inZb.getZsid())) {
                        inZb.setZsid(dto.getLicenseId());
                    }
                    inZb.setShxydm(dto.getShxydm());
                    inZb.setZczh(null == outZb.get("cpbah") ? "" : outZb.get("cpbah").toString());
                    inZb.setCplbDm(null == outZb.get("lxlb") ? "" : outZb.get("lxlb").toString());
                    inZb.setSfwtsc(null == outZb.get("sfstsc") ? "" : outZb.get("sfstsc").toString());
                    inZb.setZt(new BigDecimal(YwConstant.ZT_WGZ));
                    inZb.setXzspid(wgzId);
                    if (!BigDecimal.ZERO.equals(inZb.getNum())) {
                        inZb.setNum(null == outZb.get("xh") ? null : new BigDecimal(outZb.get("xh").toString()));
                    }
                    inZbList.add(inZb);
                }
                itJcZsDylylqxscbapzZbService.saveBatch(inZbList);
            }
        }
    }

    /**
     * 第一类医疗器械生产备案-46-子表（手动盖章）
     * @return
     */
    private List<WhsjZsyGyDto> dylYlqxScBaZb () {
        List<WhsjZsyGyDto> zbList = new ArrayList<>();

        TableName tableDyl = TJcZsDylylqxscbapzZb.class.getAnnotation(TableName.class);
        String tableName = tableDyl.value();

        WhsjZsyGyDto dto1 = new WhsjZsyGyDto("主键", "id", "1", "500", "0", tableName);
        WhsjZsyGyDto dto2 = new WhsjZsyGyDto("序号", "xh", "1", "22", "1", tableName);
        WhsjZsyGyDto dto3 = new WhsjZsyGyDto("类型类别", "lxlb", "1", "200", "1", tableName);
        WhsjZsyGyDto dto4 = new WhsjZsyGyDto("注册/备案人地址", "zcbardz", "1", "1000", "1", tableName);
        WhsjZsyGyDto dto5 = new WhsjZsyGyDto("注册/备案人名称", "zcbarmc", "1", "500", "1", tableName);
        WhsjZsyGyDto dto6 = new WhsjZsyGyDto("委托期限", "wtqx", "1", "50", "1", tableName);
        WhsjZsyGyDto dto7 = new WhsjZsyGyDto("产品名称", "cpmc", "1", "200", "1", tableName);
        WhsjZsyGyDto dto8 = new WhsjZsyGyDto("产品备案号", "cpbah", "1", "200", "1", tableName);
        WhsjZsyGyDto dto9 = new WhsjZsyGyDto("是否受托生产", "sfstsc", "1", "20", "1", tableName);
        WhsjZsyGyDto dto10 = new WhsjZsyGyDto("备注", "bz", "1", "1000", "1", tableName);

        zbList.add(dto1);
        zbList.add(dto2);
        zbList.add(dto3);
        zbList.add(dto4);
        zbList.add(dto5);
        zbList.add(dto6);
        zbList.add(dto7);
        zbList.add(dto8);
        zbList.add(dto9);
        zbList.add(dto10);
        return zbList;
    }

    /**
     * 医疗器械网络销售备案-64-子表（自动盖章）
     * @return
     */
    private List<WhsjZsyGyDto> ylqxWlxsBaZb () {
        List<WhsjZsyGyDto> zbList = new ArrayList<>();

        TableName tableDyl = BaQxwlxsbaZb.class.getAnnotation(TableName.class);
        String tableName = tableDyl.value();
        WhsjZsyGyDto dto1 = new WhsjZsyGyDto("id", "主键", "1", "100", "0", tableName);
        WhsjZsyGyDto dto2 = new WhsjZsyGyDto("xh", "序号", "1", "50", "1", tableName);
        WhsjZsyGyDto dto3 = new WhsjZsyGyDto("pzbh", "医疗器械交易服务第三方平台备案凭证编号", "1", "100", "1", tableName);
        WhsjZsyGyDto dto4 = new WhsjZsyGyDto("ptmc", "医疗器械交易服务第三方平台备案平台名称", "1", "200", "1", tableName);
        WhsjZsyGyDto dto5 = new WhsjZsyGyDto("bz", "备注", "1", "4000", "1", tableName);
        zbList.add(dto1);
        zbList.add(dto2);
        zbList.add(dto3);
        zbList.add(dto4);
        zbList.add(dto5);
        return zbList;
    }

    /**
     * 返回成功的DataResult
     * @param id
     * @return
     */
    private DataResult dataResultOk(String id) {
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("licenseId", id);
        return DataResult.ok(new JSONObject(resMap));
    }

    @ApiOperation(value="测试-根据证书类型获取证书元集合", notes="测试-根据证书类型获取证书元集合")
    @GetMapping(value = "/getList")
    public String getList(@RequestParam String zslx) {
        List<CertMetadata> certMetadataList = iCertMetadataService.selectZsyByZslx(zslx);
        return JSONObject.toJSONString(certMetadataList);
    }

}
