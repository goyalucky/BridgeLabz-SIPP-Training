package EncapPolyAbstInter;

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract double calculateDiscount();

    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: ₹" + price);
    }
}

class Electronics extends Product implements Taxable {
    private double taxRate = 0.18;

    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.10;
    }

    public double calculateTax() {
        return getPrice() * taxRate;
    }

    public String getTaxDetails() {
        return "Electronics Tax (18%)";
    }
}

class Clothing extends Product implements Taxable {
    private double taxRate = 0.05;

    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.20;
    }

    public double calculateTax() {
        return getPrice() * taxRate;
    }

    public String getTaxDetails() {
        return "Clothing Tax (5%)";
    }
}

class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.05;
    }
}

public class ECommercePlatform {
    public static void main(String[] args) {
        Product[] products = new Product[4];
        products[0] = new Electronics(101, "Smartphone", 25000);
        products[1] = new Clothing(102, "Jeans", 2000);
        products[2] = new Groceries(103, "Rice 10kg", 800);
        products[3] = new Electronics(104, "Laptop", 60000);

        for (Product p : products) {
            p.displayDetails();
            double tax = 0;
            if (p instanceof Taxable) {
                tax = ((Taxable) p).calculateTax();
                System.out.println("Tax Details: " + ((Taxable) p).getTaxDetails());
                System.out.println("Tax Amount: ₹" + tax);
            } else {
                System.out.println("Tax Details: No tax applicable");
            }
            double discount = p.calculateDiscount();
            System.out.println("Discount: ₹" + discount);
            double finalPrice = p.getPrice() + tax - discount;
            System.out.println("Final Price: ₹" + finalPrice);
            System.out.println("--------------------------------");
        }
    }
}
