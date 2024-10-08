package org.jeecg.modules.demo.dzzz.certinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.jeecg.modules.demo.dzzz.certInfoOperation.entity.CertInfoOperationRecord;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertInfo;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;

/**
 * <p>Created by Raofeicheng on 2024/8/22.</p>
 * @author Raofeicheng
 * @version 1.0
 */
public interface CertHandleMapper extends BaseMapper<CertInfo> {

	List<CertInfo> selectAll(@Param(Constants.WRAPPER) Wrapper<CertInfo> query, @Param("orderBy") String orderBy);

	List<CertInfo> selectAll(IPage<CertInfo> page, @Param(Constants.WRAPPER) Wrapper<CertInfo> query, @Param("orderBy") String orderBy);

	int copyToHistory(@Param("tableName") String tableName, @Param("zsid") String zsid, @Param("xzspId") String xzspId);

	int deleteByZsidAndXzspId(@Param("tableName") String tableName, @Param("zsid") String zsid, @Param("xzspId") String xzspId);

	@Update("UPDATE ${tableName} SET XZSPID=#{newXzspId},ZT=4 WHERE ZSID=#{zsid} AND XZSPID=#{xzspId}")
	int updateXzspId(@Param("tableName") String tableName, @Param("zsid") String zsid, @Param("xzspId") String xzspId, @Param("newXzspId") String newXzspId);

	@Update("UPDATE ${tableName} SET ZT=#{zt} WHERE ZSID=#{zsid} AND XZSPID=#{xzspId}")
	int updateZt(@Param("tableName") String tableName, @Param("zsid") String zsid, @Param("xzspId") String xzspId, @Param("zt") String zt);

	int mergeOperationRecordChange(@Param(Constants.WRAPPER) Wrapper<CertInfoOperationRecord> query);

}
