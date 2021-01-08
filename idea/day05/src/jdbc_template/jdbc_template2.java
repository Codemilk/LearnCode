package jdbc_template;

import Druid.JDBCUtils_Druids;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class jdbc_template2 {

  //修改一号数据salary为一10000
    @Test
public void test(){
        JdbcTemplate jt=new JdbcTemplate(JDBCUtils_Druids.datasource());
        String sql="update emp set salary=10000 where id=?";
        jt.update(sql,1001);
}

    //查询id为一的记录，将其封装为map集合
   @Test
    public void test3(){
        String sql="select *from emp where id=?";
       JdbcTemplate jt=new JdbcTemplate(JDBCUtils_Druids.datasource());
       Map m= jt.queryForMap(sql,1001);
       System.out.println(m .toString());
   }
   //查询所有记录
    @Test
    public void test4(){
        JdbcTemplate jt=new JdbcTemplate(JDBCUtils_Druids.datasource());
        String sql="select *from emp";
       List list= jt.queryForList(sql);
         for(Object o:list){
             System.out.println(o);
        }
    }
     //查询所有记录，将其封装为Emp对象的list集合
     @Test
     public void test5(){
         JdbcTemplate jt=new JdbcTemplate(JDBCUtils_Druids.datasource());
         String sql="select *from emp";
       List list=jt.query(sql, new RowMapper<EMP>(){
             @Override
             //把这个堪称querymap 他把一行行的map封装好
             public EMP mapRow(ResultSet resultSet, int i) throws SQLException {
                         EMP E=new EMP();
                         return E;
             }
         });
       for( Object M:list){
           System.out.println();
       }
     }
    @Test
    public void test6(){
        JdbcTemplate jt=new JdbcTemplate(JDBCUtils_Druids.datasource());
        String sql="select *from emp";
      List<EMP> list=  jt.query(sql,new BeanPropertyRowMapper<EMP>(EMP.class));
       for(EMP m:list){
           System.out.println(m);
        }
    }
   //查询总记录数
    @Test
    public void test7(){

        JdbcTemplate jt=new JdbcTemplate(JDBCUtils_Druids.datasource());
        String sql="select count(id) from account";
        Integer k=jt.queryForObject(sql, Integer.class);
        System.out.println(k);

     }
}
