package org.jeecg.modules.demo.dzzz.certInfoOperation.mapper;


import org.jeecg.modules.demo.dzzz.certInfoOperation.entity.CertInfoOperationRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.jeecg.modules.demo.dzzz.dataExchange.dto.SscjDataReqDto;

/**
 * @Description: 操作记录表
 * @Author: jeecg-boot
 * @Date:   2024-04-17
 * @Version: V1.0
 */
public interface CertInfoOperationRecordMapper extends BaseMapper<CertInfoOperationRecord> {

    /**
     * 根据条件查询变更记录
     * @return
     */
    String selectBgJlByParams(SscjDataReqDto dto);

}
