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
 * @Description: t_jc_zs_ylqxlcsyba_zb_ls2
 * @Author: jeecg-boot
 * @Date:   2024-08-01
 * @Version: V1.0
 */
@Data
@TableName(value = "t_jc_zs_ylqxlcsyba_zb",schema = "YJJXZSPXT")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="t_jc_zs_ylqxlcsyba_zb_ls2对象", description="t_jc_zs_ylqxlcsyba_zb_ls2")
public class TJcZsYlqxlcsybaZbLs2 implements Serializable {
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
    private java.lang.String num;
	/**mc*/
	@Excel(name = "mc", width = 15)
    @ApiModelProperty(value = "mc")
    private java.lang.String mc;
	/**dz*/
	@Excel(name = "dz", width = 15)
    @ApiModelProperty(value = "dz")
    private java.lang.String dz;
	/**lxr*/
	@Excel(name = "lxr", width = 15)
    @ApiModelProperty(value = "lxr")
    private java.lang.String lxr;
	/**dh*/
	@Excel(name = "dh", width = 15)
    @ApiModelProperty(value = "dh")
    private java.lang.String dh;
	/**lb*/
	@Excel(name = "lb", width = 15)
    @ApiModelProperty(value = "lb")
    private java.lang.String lb;
	/**sync*/
//	@Excel(name = "sync", width = 15)
//    @ApiModelProperty(value = "sync")
//    private java.lang.String sync;
	/**zt*/
	@Excel(name = "zt", width = 15)
    @ApiModelProperty(value = "zt")
    private java.lang.Integer zt;
}
