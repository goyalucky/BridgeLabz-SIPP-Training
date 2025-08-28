import java.util.*;
public class TransformingNames {
    public static void main(String[] args) {
        List<String> customers = Arrays.asList("john", "alice", "bob", "eve");

        System.out.println("Customer Names in Uppercase and Alphabetical Order:");
        customers.stream()
            .map(String::toUpperCase)
            .sorted()
            .forEach(System.out::println);
    }
}
