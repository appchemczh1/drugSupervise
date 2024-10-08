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
 * @Description: certchild_ckomyly_h
 * @Author: jeecg-boot
 * @Date:   2024-07-03
 * @Version: V1.0
 */
@Data
@TableName("certchild_ckomyly_h")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="certchild_ckomyly_h对象", description="certchild_ckomyly_h")
public class CertchildCkomylyH implements Serializable {
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
	/**证书Id*/
	@Excel(name = "证书Id", width = 15)
    @ApiModelProperty(value = "证书Id")
    private java.lang.String zsid;
	/**条数*/
	@Excel(name = "条数", width = 15)
    @ApiModelProperty(value = "条数")
    private java.lang.String ts;
	/**药品通用名称中文*/
	@Excel(name = "药品通用名称中文", width = 15)
    @ApiModelProperty(value = "药品通用名称中文")
    private java.lang.String yptymczw;
	/**药品通用名称英文*/
	@Excel(name = "药品通用名称英文", width = 15)
    @ApiModelProperty(value = "药品通用名称英文")
    private java.lang.String yptymcyw;
	/**加工方法中文*/
	@Excel(name = "加工方法中文", width = 15)
    @ApiModelProperty(value = "加工方法中文")
    private java.lang.String jgffzw;
	/**加工方法英文*/
	@Excel(name = "加工方法英文", width = 15)
    @ApiModelProperty(value = "加工方法英文")
    private java.lang.String jjffyw;
	/**中国药品批准文号中文*/
	@Excel(name = "中国药品批准文号中文", width = 15)
    @ApiModelProperty(value = "中国药品批准文号中文")
    private java.lang.String zgyppzwhzw;
	/**中国药品批准文号英文*/
	@Excel(name = "中国药品批准文号英文", width = 15)
    @ApiModelProperty(value = "中国药品批准文号英文")
    private java.lang.String zgyypzwhyw;
	/**是否通过我过gmp认证*/
	@Excel(name = "是否通过我过gmp认证", width = 15)
    @ApiModelProperty(value = "是否通过我过gmp认证")
    private java.lang.String sftgrz;
	/**状态0正常1删除*/
	@Excel(name = "状态0正常1删除", width = 15)
    @ApiModelProperty(value = "状态0正常1删除")
    private java.lang.String zt;
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
