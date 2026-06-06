package Lesson15;

import java.util.List;

/**
 * @author Ирина Мизгир
 * @date 20.04.2026 15:46
 */
public class Student {

    private final String name;

    private final String groupName;

    private int course;

    private final List<Mark> marks;

    public Student(String name, String groupName, int course, List<Mark> marks) {
        this.name = name;
        this.groupName = groupName;
        this.course = course;
        this.marks = marks;
    }

    public void movedNextCourse() {
        course++;
    }

    public double calculateAverageMarks() {
        int sum = 0;
        for (Mark mark : marks) {
            sum += mark.mark;
        }

        return (double) sum / marks.size();
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public static class Mark {

        private final String subject;

        private final int mark;

        public Mark(String subject, int mark) {
            this.subject = subject;
            this.mark = mark;
        }
    }

}
