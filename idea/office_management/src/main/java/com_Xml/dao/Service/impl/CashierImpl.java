package com_Xml.dao.Service.impl;

import com_Xml.dao.Service.BookShopService;
import com_Xml.dao.Service.Cashier;

import java.util.List;

public class CashierImpl implements Cashier {


    private BookShopService bookShopService;

    public BookShopService getBookShopService() {
        return bookShopService;
    }

    public void setBookShopService(BookShopService bookShopService) {
        this.bookShopService = bookShopService;
    }

    @Override
    public void checkout(String username, List<String> isbns) {

       for(String s:isbns){
           bookShopService.purcharse(username,s);
       }


    }
}
