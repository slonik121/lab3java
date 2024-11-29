package Main;

import Main.Item;
import Main.Name;
import Main.Quality;
import Main.SellIn;

public class Item {
    private final String name;
    private int sellIn;
    private int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getSellInValue() {
        return sellIn;
    }

    public String getName() {
        return name;
    }

    public int getQuality() {
        return quality;
    }

    public void decreaseSellIn() {
        sellIn--;
    }

    public void decreaseQuality(int amount) {
        quality = Math.max(0, quality - amount);
    }

    public void increaseQuality(int amount) {
        quality = Math.min(50, quality + amount);
    }

    public boolean isAgedBrie() {
        return "Aged Brie".equals(name);
    }

    public boolean isBackstagePass() {
        return "Backstage passes to a TAFKAL80ETC concert".equals(name);
    }

    public boolean isLegendary() {
        return "Sulfuras, Hand of Ragnaros".equals(name);
    }

    public boolean isSpecial() {
        return isAgedBrie() || isBackstagePass();
    }

    public void resetQuality() {
        quality = 0;
    }

    public boolean isExpired() {
        return sellIn < 0;
    }

    @Override
    public String toString() {
        return name + ", " + sellIn + ", " + quality;
    }
}
