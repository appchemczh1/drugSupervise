package org.jeecg.modules.demo.dzzz.whsjZb.service;

import org.jeecg.modules.demo.dzzz.whsjZb.entity.BaQxwlxsbaZb;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Description: ba_qxwlxsba_zb
 * @Author: jeecg-boot
 * @Date:   2024-08-30
 * @Version: V1.0
 */
public interface IBaQxwlxsbaZbService extends IService<BaQxwlxsbaZb> {

    /**
     * 查询子表数据
     *
     * @param mainId 主表id
     */
    List<BaQxwlxsbaZb> selectByMainId(String mainId);

}
