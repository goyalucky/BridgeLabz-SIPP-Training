package EncapPolyAbstInter;

interface Department {
    void assignDepartment(String departmentName);
    String getDepartmentDetails();
}

abstract class Employee implements Department {
    private int employeeId;
    private String name;
    private double baseSalary;
    private String department;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Department: " + getDepartmentDetails());
        System.out.println("Final Salary: " + calculateSalary());
        System.out.println("------------------------------");
    }

    public void assignDepartment(String departmentName) {
        this.department = departmentName;
    }

    public String getDepartmentDetails() {
        return department;
    }
}

class FullTimeEmployee extends Employee {
    private double allowance;

    public FullTimeEmployee(int employeeId, String name, double baseSalary, double allowance) {
        super(employeeId, name, baseSalary);
        this.allowance = allowance;
    }

    public double calculateSalary() {
        return getBaseSalary() + allowance;
    }
}

class PartTimeEmployee extends Employee {
    private int workHours;
    private double hourlyRate;

    public PartTimeEmployee(int employeeId, String name, double hourlyRate, int workHours) {
        super(employeeId, name, 0);
        this.hourlyRate = hourlyRate;
        this.workHours = workHours;
    }

    public double calculateSalary() {
        return hourlyRate * workHours;
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];

        employees[0] = new FullTimeEmployee(101, "Alice", 30000, 5000);
        employees[0].assignDepartment("Finance");

        employees[1] = new PartTimeEmployee(102, "Bob", 500, 80);
        employees[1].assignDepartment("Support");

        employees[2] = new FullTimeEmployee(103, "Charlie", 35000, 6000);
        employees[2].assignDepartment("HR");

        for (Employee emp : employees) {
            emp.displayDetails();
        }
    }
}
