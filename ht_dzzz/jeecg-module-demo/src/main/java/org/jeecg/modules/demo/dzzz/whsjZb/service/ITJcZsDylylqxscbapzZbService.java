package org.jeecg.modules.demo.dzzz.whsjZb.service;

import org.jeecg.modules.demo.dzzz.whsjZb.entity.TJcZsDylylqxscbapzZb;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Description: t_jc_zs_dylylqxscbapz_zb
 * @Author: jeecg-boot
 * @Date:   2024-08-30
 * @Version: V1.0
 */
public interface ITJcZsDylylqxscbapzZbService extends IService<TJcZsDylylqxscbapzZb> {

    /**
     * 查询子表数据
     *
     * @param mainId 主表id
     */
    List<TJcZsDylylqxscbapzZb> selectByMainId(String mainId);

}
