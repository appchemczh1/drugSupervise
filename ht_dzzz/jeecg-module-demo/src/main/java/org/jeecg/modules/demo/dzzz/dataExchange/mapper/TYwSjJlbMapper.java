package org.jeecg.modules.demo.dzzz.dataExchange.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.demo.dzzz.dataExchange.entity.TYwSjJlb;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.jeecg.modules.demo.dzzz.dataExchange.vo.SjjlbReqVo;
import org.jeecg.modules.demo.dzzz.dataExchange.vo.SjjlbResVo;

import java.util.List;

/**
 * @Description: t_yw_sj_jlb
 * @Author: jeecg-boot
 * @Date:   2024-07-02
 * @Version: V1.0
 */
public interface TYwSjJlbMapper extends BaseMapper<TYwSjJlb> {

    IPage<SjjlbResVo> selectPageList(@Param("vo") SjjlbReqVo vo, @Param("page") IPage page);

    List<SjjlbResVo> listByParams(@Param("vo") SjjlbReqVo vo);
}
