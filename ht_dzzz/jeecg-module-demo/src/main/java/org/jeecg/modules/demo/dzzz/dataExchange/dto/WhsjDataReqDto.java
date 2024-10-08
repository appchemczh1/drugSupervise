package org.jeecg.modules.demo.dzzz.dataExchange.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.jeecg.modules.demo.dzzz.wgz.entity.ZsYwxxb;

import java.util.List;

@Data
@ApiModel(description="省市场局-医疗器械许可-请求参数")
public class WhsjDataReqDto extends ZsYwxxb {

//    @ApiModelProperty(value = "证书类型", dataType = "String")
//    private String zslx;

    /** 核发-1 延续-2 变更-3 注销-4 补发-5 吊销-6 强制维护-7 **/
    @ApiModelProperty(value = "业务类型", dataType = "String")
    private String ywlx;

    @ApiModelProperty(value = "证书id", dataType = "String")
    private String licenseId;

    @ApiModelProperty(value = "办件编码", dataType = "String")
    private String projectNo;

    @ApiModelProperty(value = "事项编码", dataType = "String")
    private String taskCode;

//    @ApiModelProperty(value = "最新证书元版本id", dataType = "String")
//    private String bbId;

    @ApiModelProperty(value = "地区编号", dataType = "String")
    private String areaCode;

    @ApiModelProperty(value = "地区名称", dataType = "String")
    private String areaName;
    // 以上必填

    @ApiModelProperty(value = "变更次数", dataType = "String")
    private String bgs;

    @ApiModelProperty(value = "变更内容", dataType = "String")
    private String bgnr;

    @ApiModelProperty(value = "变更时间", dataType = "String")
    private String bgsj;

    @ApiModelProperty(value = "操作人ID", dataType = "String")
    private String czrid;

    @ApiModelProperty(value = "操作人姓名", dataType = "String")
    private String czrxm;

    @ApiModelProperty(value = "操作时间", dataType = "String")
    private String czsj;

    @ApiModelProperty(value = "创建时间", dataType = "String")
    private String cjsj;

    @ApiModelProperty(value = "行政审批受理编号", dataType = "String")
    private String xzspslh;

    @ApiModelProperty(value = "盖章人", dataType = "String")
    private String clrid;

    @ApiModelProperty(value = "盖章人姓名", dataType = "String")
    private String clrxm;

    @ApiModelProperty(value = "盖章时间", dataType = "String")
    private String gzTime;

    @ApiModelProperty(value = "签章ID", dataType = "String")
    private String qzid;

    @ApiModelProperty(value = "签章名称", dataType = "String")
    private String qzmc;

    @ApiModelProperty(value = "联系人", dataType = "String")
    private String lxr;

//    @ApiModelProperty(value = "联系电话", dataType = "String")
//    private String lxdh;

    @ApiModelProperty(value = "企业地址", dataType = "String")
    private String qydz;

    @ApiModelProperty(value = "法人身份证号码", dataType = "String")
    private String fddbrsfz;

    // TODO 根据证书元匹配证照的其他信息

    // 必填
    @ApiModelProperty(value = "变更明细数据")
    private List<WhsjBgmxDataReqDto> bgmxList;

    // 多个子表时拼接
    @ApiModelProperty(value = "子表集合")
    private List<WhsjZbDataReqDto> zbList;

    @ApiModelProperty(value = "licenseVid", dataType = "String")
    private String licenseVid;

//    @ApiModelProperty(value = "证书编号", dataType = "String")
//    private String zsbh;
//
//    @ApiModelProperty(value = "发证机关", dataType = "String")
//    private String fzjg;

//    @ApiModelProperty(value = "发证日期", dataType = "String")
//    private String fzrq;
//
//    @ApiModelProperty(value = "有效截至日期", dataType = "String")
//    private String yxqz;

//    @ApiModelProperty(value = "企业名称", dataType = "String")
//    private String qymc;
//
//    @ApiModelProperty(value = "统一社会信用代码", dataType = "String")
//    private String shxydm;

//    @ApiModelProperty(value = "企业ID", dataType = "String")
//    private String qyId;

    @ApiModelProperty(value = "产品名称", dataType = "String")
    private String cp;

}
