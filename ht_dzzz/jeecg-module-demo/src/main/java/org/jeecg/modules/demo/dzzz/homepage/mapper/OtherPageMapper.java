package org.jeecg.modules.demo.dzzz.homepage.mapper;

import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.demo.dzzz.certStatistics.entity.Zslxtj;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;


public interface OtherPageMapper extends BaseMapper<Zslxtj> {

    List<Map<String,String>> getZSLX(Map aampa);
}
