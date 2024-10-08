package org.jeecg.modules.demo.dzzz.information.service.impl;

import org.jeecg.modules.demo.dzzz.information.entity.Information;
import org.jeecg.modules.demo.dzzz.information.mapper.InformationMapper;
import org.jeecg.modules.demo.dzzz.information.service.IInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;

/**
 * @Description: information1
 * @Author: jeecg-boot
 * @Date:   2024-06-24
 * @Version: V1.0
 */


@Service
public class InformationServiceImpl extends ServiceImpl<InformationMapper, Information> implements IInformationService {
    @Autowired
    private InformationMapper informationMapper;
    @Override
    public List<Map> getZsbh(String shxydm) {
        return informationMapper.getZsbh(shxydm);
    }

    @Override
    public Integer selectZsCount(String shxydm) {
        return informationMapper.selectZsCount(shxydm);
    }

}
