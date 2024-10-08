package org.jeecg.modules.demo.dzzz.spht.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.demo.dzzz.spht.entity.TJcZsYpscxkWtLs2;
import org.jeecg.modules.demo.dzzz.spht.mapper.TJcZsYpscxkWtLs2Mapper;
import org.jeecg.modules.demo.dzzz.spht.service.ITJcZsYpscxkWtLs2Service;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: t_jc_zs_ypscxk_wt_ls2
 * @Author: jeecg-boot
 * @Date:   2024-08-01
 * @Version: V1.0
 */
@Service
@DS("multi-datasource1")
public class TJcZsYpscxkWtLs2ServiceImpl extends ServiceImpl<TJcZsYpscxkWtLs2Mapper, TJcZsYpscxkWtLs2> implements ITJcZsYpscxkWtLs2Service {

}
