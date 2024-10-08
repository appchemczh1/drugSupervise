package org.jeecg.modules.demo.dzzz.sczz;


import lombok.Data;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertSubTable;
import org.jeecg.modules.demo.dzzz.certinfo.vo.CertInfoPage;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: 刘枫
 * @date: 2021-1-26
 */
@Data
public class ZsDto extends CertInfoPage {
    /*发证日期年月日*/
    private String fzrq_y;
    private String fzrq_m;
    private String fzrq_d;
    
    /*有效期起年月日*/
    private String yxqq_y;
    private String yxqq_m;
    private String yxqq_d;
    
    /*有效期止年月日*/
    private String yxqz_y;
    private String yxqz_m;
    private String yxqz_d;
    private String bgnr;
    private String cpmc;

    private List<Map<String,Object>> modifyinfoList;
    
    /*变更字段*/
    private String modifyinfo1;
    private String modifyinfo2;
    private String modifyinfo3;
    private String modifyinfo4;
    private String modifyinfo5;
    private String modifyinfo6;
    private String modifyinfo7;
    private String modifyinfo8;
    private String modifyinfo9;
    private String modifyinfo10;
    private String modifyinfo11;
    private String modifyinfo12;
    private String modifyinfo13;
    private String modifyinfo14;
    private String modifyinfo15;
    private String modifyinfo16;
    private String modifyinfo17;
    private String modifyinfo18;
    private String modifyinfo19;
    private String modifyinfo20;
    private String modifyinfo21;
    private String modifyinfo22;
    private String modifyinfo23;
    private String modifyinfo24;
    private String modifyinfo25;
    private String modifyinfo26;
    private String modifyinfo27;
    private String modifyinfo28;
    private String modifyinfo29;
    private String modifyinfo30;
    private String modifyinfo31;
    private String modifyinfo32;
    private String modifyinfo33;
    private String modifyinfo34;
    private String modifyinfo35;
    private String modifyinfo36;
    private String modifyinfo37;
    private String modifyinfo38;
    private String modifyinfo39;
    private String modifyinfo40;
    private String modifyinfo41;
    private String modifyinfo42;
    private String modifyinfo43;
    private String modifyinfo44;
    private String modifyinfo45;
    private String modifyinfo46;
    private String modifyinfo47;
    private String modifyinfo48;
    private String modifyinfo49;
    private String modifyinfo50;
    private String modifyinfo51;
    private String modifyinfo52;
    private String modifyinfo53;
    private String modifyinfo54;
    private String modifyinfo55;
    private String modifyinfo56;
    private String modifyinfo57;
    private String modifyinfo58;
    private String modifyinfo59;
    private String modifyinfo60;
    private String modifyinfo61;
    private String modifyinfo62;
    private String modifyinfo63;
    private String modifyinfo64;
    private String modifyinfo65;
    private String modifyinfo66;
    private String modifyinfo67;
    private String modifyinfo68;
    private String modifyinfo69;
    private String modifyinfo70;




    
    /*跟变更字段对应的变更时间*/
    private Date modifytime1;
    private Date modifytime2;
    private Date modifytime3;
    private Date modifytime4;
    private Date modifytime5;
    private Date modifytime6;
    private Date modifytime7;
    private Date modifytime8;
    private Date modifytime9;
    private Date modifytime10;
    private Date modifytime11;
    private Date modifytime12;
    private Date modifytime13;
    private Date modifytime14;
    private Date modifytime15;
    private Date modifytime16;
    private Date modifytime17;
    private Date modifytime18;
    private Date modifytime19;
    private Date modifytime20;
    private Date modifytime21;
    private Date modifytime22;
    private Date modifytime23;
    private Date modifytime24;
    private Date modifytime25;
    private Date modifytime26;
    private Date modifytime27;
    private Date modifytime28;
    private Date modifytime29;
    private Date modifytime30;
    private Date modifytime31;
    private Date modifytime32;
    private Date modifytime33;
    private Date modifytime34;
    private Date modifytime35;
    private Date modifytime36;
    private Date modifytime37;
    private Date modifytime38;
    private Date modifytime39;
    private Date modifytime40;
    private Date modifytime41;
    private Date modifytime42;
    private Date modifytime43;
    private Date modifytime44;
    private Date modifytime45;
    private Date modifytime46;
    private Date modifytime47;
    private Date modifytime48;
    private Date modifytime49;
    private Date modifytime50;
    private Date modifytime51;
    private Date modifytime52;
    private Date modifytime53;
    private Date modifytime54;
    private Date modifytime55;
    private Date modifytime56;
    private Date modifytime57;
    private Date modifytime58;
    private Date modifytime59;
    private Date modifytime60;
    private Date modifytime61;
    private Date modifytime62;
    private Date modifytime63;
    private Date modifytime64;
    private Date modifytime65;
    private Date modifytime66;
    private Date modifytime67;
    private Date modifytime68;
    private Date modifytime69;
    private Date modifytime70;





