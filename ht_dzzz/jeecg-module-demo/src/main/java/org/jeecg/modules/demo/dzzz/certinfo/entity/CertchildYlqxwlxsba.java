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
 * @Description: certchild_ylqxwlxsba
 * @Author: jeecg-boot
 * @Date:   2024-07-09
 * @Version: V1.0
 */
@ApiModel(value="certchild_ylqxwlxsba对象", description="certchild_ylqxwlxsba")
@Data
@TableName("certchild_ylqxwlxsba")
public class CertchildYlqxwlxsba implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.String id;
	/**zsid*/
    @ApiModelProperty(value = "zsid")
    private java.lang.String zsid;
	/**shxydm*/
	@Excel(name = "shxydm", width = 15)
    @ApiModelProperty(value = "shxydm")
    private java.lang.String shxydm;
	/**dsfptbafptmc*/
	@Excel(name = "dsfptbafptmc", width = 15)
    @ApiModelProperty(value = "dsfptbafptmc")
    private java.lang.String dsfptbafptmc;
	/**pzbh*/
	@Excel(name = "pzbh", width = 15)
    @ApiModelProperty(value = "pzbh")
    private java.lang.String pzbh;
	/**bz*/
	@Excel(name = "bz", width = 15)
    @ApiModelProperty(value = "bz")
    private java.lang.String bz;
	/**sync*/
	@Excel(name = "sync", width = 15)
    @ApiModelProperty(value = "sync")
    private java.lang.String sync;
	/**xzspid*/
	@Excel(name = "xzspid", width = 15)
    @ApiModelProperty(value = "xzspid")
    private java.lang.String xzspid;
	/**num*/
	@Excel(name = "num", width = 15)
    @ApiModelProperty(value = "num")
    private java.lang.String num;

    /**状态（0：正常 1：删除 3：未盖章 4：已盖章）*/
    @Excel(name = "状态（0：正常 1：删除 3：未盖章 4：已盖章）", width = 15)
    @ApiModelProperty(value = "状态（0：正常 1：删除 3：未盖章 4：已盖章）")
    private java.lang.String zt;

}
