package MapInterface;

import java.util.*;

public class GroupByDepartment {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", "HR"),
            new Employee("Bob", "Engineering"),
            new Employee("Charlie", "HR"),
            new Employee("David", "Engineering"),
            new Employee("Eve", "Marketing")
        );

        Map<String, List<Employee>> grouped = new HashMap<>();

        for (Employee e : employees) {
            grouped.computeIfAbsent(e.getDepartment(), k -> new ArrayList<>()).add(e);
        }

        for (Map.Entry<String, List<Employee>> entry : grouped.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
