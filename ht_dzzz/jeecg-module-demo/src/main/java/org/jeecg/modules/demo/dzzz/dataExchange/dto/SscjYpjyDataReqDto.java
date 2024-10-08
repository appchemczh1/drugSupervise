package org.jeecg.modules.demo.dzzz.dataExchange.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang.StringUtils;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertInfo;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertInfoService;
import org.jeecg.modules.demo.dzzz.certtype.service.ICertTypeService;
import org.jeecg.modules.demo.dzzz.dataExchange.exception.ErrorMsg;
import org.jeecg.modules.demo.dzzz.dataExchange.exception.ErrorUtil;
import org.jeecg.modules.demo.dzzz.information.entity.Information;
import org.jeecg.modules.demo.dzzz.wgz.entity.ZsYwxxb;

import java.util.List;


@Data
@ApiModel(description="省市场局-药品经营许可-请求参数")
public class SscjYpjyDataReqDto extends SscjDataReqDto {

    @ApiModelProperty(value = "企业地址", dataType = "String")
    private String qydz;

    @ApiModelProperty(value = "新证书类型", dataType = "String")
    private String newZslx;

    @ApiModelProperty(value = "质量管理人", dataType = "String")
    private String zlglr;

    @ApiModelProperty(value = "日常监管机构", dataType = "String")
    private String rcjgjg;

    @ApiModelProperty(value = "签发人", dataType = "String")
    private String qfr;

    @ApiModelProperty(value = "范围", dataType = "String")
    private String fw;

    @ApiModelProperty(value = "行政相对人类别", dataType = "String")
    private String xkxdrlb;

    // 非必填
    @ApiModelProperty(value = "行政相对人代码_2 (工商注册号)", dataType = "String")
    private String xkxdrgszc;

    /**
     * 校验（省市场局-药品经营）
     * @param zslxList 证书类型List
     * @param dto 请求参数
     * @param isZx 是否注销
     * @return
     */
    public CertInfo valid(List<String> zslxList, SscjDataReqDto dto, boolean isZx, ICertInfoService certInfoService, ICertTypeService certTypeService) {
        CertInfo certInfo = super.valid(zslxList, dto, isZx, certInfoService, certTypeService);
        // 不能为空字段
        ErrorUtil.assertStringIsBlank(this.qydz, ErrorMsg.QYDZ_NOT_NULL);
        ErrorUtil.assertStringIsBlank(this.zlglr, ErrorMsg.ZLGLR_NOT_NULL);
        ErrorUtil.assertStringIsBlank(this.rcjgjg, ErrorMsg.RCJGJG_NOT_NULL);
        ErrorUtil.assertStringIsBlank(this.qfr, ErrorMsg.QFR_NOT_NULL);
        ErrorUtil.assertStringIsBlank(this.fw, ErrorMsg.FW_NOT_NULL);
        ErrorUtil.assertStringIsBlank(this.xkxdrlb, ErrorMsg.XKXDRLB_NOT_NULL);
//        ErrorUtil.assertFailure((StringUtils.isNotBlank(dto.getXkxdrgszc()) && "法人及非法人组织".equals(this.xkxdrlb)
//                && !dto.getXkxdrgszc().startsWith("91")), ErrorMsg.NOT_91_START_WITH);
//        ErrorUtil.assertFailure((StringUtils.isNotBlank(dto.getXkxdrgszc()) && "自然人".equals(this.xkxdrlb)
//                && !dto.getXkxdrgszc().startsWith("92")), ErrorMsg.NOT_92_START_WITH);

        return certInfo;
    }

    public static void main(String[] args) {
        String gs = "92420300MA49KUFW0H";
        if(gs.startsWith("91")) {
            System.out.println("字符串以指定前缀开头");
        } else {
            System.out.println("字符串未以指定前缀开头");
        }
    }

    /**
     * 构建未盖章证书信息（省市场局-药品经营）
     * @param bean 未盖章证书证书信息
     * @param certTypeId 证书类型ID
     * @return
     */
    public ZsYwxxb buildZsYwxxb(ZsYwxxb bean, String certTypeId) {
        bean = super.buildZsYwxxb(bean, certTypeId);
        bean.setZcdz(this.qydz);
        bean.setZlfzr(this.zlglr);
        bean.setRcjdgljg(this.rcjgjg);
        return bean;
    }

    /**
     * 构建企业信息（省市场局-药品经营）
     * @param bean
     * @return
     */
    public Information buildQyxx(Information bean) {
        Information info = super.buildQyxx(bean);
        info.setEntregaddr(this.qydz);
        info.setEntby7(this.fw);
        return info;
    }

}
