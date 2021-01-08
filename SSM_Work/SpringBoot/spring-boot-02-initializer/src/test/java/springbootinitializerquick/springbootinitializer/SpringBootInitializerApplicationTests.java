package springbootinitializerquick.springbootinitializer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import springbootinitializerquick.springbootinitializer.Bean.Person;

/**
 * SpringBoot的单元测试:
 * 可以在测试期间很方便的类似编码一样进行自动注入等容器
 *
 */
@SpringBootTest
class SpringBootInitializerApplicationTests {

	@Autowired
	Person person;

	@Autowired
	ApplicationContext ioc;

	@Test
	void testImportResources(){

		boolean testImportResource = ioc.containsBean("testImportResource");

		if(testImportResource){
			System.out.println("有了");
		}

	}

	@Test
	void contextLoads() {

		System.out.println(person);

	}



}
