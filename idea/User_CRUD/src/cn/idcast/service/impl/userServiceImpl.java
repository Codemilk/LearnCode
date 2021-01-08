package cn.idcast.service.impl;

import cn.idcast.dao.userDao;
import cn.idcast.dao.userDaoImpl.userDaoImpl;
import cn.idcast.domain.PageBean;
import cn.idcast.domain.User;
import cn.idcast.service.userService;

import java.util.List;
import java.util.Map;

public class userServiceImpl implements userService{
    //调用dao层来完成查询操作
    userDao dao=new userDaoImpl();
    @Override
    public List<User> findAll() {
        //调用dao层
        return dao.findALL();
    }

    @Override
    public User findUserByUsernameAndPassword(User user) {

     return dao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());

    }

    @Override
    public void add(User user) {
         dao.addUser(user);
    }

    @Override
    public void delete(String id) {

        dao.deleteUser(Integer.parseInt(id));
    }

    @Override
    public User findUserByid(String id) {
//
     return dao.findUserByid(Integer.parseInt(id));
    }

    @Override
    public void update(User user) {
        dao.update(user);
    }

    @Override
    public void deleteSelect(String[] uids) {
        if(uids!=null && uids.length>0){
            //遍历数组
            for(String s:uids){
                dao.deleteUser(Integer.parseInt(s));
            }
        }

    }

    @Override
    public PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> parameterMap) {
         //创建空的pageBean对象
         PageBean<User> pageBean =new PageBean<User>();


         //设置参数
         pageBean.setCurrentPage(Integer.parseInt(currentPage));
         pageBean.setRows(Integer.parseInt(rows));


         //使用dao查询总记录数
         int  totalCount =dao.findTotalCount(parameterMap);

         pageBean.setTotalCount(totalCount);


         //使用dao查询List集合
         int start =(Integer.parseInt(currentPage)-1)*Integer.parseInt(rows);
         List<User> list= dao.findUserList(start,Integer.parseInt(rows),parameterMap);

         pageBean.setList(list);
         //使用dao总页数
         int totalPage= (totalCount%Integer.parseInt(rows)==0)?(totalCount/Integer.parseInt(rows)) : totalCount/Integer.parseInt(rows)+1;
         pageBean.setTotalPage(totalPage);


         return pageBean;
    }


}
