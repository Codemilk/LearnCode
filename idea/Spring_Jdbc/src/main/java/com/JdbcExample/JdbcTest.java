package com.JdbcExample;

import com.JdbcExample.doMain.User;
import com.sun.javafx.collections.MappingChange;
import javafx.application.Platform;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

import java.lang.management.PlatformManagedObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcTest {

    ApplicationContext ctx=new ClassPathXmlApplicationContext("JdbcTest.xml");


    DataSource dataSource=(DataSource) ctx.getBean("dataSource1");

    JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
//    JdbcTemplate jdbcTemplate=(JdbcTemplate)ctx.getBean("jdbcTemplate");

    NamedParameterJdbcTemplate npJdbcTemplate= (NamedParameterJdbcTemplate)ctx.getBean("npJdbcTemplate");

    @Test
    public void test(){

        String sql="select * from user";

        List<User> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));

        System.out.println(query);

    }

    @Test
    public void test1(){

        String sql="update user set name=?";

        int diu = jdbcTemplate.update(sql, "diu");

        String sql1="select * from user";


        List<User> query = jdbcTemplate.query(sql1, new BeanPropertyRowMapper<User>(User.class));

        System.out.println(query);

    }

    @Test
    public void test2(){
        String sql="insert into user values(null,?,?,?,?,?,?,null,null)";

        List<Object []> batchArgs=new ArrayList();

        batchArgs.add(new Object[]{"aa","dasd","Dasd"});
        batchArgs.add(new Object[]{"aa","dasd","Dasd"});
        batchArgs.add(new Object[]{"aa","dasd","Dasd"});

        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);

        String sql1="select * from user";

        List<User> query = jdbcTemplate.query(sql1, new BeanPropertyRowMapper<User>(User.class));

        System.out.println(query);

    }

    /*
    * 具名参数：可以为参数起名字
    *        1.好处：若有多个参数，则不用再去对应位置，直接对应参数名
    *        2.相比经典的jdbcTemplate，参数少的时候很麻烦
    *
    * */







    @Test
    public  void testNameParameterJdbcTemplate(){

//    从IOC容器获取具名jdbcTemplate

//   这是经典的jdbcTemplate插入操作
     String sql1="insert into user(id,username,password) values(?,?,?)";

//   具名参数的写法
        String sql="insert into user(id,username,password)values(:ln,:un,:pw);";

       Map<String,Object> ParaMap=new HashMap<>();
//      为具名参数赋值
        ParaMap.put("ln","4");
        ParaMap.put("un","gia桑");
        ParaMap.put("pw","6666");

        npJdbcTemplate.update(sql,ParaMap);
    }
    // 也可以用具名参数，加入对象本身,
    //优点：1.SQL语句中的参数名和类的属性一致
    //       2.使用SqlParameterSource 的BeanPropertySqlParameterSource实现类作为参数
      @Test
    public void testNameParameterJdbcTemplate2(){

        String sql="insert into user(id,username,password)values(:id,:username,:password);";

        //创建一个基本对象
        User user=new User();
        user.setId(66);
        user.setUsername("heh");
        user.setPassword("6954187456");

        //通过这个方法来修饰user
        SqlParameterSource parameterSource=new BeanPropertySqlParameterSource(user);
        npJdbcTemplate.update(sql,parameterSource);


    }


}
