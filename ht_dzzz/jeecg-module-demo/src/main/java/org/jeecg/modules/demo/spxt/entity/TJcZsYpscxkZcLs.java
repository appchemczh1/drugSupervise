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
 * @Description: t_jc_zs_ypscxk_zc_ls
 * @Author: jeecg-boot
 * @Date:   2024-06-20
 * @Version: V1.0
 */
@Data
@TableName("t_jc_zs_ypscxk_zc_ls")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="t_jc_zs_ypscxk_zc_ls对象", description="t_jc_zs_ypscxk_zc_ls")
public class TJcZsYpscxkZcLs implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.String id;
	/**protype*/
	@Excel(name = "protype", width = 15)
    @ApiModelProperty(value = "protype")
    private java.lang.String protype;
	/**workshop*/
	@Excel(name = "workshop", width = 15)
    @ApiModelProperty(value = "workshop")
    private java.lang.String workshop;
	/**preparation*/
	@Excel(name = "preparation", width = 15)
    @ApiModelProperty(value = "preparation")
    private java.lang.String preparation;
	/**productionscope*/
	@Excel(name = "productionscope", width = 15)
    @ApiModelProperty(value = "productionscope")
    private java.lang.String productionscope;
	/**productionscopef*/
	@Excel(name = "productionscopef", width = 15)
    @ApiModelProperty(value = "productionscopef")
    private java.lang.String productionscopef;
	/**zt*/
	@Excel(name = "zt", width = 15)
    @ApiModelProperty(value = "zt")
    private java.lang.String zt;
	/**addrdetail*/
	@Excel(name = "addrdetail", width = 15)
    @ApiModelProperty(value = "addrdetail")
    private java.lang.String addrdetail;
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
	/**bgqid*/
	@Excel(name = "bgqid", width = 15)
    @ApiModelProperty(value = "bgqid")
    private java.lang.String bgqid;
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
	@Excel(name = "sync", width = 15)
    @ApiModelProperty(value = "sync")
    private java.lang.String sync;
	/**num*/
	@Excel(name = "num", width = 15)
    @ApiModelProperty(value = "num")
    private java.lang.String num;
	/**instanceno*/
	@Excel(name = "instanceno", width = 15)
    @ApiModelProperty(value = "instanceno")
    private java.lang.String instanceno;
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
