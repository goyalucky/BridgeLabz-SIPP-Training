import java.util.*;

class Item {
    String name;
    double price;
    int stock;

    Item(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}

class Customer {
    String name;
    List<String> itemList;

    Customer(String name, List<String> itemList) {
        this.name = name;
        this.itemList = itemList;
    }
}

class SmartCheckout {
    Queue<Customer> queue = new LinkedList<>();
    Map<String, Item> itemMap = new HashMap<>();

    public void addItemToStore(String name, double price, int stock) {
        itemMap.put(name, new Item(name, price, stock));
    }

    public void addCustomer(Customer customer) {
        queue.offer(customer);
    }

    public void processNextCustomer() {
        if (queue.isEmpty()) {
            System.out.println("No customers in queue.");
            return;
        }

        Customer customer = queue.poll();
        double total = 0;
        System.out.println("Processing: " + customer.name);

        for (String itemName : customer.itemList) {
            Item item = itemMap.get(itemName);
            if (item != null && item.stock > 0) {
                total += item.price;
                item.stock--;
                System.out.println("- " + itemName + " @ ₹" + item.price);
            } else {
                System.out.println("- " + itemName + " is out of stock");
            }
        }

        System.out.println("Total bill for " + customer.name + ": ₹" + total);
        System.out.println("------");
    }

    public void displayStock() {
        System.out.println("Current stock:");
        for (Item item : itemMap.values()) {
            System.out.println(item.name + ": " + item.stock + " left");
        }
    }
}

public class SupermarketSystem {
    public static void main(String[] args) {
        SmartCheckout checkout = new SmartCheckout();

        checkout.addItemToStore("Milk", 50, 10);
        checkout.addItemToStore("Bread", 30, 5);
        checkout.addItemToStore("Eggs", 6, 20);

        checkout.addCustomer(new Customer("Alice", Arrays.asList("Milk", "Bread")));
        checkout.addCustomer(new Customer("Bob", Arrays.asList("Eggs", "Milk", "Eggs")));
        checkout.addCustomer(new Customer("Charlie", Arrays.asList("Milk", "Chips")));

        checkout.processNextCustomer();
        checkout.processNextCustomer();
        checkout.displayStock();
    }
}
