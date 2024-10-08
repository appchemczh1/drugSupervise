package org.jeecg.modules.demo.dzzz.certarea.service.impl;

import org.jeecg.modules.demo.dzzz.certarea.entity.CertArea;
import org.jeecg.modules.demo.dzzz.certarea.mapper.CertAreaMapper;
import org.jeecg.modules.demo.dzzz.certarea.service.ICertAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 湖北区划表
 * @Author: jeecg-boot
 * @Date:   2024-05-29
 * @Version: V1.0
 */
@Service
public class CertAreaServiceImpl extends ServiceImpl<CertAreaMapper, CertArea> implements ICertAreaService {

    @Autowired
    private CertAreaMapper certAreaMapper;

    @Override
    public CertArea selectAreaByAreaName(String areaName) {
        return certAreaMapper.selectAreaByAreaName(areaName);
    }

    @Override
    public CertArea selectAreaByAreaCode(String areaCode) {
        return certAreaMapper.selectAreaByAreaCode(areaCode);
    }

}
