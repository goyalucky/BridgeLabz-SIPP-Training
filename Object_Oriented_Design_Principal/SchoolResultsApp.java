package Object_Oriented_Design_Principal;
import java.util.*;
class Subject {
    private String name;
    private double marks;

    public Subject(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public double getMarks() {
        return marks;
    }

    public String getName() {
        return name;
    }
}

class Student {
    private String name;
    private int rollNo;
    private List<Subject> subjects;

    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
        this.subjects = new ArrayList<>();
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }
}

class GradeCalculator {
    public double calculateTotal(Student student) {
        double total = 0;
        for (Subject subject : student.getSubjects()) {
            total += subject.getMarks();
        }
        return total;
    }

    public double calculateAverage(Student student) {
        double total = calculateTotal(student);
        return total / student.getSubjects().size();
    }

    public String calculateGrade(Student student) {
        double average = calculateAverage(student);
        if (average >= 90) return "A+";
        else if (average >= 80) return "A";
        else if (average >= 70) return "B";
        else if (average >= 60) return "C";
        else return "F";
    }
}
public class SchoolResultsApp {
    public static void main(String[] args) {
        Student student = new Student("Prashant Goyal", 101);
        student.addSubject(new Subject("Maths", 95));
        student.addSubject(new Subject("Science", 89));
        student.addSubject(new Subject("English", 84));

        GradeCalculator calculator = new GradeCalculator();
        double total = calculator.calculateTotal(student);
        double average = calculator.calculateAverage(student);
        String grade = calculator.calculateGrade(student);

        System.out.println("Student: " + student.getName() + " (Roll No: " + student.getRollNo() + ")");
        System.out.println("Total Marks: " + total);
        System.out.println("Average Marks: " + average);
        System.out.println("Final Grade: " + grade);
    }
}
