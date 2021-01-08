package springbootstudy.springbooot04web.config;


import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import springbootstudy.springbooot04web.component.MyLocaleResolver;
import springbootstudy.springbooot04web.interceptors.LoginInterceptos;

//通过WebMvcConfigurationSupport可以来扩展SpringMVC的功能
@Configuration
/**通过配置@EnableWebMvc,对于boot项目进行全面托管*/
//@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {


    /**
     *
     * @param registry
     *  配置view-controller
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");

    }
    /**
     * 配置拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        不去拦截登入请求和退出请求
//        registry.addInterceptor(new LoginInterceptos()).addPathPatterns("/*")
//                .excludePathPatterns("/login.html","/","/login","/index.html","/testException/1");
    }

    /**
     * 配置国际化解析器
     */
        @Bean
        public LocaleResolver localeResolver(){
            return  new MyLocaleResolver();
        }
}
