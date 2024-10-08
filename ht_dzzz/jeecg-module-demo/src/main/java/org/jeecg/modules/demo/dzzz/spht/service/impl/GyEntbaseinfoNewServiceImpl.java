package org.jeecg.modules.demo.dzzz.spht.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.demo.dzzz.spht.entity.GyEntbaseinfoNew;
import org.jeecg.modules.demo.dzzz.spht.mapper.GyEntbaseinfoNewMapper;
import org.jeecg.modules.demo.dzzz.spht.service.IGyEntbaseinfoNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: gy_entbaseinfo
 * @Author: jeecg-boot
 * @Date:   2024-09-18
 * @Version: V1.0
 */
@Service
@DS("multi-datasource1")
public class GyEntbaseinfoNewServiceImpl extends ServiceImpl<GyEntbaseinfoNewMapper, GyEntbaseinfoNew> implements IGyEntbaseinfoNewService {

    @Autowired
    private GyEntbaseinfoNewMapper gyEntbaseinfoNewMapper;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public List<GyEntbaseinfoNew> selectList(String shxydm) {
        return gyEntbaseinfoNewMapper.selectList(shxydm);
    }

}
