import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();

        InsurancePolicy p1 = new InsurancePolicy("P101", "Alice", LocalDate.now().plusDays(10), "Health", 1200);
        InsurancePolicy p2 = new InsurancePolicy("P102", "Bob", LocalDate.now().plusDays(40), "Auto", 1500);
        InsurancePolicy p3 = new InsurancePolicy("P103", "Charlie", LocalDate.now().plusDays(5), "Home", 1800);
        InsurancePolicy p4 = new InsurancePolicy("P104", "David", LocalDate.now().plusDays(20), "Health", 2000);
        InsurancePolicy p5 = new InsurancePolicy("P101", "Alice", LocalDate.now().plusDays(10), "Health", 1200);

        manager.addPolicy(p1);
        manager.addPolicy(p2);
        manager.addPolicy(p3);
        manager.addPolicy(p4);
        manager.addPolicy(p5);

        System.out.println("\nAll Unique Policies:");
        manager.displayAllPolicies();

        System.out.println("\nPolicies Expiring Within 30 Days:");
        manager.displayPoliciesExpiringSoon();

        System.out.println("\nHealth Coverage Policies:");
        manager.displayPoliciesByCoverage("Health");

        System.out.println("\nDuplicate Policies:");
        List<InsurancePolicy> allPolicies = Arrays.asList(p1, p2, p3, p4, p5);
        manager.displayDuplicatePolicies(allPolicies);

        System.out.println("\nPerformance Comparison:");
        manager.comparePerformance();
    }
}
