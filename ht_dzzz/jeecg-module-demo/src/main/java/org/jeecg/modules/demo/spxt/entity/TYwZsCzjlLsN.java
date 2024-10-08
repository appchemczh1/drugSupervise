package org.jeecg.modules.demo.spxt.entity;

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
 * @Description: t_yw_zs_czjl_ls_n
 * @Author: jeecg-boot
 * @Date:   2024-06-20
 * @Version: V1.0
 */
@Data
@TableName("t_yw_zs_czjl_ls_n")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="t_yw_zs_czjl_ls_n对象", description="t_yw_zs_czjl_ls_n")
public class TYwZsCzjlLsN implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.String id;
	/**证书ID*/
	@Excel(name = "证书ID", width = 15)
    @ApiModelProperty(value = "证书ID")
    private java.lang.String zsid;
	/**业务类型，1是核发，2是换发，3是变更，4是注销*/
	@Excel(name = "业务类型，1是核发，2是换发，3是变更，4是注销", width = 15)
    @ApiModelProperty(value = "业务类型，1是核发，2是换发，3是变更，4是注销")
    private java.lang.Integer ywlx;
	/**cjsj*/
	@Excel(name = "cjsj", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "cjsj")
    private java.util.Date cjsj;
	/**sjly*/
	@Excel(name = "sjly", width = 15)
    @ApiModelProperty(value = "sjly")
    private java.lang.Integer sjly;
	/**状态*/
	@Excel(name = "状态", width = 15)
    @ApiModelProperty(value = "状态")
    private java.lang.Integer zt;
	/**行政审批id*/
	@Excel(name = "行政审批id", width = 15)
    @ApiModelProperty(value = "行政审批id")
    private java.lang.String xzspslh;
	/**操作人id*/
	@Excel(name = "操作人id", width = 15)
    @ApiModelProperty(value = "操作人id")
    private java.lang.String czrid;
	/**操作人姓名*/
	@Excel(name = "操作人姓名", width = 15)
    @ApiModelProperty(value = "操作人姓名")
    private java.lang.String czrxm;
	/**操作时间*/
	@Excel(name = "操作时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "操作时间")
    private java.util.Date czsj;
	/**pid*/
	@Excel(name = "pid", width = 15)
    @ApiModelProperty(value = "pid")
    private java.lang.String pid;
	/**bgcs*/
	@Excel(name = "bgcs", width = 15)
    @ApiModelProperty(value = "bgcs")
    private java.lang.Integer bgcs;
	/**bgzt*/
	@Excel(name = "bgzt", width = 15)
    @ApiModelProperty(value = "bgzt")
    private java.lang.Integer bgzt;
	/**状态交互，0为待取，1为已取*/
	@Excel(name = "状态交互，0为待取，1为已取", width = 15)
    @ApiModelProperty(value = "状态交互，0为待取，1为已取")
    private java.lang.Integer sync;
	/**bgs*/
	@Excel(name = "bgs", width = 15)
    @ApiModelProperty(value = "bgs")
    private java.lang.Integer bgs;
	/**qzwhzt*/
	@Excel(name = "qzwhzt", width = 15)
    @ApiModelProperty(value = "qzwhzt")
    private java.lang.Integer qzwhzt;
	/**盖章状态_证书系统盖章获取签批时间后修改*/
	@Excel(name = "盖章状态_证书系统盖章获取签批时间后修改", width = 15)
    @ApiModelProperty(value = "盖章状态_证书系统盖章获取签批时间后修改")
    private java.lang.String gzstatus;
	/**dzzzsync*/
	@Excel(name = "dzzzsync", width = 15)
    @ApiModelProperty(value = "dzzzsync")
    private java.lang.String dzzzsync;
	/**新证书系统用于记录完整变更内容*/
	@Excel(name = "新证书系统用于记录完整变更内容", width = 15)
    @ApiModelProperty(value = "新证书系统用于记录完整变更内容")
    private java.lang.String bgjl;
	/**bzjl*/
	@Excel(name = "bzjl", width = 15)
    @ApiModelProperty(value = "bzjl")
    private java.lang.String bzjl;
	/**synctime*/
	@Excel(name = "synctime", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "synctime")
    private java.util.Date synctime;
	/**issc*/
	@Excel(name = "issc", width = 15)
    @ApiModelProperty(value = "issc")
    private java.lang.String issc;
}
