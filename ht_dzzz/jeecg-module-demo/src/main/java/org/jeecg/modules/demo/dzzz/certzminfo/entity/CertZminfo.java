package org.jeecg.modules.demo.dzzz.certzminfo.entity;

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
 * @Description: cert_zminfo
 * @Author: jeecg-boot
 * @Date:   2024-06-13
 * @Version: V1.0
 */
@Data
@TableName("cert_zminfo")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="cert_zminfo对象", description="cert_zminfo")
public class CertZminfo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**表id*/
	@TableId(type = IdType.ASSIGN_ID)
	@ApiModelProperty(value = "表id")
	private java.lang.String id;
	/**经营方式/服务性质
	 */
	@Excel(name = "经营方式服务性质 ", width = 15)
	@ApiModelProperty(value = "经营方式/服务性质 ")
	private java.lang.String jyfs;
	/**注册地址/申请地址/调出方地址/制剂配制地址/调入方地址/申请人注册地址/申请人制剂配制地址/委托配制制剂配制地址/受托方制剂配制地址/委托方单位地址/工厂地址中文/药品生产企业或者药品上市许可持有人地址中文/住所/委托方住所/备案人住所/注册人住所/生产企业住所/申办者地址
	 */
	@Excel(name = "注册地址/申请地址/调出方地址/制剂配制地址/调入方地址/申请人注册地址/申请人制剂配制地址/委托配制制剂配制地址/受托方制剂配制地址/委托方单位地址/工厂地址中文/药品生产企业或者药品上市许可持有人地址中文/住所/委托方住所/备案人住所/注册人住所/生产企业住所/申办者地址 ", width = 15)
	@ApiModelProperty(value = "注册地址/申请地址/调出方地址/制剂配制地址/调入方地址/申请人注册地址/申请人制剂配制地址/委托配制制剂配制地址/受托方制剂配制地址/委托方单位地址/工厂地址中文/药品生产企业或者药品上市许可持有人地址中文/住所/委托方住所/备案人住所/注册人住所/生产企业住所/申办者地址 ")
	private java.lang.String zcdz;
	/**日常监督管理机构
	 */
	@Excel(name = "日常监督管理机构", width = 15)
	@ApiModelProperty(value = "日常监督管理机构")
	private java.lang.String rcjdgljg;
	/**法定代表人/关键人员类型/委托方法定代表人
	 */
	@Excel(name = "法定代表人/关键人员类型/委托方法定代表人", width = 15)
	@ApiModelProperty(value = "法定代表人/关键人员类型/委托方法定代表人")
	private java.lang.String fddbr;
	/**投诉举报电话
	 */
	@Excel(name = "投诉举报电话", width = 15)
	@ApiModelProperty(value = "投诉举报电话")
	private java.lang.String tsjbdh;
	/**企业负责人/原负责人/委托方企业负责人
	 */
	@Excel(name = "企业负责人/原负责人/委托方企业负责人", width = 15)
	@ApiModelProperty(value = "企业负责人/原负责人/委托方企业负责人")
	private java.lang.String qyfzr;
	/**质量负责人/变更后负责人/医疗器械质量安全管理人
	 */
	@Excel(name = "质量负责人/变更后负责人/医疗器械质量安全管理人", width = 15)
	@ApiModelProperty(value = "质量负责人/变更后负责人/医疗器械质量安全管理人")
	private java.lang.String zlfzr;
	/**发证机关/备案部门/审批部门
	 */
	@Excel(name = "发证机关/备案部门/审批部门", width = 15)
	@ApiModelProperty(value = "发证机关/备案部门/审批部门")
	private java.lang.String fzjg;
	/**生产地址和生产范围/配置地址和配置范围/生产地址/生产范围/委托方生产地址
	 */
	@Excel(name = "生产地址和生产范围/配置地址和配置范围/生产地址/生产范围/委托方生产地址", width = 15)
	@ApiModelProperty(value = "生产地址和生产范围/配置地址和配置范围/生产地址/生产范围/委托方生产地址")
	private java.lang.String scdzscfw;
	/**签发人/签字
	 */
	@Excel(name = "签发人/签字", width = 15)
	@ApiModelProperty(value = "签发人/签字")
	private java.lang.String qfr;
	/**发证日期/签章与日期/备案日期/批准日期/生效日期
	 */
	@Excel(name = "发证日期/签章与日期/备案日期/批准日期/生效日期", width = 15)
	@ApiModelProperty(value = "发证日期/签章与日期/备案日期/批准日期/生效日期")
	private java.lang.String fzrq;
	/**有效期至/失效日期/有效期限/批准文号有效期/批准文号有效期至/本证明文件的有效期/批准时间中文/证明的有效期至中文
	 */
	@Excel(name = "有效期至/失效日期/有效期限/批准文号有效期/批准文号有效期至/本证明文件的有效期/批准时间中文/证明的有效期至中文", width = 15)
	@ApiModelProperty(value = "有效期至/失效日期/有效期限/批准文号有效期/批准文号有效期至/本证明文件的有效期/批准时间中文/证明的有效期至中文")
	private java.lang.String yxqz;
	/**质量授权人
	 */
	@Excel(name = "质量授权人", width = 15)
	@ApiModelProperty(value = "质量授权人")
	private java.lang.String zlsqr;
	/**生产负责人
	 */
	@Excel(name = "生产负责人", width = 15)
	@ApiModelProperty(value = "生产负责人")
	private java.lang.String scfzr;
	/**主要负责人/制剂室负责人/网站负责人
	 */
	@Excel(name = "主要负责人/制剂室负责人/网站负责人", width = 15)
	@ApiModelProperty(value = "主要负责人/制剂室负责人/网站负责人")
	private java.lang.String zyfzr;
	/**经营范围/使用范围/网站域名/范围/检查范围/品种/适用范围/生产范围/适用范围或者预期用途
	 */
	@Excel(name = "经营范围/使用范围/网站域名/范围/检查范围/品种/适用范围/生产范围/适用范围或者预期用途", width = 15)
	@ApiModelProperty(value = "经营范围/使用范围/网站域名/范围/检查范围/品种/适用范围/生产范围/适用范围或者预期用途")
	private java.lang.String jyfw;
	/**仓库地址/网站ip地址/检查场地地址/库房地址
	 */
	@Excel(name = "仓库地址/网站ip地址/检查场地地址/库房地址", width = 15)
	@ApiModelProperty(value = "仓库地址/网站ip地址/检查场地地址/库房地址")
	private java.lang.String ckdz;
	/**科室地址/生产企业所在辖区/经营场所/经营场所或生产场所/办公场所
	 */
	@Excel(name = "科室地址/生产企业所在辖区/经营场所/经营场所或生产场所/办公场所", width = 15)
	@ApiModelProperty(value = "科室地址/生产企业所在辖区/经营场所/经营场所或生产场所/办公场所")
	private java.lang.String ksdz;
	/**许可证类别
	 */
	@Excel(name = "许可证类别", width = 15)
	@ApiModelProperty(value = "许可证类别")
	private java.lang.String xkzlb;
	/**科室名称
	 */
	@Excel(name = "科室名称", width = 15)
	@ApiModelProperty(value = "科室名称")
	private java.lang.String ksmc;
	/**医疗机构类别
	 */
	@Excel(name = "医疗机构类别", width = 15)
	@ApiModelProperty(value = "医疗机构类别")
	private java.lang.String yljglb;
	/**科室负责人
	 */
	@Excel(name = "科室负责人", width = 15)
	@ApiModelProperty(value = "科室负责人")
	private java.lang.String ksfzr;
	/**进口单位
	 */
	@Excel(name = "进口单位", width = 15)
	@ApiModelProperty(value = "进口单位")
	private java.lang.String jkdw;
	/**进口单位英文名称
	 */
	@Excel(name = "进口单位英文名称", width = 15)
	@ApiModelProperty(value = "进口单位英文名称")
	private java.lang.String jkdwyw;
	/**进口单位地址
	 */
	@Excel(name = "进口单位地址", width = 15)
	@ApiModelProperty(value = "进口单位地址")
	private java.lang.String jkdwdz;
	/**进口单位英文地址
	 */
	@Excel(name = "进口单位英文地址", width = 15)
	@ApiModelProperty(value = "进口单位英文地址")
	private java.lang.String jkdwdzyw;
	/**出口单位
	 */
	@Excel(name = "出口单位", width = 15)
	@ApiModelProperty(value = "出口单位")
	private java.lang.String ckdw;
	/**出口单位英文名称
	 */
	@Excel(name = "出口单位英文名称", width = 15)
	@ApiModelProperty(value = "出口单位英文名称")
	private java.lang.String ckdwyw;
	/**出口单位地址
	 */
	@Excel(name = "出口单位地址", width = 15)
	@ApiModelProperty(value = "出口单位地址")
	private java.lang.String ckdwdz;
	/**出口单位英文地址
	 */
	@Excel(name = "出口单位英文地址", width = 15)
	@ApiModelProperty(value = "出口单位英文地址")
	private java.lang.String ckdwdzyw;
	/**进口药物名称
	 */
	@Excel(name = "进口药物名称", width = 15)
	@ApiModelProperty(value = "进口药物名称")
	private java.lang.String jkywmc;
	/**进口药物英文名称
	 */
	@Excel(name = "进口药物英文名称", width = 15)
	@ApiModelProperty(value = "进口药物英文名称")
	private java.lang.String jkywmcyw;
	/**商品编码
	 */
	@Excel(name = "商品编码", width = 15)
	@ApiModelProperty(value = "商品编码")
	private java.lang.String spbm;
	/**剂型中文/剂型
	 */
	@Excel(name = "剂型中文/剂型", width = 15)
	@ApiModelProperty(value = "剂型中文/剂型")
	private java.lang.String jxzw;
	/**剂型英文
	 */
	@Excel(name = "剂型英文", width = 15)
	@ApiModelProperty(value = "剂型英文")
	private java.lang.String jxyw;
	/**包装与规格中文/规格/包装规格/型号、规格/规格型号/试验用医疗器械型号规格
	 */
	@Excel(name = "包装与规格中文/规格/包装规格/型号、规格/规格型号/试验用医疗器械型号规格", width = 15)
	@ApiModelProperty(value = "包装与规格中文/规格/包装规格/型号、规格/规格型号/试验用医疗器械型号规格")
	private java.lang.String bzgg;
	/**包装与规格英文/规格英文
	 */
	@Excel(name = "包装与规格英文/规格英文", width = 15)
	@ApiModelProperty(value = "包装与规格英文/规格英文")
	private java.lang.String bzggyw;
	/**进口药物数量
	 */
	@Excel(name = "进口药物数量", width = 15)
	@ApiModelProperty(value = "进口药物数量")
	private java.lang.String jkywsl;
	/**进口药物数量英文
	 */
	@Excel(name = "进口药物数量英文", width = 15)
	@ApiModelProperty(value = "进口药物数量英文")
	private java.lang.String jkywslyw;
	/**管制药物含量
	 */
	@Excel(name = "管制药物含量", width = 15)
	@ApiModelProperty(value = "管制药物含量")
	private java.lang.String gzywhl;
	/**生产企业/药品实际生产者中文
	 */
	@Excel(name = "生产企业/药品实际生产者中文", width = 15)
	@ApiModelProperty(value = "生产企业/药品实际生产者中文")
	private java.lang.String scqy;
	/**生产企业英文/药品实际生产者英文
	 */
	@Excel(name = "生产企业英文/药品实际生产者英文", width = 15)
	@ApiModelProperty(value = "生产企业英文/药品实际生产者英文")
	private java.lang.String scqyyw;
	/**进口口岸
	 */
	@Excel(name = "进口口岸", width = 15)
	@ApiModelProperty(value = "进口口岸")
	private java.lang.String jkka;
	/**进口口岸英文
	 */
	@Excel(name = "进口口岸英文", width = 15)
	@ApiModelProperty(value = "进口口岸英文")
	private java.lang.String jkkayw;
	/**出口口岸
	 */
	@Excel(name = "出口口岸", width = 15)
	@ApiModelProperty(value = "出口口岸")
	private java.lang.String ckka;
	/**出口口岸英文
	 */
	@Excel(name = "出口口岸英文", width = 15)
	@ApiModelProperty(value = "出口口岸英文")
	private java.lang.String ckkayw;
	/**于下列日期前进口/于下列日期前出口/有效期起
	 */
	@Excel(name = "于下列日期前进口/于下列日期前出口/有效期起", width = 15)
	@ApiModelProperty(value = "于下列日期前进口/于下列日期前出口/有效期起")
	private java.lang.String yxqq;
	/**发证机关英文/证明当局英文
	 */
	@Excel(name = "发证机关英文/证明当局英文", width = 15)
	@ApiModelProperty(value = "发证机关英文/证明当局英文")
	private java.lang.String fzjgyw;
	/**出口药物名称/准予运输药品名称/药品名称/申请定点生产药品名称/药品通用名称/药品名称英文名拉丁名
	 */
	@Excel(name = "出口药物名称/准予运输药品名称/药品名称/申请定点生产药品名称/药品通用名称/药品名称英文名拉丁名", width = 15)
	@ApiModelProperty(value = "出口药物名称/准予运输药品名称/药品名称/申请定点生产药品名称/药品通用名称/药品名称英文名拉丁名")
	private java.lang.String ckywmc;
	/**出口药物数量
	 */
	@Excel(name = "出口药物数量", width = 15)
	@ApiModelProperty(value = "出口药物数量")
	private java.lang.String ckywsl;
	/**出口药物数量英文
	 */
	@Excel(name = "出口药物数量英文", width = 15)
	@ApiModelProperty(value = "出口药物数量英文")
	private java.lang.String ckywslyw;
	/**发货单位联系电话/联系电话/委托方联系电话/委托方住所电话
	 */
	@Excel(name = "发货单位联系电话/联系电话/委托方联系电话/委托方住所电话 ", width = 15)
			@ApiModelProperty(value = "发货单位联系电话/联系电话/委托方联系电话/委托方住所电话 ")
					private java.lang.String fhdwlxdh;
					/**运输证明有效期开始日期/有效证明有效期限自
					*/
					@Excel(name = "运输证明有效期开始日期/有效证明有效期限自", width = 15)
					@ApiModelProperty(value = "运输证明有效期开始日期/有效证明有效期限自")
					private java.lang.String yszmyxqq;
					/**运输证明有效期截止日期/邮寄证明有效期限至
					*/
					@Excel(name = "运输证明有效期截止日期/邮寄证明有效期限至", width = 15)
					@ApiModelProperty(value = "运输证明有效期截止日期/邮寄证明有效期限至")
					private java.lang.String yszmyxqz;
					/**发证机关联系电话/电话
					*/
					@Excel(name = "发证机关联系电话/电话", width = 15)
					@ApiModelProperty(value = "发证机关联系电话/电话")
					private java.lang.String fzjgdh;
					/**邮编/地址和邮编/委托方住所邮编
					*/
					@Excel(name = "邮编/地址和邮编/委托方住所邮编", width = 15)
					@ApiModelProperty(value = "邮编/地址和邮编/委托方住所邮编")
					private java.lang.String yb;
					/**管制类别/类别/制剂类别/药品分类
					*/
					@Excel(name = "管制类别/类别/制剂类别/药品分类", width = 15)
					@ApiModelProperty(value = "管制类别/类别/制剂类别/药品分类")
					private java.lang.String gzlb;
					/**专业、学历/技术职称/是否执业药师/从业年限
					*/
					@Excel(name = "专业、学历/技术职称/是否执业药师/从业年限", width = 15)
					@ApiModelProperty(value = "专业、学历/技术职称/是否执业药师/从业年限")
					private java.lang.String zyxl;
					/**审批结论/备案结论/备案意见/检查结论
					*/
					@Excel(name = "审批结论/备案结论/备案意见/检查结论", width = 15)
					@ApiModelProperty(value = "审批结论/备案结论/备案意见/检查结论")
					private java.lang.String spjl;
					/**主送单位/主送
					*/
					@Excel(name = "主送单位/主送", width = 15)
					@ApiModelProperty(value = "主送单位/主送")
					private java.lang.String zsdw;
					/**抄送单位/抄送
					*/
					@Excel(name = "抄送单位/抄送", width = 15)
					@ApiModelProperty(value = "抄送单位/抄送")
					private java.lang.String csdw;
					/**说明
					*/
					@Excel(name = "说明", width = 15)
					@ApiModelProperty(value = "说明")
					private java.lang.String sm;
					/**备注
					*/
					@Excel(name = "备注", width = 15)
					@ApiModelProperty(value = "备注")
					private java.lang.String bz;
					/**受理号/互联网药品信息服务资格证书编号/非经营性互联网信息服务备案编号
					*/
					@Excel(name = "受理号/互联网药品信息服务资格证书编号/非经营性互联网信息服务备案编号", width = 15)
					@ApiModelProperty(value = "受理号/互联网药品信息服务资格证书编号/非经营性互联网信息服务备案编号")
					private java.lang.String slh;
					/**产品名称/制剂名称/制剂名称通用名称/网络客户端应用程序名/网站域名/产品名称中文/试验用医疗器械产品/准予运输药品名称
					*/
					@Excel(name = "产品名称/制剂名称/制剂名称通用名称/网络客户端应用程序名/网站域名/产品名称中文/试验用医疗器械产品/准予运输药品名称", width = 15)
					@ApiModelProperty(value = "产品名称/制剂名称/制剂名称通用名称/网络客户端应用程序名/网站域名/产品名称中文/试验用医疗器械产品/准予运输药品名称")
					private java.lang.String cpmc;
					/**产品注册证明文件或备案凭证编号/《医疗机构制剂许可证》编号/《医疗机构制剂许可证》编号或《药品生产许可证》编号/《医疗机构制剂许可证》（或《药品生产质量管理规范》认证证书）编号/医疗器械生产(经营)许可证或备案凭证编号/生产许可或备案凭证号
					*/
					@Excel(name = "产品注册证明文件或备案凭证编号/《医疗机构制剂许可证》编号/《医疗机构制剂许可证》编号或《药品生产许可证》编号/《医疗机构制剂许可证》（或《药品生产质量管理规范》认证证书）编号/医疗器械生产(经营)许可证或备案凭证编号/生产许可或备案凭证号", width = 15)
					@ApiModelProperty(value = "产品注册证明文件或备案凭证编号/《医疗机构制剂许可证》编号/《医疗机构制剂许可证》编号或《药品生产许可证》编号/《医疗机构制剂许可证》（或《药品生产质量管理规范》认证证书）编号/医疗器械生产(经营)许可证或备案凭证编号/生产许可或备案凭证号")
					private java.lang.String cpzcbapzbh;
					/**上一级行政机关
					*/
					@Excel(name = "上一级行政机关", width = 15)
					@ApiModelProperty(value = "上一级行政机关")
					private java.lang.String syjxzzjg;
					/**人民政府
					*/
					@Excel(name = "人民政府", width = 15)
					@ApiModelProperty(value = "人民政府")
					private java.lang.String rmzf;
					/**上传附件/附件
					*/
					@Excel(name = "上传附件/附件", width = 15)
					@ApiModelProperty(value = "上传附件/附件")
					private java.lang.String scfj;
					/**有效期/使用期限/检查时间/产品储存条件及有效期/试验方案版本号及日期
					*/
					@Excel(name = "有效期/使用期限/检查时间/产品储存条件及有效期/试验方案版本号及日期", width = 15)
					@ApiModelProperty(value = "有效期/使用期限/检查时间/产品储存条件及有效期/试验方案版本号及日期")
					private java.lang.String yxq;
					/**质量标准/药品标准
					*/
					@Excel(name = "质量标准/药品标准", width = 15)
					@ApiModelProperty(value = "质量标准/药品标准")
					private java.lang.String zlbz;
					/**产品批号/电信业务经营许可证编号/非经营性互联网信息服务备案编号/产品注册或备案凭证号
					*/
					@Excel(name = "产品批号/电信业务经营许可证编号/非经营性互联网信息服务备案编号/产品注册或备案凭证号", width = 15)
					@ApiModelProperty(value = "产品批号/电信业务经营许可证编号/非经营性互联网信息服务备案编号/产品注册或备案凭证号")
					private java.lang.String cpph;
					/**调剂数量
					*/
					@Excel(name = "调剂数量", width = 15)
					@ApiModelProperty(value = "调剂数量")
					private java.lang.String tjsl;
					/**制剂名称汉语拼音/汉语拼音
					*/
					@Excel(name = "制剂名称汉语拼音/汉语拼音", width = 15)
					@ApiModelProperty(value = "制剂名称汉语拼音/汉语拼音")
					private java.lang.String zjmchypy;
					/**抄报单位
					*/
					@Excel(name = "抄报单位", width = 15)
					@ApiModelProperty(value = "抄报单位")
					private java.lang.String cbdw;
					/**变更内容/申请内容/申请理由/备案事项/变更前情况/变更原因/变更后情况/其他内容
					*/
					@Excel(name = "变更内容/申请内容/申请理由/备案事项/变更前情况/变更原因/变更后情况/其他内容", width = 15)
					@ApiModelProperty(value = "变更内容/申请内容/申请理由/备案事项/变更前情况/变更原因/变更后情况/其他内容")
					private java.lang.String bgnr;
					/**企业名称英文/药品生产企业或者药品上市许可持有人英文
					*/
					@Excel(name = "企业名称英文/药品生产企业或者药品上市许可持有人英文", width = 15)
					@ApiModelProperty(value = "企业名称英文/药品生产企业或者药品上市许可持有人英文")
					private java.lang.String qymcyw;
					/**企业地址英文/药品生产企业或者药品上市许可持有人地址英文
					*/
					@Excel(name = "企业地址英文/药品生产企业或者药品上市许可持有人地址英文", width = 15)
					@ApiModelProperty(value = "企业地址英文/药品生产企业或者药品上市许可持有人地址英文")
					private java.lang.String qydzyw;
					/**对该生产工厂检查的日期中文
					*/
					@Excel(name = "对该生产工厂检查的日期中文", width = 15)
					@ApiModelProperty(value = "对该生产工厂检查的日期中文")
					private java.lang.String jcrqzw;
					/**对该生产工厂检查的日期英文
					*/
					@Excel(name = "对该生产工厂检查的日期英文", width = 15)
					@ApiModelProperty(value = "对该生产工厂检查的日期英文")
					private java.lang.String jcrqyw;
					/**本证明文件的有效期英文/批准时间英文/证明的有效期至英文
					*/
					@Excel(name = "本证明文件的有效期英文/批准时间英文/证明的有效期至英文", width = 15)
					@ApiModelProperty(value = "本证明文件的有效期英文/批准时间英文/证明的有效期至英文")
					private java.lang.String zmwjyxqyw;
					/**签发部门地址中文/证明当局地址中文
					*/
					@Excel(name = "签发部门地址中文/证明当局地址中文", width = 15)
					@ApiModelProperty(value = "签发部门地址中文/证明当局地址中文")
					private java.lang.String fzjgdzzw;
					/**签发部门地址英文/证明当局地址英文
					*/
					@Excel(name = "签发部门地址英文/证明当局地址英文", width = 15)
					@ApiModelProperty(value = "签发部门地址英文/证明当局地址英文")
					private java.lang.String fzjgdzyw;
					/**负责人姓名及职务中文
					*/
					@Excel(name = "负责人姓名及职务中文", width = 15)
					@ApiModelProperty(value = "负责人姓名及职务中文")
					private java.lang.String fzrxmzwzw;
					/**负责人姓名及职务英文
					*/
					@Excel(name = "负责人姓名及职务英文", width = 15)
					@ApiModelProperty(value = "负责人姓名及职务英文")
					private java.lang.String fzrxmzwyw;
					/**电子邮箱/联系人电子邮箱
					*/
					@Excel(name = "电子邮箱/联系人电子邮箱", width = 15)
					@ApiModelProperty(value = "电子邮箱/联系人电子邮箱")
					private java.lang.String dzyx;
					/**传真/联系人传真
					*/
					@Excel(name = "传真/联系人传真", width = 15)
					@ApiModelProperty(value = "传真/联系人传真")
					private java.lang.String lxrcz;
					/**证书编号英文/产品批准文号英文
					*/
					@Excel(name = "证书编号英文/产品批准文号英文", width = 15)
					@ApiModelProperty(value = "证书编号英文/产品批准文号英文")
					private java.lang.String zsbhyw;
					/**产品名称英文
					*/
					@Excel(name = "产品名称英文", width = 15)
					@ApiModelProperty(value = "产品名称英文")
					private java.lang.String cpmcyw;
					/**商品名中文
					*/
					@Excel(name = "商品名中文", width = 15)
					@ApiModelProperty(value = "商品名中文")
					private java.lang.String spmzw;
					/**商品名英文
					*/
					@Excel(name = "商品名英文", width = 15)
					@ApiModelProperty(value = "商品名英文")
					private java.lang.String spmyw;
					/**活性成分中文
					*/
					@Excel(name = "活性成分中文", width = 15)
					@ApiModelProperty(value = "活性成分中文")
					private java.lang.String hxcfzw;
					/**活性成分英文
					*/
					@Excel(name = "活性成分英文", width = 15)
					@ApiModelProperty(value = "活性成分英文")
					private java.lang.String hxcfyw;
					/**包括辅料在内的完整处方组成中文
					*/
					@Excel(name = "包括辅料在内的完整处方组成中文", width = 15)
					@ApiModelProperty(value = "包括辅料在内的完整处方组成中文")
					private java.lang.String cfzczw;
					/**包括辅料在内的完整处方组成英文
					*/
					@Excel(name = "包括辅料在内的完整处方组成英文", width = 15)
					@ApiModelProperty(value = "包括辅料在内的完整处方组成英文")
					private java.lang.String cfzcyw;
					/**该药品规格是否获得许可在中国市场上使用
					*/
					@Excel(name = "该药品规格是否获得许可在中国市场上使用", width = 15)
					@ApiModelProperty(value = "该药品规格是否获得许可在中国市场上使用")
					private java.lang.String sfhdxkzzgscssy;
					/**该药品规格是否已经在中国市场上使用
					*/
					@Excel(name = "该药品规格是否已经在中国市场上使用", width = 15)
					@ApiModelProperty(value = "该药品规格是否已经在中国市场上使用")
					private java.lang.String sfyjzzgscssy;
					/**药品实际生产者地址中文
					*/
					@Excel(name = "药品实际生产者地址中文", width = 15)
					@ApiModelProperty(value = "药品实际生产者地址中文")
					private java.lang.String ypsjsczdzzw;
					/**药品实际生产者地址英文
					*/
					@Excel(name = "药品实际生产者地址英文", width = 15)
					@ApiModelProperty(value = "药品实际生产者地址英文")
					private java.lang.String ypsjsczdzyw;
					/**证明当局是否对该药品的实际生产企业进行定期检查
					*/
					@Excel(name = "证明当局是否对该药品的实际生产企业进行定期检查", width = 15)
					@ApiModelProperty(value = "证明当局是否对该药品的实际生产企业进行定期检查")
					private java.lang.String jxdqjc;
					/**定期检查的周期
					*/
					@Excel(name = "定期检查的周期", width = 15)
					@ApiModelProperty(value = "定期检查的周期")
					private java.lang.String dqjczq;
					/**此类剂型的生产是否检查过
					*/
					@Excel(name = "此类剂型的生产是否检查过", width = 15)
					@ApiModelProperty(value = "此类剂型的生产是否检查过")
					private java.lang.String jxscsfjc;
					/**生产设备和操作是否符合WHO推荐的药品生产质量管理规范
					*/
					@Excel(name = "生产设备和操作是否符合WHO推荐的药品生产质量管理规范", width = 15)
					@ApiModelProperty(value = "生产设备和操作是否符合WHO推荐的药品生产质量管理规范")
					private java.lang.String sffhwhogf;
					/**申请人所提供的信息是否满足证明当局的要求
					*/
					@Excel(name = "申请人所提供的信息是否满足证明当局的要求", width = 15)
					@ApiModelProperty(value = "申请人所提供的信息是否满足证明当局的要求")
					private java.lang.String zmdjyq;
					/**该规格未注册的理由中文
					*/
					@Excel(name = "该规格未注册的理由中文", width = 15)
					@ApiModelProperty(value = "该规格未注册的理由中文")
					private java.lang.String wzclyzw;
					/**该规格未注册的理由英文
					*/
					@Excel(name = "该规格未注册的理由英文", width = 15)
					@ApiModelProperty(value = "该规格未注册的理由英文")
					private java.lang.String wzclyyw;
					/**检查生产车间/线
					*/
					@Excel(name = "检查生产车间/线", width = 15)
					@ApiModelProperty(value = "检查生产车间/线")
					private java.lang.String jcsccj;
					/**企业排查和整改情况表
					*/
					@Excel(name = "企业排查和整改情况表", width = 15)
					@ApiModelProperty(value = "企业排查和整改情况表")
					private java.lang.String qyjczgqk;
					/**企业开展风险排查情况
					*/
					@Excel(name = "企业开展风险排查情况", width = 15)
					@ApiModelProperty(value = "企业开展风险排查情况")
					private java.lang.String qykzfxpcqk;
					/**提示风险和问题是否存在
					*/
					@Excel(name = "提示风险和问题是否存在", width = 15)
					@ApiModelProperty(value = "提示风险和问题是否存在")
					private java.lang.String fxwtsfcz;
					/**企业整改情况
					*/
					@Excel(name = "企业整改情况", width = 15)
					@ApiModelProperty(value = "企业整改情况")
					private java.lang.String qyzgqk;
					/**其他建议或意见
					*/
					@Excel(name = "其他建议或意见", width = 15)
					@ApiModelProperty(value = "其他建议或意见")
					private java.lang.String qtjyyj;
					/**认证范围中文
					*/
					@Excel(name = "认证范围中文", width = 15)
					@ApiModelProperty(value = "认证范围中文")
					private java.lang.String rzfwzw;
					/**认证范围英文
					*/
					@Excel(name = "认证范围英文", width = 15)
					@ApiModelProperty(value = "认证范围英文")
					private java.lang.String rzfwyw;
					/**受托方企业名称
					*/
					@Excel(name = "受托方企业名称", width = 15)
					@ApiModelProperty(value = "受托方企业名称")
					private java.lang.String stfqymc;
					/**受托方生产备案编号
					*/
					@Excel(name = "受托方生产备案编号", width = 15)
					@ApiModelProperty(value = "受托方生产备案编号")
					private java.lang.String stfscbabh;
					/**受托方住所
					*/
					@Excel(name = "受托方住所", width = 15)
					@ApiModelProperty(value = "受托方住所")
					private java.lang.String stfzs;
					/**受托方生产地址
					*/
					@Excel(name = "受托方生产地址", width = 15)
					@ApiModelProperty(value = "受托方生产地址")
					private java.lang.String stfscdz;
					/**受托方生产企业所在辖区
					*/
					@Excel(name = "受托方生产企业所在辖区", width = 15)
					@ApiModelProperty(value = "受托方生产企业所在辖区")
					private java.lang.String stfscqyszxq;
					/**受托方组织机构代码
					*/
					@Excel(name = "受托方组织机构代码", width = 15)
					@ApiModelProperty(value = "受托方组织机构代码")
					private java.lang.String stfzzjgdm;
					/**受托方联系电话
					*/
					@Excel(name = "受托方联系电话", width = 15)
					@ApiModelProperty(value = "受托方联系电话")
					private java.lang.String stflxdh;
					/**受托方法定代表人
					*/
					@Excel(name = "受托方法定代表人", width = 15)
					@ApiModelProperty(value = "受托方法定代表人")
					private java.lang.String stffddbr;
					/**受托方企业负责人
					*/
					@Excel(name = "受托方企业负责人", width = 15)
					@ApiModelProperty(value = "受托方企业负责人")
					private java.lang.String stfqyfzr;
					/**代理人名称
					*/
					@Excel(name = "代理人名称", width = 15)
					@ApiModelProperty(value = "代理人名称")
					private java.lang.String dlrmc;
					/**代理人住所/代理人地址
					*/
					@Excel(name = "代理人住所/代理人地址", width = 15)
					@ApiModelProperty(value = "代理人住所/代理人地址")
					private java.lang.String dlrzs;
					/**结构组成/主要组成成分/性能结构及组成
					*/
					@Excel(name = "结构组成/主要组成成分/性能结构及组成", width = 15)
					@ApiModelProperty(value = "结构组成/主要组成成分/性能结构及组成")
					private java.lang.String jgzc;
					/**预期用途/主要工作原理或者作用机理
					*/
					@Excel(name = "预期用途/主要工作原理或者作用机理", width = 15)
					@ApiModelProperty(value = "预期用途/主要工作原理或者作用机理")
					private java.lang.String yqyt;
					/**委托方生产地址邮编
					*/
					@Excel(name = "委托方生产地址邮编", width = 15)
					@ApiModelProperty(value = "委托方生产地址邮编")
					private java.lang.String stfscdzyb;
					/**委托方生产地址电话
					*/
					@Excel(name = "委托方生产地址电话", width = 15)
					@ApiModelProperty(value = "委托方生产地址电话")
					private java.lang.String stfscdzdh;
					/**受托方联系人
					*/
					@Excel(name = "受托方联系人", width = 15)
					@ApiModelProperty(value = "受托方联系人")
					private java.lang.String stflxr;
					/**受托方住所邮编
					*/
					@Excel(name = "受托方住所邮编", width = 15)
					@ApiModelProperty(value = "受托方住所邮编")
					private java.lang.String wtfzsyb;
					/**受托方住所电话
					*/
					@Excel(name = "受托方住所电话", width = 15)
					@ApiModelProperty(value = "受托方住所电话")
					private java.lang.String wtfzsdh;
					/**受托方生产地址邮编
					*/
					@Excel(name = "受托方生产地址邮编", width = 15)
					@ApiModelProperty(value = "受托方生产地址邮编")
					private java.lang.String wtfscdzyb;
					/**受托方生产地址电话
					*/
					@Excel(name = "受托方生产地址电话", width = 15)
					@ApiModelProperty(value = "受托方生产地址电话")
					private java.lang.String wtfscdzdh;
					/**医疗器械网络销售备案类型
					*/
					@Excel(name = "医疗器械网络销售备案类型", width = 15)
					@ApiModelProperty(value = "医疗器械网络销售备案类型")
					private java.lang.String ylqxwlxsbalx;
					/**联系人姓名
					*/
					@Excel(name = "联系人姓名", width = 15)
					@ApiModelProperty(value = "联系人姓名")
					private java.lang.String lxrxm;
					/**联系人身份证类型
					*/
					@Excel(name = "联系人身份证类型", width = 15)
					@ApiModelProperty(value = "联系人身份证类型")
					private java.lang.String lxrsfzlb;
					/**联系人证件号
					*/
					@Excel(name = "联系人证件号", width = 15)
					@ApiModelProperty(value = "联系人证件号")
					private java.lang.String lxrzjh;
					/**联系人电话
					*/
					@Excel(name = "联系人电话", width = 15)
					@ApiModelProperty(value = "联系人电话")
					private java.lang.String lxrdh;
					/**主体业态
					*/
					@Excel(name = "主体业态", width = 15)
					@ApiModelProperty(value = "主体业态")
					private java.lang.String ztyt;
					/**服务器存放地址
					*/
					@Excel(name = "服务器存放地址", width = 15)
					@ApiModelProperty(value = "服务器存放地址")
					private java.lang.String fwqcfdz;
					/**联系地址
					*/
					@Excel(name = "联系地址", width = 15)
					@ApiModelProperty(value = "联系地址")
					private java.lang.String lxdz;
					/**联系手机
					*/
					@Excel(name = "联系手机", width = 15)
					@ApiModelProperty(value = "联系手机")
					private java.lang.String lxsj;
					/**申请资料
					*/
					@Excel(name = "申请资料", width = 15)
					@ApiModelProperty(value = "申请资料")
					private java.lang.String syzl;
					/**试验名称
					*/
					@Excel(name = "试验名称", width = 15)
					@ApiModelProperty(value = "试验名称")
					private java.lang.String symc;
					/**试验目标
					*/
					@Excel(name = "试验目标", width = 15)
					@ApiModelProperty(value = "试验目标")
					private java.lang.String symb;
					/**试验用医疗器械分类
					*/
					@Excel(name = "试验用医疗器械分类", width = 15)
					@ApiModelProperty(value = "试验用医疗器械分类")
					private java.lang.String syyylqxfl;
					/**需进行临床试验审批的第三类医疗器械
					*/
					@Excel(name = "需进行临床试验审批的第三类医疗器械", width = 15)
					@ApiModelProperty(value = "需进行临床试验审批的第三类医疗器械")
					private java.lang.String xjjlcsyspdsfylqx;
					/**中国境内同类产品
					*/
					@Excel(name = "中国境内同类产品", width = 15)
					@ApiModelProperty(value = "中国境内同类产品")
					private java.lang.String zgjltlcp;
					/**多中心临床试验
					*/
					@Excel(name = "多中心临床试验", width = 15)
					@ApiModelProperty(value = "多中心临床试验")
					private java.lang.String dzxlcsy;
					/**代理人联系人
					*/
					@Excel(name = "代理人联系人", width = 15)
					@ApiModelProperty(value = "代理人联系人")
					private java.lang.String dlrlxr;
					/**代理人电话
					*/
					@Excel(name = "代理人电话", width = 15)
					@ApiModelProperty(value = "代理人电话")
					private java.lang.String dlrdh;
					/**代理人邮编
					*/
					@Excel(name = "代理人邮编", width = 15)
					@ApiModelProperty(value = "代理人邮编")
					private java.lang.String dlryb;
					/**监查员姓名
					*/
					@Excel(name = "监查员姓名", width = 15)
					@ApiModelProperty(value = "监查员姓名")
					private java.lang.String jcyxm;
					/**监查员电话
					*/
					@Excel(name = "监查员电话", width = 15)
					@ApiModelProperty(value = "监查员电话")
					private java.lang.String jcydh;
					/**企业名称/发货单位名称/药品生产企业名称/申请单位/产品持有人/医疗机构名称/调出方医疗机构单位名称/制剂配制单位名称/调入方医疗机构单位名称/申请人单位名称/委托配制单位名称/委托方单位名称/受托方单位名称/机构名称/网站名称/原药品生产企业名称/工厂名称中文/药品生产许可证编号/药品生产企业或者药品上市许可持有人中文/药品生产企业或者药品上市许可持有人/委托方企业名称/注册人名称/申请人名称/申办者*/
					@Excel(name = "企业名称/发货单位名称/药品生产企业名称/申请单位/产品持有人/医疗机构名称/调出方医疗机构单位名称/制剂配制单位名称/调入方医疗机构单位名称/申请人单位名称/委托配制单位名称/委托方单位名称/受托方单位名称/机构名称/网站名称/原药品生产企业名称/工厂名称中文/药品生产许可证编号/药品生产企业或者药品上市许可持有人中文/药品生产企业或者药品上市许可持有人/委托方企业名称/注册人名称/申请人名称/申办者", width = 15)
					@ApiModelProperty(value = "企业名称/发货单位名称/药品生产企业名称/申请单位/产品持有人/医疗机构名称/调出方医疗机构单位名称/制剂配制单位名称/调入方医疗机构单位名称/申请人单位名称/委托配制单位名称/委托方单位名称/受托方单位名称/机构名称/网站名称/原药品生产企业名称/工厂名称中文/药品生产许可证编号/药品生产企业或者药品上市许可持有人中文/药品生产企业或者药品上市许可持有人/委托方企业名称/注册人名称/申请人名称/申办者")
					private java.lang.String qymc;
					/**许可证编号/进口准许证号/编号/批件号/广告批准文号/批准文号/原制剂文号/制剂批准文号/备案号/原始编号/药品批准文号/批准文号/备案编号/委托方生产备案编号/注册证编号*/
					@Excel(name = "许可证编号/进口准许证号/编号/批件号/广告批准文号/批准文号/原制剂文号/制剂批准文号/备案号/原始编号/药品批准文号/批准文号/备案编号/委托方生产备案编号/注册证编号", width = 15)
					@ApiModelProperty(value = "许可证编号/进口准许证号/编号/批件号/广告批准文号/批准文号/原制剂文号/制剂批准文号/备案号/原始编号/药品批准文号/批准文号/备案编号/委托方生产备案编号/注册证编号")
					private java.lang.String zsbh;
					/**社会信用代码/统一社会信用代码/委托配制单位社会信用代码/委托方组织机构代码

					*/
					@Excel(name = "社会信用代码/统一社会信用代码/委托配制单位社会信用代码/委托方组织机构代码 ", width = 15)
							@ApiModelProperty(value = "社会信用代码/统一社会信用代码/委托配制单位社会信用代码/委托方组织机构代码 ")
									private java.lang.String shxydm;
									/**分类码
									*/
									@Excel(name = "分类码", width = 15)
									@ApiModelProperty(value = "分类码")
									private java.lang.String flm;
									/**生产地址和范围副本/范围英文*/
									@Excel(name = "生产地址和范围副本/范围英文", width = 15)
									@ApiModelProperty(value = "生产地址和范围副本/范围英文")
									private java.lang.String scdzscfwyw;
									/**areaname*/
									@Excel(name = "areaname", width = 15)
									@ApiModelProperty(value = "areaname")
									private java.lang.String areaname;
									/**areacode*/
									@Excel(name = "areacode", width = 15)
									@ApiModelProperty(value = "areacode")
									private java.lang.String areacode;
									/**dzzzid*/
									@Excel(name = "dzzzid", width = 15)
									@ApiModelProperty(value = "dzzzid")
									private java.lang.String dzzzid;
									/**ewm*/
									@Excel(name = "ewm", width = 15)
									@ApiModelProperty(value = "ewm")
									private java.lang.String ewm;
									/**transid*/
									@Excel(name = "transid", width = 15)
									@ApiModelProperty(value = "transid")
									private java.lang.String transid;
									/**zjdwmc*/
									@Excel(name = "zjdwmc", width = 15)
									@ApiModelProperty(value = "zjdwmc")
									private java.lang.String zjdwmc;
									/**zjpzdz*/
									@Excel(name = "zjpzdz", width = 15)
									@ApiModelProperty(value = "zjpzdz")
									private java.lang.String zjpzdz;
									/**fj*/
									@Excel(name = "fj", width = 15)
									@ApiModelProperty(value = "fj")
									private java.lang.String fj;
									/**dwdz*/
									@Excel(name = "dwdz", width = 15)
									@ApiModelProperty(value = "dwdz")
									private java.lang.String dwdz;
									/**dwmc*/
									@Excel(name = "dwmc", width = 15)
									@ApiModelProperty(value = "dwmc")
									private java.lang.String dwmc;
									/**pzwh*/
									@Excel(name = "pzwh", width = 15)
									@ApiModelProperty(value = "pzwh")
									private java.lang.String pzwh;
									/**syqx*/
									@Excel(name = "syqx", width = 15)
									@ApiModelProperty(value = "syqx")
									private java.lang.String syqx;
									/**guige*/
									@Excel(name = "guige", width = 15)
									@ApiModelProperty(value = "guige")
									private java.lang.String guige;
									/**yzjwh*/
									@Excel(name = "yzjwh", width = 15)
									@ApiModelProperty(value = "yzjwh")
									private java.lang.String yzjwh;
									/**rzbh*/
									@Excel(name = "rzbh", width = 15)
									@ApiModelProperty(value = "rzbh")
									private java.lang.String rzbh;
									/**stfpjpzdz*/
									@Excel(name = "stfpjpzdz", width = 15)
									@ApiModelProperty(value = "stfpjpzdz")
									private java.lang.String stfpjpzdz;
									/**pzwhyxq*/
									@Excel(name = "pzwhyxq", width = 15)
									@ApiModelProperty(value = "pzwhyxq")
									private java.lang.String pzwhyxq;
									/**zjyxq*/
									@Excel(name = "zjyxq", width = 15)
									@ApiModelProperty(value = "zjyxq")
									private java.lang.String zjyxq;
									/**wzmc*/
									@Excel(name = "wzmc", width = 15)
									@ApiModelProperty(value = "wzmc")
									private java.lang.String wzmc;
									/**sqly*/
									@Excel(name = "sqly", width = 15)
									@ApiModelProperty(value = "sqly")
									private java.lang.String sqly;
									/**ysbh*/
									@Excel(name = "ysbh", width = 15)
									@ApiModelProperty(value = "ysbh")
									private java.lang.String ysbh;
									/**ckywmcyw*/
									@Excel(name = "ckywmcyw", width = 15)
									@ApiModelProperty(value = "ckywmcyw")
									private java.lang.String ckywmcyw;
									/**jszc*/
									@Excel(name = "jszc", width = 15)
									@ApiModelProperty(value = "jszc")
									private java.lang.String jszc;
									/**iszy*/
									@Excel(name = "iszy", width = 15)
									@ApiModelProperty(value = "iszy")
									private java.lang.String iszy;
									/**cynx*/
									@Excel(name = "cynx", width = 15)
									@ApiModelProperty(value = "cynx")
									private java.lang.String cynx;
									/**bgqqk*/
									@Excel(name = "bgqqk", width = 15)
									@ApiModelProperty(value = "bgqqk")
									private java.lang.String bgqqk;
									/**bghqk*/
									@Excel(name = "bghqk", width = 15)
									@ApiModelProperty(value = "bghqk")
									private java.lang.String bghqk;
									/**basx*/
									@Excel(name = "basx", width = 15)
									@ApiModelProperty(value = "basx")
									private java.lang.String basx;
									/**sqrsfzh*/
									@Excel(name = "sqrsfzh", width = 15)
									@ApiModelProperty(value = "sqrsfzh")
									private java.lang.String sqrsfzh;
									/**jl*/
									@Excel(name = "jl", width = 15)
									@ApiModelProperty(value = "jl")
									private java.lang.String jl;
									/**pzwhyw*/
									@Excel(name = "pzwhyw", width = 15)
									@ApiModelProperty(value = "pzwhyw")
									private java.lang.String pzwhyw;
									/**dqjczqyw*/
									@Excel(name = "dqjczqyw", width = 15)
									@ApiModelProperty(value = "dqjczqyw")
									private java.lang.String dqjczqyw;
									/**wzcxm*/
									@Excel(name = "wzcxm", width = 15)
									@ApiModelProperty(value = "wzcxm")
									private java.lang.String wzcxm;
									/**ipdz*/
									@Excel(name = "ipdz", width = 15)
									@ApiModelProperty(value = "ipdz")
									private java.lang.String ipdz;
									/**hlwbah*/
									@Excel(name = "hlwbah", width = 15)
									@ApiModelProperty(value = "hlwbah")
									private java.lang.String hlwbah;
									/**slsjn*/
									@Excel(name = "slsjn", width = 15)
									@ApiModelProperty(value = "slsjn")
									private java.lang.String slsjn;
									/**slsjy*/
									@Excel(name = "slsjy", width = 15)
									@ApiModelProperty(value = "slsjy")
									private java.lang.String slsjy;
									/**slsjr*/
									@Excel(name = "slsjr", width = 15)
									@ApiModelProperty(value = "slsjr")
									private java.lang.String slsjr;
									/**cpphyw*/
									@Excel(name = "cpphyw", width = 15)
									@ApiModelProperty(value = "cpphyw")
									private java.lang.String cpphyw;
									/**cpmc2*/
									@Excel(name = "cpmc2", width = 15)
									@ApiModelProperty(value = "cpmc2")
									private java.lang.String cpmc2;
									/**cpmc3*/
									@Excel(name = "cpmc3", width = 15)
									@ApiModelProperty(value = "cpmc3")
									private java.lang.String cpmc3;
									/**cpmc4*/
									@Excel(name = "cpmc4", width = 15)
									@ApiModelProperty(value = "cpmc4")
									private java.lang.String cpmc4;
									/**guige2*/
									@Excel(name = "guige2", width = 15)
									@ApiModelProperty(value = "guige2")
									private java.lang.String guige2;
									/**bzgg2*/
									@Excel(name = "bzgg2", width = 15)
									@ApiModelProperty(value = "bzgg2")
									private java.lang.String bzgg2;
									/**bzgg3*/
									@Excel(name = "bzgg3", width = 15)
									@ApiModelProperty(value = "bzgg3")
									private java.lang.String bzgg3;
									/**bzgg4*/
									@Excel(name = "bzgg4", width = 15)
									@ApiModelProperty(value = "bzgg4")
									private java.lang.String bzgg4;
									/**xh1*/
									@Excel(name = "xh1", width = 15)
									@ApiModelProperty(value = "xh1")
									private java.lang.String xh1;
									/**xh2*/
									@Excel(name = "xh2", width = 15)
									@ApiModelProperty(value = "xh2")
									private java.lang.String xh2;
									/**xh3*/
									@Excel(name = "xh3", width = 15)
									@ApiModelProperty(value = "xh3")
									private java.lang.String xh3;
									/**xh4*/
									@Excel(name = "xh4", width = 15)
									@ApiModelProperty(value = "xh4")
									private java.lang.String xh4;
}
