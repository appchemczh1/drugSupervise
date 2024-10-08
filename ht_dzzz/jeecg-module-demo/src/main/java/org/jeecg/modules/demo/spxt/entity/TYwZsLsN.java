package org.jeecg.modules.demo.spxt.entity;

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
 * @Description: t_yw_zs_ls_n
 * @Author: jeecg-boot
 * @Date:   2024-06-20
 * @Version: V1.0
 */
@Data
@TableName("t_yw_zs_ls_n")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="t_yw_zs_ls_n对象", description="t_yw_zs_ls_n")
public class TYwZsLsN implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.String id;
	/**qyid*/
	@Excel(name = "qyid", width = 15)
    @ApiModelProperty(value = "qyid")
    private java.lang.String qyid;
	/**zslx*/
	@Excel(name = "zslx", width = 15)
    @ApiModelProperty(value = "zslx")
    private java.lang.Integer zslx;
	/**zsbh*/
	@Excel(name = "zsbh", width = 15)
    @ApiModelProperty(value = "zsbh")
    private java.lang.String zsbh;
	/**qymc*/
	@Excel(name = "qymc", width = 15)
    @ApiModelProperty(value = "qymc")
    private java.lang.String qymc;
	/**shxydm*/
	@Excel(name = "shxydm", width = 15)
    @ApiModelProperty(value = "shxydm")
    private java.lang.String shxydm;
	/**zcdz*/
	@Excel(name = "zcdz", width = 15)
    @ApiModelProperty(value = "zcdz")
    private java.lang.String zcdz;
	/**fddbr*/
	@Excel(name = "fddbr", width = 15)
    @ApiModelProperty(value = "fddbr")
    private java.lang.String fddbr;
	/**qyfzr*/
	@Excel(name = "qyfzr", width = 15)
    @ApiModelProperty(value = "qyfzr")
    private java.lang.String qyfzr;
	/**zlfzr*/
	@Excel(name = "zlfzr", width = 15)
    @ApiModelProperty(value = "zlfzr")
    private java.lang.String zlfzr;
	/**flm*/
	@Excel(name = "flm", width = 15)
    @ApiModelProperty(value = "flm")
    private java.lang.String flm;
	/**rcjdgljg*/
	@Excel(name = "rcjdgljg", width = 15)
    @ApiModelProperty(value = "rcjdgljg")
    private java.lang.String rcjdgljg;
	/**rcjdglry*/
	@Excel(name = "rcjdglry", width = 15)
    @ApiModelProperty(value = "rcjdglry")
    private java.lang.String rcjdglry;
	/**scdzhfw*/
	@Excel(name = "scdzhfw", width = 15)
    @ApiModelProperty(value = "scdzhfw")
    private java.lang.String scdzhfw;
	/**fzjg*/
	@Excel(name = "fzjg", width = 15)
    @ApiModelProperty(value = "fzjg")
    private java.lang.String fzjg;
	/**qfr*/
	@Excel(name = "qfr", width = 15)
    @ApiModelProperty(value = "qfr")
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
	/**slh*/
	@Excel(name = "slh", width = 15)
    @ApiModelProperty(value = "slh")
    private java.lang.String slh;
	/**ckdz*/
	@Excel(name = "ckdz", width = 15)
    @ApiModelProperty(value = "ckdz")
    private java.lang.String ckdz;
	/**jgjzc*/
	@Excel(name = "jgjzc", width = 15)
    @ApiModelProperty(value = "jgjzc")
    private java.lang.String jgjzc;
	/**fw*/
	@Excel(name = "fw", width = 15)
    @ApiModelProperty(value = "fw")
    private java.lang.String fw;
	/**fwyw*/
	@Excel(name = "fwyw", width = 15)
    @ApiModelProperty(value = "fwyw")
    private java.lang.String fwyw;
	/**bz*/
	@Excel(name = "bz", width = 15)
    @ApiModelProperty(value = "bz")
    private java.lang.String bz;
	/**zs*/
	@Excel(name = "zs", width = 15)
    @ApiModelProperty(value = "zs")
    private java.lang.String zs;
	/**cs*/
	@Excel(name = "cs", width = 15)
    @ApiModelProperty(value = "chaosong")
    private java.lang.String chaosong;
	/**cp*/
	@Excel(name = "cp", width = 15)
    @ApiModelProperty(value = "chanping")
    private java.lang.String chanping;
	/**cplb*/
	@Excel(name = "cplb", width = 15)
    @ApiModelProperty(value = "cplb")
    private java.lang.String cplb;
	/**cpmx*/
	@Excel(name = "cpmx", width = 15)
    @ApiModelProperty(value = "cpmx")
    private java.lang.String cpmx;
	/**dh*/
	@Excel(name = "dh", width = 15)
    @ApiModelProperty(value = "dh")
    private java.lang.String dh;
	/**cz*/
	@Excel(name = "cz", width = 15)
    @ApiModelProperty(value = "cz")
    private java.lang.String cz;
	/**gg*/
	@Excel(name = "guige", width = 15)
    @ApiModelProperty(value = "gg")
    private java.lang.String guige;
	/**jx*/
	@Excel(name = "jx", width = 15)
    @ApiModelProperty(value = "jx")
    private java.lang.String jx;
	/**fj*/
	@Excel(name = "fj", width = 15)
    @ApiModelProperty(value = "fj")
    private java.lang.String fj;
	/**wzym*/
	@Excel(name = "wzym", width = 15)
    @ApiModelProperty(value = "wzym")
    private java.lang.String wzym;
	/**jsly*/
	@Excel(name = "jsly", width = 15)
    @ApiModelProperty(value = "jsly")
    private java.lang.Integer jsly;
	/**zt*/
	@Excel(name = "zt", width = 15)
    @ApiModelProperty(value = "zt")
    private java.lang.Integer zt;
	/**ywlb*/
	@Excel(name = "ywlb", width = 15)
    @ApiModelProperty(value = "ywlb")
    private java.lang.Integer ywlb;
	/**bbid*/
	@Excel(name = "bbid", width = 15)
    @ApiModelProperty(value = "bbid")
    private java.lang.String bbid;
	/**mbid*/
	@Excel(name = "mbid", width = 15)
    @ApiModelProperty(value = "mbid")
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
	/**fzjgid*/
	@Excel(name = "fzjgid", width = 15)
    @ApiModelProperty(value = "fzjgid")
    private java.lang.String fzjgid;
	/**sjtbZsgs*/
	@Excel(name = "sjtbZsgs", width = 15)
    @ApiModelProperty(value = "sjtbZsgs")
    private java.lang.Integer sjtbZsgs;
	/**sjtbDa*/
	@Excel(name = "sjtbDa", width = 15)
    @ApiModelProperty(value = "sjtbDa")
    private java.lang.Integer sjtbDa;
	/**sjtbXzsp*/
	@Excel(name = "sjtbXzsp", width = 15)
    @ApiModelProperty(value = "sjtbXzsp")
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
	/**ewm*/
	@Excel(name = "ewm", width = 15)
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
	/**ewmlj*/
	@Excel(name = "ewmlj", width = 15)
    @ApiModelProperty(value = "ewmlj")
    private java.lang.String ewmlj;
	/**sync*/
	@Excel(name = "sync", width = 15)
    @ApiModelProperty(value = "sync")
    private java.lang.Integer sync;
	/**glzdb*/
	@Excel(name = "glzdb", width = 15)
    @ApiModelProperty(value = "glzdb")
    private java.lang.String glzdb;
	/**qylx*/
	@Excel(name = "qylx", width = 15)
    @ApiModelProperty(value = "qylx")
    private java.lang.String qylx;
	/**lxryx*/
	@Excel(name = "lxryx", width = 15)
    @ApiModelProperty(value = "lxryx")
    private java.lang.String lxryx;
	/**lxdh*/
	@Excel(name = "lxdh", width = 15)
    @ApiModelProperty(value = "lxdh")
    private java.lang.String lxdh;
	/**typelevel*/
	@Excel(name = "typelevel", width = 15)
    @ApiModelProperty(value = "typelevel")
    private java.lang.String typelevel;
	/**mobile*/
	@Excel(name = "mobile", width = 15)
    @ApiModelProperty(value = "mobile")
    private java.lang.String mobile;
	/**synctime*/
	@Excel(name = "synctime", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "synctime")
    private java.util.Date synctime;
	/**issc*/
	@Excel(name = "issc", width = 15)
    @ApiModelProperty(value = "issc")
    private java.lang.String issc;
    private java.lang.String xzspid;

}
