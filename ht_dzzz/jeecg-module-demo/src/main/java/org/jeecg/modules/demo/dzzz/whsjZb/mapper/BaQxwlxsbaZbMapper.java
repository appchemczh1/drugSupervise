package org.jeecg.modules.demo.dzzz.whsjZb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.demo.dzzz.whsjZb.entity.BaQxwlxsbaZb;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description: ba_qxwlxsba_zb
 * @Author: jeecg-boot
 * @Date:   2024-08-30
 * @Version: V1.0
 */
public interface BaQxwlxsbaZbMapper extends BaseMapper<BaQxwlxsbaZb> {

    /**
     * 删除子表数据
     * @param mainId 主表id
     */
    boolean deleteByMainId(@Param("mainId") String mainId);

    /**
     * 查询子表数据
     *
     * @param mainId 主表id
     */
    List<BaQxwlxsbaZb> selectByMainId(@Param("mainId") String mainId);

}
