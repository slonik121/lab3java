package Main;

import Main.Item;
import Main.Name;
import Main.Quality;
import Main.SellIn;
import java.util.List;
import java.util.function.Consumer;


public class Collection {
    private final List<Item> items;

    public Collection(List<Item> items) {
        this.items = items;
    }

    public void forEachItem(Consumer<Item> action) {
        for (Item item : items) {
            action.accept(item);
        }
    }
}
