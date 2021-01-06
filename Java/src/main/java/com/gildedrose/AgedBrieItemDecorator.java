package com.gildedrose;

public class AgedBrieItemDecorator extends ItemDecorator {

    public AgedBrieItemDecorator(Item item) {
        super(item);
    }


    @Override
    public void update() {
        increaseQuality(item);
        decreaseSellIn(item);
        onCannotBeSoldDo(item, super::increaseQuality);
    }

}
