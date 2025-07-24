import java.util.*;
class CartItem {
    String name;
    int quantity;
    double price;

    CartItem(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    double getTotal() {
        return quantity * price;
    }
}

class ShoppingCart {
    List<CartItem> items = new ArrayList<>();
    void addItem(String name, int quantity, double price) {
        items.add(new CartItem(name, quantity, price));
    }

    void removeItem(int i) {
        if (i >= 0 && i < items.size()) {
            items.remove(i);
        }
    }

    double getTotalPrice() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getTotal();
        }
        return total;
    }

    void showCart() {
        for (CartItem item : items) {
            System.out.println(item.name + " x" + item.quantity + " = " + item.getTotal());
        }
    }
}

public class ShoppingCartApp {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Book", 2, 250.0);
        cart.addItem("Pen", 5, 20.0);
        cart.addItem("Book", 1, 250.0);
        cart.showCart();
        System.out.println("Total: " + cart.getTotalPrice());
    }
}
