package org.jeecg.modules.demo.dzzz.spht.service;

import org.jeecg.modules.demo.dzzz.spht.entity.GyEntbaseinfoNew;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Description: gy_entbaseinfo
 * @Author: jeecg-boot
 * @Date:   2024-09-18
 * @Version: V1.0
 */
public interface IGyEntbaseinfoNewService extends IService<GyEntbaseinfoNew> {

    /**
     * 根据社会信用代码查询企业信息
     * @param shxydm
     * @return
     */
    List<GyEntbaseinfoNew> selectList(String shxydm);

}
