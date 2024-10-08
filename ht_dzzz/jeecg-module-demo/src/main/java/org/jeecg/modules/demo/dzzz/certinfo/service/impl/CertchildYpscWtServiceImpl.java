package org.jeecg.modules.demo.dzzz.certinfo.service.impl;

import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildYpscWt;
import org.jeecg.modules.demo.dzzz.certinfo.mapper.CertchildYpscWtMapper;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertchildYpscWtService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 药品生产子表委托
 * @Author: jeecg-boot
 * @Date:   2024-03-27
 * @Version: V1.0
 */
@Service
public class CertchildYpscWtServiceImpl extends ServiceImpl<CertchildYpscWtMapper, CertchildYpscWt> implements ICertchildYpscWtService {
	
	@Autowired
	private CertchildYpscWtMapper certchildYpscWtMapper;
	
	@Override
	public List<CertchildYpscWt> selectByMainId(String mainId,String  glid) {
		return certchildYpscWtMapper.selectByMainId(mainId, glid);
	}
}
