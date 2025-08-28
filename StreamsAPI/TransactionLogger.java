import java.util.*;
import java.time.LocalDateTime;

public class TransactionLogger {
    public static void main(String[] args) {
        List<String> transactions = Arrays.asList("TXN1001", "TXN1002", "TXN1003");

        transactions.forEach(txn -> 
            System.out.println(LocalDateTime.now() + " - Logged Transaction: " + txn)
        );
    }
}
