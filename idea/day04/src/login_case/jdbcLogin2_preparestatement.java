package login_case;
import util.jdbcUtils;

import java.sql.*;
import java.util.Scanner;
/* 需求：
1.通过键盘录入用户名和密码
2.判断用户是否登入成功或失败
登录方法：使用preparestatement
 */
public class jdbcLogin2_preparestatement {
    public static void main(String[] args) {
        //键盘录入，接受用户名方法
        Scanner in =new Scanner(System.in);
        String username=in.nextLine();
        String password=in.nextLine();
        boolean flag=new jdbeLogin_case().login(username,password);
        System.out.println(flag);
    }
    Connection conn= null;
    //3.获取sql执行对象
    PreparedStatement pres=null;
    ResultSet res=null;
    /*登录方法*/
    public boolean login(String username,String password){
        if(username==null&&password==null){
            return false;
        }
        //连接数据库是否登录成功
        //1.获取连接：
        try {
            String sql="select *from user where name=?and password=?";
            conn= jdbcUtils.getconnection();
            //3.获取sql执行对象

            pres=conn.prepareStatement(sql);
              //执行mysql语句 无参数执行是子类特有的
            //给问好赋值：
            pres.setString(1,username);
            pres.setString(1,password);


            //4.判断res是否有数据，有数据证明核对成功
            res=pres.executeQuery();
            return res.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtils.close(pres,conn,res);
        }
        return false;
    }


}
