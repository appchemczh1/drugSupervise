package org.jeecg.modules.demo.dzzz.certzdgz.entity;

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
 * @Description: 证书-自动盖章
 * @Author: jeecg-boot
 * @Date:   2024-04-03
 * @Version: V1.0
 */
@Data
@TableName("cert_zdgz")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="cert_zdgz对象", description="证书-自动盖章")
public class CertZdgz implements Serializable {
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
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期")
    private Date updateTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private String updateBy;
	/**数据来源*/
	@Excel(name = "数据来源", width = 15)
    @ApiModelProperty(value = "数据来源")
    private String v01;
	/**业务类型*/
	@Excel(name = "业务类型", width = 15)
    @Dict(dicCode = "changetype")
    @ApiModelProperty(value = "业务类型")
    private String ywlx;
	/**状态*/
	@Excel(name = "状态", width = 15)
    @Dict(dicCode = "usestatus")
    @ApiModelProperty(value = "状态")
    private String status;
	/**证书类型ID*/
	@Excel(name = "证书类型ID", width = 15)
    @ApiModelProperty(value = "证书类型ID")
    private String licenseTypeId;
	/**证书类型名称*/
	@Excel(name = "证书类型名称", width = 15)
    @ApiModelProperty(value = "证书类型名称")
    private String licenseTypeName;
}
