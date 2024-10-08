package org.jeecg.modules.demo.dzzz.spht.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.demo.dzzz.spht.entity.TJcZsYlqxscbaZbLs2;
import org.jeecg.modules.demo.dzzz.spht.mapper.TJcZsYlqxscbaZbLs2Mapper;
import org.jeecg.modules.demo.dzzz.spht.service.ITJcZsYlqxscbaZbLs2Service;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: t_jc_zs_ylqxscba_zb_ls2
 * @Author: jeecg-boot
 * @Date:   2024-08-01
 * @Version: V1.0
 */
@Service
@DS("multi-datasource1")
public class TJcZsYlqxscbaZbLs2ServiceImpl extends ServiceImpl<TJcZsYlqxscbaZbLs2Mapper, TJcZsYlqxscbaZbLs2> implements ITJcZsYlqxscbaZbLs2Service {

}
