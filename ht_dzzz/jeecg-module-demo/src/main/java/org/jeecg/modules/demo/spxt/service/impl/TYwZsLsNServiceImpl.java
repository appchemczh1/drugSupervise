package org.jeecg.modules.demo.spxt.service.impl;

import org.jeecg.modules.demo.spxt.entity.TYwZsLsN;
import org.jeecg.modules.demo.spxt.mapper.TYwZsLsNMapper;
import org.jeecg.modules.demo.spxt.service.ITYwZsLsNService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: t_yw_zs_ls_n
 * @Author: jeecg-boot
 * @Date:   2024-06-20
 * @Version: V1.0
 */
@Service
public class TYwZsLsNServiceImpl extends ServiceImpl<TYwZsLsNMapper, TYwZsLsN> implements ITYwZsLsNService {

    @Autowired
    TYwZsLsNMapper tYwZsLsNMapper;
    @Override
    public void updateTywZS(String spid) {
        tYwZsLsNMapper.updateTywZS(spid);
    }

    @Override
    public void updateTywCzjlN(String spid) {
        tYwZsLsNMapper.updateTywCzjlN(spid);
    }
}
