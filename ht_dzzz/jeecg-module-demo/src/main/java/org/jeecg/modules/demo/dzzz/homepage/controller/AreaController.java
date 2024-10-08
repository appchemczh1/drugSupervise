package org.jeecg.modules.demo.dzzz.homepage.controller;


import org.jeecg.common.api.vo.Result;
import org.jeecg.modules.demo.dzzz.homepage.service.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class AreaController {

    @Autowired
    private IAreaService areaService;

    @PostMapping("/dzzz.homepage/otherPage/cityName")
    public Result<Map> getCityData() {
        Map resultMap = areaService.getCityData();
        return Result.OK(resultMap);
    }
}