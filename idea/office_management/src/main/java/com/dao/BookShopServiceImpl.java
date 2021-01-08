package com.dao;

import com.Exception.UserAccount_Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

    @Autowired
   private BookShopDao bookShopDao;
    //添加事务注解
    //1.指定propagation指定事务的传播行为，即当前的事务方法被另外一个事务方法调用时
    //如何使用事务，默认值REQUIRED,
    //2.使用isolation指定事物的隔离级别，最常用的取值为READ_COMMITTED
    //3.默认情况下，Spring的声明事务对所有运行时异常进行回滚，也可以通过对应的
    //属性进行设置,noRollbackFor和rollbackFor来指定是否回滚通常这两个是不设置，使用默认值
    //4.使用readOnly,指定事务是否只读，只是读取数据库服务
    //5.使用timeout指定强制回滚之前事务可以占用的
    @Transactional(propagation = Propagation.REQUIRES_NEW
//             readOnly = false,
//             timeout = 1
//            isolation = Isolation.READ_COMMITTED,
//             noRollbackFor ={UserAccount_Exception.class}
//             ,rollbackFor = {UserAccount_Exception.class}
    )
    @Override
    public void purcharse(String username, String isbn) {
        //获取单价
        int bookPriceByIsbn = bookShopDao.findBookPriceByIsbn(isbn);

        //更新数的库存
        bookShopDao.updateBookStock(isbn);

        //更新用户的余额
        bookShopDao.updateUserAccount(username,bookPriceByIsbn);

    }
}
