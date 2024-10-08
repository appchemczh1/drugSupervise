package org.jeecg.modules.demo.dzzz.information.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.demo.dzzz.information.entity.Information;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description: information1
 * @Author: jeecg-boot
 * @Date:   2024-06-24
 * @Version: V1.0
 */
public interface InformationMapper extends BaseMapper<Information> {

    List<Map> getZsbh(String shxydm);

    /**
     * 根据统一社会信用代码,查询证书数量
     * @param shxydm
     * @return
     */
    Integer selectZsCount(String shxydm);

}
