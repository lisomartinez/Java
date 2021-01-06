package com.gildedrose;

public class NormalItemDecorator extends ItemDecorator {

    public NormalItemDecorator(Item item) {
        super(item);
    }

    @Override
    void update() {
        if (item.quality > 0) {
            decreaseItemQualityBy(item, 1);
        }
        decreaseSellIn(item);
        if (item.sellIn < 0) {
            if (item.quality > 0) {
                decreaseItemQualityBy(item, 1);
            }
        }
    }
}
