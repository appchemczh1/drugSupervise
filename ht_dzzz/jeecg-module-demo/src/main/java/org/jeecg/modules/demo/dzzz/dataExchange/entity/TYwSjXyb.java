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
 * @Description: t_yw_sj_xyb
 * @Author: jeecg-boot
 * @Date:   2024-07-29
 * @Version: V1.0
 */
@Data
@TableName("t_yw_sj_xyb")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="t_yw_sj_xyb对象", description="t_yw_sj_xyb")
public class TYwSjXyb implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键ID*/
	@TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "主键ID")
    private java.lang.Integer id;

	/**业务类型：1-核发，2-换发/延续，3-变更，4-注销，5-补发，6-人工维护，7-强制维护*/
	@Excel(name = "业务类型：1-核发，2-换发/延续，3-变更，4-注销，5-补发，6-人工维护，7-强制维护", width = 15)
    @ApiModelProperty(value = "业务类型：1-核发，2-换发/延续，3-变更，4-注销，5-补发，6-人工维护，7-强制维护")
    private java.lang.String ywlx;

	/**证书编号*/
	@Excel(name = "证书编号", width = 15)
    @ApiModelProperty(value = "证书编号")
    private java.lang.String zsbh;

	/**证书类型*/
	@Excel(name = "证书类型", width = 15)
    @ApiModelProperty(value = "证书类型")
    private java.lang.String zslx;

	/**统一社会信用代码*/
	@Excel(name = "统一社会信用代码", width = 15)
    @ApiModelProperty(value = "统一社会信用代码")
    private java.lang.String shxydm;

	/**企业名称*/
	@Excel(name = "企业名称", width = 15)
    @ApiModelProperty(value = "企业名称")
    private java.lang.String qymc;

	/**办件编号*/
	@Excel(name = "办件编号", width = 15)
    @ApiModelProperty(value = "办件编号")
    private java.lang.String bjbh;

	/**办件事项编码*/
	@Excel(name = "办件事项编码", width = 15)
    @ApiModelProperty(value = "办件事项编码")
    private java.lang.String bjsxbm;

    /**行政相对人类别*/
    @Excel(name = "行政相对人类别", width = 15)
    @ApiModelProperty(value = "行政相对人类别", dataType = "String")
    private String xkxdrlb;

    /**行政相对人类别-工商统一社会信用代码*/
    @Excel(name = "行政相对人类别-工商统一社会信用代码", width = 15)
    @ApiModelProperty(value = "行政相对人-工商统一社会信用代码", dataType = "String")
    private String xkxdrgszc;

    /**行政相对人类别-组织机构代码*/
    @Excel(name = "行政相对人类别-组织机构代码", width = 15)
    @ApiModelProperty(value = "行政相对人-组织机构代码", dataType = "String")
    private String xkxdrzzjg;

    @ApiModelProperty(value = "行政相对人-税务登记号", dataType = "String")
    private String xkxdrswdj;

    @ApiModelProperty(value = "行政相对人-事业单位证书号", dataType = "String")
    private String xkxdrsydw;

    @ApiModelProperty(value = "行政相对人-社会组织登记证号", dataType = "String")
    private String xkxdrshzz;

    @ApiModelProperty(value = "法定代表人证件类型，证件类型有：身份证、 护照号、港澳居民来往内地通行证、台湾居民来往大陆通行证、外国人永久居留身份证、或以“其他-**”开头。选填", dataType = "String")
    private String xkfrzhlx;

    @ApiModelProperty(value = "法定代表人身份证号，选填（法人及非法人组织、 个体工商户）", dataType = "String")
    private String xkfrzhhm;

    @ApiModelProperty(value = "行政许可决定文书名称，填写行政许可决定文书标题，例如“国家发展改革委关于 XXX 公司发行企业债券核准的批复(发改财金〔2015〕XXX 号)”中的“国家发展改革委关于 XXX 公司发行企业债券核准的批复”。必填", dataType = "String")
    private String xkxkws;

    @ApiModelProperty(value = "行政许可决定文书号,填写行政许可决定文书编号，如无行政许可决定文书编号，填写该行政许可的“许可编号”。必填", dataType = "String")
    private String xkwsh;

    @ApiModelProperty(value = "许可类别填写普通、 特许、 认可、 核准、登记或其他， 如为“其他”， 需注明具体类别。法人和非法人组织的登记信息， 在登记过程中按相关部门有关规定执行。必填", dataType = "String")
    private String xkxklb;

    @ApiModelProperty(value = "许可证书名称,填写行政许可证书名称，例如“煤矿生产许可证”。", dataType = "String")
    private String xkxkzs;

    @ApiModelProperty(value = "许可内容,填写行政许可决定书的主要内容。", dataType = "String")
    private String xknr;

    @ApiModelProperty(value = "许可机关统一社会信用代码", dataType = "String")
    private String xkxkjgdm;

    @ApiModelProperty(value = "许可日期", dataType = "String")
    private String xkrq;

	/**法定代表人*/
	@Excel(name = "法定代表人", width = 15)
    @ApiModelProperty(value = "法定代表人")
    private java.lang.String xkFrdb;

	/**发证机关*/
	@Excel(name = "发证机关", width = 15)
    @ApiModelProperty(value = "发证机关")
    private java.lang.String xkXkjg;

	/**发证机关*/
	@Excel(name = "发证机关", width = 15)
    @ApiModelProperty(value = "发证机关")
    private java.lang.String xkLydw;

	/**发证日期*/
	@Excel(name = "发证日期", width = 15)
    @ApiModelProperty(value = "发证日期")
    private java.lang.String fzrq;

	/**有效期至*/
	@Excel(name = "有效期至", width = 15)
    @ApiModelProperty(value = "有效期至")
    private java.lang.String yxqz;

	/**企业名称*/
	@Excel(name = "企业名称", width = 15)
    @ApiModelProperty(value = "企业名称")
    private java.lang.String xkXdrMc;

	/**发证日期*/
	@Excel(name = "发证日期", width = 15)
    @ApiModelProperty(value = "发证日期")
    private java.lang.String xkYxqz;

	/**证书ID*/
	@Excel(name = "证书ID", width = 15)
    @ApiModelProperty(value = "证书ID")
    private java.lang.String zsid;

	/**业务ID*/
	@Excel(name = "业务ID", width = 15)
    @ApiModelProperty(value = "业务ID")
    private java.lang.String ywid;

	/**数据交换标识*/
	@Excel(name = "数据交换标识", width = 15)
    @ApiModelProperty(value = "数据交换标识")
    private java.lang.String sync;

    /**xkZt*/
    @Excel(name = "xkZt", width = 15)
    @ApiModelProperty(value = "xkZt")
    private java.lang.String xkZt;

    /**证书编号*/
    @Excel(name = "证书编号", width = 15)
    @ApiModelProperty(value = "证书编号")
    private java.lang.String dataUpStatus;

    /**创建时间*/
    @ApiModelProperty(value = "创建时间")
    private java.lang.String createTime;

    /**基本事项编码*/
    @ApiModelProperty(value = "基本事项编码")
    private java.lang.String sxbm;

}
