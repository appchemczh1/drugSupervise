package org.jeecg.modules.demo.dzzz.spht.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.demo.dzzz.spht.entity.TJcZsYpscxkZcLs2;
import org.jeecg.modules.demo.dzzz.spht.mapper.TJcZsYpscxkZcLs2Mapper;
import org.jeecg.modules.demo.dzzz.spht.service.ITJcZsYpscxkZcLs2Service;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: t_jc_zs_ypscxk_zc_ls2
 * @Author: jeecg-boot
 * @Date:   2024-08-01
 * @Version: V1.0
 */
@Service
@DS("multi-datasource1")
public class TJcZsYpscxkZcLs2ServiceImpl extends ServiceImpl<TJcZsYpscxkZcLs2Mapper, TJcZsYpscxkZcLs2> implements ITJcZsYpscxkZcLs2Service {

}
