package org.jeecg.modules.demo.dzzz.certtype.service;

import java.util.List;
import java.util.Map;

import org.jeecg.common.util.CollectionUtils;
import org.jeecg.common.util.StringUtils;
import org.jeecg.modules.demo.dzzz.certtype.entity.CertType;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Description: 证照类型
 * @Author: jeecg-boot
 * @Date: 2024-03-19
 * @Version: V1.0
 */
public interface ICertTypeService extends IService<CertType> {

	List<String> getCerttypeIdByClassification(String classification);

	/**
	 * 根据用户角色获取证照类型
	 * @param param
	 * @return
	 */
	List<CertType> queryCerttypeByRole(Map<String, Object> param);

	/**
	 * 根据Classification和用户证照类型权限查询证照类型ID
	 * @param param
	 * @return
	 */
	List<String> getCerttypeIdByClassificationAndRole(Map<String, Object> param);

	default CertType getByZslx(String zslx, boolean isEfficient) {
		if (StringUtils.isBlank(zslx)) return null;
		LambdaQueryWrapper<CertType> query = new LambdaQueryWrapper<>();
		query.eq(CertType::getZslx, zslx);
		if (isEfficient) query.eq(CertType::getStatus, "2");
		List<CertType> list = list(query);
		return CollectionUtils.isNotEmpty(list) ? list.get(0) : null;
	}

}
