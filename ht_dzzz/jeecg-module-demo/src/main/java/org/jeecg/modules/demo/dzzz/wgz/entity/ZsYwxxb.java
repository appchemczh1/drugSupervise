package org.jeecg.modules.demo.dzzz.wgz.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import org.jeecg.common.aspect.annotation.Dict;
import org.jeecg.modules.demo.dzzz.certinfo.entity.ACertInfo;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @Description: zs_ywxxb
 * @Author: jeecg-boot
 * @Date:   2024-06-27
 * @Version: V1.0
 */
@Data
@TableName(value = "zs_ywxxb")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="zs_ywxxb对象", description="zs_ywxxb")
public class ZsYwxxb extends ACertInfo {

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
    private java.lang.String zslx;
	/**证书编号*/
	@Excel(name = "证书编号", width = 15)
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
	/**发证日期*/
	@Excel(name = "发证日期", width = 15)

    @ApiModelProperty(value = "发证日期")
    private String fzrq;
	/**有效期起*/
	@Excel(name = "有效期起", width = 15)

    @ApiModelProperty(value = "有效期起")
    private String yxqq;
	/**有效期至*/
	@Excel(name = "有效期至", width = 15)

    @ApiModelProperty(value = "有效期至")
    private String yxqz;
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
    /*@TableField(value = "\"cs\"")*/
    private java.lang.String chaosong;
	/**产品*/
    /*@TableField(value = "\"cp\"")*/
	@Excel(name = "产品", width = 15)
    @ApiModelProperty(value = "产品")
    private java.lang.String chanping;
	/**产品类别*/
	@Excel(name = "产品类别", width = 15)
    @ApiModelProperty(value = "产品类别")
    private java.lang.String cplb;
	/**产品明细*/
	@Excel(name = "产品明细", width = 15)
    @ApiModelProperty(value = "产品明细")
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
    private java.lang.String jsly;
	/**盖章生成状态 0同步 2未生成3生成未盖章 4盖章*/
	@Excel(name = "盖章生成状态 0同步 2未生成3生成未盖章 4盖章", width = 15)
    @ApiModelProperty(value = "盖章生成状态 0同步 2未生成3生成未盖章 4盖章")
    @Dict(dicCode = "gzzt")
    private java.lang.String zt;
	/**业务类别*/
	@Excel(name = "业务类别", width = 15)
    @ApiModelProperty(value = "业务类别")
    private java.lang.String ywlb;
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
    private java.lang.String sjtbGspt;
	/**档案系统*/
	@Excel(name = "档案系统", width = 15)
    @ApiModelProperty(value = "档案系统")
    private java.lang.String sjtbDa;
	/**1表示是行政审批推送来的数据*/
	@Excel(name = "1表示是行政审批推送来的数据", width = 15)
    @ApiModelProperty(value = "1表示是行政审批推送来的数据")
    private java.lang.String sjtbXzsp;
	/**国家局数据同步*/
	@Excel(name = "国家局数据同步", width = 15)
    @ApiModelProperty(value = "国家局数据同步")
    private java.lang.String sjtbGj;
	/**sjtbCwxx*/
	@Excel(name = "sjtbCwxx", width = 15)
    @ApiModelProperty(value = "sjtbCwxx")
    private java.lang.String sjtbCwxx;
	/**sjtbGjsj*/
	@Excel(name = "sjtbGjsj", width = 15)
    @ApiModelProperty(value = "sjtbGjsj")
    private java.lang.String sjtbGjsj;
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
	/**二维码路径*/
	@Excel(name = "二维码路径", width = 15)
    @ApiModelProperty(value = "二维码路径")
    private java.lang.String ewmlj;
	/**同步*/
	@Excel(name = "同步", width = 15)
    @ApiModelProperty(value = "同步")
    private java.lang.String sync;
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
	/**证照类型Id*/
	@Excel(name = "证照类型Id", width = 15)
    @ApiModelProperty(value = "证照类型Id")
    private java.lang.String certtypeid;

//    @Excel(name = "证照类型名称", width = 15)
//    private java.lang.String certtypename;
	/**有效状态10核发20变更30换证60证书纠错70数据维护*/
	@Excel(name = "1核发 2换发 3变更 4注销 5补发，6人工维护 7强制维护", width = 15)
    @ApiModelProperty(value = "1核发 2换发 3变更 4注销 5补发，6人工维护 7强制维护")
    private java.lang.String zszt;
	/**证书状态10有效50注销60过期70吊销80撤销99作废*/
	@Excel(name = "证书状态10有效50注销60过期70吊销80撤销98维护99作废", width = 15)
    @ApiModelProperty(value = "证书状态10有效50注销60过期70吊销80撤销98维护99作废")
    private java.lang.String yxzt;
	/**二维码*/
	@Excel(name = "二维码", width = 15)
    @ApiModelProperty(value = "二维码")
    private java.lang.String ewm;
	/**synctime*/
	@Excel(name = "synctime", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "synctime")
    private java.util.Date synctime;

