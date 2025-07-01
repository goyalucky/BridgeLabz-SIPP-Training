package ObjectModelling;

import java.util.*;

class Course {
    String name;
    List<Student> enrolledStudents = new ArrayList<>();

    Course(String name) {
        this.name = name;
    }

    void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    void showEnrolledStudents() {
        System.out.println("Students enrolled in " + name + ":");
        for (Student s : enrolledStudents) {
            System.out.println("- " + s.name);
        }
    }
}

class Student {
    String name;
    List<Course> courses = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    void enroll(Course course) {
        courses.add(course);
        course.enrollStudent(this);
    }

    void viewCourses() {
        System.out.println(name + " enrolled in:");
        for (Course c : courses) {
            System.out.println("- " + c.name);
        }
    }
}

class School {
    String name;
    List<Student> students = new ArrayList<>();

    School(String name) {
        this.name = name;
    }

    void addStudent(Student student) {
        students.add(student);
    }
}

public class Schools {
    public static void main(String[] args) {
        School school = new School("Sunrise High");

        Student s1 = new Student("Prashant");
        Student s2 = new Student("Lucky");

        school.addStudent(s1);
        school.addStudent(s2);

        Course math = new Course("Mathematics");
        Course sci = new Course("Science");

        s1.enroll(math);
        s1.enroll(sci);
        s2.enroll(math);

        s1.viewCourses();
        math.showEnrolledStudents();
    }
}
