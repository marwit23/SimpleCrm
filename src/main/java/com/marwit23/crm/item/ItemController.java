package com.marwit23.crm.item;

import com.marwit23.crm.company.Company;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> findAll() {
        return itemService.findAll();
    }

    @GetMapping("/{itemId}")
    public Item findById(@PathVariable Integer itemId) {
        return itemService.findById(itemId);
    }

    @PostMapping
    public Item save(@RequestBody Item theItem) {
        itemService.save(theItem);
        return theItem;
    }

    @PutMapping("/{itemId}")
    public Item updateItem(@RequestBody Item theItem, @PathVariable Integer itemId) {
        theItem.setItemId(itemId);
        itemService.save(theItem);
        return theItem;
    }

    @DeleteMapping("/{itemId}")
    public String deleteById(@PathVariable Integer itemId) {
        itemService.deleteById(itemId);
        return "Deleted item - " + itemId;
    }
}
