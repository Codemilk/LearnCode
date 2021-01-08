package springbootstudy.springbooot04web.config;


import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springbootstudy.springbooot04web.Mylistener;
import springbootstudy.springbooot04web.Myfilter;
import springbootstudy.springbooot04web.Myservlet;

import javax.servlet.Filter;
import java.util.EventListener;

/**配置servlet以及他的容器*/
@Configuration
public class ServletConfig {

    /**
     *
     * 配置listener
     *
     */
    @Bean
     public ServletListenerRegistrationBean servletListenerRegistrationBean(){


         ServletListenerRegistrationBean<EventListener> listenerRegistrationBean = new ServletListenerRegistrationBean<>();

         listenerRegistrationBean.setListener(new Mylistener());

         return  listenerRegistrationBean;
     }

    /***
     *
     * 配置加入filter
     */

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){

        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new Myfilter());
        filterFilterRegistrationBean.addUrlPatterns("/Myservlet");


        return filterFilterRegistrationBean;
    }


    /**加入servlet*/
    @Bean
    public ServletRegistrationBean  servletRegistrationBean(){
/**
 * public ServletRegistrationBean(T servlet, String... urlMappings)
 * ServletRegistrationBean构造器，第一个参数：传入相应的servlet，第二参数：传入对应的拦截路径*/
        ServletRegistrationBean<Myservlet> myservletServletRegistrationBean = new ServletRegistrationBean<Myservlet>(new Myservlet(), "/Myservlet");
        return myservletServletRegistrationBean;
    }

    /***
     * @return： 这里使用匿名内部类，就相当于创建一个自定义类的继承了这个WebServerFactoryCustomizer接口，
     *           并在其中调用了ConfigurableWebServerFactory的方法，对servlet容器管理,对于所有的容器都会游泳
     */
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){
        return new  WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory container) {
                container.setPort(8081);
            }
        };
    }


}
