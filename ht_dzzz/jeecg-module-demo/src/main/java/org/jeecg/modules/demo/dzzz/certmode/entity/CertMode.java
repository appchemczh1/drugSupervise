package org.jeecg.modules.demo.dzzz.certmode.entity;

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
 * @Description: 证书模板
 * @Author: jeecg-boot
 * @Date:   2024-03-20
 * @Version: V1.0
 */
@Data
@TableName("cert_mode")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="cert_mode对象", description="证书模板")
public class CertMode implements Serializable {
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
	/**证照类型表ID*/
	@Excel(name = "证照类型表ID", width = 15)
    @ApiModelProperty(value = "证照类型表ID")
    private java.lang.String certtypeid;
	/**模板版本号*/
	@Excel(name = "模板版本号", width = 15)
    @ApiModelProperty(value = "模板版本号")
    private java.lang.String bbNo;
	/**模板编号*/
	@Excel(name = "模板编号", width = 15)
    @ApiModelProperty(value = "模板编号")
    private java.lang.String templateCode;
	/**模板名称*/
	@Excel(name = "模板名称", width = 15)
    @ApiModelProperty(value = "模板名称")
    private java.lang.String templateName;
	/**模板类型*/
	@Excel(name = "模板类型", width = 15, dicCode = "cert_mode_lx")
	@Dict(dicCode = "cert_mode_lx")
    @ApiModelProperty(value = "模板类型")
    private java.lang.String templateType;
	/**显示顺序*/
	@Excel(name = "显示顺序", width = 15)
    @ApiModelProperty(value = "显示顺序")
    private java.lang.String orderNum;
	/**类型状态*/
	@Excel(name = "类型状态", width = 15, dicCode = "cert_mode_status")
	@Dict(dicCode = "cert_mode_status")
    @ApiModelProperty(value = "类型状态")
    private java.lang.String status;
	/**纸张类型*/
	@Excel(name = "纸张类型", width = 15, dicCode = "papertye")
	@Dict(dicCode = "papertye")
    @ApiModelProperty(value = "纸张类型")
    private java.lang.String papertype;
	/**是否有背景*/
	@Excel(name = "是否有背景", width = 15, dicCode = "istrue")
	@Dict(dicCode = "istrue")
    @ApiModelProperty(value = "是否有背景")
    private java.lang.String isbackgroud;
	/**附件*/
	@Excel(name = "附件", width = 15)
    @ApiModelProperty(value = "附件")
    private java.lang.String file;
	/**过期时间*/
	@Excel(name = "过期时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "过期时间")
    private java.util.Date gqTime;
	/**模板格式*/
	@Excel(name = "模板格式", width = 15, dicCode = "cert_mode_gs")
	@Dict(dicCode = "cert_mode_gs")
    @ApiModelProperty(value = "模板格式")
    private java.lang.String modeformat;
	/**证照类型编码*/
	@Excel(name = "证照类型编码", width = 15)
    @ApiModelProperty(value = "证照类型编码")
    private java.lang.String certtypecode;
	/**盖章位置左一*/
	@Excel(name = "盖章位置左一", width = 15)
    @ApiModelProperty(value = "盖章位置左一")
    private java.lang.String postLeft1;
	@Excel(name = "盖章位置左一", width = 15)
	@ApiModelProperty(value = "盖章位置左一")
	private java.lang.String postleftX1;
	/**盖章位置左二*/
	@Excel(name = "盖章位置左二", width = 15)
    @ApiModelProperty(value = "盖章位置左二")
    private java.lang.String postLeft2;
	@Excel(name = "盖章位置左二", width = 15)
	@ApiModelProperty(value = "盖章位置左二")
	private java.lang.String postleftX2;
	/**盖章位置左三*/
	@Excel(name = "盖章位置左三", width = 15)
    @ApiModelProperty(value = "盖章位置左三")
    private java.lang.String postLeft3;
	@Excel(name = "盖章位置左三", width = 15)
	@ApiModelProperty(value = "盖章位置左三")
	private java.lang.String postleftX3;
	/**盖章位置左四*/
	@Excel(name = "盖章位置左四", width = 15)
    @ApiModelProperty(value = "盖章位置左四")
    private java.lang.String postLeft4;
	@Excel(name = "盖章位置左四", width = 15)
	@ApiModelProperty(value = "盖章位置左四")
	private java.lang.String postleftX4;
	/**盖章位置右一*/
	@Excel(name = "盖章位置右一", width = 15)
    @ApiModelProperty(value = "盖章位置右一")
    private java.lang.String postRight1;
	@Excel(name = "盖章位置右一", width = 15)
	@ApiModelProperty(value = "盖章位置右一")
	private java.lang.String postrightX1;
	/**盖章位置右二*/
	@Excel(name = "盖章位置右二", width = 15)
    @ApiModelProperty(value = "盖章位置右二")
    private java.lang.String postRight2;
	@Excel(name = "盖章位置右二", width = 15)
	@ApiModelProperty(value = "盖章位置右二")
	private java.lang.String postrightX2;
	/**盖章位置右三*/
	@Excel(name = "盖章位置右三", width = 15)
    @ApiModelProperty(value = "盖章位置右三")
    private java.lang.String postRight3;
	@Excel(name = "盖章位置右三", width = 15)
	@ApiModelProperty(value = "盖章位置右三")
	private java.lang.String postrightX3;
	/**盖章位置右四*/
	@Excel(name = "盖章位置右四", width = 15)
    @ApiModelProperty(value = "盖章位置右四")
    private java.lang.String postRight4;

	private java.lang.String postrightX4;
	/**模板状态 1启用2历史*/
	@Excel(name = "模板状态 1启用2历史", width = 15, dicCode = "usestatus")
	@Dict(dicCode = "usestatus")
    @ApiModelProperty(value = "模板状态 1启用2历史")
    private java.lang.String modestatus;
	/**是否合并附件0不合并1合并*/
	@Excel(name = "是否合并附件0不合并1合并", width = 15, dicCode = "istrue")
	@Dict(dicCode = "istrue")
    @ApiModelProperty(value = "是否合并附件0不合并1合并")
    private java.lang.String ismergeFile;
	/**附件字段*/
	@Excel(name = "附件字段", width = 15)
    @ApiModelProperty(value = "附件字段")
    private java.lang.String attachField;
	/**定位方式*/
	@Excel(name = "定位方式", width = 15, dicCode = "postmethod")
	@Dict(dicCode = "postmethod")
    @ApiModelProperty(value = "定位方式(2：文本定位 1：坐标定位)")
    private java.lang.String postmethod;
	/**排版类型*/
	@Excel(name = "排版类型", width = 15, dicCode = "pblx")
	@Dict(dicCode = "pblx")
    @ApiModelProperty(value = "排版类型")
    private java.lang.String pblx;
	/**文本定位*/
	@Excel(name = "文本定位", width = 15)
    @ApiModelProperty(value = "文本定位")
    private java.lang.String wbpost;
	/**是否推送企业端*/
	@Excel(name = "是否推送企业端", width = 15, dicCode = "istrue")
	@Dict(dicCode = "istrue")
    @ApiModelProperty(value = "是否推送企业端")
    private java.lang.String isqy;
	/**是否公示*/
	@Excel(name = "是否公示", width = 15, dicCode = "istrue")
	@Dict(dicCode = "istrue")
    @ApiModelProperty(value = "是否公示")
    private java.lang.String isgs;
	/**是否为变更记录替换模板*/
	@Excel(name = "是否为变更记录替换模板", width = 15, dicCode = "istrue")
	@Dict(dicCode = "istrue")
    @ApiModelProperty(value = "是否为变更记录替换模板")
    private java.lang.String iswbgjlthmb;
	/**模板页数*/
	@Excel(name = "模板页数", width = 15)
    @ApiModelProperty(value = "模板页数")
    private java.lang.Integer mbys;
	/**变更字数项*/
	@Excel(name = "变更字数项", width = 15)
    @ApiModelProperty(value = "变更字数项")
    private java.lang.Integer bgzsx;
	/**附件来源*/
	@Excel(name = "附件来源", width = 15, dicCode = "fjly")
	@Dict(dicCode = "fjly")
    @ApiModelProperty(value = "附件来源")
    private java.lang.String fjly;
	/**附件盖章位置x轴*/
	@Excel(name = "附件盖章位置x轴", width = 15)
    @ApiModelProperty(value = "附件盖章位置x轴")
    private java.lang.String fjpostX;
	/**附件盖章位置y轴*/
	@Excel(name = "附件盖章位置y轴", width = 15)
    @ApiModelProperty(value = "附件盖章位置y轴")
    private java.lang.String fjpostY;
    private java.lang.String isecgz;
    private java.lang.String ecgzX;
    private java.lang.String ecgzY;

	@Excel(name = "附件是否盖章", width = 15)
	@ApiModelProperty(value = "附件是否盖章")
	private String isSeal;



}
