package org.jeecg.modules.demo.dzzz.homepage.controller;




import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.jeecg.common.api.vo.Result;
import org.jeecg.modules.demo.dzzz.certStatistics.entity.Zslxtj;
import org.jeecg.modules.demo.dzzz.certStatistics.service.IZslxtjService;




import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecg.modules.demo.dzzz.certStatistics.util.zzUtil.JsonUtil;
import org.jeecg.modules.demo.dzzz.certStatistics.util.zzUtil.ValidateUtil;
import org.jeecg.modules.demo.dzzz.homepage.entity.ZsQydDto;
import org.jeecg.modules.demo.dzzz.homepage.service.IAdminPageService;
import org.jeecg.modules.demo.dzzz.homepage.service.IOtherPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.metadata.IPage;

import static org.jeecg.modules.demo.dzzz.certStatistics.controller.QylxtjController.convertDate;


@RestController
@RequestMapping("/dzzz.homepage/otherPage")
@Slf4j
public class OtherPageController extends JeecgController<Zslxtj, IZslxtjService> {
    @Autowired
    private IOtherPageService iOtherPageService;
    Map<String,String> queryMap = new HashMap<>();

    // 请求子类
    @PostMapping(value = "/typeList")
    public Result<Map> typeList(HttpServletRequest request ,@RequestBody Map map){
        queryMap = new HashMap<>();
        Map resultMap = new HashMap();
        Map<String,String[]> requestParameterMap =   request.getParameterMap();

        for(Map.Entry<String,String[]> entry:requestParameterMap.entrySet()){
            queryMap.put(entry.getKey(),entry.getValue()[0]);
        }
        if(ValidateUtil.isNotEmpty(queryMap.get("rq[0]"))){
            queryMap.put("startTime",queryMap.get("rq[0]"));
            queryMap.put("endTime",queryMap.get("rq[1]"));

        }
        String type = "";
        if(!ValidateUtil.isEmpty(map.get("type"))){
            type = map.get("type").toString();
        }

        resultMap = iOtherPageService.getTypeList(type);

        return Result.ok(resultMap);

    }

    // 请求列表数据
    @PostMapping(value = "/ListDetail")
    public Result<Map> ListDetail(HttpServletRequest request ,@RequestBody Map map) throws InvocationTargetException, IllegalAccessException {
        long start = System.currentTimeMillis();
        queryMap = new HashMap<>();
        Map resultMap = new HashMap();
        Map<String,String[]> requestParameterMap =   request.getParameterMap();

        for(Map.Entry<String,String[]> entry:requestParameterMap.entrySet()){
            queryMap.put(entry.getKey(),entry.getValue()[0]);
        }
        if(ValidateUtil.isNotEmpty(queryMap.get("rq[0]"))){
            queryMap.put("startTime",queryMap.get("rq[0]"));
            queryMap.put("endTime",queryMap.get("rq[1]"));

        }
        String type = "";
        if(!ValidateUtil.isEmpty(map.get("type"))){
            type = map.get("type").toString();
        }

        resultMap = iOtherPageService.getListDetail(map);

        long end = System.currentTimeMillis();
        System.out.println((end - start) + "ms");
        return Result.ok(resultMap);

    }

    /**
     * 根据certtype获取证照
     * @param request
     * @param map
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @PostMapping(value = "/ListDetailByCerttype")
    public Result<Map> ListDetailByCerttype(HttpServletRequest request ,@RequestBody Map map) throws InvocationTargetException, IllegalAccessException {
        Map resultMap = iOtherPageService.ListDetailByCertType(map);
        return Result.ok(resultMap);

    }

    /**
     * 返回指定证书数据给企业端使用
     * @param request
     * @param map
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @PostMapping(value = "/ListZsQydDto")
    public Map<String,Object> ListZsQydDto(HttpServletRequest request ,@RequestBody Map map) throws InvocationTargetException, IllegalAccessException {
        HashMap<String, Object> data = new HashMap<>();
        IPage<ZsQydDto> list = iOtherPageService.ListZsQydDto(map);
        data.put("msg","操作成功");
        data.put("code",200);
        data.put("total",list.getTotal());
        data.put("data",list.getRecords());
        return data;
    }


}
