package by.tms.lesson20;

/**
 * @author Ирина Мизгир
 * @date 10.05.2026 14:46
 */

//Задача *:
//Имеются сущности Магазин, Производитель, Покупатель. Цель задачи сделать так, чтобы
//производитель произвел 5 единиц продукта, а покупатель их купил. Пока производитель
//не произвел продукт, покупатель не может его купить. При этом одновременно в магазине
//может находиться не более 3 товаров.

public class Exercise3Application {

    public static void main(String[] args) throws InterruptedException {
        var store = new Store();
        var producerThread = new Thread(() -> {
            var producer = new Producer(store);
            while (producer.canProduce()){
                producer.produce();
            }
        },"Производитель");
        var customerThread = new Thread(() -> {
            var customer = new Customer(store);
            while (customer.canBuy()){
                customer.buy();
            }
        },"Покупатель");
        producerThread.start();
        customerThread.start();
        producerThread.join();
        customerThread.join();

    }
}
