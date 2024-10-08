package org.jeecg.modules.demo.dzzz.attachinfo.service.impl;

import org.jeecg.modules.demo.dzzz.attachinfo.entity.Attachinfo;
import org.jeecg.modules.demo.dzzz.attachinfo.mapper.AttachinfoMapper;
import org.jeecg.modules.demo.dzzz.attachinfo.service.IAttachinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 附件储存表
 * @Author: jeecg-boot
 * @Date:   2024-04-07
 * @Version: V1.0
 */
@Service
public class AttachinfoServiceImpl extends ServiceImpl<AttachinfoMapper, Attachinfo> implements IAttachinfoService {

    @Autowired
    AttachinfoMapper attachinfoMapper;
    @Override
    public Attachinfo findAttachinfoByZSid(String zsid, String type, String status) {

        return attachinfoMapper.findAttachinfoByZSid(zsid,type,status);
    }
}
