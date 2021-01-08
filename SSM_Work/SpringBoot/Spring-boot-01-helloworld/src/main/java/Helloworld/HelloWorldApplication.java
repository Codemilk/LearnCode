package Helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author lenovo
 * 开启SpringBoot的第一个项目
 * @SpringBootApplication 来标注一个主程序类，说明这是一个Spring Boot应用
 */
@SpringBootApplication
public class HelloWorldApplication {

    public static void main(String[] args) {
        //Spring应用启动起来
        ConfigurableApplicationContext run = SpringApplication.run(HelloWorldApplication.class, args);


    }
}
