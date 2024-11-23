package Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import Main.Item;
import Main.GildedRose;

class GildedRoseTest {

    @Test
    void testUpdateQuality() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
    }
}
