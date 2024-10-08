package org.jeecg.modules.demo.dzzz.certStatistics.service.impl;

import org.jeecg.modules.demo.dzzz.certStatistics.entity.Zslxtj;
import org.jeecg.modules.demo.dzzz.certStatistics.mapper.ZslxtjMapper;
import org.jeecg.modules.demo.dzzz.certStatistics.service.IZslxtjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;


@Service
public class ZslxtjServiceImpl extends ServiceImpl<ZslxtjMapper, Zslxtj> implements IZslxtjService {
    @Autowired
    private ZslxtjMapper zslxtjMapper;

    @Override
    public List<Zslxtj> selectZslxtjList(String startTime, String endTime) {
        List<Zslxtj> zslxtjs = zslxtjMapper.selectZslxtjList(startTime, endTime);
        return zslxtjs ;
    }
}
