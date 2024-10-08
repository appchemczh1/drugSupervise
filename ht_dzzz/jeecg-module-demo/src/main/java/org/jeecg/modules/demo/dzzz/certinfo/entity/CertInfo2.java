package org.jeecg.modules.demo.dzzz.certinfo.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.redis.connection.stream.Record;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 电子证照源数据
 * @Author: jeecg-boot
 * @Date:   2024-03-27
 * @Version: V1.0
 */
@ApiModel(value="cert_info对象", description="电子证照源数据")
@Data
@TableName("cert_info1")
public class CertInfo2 implements Serializable  {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
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
	/**企业编码*/
	@Excel(name = "企业编码", width = 15)
    @ApiModelProperty(value = "企业编码")
    private java.lang.String qyid;
	/**证书类型*/
	@Excel(name = "证书类型", width = 15)
    @ApiModelProperty(value = "证书类型")
    private java.lang.String zslx;
	/**证书编号*/
	@Excel(name = "证书编号", width = 15)
    @ApiModelProperty(value = "证书编号")
    private java.lang.String zsbh;
	/**社会统一信用代码*/
	@Excel(name = "社会统一信用代码", width = 15)
    @ApiModelProperty(value = "社会统一信用代码")
    private java.lang.String shxydm;
	/**注册地址*/
	@Excel(name = "注册地址", width = 15)
    @ApiModelProperty(value = "注册地址")
    private java.lang.String zcdz;
	/**法定代表人*/
	@Excel(name = "法定代表人", width = 15)
    @ApiModelProperty(value = "法定代表人")
    private java.lang.String fddbr;
	/**企业负责人*/
	@Excel(name = "企业负责人", width = 15)
    @ApiModelProperty(value = "企业负责人")
    private java.lang.String qyfzr;
	/**质量负责人*/
	@Excel(name = "质量负责人", width = 15)
    @ApiModelProperty(value = "质量负责人")
    private java.lang.String zlfzr;
	/**分类码*/
	@Excel(name = "分类码", width = 15)
    @ApiModelProperty(value = "分类码")
    private java.lang.String flm;
	/**日常监管机构*/
	@Excel(name = "日常监管机构", width = 15)
    @ApiModelProperty(value = "日常监管机构")
    private java.lang.String rcjdgljg;
	/**日常监管人员*/
	@Excel(name = "日常监管人员", width = 15)
    @ApiModelProperty(value = "日常监管人员")
    private java.lang.String rcjdglry;
	/**生产地址和生产范围*/
	@Excel(name = "生产地址和生产范围", width = 15)
    @ApiModelProperty(value = "生产地址和生产范围")
    private java.lang.String scdzhfw;
	/**发证机关*/
	@Excel(name = "发证机关", width = 15)
    @ApiModelProperty(value = "发证机关")
    private java.lang.String fzjg;
	/**签发人*/
	@Excel(name = "签发人", width = 15)
    @ApiModelProperty(value = "签发人")
    private java.lang.String qfr;
	/**发证日期*/
	@Excel(name = "发证日期", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "发证日期")
    private java.lang.String fzrq;
	/**有效期起*/
	@Excel(name = "有效期起", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "有效期起")
    private java.lang.String yxqq;
	/**有效期止*/
	@Excel(name = "有效期止", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "有效期止")
    private java.lang.String yxqz;
	/**生产地址*/
	@Excel(name = "生产地址", width = 15)
    @ApiModelProperty(value = "生产地址")
    private java.lang.String scdz;
	/**受理号*/
	@Excel(name = "受理号", width = 15)
    @ApiModelProperty(value = "受理号")
    private java.lang.String slh;
	/**仓库地址*/
	@Excel(name = "仓库地址", width = 15)
    @ApiModelProperty(value = "仓库地址")
    private java.lang.String ckdz;
	/**结构以及组成*/
	@Excel(name = "结构以及组成", width = 15)
    @ApiModelProperty(value = "结构以及组成")
    private java.lang.String jgyjzc;
	/**范围*/
	@Excel(name = "范围", width = 15)
    @ApiModelProperty(value = "范围")
    private java.lang.String fw;
	/**范围英文*/
	@Excel(name = "范围英文", width = 15)
    @ApiModelProperty(value = "范围英文")
    private java.lang.String fwyw;
	/**备注*/
	@Excel(name = "备注", width = 15)
    @ApiModelProperty(value = "备注")
    private java.lang.String bz;
	/**主送*/
	@Excel(name = "主送", width = 15)
    @ApiModelProperty(value = "主送")
    private java.lang.String zs;
	/**抄送*/
	@Excel(name = "抄送", width = 15)
    @ApiModelProperty(value = "抄送")
    private java.lang.String chaosong;
	/**产品*/
	@Excel(name = "产品", width = 15)
    @ApiModelProperty(value = "产品")
    private java.lang.String chanpin;
	/**产品类别*/
	@Excel(name = "产品类别", width = 15)
    @ApiModelProperty(value = "产品类别")
    private java.lang.String cplb;
	/**产品明细*/
	@Excel(name = "产品明细", width = 15)
    @ApiModelProperty(value = "产品明细")
    private java.lang.String cpmx;
	/**传真*/
	@Excel(name = "传真", width = 15)
    @ApiModelProperty(value = "传真")
    private java.lang.String cz;
	/**电话*/
	@Excel(name = "电话", width = 15)
    @ApiModelProperty(value = "电话")
    private java.lang.String dh;
	/**剂型*/
	@Excel(name = "剂型", width = 15)
    @ApiModelProperty(value = "剂型")
    private java.lang.String jx;
	/**附件*/
	@Excel(name = "附件", width = 15)
    @ApiModelProperty(value = "附件")
    private java.lang.String fj;
	/**网站域名*/
	@Excel(name = "网站域名", width = 15)
    @ApiModelProperty(value = "网站域名")
    private java.lang.String wzym;
	/**接受来源*/
	@Excel(name = "接受来源", width = 15)
    @ApiModelProperty(value = "接受来源")
    private java.lang.String jsly;
	/**状态*/
	@Excel(name = "状态", width = 15)
    @ApiModelProperty(value = "状态")
    private java.lang.String zt;
	/**业务类型*/
	@Excel(name = "业务类型", width = 15)
    @ApiModelProperty(value = "业务类型")
    private java.lang.String ywlx;
	/**版本id*/
	@Excel(name = "版本id", width = 15)
    @ApiModelProperty(value = "版本id")
    private java.lang.String bbid;
	/**模块id*/
	@Excel(name = "模块id", width = 15)
    @ApiModelProperty(value = "模块id")
    private java.lang.String mbid;
	/**数据同步公示平台*/
	@Excel(name = "数据同步公示平台", width = 15)
    @ApiModelProperty(value = "数据同步公示平台")
    private java.lang.String sjtbGspt;
	/**数据同步档案系统*/
	@Excel(name = "数据同步档案系统", width = 15)
    @ApiModelProperty(value = "数据同步档案系统")
    private java.lang.String sjtbDa;
	/**数据同步行政审批*/
	@Excel(name = "数据同步行政审批", width = 15)
    @ApiModelProperty(value = "数据同步行政审批")
    private java.lang.String sjtbXzsp;
	/**数据同步国家局*/
	@Excel(name = "数据同步国家局", width = 15)
    @ApiModelProperty(value = "数据同步国家局")
    private java.lang.String sjtbGjj;
	/**数据同步错误信息*/
	@Excel(name = "数据同步错误信息", width = 15)
    @ApiModelProperty(value = "数据同步错误信息")
    private java.lang.String sjtbError;
	/**数据同步国家局时间*/
	@Excel(name = "数据同步国家局时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "数据同步国家局时间")
    private java.util.Date sjtbGjjTime;
	/**数据同步公示平台时间*/
	@Excel(name = "数据同步公示平台时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "数据同步公示平台时间")
    private java.util.Date sjtbGsptTime;
	/**数据同步档案系统时间*/
	@Excel(name = "数据同步档案系统时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "数据同步档案系统时间")
    private java.util.Date sjtbDaTime;
	/**数据同步行政审批*/
	@Excel(name = "数据同步行政审批", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "数据同步行政审批")
    private java.util.Date sjtbXzspTime;
	/**二维码*/
	@Excel(name = "二维码", width = 15)
    @ApiModelProperty(value = "二维码")
    private java.lang.String ewm;
	/**二维码路径*/
	@Excel(name = "二维码路径", width = 15)
    @ApiModelProperty(value = "二维码路径")
    private java.lang.String ewmLj;
	/**管理者代表*/
	@Excel(name = "管理者代表", width = 15)
    @ApiModelProperty(value = "管理者代表")
    private java.lang.String glzdb;
	/**联系人邮箱*/
	@Excel(name = "联系人邮箱", width = 15)
    @ApiModelProperty(value = "联系人邮箱")
    private java.lang.String lxryx;
	/**联系人电话*/
	@Excel(name = "联系人电话", width = 15)
    @ApiModelProperty(value = "联系人电话")
    private java.lang.String lxdh;
	/**企业类型*/
	@Excel(name = "企业类型", width = 15)
    @ApiModelProperty(value = "企业类型")
    private java.lang.String qylx;
	/**预留字段1*/
	@Excel(name = "预留字段1", width = 15)
    @ApiModelProperty(value = "预留字段1")
    private java.lang.String ylzd1;
	/**预留字段5*/
	@Excel(name = "预留字段5", width = 15)
    @ApiModelProperty(value = "预留字段5")
    private java.lang.String ylzd5;
	/**预留字段2*/
	@Excel(name = "预留字段2", width = 15)
    @ApiModelProperty(value = "预留字段2")
    private java.lang.String ylzd2;
	/**预留字段3*/
	@Excel(name = "预留字段3", width = 15)
    @ApiModelProperty(value = "预留字段3")
    private java.lang.String ylzd3;
	/**预留字段4*/
	@Excel(name = "预留字段4", width = 15)
    @ApiModelProperty(value = "预留字段4")
    private java.lang.String ylzd4;


    @Excel(name = "证照类型Id", width = 15)
    @ApiModelProperty(value = "证照类型Id")
    private java.lang.String certtypeid;



    @Excel(name = "原始数据id", width = 15)
    @ApiModelProperty(value = "原始数据id")
    private java.lang.String oldId;

    @Excel(name = "证书状态10有效50注销60过期70吊销80撤销99作废", width = 15)
    @ApiModelProperty(value = "证书状态")
    private java.lang.String yxzt;


    @TableField(exist = false)
    private String zsdl;
    private java.lang.String dzzsId;
    private String glsjId;
    private String transId;
    private String workCode;
    private String workName;
    private String areacode;
    private String qxname;
    private String rcjdgljgid;
    private String qfjgid;
    private String shtyxydmZs;
    private String zszt;
    private String usezt;
    private String syncScj;
    private String ishg;
    private String elyljxsxNum;
    private String ggsjts;
    private String zdgzid;
    private String syncSjzx;
    private String sxpjxx;
    private String isYscc;
    private String isEthfYbhg;
    private String licenseType;
    private String printStatus;
    private String qyfzrid;
    private String zlfzrid;
    private String sync;
    private String qlsx;
    private String projectInfo;
    private String projectNo;
    private String taskCode;
    private String dzzzid;
    private String sfycsj;
    private String sdxgsjyy;
    private String isbl;
    private String old_license_type;
    private String old_electronic_license;
    private String typecode;
    private String prod_mode;
    private String jyfs;
    private String preparation_type;
    private String device_type;
    private String business_scope;
    private String warehouse_address;
    private String business_place;
    private String zsname;
    private String qxxxname;
    private String lxr;
    private String complaintphone;
    private String repealdate;
    private String fileupload;
    private String changetext;
    private String validstatus;
    private String workcode;
    private String deactivecause;
    private String logoutdate;
    private String repealcause;
    private String czsjsjc;
    private String czsj;
    private String zjsfzr;
    private String zjsfzrsfz;
    private String fddbrsfz;
    private String logoutcause;
    private String deactivedate;
    private String lxlb;//
    private String isbf;  //是否补发
    private String bfzzwd; //补发纸质文档
    private String bfyy; //补发原因
    private String certczr; //证书操作人
    private String whr; //维护人
    private String whyy;//维护原因








}
