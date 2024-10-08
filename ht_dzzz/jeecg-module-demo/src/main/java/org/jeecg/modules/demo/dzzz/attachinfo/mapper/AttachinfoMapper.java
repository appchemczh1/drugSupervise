package org.jeecg.modules.demo.dzzz.attachinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.demo.dzzz.attachinfo.entity.Attachinfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description: 附件储存表
 * @Author: jeecg-boot
 * @Date:   2024-04-07
 * @Version: V1.0
 */
public interface AttachinfoMapper extends BaseMapper<Attachinfo> {
    Attachinfo findAttachinfoByZSid(@Param("zsid") String zsid, @Param("type") String type, @Param("status") String status);
}
