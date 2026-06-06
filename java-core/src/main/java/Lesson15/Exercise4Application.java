package Lesson15;

/**
 * @author Ирина Мизгир
 * @date 20.04.2026 13:00
 */

//Задача *:
//Представим, что в Java нет коллекции типа ArrayList. Создать свой класс, симулирующий
//работу класса динамической коллекции - т.е. создать свою кастомную коллекцию. В
//основе коллекции будет массив. Кастомная коллекция должна хранить элементы разных
//классов(т.е. это generic).
//Предусмотреть операции(методы):
//1. добавления элемента
//2. удаления элемента
//3. получение элемента по индексу
//4. проверка есть ли элемент в коллекции
//5. очистка всей коллекции
//Предусмотреть конструктор без параметров - создает массив размером
//по умолчанию. Предусмотреть конструктор с задаваемым размером внутреннего
//массива. Предусмотреть возможность автоматического расширения коллекции при
//добавлении элемента в том случае, когда коллекция уже заполнена.

public class Exercise4Application {

    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        boolean removed = list.remove(2);
        System.out.println(removed); //нашли и удалили и вывели true.
        System.out.println(list); //просмотр как выглядит коллекция.
        Integer value = list.get(2);
        System.out.println(value);
        boolean contains = list.contains(4);
        System.out.println(contains);
        boolean clearResult = list.clear();
        System.out.println(clearResult);
        System.out.println(list);

    }
}
