package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BackstageItemGildedRoseTest {
    private ObjectCreator creator = new ObjectCreator();

    @Test
    void decreaseItsSellInWhenUpdated() {
        Item item = new Item(ObjectCreator.BACKSTAGE, ObjectCreator.SELL_IN_TWELVE, ObjectCreator.QUALITY_TWO);
        GildedRose app = creator.createGildedRose(item);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(ObjectCreator.SELL_IN_TWELVE - 1);
    }

    @Test
    void qualityIncreasesBy1whenThereAreElevenDayOrMore() {
        Item item = new Item(ObjectCreator.BACKSTAGE, ObjectCreator.SELL_IN_TWELVE, ObjectCreator.QUALITY_TWO);
        GildedRose app = creator.createGildedRose(item);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(ObjectCreator.QUALITY_TWO + 1);
    }

    @Test
    void qualityIncreasesBy2whenThereAre10daysOrless() {
        Item item = new Item(ObjectCreator.BACKSTAGE, ObjectCreator.SELL_IN_ELEVEN, ObjectCreator.QUALITY_TWO);
        GildedRose app = creator.createGildedRose(item);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(ObjectCreator.QUALITY_ONE + 2);
    }

    @Test
    void qualityIncreasesBy3WhenThereAre5daysOrLess() {
        Item item = new Item(ObjectCreator.BACKSTAGE, ObjectCreator.SELL_IN_FIVE, ObjectCreator.QUALITY_TWO);
        GildedRose app = creator.createGildedRose(item);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(ObjectCreator.QUALITY_TWO + 3);
    }

    @Test
    void qualityDropsTo0AfterTheConcert() {
        Item item = new Item(ObjectCreator.BACKSTAGE, ObjectCreator.SELL_IN_ZERO, ObjectCreator.QUALITY_TWO);
        GildedRose app = creator.createGildedRose(item);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(ObjectCreator.QUALITY_ZERO);
    }

}
