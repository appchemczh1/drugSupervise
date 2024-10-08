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
 * @Description: ba_qxwlxsba_zb_ls2
 * @Author: jeecg-boot
 * @Date:   2024-08-01
 * @Version: V1.0
 */
@Data
@TableName(value = "ba_qxwlxsba_zb",schema = "YJJXZSPXT")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ba_qxwlxsba_zb_ls2对象", description="ba_qxwlxsba_zb_ls2")
public class BaQxwlxsbaZbLs2 implements Serializable {
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
    private java.lang.String num;
}
