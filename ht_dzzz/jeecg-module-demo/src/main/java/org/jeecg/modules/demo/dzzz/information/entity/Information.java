package org.jeecg.modules.demo.dzzz.information.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: information1
 * @Author: jeecg-boot
 * @Date:   2024-06-24
 * @Version: V1.0
 */
@Data
@TableName("information")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="information1对象", description="information1")
public class Information implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.String id;

	/**社会信用代码*/
	@Excel(name = "社会统一信用代码", width = 28)
    @ApiModelProperty(value = "统一社会信用代码")
    private java.lang.String entzzjgdm;

	/**entbacode*/
//	@Excel(name = "entbacode", width = 15)
    @ApiModelProperty(value = "entbacode")
    private java.lang.String entbacode;

	/**entname*/
	@Excel(name = "企业名称", width = 35)
    @ApiModelProperty(value = "企业名称")
    private java.lang.String entname;

	/**entbelongto*/
//	@Excel(name = "entbelongto", width = 15)
    @ApiModelProperty(value = "entbelongto")
    private java.lang.String entbelongto;

	/**entavailflag*/
//	@Excel(name = "entavailflag", width = 15)
    @ApiModelProperty(value = "entavailflag")
    private java.lang.String entavailflag;

	/**entintype*/
//	@Excel(name = "entintype", width = 15)
    @ApiModelProperty(value = "entintype")
    private java.lang.String entintype;

	/**entregaddr*/
	@Excel(name = "企业地址", width = 40)
    @ApiModelProperty(value = "企业地址")
    private java.lang.String entregaddr;

	/**entregpcode*/
//	@Excel(name = "entregpcode", width = 15)
    @ApiModelProperty(value = "entregpcode")
    private java.lang.String entregpcode;

	/**ents*/
	@Excel(name = "省", width = 15)
    @ApiModelProperty(value = "ents")
    private java.lang.String ents;

	/**entd*/
	@Excel(name = "市", width = 15)
    @ApiModelProperty(value = "entd")
    private java.lang.String entd;

	/**engx*/
	@Excel(name = "区/县", width = 15)
    @ApiModelProperty(value = "区/县")
    private java.lang.String engx;

	/**entregtypecode*/
//	@Excel(name = "entregtypecode", width = 15)
    @ApiModelProperty(value = "entregtypecode")
    private java.lang.String entregtypecode;

	/**entecotype*/
//	@Excel(name = "entecotype", width = 15)
    @ApiModelProperty(value = "entecotype")
    private java.lang.String entecotype;

	/**entbelongarea*/
//	@Excel(name = "entbelongarea", width = 15)
    @ApiModelProperty(value = "entbelongarea")
    private java.lang.String entbelongarea;

	/**entlinkname*/
//	@Excel(name = "entlinkname", width = 15)
    @ApiModelProperty(value = "entlinkname")
    private java.lang.String entlinkname;

	/**entlinkmobile*/
//	@Excel(name = "entlinkmobile", width = 15)
    @ApiModelProperty(value = "entlinkmobile")
    private java.lang.String entlinkmobile;

	/**entlinktel*/
//	@Excel(name = "entlinktel", width = 15)
    @ApiModelProperty(value = "entlinktel")
    private java.lang.String entlinktel;

	/**entlinkfax*/
//	@Excel(name = "entlinkfax", width = 15)
    @ApiModelProperty(value = "entlinkfax")
    private java.lang.String entlinkfax;

	/**entlinkemail*/
//	@Excel(name = "entlinkemail", width = 15)
    @ApiModelProperty(value = "entlinkemail")
    private java.lang.String entlinkemail;

	/**corpname*/
	@Excel(name = "法定代表人", width = 15)
    @ApiModelProperty(value = "法定代表人")
    private java.lang.String corpname;

	/**entby14*/
//	@Excel(name = "entby14", width = 15)
    @ApiModelProperty(value = "entby14")
    private java.lang.String entby14;

	/**entby7*/
//	@Excel(name = "entby7", width = 15)
    @ApiModelProperty(value = "entby7")
    private java.lang.String entby7;

	/**entby8*/
//	@Excel(name = "entby8", width = 15)
    @ApiModelProperty(value = "entby8")
    private java.lang.String entby8;

	/**entby12*/
//	@Excel(name = "entby12", width = 15)
    @ApiModelProperty(value = "entby12")
    private java.lang.String entby12;

	/**entby17*/
//	@Excel(name = "entby17", width = 15)
    @ApiModelProperty(value = "entby17")
    private java.lang.String entby17;

	/**entby20*/
//	@Excel(name = "entby20", width = 15)
    @ApiModelProperty(value = "entby20")
    private java.lang.String entby20;

	/**entby19*/
