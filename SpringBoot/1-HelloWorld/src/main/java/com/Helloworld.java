package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**告诉SpringBoot来标注一个主程序,告诉这是一个SpringBoot应用  */
@SpringBootApplication
public class Helloworld {

    public static void main(String[] args) {

        SpringApplication.run(Helloworld.class, args);

    }

}
