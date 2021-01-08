package itheima;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.text.Format;

public class ReflectDemo2 {




    public static void main(String[] args) throws Exception {
        //获取成员变量

        Class<?> c = Class.forName("itheima.student");

        //获取单个成员变量
//        Field name = c.getField("address");
//
//        System.out.println(name);

        //获取所有成员公共变量
//        Field[] f1 = c.getFields();
//
//        for(Field f:f1){
//            System.out.println(f);
//        }
        //获取所有的成员变量
//        Field[] f2 = c.getDeclaredFields();

//        for(Field f:f2){
//            System.out.println(f);
//        }

//        Constructor<?> constructor = c.getConstructor();
//        Object o = constructor.newInstance();
//        name.set(o,"x");
//        System.out.println(o );


        //例子，给student赋值

        Constructor<?> constructor = c.getConstructor();
        Object o = constructor.newInstance();
        Field[] declaredFields = c.getDeclaredFields();
        for (Field s:declaredFields){


        }
    }
}
