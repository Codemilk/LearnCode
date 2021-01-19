package springsecurity.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //使用密码加密类，对密码进行加密
        BCryptPasswordEncoder brBCryptPasswordEncoder =new BCryptPasswordEncoder();
        String encode = brBCryptPasswordEncoder.encode("666");
        //设置用户名和密码以及角色
        auth.inMemoryAuthentication().withUser("tom").password(encode).roles("admin");
    }

    //我们使用密码加密类的时候，需要手动去给他创建一个具体的实现对象
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
