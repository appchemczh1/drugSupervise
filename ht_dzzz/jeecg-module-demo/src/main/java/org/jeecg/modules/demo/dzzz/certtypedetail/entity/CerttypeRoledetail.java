package org.jeecg.modules.demo.dzzz.certtypedetail.entity;

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
 * @Description: 证照类型权限详细描述
 * @Author: jeecg-boot
 * @Date:   2024-04-26
 * @Version: V1.0
 */
@Data
@TableName("certtype_roledetail")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="certtype_roledetail对象", description="证照类型权限详细描述")
public class CerttypeRoledetail implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private java.lang.String id;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
	/**创建日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期")
    private java.util.Date createTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private java.lang.String updateBy;
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期")
    private java.util.Date updateTime;
	/**所属部门*/
    @ApiModelProperty(value = "所属部门")
    private java.lang.String sysOrgCode;
	/**变更*/
	@Excel(name = "变更", width = 15)
    @ApiModelProperty(value = "变更")
    private java.lang.String bg;
	/**换证*/
	@Excel(name = "换证", width = 15)
    @ApiModelProperty(value = "换证")
    private java.lang.String hz;
	/**证书纠错*/
	@Excel(name = "证书纠错", width = 15)
    @ApiModelProperty(value = "证书纠错")
    private java.lang.String zsjc;
	/**数据维护*/
	@Excel(name = "数据维护", width = 15)
    @ApiModelProperty(value = "数据维护")
    private java.lang.String sjwh;
	/**证照类型id*/
	@Excel(name = "证照类型id", width = 15)
    @ApiModelProperty(value = "证照类型id")
    private java.lang.String certtypeid;
	/**角色id*/
	@Excel(name = "角色id", width = 15)
	@ApiModelProperty(value = "角色id")
	private String roleId;

}
