package org.jeecg.modules.demo.dzzz.information.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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
public class InformationZ implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private String id;
	/**社会信用代码*/
	@Excel(name = "社会信用代码", width = 15)
    @ApiModelProperty(value = "社会信用代码")
    private String entzzjgdm;
	/**entbacode*/
	@Excel(name = "entbacode", width = 15)
    @ApiModelProperty(value = "entbacode")
    private String entbacode;
	/**entname*/
	@Excel(name = "entname", width = 15)
    @ApiModelProperty(value = "entname")
    private String entname;
	/**entbelongto*/
	@Excel(name = "entbelongto", width = 15)
    @ApiModelProperty(value = "entbelongto")
    private String entbelongto;
	/**entavailflag*/
	@Excel(name = "entavailflag", width = 15)
    @ApiModelProperty(value = "entavailflag")
    private String entavailflag;
	/**entintype*/
	@Excel(name = "entintype", width = 15)
    @ApiModelProperty(value = "entintype")
    private String entintype;
	/**entregaddr*/
	@Excel(name = "entregaddr", width = 15)
    @ApiModelProperty(value = "entregaddr")
    private String entregaddr;
	/**entregpcode*/
	@Excel(name = "entregpcode", width = 15)
    @ApiModelProperty(value = "entregpcode")
    private String entregpcode;
	/**ents*/
	@Excel(name = "ents", width = 15)
    @ApiModelProperty(value = "ents")
    private String ents;
	/**entd*/
	@Excel(name = "entd", width = 15)
    @ApiModelProperty(value = "entd")
    private String entd;
	/**engx*/
	@Excel(name = "engx", width = 15)
    @ApiModelProperty(value = "engx")
    private String engx;
	/**entregtypecode*/
	@Excel(name = "entregtypecode", width = 15)
    @ApiModelProperty(value = "entregtypecode")
    private String entregtypecode;
	/**entecotype*/
	@Excel(name = "entecotype", width = 15)
    @ApiModelProperty(value = "entecotype")
    private String entecotype;
	/**entbelongarea*/
	@Excel(name = "entbelongarea", width = 15)
    @ApiModelProperty(value = "entbelongarea")
    private String entbelongarea;
	/**entlinkname*/
	@Excel(name = "entlinkname", width = 15)
    @ApiModelProperty(value = "entlinkname")
    private String entlinkname;
	/**entlinkmobile*/
	@Excel(name = "entlinkmobile", width = 15)
    @ApiModelProperty(value = "entlinkmobile")
    private String entlinkmobile;
	/**entlinktel*/
	@Excel(name = "entlinktel", width = 15)
    @ApiModelProperty(value = "entlinktel")
    private String entlinktel;
	/**entlinkfax*/
	@Excel(name = "entlinkfax", width = 15)
    @ApiModelProperty(value = "entlinkfax")
    private String entlinkfax;
	/**entlinkemail*/
	@Excel(name = "entlinkemail", width = 15)
    @ApiModelProperty(value = "entlinkemail")
    private String entlinkemail;
	/**corpname*/
	@Excel(name = "corpname", width = 15)
    @ApiModelProperty(value = "corpname")
    private String corpname;
	/**entby14*/
	@Excel(name = "entby14", width = 15)
    @ApiModelProperty(value = "entby14")
    private String entby14;
	/**entby7*/
	@Excel(name = "entby7", width = 15)
    @ApiModelProperty(value = "entby7")
    private String entby7;
	/**entby8*/
	@Excel(name = "entby8", width = 15)
    @ApiModelProperty(value = "entby8")
    private String entby8;
	/**entby12*/
	@Excel(name = "entby12", width = 15)
    @ApiModelProperty(value = "entby12")
    private String entby12;
	/**entby17*/
	@Excel(name = "entby17", width = 15)
    @ApiModelProperty(value = "entby17")
    private String entby17;
	/**entby20*/
	@Excel(name = "entby20", width = 15)
    @ApiModelProperty(value = "entby20")
    private String entby20;
	/**entby19*/
	@Excel(name = "entby19", width = 15)
    @ApiModelProperty(value = "entby19")
    private String entby19;
	/**entby18*/
	@Excel(name = "entby18", width = 15)
    @ApiModelProperty(value = "entby18")
    private String entby18;
	/**entby16*/
	@Excel(name = "entby16", width = 15)
    @ApiModelProperty(value = "entby16")
    private String entby16;
	/**entby15*/
	@Excel(name = "entby15", width = 15)
    @ApiModelProperty(value = "entby15")
    private String entby15;
	/**auditperson*/
	@Excel(name = "auditperson", width = 15)
    @ApiModelProperty(value = "auditperson")
    private String auditperson;
	/**auditdept*/
	@Excel(name = "auditdept", width = 15)
    @ApiModelProperty(value = "auditdept")
    private String auditdept;
	/**audittiem*/
	@Excel(name = "audittiem", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "audittiem")
    private Date audittiem;
	/**delflag*/
	@Excel(name = "delflag", width = 15)
    @ApiModelProperty(value = "delflag")
    private String delflag;
	/**createdate*/
	@Excel(name = "createdate", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "createdate")
    private Date createdate;
	/**creator*/
	@Excel(name = "creator", width = 15)
    @ApiModelProperty(value = "creator")
    private String creator;
	/**createdept*/
	@Excel(name = "createdept", width = 15)
    @ApiModelProperty(value = "createdept")
    private String createdept;
	/**isConfirm*/
	@Excel(name = "isConfirm", width = 15)
    @ApiModelProperty(value = "isConfirm")
    private String isConfirm;
	/**password*/
	@Excel(name = "password", width = 15)
    @ApiModelProperty(value = "password")
    private String password;
	/**ifwf*/
	@Excel(name = "ifwf", width = 15)
    @ApiModelProperty(value = "ifwf")
    private String ifwf;
	/**entbelongtoCity*/
	@Excel(name = "entbelongtoCity", width = 15)
    @ApiModelProperty(value = "entbelongtoCity")
    private String entbelongtoCity;
	/**entbelongtoDomain*/
	@Excel(name = "entbelongtoDomain", width = 15)
    @ApiModelProperty(value = "entbelongtoDomain")
    private String entbelongtoDomain;
	/**entbelongtoTown*/
	@Excel(name = "entbelongtoTown", width = 15)
    @ApiModelProperty(value = "entbelongtoTown")
    private String entbelongtoTown;
	/**admindivision*/
	@Excel(name = "admindivision", width = 15)
    @ApiModelProperty(value = "admindivision")
    private String admindivision;
	/**sync*/
	@Excel(name = "sync", width = 15)
    @ApiModelProperty(value = "sync")
    private String sync;
	/**syncZs*/
	@Excel(name = "syncZs", width = 15)
    @ApiModelProperty(value = "syncZs")
    private String syncZs;
	/**processflag*/
	@Excel(name = "processflag", width = 15)
    @ApiModelProperty(value = "processflag")
    private String processflag;
	/**lastudate*/
	@Excel(name = "lastudate", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "lastudate")
    private Date lastudate;
	/**lastudept*/
	@Excel(name = "lastudept", width = 15)
    @ApiModelProperty(value = "lastudept")
    private String lastudept;
	/**repeatdel*/
	@Excel(name = "repeatdel", width = 15)
    @ApiModelProperty(value = "repeatdel")
    private String repeatdel;
	/**sjzlSjly*/
	@Excel(name = "sjzlSjly", width = 15)
    @ApiModelProperty(value = "sjzlSjly")
    private String sjzlSjly;
	/**ckdz*/
	@Excel(name = "ckdz", width = 15)
    @ApiModelProperty(value = "ckdz")
    private String ckdz;
	/**djjg*/
	@Excel(name = "djjg", width = 15)
    @ApiModelProperty(value = "djjg")
    private String djjg;
	/**djsj*/
	@Excel(name = "djsj", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "djsj")
    private Date djsj;
	/**fddbrsjh*/
	@Excel(name = "fddbrsjh", width = 15)
    @ApiModelProperty(value = "fddbrsjh")
    private String fddbrsjh;
	/**gsqylx*/
	@Excel(name = "gsqylx", width = 15)
    @ApiModelProperty(value = "gsqylx")
    private String gsqylx;
	/**jjhy*/
	@Excel(name = "jjhy", width = 15)
    @ApiModelProperty(value = "jjhy")
    private String jjhy;
	/**jjlx*/
	@Excel(name = "jjlx", width = 15)
    @ApiModelProperty(value = "jjlx")
    private String jjlx;
	/**jydz*/
	@Excel(name = "jydz", width = 15)
    @ApiModelProperty(value = "jydz")
    private String jydz;
	/**jyfw*/
	@Excel(name = "jyfw", width = 15)
    @ApiModelProperty(value = "jyfw")
    private String jyfw;
	/**qygm*/
	@Excel(name = "qygm", width = 15)
    @ApiModelProperty(value = "qygm")
    private String qygm;
	/**qyzclx*/
	@Excel(name = "qyzclx", width = 15)
    @ApiModelProperty(value = "qyzclx")
    private String qyzclx;
	/**qyzjlx*/
	@Excel(name = "qyzjlx", width = 15)
    @ApiModelProperty(value = "qyzjlx")
    private String qyzjlx;
	/**qyzt*/
	@Excel(name = "qyzt", width = 15)
    @ApiModelProperty(value = "qyzt")
    private String qyzt;
	/**sfgmys*/
	@Excel(name = "sfgmys", width = 15)
    @ApiModelProperty(value = "sfgmys")
    private String sfgmys;
	/**xzjddm*/
	@Excel(name = "xzjddm", width = 15)
    @ApiModelProperty(value = "xzjddm")
    private String xzjddm;
	/**zczb*/
	@Excel(name = "zczb", width = 15)
    @ApiModelProperty(value = "zczb")
    private BigDecimal zczb;
	/**zczbdw*/
	@Excel(name = "zczbdw", width = 15)
    @ApiModelProperty(value = "zczbdw")
    private String zczbdw;
	/**sjzlsjly*/
	@Excel(name = "sjzlsjly", width = 15)
    @ApiModelProperty(value = "sjzlsjly")
    private String sjzlsjly;
	/**dashxydm*/
	@Excel(name = "dashxydm", width = 15)
    @ApiModelProperty(value = "dashxydm")
    private String dashxydm;
	/**fax*/
	@Excel(name = "fax", width = 15)
    @ApiModelProperty(value = "fax")
    private String fax;
	/**jgfj*/
	@Excel(name = "jgfj", width = 15)
    @ApiModelProperty(value = "jgfj")
    private String jgfj;
	/**scdz*/
	@Excel(name = "scdz", width = 15)
    @ApiModelProperty(value = "scdz")
    private String scdz;
	/**syncScj*/
	@Excel(name = "syncScj", width = 15)
    @ApiModelProperty(value = "syncScj")
    private String syncScj;
	/**sessionid*/
	@Excel(name = "sessionid", width = 15)
    @ApiModelProperty(value = "sessionid")
    private String sessionid;
	/**sjly*/
	@Excel(name = "sjly", width = 15)
    @ApiModelProperty(value = "sjly")
    private String sjly;
	/**flag*/
	@Excel(name = "flag", width = 15)
    @ApiModelProperty(value = "flag")
    private String flag;
	/**zwfwparam*/
	@Excel(name = "zwfwparam", width = 15)
    @ApiModelProperty(value = "zwfwparam")
    private String zwfwparam;
	/**syncZyzjba*/
	@Excel(name = "syncZyzjba", width = 15)
    @ApiModelProperty(value = "syncZyzjba")
    private String syncZyzjba;
	/**syncSjzl*/
	@Excel(name = "syncSjzl", width = 15)
    @ApiModelProperty(value = "syncSjzl")
    private String syncSjzl;
	/**syncZsxt*/
	@Excel(name = "syncZsxt", width = 15)
    @ApiModelProperty(value = "syncZsxt")
    private String syncZsxt;
	/**issc*/
	@Excel(name = "issc", width = 15)
    @ApiModelProperty(value = "issc")
    private String issc;
	/**synctime*/
	@Excel(name = "synctime", width = 15)
    @ApiModelProperty(value = "synctime")
    private String synctime;

    @Excel(name = "zsbh", width = 15)
    private String zsbh;
}
