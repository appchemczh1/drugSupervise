package org.jeecg.modules.demo.dzzz.dataExchange.service;

import org.jeecg.modules.demo.dzzz.certinfo.entity.CertInfo;
import org.jeecg.modules.demo.dzzz.dataExchange.dto.SscjDataReqDto;
import org.jeecg.modules.demo.dzzz.dataExchange.entity.TYwSjXyb;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Description: t_yw_sj_xyb
 * @Author: jeecg-boot
 * @Date:   2024-07-29
 * @Version: V1.0
 */
public interface ITYwSjXybService extends IService<TYwSjXyb> {

    void saveXyb(SscjDataReqDto dto, CertInfo certInfo);

}
