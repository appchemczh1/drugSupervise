package org.jeecg.modules.demo.dzzz.certinfo.service.impl;

import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildCkomyly;
import org.jeecg.modules.demo.dzzz.certinfo.mapper.CertchildCkomylyMapper;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertchildCkomylyService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 出口欧盟原料
 * @Author: jeecg-boot
 * @Date:   2024-06-17
 * @Version: V1.0
 */
@Service
public class CertchildCkomylyServiceImpl extends ServiceImpl<CertchildCkomylyMapper, CertchildCkomyly> implements ICertchildCkomylyService {
	
	@Autowired
	private CertchildCkomylyMapper certchildCkomylyMapper;
	
	@Override
	public List<CertchildCkomyly> selectByMainId(String mainId,String glid) {
		return certchildCkomylyMapper.selectByMainId(mainId, glid);
	}
}
