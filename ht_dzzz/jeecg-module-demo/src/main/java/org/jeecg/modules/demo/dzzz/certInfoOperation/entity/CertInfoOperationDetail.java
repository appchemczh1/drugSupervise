package org.jeecg.modules.demo.dzzz.certInfoOperation.entity;

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
 * @Description: 操作详情表
 * @Author: jeecg-boot
 * @Date:   2024-04-17
 * @Version: V1.0
 */
@Data
@TableName("cert_info_operation_detail")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="cert_info_operation_detail对象", description="操作详情表")
public class CertInfoOperationDetail implements Serializable {
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
	@Excel(name = "证书id", width = 15)
    @ApiModelProperty(value = "证书id")
    private String zsid;
	/**变更前,字段历史*/
	@Excel(name = "变更前,字段历史", width = 15)
    @ApiModelProperty(value = "变更前,字段历史")
    private String zdlszt;
	/**变更后，字段现*/
	@Excel(name = "变更后，字段现", width = 15)
    @ApiModelProperty(value = "变更后，字段现")
    private String zdxz;
	/**操作时间*/
	@Excel(name = "操作时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "操作时间")
    private Date czsj;
	/**状态（0新增1修改2删除）*/
	@Excel(name = "状态（0新增1修改2删除）", width = 15)
    @ApiModelProperty(value = "状态（0新增1修改2删除）")
    private String zt;
	/**备注*/
	@Excel(name = "备注", width = 15)
    @ApiModelProperty(value = "备注")
    private String bz;
	/**证书操作记录id*/
	@Excel(name = "证书操作记录id", width = 15)
    @ApiModelProperty(value = "证书操作记录id")
    private String zsczjl;
	/**操作表名*/
	@Excel(name = "操作表名", width = 15)
    @ApiModelProperty(value = "操作表名")
    private String czbm;
	/**记录版本*/
	@Excel(name = "记录版本", width = 15)
    @ApiModelProperty(value = "记录版本")
    private String jlbb;
	/**变更字段名称 -数据库名称*/
	@Excel(name = "变更字段名称 -数据库名称", width = 15)
    @ApiModelProperty(value = "变更字段名称 -数据库名称")
    private String bgzdmc;
	/**变更次数*/
	@Excel(name = "变更次数", width = 15)
    @ApiModelProperty(value = "变更次数")
    private String bgcs;
	/**变更字段描述名称*/
	@Excel(name = "变更字段描述名称", width = 15)
    @ApiModelProperty(value = "变更字段描述名称")
    private String bgzdms;
	/**数据标识0无效1有效*/
	@Excel(name = "数据标识0无效1有效", width = 15)
    @ApiModelProperty(value = "数据标识0无效1有效")
    private String dataFlg;
	/**操作表数据id*/
	@Excel(name = "操作表数据id", width = 15)
    @ApiModelProperty(value = "操作表数据id")
    private String czsjid;
    private String bgr;
    private String bgyy;
}
