package org.jeecg.modules.demo.dzzz.spht.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.demo.dzzz.spht.entity.TJcZsYpscxkGmpLs2;
import org.jeecg.modules.demo.dzzz.spht.mapper.TJcZsYpscxkGmpLs2Mapper;
import org.jeecg.modules.demo.dzzz.spht.service.ITJcZsYpscxkGmpLs2Service;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: t_jc_zs_ypscxk_gmp_ls2
 * @Author: jeecg-boot
 * @Date:   2024-08-01
 * @Version: V1.0
 */
@Service
@DS("multi-datasource1")
public class TJcZsYpscxkGmpLs2ServiceImpl extends ServiceImpl<TJcZsYpscxkGmpLs2Mapper, TJcZsYpscxkGmpLs2> implements ITJcZsYpscxkGmpLs2Service {

}
