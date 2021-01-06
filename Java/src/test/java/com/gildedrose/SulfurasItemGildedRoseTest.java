package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SulfurasItemGildedRoseTest {
    private ObjectCreator creator = new ObjectCreator();

    @Test
    void SulfurasNeverIsNeverSold() {
        Item item = new Item(ObjectCreator.SULFURAS, ObjectCreator.SELL_IN_ONE, ObjectCreator.QUALITY_ONE);
        GildedRose app = creator.createGildedRose(item);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(ObjectCreator.SELL_IN_ONE);
    }

    @Test
    void SulfurasNeverDecreaseItsQuality() {
        Item item = new Item(ObjectCreator.SULFURAS, ObjectCreator.SELL_IN_ONE, ObjectCreator.QUALITY_ONE);
        GildedRose app = creator.createGildedRose(item);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(ObjectCreator.QUALITY_ONE);
    }
}
