package Transaction.CompletelyAnnotation;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration//配合类
@ComponentScan(basePackages = "Transaction")//组件扫描
@EnableTransactionManagement//开启事务
public class TxConfig {
//创建数据库连接池
    @Bean
 public DruidDataSource getDruidDataSource(){

         DruidDataSource dataSource=new DruidDataSource();

        return null;
    }

    @Bean
    public JdbcTemplate getJdbct(){

        return null;
    }
}
