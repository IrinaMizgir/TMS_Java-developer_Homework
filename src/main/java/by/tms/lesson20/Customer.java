package by.tms.lesson20;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ирина Мизгир
 * @date 10.05.2026 14:50
 */
public class Customer {

    private final List<String> items = new ArrayList<>();

    private final Store store;

    public Customer(Store store) {
        this.store = store;
    }

    public boolean canBuy (){
        return items.size() != 5;

    }

    public void buy() {
        if (items.size() == 5) {
            return;
        }
        items.add(store.buy());


    }
}
