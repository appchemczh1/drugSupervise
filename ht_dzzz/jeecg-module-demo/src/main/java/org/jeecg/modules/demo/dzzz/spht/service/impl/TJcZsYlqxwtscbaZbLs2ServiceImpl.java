package org.jeecg.modules.demo.dzzz.spht.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.demo.dzzz.spht.entity.TJcZsYlqxwtscbaZbLs2;
import org.jeecg.modules.demo.dzzz.spht.mapper.TJcZsYlqxwtscbaZbLs2Mapper;
import org.jeecg.modules.demo.dzzz.spht.service.ITJcZsYlqxwtscbaZbLs2Service;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: t_jc_zs_ylqxwtscba_zb_ls2
 * @Author: jeecg-boot
 * @Date:   2024-08-01
 * @Version: V1.0
 */
@Service
@DS("multi-datasource1")
public class TJcZsYlqxwtscbaZbLs2ServiceImpl extends ServiceImpl<TJcZsYlqxwtscbaZbLs2Mapper, TJcZsYlqxwtscbaZbLs2> implements ITJcZsYlqxwtscbaZbLs2Service {

}
