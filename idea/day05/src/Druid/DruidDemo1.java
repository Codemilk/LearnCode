package Druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.util.Properties;

/*
   druid演示

 */
public class DruidDemo1 {
    public static void main(String[] args) throws Exception {
        //1.导入jar包
        //2.定义配置文件
        //3.加载配置文件
        //3:方法一（方法个jibo，不知道为什么错了）：
//        ClassLoader classLoader1=DruidDemo1.class.getClassLoader();
//        URL url= classLoader1.getResource("druid.properties");
//        Properties pro=new Properties();
//
//            pro.load(new FileReader(url.getPath()));
//
//        DataSource dataSource =DruidDataSourceFactory.createDataSource(pro);
//        System.out.println(dataSource);

//        3：方法2：
        Properties pro1=new Properties();
        InputStream in = DruidDemo1.class.getClassLoader().getResourceAsStream("druid.properties");

        pro1.load(in);

        //4.获得链接池对象
        DataSource ds = DruidDataSourceFactory.createDataSource(pro1);

        Connection cons=ds.getConnection();

        System.out.println(cons);


    }
}
