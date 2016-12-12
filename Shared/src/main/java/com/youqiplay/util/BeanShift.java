package com.youqiplay.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by zhouyongbo on 2016/12/11.
 */
public class BeanShift {



    public static String oneLowerCase(String str){
        return  str.substring(0, 1).toUpperCase() + str.substring(1, str.length());
    }

    /**
     * 将对象befor属性字段  复制给 after
     * @param befor
     * @param after
     * @return
     */
    public static Object beanTransform(Object befor,Object after) {
        Class beforClass = befor.getClass();
        Class afterClass = after.getClass();
        //新获取字段名称
        Field[] fields = afterClass.getDeclaredFields();
        for (Field field:fields){
            String afterName = field.getName();
            String afterNameCase = oneLowerCase(afterName);
            try {
                Method beforMethod  = beforClass.getDeclaredMethod("get" + afterNameCase);
                Object beforInvoke = beforMethod.invoke(befor);

                Method afterMethod = afterClass.getDeclaredMethod("set" + afterNameCase,field.getType());
                if (beforMethod == null ){
                    break;
                }
                afterMethod.invoke(after,beforInvoke);
            }catch (NoSuchMethodException e){
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e) {
            }

        }
        return after;
    }

}
