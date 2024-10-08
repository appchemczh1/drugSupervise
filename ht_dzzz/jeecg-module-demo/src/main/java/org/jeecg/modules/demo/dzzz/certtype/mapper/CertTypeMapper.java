package org.jeecg.modules.demo.dzzz.certtype.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.jeecg.modules.demo.dzzz.certtype.entity.CertType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * @Description: 证照类型
 * @Author: jeecg-boot
 * @Date:   2024-03-19
 * @Version: V1.0
 */
public interface CertTypeMapper extends BaseMapper<CertType> {

    List<String> getCerttypeIdByClassification(@Param("classification") String classification);

    List<CertType> queryCerttypeByRole(Map<String, Object> param);

    /**
     * 根据Classification和用户证照类型权限查询证照类型ID
     * @param param
     * @return
     */
    List<String> getCerttypeIdByClassificationAndRole(Map<String, Object> param);

}
