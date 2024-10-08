package org.jeecg.modules.demo.dzzz.certinfo.service.impl;

import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildDylylqxscbapz;
import org.jeecg.modules.demo.dzzz.certinfo.mapper.CertchildDylylqxscbapzMapper;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertchildDylylqxscbapzService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: certchild_dylylqxscbapz
 * @Author: jeecg-boot
 * @Date:   2024-07-09
 * @Version: V1.0
 */
@Service
public class CertchildDylylqxscbapzServiceImpl extends ServiceImpl<CertchildDylylqxscbapzMapper, CertchildDylylqxscbapz> implements ICertchildDylylqxscbapzService {
	
	@Autowired
	private CertchildDylylqxscbapzMapper certchildDylylqxscbapzMapper;
	
	@Override
	public List<CertchildDylylqxscbapz> selectByMainId(String mainId,String glid) {
		return certchildDylylqxscbapzMapper.selectByMainId(mainId, glid);
	}
}
