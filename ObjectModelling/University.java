package ObjectModelling;

import java.util.*;

class Course {
    String name;
    Professor professor;

    Course(String name) {
        this.name = name;
    }

    void assignProfessor(Professor p) {
        this.professor = p;
        System.out.println(p.name + " assigned to " + name);
    }
}

class Student {
    String name;
    List<Course> courses = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    void enrollCourse(Course c) {
        courses.add(c);
        System.out.println(name + " enrolled in " + c.name);
    }
}

class Professor {
    String name;

    Professor(String name) {
        this.name = name;
    }
}

public class University {
    public static void main(String[] args) {
        Student s1 = new Student("Lucky");
        Professor p1 = new Professor("Dr. Mehta");

        Course c1 = new Course("AI");
        Course c2 = new Course("ML");

        c1.assignProfessor(p1);
        s1.enrollCourse(c1);
        s1.enrollCourse(c2);
    }
}
