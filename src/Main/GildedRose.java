package Main;

import Main.Item;
import Main.Name;
import Main.Quality;
import Main.SellIn;

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
            updateSpecialItem(item);
            return;
        }

        updateRegularItem(item);
    }

    private boolean isLegendary(Item item) {
        return item.isLegendary();
    }

    private boolean isSpecial(Item item) {
        return item.isSpecial();
    }

    private void updateSellIn(Item item) {
        item.decreaseSellIn();
    }

    private void updateSpecialItem(Item item) {
        if (item.isAgedBrie()) {
            item.increaseQuality(1);
            return;
        }

        if (item.isBackstagePass()) {
            updateBackstagePassQuality(item);
        }
    }

    private void updateBackstagePassQuality(Item item) {
        if (item.isExpired()) {
            item.resetQuality();
            return;
        }

        if (item.getSellIn().getValue() < 5) {
            item.increaseQuality(3);
            return;
        }

        if (item.getSellIn().getValue() < 10) {
            item.increaseQuality(2);
            return;
        }

        item.increaseQuality(1);
    }

    private void updateRegularItem(Item item) {
        int qualityDecreaseAmount = item.isExpired() ? 2 : 1;
        item.decreaseQuality(qualityDecreaseAmount);
    }
}
