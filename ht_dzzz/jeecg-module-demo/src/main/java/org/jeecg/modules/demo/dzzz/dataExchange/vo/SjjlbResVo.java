package org.jeecg.modules.demo.dzzz.dataExchange.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.jeecgframework.poi.excel.annotation.Excel;

@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@Data
@ApiModel(value="数据交换-响应数据", description="数据交换-响应数据")
public class SjjlbResVo {

    private static final long serialVersionUID = 1L;

//    @Excel(name = "主键ID", width = 10)
    @ApiModelProperty(value = "主键ID")
    private Integer id;

    @Excel(name = "证书类型", width = 30)
    @ApiModelProperty(value = "证书类型名称")
    private String zslxName;

//    @Excel(name = "证书类型", width = 15)
    @ApiModelProperty(value = "证书类型")
    private String zslx;

    @Excel(name = "证书编号", width = 30)
    @ApiModelProperty(value = "证书编号")
    private String zsbh;

//    @Excel(name = "业务类型", width = 15)
    @ApiModelProperty(value = "业务类型：1-核发，2-换发/延续，3-变更，4-注销，5-补发，6-人工维护")
    private String ywlx;

    @Excel(name = "业务类型", width = 12)
    @ApiModelProperty(value = "业务类型名称")
    private String ywlxName;

    @Excel(name = "接收时间", width = 20)
    @ApiModelProperty(value = "接收时间")
    private String jlsj;

//    @Excel(name = "是否成功", width = 15)
    @ApiModelProperty(value = "是否成功：0-成功 1：失败")
    private Integer jlzt;

    @Excel(name = "是否成功", width = 10)
    @ApiModelProperty(value = "是否成功")
    private String jlztName;

    @Excel(name = "返回值", width = 50)
    @ApiModelProperty(value = "返回值")
    private String jlOutJson;

    @Excel(name = "接收参数", width = 50)
    @ApiModelProperty(value = "接收参数")
    private String jlInJson;

//    @Excel(name = "来源", width = 15)
    @ApiModelProperty(value = "来源：SSCJ-省市场局，WHSJ-武汉市局")
    private String jlly;

    @Excel(name = "证书ID", width = 37)
    @ApiModelProperty(value = "证书ID")
    private String zsid;

    @Excel(name = "业务ID", width = 37)
    @ApiModelProperty(value = "业务ID：singId-省市场局，licenseid-武汉市局）")
    private String ywid;

    @Excel(name = "外部主键ID", width = 37)
    @ApiModelProperty(value = "外部主键ID：id-省市场局")
    private String outId;

}
