package org.jeecg.modules.demo.dzzz.certinfo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.jeecg.common.util.CollectionUtils;
import org.jeecg.common.util.StringUtils;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertSubTable;
import org.jeecg.modules.demo.dzzz.certinfo.mapper.CertSubTableMapper;
import org.jeecg.modules.demo.dzzz.util.CertUtils;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>Created by Raofeicheng on 2024/8/26.</p>
 * @author Raofeicheng
 * @version 1.0
 */
public interface ICertSubTableService {

	CertSubTableMapper getBaseMapper();

	default List<CertSubTable> list(CertUtils.CertSubTableEnum subTableEnum, Wrapper<CertSubTable> query) {
		return list(subTableEnum, "4", query);
	}

	default List<CertSubTable> list(CertUtils.CertSubTableEnum subTableEnum, String zt, Wrapper<CertSubTable> query) {
		return getBaseMapper().selectList(subTableEnum.getTableName(zt), query);
	}

	default <E extends IPage<CertSubTable>> E page(CertUtils.CertSubTableEnum subTableEnum, E page, Wrapper<CertSubTable> query) {
		return page(subTableEnum, "4", page, query);
	}

	default <E extends IPage<CertSubTable>> E page(CertUtils.CertSubTableEnum subTableEnum, String zt, E page, Wrapper<CertSubTable> query) {
		List<CertSubTable> list = getBaseMapper().selectList(subTableEnum.getTableName(zt), page, query);
		page.setRecords(list);
		return page;
	}

	@Transactional
	default int save(CertUtils.CertSubTableEnum subTableEnum, CertSubTable entity, String zt) {
		if (StringUtils.isBlank(subTableEnum.getTableName()) || ArrayUtils.isEmpty(subTableEnum.getColumns())) return 0;
		List<Object> args = new ArrayList<>();
		for (String column : subTableEnum.getColumns()) {
			args.add(entity.get(oConvertUtils.camelName(column)));
		}
		return getBaseMapper().save(subTableEnum.getTableName(zt), subTableEnum.getColumns(), args.toArray());
	}

	@Transactional
	default int saveBatch(CertUtils.CertSubTableEnum subTableEnum, List<CertSubTable> data, String zt) {
		if (StringUtils.isBlank(subTableEnum.getTableName()) || ArrayUtils.isEmpty(subTableEnum.getColumns()) || CollectionUtils.isEmpty(data)) return 0;
		List<Object[]> array = new ArrayList<>();
		for (CertSubTable item : data) {
			List<Object> args = new ArrayList<>();
			for (String column : subTableEnum.getColumns()) {
				args.add(item.get(oConvertUtils.camelName(column)));
			}
			array.add(args.toArray());
		}
		return getBaseMapper().saveBatch(subTableEnum.getTableName(zt), subTableEnum.getColumns(), array.toArray(new Object[0][]));
	}

	/**
	 * 临时表复制到待盖章表
	 */
	@Transactional
	default String copyToDgz(CertUtils.CertSubTableEnum subTableEnum, Wrapper<CertSubTable> query) {
		copy(subTableEnum.getTableNameLs(), subTableEnum.getTableNameDgz(), query, null, true, subTableEnum.getColumns());
		return null;
	}

	/**
	 * 盖章
	 */
	@Transactional
	default String copyToGz(CertUtils.CertSubTableEnum subTableEnum, Wrapper<CertSubTable> query, String newXzspId) {
		copy(subTableEnum.getTableNameDgz(), subTableEnum.getTableNameZs(), query, newXzspId, true, subTableEnum.getColumns());
		return null;
	}

	/**
	 * 取消盖章
	 */
	@Transactional
	default String copyToCancel(CertUtils.CertSubTableEnum subTableEnum, Wrapper<CertSubTable> query) {
		copy(subTableEnum.getTableNameZs(), subTableEnum.getTableNameDgz(), query, null, false, subTableEnum.getColumns());
		return null;
	}

	/**
	 * 证书子表复制
	 * @param sourceTn 源表
	 * @param targetTn 目标表
	 * @param query    源表查询条件
	 * @param isDelete 是否删除源表数据
	 * @param columns  需要复制或修改的字段
	 */
	@Transactional
	default String copy(String sourceTn, String targetTn, Wrapper<CertSubTable> query, String newXzspId, boolean isDelete, String... columns) {
		getBaseMapper().copyToSave(sourceTn, targetTn, newXzspId, query, columns);
		if (isDelete) getBaseMapper().delete(sourceTn, query);
		return null;
	}

	@Transactional
	default int removeByXzspId(CertUtils.CertSubTableEnum subTableEnum, String zt, String xzspId) {
		QueryWrapper<CertSubTable> query = new QueryWrapper<>();
		query.eq("XZSPID", xzspId);
		return getBaseMapper().delete(subTableEnum.getTableName(zt), query);
	}

}
