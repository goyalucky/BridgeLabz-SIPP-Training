import java.util.*;

public class LostAndFoundSystem {
    HashMap<String, LinkedList<String>> lostItems = new HashMap<>();
    HashSet<String> itemSet = new HashSet<>();

    void addItem(String type, String description) {
        if (!itemSet.contains(description.toLowerCase())) {
            lostItems.putIfAbsent(type.toLowerCase(), new LinkedList<>());
            lostItems.get(type.toLowerCase()).add(description);
            itemSet.add(description.toLowerCase());
            System.out.println("Item added: [" + type + "] " + description);
        } else {
            System.out.println("Duplicate item. Not added: " + description);
        }
    }

    void searchItem(String type, String keyword) {
        LinkedList<String> list = lostItems.get(type.toLowerCase());
        if (list == null || list.isEmpty()) {
            System.out.println("No items found for type: " + type);
            return;
        }

        boolean found = false;
        int index = 0;
        for (String item : list) {
            if (item.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("Item matched at position " + (index + 1) + ": " + item);
                found = true;
            }
            index++;
        }

        if (!found) {
            System.out.println("No matching item found with keyword: " + keyword);
        }
    }

    public static void main(String[] args) {
        LostAndFoundSystem system = new LostAndFoundSystem();

        system.addItem("Bag", "Black Nike Backpack");
        system.addItem("Mobile", "Samsung Galaxy S22");
        system.addItem("Book", "AI for Beginners");
        system.addItem("Mobile", "iPhone 14 Pro");
        system.addItem("Bag", "Red American Tourister Trolley");
        system.addItem("Bag", "Black Nike Backpack"); // duplicate

        System.out.println();
        system.searchItem("Bag", "Nike");
        system.searchItem("Mobile", "iPhone");
        system.searchItem("Book", "Python");
    }
}
