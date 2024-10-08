package org.jeecg.modules.demo.dzzz.dataExchange.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.jeecg.common.util.UUIDGenerator;
import org.jeecg.modules.demo.dzzz.certInfoOperation.entity.CertInfoOperationRecord;
import org.jeecg.modules.demo.dzzz.certInfoOperation.service.ICertInfoOperationRecordService;
import org.jeecg.modules.demo.dzzz.certarea.entity.CertArea;
import org.jeecg.modules.demo.dzzz.certarea.service.ICertAreaService;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertInfo;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertHandleService;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertInfoService;
import org.jeecg.modules.demo.dzzz.certtype.entity.CertType;
import org.jeecg.modules.demo.dzzz.certtype.service.ICertTypeService;
import org.jeecg.modules.demo.dzzz.constant.YwConstant;
import org.jeecg.modules.demo.dzzz.dataExchange.dto.SscjDataReqDto;
import org.jeecg.modules.demo.dzzz.dataExchange.dto.SscjYlqxDataReqDto;
import org.jeecg.modules.demo.dzzz.dataExchange.dto.SscjYpjyDataReqDto;
import org.jeecg.modules.demo.dzzz.dataExchange.entity.TYwSjJlb;
import org.jeecg.modules.demo.dzzz.dataExchange.entity.TYwSjXyb;
import org.jeecg.modules.demo.dzzz.dataExchange.exception.ErrorMsg;
import org.jeecg.modules.demo.dzzz.dataExchange.exception.ErrorUtil;
import org.jeecg.modules.demo.dzzz.dataExchange.exception.YwException;
import org.jeecg.modules.demo.dzzz.dataExchange.service.ITYwSjJlbService;
import org.jeecg.modules.demo.dzzz.dataExchange.service.ITYwSjXybService;
import org.jeecg.modules.demo.dzzz.dataExchange.util.YwUtil;
import org.jeecg.modules.demo.dzzz.dataExchange.vo.DataResult;
import org.jeecg.modules.demo.dzzz.dept.service.ISDeptService;
import org.jeecg.modules.demo.dzzz.enums.YwlxEnum;
import org.jeecg.modules.demo.dzzz.information.entity.Information;
import org.jeecg.modules.demo.dzzz.information.service.IInformationService;
import org.jeecg.modules.demo.dzzz.util.DateUtils;
import org.jeecg.modules.demo.dzzz.wgz.entity.ZsYwxxb;
import org.jeecg.modules.demo.dzzz.wgz.service.IZsYwxxbService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Api(tags="数据流转-省市场局")
@RestController
@RequestMapping("/xk")
@Slf4j
public class SScjController {
    @Autowired
    private IZsYwxxbService zsYwxxbService;
    @Autowired
    private ITYwSjJlbService tYwSjJlbService;
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
    private ICertAreaService certAreaService;
    @Autowired
    private ITYwSjXybService tYwSjXybService;

    // 药品证书类型List
    private List<String> ypZslxList = Arrays.asList("12", "13");

    @ApiOperation(value="省市场局数据推送-药品经营许可", notes="省市场局数据推送-药品经营许可")
    @PostMapping(value = "/ypjyxk")
    public DataResult ypjyxk(@RequestBody SscjYpjyDataReqDto dto) {
        // 数据校验 + 数据入库 + 自动盖章
        return dataValidAndWrite(ypZslxList, dto);
    }

    @ApiOperation(value="省市场局-数据推送-医疗器械许可", notes="省市场局数据推送-医疗器械许可")
    @PostMapping(value = "/ylqxxk")
    public DataResult ylqxxk(@RequestBody SscjYlqxDataReqDto dto) {
        // 数据校验 + 数据入库 + 自动盖章
        return dataValidAndWrite(Arrays.asList("14", "15"), dto);
    }

