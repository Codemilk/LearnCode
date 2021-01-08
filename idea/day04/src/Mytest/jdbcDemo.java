package Mytest;

import util.jdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/*

   查询所有的emp对象

 */
public class jdbcDemo {
    public List<emp>find_all(){
        Connection con=null;
        Statement sta=null;
        ResultSet res=null;
        List<emp> list=null;
        //1.查询步骤：
        try {
//             Class.forName("com.mysql.cj.jdbc.Driver");
//             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/db3?serverTimezone=GMT%2B8","root","123456");
            con= jdbcUtils.getconnection();
            String sql="select *from emp";
             sta=con.createStatement( );
             res=sta.executeQuery(sql);
             //遍历结果接，封装对象，装载集合
            emp emp=null;
            list=new ArrayList<emp>();
            while(res.next()){
                //获取数据

                int id= res.getInt("id");
               String name=res.getString("ename");
               int job_id=res.getInt("job_id");
               int mge=res.getInt("mgr");
               Date joindate=res.getDate("joindate");
               double salary=res.getDouble("salary");
               double bonus=res.getDouble("bonus");
               int dep_id=res.getInt("dept_id");
               //创建emp对象
               emp=new emp();
               emp.setId(id);
               emp.setEname(name);
               emp.setJob_id(job_id);
               emp.setMgr(mge);
               emp.setJoindate(joindate);
               emp.setSalsary(salary);
               emp.setBounds(bonus);
               emp.setDept_id(dep_id);
               list.add(emp);
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(res!=null){
                try {
                    res.close();
                    sta.close();
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


  return list;
    }

    public static void main(String[] args) {
        List<emp> list=new jdbcDemo().find_all();
        System.out.println(list);
    }}
