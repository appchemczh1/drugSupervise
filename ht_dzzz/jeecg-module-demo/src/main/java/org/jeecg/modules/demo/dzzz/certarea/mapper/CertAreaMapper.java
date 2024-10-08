package org.jeecg.modules.demo.dzzz.certarea.mapper;


import org.jeecg.modules.demo.dzzz.certarea.entity.CertArea;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description: 湖北区划表
 * @Author: jeecg-boot
 * @Date:   2024-05-29
 * @Version: V1.0
 */
public interface CertAreaMapper extends BaseMapper<CertArea> {

    /**
     * 根据区县名称查询地区信息
     * @param areaName
     * @return
     */
    CertArea selectAreaByAreaName(String areaName);

    /**
     * 根据区县CODE查询地区信息
     * @param areaCode
     * @return
     */
    CertArea selectAreaByAreaCode(String areaCode);

}
