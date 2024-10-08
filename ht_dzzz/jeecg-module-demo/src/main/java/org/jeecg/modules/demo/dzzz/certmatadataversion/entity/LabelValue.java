package org.jeecg.modules.demo.dzzz.certmatadataversion.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * @Description: 证书元数据表
 * @Author: jeecg-boot
 * @Date:   2024-03-25
 * @Version: V1.0
 */
@ApiModel(value="cert_metadata对象", description="证书元数据表")
@Data
public class LabelValue implements Serializable {
    private static final long serialVersionUID = 1L;


    private String label;
    private String value;
}
