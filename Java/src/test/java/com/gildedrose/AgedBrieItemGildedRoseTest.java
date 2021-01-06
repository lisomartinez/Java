package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AgedBrieItemGildedRoseTest {
    private ObjectCreator creator = new ObjectCreator();

    @Test
    void afterUpdateSellInDecrease() {
        Item item = new Item(ObjectCreator.AGED_BRIE_ITEM, ObjectCreator.SELL_IN_ONE, ObjectCreator.QUALITY_ONE);
        GildedRose app = creator.createGildedRose(item);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(ObjectCreator.SELL_IN_ONE - 1);
    }

    @Test
    void afterUpdateQualityIncrease() {
        Item item = new Item(ObjectCreator.AGED_BRIE_ITEM, ObjectCreator.SELL_IN_ONE, ObjectCreator.QUALITY_ONE);
        GildedRose app = creator.createGildedRose(item);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(ObjectCreator.QUALITY_ONE + 1);
    }

    @Test
    void qualityOfAgedBrieIsNeverGreaterThanFifty() {
        Item item = new Item(ObjectCreator.AGED_BRIE_ITEM, ObjectCreator.SELL_IN_ONE, ObjectCreator.QUALITY_FIFTY);
        GildedRose app = creator.createGildedRose(item);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(ObjectCreator.QUALITY_FIFTY);
    }

    @Test
    void onceTheSellByDateHasPassedQualityOfIncreaseTwiceAsFast() {
        Item item = new Item(ObjectCreator.AGED_BRIE_ITEM, ObjectCreator.SELL_IN_NEGATIVE, ObjectCreator.QUALITY_ONE);
        GildedRose app = creator.createGildedRose(item);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(ObjectCreator.QUALITY_ONE + 2);
    }

}
