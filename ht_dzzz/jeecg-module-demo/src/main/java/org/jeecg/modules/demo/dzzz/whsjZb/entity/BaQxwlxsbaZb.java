package org.jeecg.modules.demo.dzzz.whsjZb.entity;

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
 * @Description: ba_qxwlxsba_zb
 * @Author: jeecg-boot
 * @Date:   2024-08-30
 * @Version: V1.0
 */
@Data
@TableName("ba_qxwlxsba_zb")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ba_qxwlxsba_zb对象", description="ba_qxwlxsba_zb")
public class BaQxwlxsbaZb implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private String id;
	/**zsid*/
	@Excel(name = "zsid", width = 15)
    @ApiModelProperty(value = "zsid")
    private String zsid;
	/**统一社会信用代码*/
	@Excel(name = "统一社会信用代码", width = 15)
    @ApiModelProperty(value = "统一社会信用代码")
    private String shxydm;
	/**第三方平台备案方平台名称*/
	@Excel(name = "第三方平台备案方平台名称", width = 15)
    @ApiModelProperty(value = "第三方平台备案方平台名称")
    private String dsfptbafptmc;
	/**凭证编号*/
	@Excel(name = "凭证编号", width = 15)
    @ApiModelProperty(value = "凭证编号")
    private String pzbh;
	/**备注*/
	@Excel(name = "备注", width = 15)
    @ApiModelProperty(value = "备注")
    private String bz;
	/**num*/
	@Excel(name = "num", width = 15)
    @ApiModelProperty(value = "num")
    private String num;
	/**xzspid*/
	@Excel(name = "xzspid", width = 15)
    @ApiModelProperty(value = "xzspid")
    private String xzspid;
}
