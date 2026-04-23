package Lesson15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Ирина Мизгир
 * @date 20.04.2026 12:59
 */
//Задача 3:
//Создать класс Student, содержащий следующие характеристики – имя, группа, курс,
//оценки по предметам. Создать коллекцию, содержащую объекты класса Student.
//Написать метод, который удаляет студентов со средним баллом <3. Если средний
//балл>=3, студент переводится на следующий курс. Дополнительно написать метод
//printStudents(List<Student> students, int course), который получает список студентов и
//номер курса. А также печатает на консоль имена тех студентов из списка, которые
//обучаются на данном курсе.

public class Exercise3Application {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Collections.addAll(students,
                new Student("Иванов", "C-4512", 1, createStudentMarks(4, 3, 5)),
                new Student("Катетунов", "C-4512", 1, createStudentMarks(3, 2, 2)),
                new Student("Зубров", "C-4514", 2, createStudentMarks(5, 4, 5)));

        students.removeIf(student -> student.calculateAverageMarks() < 3);
        students.forEach(Student::movedNextCourse);
        Scanner courseReader = new Scanner(System.in);
        System.out.println("Введите номер курса (2-5): ");
        printStudents(students, courseReader.nextInt());
    }

    private static List<Student.Mark> createStudentMarks(int mathMark, int historyMark, int geographyMark) {
        List<Student.Mark> student1Marks = new ArrayList<>();
        student1Marks.add(new Student.Mark("Математика", mathMark));
        student1Marks.add(new Student.Mark("История", historyMark));
        student1Marks.add(new Student.Mark("География", geographyMark));

        return student1Marks;
    }

    private static void printStudents(List<Student> students, int course) {
        List<String> studentNames = new ArrayList<>();
        for (Student student : students) {
            if (student.getCourse() == course) {
                studentNames.add(student.getName());
            }
        }
        if (studentNames.isEmpty()) {
            System.out.printf("На курсе %d нет обучающиеся студентов", course);
        } else {
            System.out.printf("Студенты обучающиеся на курсе %d: %s", course, studentNames);
        }
    }

}
