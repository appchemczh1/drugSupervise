package org.jeecg.modules.demo.dzzz.certStatistics.util.zzUtil;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public   class Map2Vo {

    public static  <T> List<T> convertMapListToVoList(List<Map> mapList, Class<T> targetType) {
        return mapList.stream()
                .map(map -> convertMapToVo(map, targetType))
                .collect(Collectors.toList());
    }

    private static  <T> T convertMapToVo(Map map, Class<T> targetType) {
        T vo = null;
        try {
            vo = targetType.newInstance();
            Field[] fields = targetType.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName();
                Object value = map.get(fieldName);
                if (value != null) {
                    setFieldValue(vo, field, value);
                }
            }
        } catch (InstantiationException | IllegalAccessException | ParseException e) {
            e.printStackTrace();
        }
        return vo;
    }

    private static  <T> void setFieldValue(T vo, Field field, Object value) throws IllegalAccessException, ParseException {
        Class<?> fieldType = field.getType();
        if (fieldType == String.class) {
            field.set(vo, value.toString());
        } else if (fieldType == Integer.class || fieldType == int.class) {
            field.set(vo, Integer.parseInt(value.toString()));
        } else if (fieldType == BigDecimal.class) {
            field.set(vo, new BigDecimal(value.toString()));
        } else if (fieldType == Date.class) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            field.set(vo, dateFormat.parse(value.toString()));
        }
        // Add more data type conversions if needed
    }

}
