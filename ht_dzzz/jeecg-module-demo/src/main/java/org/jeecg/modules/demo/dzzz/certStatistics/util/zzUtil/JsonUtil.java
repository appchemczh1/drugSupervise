package org.jeecg.modules.demo.dzzz.certStatistics.util.zzUtil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class JsonUtil {
    private static final String REPLACE = "!_!_!";

    public JsonUtil() {
    }

//    public static void main(String[] args) {
//        System.out.println(DateUtil.long2Str(1487512828000L));
//        String json = "{\"test\":null}";
//        Map<String, Object> result = jsonObj2Map(json);
//        System.out.println("jsonObj2Map:" + result);
//        json = "{\"test1\":3215704.48,\"test\":[{\"test\":3215704.48},{\"aa\":\"aa\"}]}";
//        List<Map<String, Object>> resultList = jsonObj2List(json);
//        System.out.println("jsonObj2List:" + resultList);
//        json = "[{\"test\":3215704.48},{\"aa\":\"aa\"},{\"aa\":[{\"test\":3215704.48},{\"aa\":\"aa\"}]}]";
//        resultList = jsonArr2List(json);
//        System.out.println("jsonArr2List:" + resultList);
//        json = list2Json(resultList);
//        System.out.println("list2Json:" + json);
//        String taskCfg = "[{\"aae419\":0,\"batchUrl\":\"\",\"interceptors\":[{\"order\":1,\"svrAt\":\"before\",\"svrName\":\"\",\"taskOperateCode\":\"11\"},{\"order\":1,\"svrAt\":\"before\",\"svrName\":\"\",\"taskOperateCode\":\"12\"},{\"order\":1,\"svrAt\":\"before\",\"svrName\":\"\",\"taskOperateCode\":\"13\"},{\"order\":1,\"svrAt\":\"before\",\"svrName\":\"\",\"taskOperateCode\":\"4\"},{\"order\":1,\"svrAt\":\"before\",\"svrName\":\"\",\"taskOperateCode\":\"23\"}],\"mutex\":true,\"rule\":\"\",\"url\":\"\"}]";
//        List<Map<String, Object>> tdJsonList = jsonArr2List(taskCfg);
//        Iterator var6 = tdJsonList.iterator();
//
//        while(var6.hasNext()) {
//            Map<String, Object> tdJson = (Map)var6.next();
//            List<Map<String, Object>> interceptorList = (List)tdJson.get("interceptors");
//            System.out.println(interceptorList);
//        }
//
//    }

    public static String toJson(Object o) {
        String json = JSON.toJSONString(o);
        if (json != null && json.contains("\\\\")) {
            json = json.replace("\\\\", "\\");
        }

        return json;
    }

    public static String list2Json(List list) {
        if (ObjectUtil.isEmpty(list)) {
            return null;
        } else {
            JSONArray jsonArray = (JSONArray)JSON.toJSON(list);
            return jsonArray.toString();
        }
    }

    public static Map<String, Object> jsonObj2Map(String json) {
        return ObjectUtil.isEmpty(json) ? null : jsonObj2Map(json, "\\");
    }

    public static Map<String, Object> jsonObj2Map(String json, String replace) {
        if (ObjectUtil.isEmpty(json)) {
            return null;
        } else {
            if (!ObjectUtil.isEmpty(replace) && json.contains(replace)) {
                json = json.replace(replace, "!_!_!");
            }

            Map<String, Object> jsonObj = (Map) JSonFactory.json2bean(json, HashMap.class);
            return washMap(jsonObj, replace);
        }
    }

    public static Map<String, Object> json2Map(String json) {
        if (ObjectUtil.isEmpty(json)) {
            return null;
        } else {
            JSONObject jsonObj = JSONObject.parseObject(json);
            return washMap(jsonObj, (String)null);
        }
    }

    private static Map<String, Object> washMap(Map<String, Object> jsonObj, String replace) {
        Iterator it = jsonObj.entrySet().iterator();

        while(true) {
            while(it.hasNext()) {
                Map.Entry<String, Object> entry = (Map.Entry)it.next();
                if (!ObjectUtil.isEmpty(replace) && entry.getValue() != null && entry.getValue().toString().contains("!_!_!")) {
                    entry.setValue(entry.getValue().toString().replace("!_!_!", replace));
                } else if (entry.getValue() != null) {
                    entry.setValue(entry.getValue().toString());
                }
            }

            return jsonObj;
        }
    }

    public static List<Map<String, Object>> jsonArr2List(String json) {
        if (ObjectUtil.isEmpty(json)) {
            return null;
        } else {
            List<Map<String, Object>> result = (List)JSON.parseObject(json, new TypeReference<List<Map<String, Object>>>() {
            }, new Feature[0]);
            return result;
        }
    }

    public static <T> List<T> jsonArr2List(String json, Class<T> clazz) {
        return ObjectUtil.isEmpty(json) ? null : JSON.parseArray(json, clazz);
    }

    public static List<Map<String, Object>> jsonObj2List(String json) {
        if (ObjectUtil.isEmpty(json)) {
            return null;
        } else {
            Map<String, Object> paramMap = JSON.parseObject(json);
            List<Map<String, Object>> result = new ArrayList();
            Iterator var3 = paramMap.keySet().iterator();

            while(var3.hasNext()) {
                String key = (String)var3.next();
                Map<String, Object> param = new HashMap();
                param.put("key", key);
                Object obj = paramMap.get(key);
                String value = null;
                if (!ObjectUtil.isEmpty(obj)) {
                    value = JSON.toJSONString(obj);
                } else {
                    value = String.valueOf(obj);
                }

                param.put("value", value);
                int order = 0;
                if (ObjectUtil.isEmpty(value)) {
                    order = 2;
                } else if (!ObjectUtil.isEmpty(value) && value.startsWith("[")) {
                    if (value.length() == 2) {
                        order = 3;
                    } else {
                        order = 1;
                    }
                }

                param.put("order", Integer.valueOf(order));
                result.add(param);
            }

//            ListUtil.sortList(result, "order");
            return result;
        }
    }

    public static String classToJson(Object model) throws Exception {
        String attribute = "";
        String name = "";
        String type = "";
        String json = "{";
        Field[] field = model.getClass().getDeclaredFields();
        int i = 0;

        for(int j = field.length; i < j; ++i) {
            attribute = field[i].getName();
            name = attribute.substring(0, 1).toUpperCase() + attribute.substring(1);
            type = field[i].getGenericType().toString();
            Method m;
            if (type.equals("class java.lang.String")) {
                m = model.getClass().getMethod("get" + name);
                String value = (String)m.invoke(model);
                if (!ObjectUtil.isEmpty(value)) {
                    json = json + "\"" + attribute + "\":\"" + value + "\",";
                }
            } else if (type.equals("class java.lang.Integer")) {
                m = model.getClass().getMethod("get" + name);
                Integer value = (Integer)m.invoke(model);
                if (!ObjectUtil.isEmpty(value)) {
                    json = json + "\"" + attribute + "\":" + value + ",";
                }
            } else if (type.equals("class java.lang.Short")) {
                m = model.getClass().getMethod("get" + name);
                Short value = (Short)m.invoke(model);
                if (!ObjectUtil.isEmpty(value)) {
                    json = json + "\"" + attribute + "\":" + value + ",";
                }
            } else if (type.equals("class java.lang.Double")) {
                m = model.getClass().getMethod("get" + name);
                Double value = (Double)m.invoke(model);
                if (!ObjectUtil.isEmpty(value)) {
                    json = json + "\"" + attribute + "\":" + value + ",";
                }
            } else if (type.equals("class java.lang.Boolean")) {
                m = model.getClass().getMethod("get" + name);
                Boolean value = (Boolean)m.invoke(model);
                if (!ObjectUtil.isEmpty(value)) {
                    json = json + "\"" + attribute + "\":" + value + ",";
                }
            } else if (type.equals("class java.util.Date")) {
                m = model.getClass().getMethod("get" + name);
                Date value = (Date)m.invoke(model);
                if (!ObjectUtil.isEmpty(value)) {
                    json = json + "\"" + attribute + "\":\"" + value + "\",";
                }
            }
        }

        if (json.contains(",")) {
            json = json.substring(0, json.length() - 1);
            json = json + "}";
            return json;
        } else {
            return null;
        }
    }

}
