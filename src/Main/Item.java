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

    public void setSellIn(SellIn sellIn) {
        this.sellIn = sellIn;
    }

    public Quality getQuality() {
        return quality;
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return name.getName() + ", " + sellIn.getValue() + ", " + quality.getValue();
    }
}
