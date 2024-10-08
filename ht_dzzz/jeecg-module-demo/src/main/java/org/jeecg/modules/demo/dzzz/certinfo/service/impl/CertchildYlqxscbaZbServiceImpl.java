package org.jeecg.modules.demo.dzzz.certinfo.service.impl;

import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildYlqxscbaZb;
import org.jeecg.modules.demo.dzzz.certinfo.mapper.CertchildYlqxscbaZbMapper;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertchildYlqxscbaZbService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 二三类医疗机械生产子表
 * @Author: jeecg-boot
 * @Date:   2024-06-17
 * @Version: V1.0
 */
@Service
public class CertchildYlqxscbaZbServiceImpl extends ServiceImpl<CertchildYlqxscbaZbMapper, CertchildYlqxscbaZb> implements ICertchildYlqxscbaZbService {
	
	@Autowired
	private CertchildYlqxscbaZbMapper certchildYlqxscbaZbMapper;
	
	@Override
	public List<CertchildYlqxscbaZb> selectByMainId(String mainId,String glid) {
		return certchildYlqxscbaZbMapper.selectByMainId(mainId, glid);
	}
}
