package com.gildedrose;

public class BackstagePassesItemDecorator extends ItemDecorator {

    public static final int ELEVEN_DAYS = 11;
    public static final int SIX_DAYS = 6;

    protected BackstagePassesItemDecorator(Item item) {
        super(item);
    }

    @Override
    void update() {
        increaseQuality(item);
        increaseQualityBasedOnDaysBeforeExpiration(item);
        decreaseSellIn(item);
        onCannotBeSoldDo(item, this::decreaseItemQualityToZero);
    }

    private void decreaseItemQualityToZero(Item item) {
        item.quality = 0;
    }

    private void increaseQualityBasedOnDaysBeforeExpiration(Item item) {
        if (isTenOrLessDaysToExpiration(item)) {
            increaseQuality(item);
        }
        if (isFiveOrLessDaysToExpiration(item)) {
            increaseQuality(item);
        }
    }

    private boolean isTenOrLessDaysToExpiration(Item item) {
        return item.sellIn < ELEVEN_DAYS;
    }

    private boolean isFiveOrLessDaysToExpiration(Item item) {
        return item.sellIn < SIX_DAYS;
    }
}
