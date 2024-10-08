package org.jeecg.modules.demo.dzzz.certmatadataversion.service.impl;

import org.jeecg.modules.demo.dzzz.certmatadataversion.entity.CertMetadataVersion;
import org.jeecg.modules.demo.dzzz.certmatadataversion.entity.CertMetadata;
import org.jeecg.modules.demo.dzzz.certmatadataversion.mapper.CertMetadataMapper;
import org.jeecg.modules.demo.dzzz.certmatadataversion.mapper.CertMetadataVersionMapper;
import org.jeecg.modules.demo.dzzz.certmatadataversion.service.ICertMetadataVersionService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Collection;

/**
 * @Description: 证书元数据版本
 * @Author: jeecg-boot
 * @Date:   2024-03-25
 * @Version: V1.0
 */
@Service
public class CertMetadataVersionServiceImpl extends ServiceImpl<CertMetadataVersionMapper, CertMetadataVersion> implements ICertMetadataVersionService {

	@Autowired
	private CertMetadataVersionMapper certMetadataVersionMapper;
	@Autowired
	private CertMetadataMapper certMetadataMapper;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void saveMain(CertMetadataVersion certMetadataVersion, List<CertMetadata> certMetadataList) {
		certMetadataVersionMapper.insert(certMetadataVersion);
		if(certMetadataList!=null && certMetadataList.size()>0) {
			for(CertMetadata entity:certMetadataList) {
				//外键设置
				entity.setCertmetadataversionId(certMetadataVersion.getId());
				certMetadataMapper.insert(entity);
			}
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateMain(CertMetadataVersion certMetadataVersion,List<CertMetadata> certMetadataList) {
		certMetadataVersionMapper.updateById(certMetadataVersion);
		
		//1.先删除子表数据
		certMetadataMapper.deleteByMainId(certMetadataVersion.getId());
		
		//2.子表数据重新插入
		if(certMetadataList!=null && certMetadataList.size()>0) {
			for(CertMetadata entity:certMetadataList) {
				//外键设置
				entity.setCertmetadataversionId(certMetadataVersion.getId());
				certMetadataMapper.insert(entity);
			}
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delMain(String id) {
		certMetadataMapper.deleteByMainId(id);
		certMetadataVersionMapper.deleteById(id);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delBatchMain(Collection<? extends Serializable> idList) {
		for(Serializable id:idList) {
			certMetadataMapper.deleteByMainId(id.toString());
			certMetadataVersionMapper.deleteById(id);
		}
	}
	
}
