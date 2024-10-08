package org.jeecg.modules.demo.dzzz.certinfo.service.impl;

import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildYpscZc;
import org.jeecg.modules.demo.dzzz.certinfo.mapper.CertInfoMapper;
import org.jeecg.modules.demo.dzzz.certinfo.mapper.CertchildYpscZcMapper;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertchildYpscZcService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 药品生产子表自产
 * @Author: jeecg-boot
 * @Date:   2024-03-27
 * @Version: V1.0
 */
@Service
public class CertchildYpscZcServiceImpl extends ServiceImpl<CertchildYpscZcMapper, CertchildYpscZc> implements ICertchildYpscZcService {
	
	@Autowired
	private CertchildYpscZcMapper certchildYpscZcMapper;

	
	@Override
	public List<CertchildYpscZc> selectByMainId(String mainId,String glid) {

		return certchildYpscZcMapper.selectByMainId(mainId, glid);
	}
}
