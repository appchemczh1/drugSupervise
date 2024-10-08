package org.jeecg.modules.demo.dzzz.dataExchange.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.jeecg.modules.demo.dzzz.dataExchange.entity.TYwSjJlb;
import org.jeecg.modules.demo.dzzz.dataExchange.mapper.TYwSjJlbMapper;
import org.jeecg.modules.demo.dzzz.dataExchange.service.ITYwSjJlbService;
import org.jeecg.modules.demo.dzzz.dataExchange.vo.SjjlbReqVo;
import org.jeecg.modules.demo.dzzz.dataExchange.vo.SjjlbResVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * @Description: t_yw_sj_jlb
 * @Author: jeecg-boot
 * @Date:   2024-07-02
 * @Version: V1.0
 */
@Service
public class TYwSjJlbServiceImpl extends ServiceImpl<TYwSjJlbMapper, TYwSjJlb> implements ITYwSjJlbService {

    @Autowired
    private TYwSjJlbMapper ywSjJlbMapper;

    @Override
    public IPage<SjjlbResVo> selectPageList(SjjlbReqVo vo, IPage page) {
        return ywSjJlbMapper.selectPageList(vo, page);
    }

    @Override
    public List<SjjlbResVo> listByParams(SjjlbReqVo vo) {
        return ywSjJlbMapper.listByParams(vo);
    }

}
