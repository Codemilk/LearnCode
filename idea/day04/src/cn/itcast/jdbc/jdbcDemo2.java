package cn.itcast.jdbc;

import java.sql.*;

public class jdbcDemo2 {

    public static void main(String[] args) {
        Connection con=null;
        Statement sta=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//注册驱动也是告诉idea内部执行指定数据库的jar包
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3?serverTimezone=GMT%2B8", "root", "123456");
                       sta= con.createStatement();
                      String sql="select *from account ";
                      //int b=sta.executeUpdate(sql);
                  ResultSet res= sta.executeQuery(sql);
            System.out.println(res.toString());
            res.next();
            System.out.println(res.getString("name"));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if(sta!=null){
                try {
                    sta.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }
    }
