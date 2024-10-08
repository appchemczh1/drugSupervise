package org.jeecg.modules.demo.dzzz.certmatadataversion.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.UnsupportedEncodingException;

/**
 * @Description: 证书元数据表
 * @Author: jeecg-boot
 * @Date:   2024-03-25
 * @Version: V1.0
 */
@ApiModel(value="cert_metadata对象", description="证书元数据表")
@Data
@TableName("cert_metadata")
public class CertMetadata implements Serializable {
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
	/**前置库业务-证书类型*/
	@Excel(name = "前置库业务-证书类型", width = 15)
    @ApiModelProperty(value = "前置库业务-证书类型")
    private java.lang.String zslx;
	/**列标识*/
	@Excel(name = "列标识", width = 15)
    @ApiModelProperty(value = "列标识")
    private java.lang.String lbs;
	/**列名称*/
	@Excel(name = "列名称", width = 15)
    @ApiModelProperty(value = "列名称")
    private java.lang.String lm;
	/**字段类型*/
	@Excel(name = "字段类型", width = 15)
    @ApiModelProperty(value = "字段类型")
    private java.lang.String zdlx;
	/**字段长度*/
	@Excel(name = "字段长度", width = 15)
    @ApiModelProperty(value = "字段长度")
    private java.lang.String zdcd;
    @Excel(name = "布局样式", width = 15)
    @ApiModelProperty(value = "布局样式")
    private java.lang.String bjys;
    @Excel(name = "是否跨行", width = 15)
    @ApiModelProperty(value = "是否跨行")
    private java.lang.String iskh;
	/**是否允许为空*/
	@Excel(name = "是否允许为空", width = 15)
    @ApiModelProperty(value = "是否允许为空")
    private java.lang.String sfwk;
	/**默认值*/
	@Excel(name = "默认值", width = 15)
    @ApiModelProperty(value = "默认值")
    private java.lang.String mrz;
	/**映射属性*/
	@Excel(name = "映射属性", width = 15)
    @ApiModelProperty(value = "映射属性")
    private java.lang.String yssx;
	/**状态*/
	@Excel(name = "状态", width = 15, dicCode = "certmetadata_versionstatus")
    @ApiModelProperty(value = "状态")
    private java.lang.String zt;
	/**版本id*/
	@Excel(name = "版本id", width = 15)
    @ApiModelProperty(value = "版本id")
    private java.lang.String bbid;
	/**控件类型*/
	@Excel(name = "控件类型", width = 15)
    @ApiModelProperty(value = "控件类型")
    private java.lang.String kjlx;
	/**控件长度*/
	@Excel(name = "控件长度", width = 15)
    @ApiModelProperty(value = "控件长度")
    private java.lang.String kjcd;
	/**外部选择功能*/
	@Excel(name = "外部选择功能", width = 15)
    @ApiModelProperty(value = "外部选择功能")
    private java.lang.String wbxzgn;
	/**是否跨行*/
	@Excel(name = "是否跨行", width = 15)
    @ApiModelProperty(value = "是否跨行")
    private java.lang.String sfkh;
	/**是否删除*/
	@Excel(name = "是否删除", width = 15)
    @ApiModelProperty(value = "是否删除")
    private java.lang.String sfsc;
	/**备用字段2*/
	@Excel(name = "备用字段2", width = 15)
    @ApiModelProperty(value = "备用字段2")
    private java.lang.String byzd1;
	/**备用字段2*/
	@Excel(name = "备用字段2", width = 15)
    @ApiModelProperty(value = "备用字段2")
    private java.lang.String byzd2;
	/**备用字段2*/
	@Excel(name = "备用字段2", width = 15)
    @ApiModelProperty(value = "备用字段2")
    private java.lang.String byzd3;
	/**备用字段*/
	@Excel(name = "备用字段", width = 15)
    @ApiModelProperty(value = "备用字段")
    private java.lang.String byzd4;
	/**排序*/
	@Excel(name = "排序", width = 15)
    @ApiModelProperty(value = "排序")
    private java.lang.String px;
	/**是否公示*/
	@Excel(name = "是否公示", width = 15, dicCode = "istrue")
    @ApiModelProperty(value = "是否公示")
    private java.lang.String isgs;
	/**是否必填*/
	@Excel(name = "是否必填", width = 15, dicCode = "istrue")
    @ApiModelProperty(value = "是否必填")
    private java.lang.String isbt;
	/**模板id*/
    @ApiModelProperty(value = "模板id")
    private java.lang.String certmetadataversionId;
    private java.lang.String typevalue;

	public static CertMetadata byYssx(String yssx) {
		CertMetadata cm = new CertMetadata();
		cm.setYssx(yssx);
		return cm;
	}

}
