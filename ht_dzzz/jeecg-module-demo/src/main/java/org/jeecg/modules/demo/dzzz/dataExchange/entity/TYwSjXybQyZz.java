package org.jeecg.modules.demo.dzzz.dataExchange.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.jeecgframework.poi.excel.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 往信用办推送企业资质证书表
 * @Author: jeecg-boot
 * @Date:   2024-09-23
 * @Version: V1.0
 */
@Data
@TableName("t_yw_sj_xyb_qy_zz")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="t_yw_sj_xyb_qy_zz对象", description="往信用办推送企业资质证书表")
public class TYwSjXybQyZz implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "主键")
    private java.lang.Integer id;
	/**企业名称*/
	@Excel(name = "企业名称", width = 15)
    @ApiModelProperty(value = "企业名称")
    private java.lang.String qymc;
	/**统一社会信用代码*/
	@Excel(name = "统一社会信用代码", width = 15)
    @ApiModelProperty(value = "统一社会信用代码")
    private java.lang.String shxydm;
	/**资质证书名称*/
	@Excel(name = "资质证书名称", width = 15)
    @ApiModelProperty(value = "资质证书名称")
    private java.lang.String zsmc;
	/**资质证书编号*/
	@Excel(name = "资质证书编号", width = 15)
    @ApiModelProperty(value = "资质证书编号")
    private java.lang.String zsbh;
	/**资质或证书类别及等级*/
	@Excel(name = "资质或证书类别及等级", width = 15)
    @ApiModelProperty(value = "资质或证书类别及等级")
    private java.lang.String zslbdj;
	/**有效期至*/
	@Excel(name = "有效期至", width = 15)
    @ApiModelProperty(value = "有效期至")
    private java.lang.String yxqz;
	/**发证机构*/
	@Excel(name = "发证机构", width = 15)
    @ApiModelProperty(value = "发证机构")
    private java.lang.String fzjg;
	/**发证日期*/
	@Excel(name = "发证日期", width = 15)
    @ApiModelProperty(value = "发证日期")
    private java.lang.String fzrq;
	/**数据来源单位名*/
	@Excel(name = "数据来源单位名", width = 15)
    @ApiModelProperty(value = "数据来源单位名")
    private java.lang.String sjlydwmc;
	/**数据来源单位统一社会信用代码*/
	@Excel(name = "数据来源单位统一社会信用代码", width = 15)
    @ApiModelProperty(value = "数据来源单位统一社会信用代码")
    private java.lang.String sjlydwdm;
	/**创建时间*/
    @ApiModelProperty(value = "创建时间")
    private java.lang.String createTime;
	/**信用办ID*/
	@Excel(name = "信用办ID", width = 15)
    @ApiModelProperty(value = "信用办ID")
    private java.lang.Integer xybId;
	/**证书ID*/
	@Excel(name = "证书ID", width = 15)
    @ApiModelProperty(value = "证书ID")
    private java.lang.String zsid;
    /**数据交换标识*/
    @Excel(name = "数据交换标识", width = 15)
    @ApiModelProperty(value = "数据交换标识")
    private java.lang.String sync;

}
