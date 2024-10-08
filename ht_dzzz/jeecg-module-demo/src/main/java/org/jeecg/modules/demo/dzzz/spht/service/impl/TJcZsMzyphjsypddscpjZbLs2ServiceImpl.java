package org.jeecg.modules.demo.dzzz.spht.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.demo.dzzz.spht.entity.TJcZsMzyphjsypddscpjZbLs2;
import org.jeecg.modules.demo.dzzz.spht.mapper.TJcZsMzyphjsypddscpjZbLs2Mapper;
import org.jeecg.modules.demo.dzzz.spht.service.ITJcZsMzyphjsypddscpjZbLs2Service;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: t_jc_zs_mzyphjsypddscpj_zb_ls2
 * @Author: jeecg-boot
 * @Date:   2024-08-01
 * @Version: V1.0
 */
@Service
@DS("multi-datasource1")
public class TJcZsMzyphjsypddscpjZbLs2ServiceImpl extends ServiceImpl<TJcZsMzyphjsypddscpjZbLs2Mapper, TJcZsMzyphjsypddscpjZbLs2> implements ITJcZsMzyphjsypddscpjZbLs2Service {

}
