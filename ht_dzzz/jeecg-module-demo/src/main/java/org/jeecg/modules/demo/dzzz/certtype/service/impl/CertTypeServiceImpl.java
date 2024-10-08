package org.jeecg.modules.demo.dzzz.certtype.service.impl;

import org.jeecg.modules.demo.dzzz.certtype.entity.CertType;
import org.jeecg.modules.demo.dzzz.certtype.mapper.CertTypeMapper;
import org.jeecg.modules.demo.dzzz.certtype.service.ICertTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;

/**
 * @Description: 证照类型
 * @Author: jeecg-boot
 * @Date:   2024-03-19
 * @Version: V1.0
 */
@Service
public class CertTypeServiceImpl extends ServiceImpl<CertTypeMapper, CertType> implements ICertTypeService {

    @Autowired
    private CertTypeMapper certTypeMapper;

    @Override
    public List<String> getCerttypeIdByClassification(String classification) {
        return certTypeMapper.getCerttypeIdByClassification(classification);
    }

    @Override
    public List<CertType> queryCerttypeByRole(Map<String, Object> param){
        return certTypeMapper.queryCerttypeByRole(param);
    }

    @Override
    public List<String> getCerttypeIdByClassificationAndRole(Map<String, Object> param){
        return certTypeMapper.getCerttypeIdByClassificationAndRole(param);
    }

}
