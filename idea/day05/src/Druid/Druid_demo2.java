package Druid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
   使用新的工具类

 */
public class Druid_demo2 {
    public static void main(String[] args) {
        //添加的操作，给account添加一条记录'
        Connection cons=null;
        PreparedStatement pres=null;
        try {
            System.out.println("开始：");
            cons=JDBCUtils_Druids.getconnecttion();
            String sql="select * from  account ";
            //给sql里的？赋值

            //3.获取sql对象
             pres=cons.prepareStatement(sql);

            ResultSet res=pres.executeQuery();
            while(res.next()){
                System.out.println(res.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                JDBCUtils_Druids.close(cons,pres);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
