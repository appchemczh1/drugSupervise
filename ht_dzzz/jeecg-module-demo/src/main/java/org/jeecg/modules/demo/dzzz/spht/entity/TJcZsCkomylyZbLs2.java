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
 * @Description: t_jc_zs_ckomyly_zb_ls2
 * @Author: jeecg-boot
 * @Date:   2024-08-01
 * @Version: V1.0
 */
@Data
@TableName(value = "t_jc_zs_ckomyly_zb",schema = "YJJXZSPXT")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="t_jc_zs_ckomyly_zb_ls2对象", description="t_jc_zs_ckomyly_zb_ls2")
public class TJcZsCkomylyZbLs2 implements Serializable {
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
	/**yptymczw*/
	@Excel(name = "yptymczw", width = 15)
    @ApiModelProperty(value = "yptymczw")
    private java.lang.String yptymczw;
	/**yptymcyw*/
	@Excel(name = "yptymcyw", width = 15)
    @ApiModelProperty(value = "yptymcyw")
    private java.lang.String yptymcyw;
	/**jgffzw*/
	@Excel(name = "jgffzw", width = 15)
    @ApiModelProperty(value = "jgffzw")
    private java.lang.String jgffzw;
	/**jgffyw*/
	@Excel(name = "jgffyw", width = 15)
    @ApiModelProperty(value = "jgffyw")
    private java.lang.String jgffyw;
	/**zgyppzwhzw*/
	@Excel(name = "zgyppzwhzw", width = 15)
    @ApiModelProperty(value = "zgyppzwhzw")
    private java.lang.String zgyppzwhzw;
	/**zgyppzwhyw*/
	@Excel(name = "zgyppzwhyw", width = 15)
    @ApiModelProperty(value = "zgyppzwhyw")
    private java.lang.String zgyppzwhyw;
	/**sftgrz*/
	@Excel(name = "sftgrz", width = 15)
    @ApiModelProperty(value = "sftgrz")
    private java.lang.String sftgrz;
	/**zt*/
	@Excel(name = "zt", width = 15)
    @ApiModelProperty(value = "zt")
    private java.lang.Integer zt;
}
