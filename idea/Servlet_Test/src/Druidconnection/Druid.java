package Druidconnection;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Druid {
    private static DataSource  dataSource=null;
    private static InputStream in=null;
    static {
        Properties p=new Properties();
        in = Druid.class.getClassLoader().getResourceAsStream("druid.properties");
            try {
            p.load(in);
            dataSource = DruidDataSourceFactory.createDataSource(p);
            System.out.println(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
    }
}

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    public static  DataSource getDataSource(){
        return dataSource;
    }
    public void close(Connection c, Statement s, ResultSet res) throws SQLException {
        if(res!=null){
            res.close();
        }
        if(s!=null){
            s.close();
        }
        if(c!=null){
            c.close();
        }
    }
}
