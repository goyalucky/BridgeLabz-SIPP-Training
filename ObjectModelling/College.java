package ObjectModelling;

import java.util.*;

class Department {
    String name;

    Department(String name) {
        this.name = name;
    }
}

class Faculty {
    String name;

    Faculty(String name) {
        this.name = name;
    }
}

class University {
    String name;
    List<Department> departments = new ArrayList<>();
    List<Faculty> faculties = new ArrayList<>();

    University(String name) {
        this.name = name;
    }

    void addDepartment(Department dept) {
        departments.add(dept);
    }

    void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    void deleteUniversity() {
        departments.clear();  
        System.out.println("University deleted. All departments removed.");
    }
}

public class College {
    public static void main(String[] args) {
        University uni = new University("GLA University");

        Department cs = new Department("Computer Science");
        Department mech = new Department("Mechanical");

        uni.addDepartment(cs);
        uni.addDepartment(mech);

        Faculty f1 = new Faculty("Dr. Sinha");
        Faculty f2 = new Faculty("Prof. Mehta");

        uni.addFaculty(f1);
        uni.addFaculty(f2);

        System.out.println("Faculty exist independently even after deleting university.");
        uni.deleteUniversity();
    }
}