   /* *//**
     * 第一类医疗器械生产备案凭证
     *//*
    private List<TJcZsDylylqxscbapzZb> ylqxscbaList;
    
    *//**
     * 第一类医疗器械生产委托备案
     *//*
    private List<TJcZsDylylqxscwtbaZb> ylqxscwtbaList;
    
    *//**
     * 非药品生产企业麻醉药品精神药品购用证明
     *//*
    private List<TJcZsMzypjsypgyzmZb> mzypjsypgyList;
    *//**
     * 特殊药品名称购用证明
     *//*
    private List<TJcZsTsypmcgyzmZb> tsypmcgyzmList;
    private List<TJcZsYlqxscbaZb> qxsclist;
    private List<TJcZsYlqxwtscbaZb> wtqxsclist;
    private List<TJcZsMzyphjsypddscpjZb> mzyphjsypddscpj;
    private List<TJcZsYlqxlcsybaZb> ylqxlcsyba;
    private List<TJcZsYpckzxzZb> ypckzxz;
    private List<TJcZsYpckxszmZb> ypckxszm;
    private List<TJcZsCkomylyZb> ckomyly;
    private List<TJcZsYlqxcpckxszmZb> ylqxcpckxszm;
    private List<TJcZsYpscxkWt> ypscfy1;
    private List<TJcZsYpscxkWt> ypscfy2;*/
    private String ypckxszmgjzw;
    private String ypckxszmgjyw;
    
    
    private String qrcode;
    
    private List<String> fjPath = new ArrayList<>();
    private String zsbh;
    private String zcdz;
    private String shxydm;
    private String scdz;
    private String bz;
    private String ylzd1;
    private String ylzd6;
    private String ylzd36;
    private String ylzd37;
    private String cplb;
    private String cp;
    private String qymc;
    private String fzjg;
    private String fzrq;
    private String ylzd38;
    private String cardid;
    private String address;
    private String proaddr;
    private String corpname;
    private String chargename;
    private String range;
    private String name;
    private String fddbr;
    private String qyfzr;
    private String ylzd2;
    private String fw;
    private String zs;
    private String shxmdm;
    private String makedept;
    private String makedate;
    private String ylzd4;
    private String dh;
    private String ylzd3;
    private String ylzd15;
    private String ylzd16;
    private String ylzd13;
    private String ylzd12;
    private String ylzd10;
    private String ylzd9;
    private String ylzd11;
    private String ylzd8;
    private String ylzd7;
    private String ylzd5;
    private String ylzd14;
    private String flm;
    private String yxqz;
    private String qyid;
    private String zlfzr;
    private String rcjdgljg;
    private String monitor_person;
    private String qfr;
    private String fwyw;
    private String addrstorge;
    private String ylzd22;
    private String yxqq;
    private String ylzd17;
    private String bgcs;
    private String ylzd30;
    private String pjh;
    private String gg;
    private String ylzd19;
    private String rcjdglry;
    private String ylzd35;
    private String ckdz;
    private String jx;
    private String lxrdzyx;
    private String ylzd23;
    private String ylzd27;
    private String fzjgid;
    private String ylzd18;
    private String typelevel;
    private String monitor_org;
    private String signed_person;
    private String admtimeto;
    private String rangeid;
    private String spjyztyt;
    private String ylzd33;
    private String ylzd26;
    private String frzjhm;
    private String ylzd20;
    private String authorg;
    private String quaname;
    private String admtimefrom;
    private String addresseng;
    private String rangeng;
    private String wzym;
    private String accpid;
    private String cardname;
    private String cs;
    private String cz;
    private String ylzd21;
    private String ylzd28;
    private String ylzd31;
    private String ylzd32;
    private String ylzd24;
    private String ylzd25;
    private String ylzd29;
    private String qylx;
    private String glzdb;
    private String lxdh;
    private String lxryx;
    private String checkinfo1;
    private String checktime1;
    private String checkinfo2;
    private String checktime2;
    private String fj;
    private String worktype;
    private String fgyz;
    private String yjsfzr;
    private String lsh;
    private String wzfzr;
    private String dzhyb;
    private String wzmc;
    private String ipdz;
    private String ksdz;
    private String ksfzr;
    private String ksmc;
    private String mobile;
    private String authstandard;
    private String jyfs;
    private String fwxz;
    private String lxrsfzlx;
    private String yqid;
    private String wlkhdcxm;
    private String ypgsprange;
    private String jydz;
    private String ylzd34;
    private String tyshxydm;
    private String scdzhfw;
    private String lxrzjhm;
    private String frlxdh;
    private String lxrxm;
    private String frsfzlx;
    private String jgjzc;
    private String frxm;
    private String lxrdh;
    private String cpmx;
    private String scdzmc;
    private String qxgz;

    /** 证书ID **/
    private String zsid;

    private Map<String, List<CertSubTable>> subMap = new HashMap<>();

    public void setFzrq(String fzrq) {
        this.fzrq = fzrq;
        try {
            Date date = org.apache.commons.lang3.time.DateUtils.parseDate(fzrq, "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd");
            this.fzrq_y = DateFormatUtils.format(date, "yyyy");
            this.fzrq_m = DateFormatUtils.format(date, "M");
            this.fzrq_d = DateFormatUtils.format(date, "d");
        } catch (Exception ignore) {}
    }

    public void setYxqq(String yxqq) {
        this.yxqq = yxqq;
        try {
            Date date = org.apache.commons.lang3.time.DateUtils.parseDate(yxqq, "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd");
            this.yxqq_y = DateFormatUtils.format(date, "yyyy");
            this.yxqq_m = DateFormatUtils.format(date, "M");
            this.yxqq_d = DateFormatUtils.format(date, "d");
        } catch (Exception ignore) {}
    }

    public void setYxqz(String yxqz) {
        this.yxqz = yxqz;
        try {
            Date date = org.apache.commons.lang3.time.DateUtils.parseDate(yxqz, "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd");
            this.yxqz_y = DateFormatUtils.format(date, "yyyy");
            this.yxqz_m = DateFormatUtils.format(date, "M");
            this.yxqz_d = DateFormatUtils.format(date, "d");
        } catch (Exception ignore) {}
    }

}
