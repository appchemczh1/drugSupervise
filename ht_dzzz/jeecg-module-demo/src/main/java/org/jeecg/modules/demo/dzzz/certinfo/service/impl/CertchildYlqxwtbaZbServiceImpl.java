package org.jeecg.modules.demo.dzzz.certinfo.service.impl;

import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildYlqxwtbaZb;
import org.jeecg.modules.demo.dzzz.certinfo.mapper.CertchildYlqxwtbaZbMapper;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertchildYlqxwtbaZbService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 第二三类医疗器械委托备案子表
 * @Author: jeecg-boot
 * @Date:   2024-06-17
 * @Version: V1.0
 */
@Service
public class CertchildYlqxwtbaZbServiceImpl extends ServiceImpl<CertchildYlqxwtbaZbMapper, CertchildYlqxwtbaZb> implements ICertchildYlqxwtbaZbService {
	
	@Autowired
	private CertchildYlqxwtbaZbMapper certchildYlqxwtbaZbMapper;
	
	@Override
	public List<CertchildYlqxwtbaZb> selectByMainId(String mainId,String glid) {
		return certchildYlqxwtbaZbMapper.selectByMainId(mainId, glid);
	}
}
