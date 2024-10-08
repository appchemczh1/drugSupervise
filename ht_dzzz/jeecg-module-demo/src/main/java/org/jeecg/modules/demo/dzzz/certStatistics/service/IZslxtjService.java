package org.jeecg.modules.demo.dzzz.certStatistics.service;


import org.jeecg.modules.demo.dzzz.certStatistics.entity.Zslxtj;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IZslxtjService extends IService<Zslxtj> {
    List<Zslxtj> selectZslxtjList(String startTime, String endTime);

}
