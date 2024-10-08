package org.jeecg.modules.demo.dzzz.certStatistics.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jeecg.modules.demo.dzzz.certStatistics.entity.Qylxtj;
import org.jeecg.modules.demo.dzzz.certStatistics.entity.Zslxtj;
import org.jeecg.modules.demo.dzzz.certStatistics.mapper.QylxtjMapper;
import org.jeecg.modules.demo.dzzz.certStatistics.mapper.ZslxtjMapper;
import org.jeecg.modules.demo.dzzz.certStatistics.service.IQylxtjService;
import org.jeecg.modules.demo.dzzz.certStatistics.service.IZslxtjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class QylxtjServiceImpl extends ServiceImpl<QylxtjMapper, Qylxtj> implements IQylxtjService {
    @Autowired
    private QylxtjMapper qylxtjMapper;

    @Override
    public List<Qylxtj> selectQylxtjList(Map map) {
        return qylxtjMapper.selectQylxtjList(map);
    }

    @Override
    public List<Map<String, Integer>> ProcessData(List<Qylxtj> list) {
        Map<String, Map<String, Integer>> result = new HashMap<>();

        for (Qylxtj item : list) {

            result.computeIfAbsent("sbNum", k -> new HashMap<>()).put(item.getQylx(), item.getSbNum());


            result.computeIfAbsent("whNum", k -> new HashMap<>()).put(item.getQylx(), item.getWhNum());


            result.computeIfAbsent("hsNum", k -> new HashMap<>()).put(item.getQylx(), item.getHsNum());


            result.computeIfAbsent("syNum", k -> new HashMap<>()).put(item.getQylx(), item.getSyNum());


            result.computeIfAbsent("ycNum", k -> new HashMap<>()).put(item.getQylx(), item.getYcNum());


            result.computeIfAbsent("xyNum", k -> new HashMap<>()).put(item.getQylx(), item.getXyNum());

            result.computeIfAbsent("ezNum", k -> new HashMap<>()).put(item.getQylx(), item.getEzNum());


            result.computeIfAbsent("jmNum", k -> new HashMap<>()).put(item.getQylx(), item.getJmNum());


            result.computeIfAbsent("xgNum", k -> new HashMap<>()).put(item.getQylx(), item.getXgNum());


            result.computeIfAbsent("jzNum", k -> new HashMap<>()).put(item.getQylx(), item.getJzNum());


            result.computeIfAbsent("hgNum", k -> new HashMap<>()).put(item.getQylx(), item.getHgNum());


            result.computeIfAbsent("xnNum", k -> new HashMap<>()).put(item.getQylx(), item.getXnNum());


            result.computeIfAbsent("szNum", k -> new HashMap<>()).put(item.getQylx(), item.getSzNum());


            result.computeIfAbsent("esNum", k -> new HashMap<>()).put(item.getQylx(), item.getEsNum());


            result.computeIfAbsent("xtNum", k -> new HashMap<>()).put(item.getQylx(), item.getXtNum());


            result.computeIfAbsent("qjNum", k -> new HashMap<>()).put(item.getQylx(), item.getQjNum());


            result.computeIfAbsent("tmNum", k -> new HashMap<>()).put(item.getQylx(), item.getTmNum());


            result.computeIfAbsent("snjNum", k -> new HashMap<>()).put(item.getQylx(), item.getSnjNum());

        }
        // 指定的关键字列表
        List<String> validKeys = Arrays.asList(
                "药品生产许可证(含放射性药品生产)", "医疗机构制剂许可证",
                "药品经营许可证（批发）", "药品经营许可证（零售连锁总部）", "药品经营许可证（零售连锁门店）",
                "药品经营许可证(零售)", "放射性药品经营许可证", "放射性药品使用许可证","第一类医疗器械生产备案","第二、三类医疗器械生产许可证",
                "第三类医疗器械经营许可证(批发)","第三类医疗器械经营许可证(零售)","化妆品生产许可证"
        );
        List<String> validKeys2 = Arrays.asList(
                "药品生产许可证","放射性药品生产许可证"
        );

        for (Map<String, Integer> innerMap : result.values()) {
            // 获取药品生产许可证和放射性药品生产许可证的值
            int yaopin = innerMap.getOrDefault("药品生产许可证", 0);
            int fangshexing = innerMap.getOrDefault("放射性药品生产许可证", 0);
            int combinedValue = yaopin + fangshexing;
            // 移除原有的药品生产许可证和放射性药品生产许可证
            innerMap.remove("药品生产许可证");
            innerMap.remove("放射性药品生产许可证");
            innerMap.put("药品生产许可证(含放射性药品生产)", combinedValue);
        }
        Map<String, Map<String, Integer>> filteredNestedMap = new HashMap<>();

        for (Map.Entry<String, Map<String, Integer>> entry : result.entrySet()) {
            Map<String, Integer> filteredMap = entry.getValue().entrySet().stream()
                    .filter(e -> validKeys.contains(e.getKey()))
                    .collect(Collectors.toMap(e -> modifyKey(e.getKey()),Map.Entry::getValue));

            int sum = entry.getValue().getOrDefault("药品生产许可证", 0) + entry.getValue().getOrDefault("放射性药品生产许可证", 0);
            filteredMap.put("药品生产许可证(含放射性药品生产)", sum);
            Map<String, Integer> value = entry.getValue();
            if("whNum".equals(entry.getKey())){
                int xj1 =value.get("药品生产许可证(含放射性药品生产)")+value.get("医疗机构制剂许可证")+value.get("药品经营许可证（批发）")+
                        value.get("药品经营许可证（零售连锁总部）")+value.get("药品经营许可证（零售连锁门店）")+value.get("药品经营许可证(零售)")+
                        value.get("放射性药品经营许可证")+value.get("放射性药品使用许可证");
                int xj2 = value.get("第一类医疗器械生产备案")+value.get("第二、三类医疗器械生产许可证")+value.get("第三类医疗器械经营许可证(批发)")+
                        value.get("第三类医疗器械经营许可证(零售)");
                int zj = xj1 +xj2 +value.get("化妆品生产许可证");
                filteredMap.put("xzqh",1);
                filteredMap.put("xj1",xj1);
                filteredMap.put("xj2",xj2);
                filteredMap.put("zj",zj);

            }
            if("hsNum".equals(entry.getKey())){
                filteredMap.put("xzqh",2);
                int xj1 =value.get("药品生产许可证(含放射性药品生产)")+value.get("医疗机构制剂许可证")+value.get("药品经营许可证（批发）")+
                        value.get("药品经营许可证（零售连锁总部）")+value.get("药品经营许可证（零售连锁门店）")+value.get("药品经营许可证(零售)")+
                        value.get("放射性药品经营许可证")+value.get("放射性药品使用许可证");
                int xj2 = value.get("第一类医疗器械生产备案")+value.get("第二、三类医疗器械生产许可证")+value.get("第三类医疗器械经营许可证(批发)")+
                        value.get("第三类医疗器械经营许可证(零售)");
                int zj = xj1 +xj2 +value.get("化妆品生产许可证");
                filteredMap.put("xj1",xj1);
                filteredMap.put("xj2",xj2);
                filteredMap.put("zj",zj);
            }
            if("syNum".equals(entry.getKey())){
                filteredMap.put("xzqh",3);
                int xj1 =value.get("药品生产许可证(含放射性药品生产)")+value.get("医疗机构制剂许可证")+value.get("药品经营许可证（批发）")+
                        value.get("药品经营许可证（零售连锁总部）")+value.get("药品经营许可证（零售连锁门店）")+value.get("药品经营许可证(零售)")+
                        value.get("放射性药品经营许可证")+value.get("放射性药品使用许可证");
                int xj2 = value.get("第一类医疗器械生产备案")+value.get("第二、三类医疗器械生产许可证")+value.get("第三类医疗器械经营许可证(批发)")+
                        value.get("第三类医疗器械经营许可证(零售)");
                int zj = xj1 +xj2 +value.get("化妆品生产许可证");
                filteredMap.put("xj1",xj1);
                filteredMap.put("xj2",xj2);
                filteredMap.put("zj",zj);
            }
            if("ycNum".equals(entry.getKey())){
                filteredMap.put("xzqh",4);
                int xj1 =value.get("药品生产许可证(含放射性药品生产)")+value.get("医疗机构制剂许可证")+value.get("药品经营许可证（批发）")+
                        value.get("药品经营许可证（零售连锁总部）")+value.get("药品经营许可证（零售连锁门店）")+value.get("药品经营许可证(零售)")+
                        value.get("放射性药品经营许可证")+value.get("放射性药品使用许可证");
                int xj2 = value.get("第一类医疗器械生产备案")+value.get("第二、三类医疗器械生产许可证")+value.get("第三类医疗器械经营许可证(批发)")+
                        value.get("第三类医疗器械经营许可证(零售)");
                int zj = xj1 +xj2 +value.get("化妆品生产许可证");
                filteredMap.put("xj1",xj1);
                filteredMap.put("xj2",xj2);
                filteredMap.put("zj",zj);
            }
            if("xyNum".equals(entry.getKey())){
                filteredMap.put("xzqh",5);
                int xj1 =value.get("药品生产许可证(含放射性药品生产)")+value.get("医疗机构制剂许可证")+value.get("药品经营许可证（批发）")+
                        value.get("药品经营许可证（零售连锁总部）")+value.get("药品经营许可证（零售连锁门店）")+value.get("药品经营许可证(零售)")+
                        value.get("放射性药品经营许可证")+value.get("放射性药品使用许可证");
                int xj2 = value.get("第一类医疗器械生产备案")+value.get("第二、三类医疗器械生产许可证")+value.get("第三类医疗器械经营许可证(批发)")+
                        value.get("第三类医疗器械经营许可证(零售)");
                int zj = xj1 +xj2 +value.get("化妆品生产许可证");
                filteredMap.put("xj1",xj1);
                filteredMap.put("xj2",xj2);
                filteredMap.put("zj",zj);
            }
            if("ezNum".equals(entry.getKey())){
                filteredMap.put("xzqh",6);
                int xj1 =value.get("药品生产许可证(含放射性药品生产)")+value.get("医疗机构制剂许可证")+value.get("药品经营许可证（批发）")+
                        value.get("药品经营许可证（零售连锁总部）")+value.get("药品经营许可证（零售连锁门店）")+value.get("药品经营许可证(零售)")+
                        value.get("放射性药品经营许可证")+value.get("放射性药品使用许可证");
                int xj2 = value.get("第一类医疗器械生产备案")+value.get("第二、三类医疗器械生产许可证")+value.get("第三类医疗器械经营许可证(批发)")+
                        value.get("第三类医疗器械经营许可证(零售)");
                int zj = xj1 +xj2 +value.get("化妆品生产许可证");
                filteredMap.put("xj1",xj1);
                filteredMap.put("xj2",xj2);
                filteredMap.put("zj",zj);
            }
            if("jmNum".equals(entry.getKey())){
                filteredMap.put("xzqh",7);
                int xj1 =value.get("药品生产许可证(含放射性药品生产)")+value.get("医疗机构制剂许可证")+value.get("药品经营许可证（批发）")+
                        value.get("药品经营许可证（零售连锁总部）")+value.get("药品经营许可证（零售连锁门店）")+value.get("药品经营许可证(零售)")+
                        value.get("放射性药品经营许可证")+value.get("放射性药品使用许可证");
                int xj2 = value.get("第一类医疗器械生产备案")+value.get("第二、三类医疗器械生产许可证")+value.get("第三类医疗器械经营许可证(批发)")+
                        value.get("第三类医疗器械经营许可证(零售)");
                int zj = xj1 +xj2 +value.get("化妆品生产许可证");
                filteredMap.put("xj1",xj1);
                filteredMap.put("xj2",xj2);
                filteredMap.put("zj",zj);
            }
            if("xgNum".equals(entry.getKey())){
                filteredMap.put("xzqh",8);
                int xj1 =value.get("药品生产许可证(含放射性药品生产)")+value.get("医疗机构制剂许可证")+value.get("药品经营许可证（批发）")+
                        value.get("药品经营许可证（零售连锁总部）")+value.get("药品经营许可证（零售连锁门店）")+value.get("药品经营许可证(零售)")+
                        value.get("放射性药品经营许可证")+value.get("放射性药品使用许可证");
                int xj2 = value.get("第一类医疗器械生产备案")+value.get("第二、三类医疗器械生产许可证")+value.get("第三类医疗器械经营许可证(批发)")+
                        value.get("第三类医疗器械经营许可证(零售)");
                int zj = xj1 +xj2 +value.get("化妆品生产许可证");
                filteredMap.put("xj1",xj1);
                filteredMap.put("xj2",xj2);
                filteredMap.put("zj",zj);
            }
            if("jzNum".equals(entry.getKey())){
                filteredMap.put("xzqh",9);
                int xj1 =value.get("药品生产许可证(含放射性药品生产)")+value.get("医疗机构制剂许可证")+value.get("药品经营许可证（批发）")+
                        value.get("药品经营许可证（零售连锁总部）")+value.get("药品经营许可证（零售连锁门店）")+value.get("药品经营许可证(零售)")+
                        value.get("放射性药品经营许可证")+value.get("放射性药品使用许可证");
                int xj2 = value.get("第一类医疗器械生产备案")+value.get("第二、三类医疗器械生产许可证")+value.get("第三类医疗器械经营许可证(批发)")+
                        value.get("第三类医疗器械经营许可证(零售)");
                int zj = xj1 +xj2 +value.get("化妆品生产许可证");
                filteredMap.put("xj1",xj1);
                filteredMap.put("xj2",xj2);
                filteredMap.put("zj",zj);
            }
            if("hgNum".equals(entry.getKey())){
                filteredMap.put("xzqh",10);
                int xj1 =value.get("药品生产许可证(含放射性药品生产)")+value.get("医疗机构制剂许可证")+value.get("药品经营许可证（批发）")+
                        value.get("药品经营许可证（零售连锁总部）")+value.get("药品经营许可证（零售连锁门店）")+value.get("药品经营许可证(零售)")+
                        value.get("放射性药品经营许可证")+value.get("放射性药品使用许可证");
                int xj2 = value.get("第一类医疗器械生产备案")+value.get("第二、三类医疗器械生产许可证")+value.get("第三类医疗器械经营许可证(批发)")+
                        value.get("第三类医疗器械经营许可证(零售)");
                int zj = xj1 +xj2 +value.get("化妆品生产许可证");
                filteredMap.put("xj1",xj1);
                filteredMap.put("xj2",xj2);
                filteredMap.put("zj",zj);
            }
            if("xnNum".equals(entry.getKey())){
                filteredMap.put("xzqh",11);
                int xj1 =value.get("药品生产许可证(含放射性药品生产)")+value.get("医疗机构制剂许可证")+value.get("药品经营许可证（批发）")+
                        value.get("药品经营许可证（零售连锁总部）")+value.get("药品经营许可证（零售连锁门店）")+value.get("药品经营许可证(零售)")+
                        value.get("放射性药品经营许可证")+value.get("放射性药品使用许可证");
                int xj2 = value.get("第一类医疗器械生产备案")+value.get("第二、三类医疗器械生产许可证")+value.get("第三类医疗器械经营许可证(批发)")+
                        value.get("第三类医疗器械经营许可证(零售)");
                int zj = xj1 +xj2 +value.get("化妆品生产许可证");
                filteredMap.put("xj1",xj1);
                filteredMap.put("xj2",xj2);
                filteredMap.put("zj",zj);
            }
            if("szNum".equals(entry.getKey())){
                filteredMap.put("xzqh",12);
                int xj1 =value.get("药品生产许可证(含放射性药品生产)")+value.get("医疗机构制剂许可证")+value.get("药品经营许可证（批发）")+
                        value.get("药品经营许可证（零售连锁总部）")+value.get("药品经营许可证（零售连锁门店）")+value.get("药品经营许可证(零售)")+
                        value.get("放射性药品经营许可证")+value.get("放射性药品使用许可证");
                int xj2 = value.get("第一类医疗器械生产备案")+value.get("第二、三类医疗器械生产许可证")+value.get("第三类医疗器械经营许可证(批发)")+
                        value.get("第三类医疗器械经营许可证(零售)");
                int zj = xj1 +xj2 +value.get("化妆品生产许可证");
                filteredMap.put("xj1",xj1);
                filteredMap.put("xj2",xj2);
                filteredMap.put("zj",zj);
            }
            if("esNum".equals(entry.getKey())){
                filteredMap.put("xzqh",13);
                int xj1 =value.get("药品生产许可证(含放射性药品生产)")+value.get("医疗机构制剂许可证")+value.get("药品经营许可证（批发）")+
                        value.get("药品经营许可证（零售连锁总部）")+value.get("药品经营许可证（零售连锁门店）")+value.get("药品经营许可证(零售)")+
                        value.get("放射性药品经营许可证")+value.get("放射性药品使用许可证");
                int xj2 = value.get("第一类医疗器械生产备案")+value.get("第二、三类医疗器械生产许可证")+value.get("第三类医疗器械经营许可证(批发)")+
                        value.get("第三类医疗器械经营许可证(零售)");
                int zj = xj1 +xj2 +value.get("化妆品生产许可证");
                filteredMap.put("xj1",xj1);
                filteredMap.put("xj2",xj2);
                filteredMap.put("zj",zj);
            }
            if("xtNum".equals(entry.getKey())){
                filteredMap.put("xzqh",14);
                int xj1 =value.get("药品生产许可证(含放射性药品生产)")+value.get("医疗机构制剂许可证")+value.get("药品经营许可证（批发）")+
                        value.get("药品经营许可证（零售连锁总部）")+value.get("药品经营许可证（零售连锁门店）")+value.get("药品经营许可证(零售)")+
                        value.get("放射性药品经营许可证")+value.get("放射性药品使用许可证");
                int xj2 = value.get("第一类医疗器械生产备案")+value.get("第二、三类医疗器械生产许可证")+value.get("第三类医疗器械经营许可证(批发)")+
                        value.get("第三类医疗器械经营许可证(零售)");
                int zj = xj1 +xj2 +value.get("化妆品生产许可证");
                filteredMap.put("xj1",xj1);
                filteredMap.put("xj2",xj2);
                filteredMap.put("zj",zj);
            }
            if("qjNum".equals(entry.getKey())){
                filteredMap.put("xzqh",15);
                int xj1 =value.get("药品生产许可证(含放射性药品生产)")+value.get("医疗机构制剂许可证")+value.get("药品经营许可证（批发）")+
                        value.get("药品经营许可证（零售连锁总部）")+value.get("药品经营许可证（零售连锁门店）")+value.get("药品经营许可证(零售)")+
                        value.get("放射性药品经营许可证")+value.get("放射性药品使用许可证");
                int xj2 = value.get("第一类医疗器械生产备案")+value.get("第二、三类医疗器械生产许可证")+value.get("第三类医疗器械经营许可证(批发)")+
                        value.get("第三类医疗器械经营许可证(零售)");
                int zj = xj1 +xj2 +value.get("化妆品生产许可证");
                filteredMap.put("xj1",xj1);
                filteredMap.put("xj2",xj2);
                filteredMap.put("zj",zj);
            }
            if("tmNum".equals(entry.getKey())){
                filteredMap.put("xzqh",16);
                int xj1 =value.get("药品生产许可证(含放射性药品生产)")+value.get("医疗机构制剂许可证")+value.get("药品经营许可证（批发）")+
                        value.get("药品经营许可证（零售连锁总部）")+value.get("药品经营许可证（零售连锁门店）")+value.get("药品经营许可证(零售)")+
                        value.get("放射性药品经营许可证")+value.get("放射性药品使用许可证");
                int xj2 = value.get("第一类医疗器械生产备案")+value.get("第二、三类医疗器械生产许可证")+value.get("第三类医疗器械经营许可证(批发)")+
                        value.get("第三类医疗器械经营许可证(零售)");
                int zj = xj1 +xj2 +value.get("化妆品生产许可证");
                filteredMap.put("xj1",xj1);
                filteredMap.put("xj2",xj2);
                filteredMap.put("zj",zj);
            }
            if("snjNum".equals(entry.getKey())){
                filteredMap.put("xzqh",17);
                int xj1 =value.get("药品生产许可证(含放射性药品生产)")+value.get("医疗机构制剂许可证")+value.get("药品经营许可证（批发）")+
                        value.get("药品经营许可证（零售连锁总部）")+value.get("药品经营许可证（零售连锁门店）")+value.get("药品经营许可证(零售)")+
                        value.get("放射性药品经营许可证")+value.get("放射性药品使用许可证");
                int xj2 = value.get("第一类医疗器械生产备案")+value.get("第二、三类医疗器械生产许可证")+value.get("第三类医疗器械经营许可证(批发)")+
                        value.get("第三类医疗器械经营许可证(零售)");
                int zj = xj1 +xj2 +value.get("化妆品生产许可证");
                filteredMap.put("xj1",xj1);
                filteredMap.put("xj2",xj2);
                filteredMap.put("zj",zj);
            }
            if (!filteredMap.isEmpty()&&!"sbNum".equals(entry.getKey())) {
                filteredNestedMap.put(entry.getKey(), filteredMap);
            }
        }

        // 新建一个map用于存储所有内部map的key的汇总值
        Map<String, Integer> totalMap = new HashMap<>();

        // 遍历外部map的每个内部map
        filteredNestedMap.values().forEach(innerMap -> {
            innerMap.forEach((key, value) -> {
                // 将每个内部map的value值累加到totalMap对应的key上
                totalMap.merge(key, value, Integer::sum);
            });
        });
        List<String> keysToRemove = Arrays.asList("药品生产许可证(含放射性药品生产)");
        totalMap.put("xzqh",18);
        // 将totalMap加入到result中
        filteredNestedMap.put("totalSum", totalMap);
        List<Map<String, Integer>> resultList = filteredNestedMap.values().stream()
                .map(innerMap -> innerMap.entrySet().stream()
                        .filter(entry -> !keysToRemove.contains(entry.getKey()))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)))
                .sorted(Comparator.comparingInt(map -> map.getOrDefault("xzqh", Integer.MAX_VALUE)))
                .collect(Collectors.toList());

        return  resultList;
    }

    @Override
    public List<Map> getType(Map<String, Object> params) {
        return qylxtjMapper.getType(params);
    }

    @Override
    public List<Map> getTypeYgz(Map queryDropMap) {
        return qylxtjMapper.getTypeYgz(queryDropMap);
    }

    @Override
    public List<Map> getCertYgz(Map queryDropMap) {
        return qylxtjMapper.getCertYgz(queryDropMap);
    }

    @Override
    public List<Map> getTypeYgzByIds(List<String> zsids) {
        return qylxtjMapper.getTypeYgzByIds(zsids);
    }


    public static String modifyKey(String oldKey) {
        if("药品生产许可证(含放射性药品生产)".equals(oldKey)){
            return "ypschfsyp";
        }
        if("医疗机构制剂许可证".equals(oldKey)){
            return "ylzj";
        }
        if("药品经营许可证（批发）".equals(oldKey)){
            return "ypjypf";
        }
        if("药品经营许可证（零售连锁总部）".equals(oldKey)){
            return "ypjylszb";
        }
        if("药品经营许可证（零售连锁门店）".equals(oldKey)){
            return "ypjylsmd";
        }
        if("药品经营许可证(零售)".equals(oldKey)){
            return "ypjyls";
        }
        if("放射性药品经营许可证".equals(oldKey)){
            return "fsxypjy";
        }
        if("放射性药品使用许可证".equals(oldKey)){
            return "fsxypsy";
        }
        if("第一类医疗器械生产备案".equals(oldKey)){
            return "ylylqxba";
        }
        if("第二、三类医疗器械生产许可证".equals(oldKey)){
            return "rslylqx";
        }
        if("第三类医疗器械经营许可证(批发)".equals(oldKey)){
            return "slylqxpf";
        }
        if("第三类医疗器械经营许可证(零售)".equals(oldKey)){
            return "slylqxls";
        }
        if("化妆品生产许可证".equals(oldKey)){
            return "hzpsc";
        }
        return oldKey;
    }


}
