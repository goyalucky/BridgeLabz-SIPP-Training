import java.util.*;

class Doctor {
    String name;
    String specialty;
    boolean availableOnWeekend;
    Doctor(String name, String specialty, boolean availableOnWeekend) {
        this.name = name;
        this.specialty = specialty;
        this.availableOnWeekend = availableOnWeekend;
    }
}

public class DoctorAvailability {
    public static void main(String[] args) {
        List<Doctor> doctors = Arrays.asList(
            new Doctor("Dr. A", "Cardiology", true),
            new Doctor("Dr. B", "Orthopedics", false),
            new Doctor("Dr. C", "Neurology", true),
            new Doctor("Dr. D", "Dermatology", true)
        );

        System.out.println("Doctors available on weekends (sorted by specialty):");
        doctors.stream()
            .filter(d -> d.availableOnWeekend)
            .sorted(Comparator.comparing(d -> d.specialty))
            .forEach(d -> System.out.println(d.name + " - " + d.specialty));
    }
}
