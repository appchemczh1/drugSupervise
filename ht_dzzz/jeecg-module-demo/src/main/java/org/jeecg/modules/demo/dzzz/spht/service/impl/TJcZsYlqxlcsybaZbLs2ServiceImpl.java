package org.jeecg.modules.demo.dzzz.spht.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.demo.dzzz.spht.entity.TJcZsYlqxlcsybaZbLs2;
import org.jeecg.modules.demo.dzzz.spht.mapper.TJcZsYlqxlcsybaZbLs2Mapper;
import org.jeecg.modules.demo.dzzz.spht.service.ITJcZsYlqxlcsybaZbLs2Service;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: t_jc_zs_ylqxlcsyba_zb_ls2
 * @Author: jeecg-boot
 * @Date:   2024-08-01
 * @Version: V1.0
 */
@Service
@DS("multi-datasource1")
public class TJcZsYlqxlcsybaZbLs2ServiceImpl extends ServiceImpl<TJcZsYlqxlcsybaZbLs2Mapper, TJcZsYlqxlcsybaZbLs2> implements ITJcZsYlqxlcsybaZbLs2Service {

}
