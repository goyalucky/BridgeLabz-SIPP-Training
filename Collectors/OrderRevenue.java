import java.util.*;
import java.util.stream.*;

class Order {
    private String customer;
    private double total;
    Order(String customer, double total) { this.customer = customer; this.total = total; }
    public String getCustomer() { return customer; }
    public double getTotal() { return total; }
}

public class OrderRevenue {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
            new Order("C1", 100.5),
            new Order("C2", 200.0),
            new Order("C1", 300.0)
        );
        Map<String, Double> revenueByCustomer = orders.stream()
            .collect(Collectors.groupingBy(Order::getCustomer,
                     Collectors.summingDouble(Order::getTotal)));
        System.out.println(revenueByCustomer);
    }
}
