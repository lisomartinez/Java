package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseWithNormalItemsTest {

    private ObjectCreator objectCreator = new ObjectCreator();

    @Test
    void afterUpdateNormalItemsDecreaseItsSellInByOne() {
        Item normalItem = new Item(ObjectCreator.NORMAL_ITEM_NAME, 1, 1);
        GildedRose app = new GildedRose(new Item[]{normalItem});
        app.updateQuality();
        assertThat(app.items[0].sellIn).isZero();
    }

    @Test
    void afterUpdateNormalItemsDecreaseItsQualityByOne() {
        Item normalItemWithPositiveValues = new Item(ObjectCreator.NORMAL_ITEM_NAME, 1, 1);
        objectCreator = new ObjectCreator();
        GildedRose app = objectCreator.createGildedRose(normalItemWithPositiveValues);
        app.updateQuality();
        assertThat(app.items[0].quality).isZero();
    }

    @Test
    void onceTheSellByDateHasPassedQualityOfNormalItemsDegradesTwiceAsFast() {
        Item normalItemSellInPassed =
                new Item(ObjectCreator.NORMAL_ITEM_NAME, ObjectCreator.SELL_IN_ZERO, ObjectCreator.QUALITY_TWO);
        GildedRose app = objectCreator.createGildedRose(normalItemSellInPassed);
        app.updateQuality();
        assertThat(app.items[0].quality).isZero();
        assertThat(app.items[0].sellIn).isEqualTo(-1);
    }

    @Test
    void qualityOfNormalItemsWithinSellInIsNeverNegativeWhenUpdates() {
        Item normalItemWIthZeroQuality =
                new Item(ObjectCreator.NORMAL_ITEM_NAME, ObjectCreator.SELL_IN_ONE, ObjectCreator.QUALITY_ZERO);
        GildedRose app = objectCreator.createGildedRose(normalItemWIthZeroQuality);
        app.updateQuality();
        assertThat(app.items[0].quality).isZero();
    }

    @Test
    void qualityOfNormalItemsWithSellInPassedIsNeverNegativeWhenUpdates() {
        Item normalItemWIthZeroQuality =
                new Item(ObjectCreator.NORMAL_ITEM_NAME, ObjectCreator.SELL_IN_NEGATIVE, ObjectCreator.QUALITY_ZERO);
        GildedRose app = objectCreator.createGildedRose(normalItemWIthZeroQuality);
        app.updateQuality();
        assertThat(app.items[0].quality).isZero();
    }

    @Test
    void qualityOfNormalItemsWithSellInAboutToPassIsNeverNegativeWhenUpdates() {
        Item normalItemWIthZeroQuality =
                new Item(ObjectCreator.NORMAL_ITEM_NAME, ObjectCreator.SELL_IN_ZERO, ObjectCreator.QUALITY_ZERO);
        GildedRose app = objectCreator.createGildedRose(normalItemWIthZeroQuality);
        app.updateQuality();
        assertThat(app.items[0].quality).isZero();
    }
}
