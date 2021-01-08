package COM.AOP.Aopimpl2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Order(5)
@Component
@Aspect
public class VidateAspect {
    @Before("execution(public * COM.AOP.Aopimpl2.CalculatorImpl.*(int,int))")
    public void vidateAspect(JoinPoint joinPoint){

        System.out.println("VidateAspect"+ Arrays.asList(joinPoint.getArgs()));

    }
}