//	@Excel(name = "entby19", width = 15)
    @ApiModelProperty(value = "entby19")
    private java.lang.String entby19;

	/**entby18*/
//	@Excel(name = "entby18", width = 15)
    @ApiModelProperty(value = "entby18")
    private java.lang.String entby18;

	/**entby16*/
//	@Excel(name = "entby16", width = 15)
    @ApiModelProperty(value = "entby16")
    private java.lang.String entby16;

	/**entby15*/
//	@Excel(name = "entby15", width = 15)
    @ApiModelProperty(value = "entby15")
    private java.lang.String entby15;

	/**auditperson*/
//	@Excel(name = "auditperson", width = 15)
    @ApiModelProperty(value = "auditperson")
    private java.lang.String auditperson;

	/**auditdept*/
//	@Excel(name = "auditdept", width = 15)
    @ApiModelProperty(value = "auditdept")
    private java.lang.String auditdept;

	/**audittiem*/
//	@Excel(name = "audittiem", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "audittiem")
    private java.util.Date audittiem;

	/**delflag*/
//	@Excel(name = "delflag", width = 15)
    @ApiModelProperty(value = "delflag")
    private java.lang.String delflag;

	/**createdate*/
//	@Excel(name = "createdate", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "createdate")
    private java.util.Date createdate;

	/**creator*/
//	@Excel(name = "creator", width = 15)
    @ApiModelProperty(value = "creator")
    private java.lang.String creator;

	/**createdept*/
//	@Excel(name = "createdept", width = 15)
    @ApiModelProperty(value = "createdept")
    private java.lang.String createdept;

	/**isConfirm*/
//	@Excel(name = "isConfirm", width = 15)
    @ApiModelProperty(value = "isConfirm")
    private java.lang.String isConfirm;

	/**password*/
//	@Excel(name = "password", width = 15)
    @ApiModelProperty(value = "password")
    private java.lang.String password;

	/**ifwf*/
//	@Excel(name = "ifwf", width = 15)
    @ApiModelProperty(value = "ifwf")
    private java.lang.String ifwf;

	/**entbelongtoCity*/
//	@Excel(name = "entbelongtoCity", width = 15)
    @ApiModelProperty(value = "entbelongtoCity")
    private java.lang.String entbelongtoCity;

	/**entbelongtoDomain*/
//	@Excel(name = "entbelongtoDomain", width = 15)
    @ApiModelProperty(value = "entbelongtoDomain")
    private java.lang.String entbelongtoDomain;

	/**entbelongtoTown*/
//	@Excel(name = "entbelongtoTown", width = 15)
    @ApiModelProperty(value = "entbelongtoTown")
    private java.lang.String entbelongtoTown;

	/**admindivision*/
//	@Excel(name = "admindivision", width = 15)
    @ApiModelProperty(value = "admindivision")
    private java.lang.String admindivision;

	/**sync*/
//	@Excel(name = "sync", width = 15)
    @ApiModelProperty(value = "sync")
    private java.lang.String sync;

	/**syncZs*/
//	@Excel(name = "syncZs", width = 15)
    @ApiModelProperty(value = "syncZs")
    private java.lang.String syncZs;

	/**processflag*/
//	@Excel(name = "processflag", width = 15)
    @ApiModelProperty(value = "processflag")
    private java.lang.String processflag;

	/**lastudate*/
//	@Excel(name = "lastudate", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "lastudate")
    private java.util.Date lastudate;

	/**lastudept*/
//	@Excel(name = "lastudept", width = 15)
    @ApiModelProperty(value = "lastudept")
    private java.lang.String lastudept;

	/**repeatdel*/
//	@Excel(name = "repeatdel", width = 15)
    @ApiModelProperty(value = "repeatdel")
    private java.lang.String repeatdel;

	/**sjzlSjly*/
//	@Excel(name = "sjzlSjly", width = 15)
    @ApiModelProperty(value = "sjzlSjly")
    private java.lang.String sjzlSjly;

	/**ckdz*/
//	@Excel(name = "ckdz", width = 15)
    @ApiModelProperty(value = "ckdz")
    private java.lang.String ckdz;

	/**djjg*/
//	@Excel(name = "djjg", width = 15)
    @ApiModelProperty(value = "djjg")
    private java.lang.String djjg;

	/**djsj*/
//	@Excel(name = "djsj", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "djsj")
    private java.util.Date djsj;

	/**fddbrsjh*/
//	@Excel(name = "fddbrsjh", width = 15)
    @ApiModelProperty(value = "fddbrsjh")
    private java.lang.String fddbrsjh;

	/**gsqylx*/
//	@Excel(name = "gsqylx", width = 15)
    @ApiModelProperty(value = "gsqylx")
    private java.lang.String gsqylx;

	/**jjhy*/
