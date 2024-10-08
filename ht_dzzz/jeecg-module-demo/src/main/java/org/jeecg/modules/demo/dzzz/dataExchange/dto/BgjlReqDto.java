package org.jeecg.modules.demo.dzzz.dataExchange.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description="变更记录-请求参数")
public class BgjlReqDto implements Serializable {

    @ApiModelProperty(value = "统一社会信用代码", dataType = "String")
    private String shxydm;

    @ApiModelProperty(value = "业务类型", dataType = "String")
    private String ywlx;

    @ApiModelProperty(value = "证书类型", dataType = "String")
    private String zslx;

    @ApiModelProperty(value = "变更内容", dataType = "String")
    private String bgnr;

    @ApiModelProperty(value = "变更时间", dataType = "String")
    private String bgsj;

}
