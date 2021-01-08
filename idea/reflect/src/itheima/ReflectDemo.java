package itheima;
/*
   获取反射的方法：
                 1.类.class：会返回class对象
                 2.对象.getClass()
                 3.Class.forname("类名“)

 */
public class ReflectDemo {

    public static void main(String[] args) throws ClassNotFoundException {

        Class<student> s1 = student.class;

        Class<student> s2 = student.class;


        System.out.println(s1==s2);
        System.out.println("--------------------");


        student student=new student();
        Class<? extends student> s3 = student.getClass();
        System.out.println(s1==s3);
        System.out.println("--------------------");


        Class<?> s4 = Class.forName("itheima.student");
        System.out.println(s4==s1);

    }
}
