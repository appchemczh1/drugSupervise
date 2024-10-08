package org.jeecg.modules.demo.dzzz.certmode.service;

import java.util.List;

import org.jeecg.modules.demo.dzzz.certmode.entity.CertMode;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Description: 证书模板
 * @Author: jeecg-boot
 * @Date: 2024-03-20
 * @Version: V1.0
 */
public interface ICertModeService extends IService<CertMode> {

	default List<CertMode> listByCertTypeId(String certTypeId) {
		LambdaQueryWrapper<CertMode> query = new LambdaQueryWrapper<>();
		query.eq(CertMode::getCerttypeid, certTypeId);
		query.eq(CertMode::getModestatus, "1");
		query.orderByAsc(CertMode::getTemplateType);
		query.orderByAsc(CertMode::getOrderNum);
		return list(query);
	}

}
