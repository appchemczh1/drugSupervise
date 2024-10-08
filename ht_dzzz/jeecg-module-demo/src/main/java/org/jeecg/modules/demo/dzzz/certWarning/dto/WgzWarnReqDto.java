package org.jeecg.modules.demo.dzzz.certWarning.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.jeecgframework.poi.excel.annotation.Excel;

import java.io.Serializable;

@Data
@ApiModel(description="证书-未盖章预警-请求参数")
public class WgzWarnReqDto implements Serializable {

    @Excel(name = "证书ID", width = 37)
    @ApiModelProperty(value = "证书编号", dataType = "String")
    private String zsbh;

    @ApiModelProperty(value = "企业名称", dataType = "String")
    private String qymc;

    @ApiModelProperty(value = "证书大类", dataType = "String")
    private String zsdl;

    @ApiModelProperty(value = "发证机关", dataType = "String")
    private String fzjg;

    @ApiModelProperty(value = "查询起始日期")
    private String beginDate;

    @ApiModelProperty(value = "查询截至日期")
    private String endDate;

}
