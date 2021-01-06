package com.gildedrose;

public class NormalItemDecorator extends ItemDecorator {

    public NormalItemDecorator(Item item) {
        super(item);
    }

    @Override
    void update() {
        decreaseQualityByOne(item);
        decreaseSellIn(item);
        onCannotBeSoldDo(item, super::decreaseQualityByOne);
    }
}
