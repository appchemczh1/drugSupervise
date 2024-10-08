package org.jeecg.modules.demo.dzzz.certinfo.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.UnsupportedEncodingException;

/**
 * @Description: 麻醉药品和精神药品定点生产批件
 * @Author: jeecg-boot
 * @Date:   2024-06-17
 * @Version: V1.0
 */
@ApiModel(value="certchild_mzyphjsypddsc对象", description="麻醉药品和精神药品定点生产批件")
@Data
@TableName("certchild_mzyphjsypddsc")
public class CertchildMzyphjsypddsc implements Serializable {
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
	/**药瓶名称*/
	@Excel(name = "药瓶名称", width = 15)
    @ApiModelProperty(value = "药瓶名称")
    private String ypmc;
	/**剂型*/
	@Excel(name = "剂型", width = 15)
    @ApiModelProperty(value = "剂型")
    private String jx;
	/**规格*/
	@Excel(name = "规格", width = 15)
    @ApiModelProperty(value = "规格")
    @TableField(value = "\"gg\"")
    private String gg;
	/**管制类别*/
	@Excel(name = "管制类别", width = 15)
    @ApiModelProperty(value = "管制类别")
    private String gzlb;
	/**批准文号*/
	@Excel(name = "批准文号", width = 15)
    @ApiModelProperty(value = "批准文号")
    private String pzwh;
	/**状态*/
	@Excel(name = "状态", width = 15)
    @ApiModelProperty(value = "状态")
    private String zt;
    private java.lang.String xzspid;

}
