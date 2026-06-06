package lesson20;

import java.util.*;

/**
 * @author Ирина Мизгир
 * @date 10.05.2026 14:49
 */

public class Producer {

    private final Queue<String> items = new LinkedList<>(List.of("Продукт1", "Продукт2", "Продукт3", "Продукт4", "Продукт5"));

    private final Store store;

    public Producer(Store store) {
        this.store = store;
    }

    public boolean canProduce() {
        return !items.isEmpty();
    }

    public void produce() {
        if (items.isEmpty()) {
            return;
        }
        store.add(items.remove());
    }

}
