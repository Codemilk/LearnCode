package jdbc_template;

import Druid.JDBCUtils_Druids;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
//junit单元测试，可以让方法独立执行

public class jdbc_template {
    public static void main(String[] args) {
       //创建jdbctemplete独享
        JdbcTemplate jt=new JdbcTemplate(JDBCUtils_Druids.datasource());
        //调用方法
        //更新数据
        String s="update account set balance=2500 where id=?";
        System.out.println(jt);
       int count= jt.update(s,3);
        System.out.println(count);
    }
}
