package org.jeecg.modules.demo.dzzz.certinfo.service.impl;

import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchirdYlqxlcsyba;
import org.jeecg.modules.demo.dzzz.certinfo.mapper.CertchirdYlqxlcsybaMapper;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertchirdYlqxlcsybaService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 医疗器械临床试验备案
 * @Author: jeecg-boot
 * @Date:   2024-06-17
 * @Version: V1.0
 */
@Service
public class CertchirdYlqxlcsybaServiceImpl extends ServiceImpl<CertchirdYlqxlcsybaMapper, CertchirdYlqxlcsyba> implements ICertchirdYlqxlcsybaService {
	
	@Autowired
	private CertchirdYlqxlcsybaMapper certchirdYlqxlcsybaMapper;
	
	@Override
	public List<CertchirdYlqxlcsyba> selectByMainId(String mainId,String glid) {
		return certchirdYlqxlcsybaMapper.selectByMainId(mainId, glid);
	}
}
