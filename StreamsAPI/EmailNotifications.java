import java.util.*;

public class EmailNotifications {
    public static void main(String[] args) {
        List<String> emails = Arrays.asList("alice@example.com", "bob@example.com", "charlie@example.com");

        emails.forEach(email -> System.out.println("Sending notification to: " + email));
    }
}
