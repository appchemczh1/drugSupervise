package org.jeecg.modules.demo.dzzz.attachinfo.service;

import org.jeecg.modules.demo.dzzz.attachinfo.entity.Attachinfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Description: 附件储存表
 * @Author: jeecg-boot
 * @Date:   2024-04-07
 * @Version: V1.0
 */
public interface IAttachinfoService extends IService<Attachinfo> {

    public Attachinfo findAttachinfoByZSid(String zsid,String type,String status);

}
