package org.jeecg.modules.demo.dzzz.certinfo.entity;

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
 * @Description: 药瓶生产子表gmp
 * @Author: jeecg-boot
 * @Date:   2024-06-17
 * @Version: V1.0
 */
@ApiModel(value="certchild_ypsc_gmp对象", description="药瓶生产子表gmp")
@Data
@TableName("certchild_ypsc_gmp")
public class CertchildYpscGmp implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private String id;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private String createBy;
	/**创建日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期")
    private Date createTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private String updateBy;
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期")
    private Date updateTime;
	/**所属部门*/
    @ApiModelProperty(value = "所属部门")
    private String sysOrgCode;
	/**证书Id*/
    @ApiModelProperty(value = "证书Id")
    private String zsid;
	/**认证(检查)名称*/
	@Excel(name = "认证(检查)名称", width = 15)
    @ApiModelProperty(value = "认证(检查)名称")
    private String authname;
	/**认证(检查)范围*/
	@Excel(name = "认证(检查)范围", width = 15)
    @ApiModelProperty(value = "认证(检查)范围")
    private String authrange;
	/**通过认证(检查)时间*/
	@Excel(name = "通过认证(检查)时间", width = 15)
    @ApiModelProperty(value = "通过认证(检查)时间")
    private String passauthdate;
	/**认证(检查)机构名称*/
	@Excel(name = "认证(检查)机构名称", width = 15)
    @ApiModelProperty(value = "认证(检查)机构名称")
    private String authorg;
	/**国家(地区、组织)名称*/
	@Excel(name = "国家(地区、组织)名称", width = 15)
    @ApiModelProperty(value = "国家(地区、组织)名称")
    private String countryname;
	/**涉及品种名称*/
	@Excel(name = "涉及品种名称", width = 15)
    @ApiModelProperty(value = "涉及品种名称")
    private String sjpzmc;
	/**备注*/
	@Excel(name = "备注", width = 15)
    @ApiModelProperty(value = "备注")
    private String bz;
	/**状态*/
	@Excel(name = "状态", width = 15)
    @ApiModelProperty(value = "状态")
    private String zt;
	/**企业id*/
	@Excel(name = "企业id", width = 15)
    @ApiModelProperty(value = "企业id")
    private String qyid;
	/**0正常1删除*/
	@Excel(name = "0正常1删除", width = 15)
    @ApiModelProperty(value = "0正常1删除")
    private String sfsc;
}
