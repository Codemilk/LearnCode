package Transaction.service;

import Transaction.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.SERIALIZABLE)
public class UserService {

    @Autowired
    private UserDaoImpl userDao;

//    转账方法
    public void TransferMoney(){
        userDao.addMoney();
//        int i=1/0;
        userDao.reduceMoney();
    }
}
