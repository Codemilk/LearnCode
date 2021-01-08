package itheima;

import com.sun.media.sound.SoftTuning;

import java.lang.reflect.Method;

public class ReflectDemo3 {
    //获取成员方法并且是使用

    public static void main(String[] args) throws Exception {
        Class<?> c = Class.forName("itheima.student");

       //获取所有公有的成员方法：c.getMethods
        Method[] methods = c.getMethods();

//        for (Method m:methods){
//            System.out.println(m);
//        }

        //获取所有的成员方法:

//        Method[] declaredMethods = c.getDeclaredMethods();
//        for (Method m:declaredMethods){
//            System.out.println(m);
//        }

        Method function = c.getDeclaredMethod("function");



    }

}
