package org.jeecg.modules.demo.dzzz.spht.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.demo.dzzz.spht.entity.TJcZsYlqxcpckxszmZbLs2;
import org.jeecg.modules.demo.dzzz.spht.mapper.TJcZsYlqxcpckxszmZbLs2Mapper;
import org.jeecg.modules.demo.dzzz.spht.service.ITJcZsYlqxcpckxszmZbLs2Service;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: t_jc_zs_ylqxcpckxszm_zb_ls2
 * @Author: jeecg-boot
 * @Date:   2024-08-01
 * @Version: V1.0
 */
@Service
@DS("multi-datasource1")
public class TJcZsYlqxcpckxszmZbLs2ServiceImpl extends ServiceImpl<TJcZsYlqxcpckxszmZbLs2Mapper, TJcZsYlqxcpckxszmZbLs2> implements ITJcZsYlqxcpckxszmZbLs2Service {

}
