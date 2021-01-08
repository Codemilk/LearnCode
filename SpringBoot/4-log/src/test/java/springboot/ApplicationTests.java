package springboot;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    void contextLoads() {
        /**
         *日志级别表示由低到高   trace<debug<info<warn<error
         *  我们可以调节日志级别,日志就只会在删除这个级别以及比他等级低的
         *
         */
       logger.trace("这是trace");
       logger.debug("这是debug");
       /**springboot默认给我们使用的是info级别,可以在配置文件中配置对应的级别logging.level.项目父包名=隔离级别
        *     没有指定级别的就用SpringBoot默认规定的空偶尔：root级别
        * */
       logger.info("这是info");
       logger.warn("这还warn");
       logger.error("这是error");

    }

}
