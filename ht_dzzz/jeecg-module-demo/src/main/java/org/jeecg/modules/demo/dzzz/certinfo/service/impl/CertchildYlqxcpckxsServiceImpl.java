package org.jeecg.modules.demo.dzzz.certinfo.service.impl;

import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildYlqxcpckxs;
import org.jeecg.modules.demo.dzzz.certinfo.mapper.CertchildYlqxcpckxsMapper;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertchildYlqxcpckxsService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 医疗器械产品出口销售证明
 * @Author: jeecg-boot
 * @Date:   2024-06-17
 * @Version: V1.0
 */
@Service
public class CertchildYlqxcpckxsServiceImpl extends ServiceImpl<CertchildYlqxcpckxsMapper, CertchildYlqxcpckxs> implements ICertchildYlqxcpckxsService {
	
	@Autowired
	private CertchildYlqxcpckxsMapper certchildYlqxcpckxsMapper;
	
	@Override
	public List<CertchildYlqxcpckxs> selectByMainId(String mainId,String glid) {
		return certchildYlqxcpckxsMapper.selectByMainId(mainId, glid);
	}
}
