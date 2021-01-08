package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbcDemo1 {
    public static void main(String[] args) throws Exception {
        //1.导入驱动jar包（注意导入后要add as library）
        //2.注册驱动
//        Class.forName("com.mysql.cj.jdbc.Driver");//MySQL在8.0版本后注册驱动时要加入cj，也可以干脆什么都不写
        //3.获取数据库的链接对象
        //Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db3?serverTimezone=GMT%2B8","root","123456");//因为访问mysql数据库时候要校对时差，输入?serverTimezone=GMT%2B8可以忽略此误差，又或者你可以解决误差
        Connection con = DriverManager.getConnection("jdbc:mysql:///db2?serverTimezone=GMT%2B8", "root", "123456");//mysql在访问本地主机数据库且端口是3306时可以简写成：jdbc：mysql：///数据库名，这段代码是获取数据库的连接
        //4.定义sql语句
        String sql = "update account set balance =1000 where id=1";
        //5.获取执行sql的对象statement
        Statement sta = con.createStatement();
        //6.执行sql
        int count = sta.executeUpdate(sql);
        //7.处理结果
        System.out.println(count);
        //8.释放资源
        sta.close();
        con.close();
    }
}
