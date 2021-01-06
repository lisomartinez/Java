package com.gildedrose;

public class ObjectCreator {
    public static final String NORMAL_ITEM_NAME = "foo";
    public static final int SELL_IN_ZERO = 0;
    public static final int QUALITY_ZERO = 0;
    public static final int SELL_IN_NEGATIVE = -1;
    public static final int SELL_IN_ONE = 1;
    public static final int QUALITY_TWO = 2;

    GildedRose createGildedRose(Item... items) {
        return new GildedRose(items);
    }
}
