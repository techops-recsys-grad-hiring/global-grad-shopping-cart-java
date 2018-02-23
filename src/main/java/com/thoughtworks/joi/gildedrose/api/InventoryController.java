package com.thoughtworks.joi.gildedrose.api;

import com.thoughtworks.joi.gildedrose.domain.GildedRose;
import com.thoughtworks.joi.gildedrose.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private GildedRose gildedRose;

    @RequestMapping(value = "/get")
    public Item[] getInventory() {
        return gildedRose.items;
    }

    @RequestMapping(value = "/update")
    public Item[] updateInventory() {
        gildedRose.updateQuality();
        return gildedRose.items;
    }
}
