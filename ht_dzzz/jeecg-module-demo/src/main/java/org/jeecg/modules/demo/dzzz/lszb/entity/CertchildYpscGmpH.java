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
 * @Description: certchild_ypsc_gmp_h
 * @Author: jeecg-boot
 * @Date:   2024-07-03
 * @Version: V1.0
 */
@Data
@TableName("certchild_ypsc_gmp_h")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="certchild_ypsc_gmp_h对象", description="certchild_ypsc_gmp_h")
public class CertchildYpscGmpH implements Serializable {
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
	/**认证(检查)名称*/
	@Excel(name = "认证(检查)名称", width = 15)
    @ApiModelProperty(value = "认证(检查)名称")
    private java.lang.String authname;
	/**认证(检查)范围*/
	@Excel(name = "认证(检查)范围", width = 15)
    @ApiModelProperty(value = "认证(检查)范围")
    private java.lang.String authrange;
	/**通过认证(检查)时间*/
	@Excel(name = "通过认证(检查)时间", width = 15)
    @ApiModelProperty(value = "通过认证(检查)时间")
    private java.lang.String passauthdate;
	/**认证(检查)机构名称*/
	@Excel(name = "认证(检查)机构名称", width = 15)
    @ApiModelProperty(value = "认证(检查)机构名称")
    private java.lang.String authorg;
	/**国家(地区、组织)名称*/
	@Excel(name = "国家(地区、组织)名称", width = 15)
    @ApiModelProperty(value = "国家(地区、组织)名称")
    private java.lang.String countryname;
	/**涉及品种名称*/
	@Excel(name = "涉及品种名称", width = 15)
    @ApiModelProperty(value = "涉及品种名称")
    private java.lang.String sjpzmc;
	/**备注*/
	@Excel(name = "备注", width = 15)
    @ApiModelProperty(value = "备注")
    private java.lang.String bz;
	/**状态*/
	@Excel(name = "状态", width = 15)
    @ApiModelProperty(value = "状态")
    private java.lang.String zt;
	/**企业id*/
	@Excel(name = "企业id", width = 15)
    @ApiModelProperty(value = "企业id")
    private java.lang.String qyid;
	/**0正常1删除*/
	@Excel(name = "0正常1删除", width = 15)
    @ApiModelProperty(value = "0正常1删除")
    private java.lang.String sfsc;
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
}
