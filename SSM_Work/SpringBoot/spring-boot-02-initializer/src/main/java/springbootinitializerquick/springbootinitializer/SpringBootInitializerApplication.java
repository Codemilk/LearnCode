package springbootinitializerquick.springbootinitializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author lenovo
 * SpringBootInitializerApplication：配置类
 * @ImportResource 可以将SPirng文件扫描进来
 */
//@ImportResource("classpath:Spring.xml")
@SpringBootApplication
public class SpringBootInitializerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootInitializerApplication.class, args);
	}

}
