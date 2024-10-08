package org.jeecg.modules.demo.dzzz.certinfo.service.impl;

import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildMzyphjsypddsc;
import org.jeecg.modules.demo.dzzz.certinfo.mapper.CertchildMzyphjsypddscMapper;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertchildMzyphjsypddscService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 麻醉药品和精神药品定点生产批件
 * @Author: jeecg-boot
 * @Date:   2024-06-17
 * @Version: V1.0
 */
@Service
public class CertchildMzyphjsypddscServiceImpl extends ServiceImpl<CertchildMzyphjsypddscMapper, CertchildMzyphjsypddsc> implements ICertchildMzyphjsypddscService {
	
	@Autowired
	private CertchildMzyphjsypddscMapper certchildMzyphjsypddscMapper;
	
	@Override
	public List<CertchildMzyphjsypddsc> selectByMainId(String mainId,String glid) {
		return certchildMzyphjsypddscMapper.selectByMainId(mainId, glid);
	}
}
