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
 * @Description: t_jc_zs_mzyphjsypddscpj_zb_ls
 * @Author: jeecg-boot
 * @Date:   2024-06-20
 * @Version: V1.0
 */
@Data
@TableName("t_jc_zs_mzyphjsypddscpj_zb_ls")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="t_jc_zs_mzyphjsypddscpj_zb_ls对象", description="t_jc_zs_mzyphjsypddscpj_zb_ls")
public class TJcZsMzyphjsypddscpjZbLs implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.String id;
	/**zsid*/
	@Excel(name = "zsid", width = 15)
    @ApiModelProperty(value = "zsid")
    private java.lang.String zsid;
	/**num*/
	@Excel(name = "num", width = 15)
    @ApiModelProperty(value = "num")
    private java.lang.Integer num;
	/**ypmc*/
	@Excel(name = "ypmc", width = 15)
    @ApiModelProperty(value = "ypmc")
    private java.lang.String ypmc;
	/**jy*/
	@Excel(name = "jy", width = 15)
    @ApiModelProperty(value = "jy")
    private java.lang.String jy;
	/**gg*/
	@Excel(name = "guige", width = 15)
    @ApiModelProperty(value = "guige")
    private java.lang.String guige;
	/**gzlb*/
	@Excel(name = "gzlb", width = 15)
    @ApiModelProperty(value = "gzlb")
    private java.lang.String gzlb;
	/**pzwh*/
	@Excel(name = "pzwh", width = 15)
    @ApiModelProperty(value = "pzwh")
    private java.lang.String pzwh;
	/**zt*/
	@Excel(name = "zt", width = 15)
    @ApiModelProperty(value = "zt")
    private java.lang.Integer zt;
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
