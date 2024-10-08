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
 * @Description: t_jc_zs_ypscxk_gmp_ls
 * @Author: jeecg-boot
 * @Date:   2024-06-20
 * @Version: V1.0
 */
@Data
@TableName("t_jc_zs_ypscxk_gmp_ls")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="t_jc_zs_ypscxk_gmp_ls对象", description="t_jc_zs_ypscxk_gmp_ls")
public class TJcZsYpscxkGmpLs implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.String id;
	/**authname*/
	@Excel(name = "authname", width = 15)
    @ApiModelProperty(value = "authname")
    private java.lang.String authname;
	/**authrange*/
	@Excel(name = "authrange", width = 15)
    @ApiModelProperty(value = "authrange")
    private java.lang.String authrange;
	/**passauthdate*/
	@Excel(name = "passauthdate", width = 15)
    @ApiModelProperty(value = "passauthdate")
    private java.lang.String passauthdate;
	/**authorg*/
	@Excel(name = "authorg", width = 15)
    @ApiModelProperty(value = "authorg")
    private java.lang.String authorg;
	/**countryname*/
	@Excel(name = "countryname", width = 15)
    @ApiModelProperty(value = "countryname")
    private java.lang.String countryname;
	/**varietyname*/
	@Excel(name = "varietyname", width = 15)
    @ApiModelProperty(value = "varietyname")
    private java.lang.String varietyname;
	/**remark*/
	@Excel(name = "remark", width = 15)
    @ApiModelProperty(value = "remark")
    private java.lang.String remark;
	/**zt*/
	@Excel(name = "zt", width = 15)
    @ApiModelProperty(value = "zt")
    private java.lang.String zt;
	/**entid*/
	@Excel(name = "entid", width = 15)
    @ApiModelProperty(value = "entid")
    private java.lang.String entid;
	/**sync*/
	@Excel(name = "sync", width = 15)
    @ApiModelProperty(value = "sync")
    private java.lang.String sync;
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
