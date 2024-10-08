package org.jeecg.modules.demo.dzzz.spht.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;
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
 * @Description: t_jc_zs_mzyphjsypddscpj_zb_ls2
 * @Author: jeecg-boot
 * @Date:   2024-08-01
 * @Version: V1.0
 */
@Data
@TableName(value = "t_jc_zs_mzyphjsypddscpj_zb",schema = "YJJXZSPXT")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="t_jc_zs_mzyphjsypddscpj_zb_ls2对象", description="t_jc_zs_mzyphjsypddscpj_zb_ls2")
public class TJcZsMzyphjsypddscpjZbLs2 implements Serializable {
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
	@Excel(name = "gg", width = 15)
    @ApiModelProperty(value = "gg")
    @TableField(value = "\"gg\"")
    private java.lang.String gg;
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
}
