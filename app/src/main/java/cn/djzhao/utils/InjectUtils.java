package cn.djzhao.utils;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;

import java.lang.reflect.Field;
import java.util.Arrays;

import cn.djzhao.annotation.Autowired;
import cn.djzhao.annotation.BindView;

public class InjectUtils {
    public static void autowired(Activity activity) {
        Bundle extras = activity.getIntent().getExtras();
        if (extras == null) {
            return;
        }
        Class<? extends Activity> aClass = activity.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(Autowired.class)) {
                Autowired autowired = field.getAnnotation(Autowired.class);
                String value = autowired.value();
                String key = TextUtils.isEmpty(autowired.value()) ? field.getName() : autowired.value();
                if (extras.containsKey(key)) {
                    Object o = extras.get(key);
                    Class<?> type = field.getType();
                    // Parcelable数组类型不能直接设置，其他的都可以.
                    // 获得数组单个元素类型
                    Class<?> componentType = type.getComponentType();
                    if (type.isArray() && Parcelable.class.isAssignableFrom(componentType)) {
                        Object[] os = (Object[]) o;
                        // 创建对应类型的数组并由os拷贝
                        Object[] objects = Arrays.copyOf(os, os.length, (Class<? extends Object[]>) type);
                        o = objects;
                    }
                    field.setAccessible(true);
                    try {
                        field.set(activity, o);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public static void bindView(Activity activity) {
        Class<? extends Activity> aClass = activity.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(BindView.class)) {
                int value = declaredField.getAnnotation(BindView.class).value();
                declaredField.setAccessible(true);
                View viewById = activity.findViewById(value);
                try {
                    declaredField.set(activity, viewById);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
