package util;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/*
   JDBC 工具类
 */
public class jdbcUtils {
    /*为了未来更好的修改，我们不加入任何参数，我们选择配置文件，
      文件的读取在这里读取一次就可以了,当你想要修改的时候只需要修改配置文件里的内容就好了
     */
    private static String url;
    private static String user;
    private static String password;
    private static String driver;
    /*静态代码开优先于所有代码块，所以常用于配置文件*/
      static {
        Properties pro=null;
        try {//创建properties集合类。
             ClassLoader c=jdbcUtils.class.getClassLoader();
             URL url1=c.getResource("pro.properties");
             pro=new Properties();
            String path=url1.getPath();
            System.out.println(path);
            //加载配置文件
            pro.load(new FileReader(path));
            url=pro.getProperty("url");
            user=pro.getProperty("user");
            password=pro.getProperty("password");
            driver=pro.getProperty("driver");

            Class.forName(driver);//驱动注册
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    /*
       获取连接
       连接对象
     */
      public static Connection  getconnection() throws SQLException {

              return  DriverManager.getConnection(url,user,password);

      }






      //释放资源
      public static void close(Statement stmt, Connection con){
          if(stmt!=null){
              try {
                  stmt.close();
                  /*不可以将con.close()写在这个地方，因为stmt一旦报错或者确实就是空的，
                    那么con就无法关闭*/
              } catch (SQLException e) {
                  e.printStackTrace();
              }
          }
          if(con!=null){
              try {
                  con.close();
              } catch (SQLException e) {
                  e.printStackTrace();
              }
          }
      }



    public static void close(Statement stmt, Connection con, ResultSet res){
          if(res!=null){
              try {
                  res.close();
              } catch (SQLException e) {
                  e.printStackTrace();
              }
          }
        if(stmt!=null){
            try {
                stmt.close();
                /*不可以将con.close()写在这个地方，因为stmt一旦报错或者确实就是空的，那么con就无法关闭*/
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
