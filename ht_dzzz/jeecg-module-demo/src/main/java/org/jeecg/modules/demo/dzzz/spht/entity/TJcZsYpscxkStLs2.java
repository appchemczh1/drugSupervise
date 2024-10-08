package org.jeecg.modules.demo.dzzz.spht.entity;

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
 * @Description: t_jc_zs_ypscxk_st_ls2
 * @Author: jeecg-boot
 * @Date:   2024-08-01
 * @Version: V1.0
 */
@Data
@TableName(value = "t_jc_zs_ypscxk_st",schema = "YJJXZSPXT")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="t_jc_zs_ypscxk_st_ls2对象", description="t_jc_zs_ypscxk_st_ls2")
public class TJcZsYpscxkStLs2 implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.String id;
	/**protype*/
	@Excel(name = "protype", width = 15)
    @ApiModelProperty(value = "protype")
    private java.lang.String protype;
	/**refcompaddr*/
	@Excel(name = "refcompaddr", width = 15)
    @ApiModelProperty(value = "refcompaddr")
    private java.lang.String refcompaddr;
	/**workshop*/
	@Excel(name = "workshop", width = 15)
    @ApiModelProperty(value = "workshop")
    private java.lang.String workshop;
	/**refcompname*/
	@Excel(name = "refcompname", width = 15)
    @ApiModelProperty(value = "refcompname")
    private java.lang.String refcompname;
	/**refcompid*/
	@Excel(name = "refcompid", width = 15)
    @ApiModelProperty(value = "refcompid")
    private java.lang.String refcompid;
	/**preparation*/
	@Excel(name = "preparation", width = 15)
    @ApiModelProperty(value = "preparation")
    private java.lang.String preparation;
	/**drugtype*/
	@Excel(name = "drugtype", width = 15)
    @ApiModelProperty(value = "drugtype")
    private java.lang.String drugtype;
	/**drugname*/
	@Excel(name = "drugname", width = 15)
    @ApiModelProperty(value = "drugname")
    private java.lang.String drugname;
	/**cordrugid*/
	@Excel(name = "cordrugid", width = 15)
    @ApiModelProperty(value = "cordrugid")
    private java.lang.String cordrugid;
	/**regnumb*/
	@Excel(name = "regnumb", width = 15)
    @ApiModelProperty(value = "regnumb")
    private java.lang.String regnumb;
	/**drugdose*/
	@Excel(name = "drugdose", width = 15)
    @ApiModelProperty(value = "drugdose")
    private java.lang.String drugdose;
	/**spec*/
	@Excel(name = "spec", width = 15)
    @ApiModelProperty(value = "spec")
    private java.lang.String spec;
	/**entrustvalidate*/
	@Excel(name = "entrustvalidate", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "entrustvalidate")
    private java.util.Date entrustvalidate;
	/**productionscope*/
	@Excel(name = "productionscope", width = 15)
    @ApiModelProperty(value = "productionscope")
    private java.lang.String productionscope;
	/**productionscopef*/
	@Excel(name = "productionscopef", width = 15)
    @ApiModelProperty(value = "productionscopef")
    private java.lang.String productionscopef;
	/**throughput*/
	@Excel(name = "throughput", width = 15)
    @ApiModelProperty(value = "throughput")
    private java.lang.String throughput;
	/**calculationunit*/
	@Excel(name = "calculationunit", width = 15)
    @ApiModelProperty(value = "calculationunit")
    private java.lang.String calculationunit;
	/**preparationnumber*/
	@Excel(name = "preparationnumber", width = 15)
    @ApiModelProperty(value = "preparationnumber")
    private java.lang.String preparationnumber;
	/**getgmpcertificate*/
	@Excel(name = "getgmpcertificate", width = 15)
    @ApiModelProperty(value = "getgmpcertificate")
    private java.lang.String getgmpcertificate;
	/**gmprzscope*/
	@Excel(name = "gmprzscope", width = 15)
    @ApiModelProperty(value = "gmprzscope")
    private java.lang.String gmprzscope;
	/**zt*/
	@Excel(name = "zt", width = 15)
    @ApiModelProperty(value = "zt")
    private java.lang.String zt;
	/**bgqid*/
	@Excel(name = "bgqid", width = 15)
    @ApiModelProperty(value = "bgqid")
    private java.lang.String bgqid;
	/**addrdetail*/
	@Excel(name = "addrdetail", width = 15)
    @ApiModelProperty(value = "addrdetail")
    private java.lang.String addrdetail;
	/**zsid*/
	@Excel(name = "zsid", width = 15)
    @ApiModelProperty(value = "zsid")
    private java.lang.String zsid;
	/**createtime*/
	@Excel(name = "createtime", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "createtime")
    private java.util.Date createtime;
	/**gzrq*/
	@Excel(name = "gzrq", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "gzrq")
    private java.util.Date gzrq;
	/**productionscopecode*/
	@Excel(name = "productionscopecode", width = 15)
    @ApiModelProperty(value = "productionscopecode")
    private java.lang.String productionscopecode;
	/**regnumbvalidate*/
	@Excel(name = "regnumbvalidate", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "regnumbvalidate")
    private java.util.Date regnumbvalidate;
	/**hfrq*/
	@Excel(name = "hfrq", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "hfrq")
    private java.util.Date hfrq;
	/**xzspid*/
	@Excel(name = "xzspid", width = 15)
    @ApiModelProperty(value = "xzspid")
    private java.lang.String xzspid;
	/**ggflag*/
	@Excel(name = "ggflag", width = 15)
    @ApiModelProperty(value = "ggflag")
    private java.lang.String ggflag;
	/**isgmp*/
	@Excel(name = "isgmp", width = 15)
    @ApiModelProperty(value = "isgmp")
    private java.lang.String isgmp;
	/**throughput1*/
	@Excel(name = "throughput1", width = 15)
    @ApiModelProperty(value = "throughput1")
    private java.lang.String throughput1;
	/**preparationnumber1*/
	@Excel(name = "preparationnumber1", width = 15)
    @ApiModelProperty(value = "preparationnumber1")
    private java.lang.String preparationnumber1;
	/**sync*/
//	@Excel(name = "sync", width = 15)
//    @ApiModelProperty(value = "sync")
//    private java.lang.String sync;
	/**num*/
	@Excel(name = "num", width = 15)
    @ApiModelProperty(value = "num")
    private java.lang.String num;
}
