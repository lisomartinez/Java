package com.gildedrose;

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
        for (Item item : items) {
            ItemDecorator decoratedItem = decoratorFactory.create(item);
            decoratedItem.update();
        }
    }
}