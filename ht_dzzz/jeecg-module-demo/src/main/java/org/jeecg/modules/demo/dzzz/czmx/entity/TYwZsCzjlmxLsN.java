package org.jeecg.modules.demo.dzzz.czmx.entity;

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
 * @Description: t_yw_zs_czjlmx_ls_n
 * @Author: jeecg-boot
 * @Date:   2024-07-16
 * @Version: V1.0
 */
@Data
@TableName("t_yw_zs_czjlmx_ls_n")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="t_yw_zs_czjlmx_ls_n对象", description="t_yw_zs_czjlmx_ls_n")
public class TYwZsCzjlmxLsN implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.String id;
	/**zdmc*/
	@Excel(name = "zdmc", width = 15)
    @ApiModelProperty(value = "zdmc")
    private java.lang.String zdmc;
	/**jz*/
	@Excel(name = "jz", width = 15)
    @ApiModelProperty(value = "jz")
    private java.lang.String jz;
	/**xz*/
	@Excel(name = "xz", width = 15)
    @ApiModelProperty(value = "xz")
    private java.lang.String xz;
	/**czsj*/
	@Excel(name = "czsj", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "czsj")
    private java.util.Date czsj;
	/**zt*/
	@Excel(name = "zt", width = 15)
    @ApiModelProperty(value = "zt")
    private java.lang.Integer zt;
	/**bz*/
	@Excel(name = "bz", width = 15)
    @ApiModelProperty(value = "bz")
    private java.lang.String bz;
	/**zsczjlid*/
	@Excel(name = "zsczjlid", width = 15)
    @ApiModelProperty(value = "zsczjlid")
    private java.lang.String zsczjlid;
	/**bm*/
	@Excel(name = "bm", width = 15)
    @ApiModelProperty(value = "bm")
    private java.lang.String bm;
	/**jlid*/
	@Excel(name = "jlid", width = 15)
    @ApiModelProperty(value = "jlid")
    private java.lang.String jlid;
	/**pxm*/
	@Excel(name = "pxm", width = 15)
    @ApiModelProperty(value = "pxm")
    private java.lang.Integer pxm;
	/**pid*/
	@Excel(name = "pid", width = 15)
    @ApiModelProperty(value = "pid")
    private java.lang.String pid;
	/**zdzwmc*/
	@Excel(name = "zdzwmc", width = 15)
    @ApiModelProperty(value = "zdzwmc")
    private java.lang.String zdzwmc;
	/**bgcs*/
	@Excel(name = "bgcs", width = 15)
    @ApiModelProperty(value = "bgcs")
    private java.lang.Integer bgcs;
	/**synctime*/
	@Excel(name = "synctime", width = 15)
    @ApiModelProperty(value = "synctime")
    private java.lang.String synctime;
	/**issc*/
	@Excel(name = "issc", width = 15)
    @ApiModelProperty(value = "issc")
    private java.lang.String issc;
}
