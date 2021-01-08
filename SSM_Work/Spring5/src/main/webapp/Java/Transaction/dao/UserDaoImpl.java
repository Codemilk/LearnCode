package Transaction.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addMoney() {
        String sql="update account set balance = balance+? where name=?";
        jdbcTemplate.update(sql, 100,"zhangsan");
    }

    @Override
    public void reduceMoney() {
        String sql="update account set balance = balance-? where name=?";
        jdbcTemplate.update(sql, 100,"lisi");
    }
}
