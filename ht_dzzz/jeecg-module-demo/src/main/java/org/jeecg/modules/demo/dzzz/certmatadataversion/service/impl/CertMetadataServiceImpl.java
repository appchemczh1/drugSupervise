package org.jeecg.modules.demo.dzzz.certmatadataversion.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.commons.lang.StringUtils;
import org.jeecg.modules.demo.dzzz.certmatadataversion.entity.CertMetadata;
import org.jeecg.modules.demo.dzzz.certmatadataversion.mapper.CertMetadataMapper;
import org.jeecg.modules.demo.dzzz.certmatadataversion.service.ICertMetadataService;
import org.jeecg.modules.demo.dzzz.certtype.entity.CertType;
import org.jeecg.modules.demo.dzzz.certtype.mapper.CertTypeMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

/**
 * @Description: 证书元数据表
 * @Author: jeecg-boot
 * @Date:   2024-03-25
 * @Version: V1.0
 */
@Service
public class CertMetadataServiceImpl extends ServiceImpl<CertMetadataMapper, CertMetadata> implements ICertMetadataService {
	
	@Autowired
	private CertMetadataMapper certMetadataMapper;

	@Autowired
	private CertTypeMapper certTypeMapper;
	
	@Override
	public List<CertMetadata> selectByMainId(String mainId) {
		return certMetadataMapper.selectByMainId(mainId);
	}

	@Override
	public List<CertMetadata> querycertinfo(String lm) {
		return certMetadataMapper.querycertinfo(lm);
	}

	@Override
	public List<CertMetadata> selectZsyByZslx(String zslx) {
		LambdaQueryWrapper<CertType> queryWrapper = new LambdaQueryWrapper();
		queryWrapper.eq(CertType :: getZslx, zslx);
		CertType certType = certTypeMapper.selectOne(queryWrapper);
		if (null == certType || StringUtils.isBlank(certType.getId())) {
			return Collections.emptyList();
		}
		return certMetadataMapper.selectZsyByCertTypeId(certType.getId(), null);
	}

	@Override
	public List<CertMetadata> selectZsyByCertTypeId(String certTypeId) {
		return certMetadataMapper.selectZsyByCertTypeId(certTypeId, null);
	}

	@Override
	public CertMetadata selectCertMetaByParams(String certTypeId, String zdmc) {
		List<CertMetadata> certMetadata = certMetadataMapper.selectZsyByCertTypeId(certTypeId, zdmc);
		if (CollectionUtils.isEmpty(certMetadata)) {
			return null;
		}
		return certMetadata.get(0);
	}
}
