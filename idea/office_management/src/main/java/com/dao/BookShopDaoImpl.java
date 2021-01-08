package com.dao;

import com.Exception.BookStock_Exception;
import com.Exception.UserAccount_Exception;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao {

    @Autowired

    private JdbcTemplate jdbcTemplate;


    @Override
    public int findBookPriceByIsbn(String isbn) {
        String sql="select price from book where isbn=?";

        Integer price = jdbcTemplate.queryForObject(sql, Integer.class, isbn);
        return price;
    }

    @Override
    public void updateBookStock(String isbn) {

        //检查书的库存是否足够，若不够则排除异常
        String sql1="select stock from book_stock where isbn=?";

        Integer stock = jdbcTemplate.queryForObject(sql1, Integer.class, isbn);

        if(stock==0){
               throw new BookStock_Exception("库存没了");
        }
        String sql="update book_stock set stock=stock-1 where isbn=?";
        jdbcTemplate.update(sql, isbn);


    }

    @Override
    public void updateUserAccount(String username, int price) {
        //检查用户金额是否足够，若不够则排除异常
        String sql1="select balance from account where username=?";

        Integer balance = jdbcTemplate.queryForObject(sql1, Integer.class, username);

        if(balance-price<0){
            throw new UserAccount_Exception("您的金额不够");
        }
        String sql="update account set balance=balance-? where username=?";


        jdbcTemplate.update(sql,price,username);

    }

}
