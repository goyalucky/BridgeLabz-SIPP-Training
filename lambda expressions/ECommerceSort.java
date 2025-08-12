import java.util.*;

class Product {
    String name;
    double price, rating, discount;
    Product(String n, double p, double r, double d) {
        name = n; price = p; rating = r; discount = d;
    }
}

public class ECommerceSort {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 900, 4.5, 10),
            new Product("Phone", 600, 4.7, 15),
            new Product("Headphones", 150, 4.2, 20)
        );
        products.sort((a, b) -> Double.compare(a.price, b.price));
        products.forEach(p -> System.out.println(p.name + " $" + p.price));
    }
}
