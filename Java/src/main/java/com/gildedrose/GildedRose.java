package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES =
            "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String NORMAL = "NORMAL";

    Item[] items;
    private final DecoratorFactory decoratorFactory;

    public GildedRose(Item[] items, DecoratorFactory decoratorFactory) {
        this.items = items;
        this.decoratorFactory = decoratorFactory;
    }

    public void updateQuality() {
        Arrays.stream(items)
              .map(decoratorFactory::create)
              .forEach(ItemDecorator::update);
    }
}