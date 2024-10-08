package org.jeecg.modules.demo.dzzz.homepage.util.zzUtil;

import org.jeecg.modules.demo.dzzz.certStatistics.util.zzUtil.DateUtil;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.*;
import java.lang.reflect.Method;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.*;

public class ObjectUtil {
    public ObjectUtil() {
    }

    public static boolean isEmpty(Object object) {
        if (object == null) {
            return true;
        } else {
            if (object instanceof StringBuffer) {
                object = object.toString();
            }

            if (object instanceof String) {
                if (((String)object).trim().length() == 0 || "null".equals(((String)object).trim().toLowerCase()) || "undefined".equals(((String)object).trim().toLowerCase())) {
                    return true;
                }
            } else if (object instanceof Collection) {
                if (((Collection)object).size() == 0) {
                    return true;
                }
            } else if (object instanceof Map && ((Map)object).size() == 0) {
                return true;
            }

            return false;
        }
    }

    public static boolean isSupportSerializable(Object value) {
        return value == null ? true : Serializable.class.isAssignableFrom(value.getClass());
    }

    public static byte[] ObjectToByte(Object o) {
        if (o == null) {
            return null;
        } else {
            Object var1 = null;

            try {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos);
                oos.writeObject(o);
                oos.flush();
                byte[] bytes = baos.toByteArray();
                return bytes;
            } catch (IOException var4) {
                throw new RuntimeException("Java对象不能序列化！'" + o + "'", var4);
            }
        }
    }

    public static String ClobToString(Clob clob) {
        String reString = "";
        if (clob == null) {
            return reString;
        } else {
            Reader is = null;

            try {
                is = clob.getCharacterStream();
                BufferedReader br = new BufferedReader(is);
                String s = null;

                try {
                    s = br.readLine();
                } catch (IOException var8) {
                    var8.printStackTrace();
                }

                StringBuffer sb = new StringBuffer();

                while(s != null) {
                    sb.append(s);

                    try {
                        s = br.readLine();
                    } catch (IOException var7) {
                        var7.printStackTrace();
                    }
                }

                reString = sb.toString();
            } catch (SQLException var9) {
                var9.printStackTrace();
            }

            return reString;
        }
    }

    public static Object ByteToObject(byte[] bytes) {
        try {
            if (bytes == null) {
                return null;
            } else {
                ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
                ObjectInputStream oi = new ObjectInputStream(bi);
                Object object = oi.readObject();
                bi.close();
                oi.close();
                return object;
            }
        } catch (Exception var4) {
            throw new RuntimeException("不能反序列化！", var4);
        }
    }

    public static void convertClobToString(Map<String, Object> resource) {
        if (!isEmpty(resource)) {
            Iterator var1 = resource.keySet().iterator();

            while(var1.hasNext()) {
                String key = (String)var1.next();
                Object value = resource.get(key);
                if (value instanceof Clob) {
                    resource.put(key, ClobToString((Clob)value));
                }
            }
        }

    }

    public static void convertClobToString(List resources) {
        if (!isEmpty(resources)) {
            Iterator var1 = resources.iterator();

            while(var1.hasNext()) {
                Object resouce = var1.next();
                if (!(resouce instanceof Map)) {
                    break;
                }

                convertClobToString((Map)resouce);
            }
        }

    }

    public static Object map2Bean(Class type, Map<String, Object> map) {
        if (isEmpty(map)) {
            return null;
        } else {
            map.remove("PK");
            map.remove("key");
            map.remove("domainObjectName");
            map.remove("metadata");
            map.remove("objid");
            String propertyName = null;

            try {
                BeanInfo beanInfo = Introspector.getBeanInfo(type);
                Object obj = type.newInstance();
                PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

                for(int i = 0; i < propertyDescriptors.length; ++i) {
                    PropertyDescriptor descriptor = propertyDescriptors[i];
                    propertyName = descriptor.getName();
                    if (map.containsKey(propertyName) && !isEmpty(map.get(propertyName))) {
                        Object[] params = descriptor.getWriteMethod().getParameterTypes();
                        Object[] args = new Object[1];
                        String clazz = ((Class)params[0]).getName();
                        if (!Long.class.getName().equals(clazz) && !"long".equals(clazz)) {
                            if (!Integer.class.getName().equals(clazz) && !"int".equals(clazz)) {
                                if (Date.class.getName().equals(clazz)) {
                                    args[0] = DateUtil.str2Timestamp(String.valueOf(map.get(propertyName)));
                                } else {
                                    args[0] = String.valueOf(map.get(propertyName));
                                }
                            } else {
                                args[0] = Integer.valueOf(String.valueOf(map.get(propertyName)));
                            }
                        } else {
                            args[0] = Long.valueOf(String.valueOf(map.get(propertyName)));
                        }

                        descriptor.getWriteMethod().invoke(obj, args);
                    }
                }

                return obj;
            } catch (Exception var11) {
                var11.printStackTrace();
                System.out.println("属性值" + propertyName + "转换出错");
                return null;
            }
        }
    }

    public static Map<String, Object> bean2Map(Object bean) {
        String propertyName = null;

        try {
            Class type = bean.getClass();
            Map<String, Object> returnMap = new HashMap();
            BeanInfo beanInfo = Introspector.getBeanInfo(type);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

            for(int i = 0; i < propertyDescriptors.length; ++i) {
                PropertyDescriptor descriptor = propertyDescriptors[i];
                propertyName = descriptor.getName();
                if (!propertyName.equals("class")) {
                    Method readMethod = descriptor.getReadMethod();
                    Object result = readMethod.invoke(bean);
                    if (result != null) {
                        returnMap.put(propertyName, result);
                    } else {
                        returnMap.put(propertyName, "");
                    }
                }
            }

            return returnMap;
        } catch (Exception var10) {
            var10.printStackTrace();
            System.out.println("属性值" + propertyName + "转换出错");
            return null;
        }
    }

    public static Object deepClone(Object src) {
        Object dest = null;

        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(src);
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            dest = ois.readObject();
            return dest;
        } catch (Exception var9) {
            var9.printStackTrace();
            return dest;
        } finally {
            ;
        }
    }
}
