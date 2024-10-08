package org.jeecg.modules.demo.dzzz.homepage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.jeecg.modules.demo.dzzz.certStatistics.entity.Qylxtj;

import java.util.List;
import java.util.Map;


public interface AdminPageMapper extends BaseMapper<Qylxtj> {

    int getdgzCount();

    List<Map> getDgzZs();

    List<Map<String,Long>> getYgzZs();

    Map getFirmInfo();

    List<Map> getZsfb();

    List<Map> getStampInfo(Map queryMap);

    int getYjCount();

    List<Map> getstampWarnList();
}
