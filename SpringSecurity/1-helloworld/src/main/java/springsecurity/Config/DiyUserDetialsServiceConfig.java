package springsecurity.Config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DiyUserDetialsServiceConfig extends WebSecurityConfigurerAdapter {

    //从IOC容器中取出   UserDetailsService的实现类
    @Autowired
    private UserDetailsService userDetailsService;



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

           //设置使用哪个userDetailsService实现类
            auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
         http.formLogin()  //自定义自己编写的登入页面
             .loginPage("/login.html")  //登入页面设置
             .loginProcessingUrl("/userlogin") //登入访问路径，说白了封装路径，在表单的action写入这个路径,实际会跳转下面的success
             .defaultSuccessUrl("/success")  //登入成功之后，跳转路径 ,真正意义上的跳转到Controller
             .permitAll()   //表示同意
                 .and()
             .authorizeRequests()
                .antMatchers("/","/hello","/userlogin").permitAll()//表示那些路径不会被拦截 ，可以不用认证直接访问
                .antMatchers("/success").hasAnyAuthority("admins")//表示当前的/index路径，只有admins权限才可以访问
                 .and()
             .csrf().disable();//关闭csrf防护
         ;

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
