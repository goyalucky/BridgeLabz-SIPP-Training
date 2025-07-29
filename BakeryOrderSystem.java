import java.util.*;

class BakeryItem {
    private String itemName;
    private int quantity;
    private String category;

    public BakeryItem(String itemName, int quantity, String category) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.category = category;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCategory() {
        return category;
    }

    public String toString() {
        return itemName + " - Qty: " + quantity + " - Category: " + category;
    }
}

class OrderQueue<T extends BakeryItem> {
    private Queue<T> orders = new LinkedList<>();

    public void addOrder(T item) {
        orders.offer(item);
    }

    public T deliverOrder() {
        return orders.poll();
    }

    public List<T> filterByCategory(String category) {
        List<T> filtered = new ArrayList<>();
        for (T item : orders) {
            if (item.getCategory().equalsIgnoreCase(category)) {
                filtered.add(item);
            }
        }
        return filtered;
    }

    public void displayOrders() {
        for (T item : orders) {
            System.out.println(item);
        }
    }
}

public class BakeryOrderSystem {
    public static void main(String[] args) {
        OrderQueue<BakeryItem> orderQueue = new OrderQueue<>();

        orderQueue.addOrder(new BakeryItem("Chocolate Cake", 1, "Cake"));
        orderQueue.addOrder(new BakeryItem("Strawberry Pastry", 2, "Pastry"));
        orderQueue.addOrder(new BakeryItem("Choco Chip Cookie", 5, "Cookie"));
        orderQueue.addOrder(new BakeryItem("Vanilla Cake", 1, "Cake"));

        System.out.println("All Orders:");
        orderQueue.displayOrders();

        System.out.println("\nDelivering Order: " + orderQueue.deliverOrder());

        System.out.println("\nRemaining Orders:");
        orderQueue.displayOrders();

        System.out.println("\nFiltered by Category (Cake):");
        List<BakeryItem> cakes = orderQueue.filterByCategory("Cake");
        for (BakeryItem item : cakes) {
            System.out.println(item);
        }
    }
}
