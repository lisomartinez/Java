package com.gildedrose;

public abstract class ItemDecorator {
    protected final Item item;

    protected ItemDecorator(Item item) {
        this.item = item;
    }

    abstract void update();

    protected boolean canIncreaseQuality(Item item) {
        return item.quality < 50;
    }

    protected void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    protected void increaseQuality(Item item) {
        item.quality = item.quality + 1;
    }

    protected void decreaseItemQualityBy(Item item, int number) {
        item.quality -= number;
    }
}
