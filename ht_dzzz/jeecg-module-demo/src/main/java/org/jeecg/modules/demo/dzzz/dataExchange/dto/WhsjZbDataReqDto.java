package org.jeecg.modules.demo.dzzz.dataExchange.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
@ApiModel(description="武汉市局-子表数据-请求参数")
public class WhsjZbDataReqDto implements Serializable {

    @ApiModelProperty(value = "主键", dataType = "String")
    private String tableName;

    // TODO 数组集合 数据类型
    @ApiModelProperty(value = "子表内容集合")
    private List<Map<String, Object>> data;

    // 主键
    @ApiModelProperty(value = "数据状态", dataType = "String")
    private String id;

}
