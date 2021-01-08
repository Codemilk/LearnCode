package userdao;

import Druidconnection.Druid;
import USER.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class userdaos {
    JdbcTemplate JT=new JdbcTemplate(Druid.getDataSource());

   public User login(User loginuser){
        try {
            String sql="select * from user where username=?and password=?";

            User user = JT.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), loginuser.getUsername(), loginuser.getPassword());
           return user;
         } catch (DataAccessException e) {
             return null;
        }

      }
}
