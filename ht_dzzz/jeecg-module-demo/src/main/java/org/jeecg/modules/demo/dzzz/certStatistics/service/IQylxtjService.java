package org.jeecg.modules.demo.dzzz.certStatistics.service;


import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.demo.dzzz.certStatistics.entity.Qylxtj;
import org.jeecg.modules.demo.dzzz.certStatistics.entity.Zslxtj;

import java.util.List;
import java.util.Map;

public interface IQylxtjService extends IService<Qylxtj> {
    List<Qylxtj> selectQylxtjList(Map map);

    List<Map<String, Integer>> ProcessData(List<Qylxtj>  list);

    List<Map> getType(Map<String, Object> params);

    List<Map> getTypeYgz(Map queryDropMap);

    List<Map> getCertYgz(Map queryDropMap);

    List<Map> getTypeYgzByIds(List<String> zsids);
}
