package ObjectModelling;

import java.util.*;

class Product {
    String name;

    Product(String name) {
        this.name = name;
    }
}

class Order {
    List<Product> products = new ArrayList<>();

    void addProduct(Product p) {
        products.add(p);
    }

    void showProducts() {
        System.out.println("Order contains:");
        for (Product p : products) {
            System.out.println("- " + p.name);
        }
    }
}

class Customer {
    String name;
    List<Order> orders = new ArrayList<>();

    Customer(String name) {
        this.name = name;
    }

    void placeOrder(Order order) {
        orders.add(order);
    }
}

public class Commerce {
    public static void main(String[] args) {
        Customer c1 = new Customer("Lucky");

        Product p1 = new Product("Laptop");
        Product p2 = new Product("Headphones");

        Order order1 = new Order();
        order1.addProduct(p1);
        order1.addProduct(p2);

        c1.placeOrder(order1);

        order1.showProducts();
    }
}
