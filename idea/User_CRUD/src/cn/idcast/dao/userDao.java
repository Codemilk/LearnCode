package cn.idcast.dao;

import cn.idcast.domain.User;

import java.util.List;
import java.util.Map;

public interface userDao {
    //查询所有用户信息
    public List<User> findALL();
    //用户登入操作
    public User findUserByUsernameAndPassword(String username, String password);
    //添加联系人操作
    public void addUser(User user);
    //添加删除练习人操作
    public void deleteUser(int id);
    //通过ID来找到user
    public User findUserByid(int id);
    //更新User的方法
    public void update(User user);
    //查看user总记录数
    public int findTotalCount(Map<String, String[]> parameterMap);
    //当前页面user的数据
    public List<User> findUserList(int start, int rows, Map<String, String[]> parameterMap);
}
