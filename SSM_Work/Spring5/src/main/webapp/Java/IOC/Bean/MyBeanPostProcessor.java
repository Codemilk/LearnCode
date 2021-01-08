package IOC.Bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

public class MyBeanPostProcessor implements BeanPostProcessor {

//    在初始化之前
    @Nullable
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("在我们初始化之前执行的方法");
        return bean;
    }

//    在初始化之后
    @Nullable
    public  Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("在我们初始化之后执行的方法");
        return bean;
    }
}
