package org.jeecg.modules.demo.dzzz.certInfoOperation.entity;

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
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 操作记录表
 * @Author: jeecg-boot
 * @Date:   2024-04-17
 * @Version: V1.0
 */
@Data
@TableName("cert_info_operation_record")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="cert_info_operation_record对象", description="操作记录表")
public class CertInfoOperationRecord implements Serializable {
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
	@Excel(name = "证书id", width = 15)
    @ApiModelProperty(value = "证书id")
    private String zsid;
	/**业务类型*/
	@Excel(name = "业务类型", width = 15)
    @ApiModelProperty(value = "业务类型")
    private String ywlx;
	/**创造时间*/
	@Excel(name = "创造时间", width = 15)
    @ApiModelProperty(value = "创造时间")
    private String czrq;
	/**数据来源*/
	@Excel(name = "数据来源", width = 15)
    @ApiModelProperty(value = "数据来源")
    private String sjly;
	/**状态 0无效1有效*/
	@Excel(name = "状态 其它无效20有效", width = 15)
    @ApiModelProperty(value = "状态 其它无效20有效")
    private String stutas;
	/**行政审批受理号*/
	@Excel(name = "行政审批受理号", width = 15)
    @ApiModelProperty(value = "行政审批受理号")
    private String xzspslh;
	/**操作人员id*/
	@Excel(name = "操作人员id", width = 15)
    @ApiModelProperty(value = "操作人员id")
    private String czryid;
	/**操作人姓名*/
	@Excel(name = "操作人姓名", width = 15)
    @ApiModelProperty(value = "操作人姓名")
    private String czrxm;
	/**操作时间*/
	@Excel(name = "操作时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "操作时间")
    private Date czsj;
	/**变更次数*/
	@Excel(name = "变更次数", width = 15)
    @ApiModelProperty(value = "变更次数")
    private String bgcs;
	/**变更状态*/
	@Excel(name = "变更状态", width = 15)
    @ApiModelProperty(value = "变更状态")
    private String bgzt;
	/**变更内容*/
	@Excel(name = "变更内容", width = 15)
    @ApiModelProperty(value = "变更内容")
    private String bgnr;
	/**取值维护状态*/
	@Excel(name = "取值维护状态", width = 15)
    @ApiModelProperty(value = "取值维护状态")
    private String qzwhzt;
	/**盖章状态*/
	@Excel(name = "盖章状态", width = 15)
    @ApiModelProperty(value = "盖章状态")
    private String gzstutas;
	/**操作记录版本*/
	@Excel(name = "操作记录版本", width = 15)
    @ApiModelProperty(value = "操作记录版本")
    private String czjlbb;
	/**操作次数*/
	@Excel(name = "操作次数", width = 15)
    @ApiModelProperty(value = "操作次数")
    private String operateNo;
	/**实际变更内容*/
	@Excel(name = "实际变更内容", width = 15)
    @ApiModelProperty(value = "实际变更内容")
    private String sjbgnr;
	/**变更类型*/
	@Excel(name = "变更类型", width = 15)
    @ApiModelProperty(value = "变更类型")
    @Dict(dicCode = "changetype")
    private String bglx;
	/**表名*/
	@Excel(name = "表名", width = 15)
    @ApiModelProperty(value = "表名")
    private String tablename;
	/**父id*/
	@Excel(name = "父id", width = 15)
    @ApiModelProperty(value = "父id")
    private String pid;
	/**附件信息*/
	@Excel(name = "附件信息", width = 15)
    @ApiModelProperty(value = "附件信息")
    private String fjxx;
	/**已签章回退待签章历史id*/
	@Excel(name = "已签章回退待签章历史id", width = 15)
    @ApiModelProperty(value = "已签章回退待签章历史id")
    private String oldId;
	/**是否初始化数据*/
	@Excel(name = "是否初始化数据", width = 15)
    @ApiModelProperty(value = "是否初始化数据")
    private String iscsh;
	/**数据标识0无效1有效 无业务，数据问题处理20231108，原data_flag的值*/
	@Excel(name = "数据标识0无效1有效 无业务，数据问题处理20231108，原data_flag的值", width = 15)
    @ApiModelProperty(value = "数据标识0无效1有效 无业务，数据问题处理20231108，原data_flag的值")
    private String oldDataFlag;
	/**印章编号数据初始化使用*/
	@Excel(name = "印章编号数据初始化使用", width = 15)
    @ApiModelProperty(value = "印章编号数据初始化使用")
    private String selcode;
	/**印章名称数据初始化使用*/
	@Excel(name = "印章名称数据初始化使用", width = 15)
    @ApiModelProperty(value = "印章名称数据初始化使用")
    private String selname;
    private String bgyy;
    private String whr;
    private String whyy;
    private String qxgzr;
    private String qxgzyy;
    private String fj;
    private Date gztime;

}
