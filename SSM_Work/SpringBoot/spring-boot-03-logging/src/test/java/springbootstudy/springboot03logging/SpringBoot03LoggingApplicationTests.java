package springbootstudy.springboot03logging;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBoot03LoggingApplicationTests {

//	记录器
    Logger logger= LoggerFactory.getLogger(SpringBoot03LoggingApplicationTests.class);

    @Test
	void contextLoads() {
		/**
		 * 日志级别
		 *     从低到高：trace<debug<info<warn<error
		 *     可以在配置文件来面配置日志隔离等级,只会显示当前等级和更高等级的
		 */
		logger.trace("trace");
    	logger.debug("debug");
//    	SpringBoot默认的隔离级别是info
    	logger.info("info");
    	logger.warn("warn");
    	logger.error("error");

	}

}
