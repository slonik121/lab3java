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

    @Override
    public String toString() {
        return name.getValue() + ", " + sellIn.getValue() + ", " + quality.getValue();
    }

    public void decreaseSellIn() {
        this.sellIn.decrease();
    }

    public void increaseQuality(int value) {
        this.quality.increase(value);
    }

    public void decreaseQuality(int value) {
        this.quality.decrease(value);
    }

    public boolean isExpired() {
        return this.sellIn.getValue() < 0;
    }

    public boolean isSellInLessThan(int value) {
        return this.sellIn.getValue() < value;
    }

    public boolean isLegendary() {
        return this.name.getValue().equals("Legendary");
    }

    public boolean isSpecial() {
        return isAgedBrie() || isBackstagePass();
    }

    public boolean isAgedBrie() {
        return this.name.getValue().equals("Aged Brie");
    }

    public boolean isBackstagePass() {
        return this.name.getValue().equals("Backstage Pass");
    }

    public void resetQuality() {
        this.quality.reset();
    }
}
