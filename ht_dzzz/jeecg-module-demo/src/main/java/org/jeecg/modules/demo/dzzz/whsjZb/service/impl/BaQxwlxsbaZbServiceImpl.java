package org.jeecg.modules.demo.dzzz.whsjZb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jeecg.modules.demo.dzzz.whsjZb.entity.BaQxwlxsbaZb;
import org.jeecg.modules.demo.dzzz.whsjZb.mapper.BaQxwlxsbaZbMapper;
import org.jeecg.modules.demo.dzzz.whsjZb.service.IBaQxwlxsbaZbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Description: ba_qxwlxsba_zb
 * @Author: jeecg-boot
 * @Date:   2024-08-30
 * @Version: V1.0
 */
@Service
public class BaQxwlxsbaZbServiceImpl extends ServiceImpl<BaQxwlxsbaZbMapper, BaQxwlxsbaZb> implements IBaQxwlxsbaZbService {

    @Autowired
    private BaQxwlxsbaZbMapper baQxwlxsbaZbMapper;

    @Override
    public List<BaQxwlxsbaZb> selectByMainId(String mainId) {
        return baQxwlxsbaZbMapper.selectByMainId(mainId);
    }

}
