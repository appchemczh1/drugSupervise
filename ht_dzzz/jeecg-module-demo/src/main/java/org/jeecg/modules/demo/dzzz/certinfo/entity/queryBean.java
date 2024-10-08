package org.jeecg.modules.demo.dzzz.certinfo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 电子证照源数据
 * @Author: jeecg-boot
 * @Date:   2024-03-27
 * @Version: V1.0
 */
@ApiModel(value="查询辅助类", description="查询类")
@Data
public class queryBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String beginDate;
    private String endDate;
    private String dlzslx;
    private String dlzszt;
    //是否当前操作变更记录
    private String isdq;
    private String iwgz;
    private String iswh;

    //查询框

    private String qymc;
    private String shxydm;
    private String zsbh;
    private  String xzqh;//information表关联查
    private String fzjg;
    private String fzrq;
    private String chanping;

    //证书类别(大类-> yp,ylqx,hzp)
    private String zslb;

    // 是否显示职业药师（0：显示，1：不显示）
    private String showZyys;

}
