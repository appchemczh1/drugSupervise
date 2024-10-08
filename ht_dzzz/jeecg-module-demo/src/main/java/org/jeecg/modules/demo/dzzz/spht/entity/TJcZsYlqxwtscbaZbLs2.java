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
 * @Description: t_jc_zs_ylqxwtscba_zb_ls2
 * @Author: jeecg-boot
 * @Date:   2024-08-01
 * @Version: V1.0
 */
@Data
@TableName(value = "t_jc_zs_ylqxwtscba_zb",schema = "YJJXZSPXT")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="t_jc_zs_ylqxwtscba_zb_ls2对象", description="t_jc_zs_ylqxwtscba_zb_ls2")
public class TJcZsYlqxwtscbaZbLs2 implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.String id;
	/**zsid*/
	@Excel(name = "zsid", width = 15)
    @ApiModelProperty(value = "zsid")
    private java.lang.String zsid;
	/**cpmc*/
	@Excel(name = "cpmc", width = 15)
    @ApiModelProperty(value = "cpmc")
    private java.lang.String cpmc;
	/**cpzch*/
	@Excel(name = "cpzch", width = 15)
    @ApiModelProperty(value = "cpzch")
    private java.lang.String cpzch;
	/**wtrq*/
	@Excel(name = "wtrq", width = 15)
    @ApiModelProperty(value = "wtrq")
    private java.lang.String wtrq;
	/**px*/
	@Excel(name = "px", width = 15)
    @ApiModelProperty(value = "px")
    private java.lang.Integer px;
	/**zt*/
	@Excel(name = "zt", width = 15)
    @ApiModelProperty(value = "zt")
    private java.lang.Integer zt;
}
