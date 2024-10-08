package org.jeecg.modules.demo.dzzz.spht.mapper;

import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.demo.dzzz.spht.entity.GyEntbaseinfoNew;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @Description: gy_entbaseinfo
 * @Author: jeecg-boot
 * @Date:   2024-09-18
 * @Version: V1.0
 */
public interface GyEntbaseinfoNewMapper extends BaseMapper<GyEntbaseinfoNew> {

    /**
     * 根据社会信用代码查询企业信息
     * @param shxydm
     * @return
     */
    List<GyEntbaseinfoNew> selectList(@Param("shxydm") String shxydm);

}
