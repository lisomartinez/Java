package com.gildedrose;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class DecoratorFactory {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES =
            "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    Map<String, Function<Item, ItemDecorator>> decoratorFactory = new HashMap<>(5);
    Function<Item, ItemDecorator> defaultDecorator;

    public DecoratorFactory() {
        defaultDecorator = NormalItemDecorator::new;
        decoratorFactory.put(AGED_BRIE, AgedBrieItemDecorator::new);
        decoratorFactory.put(BACKSTAGE_PASSES, BackstagePassesItemDecorator::new);
        decoratorFactory.put(SULFURAS, SulfurasItemDecorator::new);
    }

    public ItemDecorator create(Item item) {
        Function<Item, ItemDecorator> factory = decoratorFactory.getOrDefault(item.name, defaultDecorator);
        return factory.apply(item);
    }


}
