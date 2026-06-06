package Lesson15;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Ирина Мизгир
 * @date 20.04.2026 14:59
 */
public class AnimalNames {

    private final Deque<String> names = new LinkedList<>();

    public void add(String name) {
        names.addFirst(name);
    }

    public void delete() {
        names.removeLast();
    }

    public void print() {
        System.out.println(names);
    }
}
