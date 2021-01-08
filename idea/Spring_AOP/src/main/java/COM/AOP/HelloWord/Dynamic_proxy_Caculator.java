package COM.AOP.HelloWord;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Dynamic_proxy_Caculator  {

    //要代理的对象
    private Calculator calculator;


    public  Dynamic_proxy_Caculator (Calculator calculator) {
        this.calculator=calculator;
    }


        public Calculator getLoggingProxy() {
          Calculator calculatorProxy = null;

          //需要告诉代理对象由哪一个类加载器加载
          ClassLoader classLoader = calculator.getClass().getClassLoader();
          //代理对象有哪些方法
          Class<?>[] interfaces = calculator.getClass().getInterfaces();

          //invocationHandler代理方法，执行代码逻辑
            calculatorProxy = (Calculator) Proxy.newProxyInstance(classLoader, interfaces, new InvocationHandler() {
             /*
                invoke参数：
                          proxy：正在返回的那个代理对象，一般情况下，在invoke方法中不适用该对象
                                 原因： 当你调用proxy这个对象的时候，难免会调用它的方法，它来自于invoke，造成的结果就是无限循环
                          method：正在被调用的方法
                          args：调用方法时，传入的参数

              */
              @Override
              public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                  System.out.println(method.getName());
                  System.out.println(args);

                  System.out.println("invoke");

                  Object invoke = method.invoke(calculator, args);
                  System.out.println(invoke);
                  return 0;
              }
          });

         return calculatorProxy;
      }


}
