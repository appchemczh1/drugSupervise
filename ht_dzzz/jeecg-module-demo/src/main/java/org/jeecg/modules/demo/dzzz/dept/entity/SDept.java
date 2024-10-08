package org.jeecg.modules.demo.dzzz.dept.entity;

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
 * @Description: s_dept
 * @Author: jeecg-boot
 * @Date:   2024-07-11
 * @Version: V1.0
 */
@Data
@TableName("s_dept")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="s_dept对象", description="s_dept")
public class SDept implements Serializable {
    private static final long serialVersionUID = 1L;

	/**部门主键*/
	@Excel(name = "部门主键", width = 15)
    @ApiModelProperty(value = "部门主键")
    private java.lang.String deptId;
	/**父部门id*/
	@Excel(name = "父部门id", width = 15)
    @ApiModelProperty(value = "父部门id")
    private java.lang.String parentId;
	/**祖级列表*/
	@Excel(name = "祖级列表", width = 15)
    @ApiModelProperty(value = "祖级列表")
    private java.lang.String ancestors;
	/**部门名称*/
	@Excel(name = "部门名称", width = 15)
    @ApiModelProperty(value = "部门名称")
    private java.lang.String deptName;
	/**显示顺序*/
	@Excel(name = "显示顺序", width = 15)
    @ApiModelProperty(value = "显示顺序")
    private java.math.BigDecimal orderNum;
	/**负责人*/
	@Excel(name = "负责人", width = 15)
    @ApiModelProperty(value = "负责人")
    private java.lang.String leader;
	/**联系电话*/
	@Excel(name = "联系电话", width = 15)
    @ApiModelProperty(value = "联系电话")
    private java.lang.String phone;
	/**邮箱*/
	@Excel(name = "邮箱", width = 15)
    @ApiModelProperty(value = "邮箱")
    private java.lang.String email;
	/**部门状态（0正常 1停用）*/
	@Excel(name = "部门状态（0正常 1停用）", width = 15)
    @ApiModelProperty(value = "部门状态（0正常 1停用）")
    private java.math.BigDecimal status;
	/**删除标志（0代表存在 2代表删除）*/
	@Excel(name = "删除标志（0代表存在 2代表删除）", width = 15)
    @ApiModelProperty(value = "删除标志（0代表存在 2代表删除）")
    @TableLogic
    private java.math.BigDecimal delFlag;
	/**创建者*/
    @ApiModelProperty(value = "创建者")
    private java.lang.String createBy;
	/**创建时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "创建时间")
    private java.util.Date createTime;
	/**更新者*/
    @ApiModelProperty(value = "更新者")
    private java.lang.String updateBy;
	/**更新时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "更新时间")
    private java.util.Date updateTime;
	/**部门类型*/
	@Excel(name = "部门类型", width = 15)
    @ApiModelProperty(value = "部门类型")
    private java.lang.String deptType;
	/**地区编码*/
	@Excel(name = "地区编码", width = 15)
    @ApiModelProperty(value = "地区编码")
    private java.lang.String areaId;
	/**地区名称*/
	@Excel(name = "地区名称", width = 15)
    @ApiModelProperty(value = "地区名称")
    private java.lang.String areaName;
	/**组织类型对应菜单*/
	@Excel(name = "组织类型对应菜单", width = 15)
    @ApiModelProperty(value = "组织类型对应菜单")
    private java.lang.String deptPatter;
	/**是否是顶级机构(0否1是)*/
	@Excel(name = "是否是顶级机构(0否1是)", width = 15)
    @ApiModelProperty(value = "是否是顶级机构(0否1是)")
    private java.lang.String topDept;
	/**企业统一社会信用代码 颁发机构代码*/
	@Excel(name = "企业统一社会信用代码 颁发机构代码", width = 15)
    @ApiModelProperty(value = "企业统一社会信用代码 颁发机构代码")
    private java.lang.String orgNo;
	/**创建用户id*/
	@Excel(name = "创建用户id", width = 15)
    @ApiModelProperty(value = "创建用户id")
    private java.lang.String createByUid;
	/**前置库部门名称*/
	@Excel(name = "前置库部门名称", width = 15)
    @ApiModelProperty(value = "前置库部门名称")
    private java.lang.String var1;
	/** 颁发机构代码*/
	@Excel(name = " 颁发机构代码", width = 15)
    @ApiModelProperty(value = " 颁发机构代码")
    private java.lang.String var2;
	/**扩展字符类字段3*/
	@Excel(name = "扩展字符类字段3", width = 15)
    @ApiModelProperty(value = "扩展字符类字段3")
    private java.lang.String var3;
	/**var4*/
	@Excel(name = "var4", width = 15)
    @ApiModelProperty(value = "var4")
    private java.lang.String var4;
	/**var5*/
	@Excel(name = "var5", width = 15)
    @ApiModelProperty(value = "var5")
    private java.lang.String var5;
	/**var6*/
	@Excel(name = "var6", width = 15)
    @ApiModelProperty(value = "var6")
    private java.lang.String var6;
	/**var7*/
	@Excel(name = "var7", width = 15)
    @ApiModelProperty(value = "var7")
    private java.lang.String var7;
	/**var8*/
	@Excel(name = "var8", width = 15)
    @ApiModelProperty(value = "var8")
    private java.lang.String var8;
	/**date1*/
	@Excel(name = "date1", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "date1")
    private java.util.Date date1;
	/**date2*/
	@Excel(name = "date2", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "date2")
    private java.util.Date date2;
}
