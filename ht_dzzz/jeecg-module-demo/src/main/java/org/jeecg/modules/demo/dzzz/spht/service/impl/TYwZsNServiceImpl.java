package org.jeecg.modules.demo.dzzz.spht.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.demo.dzzz.spht.entity.TYwZsN;
import org.jeecg.modules.demo.dzzz.spht.mapper.TYwZsNMapper;
import org.jeecg.modules.demo.dzzz.spht.service.ITYwZsNService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: t_yw_zs_n
 * @Author: jeecg-boot
 * @Date:   2024-07-16
 * @Version: V1.0
 */
@Service
@DS("multi-datasource1")
public class TYwZsNServiceImpl extends ServiceImpl<TYwZsNMapper, TYwZsN> implements ITYwZsNService {

}
