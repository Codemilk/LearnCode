package springboot.Config;


import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springboot.Component.LoginHandlerInterceptor;
import springboot.Component.MyLocalResolver;

import java.util.Arrays;

/**通过调用WebMvcConfigurer接口，继承方法，来扩展SpringMVC
 * */
//@EnableWebMvc
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {


//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("index");
//        registry.addViewController("index.html").setViewName("index");
//
//    }
    
    /**所有的WebMvcConfigurer都会被WebMvcConfigurerComposite中从容器中取出来，然后一起起作用*/
    @Bean
    public WebMvcConfigurer  webMvcConfigurer(){
        return new WebMvcConfigurer() {
            //SpringMvc扩展试图转换器
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                    registry.addViewController("/").setViewName("index");
                    registry.addViewController("/index.html").setViewName("index");
                    registry.addViewController("/dashboard.html").setViewName("dashboard");
            }
            /**SpringMvc扩展拦截器
             *       注意：SpringBoot已经做好了静态资源的映射，但是webjars等小细节还是要自己手动取出拦截路径
             * */
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/","/index.html","/login","/webjars/**","/css/**","/img/**");
//            }

        };
    }
//    我们要添加一个localResolver，让自动配置的localResolver失效
    @Bean
    public LocaleResolver  localeResolver(){

        MyLocalResolver myLocalResolver = new MyLocalResolver();
        return myLocalResolver;
    }
}
