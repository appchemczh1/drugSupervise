package org.jeecg.modules.demo.dzzz.shiyan2.entity;

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
 * @Description: t_jc_zs_ypscxk_jbxx_ls
 * @Author: jeecg-boot
 * @Date:   2024-07-06
 * @Version: V1.0
 */
@Data
@TableName("t_jc_zs_ypscxk_jbxx_ls")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="t_jc_zs_ypscxk_jbxx_ls对象", description="t_jc_zs_ypscxk_jbxx_ls")
public class TJcZsYpscxkJbxxLs implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.String id;
	/**企业id*/
	@Excel(name = "企业id", width = 15)
    @ApiModelProperty(value = "企业id")
    private java.lang.String entid;
	/**企业名称*/
	@Excel(name = "企业名称", width = 15)
    @ApiModelProperty(value = "企业名称")
    private java.lang.String entname;
	/**注册地址*/
	@Excel(name = "注册地址", width = 15)
    @ApiModelProperty(value = "注册地址")
    private java.lang.String zcdz;
	/**社会信用代码*/
	@Excel(name = "社会信用代码", width = 15)
    @ApiModelProperty(value = "社会信用代码")
    private java.lang.String shxydm;
	/**邮编*/
	@Excel(name = "邮编", width = 15)
    @ApiModelProperty(value = "邮编")
    private java.lang.String yb;
	/**许可编号*/
	@Excel(name = "许可编号", width = 15)
    @ApiModelProperty(value = "许可编号")
    private java.lang.String xkzbh;
	/**企业类型*/
	@Excel(name = "企业类型", width = 15)
    @ApiModelProperty(value = "企业类型")
    private java.lang.String qylx;
	/**三资企业外方国别或地区名称*/
	@Excel(name = "三资企业外方国别或地区名称", width = 15)
    @ApiModelProperty(value = "三资企业外方国别或地区名称")
    private java.lang.String areaname;
	/**企业创建时间*/
	@Excel(name = "企业创建时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "企业创建时间")
    private java.util.Date founddate;
	/**是否隶属企业集团*/
	@Excel(name = "是否隶属企业集团", width = 15)
    @ApiModelProperty(value = "是否隶属企业集团")
    private java.lang.String isheadquarter;
	/**企业集团名称*/
	@Excel(name = "企业集团名称", width = 15)
    @ApiModelProperty(value = "企业集团名称")
    private java.lang.String headquartername;
	/**企业集团社会信用代码*/
	@Excel(name = "企业集团社会信用代码", width = 15)
    @ApiModelProperty(value = "企业集团社会信用代码")
    private java.lang.String headquarterorgcode;
	/**法定代表人*/
	@Excel(name = "法定代表人", width = 15)
    @ApiModelProperty(value = "法定代表人")
    private java.lang.String legalrepresentative;
	/**企业负责人*/
	@Excel(name = "企业负责人", width = 15)
    @ApiModelProperty(value = "企业负责人")
    private java.lang.String enterprisehead;
	/**质量负责人*/
	@Excel(name = "质量负责人", width = 15)
    @ApiModelProperty(value = "质量负责人")
    private java.lang.String qualityhead;
	/**生产负责人*/
	@Excel(name = "生产负责人", width = 15)
    @ApiModelProperty(value = "生产负责人")
    private java.lang.String productionhead;
	/**质量受权人*/
	@Excel(name = "质量受权人", width = 15)
    @ApiModelProperty(value = "质量受权人")
    private java.lang.String licensor;
	/**法定代表人职称*/
	@Excel(name = "法定代表人职称", width = 15)
    @ApiModelProperty(value = "法定代表人职称")
    private java.lang.String legaltitle;
	/**法定代表人所学专业*/
	@Excel(name = "法定代表人所学专业", width = 15)
    @ApiModelProperty(value = "法定代表人所学专业")
    private java.lang.String legalschoolmajor;
	/**法定代表人毕业院校*/
	@Excel(name = "法定代表人毕业院校", width = 15)
    @ApiModelProperty(value = "法定代表人毕业院校")
    private java.lang.String legalschool;
	/**法定代表人身份证号*/
	@Excel(name = "法定代表人身份证号", width = 15)
    @ApiModelProperty(value = "法定代表人身份证号")
    private java.lang.String legalidno;
	/**企业负责人职称*/
	@Excel(name = "企业负责人职称", width = 15)
    @ApiModelProperty(value = "企业负责人职称")
    private java.lang.String enterpristitle;
	/**企业负责人所学专业*/
	@Excel(name = "企业负责人所学专业", width = 15)
    @ApiModelProperty(value = "企业负责人所学专业")
    private java.lang.String enterprislschoolmajor;
	/**企业负责人毕业院校*/
	@Excel(name = "企业负责人毕业院校", width = 15)
    @ApiModelProperty(value = "企业负责人毕业院校")
    private java.lang.String enterpriseschool;
	/**企业负责人身份证号*/
	@Excel(name = "企业负责人身份证号", width = 15)
    @ApiModelProperty(value = "企业负责人身份证号")
    private java.lang.String enterpriseidno;
	/**质量负责人职称*/
	@Excel(name = "质量负责人职称", width = 15)
    @ApiModelProperty(value = "质量负责人职称")
    private java.lang.String qualitytitle;
	/**质量负责人所学专业*/
	@Excel(name = "质量负责人所学专业", width = 15)
    @ApiModelProperty(value = "质量负责人所学专业")
    private java.lang.String qualityschoolmajor;
	/**质量负责人毕业院校*/
	@Excel(name = "质量负责人毕业院校", width = 15)
    @ApiModelProperty(value = "质量负责人毕业院校")
    private java.lang.String qualityschool;
	/**质量负责人身份证号*/
	@Excel(name = "质量负责人身份证号", width = 15)
    @ApiModelProperty(value = "质量负责人身份证号")
    private java.lang.String qualityidno;
	/**生产负责人职称*/
	@Excel(name = "生产负责人职称", width = 15)
    @ApiModelProperty(value = "生产负责人职称")
    private java.lang.String productiontitle;
	/**生产负责人所学专业*/
	@Excel(name = "生产负责人所学专业", width = 15)
    @ApiModelProperty(value = "生产负责人所学专业")
    private java.lang.String productionschoolmajor;
	/**生产负责人毕业院校*/
	@Excel(name = "生产负责人毕业院校", width = 15)
    @ApiModelProperty(value = "生产负责人毕业院校")
    private java.lang.String productionschool;
	/**生产负责人身份证号*/
	@Excel(name = "生产负责人身份证号", width = 15)
    @ApiModelProperty(value = "生产负责人身份证号")
    private java.lang.String productionidno;
	/**质量受权人职称*/
	@Excel(name = "质量受权人职称", width = 15)
    @ApiModelProperty(value = "质量受权人职称")
    private java.lang.String licensortitle;
	/**质量受权人所学专业*/
	@Excel(name = "质量受权人所学专业", width = 15)
    @ApiModelProperty(value = "质量受权人所学专业")
    private java.lang.String licensorschoolmajor;
	/**质量受权人毕业院校*/
	@Excel(name = "质量受权人毕业院校", width = 15)
    @ApiModelProperty(value = "质量受权人毕业院校")
    private java.lang.String licensorschool;
	/**质量受权人身份证号*/
	@Excel(name = "质量受权人身份证号", width = 15)
    @ApiModelProperty(value = "质量受权人身份证号")
    private java.lang.String licensoridno;
	/**职工人数（人）*/
	@Excel(name = "职工人数（人）", width = 15)
    @ApiModelProperty(value = "职工人数（人）")
    private java.lang.Integer staffnumber;
	/**其中：技术人员（人）*/
	@Excel(name = "其中：技术人员（人）", width = 15)
    @ApiModelProperty(value = "其中：技术人员（人）")
    private java.lang.Integer technicalnumber;
	/**高级职称（人）*/
	@Excel(name = "高级职称（人）", width = 15)
    @ApiModelProperty(value = "高级职称（人）")
    private java.lang.Integer seniortitlenumber;
	/**初级职称（人）*/
	@Excel(name = "初级职称（人）", width = 15)
    @ApiModelProperty(value = "初级职称（人）")
    private java.lang.Integer juniortitlenumber;
	/**研究生学历（人）*/
	@Excel(name = "研究生学历（人）", width = 15)
    @ApiModelProperty(value = "研究生学历（人）")
    private java.lang.Integer graduatedegreenumber;
	/**本科专科学历（人）*/
	@Excel(name = "本科专科学历（人）", width = 15)
    @ApiModelProperty(value = "本科专科学历（人）")
    private java.lang.Integer bachelordegreenumber;
	/**固定资产原值（万元）*/
	@Excel(name = "固定资产原值（万元）", width = 15)
    @ApiModelProperty(value = "固定资产原值（万元）")
    private java.math.BigDecimal gdoriginalvalue;
	/**固定资产净值（万元）*/
	@Excel(name = "固定资产净值（万元）", width = 15)
    @ApiModelProperty(value = "固定资产净值（万元）")
    private java.math.BigDecimal gdoriginalnet;
	/**厂区占地面积（平米）*/
	@Excel(name = "厂区占地面积（平米）", width = 15)
    @ApiModelProperty(value = "厂区占地面积（平米）")
    private java.math.BigDecimal plantarea;
	/**建筑面积（平米）*/
	@Excel(name = "建筑面积（平米）", width = 15)
    @ApiModelProperty(value = "建筑面积（平米）")
    private java.math.BigDecimal builtuparea;
	/**上年度产值（万元）*/
	@Excel(name = "上年度产值（万元）", width = 15)
    @ApiModelProperty(value = "上年度产值（万元）")
    private java.math.BigDecimal annualoutputvalue;
	/**上年度利润（万元）*/
	@Excel(name = "上年度利润（万元）", width = 15)
    @ApiModelProperty(value = "上年度利润（万元）")
    private java.math.BigDecimal lastyearsprofit;
	/**原料药注册品种数*/
	@Excel(name = "原料药注册品种数", width = 15)
    @ApiModelProperty(value = "原料药注册品种数")
    private java.lang.Integer crudedrugregnumber;
	/**制剂注册品种数*/
	@Excel(name = "制剂注册品种数", width = 15)
    @ApiModelProperty(value = "制剂注册品种数")
    private java.lang.Integer preparationregnumber;
	/**其他类注册产品数*/
	@Excel(name = "其他类注册产品数", width = 15)
    @ApiModelProperty(value = "其他类注册产品数")
    private java.lang.Integer otherregnumber;
	/**常年生产品种数*/
	@Excel(name = "常年生产品种数", width = 15)
    @ApiModelProperty(value = "常年生产品种数")
    private java.lang.Integer annualproductionnumber;
	/**联系人*/
	@Excel(name = "联系人", width = 15)
    @ApiModelProperty(value = "联系人")
    private java.lang.String contacter;
	/**传真*/
	@Excel(name = "传真", width = 15)
    @ApiModelProperty(value = "传真")
    private java.lang.String faxphone;
	/**固定电话*/
	@Excel(name = "固定电话", width = 15)
    @ApiModelProperty(value = "固定电话")
    private java.lang.String telephone;
	/**手机*/
	@Excel(name = "手机", width = 15)
    @ApiModelProperty(value = "手机")
    private java.lang.String mobilephone;
	/**E-mail*/
	@Excel(name = "E-mail", width = 15)
    @ApiModelProperty(value = "E-mail")
    private java.lang.String email;
	/**分类码*/
	@Excel(name = "分类码", width = 15)
    @ApiModelProperty(value = "分类码")
    private java.lang.String typecode;
	/**是否无菌生产*/
	@Excel(name = "是否无菌生产", width = 15)
    @ApiModelProperty(value = "是否无菌生产")
    private java.lang.String isasepsis;
	/**备注*/
	@Excel(name = "备注", width = 15)
    @ApiModelProperty(value = "备注")
    private java.lang.String remark;
	/**证书id*/
	@Excel(name = "证书id", width = 15)
    @ApiModelProperty(value = "证书id")
    private java.lang.String zsid;
	/**行政审批id*/
	@Excel(name = "行政审批id", width = 15)
    @ApiModelProperty(value = "行政审批id")
    private java.lang.String xzspid;
	/**createdate*/
	@Excel(name = "createdate", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "createdate")
    private java.util.Date createdate;
	/**instanceno*/
	@Excel(name = "instanceno", width = 15)
    @ApiModelProperty(value = "instanceno")
    private java.lang.String instanceno;
}
