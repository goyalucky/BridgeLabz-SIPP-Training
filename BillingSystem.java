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
        System.out.println("Product: " + name);
        System.out.println("Original Price: ₹" + price);
        System.out.println("Discount: ₹" + calculateDiscount());
        System.out.println("Final Price: ₹" + finalPrice());
        System.out.println();
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

public class BillingSystem {
    public static void main(String[] args) {
        Product[] products = new Product[3];
        products[0] = new Electronics("Smartphone", 30000);
        products[1] = new Clothing("T-Shirt", 1500);
        products[2] = new Grocery("Rice (5kg)", 500);

        for (Product p : products) {
            p.printBill();
        }
    }
}
