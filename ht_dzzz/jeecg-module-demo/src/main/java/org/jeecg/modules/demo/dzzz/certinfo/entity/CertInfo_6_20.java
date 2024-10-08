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
 * @Description: cert_info_new
 * @Author: jeecg-boot
 * @Date:   2024-06-15
 * @Version: V1.0
 */
@Data
@TableName("cert_info")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="cert_info对象", description="cert_info_new")
public class CertInfo_6_20 implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键id")
    private java.lang.String id;
	/**企业id*/
	@Excel(name = "企业id", width = 15)
    @ApiModelProperty(value = "企业id")
    private java.lang.String qyid;
	/**证书类型*/
	@Excel(name = "证书类型", width = 15)
    @ApiModelProperty(value = "证书类型")
    private java.lang.Integer zslx;
	/**证书编号*/
	@Excel(name = "证书编号", width = 15)
    @ApiModelProperty(value = "证书编号")
    private java.lang.String zsbh;
	/**企业名称*/
	@Excel(name = "企业名称", width = 15)
    @ApiModelProperty(value = "企业名称")
    private java.lang.String qymc;
	/**社会信用代码*/
	@Excel(name = "社会信用代码", width = 15)
    @ApiModelProperty(value = "社会信用代码")
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
	/**日常监督管理机构*/
	@Excel(name = "日常监督管理机构", width = 15)
    @ApiModelProperty(value = "日常监督管理机构")
    private java.lang.String rcjdgljg;
	/**日常监督管理人员*/
	@Excel(name = "日常监督管理人员", width = 15)
    @ApiModelProperty(value = "日常监督管理人员")
    private java.lang.String rcjdglry;
	/**生产地址范围*/
	@Excel(name = "生产地址范围", width = 15)
    @ApiModelProperty(value = "生产地址范围")
    private java.lang.String scdzhfw;
	/**发证机关*/
	@Excel(name = "发证机关", width = 15)
    @ApiModelProperty(value = "发证机关")
    private java.lang.String fzjg;
	/**签发人*/
	@Excel(name = "签发人", width = 15)
    @ApiModelProperty(value = "签发人")
    private java.lang.String qfr;
	/**fzrq*/
	@Excel(name = "fzrq", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "fzrq")
    private java.util.Date fzrq;
	/**yxqq*/
	@Excel(name = "yxqq", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "yxqq")
    private java.util.Date yxqq;
	/**yxqz*/
	@Excel(name = "yxqz", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "yxqz")
    private java.util.Date yxqz;
	/**scdz*/
	@Excel(name = "scdz", width = 15)
    @ApiModelProperty(value = "scdz")
    private java.lang.String scdz;
	/**受理号*/
	@Excel(name = "受理号", width = 15)
    @ApiModelProperty(value = "受理号")
    private java.lang.String slh;
	/**仓库地址*/
	@Excel(name = "仓库地址", width = 15)
    @ApiModelProperty(value = "仓库地址")
    private java.lang.String ckdz;
	/**your_comment_here*/
	@Excel(name = "your_comment_here", width = 15)
    @ApiModelProperty(value = "your_comment_here")
    private java.lang.String jgjzc;
	/**范围*/
	@Excel(name = "范围", width = 15)
    @ApiModelProperty(value = "范围")
    private java.lang.String fw;
	/**范围副本*/
	@Excel(name = "范围副本", width = 15)
    @ApiModelProperty(value = "范围副本")
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
    private java.lang.String chanping;
	/**产品类别*/
	@Excel(name = "产品类别", width = 15)
    @ApiModelProperty(value = "产品类别")
    private java.lang.String cplb;
	/**cpmx*/
	@Excel(name = "cpmx", width = 15)
    @ApiModelProperty(value = "cpmx")
    private java.lang.String cpmx;
	/**电话*/
	@Excel(name = "电话", width = 15)
    @ApiModelProperty(value = "电话")
    private java.lang.String dh;
	/**传真*/
	@Excel(name = "传真", width = 15)
    @ApiModelProperty(value = "传真")
    private java.lang.String cz;
	/**规格*/
	@Excel(name = "规格", width = 15)
    @ApiModelProperty(value = "规格")
    private java.lang.String guige;
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
    private java.lang.Integer jsly;
	/**盖章生成状态 0同步 2未生成3生成未盖章 4盖章*/
	@Excel(name = "盖章生成状态 0同步 2未生成3生成未盖章 4盖章", width = 15)
    @ApiModelProperty(value = "盖章生成状态 0同步 2未生成3生成未盖章 4盖章")
    private java.lang.Integer zt;
	/**业务类别*/
	@Excel(name = "业务类别", width = 15)
    @ApiModelProperty(value = "业务类别")
    private java.lang.Integer ywlb;
	/**版本id*/
	@Excel(name = "版本id", width = 15)
    @ApiModelProperty(value = "版本id")
    private java.lang.String bbid;
	/**FZJGID*/
	@Excel(name = "FZJGID", width = 15)
    @ApiModelProperty(value = "FZJGID")
    private java.lang.String mbid;
	/**ylzd1*/
	@Excel(name = "ylzd1", width = 15)
    @ApiModelProperty(value = "ylzd1")
    private java.lang.String ylzd1;
	/**ylzd2*/
	@Excel(name = "ylzd2", width = 15)
    @ApiModelProperty(value = "ylzd2")
    private java.lang.String ylzd2;
	/**ylzd3*/
	@Excel(name = "ylzd3", width = 15)
    @ApiModelProperty(value = "ylzd3")
    private java.lang.String ylzd3;
	/**ylzd4*/
	@Excel(name = "ylzd4", width = 15)
    @ApiModelProperty(value = "ylzd4")
    private java.lang.String ylzd4;
	/**ylzd5*/
	@Excel(name = "ylzd5", width = 15)
    @ApiModelProperty(value = "ylzd5")
    private java.lang.String ylzd5;
	/**发证机关id*/
	@Excel(name = "发证机关id", width = 15)
    @ApiModelProperty(value = "发证机关id")
    private java.lang.String fzjgid;
	/**公示平台*/
	@Excel(name = "公示平台", width = 15)
    @ApiModelProperty(value = "公示平台")
    private java.lang.Integer sjtbGspt;
	/**档案系统*/
	@Excel(name = "档案系统", width = 15)
    @ApiModelProperty(value = "档案系统")
    private java.lang.Integer sjtbDa;
	/**1表示是行政审批推送来的数据*/
	@Excel(name = "1表示是行政审批推送来的数据", width = 15)
    @ApiModelProperty(value = "1表示是行政审批推送来的数据")
    private java.lang.Integer sjtbXzsp;
	/**sjtbGj*/
	@Excel(name = "sjtbGj", width = 15)
    @ApiModelProperty(value = "sjtbGj")
    private java.lang.Integer sjtbGj;
	/**sjtbCwxx*/
	@Excel(name = "sjtbCwxx", width = 15)
    @ApiModelProperty(value = "sjtbCwxx")
    private java.lang.String sjtbCwxx;
	/**sjtbGjsj*/
	@Excel(name = "sjtbGjsj", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "sjtbGjsj")
    private java.util.Date sjtbGjsj;
	/**ylzd6*/
	@Excel(name = "ylzd6", width = 15)
    @ApiModelProperty(value = "ylzd6")
    private java.lang.String ylzd6;
	/**ylzd7*/
	@Excel(name = "ylzd7", width = 15)
    @ApiModelProperty(value = "ylzd7")
    private java.lang.String ylzd7;
	/**ylzd8*/
	@Excel(name = "ylzd8", width = 15)
    @ApiModelProperty(value = "ylzd8")
    private java.lang.String ylzd8;
	/**ylzd9*/
	@Excel(name = "ylzd9", width = 15)
    @ApiModelProperty(value = "ylzd9")
    private java.lang.String ylzd9;
	/**ylzd10*/
	@Excel(name = "ylzd10", width = 15)
    @ApiModelProperty(value = "ylzd10")
    private java.lang.String ylzd10;
	/**ylzd11*/
	@Excel(name = "ylzd11", width = 15)
    @ApiModelProperty(value = "ylzd11")
    private java.lang.String ylzd11;
	/**ylzd12*/
	@Excel(name = "ylzd12", width = 15)
    @ApiModelProperty(value = "ylzd12")
    private java.lang.String ylzd12;
	/**ylzd13*/
	@Excel(name = "ylzd13", width = 15)
    @ApiModelProperty(value = "ylzd13")
    private java.lang.String ylzd13;
	/**ylzd14*/
	@Excel(name = "ylzd14", width = 15)
    @ApiModelProperty(value = "ylzd14")
    private java.lang.String ylzd14;
	/**ylzd15*/
	@Excel(name = "ylzd15", width = 15)
    @ApiModelProperty(value = "ylzd15")
    private java.lang.String ylzd15;
	/**ylzd16*/
	@Excel(name = "ylzd16", width = 15)
    @ApiModelProperty(value = "ylzd16")
    private java.lang.String ylzd16;
	/**ylzd17*/
	@Excel(name = "ylzd17", width = 15)
    @ApiModelProperty(value = "ylzd17")
    private java.lang.String ylzd17;
	/**ylzd18*/
	@Excel(name = "ylzd18", width = 15)
    @ApiModelProperty(value = "ylzd18")
    private java.lang.String ylzd18;
	/**ylzd19*/
	@Excel(name = "ylzd19", width = 15)
    @ApiModelProperty(value = "ylzd19")
    private java.lang.String ylzd19;
	/**ylzd20*/
	@Excel(name = "ylzd20", width = 15)
    @ApiModelProperty(value = "ylzd20")
    private java.lang.String ylzd20;
	/**ylzd21*/
	@Excel(name = "ylzd21", width = 15)
    @ApiModelProperty(value = "ylzd21")
    private java.lang.String ylzd21;
	/**ylzd22*/
	@Excel(name = "ylzd22", width = 15)
    @ApiModelProperty(value = "ylzd22")
    private java.lang.String ylzd22;
	/**ylzd23*/
	@Excel(name = "ylzd23", width = 15)
    @ApiModelProperty(value = "ylzd23")
    private java.lang.String ylzd23;
	/**ylzd24*/
	@Excel(name = "ylzd24", width = 15)
    @ApiModelProperty(value = "ylzd24")
    private java.lang.String ylzd24;
	/**ylzd25*/
	@Excel(name = "ylzd25", width = 15)
    @ApiModelProperty(value = "ylzd25")
    private java.lang.String ylzd25;
	/**ylzd26*/
	@Excel(name = "ylzd26", width = 15)
    @ApiModelProperty(value = "ylzd26")
    private java.lang.String ylzd26;
	/**ylzd27*/
	@Excel(name = "ylzd27", width = 15)
    @ApiModelProperty(value = "ylzd27")
    private java.lang.String ylzd27;
	/**ylzd28*/
	@Excel(name = "ylzd28", width = 15)
    @ApiModelProperty(value = "ylzd28")
    private java.lang.String ylzd28;
	/**ylzd29*/
	@Excel(name = "ylzd29", width = 15)
    @ApiModelProperty(value = "ylzd29")
    private java.lang.String ylzd29;
	/**ylzd30*/
	@Excel(name = "ylzd30", width = 15)
    @ApiModelProperty(value = "ylzd30")
    private java.lang.String ylzd30;
	/**ylzd31*/
	@Excel(name = "ylzd31", width = 15)
    @ApiModelProperty(value = "ylzd31")
    private java.lang.String ylzd31;
	/**ylzd32*/
	@Excel(name = "ylzd32", width = 15)
    @ApiModelProperty(value = "ylzd32")
    private java.lang.String ylzd32;
	/**ylzd33*/
	@Excel(name = "ylzd33", width = 15)
    @ApiModelProperty(value = "ylzd33")
    private java.lang.String ylzd33;
	/**ylzd34*/
	@Excel(name = "ylzd34", width = 15)
    @ApiModelProperty(value = "ylzd34")
    private java.lang.String ylzd34;
	/**ylzd35*/
	@Excel(name = "ylzd35", width = 15)
    @ApiModelProperty(value = "ylzd35")
    private java.lang.String ylzd35;
	/**ylzd36*/
	@Excel(name = "ylzd36", width = 15)
    @ApiModelProperty(value = "ylzd36")
    private java.lang.String ylzd36;
	/**ylzd37*/
	@Excel(name = "ylzd37", width = 15)
    @ApiModelProperty(value = "ylzd37")
    private java.lang.String ylzd37;
	/**ylzd38*/
	@Excel(name = "ylzd38", width = 15)
    @ApiModelProperty(value = "ylzd38")
    private java.lang.String ylzd38;
	/**ylzd39*/
	@Excel(name = "ylzd39", width = 15)
    @ApiModelProperty(value = "ylzd39")
    private java.lang.String ylzd39;
	/**ylzd40*/
	@Excel(name = "ylzd40", width = 15)
    @ApiModelProperty(value = "ylzd40")
    private java.lang.String ylzd40;
	/**二维码*/
	@Excel(name = "二维码", width = 15)
    private transient java.lang.String ewmString;

    private byte[] ewm;

    public byte[] getEwm(){
        if(ewmString==null){
            return null;
        }
        try {
            return ewmString.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getEwmString(){
        if(ewm==null || ewm.length==0){
            return "";
        }
        try {
            return new String(ewm,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
	/**二维码路径*/
	@Excel(name = "二维码路径", width = 15)
    @ApiModelProperty(value = "二维码路径")
    private java.lang.String ewmlj;
	/**同步*/
	@Excel(name = "同步", width = 15)
    @ApiModelProperty(value = "同步")
    private java.lang.Integer sync;
	/**模板id*/
	@Excel(name = "模板id", width = 15)
    @ApiModelProperty(value = "模板id")
    private java.lang.String glzdb;
	/**企业类型*/
	@Excel(name = "企业类型", width = 15)
    @ApiModelProperty(value = "企业类型")
    private java.lang.String qylx;
	/**联系人邮箱*/
	@Excel(name = "联系人邮箱", width = 15)
    @ApiModelProperty(value = "联系人邮箱")
    private java.lang.String lxryx;
	/**联系电话*/
	@Excel(name = "联系电话", width = 15)
    @ApiModelProperty(value = "联系电话")
    private java.lang.String lxdh;
	/**类型级别*/
	@Excel(name = "类型级别", width = 15)
    @ApiModelProperty(value = "类型级别")
    private java.lang.String typelevel;
	/**移动电话*/
	@Excel(name = "移动电话", width = 15)
    @ApiModelProperty(value = "移动电话")
    private java.lang.String mobile;
	/**OLD_ID*/
	@Excel(name = "OLD_ID", width = 15)
    @ApiModelProperty(value = "OLD_ID")
    private java.lang.String oldId;
	/**证照类型Id*/
	@Excel(name = "证照类型Id", width = 15)
    @ApiModelProperty(value = "证照类型Id")
    private java.lang.String certtypeid;
	/**电子证书（多证书;分割）*/
	@Excel(name = "电子证书（多证书;分割）", width = 15)
    @ApiModelProperty(value = "电子证书（多证书;分割）")
    private java.lang.String dzzsId;
	/**关联数据ID*/
	@Excel(name = "关联数据ID", width = 15)
    @ApiModelProperty(value = "关联数据ID")
    private java.lang.String glsjId;
	/**区划代码*/
	@Excel(name = "区划代码", width = 15)
    @ApiModelProperty(value = "区划代码")
    private java.lang.String areacode;
	/**区划名称*/
	@Excel(name = "区划名称", width = 15)
    @ApiModelProperty(value = "区划名称")
    private java.lang.String areaname;
	/**签发机构id*/
	@Excel(name = "签发机构id", width = 15)
    @ApiModelProperty(value = "签发机构id")
    private java.lang.String qfjgid;
	/**有效状态10核发20变更30换证60证书纠错70数据维护*/
	@Excel(name = "有效状态10核发20变更30换证60证书纠错70数据维护", width = 15)
    @ApiModelProperty(value = "有效状态10核发20变更30换证60证书纠错70数据维护")
    private java.lang.String zszt;
	/**使用状态（0草稿，1申请；2完成；3作废）*/
	@Excel(name = "使用状态（0草稿，1申请；2完成；3作废）", width = 15)
    @ApiModelProperty(value = "使用状态（0草稿，1申请；2完成；3作废）")
    private java.lang.String usezt;
	/**是否合格*/
	@Excel(name = "是否合格", width = 15)
    @ApiModelProperty(value = "是否合格")
    private java.lang.String ishg;
	/**二类医疗器械注册证当前生效数据标记*/
	@Excel(name = "二类医疗器械注册证当前生效数据标记", width = 15)
    @ApiModelProperty(value = "二类医疗器械注册证当前生效数据标记")
    private java.lang.String elyljxsxNum;
	/**自动盖章id*/
	@Excel(name = "自动盖章id", width = 15)
    @ApiModelProperty(value = "自动盖章id")
    private java.lang.String zdgzid;
	/**是否为医疗器械注册人、备案人和经营企业专门提供运输、贮存服务*/
	@Excel(name = "是否为医疗器械注册人、备案人和经营企业专门提供运输、贮存服务", width = 15)
    @ApiModelProperty(value = "是否为医疗器械注册人、备案人和经营企业专门提供运输、贮存服务")
    private java.lang.String isYscc;
	/**事项编码*/
	@Excel(name = "事项编码", width = 15)
    @ApiModelProperty(value = "事项编码")
    private java.lang.String sxbm;
	/**办件编号*/
	@Excel(name = "办件编号", width = 15)
    @ApiModelProperty(value = "办件编号")
    private java.lang.String projectNo;
	/**电子证照标识*/
	@Excel(name = "电子证照标识", width = 15)
    @ApiModelProperty(value = "电子证照标识")
    private java.lang.String dzzzid;
	/**是否异常数据1是0否,市局初始化很多异常数据*/
	@Excel(name = "是否异常数据1是0否,市局初始化很多异常数据", width = 15)
    @ApiModelProperty(value = "是否异常数据1是0否,市局初始化很多异常数据")
    private java.lang.String sfycsj;
	/**手动修改数据原因*/
	@Excel(name = "手动修改数据原因", width = 15)
    @ApiModelProperty(value = "手动修改数据原因")
    private java.lang.String sdxgsjyy;
	/**是否补录*/
	@Excel(name = "是否补录", width = 15)
    @ApiModelProperty(value = "是否补录")
    private java.lang.String isbl;
	/**老电子证照标识*/
	@Excel(name = "老电子证照标识", width = 15)
    @ApiModelProperty(value = "老电子证照标识")
    private java.lang.String oldDzzzid;
	/**证书名称*/
	@Excel(name = "证书名称", width = 15)
    @ApiModelProperty(value = "证书名称")
    private java.lang.String zsname;
	/**区划地址详情*/
	@Excel(name = "区划地址详情", width = 15)
    @ApiModelProperty(value = "区划地址详情")
    private java.lang.String areanamedetail;
	/**证书状态10有效50注销60过期70吊销80撤销99作废*/
	@Excel(name = "证书状态10有效50注销60过期70吊销80撤销99作废", width = 15)
    @ApiModelProperty(value = "证书状态10有效50注销60过期70吊销80撤销99作废")
    private java.lang.String yxzt;
	/**投诉举报电话*/
	@Excel(name = "投诉举报电话", width = 15)
    @ApiModelProperty(value = "投诉举报电话")
    private java.lang.String complaintphone;
	/**补发资质文档（附件）*/
	@Excel(name = "补发资质文档（附件）", width = 15)
    @ApiModelProperty(value = "补发资质文档（附件）")
    private java.lang.String bfzzwd;
	/**发证机关id*/
	@Excel(name = "发证机关id", width = 15)
    @ApiModelProperty(value = "发证机关id")
    private java.lang.String bfyy;
	/**补发人*/
	@Excel(name = "补发人", width = 15)
    @ApiModelProperty(value = "补发人")
    private java.lang.String bfr;
	/**维护人*/
	@Excel(name = "维护人", width = 15)
    @ApiModelProperty(value = "维护人")
    private java.lang.String whr;
	/**维护原因*/
	@Excel(name = "维护原因", width = 15)
    @ApiModelProperty(value = "维护原因")
    private java.lang.String whyy;
	/**联系人*/
	@Excel(name = "联系人", width = 15)
    @ApiModelProperty(value = "联系人")
    private java.lang.String lxr;
	/**注销人*/
	@Excel(name = "注销人", width = 15)
    @ApiModelProperty(value = "注销人")
    private java.lang.String zxr;
	/**注销原因*/
	@Excel(name = "注销原因", width = 15)
    @ApiModelProperty(value = "注销原因")
    private java.lang.String zxyy;
	/**sjtbScj*/
	@Excel(name = "sjtbScj", width = 15)
    @ApiModelProperty(value = "sjtbScj")
    private java.lang.String sjtbScj;
	/**市场局同步时间*/
	@Excel(name = "市场局同步时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "市场局同步时间")
    private java.util.Date tbsjScj;
	/**行政审批同步时间*/
	@Excel(name = "行政审批同步时间", width = 15)
    @ApiModelProperty(value = "行政审批同步时间")
    private java.lang.String tbsjXzsp;
    private java.lang.String zsdl;
    private java.lang.String bgr;
    private java.lang.String bgyy;
}
