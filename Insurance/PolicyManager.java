import java.time.LocalDate;
import java.util.*;

public class PolicyManager {
    private Set<InsurancePolicy> hashSetPolicies = new HashSet<>();
    private Set<InsurancePolicy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<InsurancePolicy> treeSetPolicies = new TreeSet<>();
    private Set<String> seenPolicyNumbers = new HashSet<>();

    public void addPolicy(InsurancePolicy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
        seenPolicyNumbers.add(policy.getPolicyNumber());
    }

    public void displayAllPolicies() {
        for (InsurancePolicy p : hashSetPolicies)
            System.out.println(p);
    }

    public void displayPoliciesExpiringSoon() {
        LocalDate now = LocalDate.now();
        LocalDate in30Days = now.plusDays(30);
        for (InsurancePolicy p : treeSetPolicies) {
            if (!p.getExpiryDate().isBefore(now) && !p.getExpiryDate().isAfter(in30Days))
                System.out.println(p);
        }
    }

    public void displayPoliciesByCoverage(String type) {
        for (InsurancePolicy p : hashSetPolicies) {
            if (p.getCoverageType().equalsIgnoreCase(type))
                System.out.println(p);
        }
    }

    public void displayDuplicatePolicies(List<InsurancePolicy> allPolicies) {
        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new HashSet<>();
        for (InsurancePolicy p : allPolicies) {
            if (!seen.add(p.getPolicyNumber())) {
                duplicates.add(p.getPolicyNumber());
            }
        }
        for (InsurancePolicy p : allPolicies) {
            if (duplicates.contains(p.getPolicyNumber())) {
                System.out.println(p);
            }
        }
    }

    public void comparePerformance() {
        int operations = 100000;
        List<InsurancePolicy> testPolicies = new ArrayList<>();
        for (int i = 0; i < operations; i++) {
            testPolicies.add(new InsurancePolicy("P" + i, "Holder" + i, LocalDate.now().plusDays(i % 365), "Health", 1000 + i));
        }

        long start = System.currentTimeMillis();
        Set<InsurancePolicy> hs = new HashSet<>(testPolicies);
        long hashTime = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        Set<InsurancePolicy> lhs = new LinkedHashSet<>(testPolicies);
        long lhsTime = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        Set<InsurancePolicy> ts = new TreeSet<>(testPolicies);
        long tsTime = System.currentTimeMillis() - start;

        System.out.println("HashSet time: " + hashTime + "ms");
        System.out.println("LinkedHashSet time: " + lhsTime + "ms");
        System.out.println("TreeSet time: " + tsTime + "ms");
    }
}
