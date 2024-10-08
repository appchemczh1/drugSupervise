package org.jeecg.modules.demo.dzzz.whsjZb.service.impl;

import org.jeecg.modules.demo.dzzz.whsjZb.entity.TJcZsDylylqxscbapzZb;
import org.jeecg.modules.demo.dzzz.whsjZb.mapper.TJcZsDylylqxscbapzZbMapper;
import org.jeecg.modules.demo.dzzz.whsjZb.service.ITJcZsDylylqxscbapzZbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * @Description: t_jc_zs_dylylqxscbapz_zb
 * @Author: jeecg-boot
 * @Date:   2024-08-30
 * @Version: V1.0
 */
@Service
public class TJcZsDylylqxscbapzZbServiceImpl extends ServiceImpl<TJcZsDylylqxscbapzZbMapper, TJcZsDylylqxscbapzZb> implements ITJcZsDylylqxscbapzZbService {

    @Autowired
    private TJcZsDylylqxscbapzZbMapper tJcZsDylylqxscbapzZbMapper;

    @Override
    public List<TJcZsDylylqxscbapzZb> selectByMainId(String mainId) {
        return tJcZsDylylqxscbapzZbMapper.selectByMainId(mainId);
    }

}
