import java.util.*;

class Invoice {
    int id;
    Invoice(int id) { this.id = id; }
    public String toString() { return "Invoice ID: " + id; }
}

public class InvoiceCreator {
    public static void main(String[] args) {
        List<Integer> ids = Arrays.asList(1, 2, 3);
        ids.stream().map(Invoice::new).forEach(System.out::println);
    }
}
