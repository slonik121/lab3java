package Main;

import Main.Item;
import Main.Name;
import Main.Quality;
import Main.SellIn;
import java.util.List;
import Main.Collection;


public class GildedRose {
    private final Collection items;

    public GildedRose(List<Item> itemList) {
        this.items = new Collection(itemList);
    }

    public void updateQuality() {
        items.forEachItem(this::processItemUpdate);
    }

    private void processItemUpdate(Item item) {
        if (item.isLegendary()) return;

        item.decreaseSellIn();

        if (item.isSpecial()) {
            updateSpecialItem(item);
        } else {
            updateRegularItem(item);
        }
    }

    private void updateSpecialItem(Item item) {
        if (item.isAgedBrie()) {
            item.increaseQuality(1);
            return;
        }

        if (item.isBackstagePass()) {
            updateBackstagePass(item);
        }
    }

    private void updateBackstagePass(Item item) {
        if (item.isExpired()) {
            item.resetQuality();
            return;
        }

        int qualityIncrease = calculateBackstageQualityIncrease(item);
        item.increaseQuality(qualityIncrease);
    }

    private int calculateBackstageQualityIncrease(Item item) {
        if (item.isSellInLessThan(5)) return 3;
        if (item.isSellInLessThan(10)) return 2;
        return 1;
    }

    private void updateRegularItem(Item item) {
        int qualityDecrease = item.isExpired() ? 2 : 1;
        item.decreaseQuality(qualityDecrease);
    }
}
