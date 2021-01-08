package AOP.Jdk_Proxy.Proxy;

import AOP.Jdk_Proxy.Dao.UserDao;
import AOP.Jdk_Proxy.Dao.UserDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserDaoProxy  {

    public static void main(String[] args) {

        //获得类目录
        ClassLoader classLoader = UserDaoProxy.class.getClassLoader();
        //获取接口
        Class [] interfaces={UserDao.class};
        //传入对应被代理对象（接口实现类）
        UserDao userDao=new UserDaoImpl();
//        newProxyInstance的参数：
//                            类目录,接口集，增强代理对象的接口invokeUserDao
        UserDao userDao1 = (UserDao) Proxy.newProxyInstance(classLoader,interfaces, new invokeUserDao(userDao));

        int re = userDao1.add(1, 2);

    }

}
//创建代理对象的增强实现
class invokeUserDao implements InvocationHandler{

    private Object object;

    //1.创建的是谁的代理对象，把谁传过来，有参构造就行

    public invokeUserDao(Object object){
        this.object=object;

    }

    //这里就是增强逻辑的方法
/*  invoke参数：
       proxy：正在返回的那个代理对象，一般情况下，在invoke方法中不适用该对象
              原因： 当你调用proxy这个对象的时候，难免会调用它的方法，它来自于invoke，造成的结果就是无限循环
       method：正在被调用的方法
       args：调用方法时，传入的参数


*/
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //方法之前增强的逻辑
        System.out.println("Improvement before the method");

        //被增强方法方法执行,

        Object invoke = method.invoke(object, args);
        System.out.println("被增强方法执行了，结果是："+invoke);

        //方法之后增强的逻辑
        System.out.println("Improvement after the method");

        //方法返回的参数
        return invoke;
    }
}