//	@Excel(name = "jjhy", width = 15)
    @ApiModelProperty(value = "jjhy")
    private java.lang.String jjhy;

	/**jjlx*/
//	@Excel(name = "jjlx", width = 15)
    @ApiModelProperty(value = "jjlx")
    private java.lang.String jjlx;

	/**jydz*/
//	@Excel(name = "jydz", width = 15)
    @ApiModelProperty(value = "jydz")
    private java.lang.String jydz;

	/**jyfw*/
//	@Excel(name = "jyfw", width = 15)
    @ApiModelProperty(value = "jyfw")
    private java.lang.String jyfw;

	/**qygm*/
//	@Excel(name = "qygm", width = 15)
    @ApiModelProperty(value = "qygm")
    private java.lang.String qygm;

	/**qyzclx*/
//	@Excel(name = "qyzclx", width = 15)
    @ApiModelProperty(value = "qyzclx")
    private java.lang.String qyzclx;

	/**qyzjlx*/
//	@Excel(name = "qyzjlx", width = 15)
    @ApiModelProperty(value = "qyzjlx")
    private java.lang.String qyzjlx;

	/**qyzt*/
//	@Excel(name = "qyzt", width = 15)
    @ApiModelProperty(value = "qyzt")
    private java.lang.String qyzt;

	/**sfgmys*/
//	@Excel(name = "sfgmys", width = 15)
    @ApiModelProperty(value = "sfgmys")
    private java.lang.String sfgmys;

	/**xzjddm*/
//	@Excel(name = "xzjddm", width = 15)
    @ApiModelProperty(value = "xzjddm")
    private java.lang.String xzjddm;

	/**zczb*/
//	@Excel(name = "zczb", width = 15)
    @ApiModelProperty(value = "zczb")
    private java.math.BigDecimal zczb;

	/**zczbdw*/
//	@Excel(name = "zczbdw", width = 15)
    @ApiModelProperty(value = "zczbdw")
    private java.lang.String zczbdw;

	/**sjzlsjly*/
//	@Excel(name = "sjzlsjly", width = 15)
    @ApiModelProperty(value = "sjzlsjly")
    private java.lang.String sjzlsjly;

	/**dashxydm*/
//	@Excel(name = "dashxydm", width = 15)
    @ApiModelProperty(value = "dashxydm")
    private java.lang.String dashxydm;

	/**fax*/
//	@Excel(name = "fax", width = 15)
    @ApiModelProperty(value = "fax")
    private java.lang.String fax;

	/**jgfj*/
//	@Excel(name = "jgfj", width = 15)
    @ApiModelProperty(value = "jgfj")
    private java.lang.String jgfj;

	/**scdz*/
//	@Excel(name = "scdz", width = 15)
    @ApiModelProperty(value = "scdz")
    private java.lang.String scdz;

	/**syncScj*/
//	@Excel(name = "syncScj", width = 15)
    @ApiModelProperty(value = "syncScj")
    private java.lang.String syncScj;

	/**sessionid*/
//	@Excel(name = "sessionid", width = 15)
    @ApiModelProperty(value = "sessionid")
    private java.lang.String sessionid;

	/**sjly*/
//	@Excel(name = "sjly", width = 15)
    @ApiModelProperty(value = "sjly")
    private java.lang.String sjly;

	/**flag*/
//	@Excel(name = "flag", width = 15)
    @ApiModelProperty(value = "flag")
    private java.lang.String flag;

	/**zwfwparam*/
//	@Excel(name = "zwfwparam", width = 15)
    @ApiModelProperty(value = "zwfwparam")
    private java.lang.String zwfwparam;

	/**syncZyzjba*/
//	@Excel(name = "syncZyzjba", width = 15)
    @ApiModelProperty(value = "syncZyzjba")
    private java.lang.String syncZyzjba;

	/**syncSjzl*/
//	@Excel(name = "syncSjzl", width = 15)
    @ApiModelProperty(value = "syncSjzl")
    private java.lang.String syncSjzl;

	/**syncZsxt*/
//	@Excel(name = "syncZsxt", width = 15)
    @ApiModelProperty(value = "syncZsxt")
    private java.lang.String syncZsxt;

	/**issc*/
//	@Excel(name = "issc", width = 15)
    @ApiModelProperty(value = "issc")
    private java.lang.String issc;

	/**synctime*/
//	@Excel(name = "synctime", width = 15)
    @ApiModelProperty(value = "synctime")
    private java.lang.String synctime;

//	@Excel(name = "历史名称", width = 15)
    @ApiModelProperty(value = "历史名称")
    private java.lang.String hisName;

    //	@Excel(name = "证书数量", width = 15)
    @TableField(exist = false)
    @ApiModelProperty(value = "证书数量")
    private Integer zsNum;

}
