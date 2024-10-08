package org.jeecg.modules.demo.dzzz.dataExchange.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.jeecg.modules.demo.dzzz.dataExchange.entity.TYwSjJlb;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.demo.dzzz.dataExchange.vo.SjjlbReqVo;
import org.jeecg.modules.demo.dzzz.dataExchange.vo.SjjlbResVo;

import java.util.List;

/**
 * @Description: t_yw_sj_jlb
 * @Author: jeecg-boot
 * @Date:   2024-07-02
 * @Version: V1.0
 */
public interface ITYwSjJlbService extends IService<TYwSjJlb> {

    IPage<SjjlbResVo> selectPageList(SjjlbReqVo vo, IPage page);

    List<SjjlbResVo> listByParams(SjjlbReqVo vo);

}
