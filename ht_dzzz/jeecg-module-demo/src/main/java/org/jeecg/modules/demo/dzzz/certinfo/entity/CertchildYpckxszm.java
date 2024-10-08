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
 * @Description: 药品出口销售证明
 * @Author: jeecg-boot
 * @Date:   2024-06-17
 * @Version: V1.0
 */
@ApiModel(value="certchild_ypckxszm对象", description="药品出口销售证明")
@Data
@TableName("certchild_ypckxszm")
public class CertchildYpckxszm implements Serializable {
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
	/**数量*/
	@Excel(name = "数量", width = 15)
    @ApiModelProperty(value = "数量")
    private String num;
	/**进口国家中文*/
	@Excel(name = "进口国家中文", width = 15)
    @ApiModelProperty(value = "进口国家中文")
    private String jkgjzw;
	/**进口国家英文*/
	@Excel(name = "进口国家英文", width = 15)
    @ApiModelProperty(value = "进口国家英文")
    private String jkgjyw;
	/**条数*/
	@Excel(name = "条数", width = 15)
    @ApiModelProperty(value = "条数")
    private String ts;
	/**类型*/
	@Excel(name = "类型", width = 15)
    @ApiModelProperty(value = "类型")
    private String lx;
	/**状态*/
	@Excel(name = "状态", width = 15)
    @ApiModelProperty(value = "状态")
    private String zt;
    private java.lang.String xzspid;

}
