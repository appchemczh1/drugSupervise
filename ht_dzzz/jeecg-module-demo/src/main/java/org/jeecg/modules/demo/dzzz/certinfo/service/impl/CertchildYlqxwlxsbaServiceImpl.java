package org.jeecg.modules.demo.dzzz.certinfo.service.impl;

import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildYlqxwlxsba;
import org.jeecg.modules.demo.dzzz.certinfo.mapper.CertchildYlqxwlxsbaMapper;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertchildYlqxwlxsbaService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: certchild_ylqxwlxsba
 * @Author: jeecg-boot
 * @Date:   2024-07-09
 * @Version: V1.0
 */
@Service
public class CertchildYlqxwlxsbaServiceImpl extends ServiceImpl<CertchildYlqxwlxsbaMapper, CertchildYlqxwlxsba> implements ICertchildYlqxwlxsbaService {
	
	@Autowired
	private CertchildYlqxwlxsbaMapper certchildYlqxwlxsbaMapper;
	
	@Override
	public List<CertchildYlqxwlxsba> selectByMainId(String mainId,String glid) {
		return certchildYlqxwlxsbaMapper.selectByMainId(mainId, glid);
	}
}
