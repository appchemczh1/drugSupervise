package org.jeecg.modules.demo.dzzz.certInfoOperation.service.impl;

import org.jeecg.modules.demo.dzzz.certInfoOperation.entity.CertInfoOperationRecord;
import org.jeecg.modules.demo.dzzz.certInfoOperation.mapper.CertInfoOperationRecordMapper;
import org.jeecg.modules.demo.dzzz.certInfoOperation.service.ICertInfoOperationRecordService;
import org.jeecg.modules.demo.dzzz.dataExchange.dto.SscjDataReqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 操作记录表
 * @Author: jeecg-boot
 * @Date:   2024-04-17
 * @Version: V1.0
 */
@Service
public class CertInfoOperationRecordServiceImpl extends ServiceImpl<CertInfoOperationRecordMapper, CertInfoOperationRecord> implements ICertInfoOperationRecordService {

    @Autowired
    private CertInfoOperationRecordMapper certInfoOperationRecordMapper;

    @Override
    public String selectBgJlByParams(SscjDataReqDto dto) {
        return certInfoOperationRecordMapper.selectBgJlByParams(dto);
    }
}
