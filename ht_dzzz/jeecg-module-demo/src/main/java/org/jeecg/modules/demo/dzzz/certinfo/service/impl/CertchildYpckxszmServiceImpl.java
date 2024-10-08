package org.jeecg.modules.demo.dzzz.certinfo.service.impl;

import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildYpckxszm;
import org.jeecg.modules.demo.dzzz.certinfo.mapper.CertchildYpckxszmMapper;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertchildYpckxszmService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 药品出口销售证明
 * @Author: jeecg-boot
 * @Date:   2024-06-17
 * @Version: V1.0
 */
@Service
public class CertchildYpckxszmServiceImpl extends ServiceImpl<CertchildYpckxszmMapper, CertchildYpckxszm> implements ICertchildYpckxszmService {
	
	@Autowired
	private CertchildYpckxszmMapper certchildYpckxszmMapper;
	
	@Override
	public List<CertchildYpckxszm> selectByMainId(String mainId,String glid) {
		return certchildYpckxszmMapper.selectByMainId(mainId, glid);
	}
}
