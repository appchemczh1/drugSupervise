package org.jeecg.modules.demo.dzzz.certinfo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertInfo;

/**
 * @author huke
 * @date 2024年08月21日 11:22
 * 定时任务
 */
public interface ICertinfoJobService  extends IService<CertInfo> {
    void xzspToZsxt(String parameter);
}
