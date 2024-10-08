package org.jeecg.modules.demo.dzzz.whsjZb.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.jeecgframework.poi.excel.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: ba_qxwlxsba_zb_zs
 * @Author: jeecg-boot
 * @Date:   2024-09-01
 * @Version: V1.0
 */
@Data
@TableName("ba_qxwlxsba_zb_zs")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ba_qxwlxsba_zb_zs对象", description="ba_qxwlxsba_zb_zs")
public class BaQxwlxsbaZbZs implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.String id;
	/**zsid*/
	@Excel(name = "zsid", width = 15)
    @ApiModelProperty(value = "zsid")
    private java.lang.String zsid;
	/**shxydm*/
	@Excel(name = "shxydm", width = 15)
    @ApiModelProperty(value = "shxydm")
    private java.lang.String shxydm;
	/**dsfptbafptmc*/
	@Excel(name = "dsfptbafptmc", width = 15)
    @ApiModelProperty(value = "dsfptbafptmc")
    private java.lang.String dsfptbafptmc;
	/**pzbh*/
	@Excel(name = "pzbh", width = 15)
    @ApiModelProperty(value = "pzbh")
    private java.lang.String pzbh;
	/**bz*/
	@Excel(name = "bz", width = 15)
    @ApiModelProperty(value = "bz")
    private java.lang.String bz;
	/**num*/
	@Excel(name = "num", width = 15)
    @ApiModelProperty(value = "num")
    private java.lang.String num;
	/**xzspid*/
	@Excel(name = "xzspid", width = 15)
    @ApiModelProperty(value = "xzspid")
    private java.lang.String xzspid;
}
