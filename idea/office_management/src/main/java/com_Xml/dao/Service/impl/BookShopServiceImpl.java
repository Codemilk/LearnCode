package com_Xml.dao.Service.impl;

import com_Xml.dao.Service.BookShopService;

public class BookShopServiceImpl implements BookShopService {

    private BookShopDao bookShopDao;

    public BookShopDao getBookShopDao() {
        return bookShopDao;
    }

    public void setBookShopDao(BookShopDao bookShopDao) {
        this.bookShopDao = bookShopDao;
    }

    public BookShopServiceImpl() {
    }

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
