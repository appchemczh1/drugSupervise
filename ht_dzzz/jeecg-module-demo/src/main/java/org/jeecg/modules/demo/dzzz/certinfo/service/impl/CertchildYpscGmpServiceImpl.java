package org.jeecg.modules.demo.dzzz.certinfo.service.impl;

import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildYpscGmp;
import org.jeecg.modules.demo.dzzz.certinfo.mapper.CertchildYpscGmpMapper;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertchildYpscGmpService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 药瓶生产子表gmp
 * @Author: jeecg-boot
 * @Date:   2024-06-17
 * @Version: V1.0
 */
@Service
public class CertchildYpscGmpServiceImpl extends ServiceImpl<CertchildYpscGmpMapper, CertchildYpscGmp> implements ICertchildYpscGmpService {
	
	@Autowired
	private CertchildYpscGmpMapper certchildYpscGmpMapper;
	
	@Override
	public List<CertchildYpscGmp> selectByMainId(String mainId,String glid) {
		return certchildYpscGmpMapper.selectByMainId(mainId, glid);
	}
}
