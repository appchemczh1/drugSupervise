package org.jeecg.modules.demo.dzzz.certWarning.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.jeecgframework.poi.excel.annotation.Excel;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(description="证书-有效期预警-响应数据")
public class YxqWarnResDto implements Serializable {

    @Excel(name = "证书类型", width = 10)
    @ApiModelProperty(value = "证书大类名称", dataType = "String")
    private String zsdlName;

    @ApiModelProperty(value = "证书大类", dataType = "String")
    private String zsdl;

    @ApiModelProperty(value = "证书类型", dataType = "String")
    private String zslx;

    @Excel(name = "证书编号", width = 30)
    @ApiModelProperty(value = "证书编号", dataType = "String")
    private String zsbh;

    @Excel(name = "企业名称", width = 40)
    @ApiModelProperty(value = "企业名称", dataType = "String")
    private String qymc;

    @Excel(name = "发证机关", width = 35)
    @ApiModelProperty(value = "发证机关", dataType = "String")
    private String fzjg;

    @Excel(name = "有效期至", width = 12)
    @ApiModelProperty(value = "有效期至", dataType = "String")
    private String yxqz;

    @ApiModelProperty(value = "预警日期", dataType = "String")
    private String oneMonth;

    @ApiModelProperty(value = "预警日期", dataType = "String")
    private String threeMonth;

    @ApiModelProperty(value = "社会信用代码", dataType = "String")
    private String shxydm;

    @ApiModelProperty(value = "投诉举报电话", dataType = "String")
    private String tsDh;

    @ApiModelProperty(value = "注册地址", dataType = "String")
    private String zcdz;

    @ApiModelProperty(value = "经营方式", dataType = "String")
    private String jyfs;

    @ApiModelProperty(value = "法定代表人", dataType = "String")
    private String fddbr;

    @ApiModelProperty(value = "企业负责人", dataType = "String")
    private String qyfzr;

    @ApiModelProperty(value = "质量负责人", dataType = "String")
    private String zlfzr;

    @ApiModelProperty(value = "日常监督检查管理机构", dataType = "String")
    private String rcjdgljg;

    @ApiModelProperty(value = "经营范围", dataType = "String")
    private String fw;

    @ApiModelProperty(value = "签发人", dataType = "String")
    private String qfr;

    @ApiModelProperty(value = "发证日期", dataType = "String")
    private Date fzrq;

    @ApiModelProperty(value = "联系人", dataType = "String")
    private String lxr;

    @ApiModelProperty(value = "联系电话", dataType = "String")
    private String lxdh;

    @Excel(name = "预警标识", width = 12)
    @ApiModelProperty(value = "预警标识", dataType = "String")
    private String yjbs;

    @ApiModelProperty(value = "预警图标", dataType = "String")
    private String yjIcon;

    @Excel(name = "处理状态", width = 12)
    @ApiModelProperty(value = "处理状态", dataType = "String")
    private String yjclzt;

}
