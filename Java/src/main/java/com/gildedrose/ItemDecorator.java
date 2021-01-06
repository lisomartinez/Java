package com.gildedrose;

import java.util.function.Consumer;

public abstract class ItemDecorator {
    public static final int MAX_QUALITY = 50;
    public static final int ONE_UNIT = 1;
    private static final int EXPIRATION = 0;
    protected final Item item;

    protected ItemDecorator(Item item) {
        this.item = item;
    }

    abstract void update();

    protected boolean canIncreaseQuality(Item item) {
        return item.quality < MAX_QUALITY;
    }

    protected void decreaseSellIn(Item item) {

        item.sellIn -= ONE_UNIT;
    }

    private boolean canDecreaseQuality(Item item) {
        return item.quality > 0;
    }

    protected void increaseQuality(Item item) {
        if (!canIncreaseQuality(item)) return;
        item.quality += ONE_UNIT;
    }


    protected void decreaseQualityByOne(Item item) {
        if (!canDecreaseQuality(item)) return;
        item.quality -= ONE_UNIT;
    }

    protected boolean cannotBeSold(Item item) {
        return item.sellIn < EXPIRATION;
    }

    protected void onCannotBeSoldDo(Item item, Consumer<? super Item> action) {
        if (cannotBeSold(item)) {
            action.accept(item);
        }
    }
}
