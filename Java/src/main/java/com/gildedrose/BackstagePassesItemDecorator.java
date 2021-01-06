package com.gildedrose;

public class BackstagePassesItemDecorator extends ItemDecorator {
    protected BackstagePassesItemDecorator(Item item) {
        super(item);
    }

    @Override
    void update() {
        if (canIncreaseQuality(item)) {
            increaseQuality(item);
            if (item.sellIn < 11 && canIncreaseQuality(item)) {
                increaseQuality(item);
            }
            if (item.sellIn < 6 && canIncreaseQuality(item)) {
                increaseQuality(item);
            }
        }
        decreaseSellIn(item);
        if (item.sellIn < 0) {
            decreaseItemQualityBy(item, item.quality);
        }
    }
}
