import java.util.*;
import java.util.stream.Collectors;

class Claim {
    String type;
    double amount;
    Claim(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }
}

public class InsuranceClaimAnalysis {
    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
            new Claim("Health", 5000),
            new Claim("Health", 7000),
            new Claim("Auto", 10000),
            new Claim("Auto", 8000),
            new Claim("Life", 15000)
        );

        System.out.println("Average Claim Amount by Type:");
        claims.stream()
            .collect(Collectors.groupingBy(c -> c.type, Collectors.averagingDouble(c -> c.amount)))
            .forEach((type, avg) -> System.out.println(type + " : " + avg));
    }
}
