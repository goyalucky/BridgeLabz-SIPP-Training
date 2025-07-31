import java.io.*;
import java.util.*;

class Employee implements Serializable {
    int id;
    String name;
    String department;
    double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Dept: " + department + ", Salary: " + salary;
    }
}

public class Serialization {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Alice", "IT", 55000));
        employees.add(new Employee(102, "Bob", "HR", 48000));
        employees.add(new Employee(103, "Charlie", "Finance", 62000));

        String filename = "employees.ser";

        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(employees);
            oos.close();
            fos.close();
            System.out.println("Employees have been serialized to " + filename);
        } catch (IOException e) {
            System.out.println("Serialization error: " + e.getMessage());
        }

        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<Employee> retrievedEmployees = (List<Employee>) ois.readObject();
            ois.close();
            fis.close();

            System.out.println("\nDeserialized Employee List:");
            for (Employee emp : retrievedEmployees) {
                System.out.println(emp);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization error: " + e.getMessage());
        }
    }
}
