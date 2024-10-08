package org.jeecg.modules.demo.dzzz.whsjZb.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: t_jc_zs_dylylqxscbapz_zb
 * @Author: jeecg-boot
 * @Date:   2024-08-30
 * @Version: V1.0
 */
@Data
@TableName("t_jc_zs_dylylqxscbapz_zb")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="t_jc_zs_dylylqxscbapz_zb对象", description="t_jc_zs_dylylqxscbapz_zb")
public class TJcZsDylylqxscbapzZb implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.String id;
	/**证书ID*/
	@Excel(name = "证书ID", width = 15)
    @ApiModelProperty(value = "证书ID")
    private java.lang.String zsid;
	/**产品注册号/备案号*/
	@Excel(name = "产品注册号/备案号", width = 15)
    @ApiModelProperty(value = "产品注册号/备案号")
    private java.lang.String zczh;
	/**产品类别代码*/
	@Excel(name = "产品类别代码", width = 15)
    @ApiModelProperty(value = "产品类别代码")
    private java.lang.String cplbDm;
	/**是否委托生产*/
	@Excel(name = "是否委托生产", width = 15)
    @ApiModelProperty(value = "是否委托生产")
    private java.lang.String sfwtsc;
	/**注册/备案人名称*/
	@Excel(name = "注册/备案人名称", width = 15)
    @ApiModelProperty(value = "注册/备案人名称")
    private java.lang.String zcbarmc;
	/**注册/备案人地址*/
	@Excel(name = "注册/备案人地址", width = 15)
    @ApiModelProperty(value = "注册/备案人地址")
    private java.lang.String zcbardz;
	/**社会信用代码*/
	@Excel(name = "社会信用代码", width = 15)
    @ApiModelProperty(value = "社会信用代码")
    private java.lang.String shxydm;
	/**委托期限*/
	@Excel(name = "委托期限", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "委托期限")
    private java.util.Date wtqx;
	/**备注*/
	@Excel(name = "备注", width = 15)
    @ApiModelProperty(value = "备注")
    private java.lang.String bz;
	/**产品名称*/
	@Excel(name = "产品名称", width = 15)
    @ApiModelProperty(value = "产品名称")
    private java.lang.String cpmc;
	/**num*/
	@Excel(name = "num", width = 15)
    @ApiModelProperty(value = "num")
    private java.math.BigDecimal num;
	/**zt*/
	@Excel(name = "zt", width = 15)
    @ApiModelProperty(value = "zt")
    private java.math.BigDecimal zt;
	/**行政审批id*/
	@Excel(name = "行政审批id", width = 15)
    @ApiModelProperty(value = "行政审批id")
    private java.lang.String xzspid;
}
