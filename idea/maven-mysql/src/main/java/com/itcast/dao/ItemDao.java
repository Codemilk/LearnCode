package com.itcast.dao;

import com.itcast.domain.Item;

import java.util.List;

public interface ItemDao {
    public List<Item> finAll() throws Exception;
}
