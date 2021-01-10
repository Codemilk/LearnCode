package springboot.Config;

import Filters.MyFilter;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springboot.Listeners.MyListener;
import springboot.Servlet.MyServlet;

import javax.servlet.Filter;
import javax.servlet.ServletRegistration;
import java.util.Arrays;
import java.util.EventListener;

@Configuration
public class MyServerConfig {

    //注册三大组件
    //Listener
    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean(){
        //注册Listener
        ServletListenerRegistrationBean<EventListener> eventListenerServletListenerRegistrationBean = new ServletListenerRegistrationBean<>(new MyListener());
         return eventListenerServletListenerRegistrationBean;
    }

    //Filter
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){

        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        //传入指定的Filter
        filterFilterRegistrationBean.setFilter(new MyFilter());
        //传入指定拦截器拦截的路径
        filterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/MyServlet","/hello"));

        return filterFilterRegistrationBean;
    }
    //Servlet
    @Bean
    public ServletRegistrationBean servletRegistration(){
        /**
         * 参数:对应的servlet,对应servlet拦截的路径
         * */
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new MyServlet(),"/MyServlet");
        return servletRegistrationBean;
    }


    //修改servlet的容器
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){
        /**
         * public interface WebServerFactoryCustomizer<T extends WebServerFactory> {
         *           	void customize(T fa ctory);
         *ConfigurableWebServerFactory继承自WebServerFactory，所以写成这种方式
         * */
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            //定制 嵌入式的servlet容器的相关规则
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                factory.setPort(8080);
            }
        };


    }

}
