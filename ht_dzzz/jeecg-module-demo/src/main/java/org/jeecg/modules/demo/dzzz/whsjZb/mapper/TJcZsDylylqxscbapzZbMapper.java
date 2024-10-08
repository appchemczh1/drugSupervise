package org.jeecg.modules.demo.dzzz.whsjZb.mapper;

import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildDylylqxscbapz;
import org.jeecg.modules.demo.dzzz.whsjZb.entity.TJcZsDylylqxscbapzZb;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @Description: t_jc_zs_dylylqxscbapz_zb
 * @Author: jeecg-boot
 * @Date:   2024-08-30
 * @Version: V1.0
 */
public interface TJcZsDylylqxscbapzZbMapper extends BaseMapper<TJcZsDylylqxscbapzZb> {

    /**
     * 删除子表数据
     *
     * @param mainId 主表id
     */
    boolean deleteByMainId(@Param("mainId") String mainId);

    /**
     * 查询子表数据
     *
     * @param mainId 主表id
     */
    List<TJcZsDylylqxscbapzZb> selectByMainId(@Param("mainId") String mainId);

}
