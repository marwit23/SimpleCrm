package com.marwit23.crm.item;

import java.util.List;

public interface ItemService {
    List<Item> findAll();
    Item findById(Integer itemId);
    void save(Item theItem);
    void deleteById(Integer itemId);

}
