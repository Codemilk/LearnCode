package springbootstudy.springbooot04web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

@SpringBootApplication
public class SpringBooot04WebApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringBooot04WebApplication.class, args);
	}

}
