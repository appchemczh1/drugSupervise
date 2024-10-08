package org.jeecg.modules.demo.dzzz.certinfo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ArrayUtils;
import org.jeecg.common.util.CollectionUtils;
import org.jeecg.common.util.StringUtils;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertInfo;
import org.jeecg.modules.demo.dzzz.certinfo.mapper.CertHandleMapper;
import org.jeecg.modules.demo.dzzz.certinfo.vo.CertInfoPage;
import org.jeecg.modules.demo.dzzz.certmatadataversion.entity.CertMetadata;
import org.jeecg.modules.demo.dzzz.certtype.entity.CertType;
import org.jeecg.modules.demo.dzzz.wgz.entity.ZsYwxxb;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>Created by Raofeicheng on 2024/8/21.</p>
 * @author Raofeicheng
 * @version 1.0
 */
public interface ICertHandleService extends IService<CertInfo> {

	CertHandleMapper getCertHandleMapper();

	default List<CertInfo> listByIds(String... ids) {
		if (ArrayUtils.isEmpty(ids)) return new ArrayList<>();
		LambdaQueryWrapper<CertInfo> query = new LambdaQueryWrapper<>();
		query.in(CertInfo::getId, Arrays.asList(ids).toArray());
		return list(query);
	}

	default List<CertInfo> listAll(Wrapper<CertInfo> query) {
		String orderBy = query.getExpression().getOrderBy().getSqlSegment();
		query.getExpression().getOrderBy().clear();
		return getCertHandleMapper().selectAll(query, orderBy);
	}

	default <E extends IPage<CertInfo>> E pageAll(E page, Wrapper<CertInfo> query) {
		String orderBy = query.getExpression().getOrderBy().getSqlSegment();
		query.getExpression().getOrderBy().clear();
		List<CertInfo> list = getCertHandleMapper().selectAll(page, query, orderBy);
		page.setRecords(list);
		return page;
	}

	default CertInfo getByZsid(String zsid, boolean isEfficient) {
		if (StringUtils.isBlank(zsid)) return null;
		LambdaQueryWrapper<CertInfo> query = new LambdaQueryWrapper<>();
		query.eq(CertInfo::getZsid, zsid);
		if (isEfficient) query.eq(CertInfo::getYxzt, "10");
		List<CertInfo> list = list(query);
		return CollectionUtils.isNotEmpty(list) ? list.get(0) : null;
	}

	List<CertMetadata> getCertMetadata(String cardTypeId, String versionId);

	/**
	 * 批量盖章（未盖章表）
	 * @param ids           待盖章表id
	 * @param type          操作类型 null盖章，sczz生成证照
	 * @param signatureName 签章名称
	 * @param keySn         签章uKey
	 * @return 错误信息
	 */
	String batchGzFromWgz(String[] ids, String type, String signatureName, String keySn, HttpServletRequest request);

	/**
	 * 批量盖章（已盖章表）
	 * @param ids           待盖章表id
	 * @param type          操作类型 null盖章，sczz生成证照
	 * @param signatureName 签章名称
	 * @param keySn         签章uKey
	 * @return 错误信息
	 */
	String batchGzFromYgz(String[] ids, String type, String signatureName, String keySn, HttpServletRequest request);

	String batchGzFromWgz(List<ZsYwxxb> certInfoList, String type, String signatureName, String keySn, HttpServletRequest request);

	String batchGzFromYgz(List<CertInfo> certInfoList, String type, String signatureName, String keySn, HttpServletRequest request);

	/**
	 * 取消盖章
	 */
	String cancelGz(CertInfo cert, String qxGzyy);

	/**
	 * 注销证书
	 */
	void certInfoZx(String zsid);

	/**
	 * 新增待盖章记录
	 */
	String saveZsYwxxb(CertType certType, ZsYwxxb entity);

	/**
	 * 维护申请
	 * <ol>
	 * <li>待盖章记录维护申请后隐藏（不能盖章，知道申请通过或拒绝后才可以）</li>
	 * <li>已盖章记录维护申请后不变，但是审核通过时必须确保待盖章记录中没有同证书记录</li>
	 * </ol>
	 * @param pageEntity 页面证书实体
	 * @return 错误信息
	 */
	String maintainApply(CertInfoPage pageEntity);

	String maintainPass(CertInfoPage pageEntity);

	String maintainBack(CertInfoPage pageEntity);

	String saveOrUpdateBl(CertInfoPage pageEntity);

	String zhuXiao(CertInfoPage pageEntity);

}
