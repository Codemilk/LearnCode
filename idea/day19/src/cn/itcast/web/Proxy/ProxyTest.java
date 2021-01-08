package cn.itcast.web.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {



    public static void main(String[] args) {
        //创建真实对象
        Lenovo lenovo=new Lenovo();
        //动态代理增强对象
         /*
                   Proxy.newProxyInstance()
                   需要三个参数
                     1.类加载器：真实对象.getClass().getClassLoader()
                     2.接口数组：真实对象.getClass().getInterfaces()
                     3.处理器：new InvocationHandler()（匿名内部类）处理核心业务逻辑
          */
        SaleComputer proxyInstance = (SaleComputer)Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
            /*
               代理逻辑编写的方法，代理对象调用的所有方法都会触发该方法执行
               1.Proxy:代理对象
               2.method：代理对象调用的方法，被封装的对象
               3.args：方法执行时，传递的实际参数
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                System.out.println("代理方法执行了");
//                System.out.println(method.getName());
//                System.out.println(args[0]);
            // 1.增强参数
            // 判断是否是sale方法
                if(method.getName().equals("sale")){
            //如果是，就增强参数
            //增强方法体
                    System.out.println("感谢您的购买");
                   double money = (double) args[0];
                   money=money*0.85;
                   Object invoke = method.invoke(lenovo, money);
            //使用真实对象调用该方法
            //3.增强返回值
                    return invoke+"和一台鼠标垫";
                }else{
                    Object obj = method.invoke(lenovo, args);
                     return obj;
                }

            }
        });

        //调用方法
      String sale = proxyInstance.sale(8000);
      System.out.println(sale);
    }


}
