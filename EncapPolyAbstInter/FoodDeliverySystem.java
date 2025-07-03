package EncapPolyAbstInter;

interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract double calculateTotalPrice();

    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price: ₹" + price);
        System.out.println("Quantity: " + quantity);
    }
}

class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    public double applyDiscount() {
        return calculateTotalPrice() * 0.10;
    }

    public String getDiscountDetails() {
        return "10% discount on Veg Items";
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private double extraChargePerItem = 30.0;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    public double calculateTotalPrice() {
        return (getPrice() + extraChargePerItem) * getQuantity();
    }

    public double applyDiscount() {
        return calculateTotalPrice() * 0.05;
    }

    public String getDiscountDetails() {
        return "5% discount on Non-Veg Items";
    }
}

public class FoodDeliverySystem {
    public static void main(String[] args) {
        FoodItem[] order = new FoodItem[4];
        order[0] = new VegItem("Paneer Butter Masala", 250, 2);
        order[1] = new NonVegItem("Chicken Biryani", 300, 1);
        order[2] = new VegItem("Dal Tadka", 150, 3);
        order[3] = new NonVegItem("Mutton Curry", 400, 2);

        for (FoodItem item : order) {
            item.getItemDetails();
            double totalPrice = item.calculateTotalPrice();
            System.out.println("Total Price (before discount): ₹" + totalPrice);
            if (item instanceof Discountable) {
                Discountable dis = (Discountable) item;
                double discount = dis.applyDiscount();
                System.out.println(dis.getDiscountDetails());
                System.out.println("Discount: ₹" + discount);
                double finalPrice = totalPrice - discount;
                System.out.println("Final Price: ₹" + finalPrice);
            }
        }
    }
}
