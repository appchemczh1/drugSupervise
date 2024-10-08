package org.jeecg.modules.demo.dzzz.certtype.entity;

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
 * @Description: 证照类型
 * @Author: jeecg-boot
 * @Date:   2024-03-19
 * @Version: V1.0
 */
@Data
@TableName("cert_type")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="cert_type对象", description="证照类型")
public class CertType implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private java.lang.String id;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
	/**创建日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期")
    private java.util.Date createTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private java.lang.String updateBy;
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期")
    private java.util.Date updateTime;
	/**所属部门*/
    @ApiModelProperty(value = "所属部门")
    private java.lang.String sysOrgCode;
	/**父类型id*/
	@Excel(name = "父类型id", width = 15)
    @ApiModelProperty(value = "父类型id")
    private java.lang.String pid;
	/**机构id*/
	@Excel(name = "机构id", width = 15)
    @ApiModelProperty(value = "机构id")
    private java.lang.String orgId;
	/**祖级列表*/
	@Excel(name = "祖级列表", width = 15)
    @ApiModelProperty(value = "祖级列表")
    private java.lang.String ancestors;
	/**证书类型*/
	@Excel(name = "证书类型", width = 15)
    @ApiModelProperty(value = "证书类型")
    private java.lang.String certtype;
	/**证照类型编码*/
	@Excel(name = "证照类型编码", width = 15)
    @ApiModelProperty(value = "证照类型编码")
    private java.lang.String certtypecode;
	/**证书类型名称*/
	@Excel(name = "证书类型名称", width = 15)
    @ApiModelProperty(value = "证书类型名称")
    private java.lang.String certtypename;
	/**显示顺序*/
	@Excel(name = "显示顺序", width = 15)
    @ApiModelProperty(value = "显示顺序")
    private java.lang.String ordernum;
	/**状态*/
	@Excel(name = "状态", width = 15, dicCode = "certtypestatus")
	@Dict(dicCode = "certtypestatus")
    @ApiModelProperty(value = "状态")
    private java.lang.String status;
	/**证书分类*/
	@Excel(name = "证书分类", width = 15, dicCode = "cert_type_lx")
	@Dict(dicCode = "cert_type_lx")
    @ApiModelProperty(value = "证书分类")
    private java.lang.String certtypeClassification;
	/**扩展日期1*/
	@Excel(name = "扩展日期1", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "扩展日期1")
    private java.util.Date date1;
	/**扩展日期2*/
	@Excel(name = "扩展日期2", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "扩展日期2")
    private java.util.Date date2;
	/**企业类型*/
	@Excel(name = "企业类型", width = 15, dicCode = "qytype")
	@Dict(dicCode = "qytype")
    @ApiModelProperty(value = "企业类型")
    private java.lang.String qytype;
	/**证书表单id*/
	@Excel(name = "证书表单id", width = 15)
    @ApiModelProperty(value = "证书表单id")
    private java.lang.String formId;
	/**表单名字*/
	@Excel(name = "表单名字", width = 15)
    @ApiModelProperty(value = "表单名字")
    private java.lang.String formName;
	/**前置库业务-证书类型*/
	@Excel(name = "前置库业务-证书类型", width = 15)
    @ApiModelProperty(value = "前置库业务-证书类型")
    private java.lang.String zslx;
	/**证书规则编号*/
	@Excel(name = "证书规则编号", width = 15)
    @ApiModelProperty(value = "证书规则编号")
    private java.lang.String codeRule;
	/**是否公示*/
	@Excel(name = "是否公示", width = 15, dicCode = "istrue")
	@Dict(dicCode = "istrue")
    @ApiModelProperty(value = "是否公示")
    private java.lang.String isgs;
    private java.lang.String zszb;

}
