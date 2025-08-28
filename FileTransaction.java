import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

class InvalidTransactionException extends Exception {
    public InvalidTransactionException(String message) {
        super(message);
    }
}

public class FileTransaction {

    public static void processWithException(Path filePath) throws IOException, InvalidTransactionException {
        try (Stream<String> lines = Files.lines(filePath)) {
            List<Integer> transactions = new ArrayList<>();
            for (String line : lines.toList()) {
                try {
                    transactions.add(Integer.parseInt(line.trim()));
                } catch (NumberFormatException e) {
                    throw new InvalidTransactionException("Invalid transaction data: " + line);
                }
            }
            System.out.println("Sum of Transactions: " + transactions.stream().mapToInt(Integer::intValue).sum());
            System.out.println("Max Transaction: " + transactions.stream().mapToInt(Integer::intValue).max().getAsInt());
        }
    }

    public static void processSkippingInvalid(Path filePath) throws IOException {
        try (Stream<String> lines = Files.lines(filePath)) {
            List<Integer> transactions = lines
                    .map(String::trim)
                    .filter(s -> {
                        try {
                            Integer.parseInt(s);
                            return true;
                        } catch (NumberFormatException e) {
                            return false;
                        }
                    })
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            int sum = transactions.stream().mapToInt(Integer::intValue).sum();
            int max = transactions.stream().mapToInt(Integer::intValue).max().orElse(0);

            System.out.println("Sum of Transactions: " + sum);
            System.out.println("Max Transaction: " + max);
        }
    }

    public static void main(String[] args) {
        Path filePath = Paths.get("transactions.txt");

        System.out.println("=== Approach 1: Throw Exception on Invalid Data ===");
        try {
            processWithException(filePath);
        } catch (InvalidTransactionException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n=== Approach 2: Skip Invalid Data ===");
        try {
            processSkippingInvalid(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
