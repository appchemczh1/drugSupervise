package org.jeecg.modules.demo.dzzz.certInfoOperation.service;

import java.util.List;

import org.jeecg.modules.demo.dzzz.certInfoOperation.entity.CertInfoOperationRecord;
import org.jeecg.modules.demo.dzzz.dataExchange.dto.SscjDataReqDto;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Description: 操作记录表
 * @Author: jeecg-boot
 * @Date: 2024-04-17
 * @Version: V1.0
 */
public interface ICertInfoOperationRecordService extends IService<CertInfoOperationRecord> {

	/**
	 * 根据条件查询变更记录
	 * @return
	 */
	String selectBgJlByParams(SscjDataReqDto dto);

	default long countBgjlByZsid(String zsid) {
		LambdaQueryWrapper<CertInfoOperationRecord> query = new LambdaQueryWrapper<>();
		query.eq(CertInfoOperationRecord::getZsid, zsid);
		query.eq(CertInfoOperationRecord::getStutas, "20");
		return count(query);
	}

	default List<CertInfoOperationRecord> listBgjlByZsid(String zsid, boolean isAsc) {
		LambdaQueryWrapper<CertInfoOperationRecord> query = new LambdaQueryWrapper<>();
		query.eq(CertInfoOperationRecord::getZsid, zsid);
		query.eq(CertInfoOperationRecord::getStutas, "20");
		if (isAsc)
			query.orderByAsc(CertInfoOperationRecord::getCzsj);
		else
			query.orderByDesc(CertInfoOperationRecord::getCzsj);
		return list(query);
	}

	default Integer getMaxOperateNoByZsid(String zsid, Integer defaultVal) {
		QueryWrapper<CertInfoOperationRecord> query = new QueryWrapper<>();
		query.select("MAX(OPERATE_NO)");
		query.eq("STUTAS", "20");
		query.eq("ZSID", zsid);
		for (Object item : listObjs(query)) {
			if (null == item) continue;
			if (item instanceof Number) return ((Number) item).intValue();
		}
		return defaultVal;
	}

}
