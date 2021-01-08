package Druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils_Druids {
     private  static  DataSource das ;
     //创建数据库连接
      static {
         try {
             Properties p=new Properties();
             InputStream in=JDBCUtils_Druids.class.getClassLoader().getResourceAsStream("druid.properties");
             p.load(in);
             das= DruidDataSourceFactory.createDataSource(p);

         } catch (Exception e) {
              e.printStackTrace();
          }
      }
      //获取连接,

      public static Connection getconnecttion() throws SQLException {
          System.out.println(das.getConnection());
                 return das.getConnection();

      }

       //关闭，多参调用少参，减少冗余；
      public static void close(Connection c, Statement s) throws SQLException {
           close(c,s,null);
      }
    public static void close(Connection c, Statement s, ResultSet res) throws SQLException {
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
   public static DataSource datasource(){
          return das;
   }

}
