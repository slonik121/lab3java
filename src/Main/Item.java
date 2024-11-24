package Main;

import Main.Item;
import Main.Name;
import Main.Quality;
import Main.SellIn;

public class Item {
    private Name name;
    private SellIn sellIn;
    private Quality quality;

    public Item(String name, int sellIn, int quality) {
        this.name = new Name(name);
        this.sellIn = new SellIn(sellIn);
        this.quality = new Quality(quality);
    }

    public Name getName() {
        return name;
    }

    public SellIn getSellIn() {
        return sellIn;
    }

    public Quality getQuality() {
        return quality;
    }

    public boolean isLegendary() {
        return name.getName().equals("Sulfuras, Hand of Ragnaros");
    }

    public boolean isSpecial() {
        return isAgedBrie() || isBackstagePass();
    }

    public boolean isAgedBrie() {
        return name.getName().equals("Aged Brie");
    }

    public boolean isBackstagePass() {
        return name.getName().equals("Backstage passes to a TAFKAL80ETC concert");
    }

    public boolean isExpired() {
        return sellIn.getValue() < 0;
    }

    public void decreaseSellIn() {
        sellIn.decrease();
    }

    public void increaseQuality(int amount) {
        quality.increase(amount);
    }

    public void decreaseQuality(int amount) {
        quality.decrease(amount);
    }

    public void resetQuality() {
        this.quality = new Quality(0);
    }

    @Override
    public String toString() {
        return name.getName() + ", " + sellIn.getValue() + ", " + quality.getValue();
    }
}
