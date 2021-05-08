package com.marwit23.crm.item;

import com.marwit23.crm.company.Company;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepo itemRepo;

    public ItemServiceImpl(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    @Override
    public List<Item> findAll() {
        return itemRepo.findAll();
    }

    @Override
    public Item findById(Integer itemId) {
        Optional<Item> result = itemRepo.findById(itemId);
        Item theItem;
        if(result.isPresent()) theItem = result.get();
        else throw new RuntimeException("Unable to find this item.");
        return theItem;
    }

    @Override
    public void save(Item theItem) {
        itemRepo.save(theItem);
    }

    @Override
    public void deleteById(Integer itemId) {
        itemRepo.deleteById(itemId);
    }
}
