package org.jeecg.modules.demo.dzzz.spht.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.demo.dzzz.spht.entity.TJcZsYpckxszmZbLs2;
import org.jeecg.modules.demo.dzzz.spht.mapper.TJcZsYpckxszmZbLs2Mapper;
import org.jeecg.modules.demo.dzzz.spht.service.ITJcZsYpckxszmZbLs2Service;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: t_jc_zs_ypckxszm_zb_ls2
 * @Author: jeecg-boot
 * @Date:   2024-08-01
 * @Version: V1.0
 */
@Service
@DS("multi-datasource1")
public class TJcZsYpckxszmZbLs2ServiceImpl extends ServiceImpl<TJcZsYpckxszmZbLs2Mapper, TJcZsYpckxszmZbLs2> implements ITJcZsYpckxszmZbLs2Service {

}
