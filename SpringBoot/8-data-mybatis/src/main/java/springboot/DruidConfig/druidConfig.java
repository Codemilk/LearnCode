package springboot.DruidConfig;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class druidConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource dataSource(){
         return new DruidDataSource();
    }

     /**
      * 配置Druid监控
      *     配置一个管理后台的Servlet
      * */
     @Bean
     public ServletRegistrationBean statViewServlet(){
         //将  statViewServlet 加入到ioc
         ServletRegistrationBean<StatViewServlet> statViewServletServletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
         //配置statViewServlet的初始化参数
          //配置参数和参数值
         Map<String,String> initParams =new HashMap<>();
         initParams.put("jmxUsername","admin");
         initParams.put("jmxPassword","123456");
          //将配置好的属性传入servlet注册器
         statViewServletServletRegistrationBean.setInitParameters(initParams);
         return statViewServletServletRegistrationBean;
     }


     //配置一个web监控的Filter
     public FilterRegistrationBean  webStatFilter(){

         FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
         //和上边一样
         Map<String, String> initParams = new HashMap<>();
         initParams.put("exclusions", "*.js,*.css,/druid/*");
         filterRegistrationBean.setInitParameters(initParams);
         //配置拦截器和对应的拦截路径
         filterRegistrationBean.setFilter(new WebStatFilter());
         filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));

         return     filterRegistrationBean;
     }
}
