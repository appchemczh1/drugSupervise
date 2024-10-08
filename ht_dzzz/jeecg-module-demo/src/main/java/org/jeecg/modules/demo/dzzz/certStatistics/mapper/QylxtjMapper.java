package org.jeecg.modules.demo.dzzz.certStatistics.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.demo.dzzz.certStatistics.entity.Qylxtj;
import org.jeecg.modules.demo.dzzz.certStatistics.entity.Zslxtj;

import java.util.List;
import java.util.Map;


public interface QylxtjMapper extends BaseMapper<Qylxtj> {
    List<Qylxtj> selectQylxtjList(Map map);

    List<Map> getType(Map<String, Object> params);

    List<Map> getTypeYgz(Map queryDropMap);

    List<Map> getCertYgz(Map queryDropMap);

    List<Map> getTypeYgzByIds(@Param("zsids") List<String> zsids);
}
