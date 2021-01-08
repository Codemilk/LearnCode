package AOP.AOP_annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//增强类
@Component
//表示生成了代理对象
@Aspect
@Order(1)
public class UserProxy2 {

    @Pointcut("execution(public int AOP.AOP_annotation.User.add())")
    //为了让切点表达式重用，这里建立表示切点表达式的方法
    public void pointcut(){

    }

//    JoinPoint:可以联动这个方法
    //前置通知
    @Before("pointcut()")
    public void before(){
        System.out.println("before2");
    }
//
//    //后置通知
//    @After("execution(public int AOP.AOP_annotation.User.add()))")
//    public void after(){
//        System.out.println("after2");
//    }
//
//    //返回通知：
//    //在方法正常结束后执行的代码
//    //返回通知是可以访问到方法的返回值！
//    @AfterReturning(value = "execution(public int AOP.AOP_annotation.User.add()))",returning = "res")
//    public void AfterReturning(int res){
//        System.out.println("AfterReturning2："+res);
//    }
//     //异常通知：只有异常的时候才会执行,可以返回异常
//    @AfterThrowing(value = "execution(public int AOP.AOP_annotation.User.add()))",throwing = "s")
//    public void AfterThrowing(Exception s){
//        System.out.println("AfterThrowing2:"+s.toString());
//    }
//
//   /*环绕通知，功能很强，但是并不常用
//    *环绕通知类似于动态代理的全过程：ProceedingJoinPoint类型的参数可以决定是否执行目标方法
//    *且环绕通知必须有返回值，返回值为目标方法的返回值
//   */
//    @Around("execution(public int AOP.AOP_annotation.User.add()))")
//    public int Around(ProceedingJoinPoint joinPoint) throws Throwable {
//
//        System.out.println("环绕之前2");
//
//        //被增强的方法执行
//        Object proceed = joinPoint.proceed();
//
//        System.out.println("环绕之后2");
//        return (int) proceed;
//
//    }
}
