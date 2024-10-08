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
 * @Description: certchild_ypsc_st_h
 * @Author: jeecg-boot
 * @Date:   2024-07-03
 * @Version: V1.0
 */
@Data
@TableName("certchild_ypsc_st_h")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="certchild_ypsc_st_h对象", description="certchild_ypsc_st_h")
public class CertchildYpscStH implements Serializable {
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
	@Excel(name = "证书id", width = 15)
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
	/**生产类别*/
	@Excel(name = "生产类别", width = 15)
    @ApiModelProperty(value = "生产类别")
    private java.lang.String sclb;
	/**前置库子表Id*/
	@Excel(name = "前置库子表Id", width = 15)
    @ApiModelProperty(value = "前置库子表Id")
    private java.lang.String qzkid;
	/**同步标识*/
	@Excel(name = "同步标识", width = 15)
    @ApiModelProperty(value = "同步标识")
    private java.lang.String sync;
	/**交换状态*/
	@Excel(name = "交换状态", width = 15)
    @ApiModelProperty(value = "交换状态")
    private java.lang.String jhzt;
	/**核减时间*/
	@Excel(name = "核减时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "核减时间")
    private java.util.Date gzrq;
	/**历史受托数据备份*/
	@Excel(name = "历史受托数据备份", width = 15)
    @ApiModelProperty(value = "历史受托数据备份")
    private java.lang.String protypebak;
	/**zsoldid*/
	@Excel(name = "zsoldid", width = 15)
    @ApiModelProperty(value = "zsoldid")
    private java.lang.String zsoldid;
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
