package by.tms.lesson20;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Ирина Мизгир
 * @date 10.05.2026 14:47
 */

public class Store {

    private final Queue<String> storage = new ArrayBlockingQueue<>(3);

    public void add(String item) {
        synchronized (storage) {
            while (!storage.offer(item)) {
                System.out.println(Thread.currentThread().getName() + ": Ожидаем добавление продукта: " + item);
                try {
                    storage.wait();
                } catch (InterruptedException exception) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(exception);
                }
            }
            System.out.println(Thread.currentThread().getName() + ": Продукт добавлен: " + item);
            storage.notify();
        }
    }

    public String buy() {
        synchronized (storage) {
            while (storage.isEmpty()) {
                System.out.println(Thread.currentThread().getName() + ": Ожидаем поступление продукта");
                try {
                    storage.wait();
                } catch (InterruptedException exception) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(exception);
                }


            }
            String item = storage.remove();
            System.out.println(Thread.currentThread().getName() + ": Купили продукт: " + item);
            storage.notify();
            return item;
        }
    }

}
