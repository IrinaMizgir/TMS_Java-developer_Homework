package Lesson15;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * @author Ирина Мизгир
 * @date 20.04.2026 18:35
 */
public class MyList<E> {

    private int currentSize;

    private E[] array;

    public MyList(int size) {
        array = (E[]) new Object[size];
    }

    public MyList() {
        this(16);
    }

    //1. добавления элемента
    public void add(E value) {
        if (currentSize == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[currentSize] = value;
        currentSize++;
    }

    //2. удаления элемента
    public boolean remove(E removeValue) {
        for (int i = 0; i < currentSize; i++) {
            if (array[i].equals(removeValue)) {
                array[i] = null;
                currentSize--;
                //array = Arrays.copyOf(array, array.length);
                int n =i+1;
                System.arraycopy(array, n, array, i, array.length-i-1);
                array[array.length-1] = null;
                return true;
            }
        }
        return false;
    }

    //3. получение элемента по индексу
    public E get(int index) {
        if (index >= currentSize) {
            throw new NoSuchElementException(
                    "Index out of bounds: " + index
            );
        }
        return array[index];
    }

    //4. проверка есть ли элемент в коллекции
    public boolean contains(E searchValue) {
        for (int i = 0; i < currentSize; i++) {
            if (Objects.equals(array[i], searchValue)) {
                return true;
            }
        }
        return false;
    }

    //5. очистка всей коллекции
    public boolean clear() {
        if (currentSize == 0) {
            return false;
        }
        currentSize = 0;
        Arrays.fill(array, null);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < currentSize; i++) {
            sb.append(array[i]);
            if (i != currentSize - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');

        return sb.toString();
    }
}
