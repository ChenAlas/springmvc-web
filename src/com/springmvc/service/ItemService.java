package com.springmvc.service;

import java.util.List;

import com.springmvc.pojo.Items;

public interface ItemService {
    List<Items> getItemList();
    Items getItemById(int id);
    void updateItem(Items items);
}
