package com.hsf.javautils.reflect;

import java.lang.reflect.Field;

public class ReflectUtil {
    /**
     * 专门用于获得public static的字段
     * @param clazz CLASS对象
     * @param fieldName 字段名
     * @return 字符按值
     * @param <T> 返回类型
     */
    public static <T> T getStaticField(final Class<?> clazz, final String fieldName) {
        try {
            Field field = clazz.getField(fieldName);
            Object value = field.get(null);
            return (T) value;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
