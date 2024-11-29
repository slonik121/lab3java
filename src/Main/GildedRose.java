package Main;

import Main.Item;
import Main.Name;
import Main.Quality;
import Main.SellIn;
import java.util.List;

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
            processItemUpdate(item);
        }
    }

    private void processItemUpdate(Item item) {
        if (item.isLegendary()) {
            return;
        }

        decreaseItemSellIn(item);

        if (item.isSpecial()) {
            updateSpecialItemQuality(item);
            return;
        }

        updateRegularItemQuality(item);
    }

    private void decreaseItemSellIn(Item item) {
        item.decreaseSellIn();
    }

    private void updateSpecialItemQuality(Item item) {
        if (item.isAgedBrie()) {
            item.increaseQuality(1);
            return;
        }

        if (item.isBackstagePass()) {
            handleBackstagePassQuality(item);
        }
    }

    private void handleBackstagePassQuality(Item item) {
        if (item.isExpired()) {
            item.resetQuality();
            return;
        }

        if (item.getSellInValue() < 5) {
            item.increaseQuality(3);
            return;
        }

        if (item.getSellInValue() < 10) {
            item.increaseQuality(2);
            return;
        }

        item.increaseQuality(1);
    }

    private void updateRegularItemQuality(Item item) {
        int decreaseAmount = item.isExpired() ? 2 : 1;
        item.decreaseQuality(decreaseAmount);
    }
}
