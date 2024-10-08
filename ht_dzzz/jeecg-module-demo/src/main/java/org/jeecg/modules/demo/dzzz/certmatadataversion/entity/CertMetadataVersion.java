package org.jeecg.modules.demo.dzzz.certmatadataversion.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
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

/**
 * @Description: 证书元数据版本
 * @Author: jeecg-boot
 * @Date:   2024-03-25
 * @Version: V1.0
 */
@ApiModel(value="cert_metadata_version对象", description="证书元数据版本")
@Data
@TableName("cert_metadata_version")
public class CertMetadataVersion implements Serializable {
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
	/**版本名称*/
	@Excel(name = "版本名称", width = 15)
    @ApiModelProperty(value = "版本名称")
    private java.lang.String bbmc;
	/**定版时间*/
	@Excel(name = "定版时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "定版时间")
    private java.util.Date dbsj;
	/**状态*/
	@Excel(name = "状态", width = 15, dicCode = "certmetadata_versionstatus")
    @Dict(dicCode = "certmetadata_versionstatus")
    @ApiModelProperty(value = "状态")
    private java.lang.String status;
	/**证书类型id*/
	@Excel(name = "证书类型id", width = 15)
    @ApiModelProperty(value = "证书类型id")
    private java.lang.String certTypeId;
	/**版本编号*/
	@Excel(name = "版本编号", width = 15)
    @ApiModelProperty(value = "版本编号")
    private java.lang.String versoncode;
	/**删除标志 0正常1删除*/
	@Excel(name = "删除标志 0正常1删除", width = 15)
    @ApiModelProperty(value = "删除标志 0正常1删除")
    private java.lang.String isdelete;

	/**备用字段*/
	@Excel(name = "备用字段", width = 15)
    @ApiModelProperty(value = "备用字段")
    private java.lang.String byzz1;
	/**备用字段*/
	@Excel(name = "备用字段", width = 15)
    @ApiModelProperty(value = "备用字段")
    private java.lang.String byzz2;
	/**备用字段*/
	@Excel(name = "备用字段", width = 15)
    @ApiModelProperty(value = "备用字段")
    private java.lang.String byzz3;
	/**备用字段*/
	@Excel(name = "备用字段", width = 15)
    @ApiModelProperty(value = "备用字段")
    private java.lang.String byzz4;
}
