package springboot.Config;


import org.springframework.context.annotation.Configuration;


/**
 *  @Configuration 指明当前类是一个配置类，就是来替代之间的Spring配置文件
 *    相当于在配置文件中用<bean></bean>加入组件
 *
 * */

@Configuration
public class myConfiguration {

    /**@Bean: 将方法的返回值添加到容器中，容器中这个组件默认的id就是方法名*/
//    @Bean
//    public helloService helloService() {
//      return   new helloService();
//    }
}
