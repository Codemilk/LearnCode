package COM.AOP.AopImp;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class LoggingAspect {

    //前置通知：在目标方法开始之前执行 ;
    @Before("execution(public int COM.AOP.AopImp.Calculator.*(int,int))")

    public void beforeMethod(JoinPoint joinPoint){
        String methodName=joinPoint.getSignature().getName();
        List<Object> args=Arrays.asList(joinPoint.getArgs());
        System.out.println("the method "+methodName+" begins with"+args);
    }

   //后置通知：在没有标方法执行后(无论方法是否异常)，还不能访问目标方法执行的结果
    @After("execution(public int COM.AOP.AopImp.Calculator.*(int,int))")
    public void agterMethod(JoinPoint joinPoint){
        String methodName=joinPoint.getSignature().getName();
        List<Object> args=Arrays.asList(joinPoint.getArgs());
        System.out.println("the method "+methodName+" ends with");
    }
}