    @ApiOperation(value="省市场局-数据推送-注销", notes="省市场局-数据推送-注销")
    @PostMapping(value = "/zx")
    public DataResult zx(@RequestBody SscjDataReqDto dto) {
        // 数据校验
        DataResult validResult = validateData(Arrays.asList("12", "13", "14", "15"), dto, true, certTypeService);
        if (!validResult.isSuccess()) {
            return validResult;
        }
        try {
            CertInfo certInfo = (CertInfo) validResult.getData();
            // 更新为注销状态
            CertInfo updInfo = new CertInfo();
            updInfo.setId(certInfo.getId());
            updInfo.setYxzt(YwConstant.ZSZT_ZX);
            updInfo.setZszt(YwlxEnum.ZHUXIAO.getCode());
            updInfo.setJsly(YwConstant.JLLY_SSCJ);
            updInfo.setSjtbSscj(String.valueOf(YwConstant.CONFIRM));
            updInfo.setSjzx(String.valueOf(YwConstant.CONFIRM));
            certInfoService.updateById(updInfo);
            // 保存-操作记录表
            saveCzjl(dto);
            return dataResultOk(dto.getId());

        } catch (Exception e) {
            validResult = DataResult.error(e.getMessage());
            // 保存-推送数据记录表
            saveTYwSjJlb(dto, validResult);
            log.error(e.getMessage());
            return validResult;
        }
    }

    /**
     * 数据校验 + 数据入库 + 自动盖章
     * @param zslxList
     * @param dto
     * @return
     */
    private DataResult dataValidAndWrite(List<String> zslxList, SscjDataReqDto dto) {
        try {
            // 数据校验
            DataResult validResult = validateData(zslxList, dto, false, certTypeService);
            if (!validResult.isSuccess()) {
                return validResult;
            }
            // 保存-企业信息，存在则更新
            String qyId = saveOrUpdateQyxx(dto);
            // 保存-未盖章信息表
            String id = saveZsYwxxb(dto, qyId);
            // 保存-操作记录表
            saveCzjl(dto);

            // 非注销
            if (!YwlxEnum.ZHUXIAO.getCode().equals(dto.getYwlx())) {
                // 省市场局自动盖章
                String resMsg = certHandleService.batchGzFromWgz(new String[]{ id }, null, "", "", null);
                log.info("省市场局自动盖章结果：{}", resMsg);
                // 盖章错误信息返回给用户
                if (!YwConstant.GZ_SUCCESS.equals(resMsg) && !YwConstant.SC_ZS_SUCCESS.equals(resMsg)) {
                    validResult.setMsg(resMsg);
                }
                // TODO 盖完章后，调用省市场局接口回传数据
            }
            // 保存信用办数据
            tYwSjXybService.saveXyb(dto, null);

            return validResult;
        } catch (Exception e) {
            DataResult validResult = DataResult.error(e.getMessage());
            // 保存-推送数据记录表
            saveTYwSjJlb(dto, validResult);
            log.error(e.getMessage());
            return validResult;
        }
    }

