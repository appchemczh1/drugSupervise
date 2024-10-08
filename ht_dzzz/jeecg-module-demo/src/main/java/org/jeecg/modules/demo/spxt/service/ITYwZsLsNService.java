package org.jeecg.modules.demo.spxt.service;

import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.demo.spxt.entity.TYwZsLsN;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Description: t_yw_zs_ls_n
 * @Author: jeecg-boot
 * @Date:   2024-06-20
 * @Version: V1.0
 */
public interface ITYwZsLsNService extends IService<TYwZsLsN> {

     void updateTywZS(String spid);
     void updateTywCzjlN(String spid);

}
