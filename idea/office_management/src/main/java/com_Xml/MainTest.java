package com_Xml;

import com_Xml.dao.Service.impl.BookShopDao;
import com_Xml.dao.Service.BookShopService;
import com_Xml.dao.Service.Cashier;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class MainTest {
   private ApplicationContext container;
   private BookShopDao bookShopDao;
   private BookShopService bookShopService;
   private Cashier cashier;
    {

        container=new ClassPathXmlApplicationContext("aaplicationXml.xml");
         bookShopDao = (BookShopDao)container.getBean(BookShopDao.class);
         bookShopService  =(BookShopService)container.getBean(BookShopService.class);
        cashier=(Cashier)container.getBean(Cashier.class);
    }

    @Test
    public void findBookPriceByIsbnTest(){


        System.out.println( bookShopDao.findBookPriceByIsbn("1001"));

    }

    @Test
    public void updateBookStockTest(){


             bookShopDao.updateBookStock("1001");
    }

    @Test
    public void updateUserAccountTest(){

          bookShopDao.updateUserAccount("AA", 20);
    }

    @Test
    public void BookShopServiceTest(){

        bookShopService.purcharse("AA", "1001");

    }

    @Test
    public  void TestTransactionPro(){
     cashier.checkout("AA", Arrays.asList("1001","1002"));

    }
}
