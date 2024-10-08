package org.jeecg.modules.demo.dzzz.certinfo.service.impl;

import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildYpscSt;
import org.jeecg.modules.demo.dzzz.certinfo.mapper.CertchildYpscStMapper;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertchildYpscStService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 药品生产子表受托
 * @Author: jeecg-boot
 * @Date:   2024-03-27
 * @Version: V1.0
 */
@Service
public class CertchildYpscStServiceImpl extends ServiceImpl<CertchildYpscStMapper, CertchildYpscSt> implements ICertchildYpscStService {
	
	@Autowired
	private CertchildYpscStMapper certchildYpscStMapper;
	
	@Override
	public List<CertchildYpscSt> selectByMainId(String mainId,String glid) {
		return certchildYpscStMapper.selectByMainId(mainId, glid);
	}
}
