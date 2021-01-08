package springbootinitializerquick.springbootinitializer.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springbootinitializerquick.springbootinitializer.Bean.TestImportResource;

/**
 * @author lenovo
 * configuration
 */
@Configuration
public class configuration {

    /**将方法的返回值添加到容器,并且这个组件的默认Id就是方法名字*/
    @Bean
    public TestImportResource testImportResource(){
        System.out.println("testImportResource");
        return new TestImportResource();

    }
}
