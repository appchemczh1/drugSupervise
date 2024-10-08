package org.jeecg.modules.demo.dzzz.certinfo.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.jeecgframework.poi.excel.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: certchild_dylylqxscbapz
 * @Author: jeecg-boot
 * @Date:   2024-07-09
 * @Version: V1.0
 */
@ApiModel(value="certchild_dylylqxscbapz对象", description="certchild_dylylqxscbapz")
@Data
@TableName("certchild_dylylqxscbapz")
public class CertchildDylylqxscbapz implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.String id;
	/**zsid*/
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
	@Excel(name = "wtqx", width = 15)
    @ApiModelProperty(value = "wtqx")
    private java.lang.String wtqx;
	/**bz*/
	@Excel(name = "bz", width = 15)
    @ApiModelProperty(value = "bz")
    private java.lang.String bz;
	/**cpmc*/
	@Excel(name = "cpmc", width = 15)
    @ApiModelProperty(value = "cpmc")
    private java.lang.String cpmc;
	/**sync*/
	@Excel(name = "sync", width = 15)
    @ApiModelProperty(value = "sync")
    private java.lang.String sync;
	/**xzspid*/
	@Excel(name = "xzspid", width = 15)
    @ApiModelProperty(value = "xzspid")
    private java.lang.String xzspid;
	/**num*/
	@Excel(name = "num", width = 15)
    @ApiModelProperty(value = "num")
    private java.math.BigDecimal num;
	/**zt*/
	@Excel(name = "zt", width = 15)
    @ApiModelProperty(value = "zt")
    private java.math.BigDecimal zt;


}
