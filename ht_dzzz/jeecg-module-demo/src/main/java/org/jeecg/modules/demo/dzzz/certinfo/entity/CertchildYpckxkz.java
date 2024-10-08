package org.jeecg.modules.demo.dzzz.certinfo.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.UnsupportedEncodingException;

/**
 * @Description: 药品出口准许证
 * @Author: jeecg-boot
 * @Date:   2024-06-17
 * @Version: V1.0
 */
@ApiModel(value="certchild_ypckxkz对象", description="药品出口准许证")
@Data
@TableName("certchild_ypckxkz")
public class CertchildYpckxkz implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private String id;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private String createBy;
	/**创建日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期")
    private Date createTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private String updateBy;
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期")
    private Date updateTime;
	/**所属部门*/
    @ApiModelProperty(value = "所属部门")
    private String sysOrgCode;
	/**证书id*/
    @ApiModelProperty(value = "证书id")
    private String zsid;
	/**条数*/
	@Excel(name = "条数", width = 15)
    @ApiModelProperty(value = "条数")
    private String ts;
	/**出口药物名称*/
	@Excel(name = "出口药物名称", width = 15)
    @ApiModelProperty(value = "出口药物名称")
    private String ckywmc;
	/**出口药物名称英文*/
	@Excel(name = "出口药物名称英文", width = 15)
    @ApiModelProperty(value = "出口药物名称英文")
    private String ckywmcyw;
	/**商品编码*/
	@Excel(name = "商品编码", width = 15)
    @ApiModelProperty(value = "商品编码")
    private String spid;
	/**剂型*/
	@Excel(name = "剂型", width = 15)
    @ApiModelProperty(value = "剂型")
    private String jx;
	/**出口药物包装*/
	@Excel(name = "出口药物包装", width = 15)
    @ApiModelProperty(value = "出口药物包装")
    private String ckywbz;
	/**出口药物规格*/
	@Excel(name = "出口药物规格", width = 15)
    @ApiModelProperty(value = "出口药物规格")
    private String ckywgg;
	/**出口药物数量*/
	@Excel(name = "出口药物数量", width = 15)
    @ApiModelProperty(value = "出口药物数量")
    private String ckywsl;
	/**状态*/
	@Excel(name = "状态", width = 15)
    @ApiModelProperty(value = "状态")
    private String zt;
    private java.lang.String xzspid;

}
