package ObjectModelling;

import java.util.ArrayList;
import java.util.List;

class Company {
    String name;
    List<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department dept) {
        departments.add(dept);
    }

    public void showStructure() {
        System.out.println("Company: " + name);
        for (Department d : departments) {
            d.showDepartment();
        }
        System.out.println();
    }
}

class Department {
    String deptName;
    List<Employee> employees;

    public Department(String deptName) {
        this.deptName = deptName;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee emp) {
        employees.add(emp);
    }

    public void showDepartment() {
        System.out.println(" Department: " + deptName);
        for (Employee e : employees) {
            System.out.println("  Employee: " + e.empName);
        }
    }
}

class Employee {
    String empName;

    public Employee(String empName) {
        this.empName = empName;
    }
}

public class Composition {
    public static void main(String[] args) {
        Company company = new Company("Tech Solutions");

        Department dev = new Department("Development");
        dev.addEmployee(new Employee("Prashant"));
        dev.addEmployee(new Employee("Lucky"));

        Department hr = new Department("HR");
        hr.addEmployee(new Employee("Aman"));

        company.addDepartment(dev);
        company.addDepartment(hr);

        company.showStructure();
    }
}
