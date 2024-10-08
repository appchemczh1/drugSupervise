package org.jeecg.modules.demo.dzzz.dataExchange.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description="武汉市局-变更明细数据-请求参数")
public class WhsjBgmxDataReqDto implements Serializable {

    @ApiModelProperty(value = "主键", dataType = "String")
    private String id;

    @ApiModelProperty(value = "主表ID或子表ID", dataType = "String")
    private String tableDataId;

    // 主表修改10，子表20
    @ApiModelProperty(value = "数据状态", dataType = "String")
    private String dataFlag;

    // 证书元里的字段 var1
    @ApiModelProperty(value = "证书表或子表名称", dataType = "String")
    private String tableName;

    @ApiModelProperty(value = "字段名称", dataType = "String")
    private String columnName;

    @ApiModelProperty(value = "字段中文名称", dataType = "String")
    private String columnDesc;

    @ApiModelProperty(value = "旧值", dataType = "String")
    private String beforeValue;

    @ApiModelProperty(value = "新值", dataType = "String")
    private String afterValue;
    // 以上必填

    @ApiModelProperty(value = "变更次数", dataType = "String")
    private String bgcs;

    // 变更记录证书上的内容
    @ApiModelProperty(value = "变更内容", dataType = "String")
    private String changeContent;

    // 必填
    @ApiModelProperty(value = "变更时间", dataType = "String")
    private String changeTime;

    @ApiModelProperty(value = "排序", dataType = "String")
    private String pxm;

    @ApiModelProperty(value = "备注", dataType = "String")
    private String remark;

    public void valid () {
        // 不能为空字段
//        ErrorUtil.assertStringIsBlank(this.id, ErrorMsg.ZS_NOT_NULL);
//        ErrorUtil.assertStringIsBlank(this.tableDataId, ErrorMsg.JYFW_NOT_NULL);
//        ErrorUtil.assertStringIsBlank(this.dataFlag, ErrorMsg.JYCS_NOT_NULL);
//        ErrorUtil.assertStringIsBlank(this.tableName, ErrorMsg.JYFS_NOT_NULL);
//        ErrorUtil.assertStringIsBlank(this.columnName, ErrorMsg.XKXDRLB2_NOT_NULL);
//        ErrorUtil.assertStringIsBlank(this.columnDesc, ErrorMsg.XKXDRLB2_NOT_NULL);
//        ErrorUtil.assertStringIsBlank(this.beforeValue, ErrorMsg.XKXDRLB2_NOT_NULL);
//        ErrorUtil.assertStringIsBlank(this.afterValue, ErrorMsg.XKXDRLB2_NOT_NULL);
//        ErrorUtil.assertStringIsBlank(this.changeTime, ErrorMsg.XKXDRLB2_NOT_NULL);
    }

}
