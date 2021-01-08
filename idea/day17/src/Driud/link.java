package Driud;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class link {
   private static DataSource dataSource=null;
    static {
        Properties p=new Properties();


        InputStream resourceAsStream = link.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            p.load(resourceAsStream);
           dataSource = DruidDataSourceFactory.createDataSource(p);
            System.out.println(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public Connection getConnextion() throws SQLException {
        return dataSource.getConnection();
    }
}
