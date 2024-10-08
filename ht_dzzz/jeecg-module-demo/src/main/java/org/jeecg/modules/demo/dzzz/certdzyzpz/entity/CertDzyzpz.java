package org.jeecg.modules.demo.dzzz.certdzyzpz.entity;

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
 * @Description: 证书_电子印章配置
 * @Author: jeecg-boot
 * @Date:   2024-04-02
 * @Version: V1.0
 */
@Data
@TableName("cert_dzyzpz")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="cert_dzyzpz对象", description="证书_电子印章配置")
public class CertDzyzpz implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private String id;
	/**印章编号*/
	@Excel(name = "印章编号", width = 15)
    @ApiModelProperty(value = "印章编号")
    private String sealCode;
	/**印章名称*/
	@Excel(name = "印章名称", width = 15)
    @ApiModelProperty(value = "印章名称")
    private String sealName;
	/**印章大小长*/
	@Excel(name = "印章大小长", width = 15)
    @ApiModelProperty(value = "印章大小长")
    private Integer sealSizeLong;
	/**印章大小宽*/
	@Excel(name = "印章大小宽", width = 15)
    @ApiModelProperty(value = "印章大小宽")
    private Integer sealSizeWide;
	/**所属部门*/
	@Excel(name = "所属部门", width = 15)
    @ApiModelProperty(value = "所属部门")
    private String sealDeptName;
	/**对应发证机关*/
	@Excel(name = "对应发证机关", width = 15)
    @ApiModelProperty(value = "对应发证机关")
    private String var1;
	/**类型状态*/
	@Excel(name = "类型状态", width = 15)
    @ApiModelProperty(value = "类型状态")
    private String state;
	/**显示顺序*/
	@Excel(name = "显示顺序", width = 15)
    @ApiModelProperty(value = "显示顺序")
    private Integer orderNum;
	/**印章样式*/
	@Excel(name = "印章样式", width = 15)
    @ApiModelProperty(value = "印章样式")
    private String yzys;
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
}
