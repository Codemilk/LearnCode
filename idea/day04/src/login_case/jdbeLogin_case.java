package login_case;
import util.jdbcUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
/* 需求：
1.通过键盘录入用户名和密码
2.判断用户是否登入成功或失败
 */
public class jdbeLogin_case {
    public static void main(String[] args) {
        //键盘录入，接受用户名方法
        Scanner in =new Scanner(System.in);
        String name=in.nextLine();
        String password=in.nextLine();
        boolean flag=new jdbeLogin_case().login(name,password);
        System.out.println(flag);
    }
    Connection conn= null;
    //3.获取sql执行对象
    Statement sta=null;
    ResultSet res=null;
    /*登录方法*/
      public boolean login(String username,String password){
      if(username==null&&password==null){
          return false;
      }
      //连接数据库是否登录成功
      //1.获取连接：
          try {
              String sql="select *from user where name='"+username+"'and password='"+password+"'";
              conn= jdbcUtils.getconnection();
            //3.获取sql执行对象
              sta=conn.createStatement();
               res=sta.executeQuery(sql);
              //4.判断res是否有数据，有数据证明核对成功
                return res.next();
          } catch (SQLException e) {
              e.printStackTrace();
          }finally {
              jdbcUtils.close(sta,conn,res);
          }
          return false;
      }


}
