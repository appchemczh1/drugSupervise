package org.jeecg.modules.demo.dzzz.homepage.service;


import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.demo.dzzz.certStatistics.entity.Qylxtj;

import java.util.List;
import java.util.Map;

public interface IAdminPageService extends IService<Qylxtj> {

    Map getDgz();

    Map getZsfb();

    Map getStampRank();

    Map getFirmInfo();

    Map getinfo(String name);

    Map stampInfo();

    Map getstampWarnList();
}
