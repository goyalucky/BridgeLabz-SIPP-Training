import java.util.*;

abstract class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    abstract double calculateDiscount();

    double finalPrice() {
        return price - calculateDiscount();
    }

    void printBill() {
        System.out.println(name + " | Price: ₹" + price + " | Discount: ₹" + calculateDiscount() + " | Final: ₹" + finalPrice());
    }
}

class Electronics extends Product {
    Electronics(String name, double price) {
        super(name, price);
    }

    double calculateDiscount() {
        return price * 0.10;
    }
}

class Clothing extends Product {
    Clothing(String name, double price) {
        super(name, price);
    }

    double calculateDiscount() {
        return price * 0.20;
    }
}

class Grocery extends Product {
    Grocery(String name, double price) {
        super(name, price);
    }

    double calculateDiscount() {
        return 0;
    }
}

public class OnlineStoreBilling {
    public static void main(String[] args) {
        List<Product> cart = new ArrayList<>();
        cart.add(new Electronics("Smartphone", 30000));
        cart.add(new Clothing("T-shirt", 1000));
        cart.add(new Grocery("Rice", 800));

        for (Product p : cart) {
            p.printBill();
        }
    }
}
