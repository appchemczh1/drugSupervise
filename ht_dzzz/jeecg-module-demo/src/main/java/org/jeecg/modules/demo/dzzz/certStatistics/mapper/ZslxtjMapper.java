package org.jeecg.modules.demo.dzzz.certStatistics.mapper;

import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.demo.dzzz.certStatistics.entity.Zslxtj;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;


public interface ZslxtjMapper extends BaseMapper<Zslxtj> {
    List<Zslxtj> selectZslxtjList(@Param("yxqq") String startTime,@Param("yxqz") String endTime);
}
