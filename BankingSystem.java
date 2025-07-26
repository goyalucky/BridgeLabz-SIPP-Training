import java.util.*;

public class BankingSystem {
    public static void main(String[] args) {
        HashMap<Integer, Integer> accounts = new HashMap<>();
        accounts.put(1001, 5000);
        accounts.put(1002, 3000);
        accounts.put(1003, 7000);

        TreeMap<Integer, Integer> sortedAccounts = new TreeMap<>(accounts);

        Queue<Integer> withdrawals = new LinkedList<>();
        withdrawals.add(1002);
        withdrawals.add(1003);
        withdrawals.add(1001);

        while (!withdrawals.isEmpty()) {
            int acc = withdrawals.poll();
            int bal = accounts.getOrDefault(acc, 0);
            accounts.put(acc, bal - 500);
        }

        System.out.println("Accounts: " + accounts);
        System.out.println("Sorted Accounts: " + sortedAccounts);
    }
}
