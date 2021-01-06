package com.gildedrose;

public class ObjectCreator {
    public static final String AGED_BRIE_ITEM = "Aged Brie";
    public static final String NORMAL_ITEM_NAME = "foo";
    public static final int SELL_IN_NEGATIVE = -1;
    public static final int SELL_IN_ZERO = 0;
    public static final int SELL_IN_ONE = 1;
    public static final int QUALITY_ZERO = 0;
    public static final int QUALITY_ONE = 1;
    public static final int QUALITY_TWO = 2;
    public static final int QUALITY_FIFTY = 50;
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final int SELL_IN_TWELVE = 12;
    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final int SELL_IN_ELEVEN = 11;
    public static final int SELL_IN_FIVE = 5;

    GildedRose createGildedRose(Item... items) {
        return new GildedRose(items, new DecoratorFactory());
    }
}
