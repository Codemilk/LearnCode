package cn.itcast.jdbc;

import java.sql.*;

public class jdbcDemo3 {
    public static void main(String[] args){
        Connection con=null;
        Statement  stmt=null;
        ResultSet sta=null;

        //注册驱动，让内bu知道用什么jar包
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //连接到数据库jdbc:mysql://localhost:3306/db3?serverTimezone=GMT%2B8
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/db3?serverTimezone=GMT%2B8","root","123456");
            //创建数据库sql对象
            stmt=con.createStatement();
            sta=stmt.executeQuery("select * from account");
            //执行sql语句
            while (sta.next()) {
                System.out.println(sta.getString("name"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                sta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



    }}
