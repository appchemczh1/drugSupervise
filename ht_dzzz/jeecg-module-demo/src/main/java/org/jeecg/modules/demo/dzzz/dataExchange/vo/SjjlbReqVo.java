package org.jeecg.modules.demo.dzzz.dataExchange.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@ApiModel(value="数据交换-请求参数", description="数据交换-请求参数")
@NoArgsConstructor
@AllArgsConstructor
public class SjjlbReqVo {

    @ApiModelProperty(value = "证书类型名称", dataType = "String")
    private String zslxName;

    @ApiModelProperty(value = "证书编号", dataType = "String")
    private String zsbh;

    @ApiModelProperty(value = "是否成功（0：是 1：否）", dataType = "String")
    private Integer jlzt;

    @ApiModelProperty(value = "来源：SSCJ-省市场局，WHSJ-武汉市局")
    private String jlly;

    @ApiModelProperty(value = "查询起始日期")
    private String beginDate;

    @ApiModelProperty(value = "查询截至日期")
    private String endDate;

    @ApiModelProperty(value = "业务类型")
    private String ywlx;

}
