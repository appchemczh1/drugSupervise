package org.jeecg.modules.demo.spxt.entity;

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
 * @Description: t_yw_zs_zsy
 * @Author: jeecg-boot
 * @Date:   2024-06-20
 * @Version: V1.0
 */
@Data
@TableName("t_yw_zs_zsy")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="t_yw_zs_zsy对象", description="t_yw_zs_zsy")
public class TYwZsZsy implements Serializable {
    private static final long serialVersionUID = 1L;

	/**证书源ID*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "证书源ID")
    private java.lang.String id;
	/**证书类型*/
	@Excel(name = "证书类型", width = 15)
    @ApiModelProperty(value = "证书类型")
    private java.lang.Integer zslx;
	/**lbs*/
	@Excel(name = "lbs", width = 15)
    @ApiModelProperty(value = "lbs")
    private java.lang.String lbs;
	/**lm*/
	@Excel(name = "lm", width = 15)
    @ApiModelProperty(value = "lm")
    private java.lang.String lm;
	/**zdlx*/
	@Excel(name = "zdlx", width = 15)
    @ApiModelProperty(value = "zdlx")
    private java.lang.String zdlx;
	/**zdcd*/
	@Excel(name = "zdcd", width = 15)
    @ApiModelProperty(value = "zdcd")
    private java.lang.Integer zdcd;
	/**sfwk*/
	@Excel(name = "sfwk", width = 15)
    @ApiModelProperty(value = "sfwk")
    private java.lang.Integer sfwk;
	/**mrz*/
	@Excel(name = "mrz", width = 15)
    @ApiModelProperty(value = "mrz")
    private java.lang.String mrz;
	/**yssx*/
	@Excel(name = "yssx", width = 15)
    @ApiModelProperty(value = "yssx")
    private java.lang.String yssx;
	/**状态为0有效，为1无效*/
	@Excel(name = "状态为0有效，为1无效", width = 15)
    @ApiModelProperty(value = "状态为0有效，为1无效")
    private java.lang.Integer zt;
	/**证书源版本ID*/
	@Excel(name = "证书源版本ID", width = 15)
    @ApiModelProperty(value = "证书源版本ID")
    private java.lang.String bbid;
	/**kjlx*/
	@Excel(name = "kjlx", width = 15)
    @ApiModelProperty(value = "kjlx")
    private java.lang.Integer kjlx;
	/**kjcd*/
	@Excel(name = "kjcd", width = 15)
    @ApiModelProperty(value = "kjcd")
    private java.lang.Integer kjcd;
	/**排序码*/
	@Excel(name = "排序码", width = 15)
    @ApiModelProperty(value = "排序码")
    private java.lang.Integer pxm;
	/**wbxzgn*/
	@Excel(name = "wbxzgn", width = 15)
    @ApiModelProperty(value = "wbxzgn")
    private java.lang.String wbxzgn;
	/**是否跨行，为0不跨行，为1跨行（一行最多含两个字段）*/
	@Excel(name = "是否跨行，为0不跨行，为1跨行（一行最多含两个字段）", width = 15)
    @ApiModelProperty(value = "是否跨行，为0不跨行，为1跨行（一行最多含两个字段）")
    private java.lang.Integer sfkh;
	/**是否删除（隐藏），为0显示，为1隐藏*/
	@Excel(name = "是否删除（隐藏），为0显示，为1隐藏", width = 15)
    @ApiModelProperty(value = "是否删除（隐藏），为0显示，为1隐藏")
    private java.lang.Integer sfsc;
	/**是否必填，0为非必填，1为必填*/
	@Excel(name = "是否必填，0为非必填，1为必填", width = 15)
    @ApiModelProperty(value = "是否必填，0为非必填，1为必填")
    private java.lang.String sfbt;
	/**synctime*/
	@Excel(name = "synctime", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "synctime")
    private java.util.Date synctime;
}
