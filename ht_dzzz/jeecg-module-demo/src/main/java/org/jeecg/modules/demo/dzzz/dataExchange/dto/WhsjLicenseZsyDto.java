package org.jeecg.modules.demo.dzzz.dataExchange.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel(description="武汉市局-证书元-请求参数")
public class WhsjLicenseZsyDto implements Serializable {

    @ApiModelProperty(value = "证书表证书元信息集合")
    private List<WhsjZsyDto> zsyList;

    @ApiModelProperty(value = "子表证书元信息集合")
    private List<WhsjZsyGyDto> zbList;

}
