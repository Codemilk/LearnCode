package util;

import Mytest.emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/*演示jdbc工具类*/
public class JdbcUtils_Test
{
    public List<emp> find_all(){
        Connection con=null;
        Statement sta=null;
        ResultSet res=null;
        List<emp> list=null;
        //1.查询步骤：
        try {
            String sql="select *from emp";
            con=jdbcUtils.getconnection();
            sta=con.createStatement();
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
            jdbcUtils.close(sta,con,res);
        }


          return list;
    }

    public static void main(String[] args) {
         new JdbcUtils_Test().find_all();
    }
}
