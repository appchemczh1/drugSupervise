package org.jeecg.modules.demo.dzzz.certinfo.service.impl;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.modules.demo.dzzz.certinfo.mapper.CertSubTableMapper;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertSubTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>Created by Raofeicheng on 2024/8/26.</p>
 * @author Raofeicheng
 * @version 1.0
 */
@Slf4j
@Getter
@Service
public class CertSubTableServiceImpl implements ICertSubTableService {

	@Autowired
	public CertSubTableServiceImpl(CertSubTableMapper baseMapper) {
		this.baseMapper = baseMapper;
	}

	protected CertSubTableMapper baseMapper;

}
