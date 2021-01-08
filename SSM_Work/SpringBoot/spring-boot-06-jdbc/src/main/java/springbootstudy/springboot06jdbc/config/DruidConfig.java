package springbootstudy.springboot06jdbc.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

/**通过ConfigurationProperties配置属性*/
    @ConfigurationProperties(prefix ="spring.datasource")
    @Bean
    public DruidDataSource druidDataSource(){

        return new DruidDataSource();
    }

    /**配置德鲁伊监控servlet*/
    @Bean
    public ServletRegistrationBean  statViewServlet(){

        ServletRegistrationBean<StatViewServlet> statViewServletServletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        Map map=new HashMap();
        map.put("loginUsername", "admin");
        map.put("loginPassword", "123456");
        map.put("allow", "");/*什么也不写表示，允许所有都可以访问*/

        statViewServletServletRegistrationBean.setInitParameters(map);

        return statViewServletServletRegistrationBean;

    }

//    配置一个web监控的filter

    @Bean
    public FilterRegistrationBean webStatFilter(){

        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();

        filterFilterRegistrationBean.setFilter(new WebStatFilter());

//      setUrlPatterns设置拦截路径。
        filterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        return filterFilterRegistrationBean;
    }
}
