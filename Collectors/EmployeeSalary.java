import java.util.*;
import java.util.stream.*;

class Employee {
    private String name;
    private String department;
    private double salary;
    Employee(String name, String department, double salary) {
        this.name = name; this.department = department; this.salary = salary;
    }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
}

public class EmployeeSalary {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("E1", "IT", 50000),
            new Employee("E2", "HR", 40000),
            new Employee("E3", "IT", 60000),
            new Employee("E4", "HR", 45000)
        );
        Map<String, Double> avgSalaryByDept = employees.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment,
                     Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(avgSalaryByDept);
    }
}
