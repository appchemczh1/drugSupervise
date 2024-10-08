package org.jeecg.modules.demo.dzzz.spht.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.jeecgframework.poi.excel.annotation.Excel;

import java.io.Serializable;

/**
 * @Description: ba_qxwlxsba_zb_ls2
 * @Author: jeecg-boot
 * @Date:   2024-08-01
 * @Version: V1.0
 */
@Data
@TableName(value = "ba_qxwlxsba_zb_ls")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ba_qxwlxsba_zb_ls对象", description="ba_qxwlxsba_zb_ls")
public class BaQxwlxsbaZbLs implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private String id;
	/**zsid*/
	@Excel(name = "zsid", width = 15)
    @ApiModelProperty(value = "zsid")
    private String zsid;
	/**shxydm*/
	@Excel(name = "shxydm", width = 15)
    @ApiModelProperty(value = "shxydm")
    private String shxydm;
	/**dsfptbafptmc*/
	@Excel(name = "dsfptbafptmc", width = 15)
    @ApiModelProperty(value = "dsfptbafptmc")
    private String dsfptbafptmc;
	/**pzbh*/
	@Excel(name = "pzbh", width = 15)
    @ApiModelProperty(value = "pzbh")
    private String pzbh;
	/**bz*/
	@Excel(name = "bz", width = 15)
    @ApiModelProperty(value = "bz")
    private String bz;
	/**sync*/
//	@Excel(name = "sync", width = 15)
//    @ApiModelProperty(value = "sync")
//    private java.lang.String sync;
	/**xzspid*/
//	@Excel(name = "xzspid", width = 15)
//    @ApiModelProperty(value = "xzspid")
//    private java.lang.String xzspid;
	/**num*/
	@Excel(name = "num", width = 15)
    @ApiModelProperty(value = "num")
    private String num;
}
