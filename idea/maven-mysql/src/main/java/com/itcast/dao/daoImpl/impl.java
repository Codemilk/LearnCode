package com.itcast.dao.daoImpl;

import com.itcast.dao.ItemDao;
import com.itcast.domain.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class impl implements ItemDao {
    @Override
    public List<Item> finAll() throws Exception {
        String sql="select * from test1";

       Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/maven_test?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&characterSetResults=utf8&useSSL=false&verifyServerCertificate=false&autoReconnct=true&autoReconnectForPools=true&allowMultiQueries=true","root","123456");
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Item> list=new ArrayList<>();
        while (resultSet.next()){
            Item it=new Item();
            it.setId(resultSet.getInt("id"));
            it.setName(resultSet.getString("name"));
            list.add(it);
        }


        return list;
    }
}
