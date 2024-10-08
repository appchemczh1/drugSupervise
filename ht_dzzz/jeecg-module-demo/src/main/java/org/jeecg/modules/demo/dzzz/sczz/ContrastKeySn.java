package org.jeecg.modules.demo.dzzz.sczz;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @description:
 * @author: 刘枫
 * @date: 2021-11-17
 */
@Data
@TableName("T_B_BM_KEY")
public class ContrastKeySn {
    private static final long serialVersionUID = 1L;
    
  /*  @TableId(type = IdType.UUID)*/
    private String id;
    
    @TableField("KEYSN_PDF")
    private String keySnPdf;
    
    @TableField("KEYNAME_PDF")
    private String keyNamePdf;
    
    @TableField("KEYSN_OFD")
    private String keySnOfd;
    
    @TableField("KEYNAME_OFD")
    private String keyNameOfd;
    
    private String createTime;
    
    private String delFlag;
}
