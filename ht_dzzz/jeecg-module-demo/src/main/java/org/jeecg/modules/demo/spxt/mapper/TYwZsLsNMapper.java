package org.jeecg.modules.demo.spxt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.demo.spxt.entity.TYwZsLsN;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description: t_yw_zs_ls_n
 * @Author: jeecg-boot
 * @Date:   2024-06-20
 * @Version: V1.0
 */
public interface TYwZsLsNMapper extends BaseMapper<TYwZsLsN> {

    void updateTywZS(@Param("spid")String spid);
    void updateTywCzjlN(@Param("spid")String spid);
}