    //证书大类  yp,ylqx,hzp
    private String zsdl;
    //老系统的电子证照标识 初始化使用
    private String oldId;
    //是否系统产生数据
    private String isxt;
    //证书id 关联 子表 操作记录
    private String zsid;
    //维护Id, 对应 维护数据的id
    private String whid;
    //维护操作状态
    @Dict(dicCode = "czzt")
    private String czzt;
    //是否维护中
    private String iswh;
    //盖章时间
    private Date gztime;
    //是否过期 1是 其他否
    /*private String isgq;*/





    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQyid() {
        return qyid;
    }

    public void setQyid(String qyid) {
        this.qyid = qyid;
    }

    public String getZslx() {
        return zslx;
    }

    public void setZslx(String zslx) {
        this.zslx = zslx;
    }

    public String getZsbh() {
        return zsbh;
    }

    public void setZsbh(String zsbh) {
        this.zsbh = zsbh;
    }

    public String getQymc() {
        return qymc;
    }

    public void setQymc(String qymc) {
        this.qymc = qymc;
    }

    public String getShxydm() {
        return shxydm;
    }

    public void setShxydm(String shxydm) {
        this.shxydm = shxydm;
    }

    public String getZcdz() {
        return zcdz;
    }

    public void setZcdz(String zcdz) {
        this.zcdz = zcdz;
    }

    public String getFddbr() {
        return fddbr;
    }

    public void setFddbr(String fddbr) {
        this.fddbr = fddbr;
    }

    public String getQyfzr() {
        return qyfzr;
    }

    public void setQyfzr(String qyfzr) {
        this.qyfzr = qyfzr;
    }

    public String getZlfzr() {
        return zlfzr;
    }

    public void setZlfzr(String zlfzr) {
        this.zlfzr = zlfzr;
    }

    public String getFlm() {
        return flm;
    }

    public void setFlm(String flm) {
        this.flm = flm;
    }

    public String getRcjdgljg() {
        return rcjdgljg;
    }

    public void setRcjdgljg(String rcjdgljg) {
        this.rcjdgljg = rcjdgljg;
    }

    public String getRcjdglry() {
        return rcjdglry;
    }

    public void setRcjdglry(String rcjdglry) {
        this.rcjdglry = rcjdglry;
    }

    public String getScdzhfw() {
        return scdzhfw;
    }

    public void setScdzhfw(String scdzhfw) {
        this.scdzhfw = scdzhfw;
    }

    public String getFzjg() {
        return fzjg;
    }

    public void setFzjg(String fzjg) {
        this.fzjg = fzjg;
    }

    public String getQfr() {
        return qfr;
    }

    public void setQfr(String qfr) {
        this.qfr = qfr;
    }


    public String getScdz() {
        return scdz;
    }

    public void setScdz(String scdz) {
        this.scdz = scdz;
    }

    public String getSlh() {
        return slh;
    }

//

    public String getCzzt() {
        return czzt;
    }