    /**
     * 校验数据
     * @param zslxList 各业务处理的证书类型
     * @param dto 请求参数
     * @param isZx 是否注销接口过来
     * @return
     */
    private DataResult validateData(List<String> zslxList, SscjDataReqDto dto, boolean isZx, ICertTypeService certTypeService) {
        DataResult validResult;
        try {
            // 非空校验
            CertInfo certInfo = dto.valid(zslxList, dto, isZx, certInfoService, certTypeService);
            String ywlx = dto.getYwlx();
            if (!isZx) {
                ErrorUtil.assertFailure(YwlxEnum.ZHUXIAO.getCode().equals(ywlx), ErrorMsg.NOT_ZX_JK);
            }

            // 换发、变更、强制维护、补发时 可以修改证书编号
            String zsbh = dto.getZsbh();
            if ((YwlxEnum.HUANFA.getCode().equals(ywlx) || YwlxEnum.BIANGE.getCode().equals(ywlx)
                    || YwlxEnum.QZWH.getCode().equals(ywlx) || YwlxEnum.BUFA.getCode().equals(ywlx) )
                    && StringUtils.isNotBlank(dto.getNewZsbh()) && StringUtils.isNotBlank(dto.getNewZsbh().trim())
                    && !zsbh.trim().equals(dto.getNewZsbh().trim())) {
                zsbh = dto.getNewZsbh().trim();
                ErrorUtil.assertStringIsBlank(zsbh, ErrorMsg.ZSBH_NOT_NULL);
            }

            // 20240328 获取最新的证书类型
            String zslx = dto.getZslx();
            if ((YwlxEnum.HUANFA.getCode().equals(ywlx) || YwlxEnum.BIANGE.getCode().equals(ywlx)
                    || YwlxEnum.QZWH.getCode().equals(ywlx) || YwlxEnum.BUFA.getCode().equals(ywlx) )
                    && StringUtils.isNotBlank(dto.getNewZslx()) && StringUtils.isNotBlank(dto.getNewZslx().trim())
                    && !zslx.trim().equals(dto.getNewZslx().trim())) {
                zslx = dto.getNewZslx().trim();
                ErrorUtil.assertStringIsBlank(zslx, ErrorMsg.ZSLX_NOT_NULL);
            }

            if (YwlxEnum.ZHUXIAO.getCode().equals(ywlx)) {
                // 注销（办件编号、办件事项编码）不能为空
                ErrorUtil.assertStringIsBlank(dto.getBjbh(), ErrorMsg.BJBH_NOT_NULL);
                ErrorUtil.assertStringIsBlank(dto.getTaskCode(), ErrorMsg.BJSXBM_NOT_NULL);
                zxAndZsbhValid(zsbh, zslx, dto.getFzrq());
                // 查询是否有证书记录，没有给出提示
                ErrorUtil.assertFailure(null == certInfo, ErrorMsg.ZS_NO_EXIST);
                // 如果当前已经为注销状态，给出提示
                ErrorUtil.assertFailure(YwConstant.ZSZT_ZX.equals(certInfo.getYxzt()), ErrorMsg.ZS_YZX);

                // 保存-推送数据记录表
                saveTYwSjJlb(dto, dataResultOk(dto.getId()));
                return DataResult.ok(certInfo);

            } else {
                ErrorUtil.assertDateStrNotMoreThanCurrentDate(dto.getFzrq(), ErrorMsg.FZ_RQ);
                ErrorUtil.assertDateStrNotLessThanCurrentDate(dto.getJzrq(), ErrorMsg.JZ_RQ);

                // 20231110省市局要求根据singId 判断已生成的证书信息
                LambdaQueryWrapper<TYwSjJlb> jlbQuery = new LambdaQueryWrapper();
                jlbQuery.eq(TYwSjJlb :: getYwid, dto.getSingId());
                jlbQuery.eq(TYwSjJlb :: getJlzt, YwConstant.CONFIRM);
                List<TYwSjJlb> jlbList = tYwSjJlbService.list(jlbQuery);
                if (!CollectionUtils.isEmpty(jlbList)) {
                    TYwSjJlb jlb = jlbList.get(0);
                    dto.setZsid(jlb.getZsid());
                    // 强制维护，不限制推送【2024-09-27 已盖章出现重复数据，去掉这块】
//                    if (!YwlxEnum.QZWH.getCode().equals(ywlx)) {
//                        ErrorUtil.assertFailure(null != jlb, ErrorMsg.ZS_EXIST);
//                    }
                }

                // 对发证机关校验，并给发证机关ID赋值
                dto.setFzjgid(YwUtil.fzjgValid(dto.getFzjg(), deptService));
                if (YwlxEnum.HEFA.getCode().equals(ywlx)) {
                    // 根据证书编号、证书类型、业务类型查询，如果存在则提示：当前企业已有该核发类型许可,无需继续推送!
                    LambdaQueryWrapper<ZsYwxxb> wgzQuery = new LambdaQueryWrapper();
                    wgzQuery.eq(ZsYwxxb :: getZsbh, dto.getZsbh());
                    wgzQuery.eq(ZsYwxxb :: getZslx, dto.getZslx());
                    wgzQuery.eq(ZsYwxxb :: getZszt, dto.getYwlx());
                    List<ZsYwxxb> zsList = zsYwxxbService.list(wgzQuery);
                    ErrorUtil.assertFailure(!CollectionUtils.isEmpty(zsList), ErrorMsg.HF_ZS_EXIST);

                } else {
                    if (YwlxEnum.BIANGE.getCode().equals(ywlx) || YwlxEnum.QZWH.getCode().equals(ywlx)) {
                        // 变更对内容和时间进行校验
                        ErrorUtil.assertStringIsBlank(dto.getBgnr(), ErrorMsg.BGNR_NOT_NULL);
                        ErrorUtil.assertStringIsBlank(dto.getBgsj(), ErrorMsg.BGSJ_NOT_NULL);

                        // 变更业务时，判断同一条变更信息是不是重复推送了
                        String bgnr = operationRecordService.selectBgJlByParams(dto);
                        ErrorUtil.assertFailure(StringUtils.isNotBlank(bgnr) && bgnr.equals(dto.getBgnr()),
                                String.format(ErrorMsg.BG_JL_CF, YwConstant.ZSLX_SSCJ.get(dto.getZslx()), dto.getZsbh(), dto.getBgsj()));
                    }
                    // 如果不存在则提示：查不到历史证书!
                    ErrorUtil.assertFailure(null == certInfo, String.format(ErrorMsg.NO_FIND_HISTORY,
                            YwConstant.ZSLX_SSCJ.get(dto.getZslx()), dto.getZsbh()));
                }

                // （药品许可）非注销业务对证书编号校验
                notZxAndZsbhValid(zsbh, zslx);
                // 判断证书编号是否重复
                String errorMsg = checkZsbh(dto);
                ErrorUtil.assertFailure(StringUtils.isNotBlank(errorMsg), errorMsg);

                if ((YwlxEnum.HUANFA.getCode().equals(ywlx) || YwlxEnum.BIANGE.getCode().equals(ywlx)
                        || YwlxEnum.QZWH.getCode().equals(ywlx) || YwlxEnum.BUFA.getCode().equals(ywlx) )
                        && StringUtils.isNotBlank(dto.getNewZsbh()) && StringUtils.isNotBlank(dto.getNewZsbh().trim())
                        && !dto.getZsbh().trim().equals(dto.getNewZsbh().trim())) {
                    dto.setZsbh(dto.getNewZsbh());
                }
                if ((YwlxEnum.HUANFA.getCode().equals(ywlx) || YwlxEnum.BIANGE.getCode().equals(ywlx)
                        || YwlxEnum.QZWH.getCode().equals(ywlx) || YwlxEnum.BUFA.getCode().equals(ywlx) )
                        && StringUtils.isNotBlank(dto.getNewZslx()) && StringUtils.isNotBlank(dto.getNewZslx().trim())
                        && !dto.getZslx().trim().equals(dto.getNewZslx().trim())) {
                    ErrorUtil.assertFailure(!ypZslxList.contains(zslx), ErrorMsg.ZS_LX_NOT_FIND);
                    dto.setZslx(dto.getNewZslx());
                }
            }
            validResult = dataResultOk(dto.getId());

        } catch (YwException e) {
            if (ErrorMsg.ZS_EXIST.equals(e.getMessage())) {
                validResult = DataResult.error(YwConstant.ERROR_CODE_400, e.getMessage());
            } else {
                validResult = DataResult.error(e.getMessage());
            }
            log.error(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // 保存-推送数据记录表
        saveTYwSjJlb(dto, validResult);
        return validResult;
    }

    /**
     * 保存-未盖章证书信息表
     * @param dto 请求参数
     */
    private String saveZsYwxxb(SscjDataReqDto dto, String qyId) {
        LambdaQueryWrapper<CertType> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(CertType :: getZslx, dto.getZslx());
        lambdaQueryWrapper.eq(CertType :: getStatus, YwConstant.CERT_TYPE_STATUS_FB);
        CertType certType = certTypeService.getOne(lambdaQueryWrapper);
        ErrorUtil.assertFailure(null == certType || StringUtils.isBlank(certType.getId()), ErrorMsg.ZS_LX_NOT_EXIST);

        ZsYwxxb bean = new ZsYwxxb();
        BeanUtils.copyProperties(dto, bean);
        bean = dto.buildZsYwxxb(bean, certType.getId());
        bean.setFzrq(dto.getFzrq());
        bean.setYxqz(dto.getJzrq());
        bean.setQyid(qyId);

        log.info("未盖章证书表：{}", JSONObject.toJSONString(bean));
        zsYwxxbService.save(bean);
        return bean.getId();
    }

    /**
     * 保存或更新-企业信息表
     * @param dto 请求参数
     */
    private String saveOrUpdateQyxx(SscjDataReqDto dto) {
        LambdaQueryWrapper<Information> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Information :: getEntzzjgdm, dto.getShxydm());
        Information info = informationService.getOne(queryWrapper);
        if (null != info && StringUtils.isNotBlank(info.getId())) {
            log.info("已存在企业信息，进行更新企业信息");
        }
        Information bean = dto.buildQyxx(info);
        CertArea area = certAreaService.selectAreaByAreaName(dto.getSzqx());
        if (null != area) {
            bean.setAdmindivision(area.getAreacode());
        }
        informationService.saveOrUpdate(bean);
        return bean.getId();
    }

    /**
     * 保存-操作记录表
     * @param dto 请求参数
     */
    private void saveCzjl(SscjDataReqDto dto) {
        CertInfoOperationRecord bean = new CertInfoOperationRecord();
        bean.setId(UUIDGenerator.generate());
        bean.setCreateBy(YwConstant.JLLY_SSCJ);
        bean.setCreateTime(new Date());
        bean.setYwlx(dto.getYwlx());
        bean.setBglx(dto.getYwlx());
        bean.setZsid(dto.getZsid());
        bean.setSjly(YwConstant.JLLY_SSCJ);
        bean.setStutas("20");
        bean.setCzsj(new Date());

        // 换发、变更，写入变更信息
        if (YwlxEnum.HUANFA.getCode().equals(dto.getYwlx()) || YwlxEnum.BIANGE.getCode().equals(dto.getYwlx())
                || YwlxEnum.QZWH.getCode().equals(dto.getYwlx())) {
            bean.setBgnr(dto.getBgnr());
            bean.setCzrq(dto.getBgsj());
            bean.setBgcs(dto.getBgcs());
        }
        operationRecordService.save(bean);
    }

    /**
     * 保存-推送数据记录表
     * @param dto 请求参数
     * @param result
     */
    private void saveTYwSjJlb(SscjDataReqDto dto, DataResult result) {
        try {
            TYwSjJlb jlb = new TYwSjJlb();
            jlb.setJlly(YwConstant.JLLY_SSCJ);
            jlb.setZsid(StringUtils.isBlank(dto.getZsid()) ? "" : dto.getZsid());
            jlb.setZsbh(StringUtils.isBlank(dto.getZsbh()) ? "" : dto.getZsbh());
            jlb.setJlInJson(null == dto ? null : dto.getParams());
            jlb.setJlsj(DateUtils.getTodayStr());
            jlb.setZslx(StringUtils.isEmpty(dto.getZslx()) ? "" : dto.getZslx());
            jlb.setJlzt(result.isSuccess() ? YwConstant.CONFIRM : YwConstant.DENY);
            jlb.setYwlx(StringUtils.isBlank(dto.getYwlx()) ? "" : dto.getYwlx());
            jlb.setYwid(StringUtils.isBlank(dto.getSingId()) ? "" : dto.getSingId());
            jlb.setOutId(StringUtils.isBlank(dto.getId()) ? "" : dto.getId());
            jlb.setJlOutJson(JSONObject.toJSONString(result));
            tYwSjJlbService.save(jlb);
        } catch (Exception ex) {
            log.error("省市场局-推送数据-业务记录表，写入失败！", ex);
        }
    }

    /**
     * （药品许可）非注销业务对证书编号校验
     * 证书编号规则校验添加 鄂AA0271*****
     * 1、判断第一个字是否是“鄂”，
     * 2、第二位字：A表示批发企业，B表示零售连锁企业，C表示零售连锁门店，D表示单体零售企业;
     * 3、总长度是否是12位
     * @param zsbh
     * @param zslx
     */
    public void notZxAndZsbhValid(String zsbh, String zslx) {
        if (ypZslxList.contains(zslx)) {
            String zsbh_one = zsbh.substring(0,1);
            ErrorUtil.assertFailure(!Objects.equals(zsbh_one, "鄂"), ErrorMsg.ZS_BH_ZM_FIRST);
            String zsbh_tow =zsbh.substring(1,2);
            ErrorUtil.assertFailure(!Objects.equals(YwConstant.ZSBH_ZM_SECOND.get(zslx), zsbh_tow), ErrorMsg.ZS_BH_ZM_SECOND);
            ErrorUtil.assertFailure(zsbh.length() != 12, ErrorMsg.ZS_BH_LENGTH);
        }
    }

    /**
     * 2024年1月1日之前发的证，仅为注销时，可以正常推送，将证进行注销  其他业务类型 及注销时发证日期为2024年1月1日之后的 必须按照新的证书编号规则来
     * 2023-01-03 谭老师要求添加的新需求
     * （药品许可）注销业务对证书编号校验
     * 2024-01-01 之后 证书编号规则校验添加 鄂AA0271*****
     * 1、判断第一个字是否是“鄂”，
     * 2、第二位字：A表示批发企业，B表示零售连锁企业，C表示零售连锁门店，D表示单体零售企业;
     * 3、总长度是否是12位
     * @param zsbh
     * @param zslx
     * @param fzrq
     */
    public void zxAndZsbhValid(String zsbh, String zslx, String fzrq) throws Exception {
        if (ypZslxList.contains(zslx)) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date2 = sdf.parse("2024-01-01");

                Date fzrqDate = DateUtils.parseDate(fzrq, "yyyy-MM-dd");
                if (fzrqDate.compareTo(date2) >= 0) {
                    String zsbh_one =zsbh.substring(0,1);
                    ErrorUtil.assertFailure(!Objects.equals(zsbh_one, "鄂"), ErrorMsg.ZS_BH_ZX_ZM_FIRST);
                    String zsbh_tow = zsbh.substring(1, 2);
                    ErrorUtil.assertFailure(!Objects.equals(YwConstant.ZSBH_ZM_SECOND.get(zslx), zsbh_tow), ErrorMsg.ZS_BH_ZX_ZM_SECOND);
                    ErrorUtil.assertFailure(zsbh.length() != 12, ErrorMsg.ZS_BH_ZX_LENGTH);
                }
            } catch (ParseException e) {
                log.error(e.getMessage());
                throw new YwException("注销业务对证书编号校验出现异常");
            }
        }
    }


    //判断证书编号是否重复 //数据来源 市场局 ，应该不需要这个判断，不管入口是哪里 一个企业对应一个证
    public String checkZsbh(SscjDataReqDto dto) {
        String errMsg = "";

        String oldZsbh = dto.getZsbh();
        String newZsbh = dto.getNewZsbh();
        String shxydm = dto.getShxydm();
        String ywlx = dto.getYwlx();
        String qymc = dto.getQymc();
        String zslxName = YwConstant.ZSLX_SSCJ.get(dto.getZslx());
        //根据类型判断 或者证书编号
        String zsbh = oldZsbh;
        if ((YwlxEnum.HUANFA.getCode().equals(ywlx) || YwlxEnum.BIANGE.getCode().equals(ywlx)
                || YwlxEnum.QZWH.getCode().equals(ywlx) || YwlxEnum.BUFA.getCode().equals(ywlx) )
                && StringUtils.isNotBlank(newZsbh) && !zsbh.equals(newZsbh)) {
            zsbh = newZsbh;
        }
        // 查询证书类型ID
        LambdaQueryWrapper<CertType> certTypeQuery = new LambdaQueryWrapper();
        certTypeQuery.eq(CertType::getZslx, dto.getZslx());
        certTypeQuery.eq(CertType::getStatus, YwConstant.CERT_TYPE_STATUS_FB);
        List<CertType> certTypeList = certTypeService.list(certTypeQuery);
        ErrorUtil.assertFailure(CollectionUtils.isEmpty(certTypeList), ErrorMsg.ZS_LX_NOT_FIND);
        String certTypeId = certTypeList.get(0).getId();

        if (YwlxEnum.HEFA.getCode().equals(ywlx)) {
            LambdaQueryWrapper<CertInfo> queryWrapper = new LambdaQueryWrapper();
            queryWrapper.eq(CertInfo :: getZsbh, zsbh);
            queryWrapper.eq(CertInfo :: getCerttypeid, certTypeId);
            queryWrapper.ne(CertInfo :: getZszt, YwConstant.ZSZT_ZF);
            queryWrapper.ne(CertInfo :: getShxydm, shxydm);
            List<CertInfo> list = certInfoService.list(queryWrapper);
            //判断是否存在此证书编号
            if (!CollectionUtils.isEmpty(list)) {
                CertInfo vo = list.get(0);
                errMsg = "推送的证书【"+ zslxName +"】证书编号【"+ zsbh +"】企业名称【"+ qymc +"】社会信用代码【"+ shxydm +"】 与 证书编号【"
                        + vo.getZsbh() +"】企业名称【"+ vo.getQymc() +"】社会信用代码【"+ vo.getShxydm() +"】,其他企业信息存在重复信息!";
            }
        }
        if (!YwlxEnum.HEFA.getCode().equals(ywlx) && StringUtils.isNotEmpty(oldZsbh)
                && StringUtils.isNotEmpty(newZsbh) && !newZsbh.equals(oldZsbh)) {
            LambdaQueryWrapper<CertInfo> queryWrapper = new LambdaQueryWrapper();
            queryWrapper.eq(CertInfo :: getZsbh, newZsbh);
            queryWrapper.eq(CertInfo :: getCerttypeid, certTypeId);
            queryWrapper.ne(CertInfo :: getZszt, YwConstant.ZSZT_ZF);
            queryWrapper.ne(CertInfo :: getShxydm, shxydm);
            List<CertInfo> list = certInfoService.list(queryWrapper);
            //判断是否存在此证书编号
            if (!CollectionUtils.isEmpty(list)) {
                CertInfo vo = list.get(0);
                errMsg = "推送的证书【"+ zslxName +"】证书编号【"+ zsbh +"】企业名称【"+ qymc +"】社会信用代码【"+ shxydm +"】 与 证书编号【"
                        + vo.getZsbh() +"】企业名称【"+ vo.getQymc() +"】社会信用代码【"+ vo.getShxydm() +"】,其他企业信息存在重复信息!";
            }
        }
        //判断社会信用代码关联的证书编号是不是同一个 不是则返回true   保证一企业一个证
        if (!YwlxEnum.HEFA.getCode().equals(ywlx)) {
            LambdaQueryWrapper<CertInfo> queryWrapper = new LambdaQueryWrapper();
            queryWrapper.eq(CertInfo :: getShxydm, shxydm);
            queryWrapper.eq(CertInfo :: getCerttypeid, certTypeId);
            queryWrapper.ne(CertInfo :: getYxzt, YwConstant.ZSZT_ZF);
            List<CertInfo> list = certInfoService.list(queryWrapper);
            if (!CollectionUtils.isEmpty(list)) {
                if (!list.stream().filter(m -> m.getZsbh().equals(oldZsbh)).findAny().isPresent()) {
                    CertInfo vo = list.get(0);
                    errMsg = "推送的证书【"+ zslxName +"】证书编号【"+ oldZsbh +"】企业名称【"+ vo.getQymc() +"】社会信用代码【" + vo.getShxydm() +
                            "】 已换成证书编号 【"+ newZsbh +"】,请检查推送信息";
                }
            }
        }
        return errMsg;
    }

    /**
     * 保存信用办数据
     * @param dto
     */
    private void saveTYwSjXyb(SscjDataReqDto dto) {
        TYwSjXyb xyb = new TYwSjXyb();
        BeanUtils.copyProperties(dto, xyb);
        xyb.setXkFrdb(dto.getFddbr());
        xyb.setXkXkjg(dto.getFzjg());
        xyb.setXkLydw(dto.getFzjg());
        xyb.setYxqz(dto.getJzrq());
        xyb.setXkYxqz(dto.getJzrq());
        xyb.setXkXdrMc(dto.getQymc());
        xyb.setYwid(dto.getId());
        xyb.setDataUpStatus("1");
        xyb.setXkZt("1");
        xyb.setCreateTime(DateUtils.getTodayStr());
        tYwSjXybService.save(xyb);
    }

    /**
     * 返回成功的DataResult
     * @param id
     * @return
     */
    private DataResult dataResultOk(String id) {
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("xkId", id);
        return DataResult.ok(new JSONObject(resMap));
    }

}
