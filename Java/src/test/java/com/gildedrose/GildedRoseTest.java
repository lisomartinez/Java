package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseTest {

    @Test
    void whenCreatedKnowsItsItems() {
        Item[] items = new Item[]{new Item("foo", 1, 1)};
        GildedRose app = new GildedRose(items);
        assertThat(app.items).containsExactly(items);
    }

    @Test
    void whenCreatedItemsPropertiesHaveNoChanged() {
        Item[] items = new Item[]{new Item("foo", 1, 1)};
        GildedRose app = new GildedRose(items);
        assertThat(app.items[0].quality).isEqualTo(1);
        assertThat(app.items[0].sellIn).isEqualTo(1);
    }

    @Test
    void changeNormalItemPropertiesAfterUpdate() {
        Item[] items = new Item[]{new Item("foo", 1, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isZero();
        assertThat(app.items[0].sellIn).isZero();
    }


}
