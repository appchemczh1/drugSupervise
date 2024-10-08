package org.jeecg.modules.demo.dzzz.spht.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.demo.dzzz.spht.entity.BaQxwlxsbaZbLs2;
import org.jeecg.modules.demo.dzzz.spht.mapper.BaQxwlxsbaZbLs2Mapper;
import org.jeecg.modules.demo.dzzz.spht.service.IBaQxwlxsbaZbLs2Service;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: ba_qxwlxsba_zb_ls2
 * @Author: jeecg-boot
 * @Date:   2024-08-01
 * @Version: V1.0
 */
@Service
@DS("multi-datasource1")
public class BaQxwlxsbaZbLs2ServiceImpl extends ServiceImpl<BaQxwlxsbaZbLs2Mapper, BaQxwlxsbaZbLs2> implements IBaQxwlxsbaZbLs2Service {

}
