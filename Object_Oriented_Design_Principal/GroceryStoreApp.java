package Object_Oriented_Design_Principal;
import java.util.*;
class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return price * quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}
class Customer {
    private String name;
    private List<Product> products;

    public Customer(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getName() {
        return name;
    }
}
class BillGenerator {
    public double calculateTotal(Customer customer) {
        double total = 0;
        for (Product product : customer.getProducts()) {
            total += product.getTotalPrice();
        }
        return total;
    }

    public void printBill(Customer customer) {
        System.out.println("Customer Name: " + customer.getName());
        for (Product product : customer.getProducts()) {
            System.out.println(product.getName() + " | Price: ₹" + product.getPrice() + " | Quantity: " + product.getQuantity() +
                               " | Subtotal: ₹" + product.getTotalPrice());
        }
        double total = calculateTotal(customer);
        System.out.println("Total Amount: ₹" + total);
    }
}
public class GroceryStoreApp {
    public static void main(String[] args) {
        Customer customer = new Customer("Lucky Goyal");

        customer.addProduct(new Product("Apple", 100, 2));
        customer.addProduct(new Product("Milk", 50, 1));
        customer.addProduct(new Product("Rice", 80, 3));

        BillGenerator billGen = new BillGenerator();
        billGen.printBill(customer);
    }
}
