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
 * @Description: t_jc_zs_dylylqxscbapz_zb_ls2
 * @Author: jeecg-boot
 * @Date:   2024-08-01
 * @Version: V1.0
 */
@Data
@TableName(value = "t_jc_zs_dylylqxscbapz_zb",schema = "YJJXZSPXT")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="t_jc_zs_dylylqxscbapz_zb_ls2对象", description="t_jc_zs_dylylqxscbapz_zb_ls2")
public class TJcZsDylylqxscbapzZbLs2 implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.String id;
	/**zsid*/
	@Excel(name = "zsid", width = 15)
    @ApiModelProperty(value = "zsid")
    private java.lang.String zsid;
	/**zczh*/
	@Excel(name = "zczh", width = 15)
    @ApiModelProperty(value = "zczh")
    private java.lang.String zczh;
	/**cplbDm*/
	@Excel(name = "cplbDm", width = 15)
    @ApiModelProperty(value = "cplbDm")
    private java.lang.String cplbDm;
	/**sfwtsc*/
	@Excel(name = "sfwtsc", width = 15)
    @ApiModelProperty(value = "sfwtsc")
    private java.lang.String sfwtsc;
	/**zcbarmc*/
	@Excel(name = "zcbarmc", width = 15)
    @ApiModelProperty(value = "zcbarmc")
    private java.lang.String zcbarmc;
	/**zcbardz*/
	@Excel(name = "zcbardz", width = 15)
    @ApiModelProperty(value = "zcbardz")
    private java.lang.String zcbardz;
	/**shxydm*/
	@Excel(name = "shxydm", width = 15)
    @ApiModelProperty(value = "shxydm")
    private java.lang.String shxydm;
	/**wtqx*/
	@Excel(name = "wtqx", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "wtqx")
    private java.util.Date wtqx;
	/**bz*/
	@Excel(name = "bz", width = 15)
    @ApiModelProperty(value = "bz")
    private java.lang.String bz;
	/**cpmc*/
	@Excel(name = "cpmc", width = 15)
    @ApiModelProperty(value = "cpmc")
    private java.lang.String cpmc;
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
    private java.math.BigDecimal num;
	/**zt*/
	@Excel(name = "zt", width = 15)
    @ApiModelProperty(value = "zt")
    private java.math.BigDecimal zt;
}
