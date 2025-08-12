import java.util.*;
import java.util.function.Predicate;

public class NotificationFilter {
    public static void main(String[] args) {
        List<String> alerts = Arrays.asList("Critical", "Normal", "Low");
        Predicate<String> filter = a -> a.equals("Critical");
        alerts.stream().filter(filter).forEach(System.out::println);
    }
}
