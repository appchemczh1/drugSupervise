package org.jeecg.modules.demo.dzzz.certinfo.service.impl;

import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildYpckxkz;
import org.jeecg.modules.demo.dzzz.certinfo.mapper.CertchildYpckxkzMapper;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertchildYpckxkzService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 药品出口准许证
 * @Author: jeecg-boot
 * @Date:   2024-06-17
 * @Version: V1.0
 */
@Service
public class CertchildYpckxkzServiceImpl extends ServiceImpl<CertchildYpckxkzMapper, CertchildYpckxkz> implements ICertchildYpckxkzService {
	
	@Autowired
	private CertchildYpckxkzMapper certchildYpckxkzMapper;
	
	@Override
	public List<CertchildYpckxkz> selectByMainId(String mainId,String glid) {
		return certchildYpckxkzMapper.selectByMainId(mainId, glid);
	}
}
