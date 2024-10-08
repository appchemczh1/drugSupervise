package org.jeecg.modules.demo.dzzz.dataExchange.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertInfo;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertInfoService;
import org.jeecg.modules.demo.dzzz.certtype.service.ICertTypeService;
import org.jeecg.modules.demo.dzzz.dataExchange.exception.ErrorMsg;
import org.jeecg.modules.demo.dzzz.dataExchange.exception.ErrorUtil;
import org.jeecg.modules.demo.dzzz.information.entity.Information;
import org.jeecg.modules.demo.dzzz.wgz.entity.ZsYwxxb;

import java.util.List;


@Data
@ApiModel(description="省市场局-医疗器械许可-请求参数")
public class SscjYlqxDataReqDto extends SscjDataReqDto {

    @ApiModelProperty(value = "住所", dataType = "String")
    private String zs;

    @ApiModelProperty(value = "经营范围", dataType = "String")
    private String jyfw;

    @ApiModelProperty(value = "经营场所", dataType = "String")
    private String jycs;

    @ApiModelProperty(value = "经营方式", dataType = "String")
    private String jyfs;

    @ApiModelProperty(value = "填写法人及非法人组织、自然人、个体工商户三个类别中的一个。必填", dataType = "String")
    private String xkxdrlb;

    @ApiModelProperty(value = "若个体工商户统一社会信用代码填的17 个 0 加 X，则此字段必填", dataType = "String")
    private String xkxdrgszc;

    @ApiModelProperty(value = "许可日期", dataType = "String")
    private String xkrq;

    /**
     * 校验（省市场局-药品器械）
     * @param zslxList 证书类型List
     * @param dto 请求参数
     * @param isZx 是否注销
     * @return
     */
    public CertInfo valid(List<String> zslxList, SscjDataReqDto dto, boolean isZx, ICertInfoService certInfoService, ICertTypeService certTypeService) {
        CertInfo certInfo = super.valid(zslxList, dto, isZx, certInfoService, certTypeService);
        // 不能为空字段
        ErrorUtil.assertStringIsBlank(this.zs, ErrorMsg.ZS_NOT_NULL);
        ErrorUtil.assertStringIsBlank(this.jyfw, ErrorMsg.JYFW_NOT_NULL);
        ErrorUtil.assertStringIsBlank(this.jycs, ErrorMsg.JYCS_NOT_NULL);
        ErrorUtil.assertStringIsBlank(this.jyfs, ErrorMsg.JYFS_NOT_NULL);
        ErrorUtil.assertStringIsBlank(this.xkxdrlb, ErrorMsg.XKXDRLB2_NOT_NULL);

        return certInfo;
    }

    /**
     * 构建未盖章证书信息（省市场局-药品器械）
     * @param bean 未盖章证书证书信息
     * @param certTypeId 证书类型ID
     * @return
     */
    public ZsYwxxb buildZsYwxxb(ZsYwxxb bean, String certTypeId) {
        bean = super.buildZsYwxxb(bean, certTypeId);
        bean.setZcdz(this.zs);
        bean.setYlzd1(this.jyfs);
        bean.setYlzd6(this.jycs);
        bean.setFw(this.jyfw);
        return bean;
    }

    /**
     * 构建企业信息（省市场局-药品器械）
     * @param bean
     * @return
     */
    public Information buildQyxx(Information bean) {
        Information info = super.buildQyxx(bean);
        info.setEntregaddr(this.zs);
        info.setEntby7(this.jyfw);
        // info.setEntby14(this.getXkfrzhhm());
        return info;
    }

}
