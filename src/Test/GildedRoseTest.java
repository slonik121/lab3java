package Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import Main.Item;
import Main.GildedRose;
import java.util.Arrays;
import java.util.List;

class GildedRoseTest {

    @Test
    void testUpdateQuality() {
        Item item = new Item("foo", 0, 0);
        List<Item> items = Arrays.asList(item);
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        int updatedQuality = item.getQuality();

        assertEquals(0, updatedQuality);
    }
}


