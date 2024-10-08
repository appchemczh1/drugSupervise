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
 * @Description: 医疗器械临床试验备案
 * @Author: jeecg-boot
 * @Date:   2024-06-17
 * @Version: V1.0
 */
@ApiModel(value="certchird_ylqxlcsyba对象", description="医疗器械临床试验备案")
@Data
@TableName("certchird_ylqxlcsyba")
public class CertchirdYlqxlcsyba implements Serializable {
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
	/**证书id*/
    @ApiModelProperty(value = "证书id")
    private String zsid;
	/**条数*/
	@Excel(name = "条数", width = 15)
    @ApiModelProperty(value = "条数")
    private String ts;
	/**拟生产药品的名称*/
	@Excel(name = "拟生产药品的名称", width = 15)
    @ApiModelProperty(value = "拟生产药品的名称")
    private String nscypmc;
	/**地址/科室*/
	@Excel(name = "地址/科室", width = 15)
    @ApiModelProperty(value = "地址/科室")
    private String dz;
	/**批准文号联系人/职务*/
	@Excel(name = "批准文号联系人/职务", width = 15)
    @ApiModelProperty(value = "批准文号联系人/职务")
    private String lxr;
	/**电话*/
	@Excel(name = "电话", width = 15)
    @ApiModelProperty(value = "电话")
    private String dh;
	/**类别 1临床实验机构(如多中心应注明牵头单位)2:研究者*/
	@Excel(name = "类别 1临床实验机构(如多中心应注明牵头单位)2:研究者", width = 15)
    @ApiModelProperty(value = "类别 1临床实验机构(如多中心应注明牵头单位)2:研究者")
    private String lb;
	/**状态 0正常 1删除*/
	@Excel(name = "状态 0正常 1删除", width = 15)
    @ApiModelProperty(value = "状态 0正常 1删除")
    private String zt;
    private java.lang.String xzspid;

}
