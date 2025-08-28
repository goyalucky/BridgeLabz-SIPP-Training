import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

class GymMember {
    String name;
    LocalDate expiryDate;
    GymMember(String name, LocalDate expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }
}

public class ExpiringMemberships {
    public static void main(String[] args) {
        List<GymMember> members = Arrays.asList(
            new GymMember("John", LocalDate.now().plusDays(10)),
            new GymMember("Alice", LocalDate.now().plusDays(40)),
            new GymMember("Bob", LocalDate.now().plusDays(25)),
            new GymMember("Eve", LocalDate.now().plusDays(5))
        );

        System.out.println("Memberships expiring within 30 days:");
        members.stream()
            .filter(m -> ChronoUnit.DAYS.between(LocalDate.now(), m.expiryDate) <= 30)
            .forEach(m -> System.out.println(m.name + " - Expiry: " + m.expiryDate));
    }
}
