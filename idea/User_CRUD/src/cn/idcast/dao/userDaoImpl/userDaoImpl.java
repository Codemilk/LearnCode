package cn.idcast.dao.userDaoImpl;

import cn.idcast.dao.userDao;
import cn.idcast.domain.User;
import cn.idcast.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class userDaoImpl implements userDao {
    JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtils.getDataSource());
     @Override
    public List<User> findALL() {
        //使用jdbc操作数据
         String sql="select * from user";
         List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));

         return users;
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try {
            String sql="select * from user where username=? and password=?";
            User user= jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),username,password);
            return user;
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addUser(User user) {
        String sql="insert into user values(null,?,?,?,?,?,?,null,null)";
        jdbcTemplate.update(sql, user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail());
    }

    @Override
    public void deleteUser(int id) {
        String sql="delete from user where id = ?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public User findUserByid(int id) {
         String sql="select * from user where id= ?";
       return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),id);
    }

    @Override
    public void update(User user) {
        String sql = "update user set name = ?,gender = ? ,age = ? , address = ? , qq = ?, email = ? where id = ?";
        jdbcTemplate.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());

    }

    @Override
    public int findTotalCount(Map<String, String[]> parameterMap) {
        //为了方便条件查询的sql语句的拼接，需要定义模板sql
        String sql="select count(*) from user where 1=1 ";
        StringBuilder sb=new StringBuilder(sql);
        //遍历map
        Set<String> keySet = parameterMap.keySet();
        //定义一个参数集合，为后续判断

        List<Object> list=new ArrayList<Object>();

        for (String key : keySet) {
            if("currentPage".equals(key)||"rows".equals(key)){
                continue;
            }
            //判断values是否有值

            String values = parameterMap.get(key) [0];
            if(values != null && !"".equals(values)){
                //有值
                sb.append(" and "+key+" like ? ");
                list.add("%"+values+"%");//？条件的值
            }
        }
        System.out.println(sb.toString());
        System.out.println(list);

        Integer integer = jdbcTemplate.queryForObject(sb.toString(), Integer.class,list.toArray());
        System.out.println(integer);
        return integer;
    }

    @Override
    public List<User> findUserList(int start, int rows, Map<String, String[]> parameterMap) {
        String sql="select * from user where 1=1";
        StringBuilder sb=new StringBuilder(sql);
        //遍历map
        Set<String> keySet = parameterMap.keySet();
        //定义一个参数集合，为后续判断

        List<Object> list=new ArrayList<Object>();

        for (String key : keySet) {
            if("currentPage".equals(key)||"rows".equals(key)){
                continue;
            }
            //判断values是否有值

            String values = parameterMap.get(key) [0];
            if(values != null && !"".equals(values)){
                //有值
                sb.append(" and "+key+" like ? ");
                list.add("%"+values+"%");//？条件的值
            }
        }
         //添加分页查询
          sb.append(" limit ?,?");
         //添加分页查询参数
           list.add(start);
           list.add(rows);

         List<User> query = jdbcTemplate.query(sb.toString(), new BeanPropertyRowMapper<User>(User.class),list.toArray());
        return query;
    }


}


