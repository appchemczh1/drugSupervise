package org.jeecg.modules.demo.dzzz.lszb.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: certchird_ylqxlcsyba_h
 * @Author: jeecg-boot
 * @Date:   2024-07-03
 * @Version: V1.0
 */
@Data
@TableName("certchird_ylqxlcsyba_h")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="certchird_ylqxlcsyba_h对象", description="certchird_ylqxlcsyba_h")
public class CertchirdYlqxlcsybaH implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.String id;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
	/**创建日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "创建日期")
    private java.util.Date createTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private java.lang.String updateBy;
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "更新日期")
    private java.util.Date updateTime;
	/**所属部门*/
    @ApiModelProperty(value = "所属部门")
    private java.lang.String sysOrgCode;
	/**证书id*/
	@Excel(name = "证书id", width = 15)
    @ApiModelProperty(value = "证书id")
    private java.lang.String zsid;
	/**拟生产药品的名称*/
	@Excel(name = "拟生产药品的名称", width = 15)
    @ApiModelProperty(value = "拟生产药品的名称")
    private java.lang.String nscypmc;
	/**地址/科室*/
	@Excel(name = "地址/科室", width = 15)
    @ApiModelProperty(value = "地址/科室")
    private java.lang.String dz;
	/**批准文号联系人/职务*/
	@Excel(name = "批准文号联系人/职务", width = 15)
    @ApiModelProperty(value = "批准文号联系人/职务")
    private java.lang.String lxr;
	/**电话*/
	@Excel(name = "电话", width = 15)
    @ApiModelProperty(value = "电话")
    private java.lang.String dh;
	/**类别 1临床实验机构(如多中心应注明牵头单位)2:研究者*/
	@Excel(name = "类别 1临床实验机构(如多中心应注明牵头单位)2:研究者", width = 15)
    @ApiModelProperty(value = "类别 1临床实验机构(如多中心应注明牵头单位)2:研究者")
    private java.lang.String lb;
	/**状态 0正常 1删除*/
	@Excel(name = "状态 0正常 1删除", width = 15)
    @ApiModelProperty(value = "状态 0正常 1删除")
    private java.lang.String zt;
	/**条数*/
	@Excel(name = "条数", width = 15)
    @ApiModelProperty(value = "条数")
    private java.lang.String ts;
	/**ylzd1*/
	@Excel(name = "ylzd1", width = 15)
    @ApiModelProperty(value = "ylzd1")
    private java.lang.String ylzd1;
	/**ylzd2*/
	@Excel(name = "ylzd2", width = 15)
    @ApiModelProperty(value = "ylzd2")
    private java.lang.String ylzd2;
	/**ylzd3*/
	@Excel(name = "ylzd3", width = 15)
    @ApiModelProperty(value = "ylzd3")
    private java.lang.String ylzd3;
	/**ylzd4*/
	@Excel(name = "ylzd4", width = 15)
    @ApiModelProperty(value = "ylzd4")
    private java.lang.String ylzd4;
	/**ylzd5*/
	@Excel(name = "ylzd5", width = 15)
    @ApiModelProperty(value = "ylzd5")
    private java.lang.String ylzd5;
    private java.lang.String xzspid;

}
