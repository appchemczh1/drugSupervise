package org.jeecg.modules.demo.dzzz.homepage.service;


import org.jeecg.modules.demo.dzzz.certStatistics.entity.Zslxtj;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.demo.dzzz.homepage.entity.ZsQydDto;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public interface IOtherPageService extends IService<Zslxtj> {

    void clearCache();

    Map getTypeList(String type);

    Map getListDetail(Map qmap) throws InvocationTargetException, IllegalAccessException;

    /**
     * 根据证书类型查询证照
     * @param map
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    Map ListDetailByCertType(Map map) throws InvocationTargetException, IllegalAccessException;

    IPage<ZsQydDto> ListZsQydDto(Map map) throws InvocationTargetException, IllegalAccessException;
}
