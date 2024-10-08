package org.jeecg.modules.demo.dzzz.dataExchange.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel(description="武汉市局-证书元-主表-响应参数")
public class WhsjZsyDto extends WhsjZsyGyDto {

    @ApiModelProperty(value = "证书系统映射值", dataType = "String")
    private String zzyssx;

    @ApiModelProperty(value = "证书元版本id", dataType = "String")
    private String bbid;

}
