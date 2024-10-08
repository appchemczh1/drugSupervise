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
 * @Description: t_jc_zs_ylqxcpckxszm_zb_ls2
 * @Author: jeecg-boot
 * @Date:   2024-08-01
 * @Version: V1.0
 */
@Data
@TableName(value = "t_jc_zs_ylqxcpckxszm_zb",schema = "YJJXZSPXT")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="t_jc_zs_ylqxcpckxszm_zb_ls2对象", description="t_jc_zs_ylqxcpckxszm_zb_ls2")
public class TJcZsYlqxcpckxszmZbLs2 implements Serializable {
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
	/**gg*/
	@Excel(name = "gg", width = 15)
    @ApiModelProperty(value = "gg")
    @TableField(value = "\"gg\"")
    private java.lang.String gg;
	/**bh*/
	@Excel(name = "bh", width = 15)
    @ApiModelProperty(value = "bh")
    private java.lang.String bh;
	/**zt*/
	@Excel(name = "zt", width = 15)
    @ApiModelProperty(value = "zt")
    private java.lang.Integer zt;
	/**sync*/
//	@Excel(name = "sync", width = 15)
//    @ApiModelProperty(value = "sync")
//    private java.lang.String sync;
}
