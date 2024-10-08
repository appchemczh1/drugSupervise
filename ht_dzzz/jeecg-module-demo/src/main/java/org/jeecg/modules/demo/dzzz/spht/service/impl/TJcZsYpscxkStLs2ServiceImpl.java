package org.jeecg.modules.demo.dzzz.spht.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.demo.dzzz.spht.entity.TJcZsYpscxkStLs2;
import org.jeecg.modules.demo.dzzz.spht.mapper.TJcZsYpscxkStLs2Mapper;
import org.jeecg.modules.demo.dzzz.spht.service.ITJcZsYpscxkStLs2Service;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: t_jc_zs_ypscxk_st_ls2
 * @Author: jeecg-boot
 * @Date:   2024-08-01
 * @Version: V1.0
 */
@Service
@DS("multi-datasource1")
public class TJcZsYpscxkStLs2ServiceImpl extends ServiceImpl<TJcZsYpscxkStLs2Mapper, TJcZsYpscxkStLs2> implements ITJcZsYpscxkStLs2Service {

}
