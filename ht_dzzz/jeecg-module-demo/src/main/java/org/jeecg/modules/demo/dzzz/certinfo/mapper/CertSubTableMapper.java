package org.jeecg.modules.demo.dzzz.certinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertSubTable;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.Mapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;

/**
 * <p>Created by Raofeicheng on 2024/8/26.</p>
 * @author Raofeicheng
 * @version 1.0
 */
public interface CertSubTableMapper extends Mapper<CertSubTable> {

	List<CertSubTable> selectList(@Param("tableName") String tableName, @Param(Constants.WRAPPER) Wrapper<CertSubTable> query);

	List<CertSubTable> selectList(@Param("tableName") String tableName, IPage<CertSubTable> page, @Param(Constants.WRAPPER) Wrapper<CertSubTable> query);

	int save(@Param("tableName") String tableName, @Param("columns") String[] columns, @Param("args") Object[] args);

	int saveBatch(@Param("tableName") String tableName, @Param("columns") String[] columns, @Param("args") Object[][] args);

	int copyToInsert(@Param("sourceTn") String sourceTn, @Param("targetTn") String targetTn, @Param(Constants.WRAPPER) Wrapper<CertSubTable> query);

	int copyToSave(@Param("sourceTn") String sourceTn, @Param("targetTn") String targetTn, @Param("newXzspId") String newXzspId,
				   @Param(Constants.WRAPPER) Wrapper<CertSubTable> query, @Param("columns") String... columns);

	int delete(@Param("tableName") String tableName, @Param(Constants.WRAPPER) Wrapper<CertSubTable> query);

}
