package itheima;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
     反射获取构造方法并使用
 */
public class ReflectDemo1 {

    public static void main(String[] args) throws Exception{
       //获取class对象

        Class<?> c = Class.forName("itheima.student");

        //Constructors返回一个Constructor对象的数组，Constructor对象反映了由该Class对象的所有公有构造函数
//        Constructor<?>[] constructors = c.getConstructors();

//        Constructor<?>[] constructors = c.getDeclaredConstructors();
//        for(Constructor s:constructors){
//            System.out.println(s);
//        }



        //通过构造函数来创建对象

//        Constructor<student> constructor = c.getConstructor(String.class,String.class,int.class);
//
//        student student = constructor.newInstance("li","dd",40);
//        System.out.println(student);


        Constructor<?> declaredConstructor = c.getDeclaredConstructor(String.class);
        //取消当前类的访问检查
        declaredConstructor.setAccessible(true);
        Object laoli = declaredConstructor.newInstance("laoli");
        System.out.println(laoli);

    }
}
