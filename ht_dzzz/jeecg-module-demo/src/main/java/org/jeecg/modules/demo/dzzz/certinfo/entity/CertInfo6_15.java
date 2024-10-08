package org.jeecg.modules.demo.dzzz.certinfo.entity;

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
 * @Description: cert_info2
 * @Author: jeecg-boot
 * @Date:   2024-06-13
 * @Version: V1.0
 */
@Data
@TableName("cert_info6_15")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="cert_info1对象", description="cert_info2")
public class CertInfo6_15 implements Serializable {
    private static final long serialVersionUID = 1L;

	/**证书id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "证书id")
    private String id;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private String createBy;
	/**创建日期*/
    @ApiModelProperty(value = "创建日期")
    private String createTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private String updateBy;
	/**更新日期*/
    @ApiModelProperty(value = "更新日期")
    private String updateTime;
	/**企业编码*/
	@Excel(name = "企业编码", width = 15)
    @ApiModelProperty(value = "企业编码")
    private String qyid;
	/**证书编号/证书号码*/
	@Excel(name = "证书编号/证书号码", width = 15)
    @ApiModelProperty(value = "证书编号/证书号码")
    private String zsbh;
	/**备注*/
	@Excel(name = "备注", width = 15)
    @ApiModelProperty(value = "备注")
    private String bz;
	/**产品*/
	@Excel(name = "产品", width = 15)
    @ApiModelProperty(value = "产品")
    private String chanpin;
	/**产品类别*/
	@Excel(name = "产品类别", width = 15)
    @ApiModelProperty(value = "产品类别")
    private String cplb;
	/**产品明细*/
	@Excel(name = "产品明细", width = 15)
    @ApiModelProperty(value = "产品明细")
    private String cpmx;
	/**接受来源*/
	@Excel(name = "接受来源", width = 15)
    @ApiModelProperty(value = "接受来源")
    private String jsly;
	/**盖章生成状态 0同步 2未生成3生成未盖章 4盖章*/
	@Excel(name = "盖章生成状态 0同步 2未生成3生成未盖章 4盖章", width = 15)
    @ApiModelProperty(value = "盖章生成状态 0同步 2未生成3生成未盖章 4盖章")
    private String zt;
	/**业务类型*/
	@Excel(name = "业务类型", width = 15)
    @ApiModelProperty(value = "业务类型")
    private String ywlx;
	/**版本id*/
	@Excel(name = "版本id", width = 15)
    @ApiModelProperty(value = "版本id")
    private String bbid;
	/**模块id*/
	@Excel(name = "模块id", width = 15)
    @ApiModelProperty(value = "模块id")
    private String mbid;
	/**数据同步公示平台*/
	@Excel(name = "数据同步公示平台", width = 15)
    @ApiModelProperty(value = "数据同步公示平台")
    private String sjtbGspt;
	/**数据同步档案系统*/
	@Excel(name = "数据同步档案系统", width = 15)
    @ApiModelProperty(value = "数据同步档案系统")
    private String sjtbDa;
	/**数据同步行政审批*/
	@Excel(name = "数据同步行政审批", width = 15)
    @ApiModelProperty(value = "数据同步行政审批")
    private String sjtbXzsp;
	/**数据同步国家局*/
	@Excel(name = "数据同步国家局", width = 15)
    @ApiModelProperty(value = "数据同步国家局")
    private String sjtbGjj;
	/**数据同步错误信息*/
	@Excel(name = "数据同步错误信息", width = 15)
    @ApiModelProperty(value = "数据同步错误信息")
    private String sjtbError;
	/**数据同步国家局时间*/
	@Excel(name = "数据同步国家局时间", width = 15)
    @ApiModelProperty(value = "数据同步国家局时间")
    private String sjtbGjjTime;
	/**数据同步公示平台时间*/
	@Excel(name = "数据同步公示平台时间", width = 15)
    @ApiModelProperty(value = "数据同步公示平台时间")
    private String sjtbGsptTime;
	/**数据同步档案系统时间*/
	@Excel(name = "数据同步档案系统时间", width = 15)
    @ApiModelProperty(value = "数据同步档案系统时间")
    private String sjtbDaTime;
	/**数据同步行政审批*/
	@Excel(name = "数据同步行政审批", width = 15)
    @ApiModelProperty(value = "数据同步行政审批")
    private String sjtbXzspTime;
	/**二维码*/
	@Excel(name = "二维码", width = 15)
    @ApiModelProperty(value = "二维码")
    private String ewm;
	/**二维码路径*/
	@Excel(name = "二维码路径", width = 15)
    @ApiModelProperty(value = "二维码路径")
    private String ewmLj;
	/**企业类型*/
	@Excel(name = "企业类型", width = 15)
    @ApiModelProperty(value = "企业类型")
    private String qylx;
	/**证照类型Id*/
	@Excel(name = "证照类型Id", width = 15)
    @ApiModelProperty(value = "证照类型Id")
    private String certtypeid;
	/**原始数据id*/
	@Excel(name = "原始数据id", width = 15)
    @ApiModelProperty(value = "原始数据id")
    private String oldId;
	/**电子证书（多证书;分割）*/
	@Excel(name = "电子证书（多证书;分割）", width = 15)
    @ApiModelProperty(value = "电子证书（多证书;分割）")
    private String dzzsId;
	/**关联数据ID*/
	@Excel(name = "关联数据ID", width = 15)
    @ApiModelProperty(value = "关联数据ID")
    private String glsjId;
	/**审批ID xzsp_rights_type 表id*/
	@Excel(name = "审批ID xzsp_rights_type 表id", width = 15)
    @ApiModelProperty(value = "审批ID xzsp_rights_type 表id")
    private String transId;
	/**事项编码*/
	@Excel(name = "事项编码", width = 15)
    @ApiModelProperty(value = "事项编码")
    private String workCode;
	/**事项名称*/
	@Excel(name = "事项名称", width = 15)
    @ApiModelProperty(value = "事项名称")
    private String workName;
	/**区划代码*/
	@Excel(name = "区划代码", width = 15)
    @ApiModelProperty(value = "区划代码")
    private String areacode;
	/**区划名称*/
	@Excel(name = "区划名称", width = 15)
    @ApiModelProperty(value = "区划名称")
    private String qxname;
	/**日常监督管理机构id*/
	@Excel(name = "日常监督管理机构id", width = 15)
    @ApiModelProperty(value = "日常监督管理机构id")
    private String rcjdgljgid;
	/**签发机构Id*/
	@Excel(name = "签发机构Id", width = 15)
    @ApiModelProperty(value = "签发机构Id")
    private String qfjgid;
	/**有效状态10核发20变更30换证60证书纠错70数据维护*/
	@Excel(name = "有效状态10核发20变更30换证60证书纠错70数据维护", width = 15)
    @ApiModelProperty(value = "有效状态10核发20变更30换证60证书纠错70数据维护")
    private String zszt;
	/**使用状态（0草稿，1申请；2完成；3作废）*/
	@Excel(name = "使用状态（0草稿，1申请；2完成；3作废）", width = 15)
    @ApiModelProperty(value = "使用状态（0草稿，1申请；2完成；3作废）")
    private String usezt;
	/**数据同步市场局*/
	@Excel(name = "数据同步市场局", width = 15)
    @ApiModelProperty(value = "数据同步市场局")
    private String syncScj;
	/**是否合格*/
	@Excel(name = "是否合格", width = 15)
    @ApiModelProperty(value = "是否合格")
    private String ishg;
	/**二类医疗器械注册证当前生效数据标记*/
	@Excel(name = "二类医疗器械注册证当前生效数据标记", width = 15)
    @ApiModelProperty(value = "二类医疗器械注册证当前生效数据标记")
    private String elyljxsxNum;
	/**广告数据推送*/
	@Excel(name = "广告数据推送", width = 15)
    @ApiModelProperty(value = "广告数据推送")
    private String ggsjts;
	/**自动盖章id*/
	@Excel(name = "自动盖章id", width = 15)
    @ApiModelProperty(value = "自动盖章id")
    private String zdgzid;
	/**数据中心同步*/
	@Excel(name = "数据中心同步", width = 15)
    @ApiModelProperty(value = "数据中心同步")
    private String syncSjzx;
	/**事项拼接信息*/
	@Excel(name = "事项拼接信息", width = 15)
    @ApiModelProperty(value = "事项拼接信息")
    private String sxpjxx;
	/**是否为医疗器械注册人、备案人和经营企业专门提供运输、贮存服务*/
	@Excel(name = "是否为医疗器械注册人、备案人和经营企业专门提供运输、贮存服务", width = 15)
    @ApiModelProperty(value = "是否为医疗器械注册人、备案人和经营企业专门提供运输、贮存服务")
    private String isYscc;
	/**是否具备儿童护肤类、眼部护肤类化妆品生产条件*/
	@Excel(name = "是否具备儿童护肤类、眼部护肤类化妆品生产条件", width = 15)
    @ApiModelProperty(value = "是否具备儿童护肤类、眼部护肤类化妆品生产条件")
    private String isEthfYbhg;
	/**证书类型关联code*/
	@Excel(name = "证书类型关联code", width = 15)
    @ApiModelProperty(value = "证书类型关联code")
    private String licenseType;
	/**打印状态*/
	@Excel(name = "打印状态", width = 15)
    @ApiModelProperty(value = "打印状态")
    private String printStatus;
	/**前置库是否同步*/
	@Excel(name = "前置库是否同步", width = 15)
    @ApiModelProperty(value = "前置库是否同步")
    private String sync;
	/**权力事项基础编码*/
	@Excel(name = "权力事项基础编码", width = 15)
    @ApiModelProperty(value = "权力事项基础编码")
    private String qlsx;
	/**办件信息*/
	@Excel(name = "办件信息", width = 15)
    @ApiModelProperty(value = "办件信息")
    private String projectInfo;
	/**办件编码*/
	@Excel(name = "办件编码", width = 15)
    @ApiModelProperty(value = "办件编码")
    private String projectNo;
	/**事项编码*/
	@Excel(name = "事项编码", width = 15)
    @ApiModelProperty(value = "事项编码")
    private String taskCode;
	/**电子证照标识*/
	@Excel(name = "电子证照标识", width = 15)
    @ApiModelProperty(value = "电子证照标识")
    private String dzzzid;
	/**是否异常数据1是0否,市局初始化很多异常数据*/
	@Excel(name = "是否异常数据1是0否,市局初始化很多异常数据", width = 15)
    @ApiModelProperty(value = "是否异常数据1是0否,市局初始化很多异常数据")
    private String sfycsj;
	/**手动修改数据原因*/
	@Excel(name = "手动修改数据原因", width = 15)
    @ApiModelProperty(value = "手动修改数据原因")
    private String sdxgsjyy;
	/**是否补录*/
	@Excel(name = "是否补录", width = 15)
    @ApiModelProperty(value = "是否补录")
    private String isbl;
	/**license_type的备份值*/
	@Excel(name = "license_type的备份值", width = 15)
    @ApiModelProperty(value = "license_type的备份值")
    private String oldLicenseType;
	/**历史electronic_license*/
	@Excel(name = "历史electronic_license", width = 15)
    @ApiModelProperty(value = "历史electronic_license")
    private String oldElectronicLicense;
	/**证照类型另外的编码值*/
	@Excel(name = "证照类型另外的编码值", width = 15)
    @ApiModelProperty(value = "证照类型另外的编码值")
    private String typecode;
	/**证书名称*/
	@Excel(name = "证书名称", width = 15)
    @ApiModelProperty(value = "证书名称")
    private String zsname;
	/**区划地址详细*/
	@Excel(name = "区划地址详细", width = 15)
    @ApiModelProperty(value = "区划地址详细")
    private String qxxxname;
	/**证书状态10有效50注销60过期70吊销80撤销99作废*/
	@Excel(name = "证书状态10有效50注销60过期70吊销80撤销99作废", width = 15)
    @ApiModelProperty(value = "证书状态10有效50注销60过期70吊销80撤销99作废")
    private String yxzt;
	/**联系人*/
	@Excel(name = "联系人", width = 15)
    @ApiModelProperty(value = "联系人")
    private String lxr;
	/**投诉举报电话*/
	@Excel(name = "投诉举报电话", width = 15)
    @ApiModelProperty(value = "投诉举报电话")
    private String complaintphone;
	/**最新许可类型*/
	@Excel(name = "最新许可类型", width = 15)
    @ApiModelProperty(value = "最新许可类型")
    private String validstatus;
	/**业务编码*/
	@Excel(name = "业务编码", width = 15)
    @ApiModelProperty(value = "业务编码")
    private String workcode;
	/**吊销原因*/
	@Excel(name = "吊销原因", width = 15)
    @ApiModelProperty(value = "吊销原因")
    private String deactivecause;
	/**注销日期*/
	@Excel(name = "注销日期", width = 15)
    @ApiModelProperty(value = "注销日期")
    private String logoutdate;
	/**撤销原因*/
	@Excel(name = "撤销原因", width = 15)
    @ApiModelProperty(value = "撤销原因")
    private String repealcause;
	/**最后一次操作时间戳*/
	@Excel(name = "最后一次操作时间戳", width = 15)
    @ApiModelProperty(value = "最后一次操作时间戳")
    private String czsjsjc;
	/**最后一次操作时间*/
	@Excel(name = "最后一次操作时间", width = 15)
    @ApiModelProperty(value = "最后一次操作时间")
    private String czsj;
	/**注销原因*/
	@Excel(name = "注销原因", width = 15)
    @ApiModelProperty(value = "注销原因")
    private String logoutcause;
	/**吊销日期*/
	@Excel(name = "吊销日期", width = 15)
    @ApiModelProperty(value = "吊销日期")
    private String deactivedate;
	/**类型类别*/
	@Excel(name = "类型类别", width = 15)
    @ApiModelProperty(value = "类型类别")
    private String lxlb;
	/**是否补发*/
	@Excel(name = "是否补发", width = 15)
    @ApiModelProperty(value = "是否补发")
    private String isbf;
	/**签发时间*/
	@Excel(name = "签发时间", width = 15)
    @ApiModelProperty(value = "签发时间")
    private String qfsj;
	/**补发纸质文档*/
	@Excel(name = "补发纸质文档", width = 15)
    @ApiModelProperty(value = "补发纸质文档")
    private String bfzzwd;
	/**补发原因*/
	@Excel(name = "补发原因", width = 15)
    @ApiModelProperty(value = "补发原因")
    private String bfyy;
	/**补发操作人*/
	@Excel(name = "补发操作人", width = 15)
    @ApiModelProperty(value = "补发操作人")
    private String certczr;
	/**维护人*/
	@Excel(name = "维护人", width = 15)
    @ApiModelProperty(value = "维护人")
    private String whr;
	/**维护原因*/
	@Excel(name = "维护原因", width = 15)
    @ApiModelProperty(value = "维护原因")
    private String whyy;
	/**jssj*/
	@Excel(name = "jssj", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "jssj")
    private Date jssj;
	/**flm*/
	@Excel(name = "flm", width = 15)
    @ApiModelProperty(value = "flm")
    private String flm;
	/**qymc*/
	@Excel(name = "qymc", width = 15)
    @ApiModelProperty(value = "qymc")
    private String qymc;
	/**shxydm*/
	@Excel(name = "shxydm", width = 15)
    @ApiModelProperty(value = "shxydm")
    private String shxydm;
	/**slh*/
	@Excel(name = "slh", width = 15)
    @ApiModelProperty(value = "slh")
    private String slh;
	/**fzjg*/
	@Excel(name = "fzjg", width = 15)
    @ApiModelProperty(value = "fzjg")
    private String fzjg;
	/**lxdh*/
	@Excel(name = "lxdh", width = 15)
    @ApiModelProperty(value = "lxdh")
    private String lxdh;
	/**isscdzzz*/
	@Excel(name = "isscdzzz", width = 15)
    @ApiModelProperty(value = "isscdzzz")
    private String isscdzzz;
	/**deviceType*/
	@Excel(name = "deviceType", width = 15)
    @ApiModelProperty(value = "deviceType")
    private String deviceType;
	/**rcjdglry*/
	@Excel(name = "rcjdglry", width = 15)
    @ApiModelProperty(value = "rcjdglry")
    private String rcjdglry;
    private  String zsdl;
}
