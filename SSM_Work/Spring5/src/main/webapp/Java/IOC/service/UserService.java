package IOC.service;

import IOC.dao.UserDao;
import IOC.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

//    @Autowired
    //可以通过@Qualifier指定对应的id 例如@Qualifier("a")  @Service("a")
//    @Qualifier("dd")
    @Resource(name = "dd")
    private  UserDao userDao;
    @Value("dd")
    private  String name;
    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public void add(){
        System.out.println("我是UserService");
        userDao.update();
    }
}
