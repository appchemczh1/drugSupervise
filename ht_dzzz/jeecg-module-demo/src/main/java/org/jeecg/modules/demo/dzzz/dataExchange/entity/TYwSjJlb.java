package org.jeecg.modules.demo.dzzz.dataExchange.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.jeecgframework.poi.excel.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: t_yw_sj_jlb
 * @Author: jeecg-boot
 * @Date:   2024-07-02
 * @Version: V1.0
 */
@Data
@TableName("t_yw_sj_jlb")
@ApiModel(value="数据流转日志记录-对象", description="数据流转日志记录")
public class TYwSjJlb implements Serializable {

    private static final long serialVersionUID = 1L;

	/**主键ID*/
	@Excel(name = "主键ID", width = 15)
    @ApiModelProperty(value = "主键ID")
    @TableId(type = IdType.AUTO)
    private java.lang.Integer id;

	/**来源：来源：SSCJ-省市场局，WHSJ-武汉市局*/
	@Excel(name = "来源：SSCJ-省市场局，WHSJ-武汉市局", width = 15)
    @ApiModelProperty(value = "来源：SSCJ-省市场局，WHSJ-武汉市局")
    private java.lang.String jlly;

	/**证书ID*/
	@Excel(name = "证书ID", width = 15)
    @ApiModelProperty(value = "证书ID")
    private java.lang.String zsid;

	/**证书编号*/
	@Excel(name = "证书编号", width = 15)
    @ApiModelProperty(value = "证书编号")
    private java.lang.String zsbh;

	/**省市场局、武汉市局推送数据入参*/
	@Excel(name = "省市场局、武汉市局推送数据入参", width = 15)
    @ApiModelProperty(value = "省市场局、武汉市局推送数据入参")
    private java.lang.String jlInJson;

	/**推送状态：0-成功 1：失败*/
	@Excel(name = "推送状态：0-成功 1：失败", width = 15)
    @ApiModelProperty(value = "推送状态：0-成功 1：失败")
    private java.lang.Integer jlzt;

	/**响应省市场局、武汉市局数据*/
	@Excel(name = "响应省市场局、武汉市局数据", width = 15)
    @ApiModelProperty(value = "响应省市场局、武汉市局数据")
    private java.lang.String jlOutJson;

	/**记录时间*/
	@Excel(name = "记录时间", width = 15)
    @ApiModelProperty(value = "记录时间")
    private java.lang.String jlsj;

	/**证书类型*/
	@Excel(name = "证书类型", width = 15)
    @ApiModelProperty(value = "证书类型")
    private java.lang.String zslx;

    @Excel(name = "业务ID", width = 15)
    @ApiModelProperty(value = "业务ID：singId-省市场局，licenseId-武汉市局）")
    private java.lang.String ywid;

    @Excel(name = "业务类型：1-核发，2-换发/延续，3-变更，4-注销，5-补发，6-人工维护，7-强制维护", width = 15)
    @ApiModelProperty(value = "业务类型：1-核发，2-换发/延续，3-变更，4-注销，5-补发，6-人工维护，7-强制维护")
    private java.lang.String ywlx;

    @Excel(name = "外部主键ID：id-省市场局", width = 15)
    @ApiModelProperty(value = "外部主键ID：id-省市场局，licenseVid-武汉市局")
    private java.lang.String outId;

}
