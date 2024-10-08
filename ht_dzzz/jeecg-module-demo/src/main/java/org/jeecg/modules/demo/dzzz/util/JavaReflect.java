package org.jeecg.modules.demo.dzzz.util;

import java.lang.reflect.Method;

public class JavaReflect {
    /**
     * @param obj 操作的对象
     * @param att 操作的属性
     **/
    public static Object getter(Object obj, String att) throws Exception {
        try {
            Method method = obj.getClass().getMethod("get" + att);
            return method.invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
    
    }
    
    /**
     * @param obj   操作的对象
     * @param att   操作的属性
     * @param value 设置的值
     * @param type  参数的属性
     */
    public static void setter(Object obj, String att, Object value, Class<?> type) throws Exception {
        try {
            Method method = obj.getClass().getMethod("set" + att, type);
            method.invoke(obj, value);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
    }
    
    public static String getFristStrUp(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1, str.length());
    }
    
}
