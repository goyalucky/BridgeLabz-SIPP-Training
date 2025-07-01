package Inheritance;

class Employee {
    String name;
    int id;
    double salary;

    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
    }
}

class Manager extends Employee {
    int teamSize;

    Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
    }
}

class Developer extends Employee {
    String programmingLanguage;

    Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

class Intern extends Employee {
    String university;

    Intern(String name, int id, double salary, String university) {
        super(name, id, salary);
        this.university = university;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("University: " + university);
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        Employee manager = new Manager("Ananya", 101, 85000, 8);
        Employee developer = new Developer("Rohit", 102, 65000, "Java");
        Employee intern = new Intern("Sneha", 103, 15000, "GLA University");

        manager.displayDetails();
        System.out.println();

        developer.displayDetails();
        System.out.println();

        intern.displayDetails();
    }
}
