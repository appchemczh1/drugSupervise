package org.jeecg.modules.demo.dzzz.homepage.service.impl;


import org.jeecg.modules.demo.dzzz.certStatistics.util.zzUtil.ValidateUtil;
import org.jeecg.modules.demo.dzzz.homepage.entity.Area;
import org.jeecg.modules.demo.dzzz.homepage.mapper.AreaMapper;
import org.jeecg.modules.demo.dzzz.homepage.service.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AreaService implements IAreaService {

    @Autowired
    private AreaMapper areaMapper;

    public Map  getCityData() {

        Map resultMap = new HashMap<>();
        // 查询所有行政区划数据
        List<Area> areas = areaMapper.selectAllAreas();

        // 将列表转换为Map，以便于快速查找
        Map<String, List<Area>> areaMap = areas.stream()
                .collect(Collectors.groupingBy(Area::getParentId));

        // 递归构建树形结构
        List<Map<String, Object>> buildTree =  buildTree("f4407802f29947f78dedbb0f268b68d2", areaMap); // 假设根节点的parentId为"0"
        resultMap.put("list",buildTree);
        return resultMap;
    }

    private List<Map<String, Object>> buildTree(String parentId, Map<String, List<Area>> areaMap) {
        List<Map<String, Object>> result = new ArrayList<>();

        List<Area> children = areaMap.get(parentId);
        if (children != null) {
            for (Area area : children) {
                Map<String, Object> node = new HashMap<>();
                node.put("id", area.getDeptId());
                node.put("label", area.getXZQH());
                List<Map<String, Object>> childNodes = buildTree(area.getDeptId(), areaMap);
                if (ValidateUtil.isNotEmpty(childNodes)) {
                    node.put("children", childNodes);
                }
                result.add(node);
            }
        }
        return result;
    }
}

