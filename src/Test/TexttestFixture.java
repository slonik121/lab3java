package Test;

import Main.Item;
import Main.GildedRose;
import java.util.List;
import Main.Quality;
import java.util.ArrayList;


public class TextTestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        Item[] items = createItems();
        GildedRose app = new GildedRose(items);

        int days = calculateDays(args);
        printSimulation(app, items, days);
    }

    private static Item[] createItems() {
        return new Item[] {
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 50),
                new Item("Sulfuras, Hand of Ragnaros", -1, 50),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Item("Conjured Mana Cake", 3, 6)
        };
    }

    private static int calculateDays(String[] args) {
        if (args.length == 0) {
            return 2;
        }
        return Integer.parseInt(args[0]) + 1;
    }

    private static void printSimulation(GildedRose app, Item[] items, int days) {
        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            printHeader();
            printItems(items);
            System.out.println();
            app.updateQuality();
        }
    }

    private static void printHeader() {
        System.out.println("name, sellIn, quality");
    }

    private static void printItems(Item[] items) {
        for (Item item : items) {
            System.out.println(item);
        }
    }
}
