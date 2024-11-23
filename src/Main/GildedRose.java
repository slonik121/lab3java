package Main;

import Main.Item;

public class GildedRose {
    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public Item[] getItems() {
        return items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private void updateItem(Item item) {
        if (isLegendary(item)) {
            return;
        }

        updateSellIn(item);
        if (isSpecial(item)) {
            updateSpecialItemQuality(item);
        } else {
            updateRegularItemQuality(item);
        }
    }

    private boolean isLegendary(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isSpecial(Item item) {
        return item.name.equals("Aged Brie") || item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private void updateSellIn(Item item) {
        item.sellIn--;
    }

    private void updateSpecialItemQuality(Item item) {
        if (item.name.equals("Aged Brie")) {
            increaseQuality(item, 1);
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.sellIn < 0) {
                item.quality = 0; // Concert is over
            } else if (item.sellIn < 5) {
                increaseQuality(item, 3);
            } else if (item.sellIn < 10) {
                increaseQuality(item, 2);
            } else {
                increaseQuality(item, 1);
            }
        }
    }

    private void updateRegularItemQuality(Item item) {
        decreaseQuality(item, item.sellIn < 0 ? 2 : 1);
    }

    private void increaseQuality(Item item, int amount) {
        item.quality = Math.min(item.quality + amount, 50);
    }

    private void decreaseQuality(Item item, int amount) {
        item.quality = Math.max(item.quality - amount, 0);
    }
}
