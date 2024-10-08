package org.jeecg.modules.demo.dzzz.dataExchange.dto;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang.StringUtils;
import org.jeecg.common.util.UUIDGenerator;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertInfo;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertInfoService;
import org.jeecg.modules.demo.dzzz.certtype.entity.CertType;
import org.jeecg.modules.demo.dzzz.certtype.service.ICertTypeService;
import org.jeecg.modules.demo.dzzz.dataExchange.exception.ErrorMsg;
import org.jeecg.modules.demo.dzzz.constant.YwConstant;
import org.jeecg.modules.demo.dzzz.dataExchange.exception.ErrorUtil;
import org.jeecg.modules.demo.dzzz.dataExchange.util.YwUtil;
import org.jeecg.modules.demo.dzzz.dataExchange.vo.DataResult;
import org.jeecg.modules.demo.dzzz.enums.YwlxEnum;
import org.jeecg.modules.demo.dzzz.information.entity.Information;
import org.jeecg.modules.demo.dzzz.util.DateUtils;
import org.jeecg.modules.demo.dzzz.wgz.entity.ZsYwxxb;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Data
@ApiModel(description="省市场局-公共请求参数")
public class SscjDataReqDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id", dataType = "String")
    private String id;

    @ApiModelProperty(value = "企业名称", dataType = "String")
    private String qymc;

    @ApiModelProperty(value = "统一社会信用代码", dataType = "String")
    private String shxydm;

    @ApiModelProperty(value = "法定代表人", dataType = "String")
    private String fddbr;

    @ApiModelProperty(value = "联系人", dataType = "String")
    private String lxr;

    @ApiModelProperty(value = "联系电话", dataType = "String")
    private String lxdh;

    @ApiModelProperty(value = "所在省", dataType = "String")
    private String szsf;

    @ApiModelProperty(value = "所在市", dataType = "String")
    private String szds;

    @ApiModelProperty(value = "所在县", dataType = "String")
    private String szqx;

    @ApiModelProperty(value = "业务类型", dataType = "String")
    private String ywlx;

    @ApiModelProperty(value = "证书类型", dataType = "String")
    private String zslx;

    @ApiModelProperty(value = "证书编号", dataType = "String")
    private String zsbh;

    @ApiModelProperty(value = "许可证有效截止日期（YYYY-MM-DD）", dataType = "String")
    private String jzrq;

    @ApiModelProperty(value = "企业负责人", dataType = "String")
    private String qyfzr;

    @ApiModelProperty(value = "发证日期（YYYY-MM-DD）", dataType = "String")
    private String fzrq;

    @ApiModelProperty(value = "发证机关", dataType = "String")
    private String fzjg;

    @ApiModelProperty(value = "发证机关ID", dataType = "String")
    private String fzjgid;

    @ApiModelProperty(value = "仓库地址", dataType = "String")
    private String ckdz;

    // =====================================================================
    // 非必填（业务类型为换发/变更时，必填）
    @ApiModelProperty(value = "变更内容（变更为必填项）", dataType = "String")
    private String bgnr;

    // 非必填（业务类型为换发/变更时，必填）
    @ApiModelProperty(value = "变更时间（变更为必填项）", dataType = "String")
    private String bgsj;

    // 非必填
    @ApiModelProperty(value = "变更次数", dataType = "String")
    private String bgcs;
    // =====================================================================

    // 非必填（业务类型为注销时，必填）
    @ApiModelProperty(value = "办件编号", dataType = "String")
    private String bjbh;

    // 非必填（业务类型为注销时，必填）
    @ApiModelProperty(value = "办件事项编码", dataType = "String")
    private String taskCode;

    // 非必填
    @ApiModelProperty(value = "新证书编号", dataType = "String")
    private String newZsbh;

    @ApiModelProperty(value = "市场局证书数据主键", dataType = "String")
    private String singId;

    // ================以下非必填===============================================
    @ApiModelProperty(value = "行政相对人代码_2 (工商注册号)", dataType = "String")
    private String xkxdrgszc;

    @ApiModelProperty(value = "行政相对人代码_3(组织机构代码)9位", dataType = "String")
    private String xkxdrzzjg;

    @ApiModelProperty(value = "行政相对人代码_4(税务登记号)", dataType = "String")
    private String xkxdrswdj;

    @ApiModelProperty(value = "行政相对人代码_5(事业单位证书号)", dataType = "String")
    private String xkxdrsydw;

    @ApiModelProperty(value = "行政相对人代码_6(社会组织登记证号)", dataType = "String")
    private String xkxdrshzz;

    @ApiModelProperty(value = "法定代表人证件类型，证件类型有：身份证、 护照号、港澳居民来往内地通行证、台湾居民来往大陆通行证、外国人永久居留身份证、或以“其他-**”开头。选填", dataType = "String")
    private String xkfrzhlx;

    @ApiModelProperty(value = "法定代表人身份证号，选填（法人及非法人组织、 个体工商户）", dataType = "String")
    private String xkfrzhhm;
    // ================非必填结束===============================================

    @ApiModelProperty(value = "行政许可决定文书名称，填写行政许可决定文书标题，例如“国家发展改革委关于 XXX 公司发行企业债券核准的批复(发改财金〔2015〕XXX 号)”中的“国家发展改革委关于 XXX 公司发行企业债券核准的批复”。必填", dataType = "String")
    private String xkxkws;

    @ApiModelProperty(value = "行政许可决定文书号,填写行政许可决定文书编号，如无行政许可决定文书编号，填写该行政许可的“许可编号”。必填", dataType = "String")
    private String xkwsh;

    @ApiModelProperty(value = "许可类别填写普通、 特许、 认可、 核准、登记或其他， 如为“其他”， 需注明具体类别。法人和非法人组织的登记信息， 在登记过程中按相关部门有关规定执行。必填", dataType = "String")
    private String xkxklb;

    @ApiModelProperty(value = "许可证书名称,填写行政许可证书名称，例如“煤矿生产许可证”。", dataType = "String")
    private String xkxkzs;

    @ApiModelProperty(value = "许可内容,填写行政许可决定书的主要内容。", dataType = "String")
    private String xknr;

    @ApiModelProperty(value = "许可机关统一社会信用代码", dataType = "String")
    private String xkxkjgdm;

    @ApiModelProperty(value = "证书ID", dataType = "String")
    @JsonIgnore
    private String zsid;

    @ApiModelProperty(value = "请求参数", dataType = "String")
    @JsonIgnore
    private String params;

    // 非必填
    @ApiModelProperty(value = "新证书类型", dataType = "String")
    private String newZslx;

    /**
     * 公共的校验
     * @param zslxList 证书类型List
     * @param dto 请求参数
     * @param isZx 是否注销
     * @return
     */
    public CertInfo valid(List<String> zslxList, SscjDataReqDto dto, boolean isZx, ICertInfoService certInfoService, ICertTypeService certTypeService) {
        ErrorUtil.assertFailure(null == dto, ErrorMsg.PARAMS_NOT_NULL);
        dto.setParams(JSONObject.toJSONString(dto));
        ErrorUtil.assertStringIsBlank(dto.getSingId(), ErrorMsg.SINGID_NOT_NULL);
        String ywlx = dto.getYwlx();
        ErrorUtil.assertStringIsBlank(ywlx, ErrorMsg.YWLX_NOT_NULL);
        // 证书类型转换
        ErrorUtil.assertStringIsBlank(dto.getZslx(), ErrorMsg.ZSLX_NOT_NULL);
        dto.setZslx(YwUtil.zslxConvert(Integer.parseInt(zslx)) + "");
        ErrorUtil.assertZsListNotExist(zslxList, dto.getZslx(), ErrorMsg.ZS_LX_NOT_FIND);
        // 新证书类型转换
        if (StringUtils.isNotBlank(dto.getNewZslx())) {
            dto.setNewZslx(YwUtil.zslxConvert(Integer.parseInt(dto.getNewZslx())) + "");
        }
        ErrorUtil.assertStringIsBlank(dto.getZsbh(), ErrorMsg.ZSBH_NOT_NULL);

        // 按照证书类型、证书编号，查询是否存在，不存在则未查询到历史数据；
        LambdaQueryWrapper<CertType> certTypeQuery = new LambdaQueryWrapper();
        certTypeQuery.eq(CertType::getZslx, dto.getZslx());
        certTypeQuery.eq(CertType::getStatus, YwConstant.CERT_TYPE_STATUS_FB);
        List<CertType> certTypeList = certTypeService.list(certTypeQuery);
        ErrorUtil.assertFailure(CollectionUtils.isEmpty(certTypeList), ErrorMsg.ZS_LX_NOT_FIND);

        // 查询是否有证书记录，如果有给zsid赋值
        LambdaQueryWrapper<CertInfo> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.in(CertInfo::getZsbh, Arrays.asList(dto.getZsbh(), dto.getNewZsbh()));
        queryWrapper.eq(CertInfo::getCerttypeid, certTypeList.get(0).getId());
        queryWrapper.ne(CertInfo::getYxzt, YwConstant.ZSZT_ZF);
        List<CertInfo> certList = certInfoService.list(queryWrapper);
        CertInfo certInfo = null;
        if (!CollectionUtils.isEmpty(certList)) {
            // 如果按证书编号、业务类型查，出现多条，再按‘统一社会信用代码’查询
            if (certList.size() > 1) {
                LambdaQueryWrapper<CertInfo> queryWrapperTwo = new LambdaQueryWrapper();
                queryWrapperTwo.in(CertInfo::getZsbh, Arrays.asList(dto.getZsbh(), dto.getNewZsbh()));
                queryWrapperTwo.eq(CertInfo::getCerttypeid, certTypeList.get(0).getId());
                queryWrapperTwo.eq(CertInfo::getShxydm, dto.getShxydm());
                queryWrapperTwo.ne(CertInfo::getYxzt, YwConstant.ZSZT_ZF);
                List<CertInfo> certListTwo = certInfoService.list(queryWrapperTwo);
                if (!CollectionUtils.isEmpty(certListTwo)) {
                    certInfo = certListTwo.get(0);
                }
            } else {
                certInfo = certList.get(0);
            }
            dto.setZsid(certInfo.getZsid());
        } else {
            dto.setZsid(dto.getSingId());
        }

        // 如果是注销接口，业务类型不是注销则提示错误
        if (isZx) {
            ErrorUtil.assertFailure(!YwlxEnum.ZHUXIAO.getCode().equals(ywlx), ErrorMsg.NO_ZX_YWLX);
        }
        ErrorUtil.assertStringIsBlank(dto.getQymc(), ErrorMsg.QYMC_NOT_NULL);
        ErrorUtil.assertStringIsBlank(dto.getShxydm(), ErrorMsg.SHXYDM_NOT_NULL);
        ErrorUtil.assertStringIsBlank(dto.getFddbr(), ErrorMsg.FDDBR_NOT_NULL);
        ErrorUtil.assertStringIsBlank(dto.getLxr(), ErrorMsg.LXR_NOT_NULL);
        ErrorUtil.assertStringIsBlank(dto.getLxdh(), ErrorMsg.LXDH_NOT_NULL);
        ErrorUtil.assertStringIsBlank(dto.getSzsf(), ErrorMsg.SZSF_NOT_NULL);
        ErrorUtil.assertStringIsBlank(dto.getSzds(), ErrorMsg.SZDS_NOT_NULL);
        ErrorUtil.assertStringIsBlank(dto.getSzqx(), ErrorMsg.SZQX_NOT_NULL);
        ErrorUtil.assertStringIsBlank(dto.getJzrq(), ErrorMsg.JZRQ_NOT_NULL);
        ErrorUtil.assertStringIsBlank(dto.getQyfzr(), ErrorMsg.QYFZR_NOT_NULL);
        ErrorUtil.assertStringIsBlank(dto.getFzrq(), ErrorMsg.FZRQ_NOT_NULL);
        ErrorUtil.assertStringIsBlank(dto.getFzjg(), ErrorMsg.FZJG_NOT_NULL);
        ErrorUtil.assertStringIsBlank(dto.getCkdz(), ErrorMsg.CKDZ_NOT_NULL);

        ErrorUtil.assertStringIsBlank(dto.getXkxkws(), ErrorMsg.XKXKWS_NOT_NULL);
        ErrorUtil.assertStringIsBlank(dto.getXkwsh(), ErrorMsg.XKWSH_NOT_NULL);
        ErrorUtil.assertStringIsBlank(dto.getXkxklb(), ErrorMsg.XKXKLB_NOT_NULL);
        ErrorUtil.assertStringIsBlank(dto.getXkxkzs(), ErrorMsg.XKXKZS_NOT_NULL);
        ErrorUtil.assertStringIsBlank(dto.getXknr(), ErrorMsg.XKNR_NOT_NULL);
        ErrorUtil.assertStringIsBlank(dto.getXkxkjgdm(), ErrorMsg.XKXKJGDM_NOT_NULL);
        ErrorUtil.assertSpecialChar(dto.getQymc(), "企业名称" + ErrorMsg.TS_ZF);
        ErrorUtil.assertSpecialChar(dto.getQyfzr(), "法人代表" + ErrorMsg.TS_ZF);
        String zslxMc = YwConstant.ZSLX_SSCJ.get(zslx);
        // TODO 统一社会信用代码不能为空 dto.getShxydm()
        ErrorUtil.assertFailure(dto.getShxydm().length() < 18, String.format(zslxMc, ErrorMsg.SHXYDM_LENGTH));
        return certInfo;
    }

    /**
     * 构建公共的未盖章证书信息
     * @param bean 未盖章证书证书信息
     * @param certTypeId 证书类型ID
     * @return
     */
    public ZsYwxxb buildZsYwxxb(ZsYwxxb bean, String certTypeId) {
        bean.setId(UUIDGenerator.generate());
        bean.setQyfzr(this.qyfzr);
        bean.setYwlb(this.ywlx);
        bean.setFzjg(this.fzjg);
        bean.setZsid(this.zsid);
        bean.setCerttypeid(certTypeId);
        bean.setZslx(this.zslx);
        bean.setSynctime(new Date());
        bean.setZt(YwConstant.GZ_SCZT_WGZ);
        bean.setJsly(YwConstant.JLLY_SSCJ);
        bean.setZszt(this.ywlx);
        bean.setYxzt(YwConstant.ZSZT_YX);
        bean.setSynctime(new Date());
        bean.setSync("0");
        return bean;
    }

    /**
     * 构建公共的企业信息
     * @param bean
     * @return
     */
    public Information buildQyxx(Information bean) {
        String qyId = UUIDGenerator.generate();
        if (null == bean || StringUtils.isEmpty(bean.getId())) {
            bean = new Information();
        } else {
            qyId = bean.getId();
        }
        bean.setId(qyId);
        bean.setEntname(this.qymc);
        bean.setEntzzjgdm(this.shxydm);
        bean.setEnts(this.szsf);
        bean.setEntd(this.szds);
        bean.setEngx(this.szqx);
        bean.setEntlinkname(this.qyfzr);
        bean.setEntlinktel(this.lxdh);
        bean.setCorpname(this.fddbr);
        bean.setEntby14(this.xkfrzhhm);
        bean.setScdz(this.ckdz);// 生产地址
        bean.setSynctime(DateUtils.getTodayStr());
        bean.setSync("0");

        return bean;
    }

}
