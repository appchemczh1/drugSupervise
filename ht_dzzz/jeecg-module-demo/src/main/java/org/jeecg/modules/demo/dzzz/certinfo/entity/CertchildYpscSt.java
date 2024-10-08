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
 * @Description: 药品生产子表受托
 * @Author: jeecg-boot
 * @Date:   2024-03-27
 * @Version: V1.0
 */
@ApiModel(value="certchild_ypsc_st对象", description="药品生产子表受托")
@Data
@TableName("certchild_ypsc_st")
public class CertchildYpscSt implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private java.lang.String id;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
//	/**创建日期*/
//	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
//    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
//    @ApiModelProperty(value = "创建日期")
//    private java.util.Date createTime;
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
	/**受托*/
	@Excel(name = "受托", width = 15)
    @ApiModelProperty(value = "受托")
    private java.lang.String protype;
	/**注册地址*/
	@Excel(name = "注册地址", width = 15)
    @ApiModelProperty(value = "注册地址")
    private java.lang.String refcompaddr;
	/**车间*/
	@Excel(name = "车间", width = 15)
    @ApiModelProperty(value = "车间")
    private java.lang.String workshop;
	/**受托/委托企业名称*/
	@Excel(name = "受托/委托企业名称", width = 15)
    @ApiModelProperty(value = "受托/委托企业名称")
    private java.lang.String refcompname;
	/**受托/委托企业id*/
	@Excel(name = "受托/委托企业id", width = 15)
    @ApiModelProperty(value = "受托/委托企业id")
    private java.lang.String refcompId;
	/**生产线*/
	@Excel(name = "生产线", width = 15)
    @ApiModelProperty(value = "生产线")
    private java.lang.String preparation;
	/**生产药类型 1原料 2非原料3暂无品种批次*/
	@Excel(name = "生产药类型 1原料 2非原料3暂无品种批次", width = 15)
    @ApiModelProperty(value = "生产药类型 1原料 2非原料3暂无品种批次")
    private java.lang.String drugtype;
	/**药品通用名称*/
	@Excel(name = "药品通用名称", width = 15)
    @ApiModelProperty(value = "药品通用名称")
    private java.lang.String drugname;
	/**相关药品编码*/
	@Excel(name = "相关药品编码", width = 15)
    @ApiModelProperty(value = "相关药品编码")
    private java.lang.String cordrugid;
	/**批准文号/登记号*/
	@Excel(name = "批准文号/登记号", width = 15)
    @ApiModelProperty(value = "批准文号/登记号")
    private java.lang.String regnumb;
	/**药品剂型*/
	@Excel(name = "药品剂型", width = 15)
    @ApiModelProperty(value = "药品剂型")
    private java.lang.String drugdose;
	/**药品规格*/
	@Excel(name = "药品规格", width = 15)
    @ApiModelProperty(value = "药品规格")
    private java.lang.String spec;
	/**委托有效期*/
	@Excel(name = "委托有效期", width = 15)
    @ApiModelProperty(value = "委托有效期")
    private java.lang.String entrustvalidate;
	/**生产范围(正本)*/
	@Excel(name = "生产范围(正本)", width = 15)
    @ApiModelProperty(value = "生产范围(正本)")
    private java.lang.String productionscope;
	/**生产范围(副本)*/
	@Excel(name = "生产范围(副本)", width = 15)
    @ApiModelProperty(value = "生产范围(副本)")
    private java.lang.String productionscopeF;
	/**年生产能力*/
	@Excel(name = "年生产能力", width = 15)
    @ApiModelProperty(value = "年生产能力")
    private java.lang.String throughput;
	/**计算单位*/
	@Excel(name = "计算单位", width = 15)
    @ApiModelProperty(value = "计算单位")
    private java.lang.String calculationunit;
	/**生产线(条)*/
	@Excel(name = "生产线(条)", width = 15)
    @ApiModelProperty(value = "生产线(条)")
    private java.lang.String preparationnumber;
	/**药品GMP证书编码*/
	@Excel(name = "药品GMP证书编码", width = 15)
    @ApiModelProperty(value = "药品GMP证书编码")
    private java.lang.String getgmpcertificate;
	/**gmp认证范围*/
	@Excel(name = "gmp认证范围", width = 15)
    @ApiModelProperty(value = "gmp认证范围")
    private java.lang.String gmprzscope;
	/**状态 0失效 1有效 2变更*/
	@Excel(name = "状态 0失效 1有效 2变更", width = 15)
    @ApiModelProperty(value = "状态 0失效 1有效 2变更")
    private java.lang.String zt;
	/**变更前Id*/
	@Excel(name = "变更前Id", width = 15)
    @ApiModelProperty(value = "变更前Id")
    private java.lang.String bgqid;
	/**生产地址详情*/
	@Excel(name = "生产地址详情", width = 15)
    @ApiModelProperty(value = "生产地址详情")
    private java.lang.String addrdetail;
	/**证书id*/
    @ApiModelProperty(value = "证书id")
    private java.lang.String zsid;
	/**创建日期*/
	@Excel(name = "创建日期", width = 15)
    @ApiModelProperty(value = "创建日期")
    private java.lang.String createtime;
	/**盖章日期*/
	@Excel(name = "盖章日期", width = 15)
    @ApiModelProperty(value = "盖章日期")
    private java.lang.String gztime;
	/**生产范围正本code*/
	@Excel(name = "生产范围正本code", width = 15)
    @ApiModelProperty(value = "生产范围正本code")
    private java.lang.String productionscopecode;
	/**行政审批id*/
	@Excel(name = "行政审批id", width = 15)
    @ApiModelProperty(value = "行政审批id")
    private java.lang.String xzspid;
	/**公告环节状态“1许可 2不予许可”*/
	@Excel(name = "公告环节状态“1许可 2不予许可”", width = 15)
    @ApiModelProperty(value = "公告环节状态“1许可 2不予许可”")
    private java.lang.String gghjstatus;
	/**有无药品gmp证书编号*/
	@Excel(name = "有无药品gmp证书编号", width = 15)
    @ApiModelProperty(value = "有无药品gmp证书编号")
    private java.lang.String isgmp;
	/**信息状态  0正常 1删除*/
	@Excel(name = "信息状态  0正常 1删除", width = 15)
    @ApiModelProperty(value = "信息状态  0正常 1删除")
    private java.lang.String sfsc;
	/**数量*/
	@Excel(name = "数量", width = 15)
    @ApiModelProperty(value = "数量")
    private java.lang.String num;
	/**某时间*/
	@Excel(name = "某时间", width = 15)
    @ApiModelProperty(value = "某时间")
    private java.lang.String regnumevalidate;



}
