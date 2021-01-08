package cn.idcast.service;

import cn.idcast.domain.PageBean;
import cn.idcast.domain.User;

import java.util.List;
import java.util.Map;

//用户管理的业务接口
public interface userService {
    //查询所有用户信息
    public List<User> findAll();
    //用户登入操作
    public User findUserByUsernameAndPassword(User user);
    //添加联系人操作
    public void add(User user);
    //添加删除练习人操作
    public void delete(String id);
    //通过ID来找出user
    public User findUserByid(String id);
    //用于更新User的方法
    public void  update(User user);
    //删除选中的user
    public void deleteSelect(String [] uids);
    //分页查询和分页条件查询
    public PageBean <User> findUserByPage(String currentPage, String rows, Map<String, String[]> parameterMap);
}
