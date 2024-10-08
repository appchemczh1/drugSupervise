package org.jeecg.modules.demo.dzzz.spht.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.demo.dzzz.spht.entity.TJcZsYpckzxzZbLs2;
import org.jeecg.modules.demo.dzzz.spht.mapper.TJcZsYpckzxzZbLs2Mapper;
import org.jeecg.modules.demo.dzzz.spht.service.ITJcZsYpckzxzZbLs2Service;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: t_jc_zs_ypckzxz_zb_ls2
 * @Author: jeecg-boot
 * @Date:   2024-08-01
 * @Version: V1.0
 */
@Service
@DS("multi-datasource1")
public class TJcZsYpckzxzZbLs2ServiceImpl extends ServiceImpl<TJcZsYpckzxzZbLs2Mapper, TJcZsYpckzxzZbLs2> implements ITJcZsYpckzxzZbLs2Service {

}
