package com.thoughtworks.joi.gildedrose.api;

import com.thoughtworks.joi.gildedrose.domain.GildedRose;
import com.thoughtworks.joi.gildedrose.domain.Item;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    @Test
    @Ignore
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

}