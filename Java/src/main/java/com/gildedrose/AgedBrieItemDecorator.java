package com.gildedrose;

public class AgedBrieItemDecorator extends ItemDecorator {

    public AgedBrieItemDecorator(Item item) {
        super(item);
    }


    @Override
    public void update() {
        if (canIncreaseQuality(item)) {
            increaseQuality(item);
        }
        decreaseSellIn(item);
        if (item.sellIn < 0 && canIncreaseQuality(item)) {
            increaseQuality(item);

        }
    }

}
