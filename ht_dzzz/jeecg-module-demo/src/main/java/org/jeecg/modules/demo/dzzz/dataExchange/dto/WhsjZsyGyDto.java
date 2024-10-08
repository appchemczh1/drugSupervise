package org.jeecg.modules.demo.dzzz.dataExchange.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description="武汉市局-证书元-子表-响应参数")
public class WhsjZsyGyDto implements Serializable {

    @ApiModelProperty(value = "字段名称", dataType = "String")
    private String lbs;

    @ApiModelProperty(value = "字段中文名称", dataType = "String")
    private String lm;

    @ApiModelProperty(value = "字段类型1字符串4日期", dataType = "String")
    private String zdlx;

    @ApiModelProperty(value = "长度", dataType = "String")
    private String zdcd;

    @ApiModelProperty(value = "是否为空1是0否", dataType = "String")
    private String sfwk;

    @ApiModelProperty(value = "证书系统主表表名", dataType = "String")
    private String var1;

    public WhsjZsyGyDto() {
    }

    public WhsjZsyGyDto(String lbs, String lm, String zdlx, String zdcd, String sfwk, String var1) {
        this.lbs = lbs;
        this.lm = lm;
        this.zdlx = zdlx;
        this.zdcd = zdcd;
        this.sfwk = sfwk;
        this.var1 = var1;
    }

}
