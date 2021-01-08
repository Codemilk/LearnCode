package springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import springboot.Bean.person;
import springboot.Service.helloService;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private person  p;

    @Autowired
    private ApplicationContext applicationContext;



    @Test
    void test1() {

        System.out.println(p);

    }

    @Test
    void test2() {
        boolean helloService = applicationContext.containsBean("helloService");
        System.out.println(helloService);

    }

}
