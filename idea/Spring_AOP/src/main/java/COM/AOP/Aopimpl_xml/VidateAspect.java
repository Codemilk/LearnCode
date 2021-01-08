package COM.AOP.Aopimpl_xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;


public class VidateAspect {


    public void vidateAspect(JoinPoint joinPoint,Object result){

        System.out.println("VidateAspect"+ Arrays.asList(joinPoint.getArgs()));
        System.out.println(result);
    }
}
