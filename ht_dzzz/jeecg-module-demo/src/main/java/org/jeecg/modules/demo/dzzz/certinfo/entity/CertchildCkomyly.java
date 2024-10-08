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
 * @Description: 出口欧盟原料
 * @Author: jeecg-boot
 * @Date:   2024-06-17
 * @Version: V1.0
 */
@ApiModel(value="certchild_ckomyly对象", description="出口欧盟原料")
@Data
@TableName("certchild_ckomyly")
public class CertchildCkomyly implements Serializable {
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
	/**证书Id*/
    @ApiModelProperty(value = "证书Id")
    private String zsid;
	/**条数*/
	@Excel(name = "条数", width = 15)
    @ApiModelProperty(value = "条数")
    private String ts;
	/**药品通用名称中文*/
	@Excel(name = "药品通用名称中文", width = 15)
    @ApiModelProperty(value = "药品通用名称中文")
    private String yptymczw;
	/**药品通用名称英文*/
	@Excel(name = "药品通用名称英文", width = 15)
    @ApiModelProperty(value = "药品通用名称英文")
    private String yptymcyw;
	/**加工方法中文*/
	@Excel(name = "加工方法中文", width = 15)
    @ApiModelProperty(value = "加工方法中文")
    private String jgffzw;
	/**加工方法英文*/
	@Excel(name = "加工方法英文", width = 15)
    @ApiModelProperty(value = "加工方法英文")
    private String jjffyw;
	/**中国药品批准文号中文*/
	@Excel(name = "中国药品批准文号中文", width = 15)
    @ApiModelProperty(value = "中国药品批准文号中文")
    private String zgyppzwhzw;
	/**中国药品批准文号英文*/
	@Excel(name = "中国药品批准文号英文", width = 15)
    @ApiModelProperty(value = "中国药品批准文号英文")
    private String zgyypzwhyw;
	/**是否通过我过gmp认证*/
	@Excel(name = "是否通过我过gmp认证", width = 15)
    @ApiModelProperty(value = "是否通过我过gmp认证")
    private String sftgrz;
	/**状态0正常1删除*/
	@Excel(name = "状态0正常1删除", width = 15)
    @ApiModelProperty(value = "状态0正常1删除")
    private String zt;
    private java.lang.String xzspid;

}
