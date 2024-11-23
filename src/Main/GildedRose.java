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
            updateSpecialItemQuality(item);
            return;
        }

        updateRegularItemQuality(item);
    }

    private boolean isLegendary(Item item) {
        return item.getName().getName().equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isSpecial(Item item) {
        String name = item.getName().getName();
        return name.equals("Aged Brie") || name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private void updateSellIn(Item item) {
        item.getSellIn().decrease();
    }

    private void updateSpecialItemQuality(Item item) {
        String name = item.getName().getName();

        if (name.equals("Aged Brie")) {
            item.getQuality().increase(1);
            return;
        }

        if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.getSellIn().getValue() < 0) {
                item.setQuality(new Quality(0));
                return;
            }

            if (item.getSellIn().getValue() < 5) {
                item.getQuality().increase(3);
                return;
            }

            if (item.getSellIn().getValue() < 10) {
                item.getQuality().increase(2);
                return;
            }

            item.getQuality().increase(1);
        }
    }

    private void updateRegularItemQuality(Item item) {
        int qualityDecreaseAmount = item.getSellIn().getValue() < 0 ? 2 : 1;
        item.getQuality().decrease(qualityDecreaseAmount);
    }
}
