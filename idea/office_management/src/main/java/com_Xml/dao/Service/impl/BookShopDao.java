package com_Xml.dao.Service.impl;

public interface BookShopDao {

    //根据书号获取的单价
    public int findBookPriceByIsbn(String isbn);

    //更新数的存库 好对应的库存减一
    public void updateBookStock(String isbn);

    //更新用户的账户余额：使username的balance-price
    public void updateUserAccount(String username, int price);
}
