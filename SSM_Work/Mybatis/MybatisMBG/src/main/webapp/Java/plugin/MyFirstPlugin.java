package plugin;


import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Statement;
import java.util.Properties;

/**
     @Intercepts: 表示当前这个类是一个插件
     @Signature: 为插件签名，告诉mybaits当前插件用来拦截哪一个对象的哪一个方法
**/
@Intercepts({
        @Signature(type = StatementHandler.class,method ="parameterize",args = java.sql.Statement.class)
})
public class MyFirstPlugin  implements Interceptor {
/**
    intercept:拦截
              拦截目标对象（四大对象）的某一个方法
 **/

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
//        执行目标方法
        System.out.println("First intercept");
//        动态改变一下sql运行的参数，以前1号员工，实际上要的是三号员工
//         invocation.getMethod()
        Object proceed = invocation.proceed();

//         获取
        System.out.println("当前的拦截对象："+invocation.getTarget());

//        返回执行后的返回值
        return  proceed;
    }
//plugin：
//       包装目标对象，包装，为目标对象常见一个代理对象
    @Override
    public Object plugin(Object target) {

        /**
         * Mybatis提供Plugin来为target包装成一个代理对象
         */
        System.out.println("plugin "+target);
        Object wrap = Plugin.wrap(target, this);
        System.out.println(wrap.toString());
        return wrap;
    }

    /**
     *
     * setProperties：
     *           将插件注册时的property属性设置进来
     *
     */
    @Override
    public void setProperties(Properties properties) {

        System.out.println("properties:"+properties);


    }
}