    public void setCzzt(String czzt) {
        this.czzt = czzt;
    }

    public String getIswh() {
        return iswh;
    }

    public void setIswh(String iswh) {
        this.iswh = iswh;
    }

    public void setSlh(String slh) {
        this.slh = slh;
    }

    public String getCkdz() {
        return ckdz;
    }

    public void setCkdz(String ckdz) {
        this.ckdz = ckdz;
    }

    public String getJgjzc() {
        return jgjzc;
    }

    public void setJgjzc(String jgjzc) {
        this.jgjzc = jgjzc;
    }

    public String getFw() {
        return fw;
    }

    public void setFw(String fw) {
        this.fw = fw;
    }

    public String getFwyw() {
        return fwyw;
    }

    public void setFwyw(String fwyw) {
        this.fwyw = fwyw;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getZs() {
        return zs;
    }

    public void setZs(String zs) {
        this.zs = zs;
    }



    public String getCplb() {
        return cplb;
    }

    public void setCplb(String cplb) {
        this.cplb = cplb;
    }

    public String getCpmx() {
        return cpmx;
    }

    public void setCpmx(String cpmx) {
        this.cpmx = cpmx;
    }

    public String getDh() {
        return dh;
    }

    public void setDh(String dh) {
        this.dh = dh;
    }

    public String getCz() {
        return cz;
    }

    public void setCz(String cz) {
        this.cz = cz;
    }

    public String getGuige() {
        return guige;
    }

    public void setGuige(String guige) {
        this.guige = guige;
    }

    public String getJx() {
        return jx;
    }

    public void setJx(String jx) {
        this.jx = jx;
    }

    public String getFj() {
        return fj;
    }

    public void setFj(String fj) {
        this.fj = fj;
    }

    public String getWzym() {
        return wzym;
    }

    public void setWzym(String wzym) {
        this.wzym = wzym;
    }

    public String getJsly() {
        return jsly;
    }

    public void setJsly(String jsly) {
        this.jsly = jsly;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public String getYwlb() {
        return ywlb;
    }

    public void setYwlb(String ywlb) {
        this.ywlb = ywlb;
    }

    public String getBbid() {
        return bbid;
    }

    public void setBbid(String bbid) {
        this.bbid = bbid;
    }

    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

    public String getYlzd1() {
        return ylzd1;
    }

    public void setYlzd1(String ylzd1) {
        this.ylzd1 = ylzd1;
    }

    public String getYlzd2() {
        return ylzd2;
    }

    public void setYlzd2(String ylzd2) {
        this.ylzd2 = ylzd2;
    }

    public String getYlzd3() {
        return ylzd3;
    }

    public void setYlzd3(String ylzd3) {
        this.ylzd3 = ylzd3;
    }

    public String getYlzd4() {
        return ylzd4;
    }

    public void setYlzd4(String ylzd4) {
        this.ylzd4 = ylzd4;
    }

    public String getYlzd5() {
        return ylzd5;
    }

    public void setYlzd5(String ylzd5) {
        this.ylzd5 = ylzd5;
    }

    public String getFzjgid() {
        return fzjgid;
    }

    public void setFzjgid(String fzjgid) {
        this.fzjgid = fzjgid;
    }

    public String getSjtbGspt() {
        return sjtbGspt;
    }

    public void setSjtbGspt(String sjtbGspt) {
        this.sjtbGspt = sjtbGspt;
    }

    public String getSjtbDa() {
        return sjtbDa;
    }

    public void setSjtbDa(String sjtbDa) {
        this.sjtbDa = sjtbDa;
    }

    public String getSjtbXzsp() {
        return sjtbXzsp;
    }

    public void setSjtbXzsp(String sjtbXzsp) {
        this.sjtbXzsp = sjtbXzsp;
    }

    public String getSjtbGj() {
        return sjtbGj;
    }

    public void setSjtbGj(String sjtbGj) {
        this.sjtbGj = sjtbGj;
    }

    public String getSjtbCwxx() {
        return sjtbCwxx;
    }

    public void setSjtbCwxx(String sjtbCwxx) {
        this.sjtbCwxx = sjtbCwxx;
    }

    public String getSjtbGjsj() {
        return sjtbGjsj;
    }

    public void setSjtbGjsj(String sjtbGjsj) {
        this.sjtbGjsj = sjtbGjsj;
    }

    public String getYlzd6() {
        return ylzd6;
    }

    public void setYlzd6(String ylzd6) {
        this.ylzd6 = ylzd6;
    }

    public String getYlzd7() {
        return ylzd7;
    }

    public void setYlzd7(String ylzd7) {
        this.ylzd7 = ylzd7;
    }

    public String getYlzd8() {
        return ylzd8;
    }

    public void setYlzd8(String ylzd8) {
        this.ylzd8 = ylzd8;
    }

    public String getYlzd9() {
        return ylzd9;
    }

    public void setYlzd9(String ylzd9) {
        this.ylzd9 = ylzd9;
    }

    public String getYlzd10() {
        return ylzd10;
    }

    public void setYlzd10(String ylzd10) {
        this.ylzd10 = ylzd10;
    }

    public String getYlzd11() {
        return ylzd11;
    }

    public void setYlzd11(String ylzd11) {
        this.ylzd11 = ylzd11;
    }

    public String getYlzd12() {
        return ylzd12;
    }

    public void setYlzd12(String ylzd12) {
        this.ylzd12 = ylzd12;
    }

    public String getYlzd13() {
        return ylzd13;
    }

    public void setYlzd13(String ylzd13) {
        this.ylzd13 = ylzd13;
    }

    public String getYlzd14() {
        return ylzd14;
    }

    public void setYlzd14(String ylzd14) {
        this.ylzd14 = ylzd14;
    }

    public String getYlzd15() {
        return ylzd15;
    }

    public void setYlzd15(String ylzd15) {
        this.ylzd15 = ylzd15;
    }

    public String getYlzd16() {
        return ylzd16;
    }

    public void setYlzd16(String ylzd16) {
        this.ylzd16 = ylzd16;
    }

    public String getYlzd17() {
        return ylzd17;
    }

    public void setYlzd17(String ylzd17) {
        this.ylzd17 = ylzd17;
    }

    public String getYlzd18() {
        return ylzd18;
    }

    public void setYlzd18(String ylzd18) {
        this.ylzd18 = ylzd18;
    }

    public String getYlzd19() {
        return ylzd19;
    }

    public void setYlzd19(String ylzd19) {
        this.ylzd19 = ylzd19;
    }

    public String getYlzd20() {
        return ylzd20;
    }

    public void setYlzd20(String ylzd20) {
        this.ylzd20 = ylzd20;
    }

    public String getYlzd21() {
        return ylzd21;
    }

    public void setYlzd21(String ylzd21) {
        this.ylzd21 = ylzd21;
    }

    public String getYlzd22() {
        return ylzd22;
    }

    public void setYlzd22(String ylzd22) {
        this.ylzd22 = ylzd22;
    }

    public String getYlzd23() {
        return ylzd23;
    }

    public void setYlzd23(String ylzd23) {
        this.ylzd23 = ylzd23;
    }

    public String getYlzd24() {
        return ylzd24;
    }

    public void setYlzd24(String ylzd24) {
        this.ylzd24 = ylzd24;
    }

    public String getYlzd25() {
        return ylzd25;
    }

    public void setYlzd25(String ylzd25) {
        this.ylzd25 = ylzd25;
    }

    public String getYlzd26() {
        return ylzd26;
    }

    public void setYlzd26(String ylzd26) {
        this.ylzd26 = ylzd26;
    }

    public String getYlzd27() {
        return ylzd27;
    }

    public void setYlzd27(String ylzd27) {
        this.ylzd27 = ylzd27;
    }

    public String getYlzd28() {
        return ylzd28;
    }

    public void setYlzd28(String ylzd28) {
        this.ylzd28 = ylzd28;
    }

    public String getYlzd29() {
        return ylzd29;
    }

    public void setYlzd29(String ylzd29) {
        this.ylzd29 = ylzd29;
    }

    public String getYlzd30() {
        return ylzd30;
    }

    public void setYlzd30(String ylzd30) {
        this.ylzd30 = ylzd30;
    }

    public String getYlzd31() {
        return ylzd31;
    }

    public void setYlzd31(String ylzd31) {
        this.ylzd31 = ylzd31;
    }

    public String getYlzd32() {
        return ylzd32;
    }

    public void setYlzd32(String ylzd32) {
        this.ylzd32 = ylzd32;
    }

    public String getYlzd33() {
        return ylzd33;
    }

    public void setYlzd33(String ylzd33) {
        this.ylzd33 = ylzd33;
    }

    public String getYlzd34() {
        return ylzd34;
    }

    public void setYlzd34(String ylzd34) {
        this.ylzd34 = ylzd34;
    }

    public String getYlzd35() {
        return ylzd35;
    }

    public void setYlzd35(String ylzd35) {
        this.ylzd35 = ylzd35;
    }

    public String getYlzd36() {
        return ylzd36;
    }

    public void setYlzd36(String ylzd36) {
        this.ylzd36 = ylzd36;
    }

    public String getYlzd37() {
        return ylzd37;
    }

    public void setYlzd37(String ylzd37) {
        this.ylzd37 = ylzd37;
    }

    public String getYlzd38() {
        return ylzd38;
    }

    public void setYlzd38(String ylzd38) {
        this.ylzd38 = ylzd38;
    }

    public String getYlzd39() {
        return ylzd39;
    }

    public void setYlzd39(String ylzd39) {
        this.ylzd39 = ylzd39;
    }

    public String getYlzd40() {
        return ylzd40;
    }

    public void setYlzd40(String ylzd40) {
        this.ylzd40 = ylzd40;
    }

    public String getEwmlj() {
        return ewmlj;
    }

    public void setEwmlj(String ewmlj) {
        this.ewmlj = ewmlj;
    }

    public String getSync() {
        return sync;
    }

    public void setSync(String sync) {
        this.sync = sync;
    }

    public String getGlzdb() {
        return glzdb;
    }

    public void setGlzdb(String glzdb) {
        this.glzdb = glzdb;
    }

    public String getQylx() {
        return qylx;
    }

    public void setQylx(String qylx) {
        this.qylx = qylx;
    }

    public String getLxryx() {
        return lxryx;
    }

    public void setLxryx(String lxryx) {
        this.lxryx = lxryx;
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    public String getTypelevel() {
        return typelevel;
    }

    public void setTypelevel(String typelevel) {
        this.typelevel = typelevel;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCerttypeid() {
        return certtypeid;
    }

    public void setCerttypeid(String certtypeid) {
        this.certtypeid = certtypeid;
    }

    public String getZszt() {
        return zszt;
    }

    public void setZszt(String zszt) {
        this.zszt = zszt;
    }

    public String getYxzt() {
        return yxzt;
    }

    public void setYxzt(String yxzt) {
        this.yxzt = yxzt;
    }

    public String getEwm() {
        return ewm;
    }

    public void setEwm(String ewm) {
        this.ewm = ewm;
    }

    public Date getSynctime() {
        return synctime;
    }

    public void setSynctime(Date synctime) {
        this.synctime = synctime;
    }

    public String getZsdl() {
        return zsdl;
    }

    public void setZsdl(String zsdl) {
        this.zsdl = zsdl;
    }

    public String getZsid() {
        return zsid;
    }

    public void setZsid(String zsid) {
        this.zsid = zsid;
    }

    public String getIsxt() {
        return isxt;
    }

    public void setIsxt(String isxt) {
        this.isxt = isxt;
    }

    public String getWhid() {
        return whid;
    }

    public void setWhid(String isxt) {
        this.whid = isxt;
    }

	public String getCertTypeId() {
		return getCerttypeid();
	}

}
