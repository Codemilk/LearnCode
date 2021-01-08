package COM.AOP.Aopimpl2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
@Aspect
public class logginggiao {

    @Pointcut("execution(public int COM.AOP.Aopimpl2.CalculatorImpl.*(int,int))")
    public void DeclareJoinPointExpression(){}

    @Before("DeclareJoinPointExpression()")
    public void beforeMethod(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        System.out.println("logging执行了");
    }
//
//    @After("execution(public int COM.AOP.Aopimpl2.CalculatorImpl.*(int,int)))")
//    public void afterMethod(JoinPoint joinPoint){
//
//        String name = joinPoint.getSignature().getName();
//        Object[] args = joinPoint.getArgs();
//
//        System.out.println("after执行了");
//
//    }
//
//
//    @AfterReturning(value = "execution(public int COM.AOP.Aopimpl2.CalculatorImpl.*(int,int)))",returning = "result")
//    //在方法正常结束后执行的代码
//    //返回通知是可以访问到方法的返回值！
//    public void afterReturningMethod(JoinPoint joinPoint,Object result){
//
//        String name = joinPoint.getSignature().getName();
//        Object[] args = joinPoint.getArgs();
//
//        System.out.println("AfterReturning得到的返回值是："+result.toString());
//    }
//   //异常通知，发生异常的时候,可以指定出现特定异常时候才出现
//    @AfterThrowing(value = "execution(public int COM.AOP.Aopimpl2.CalculatorImpl.*(int,int)))",throwing = "ex")
//    public void afterThrowingMethod(Exception ex){
//
//
//        ex.printStackTrace();
//        System.out.println("AfterThrowing执行了");
//    }
//
//    /*环绕通知，功能很强，但是并不常用
//    *环绕通知类似于动态代理的全过程：ProceedingJoinPoint类型的参数可以决定是否执行目标方法
//    *且环绕通知必须有返回值，返回值为目标方法的返回值
//    */
//    @Around("execution(public int COM.AOP.Aopimpl2.CalculatorImpl.*(int,int))")
//    public Object aroundMethod(ProceedingJoinPoint pj) {
//        Object result=null;
//
//        try {
//
//            //前置通知
//            System.out.println("这里是前置通知");
//
//            //方法执行
//            result=pj.proceed();
//
//
//        } catch (Throwable throwable) {
//
//            //异常通知
//            System.out.println("异常通知");
//        }
//            //后置通知
//            System.out.println("这里是后置通知");
//
//
//        System.out.println("aroundMethod执行了 "+pj.getSignature().getName()+":"+result);
//        return result;
//    }

}
