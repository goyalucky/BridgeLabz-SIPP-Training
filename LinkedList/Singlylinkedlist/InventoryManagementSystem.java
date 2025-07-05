package LinkedList.Singlylinkedlist;

class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;

    Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryLinkedList {
    Item head;

    void addAtBeginning(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    void addAtEnd(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    void addAtPosition(int position, String itemName, int itemId, int quantity, double price) {
        if (position == 1) {
            addAtBeginning(itemName, itemId, quantity, price);
            return;
        }
        Item temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Invalid position.");
            return;
        }
        Item newItem = new Item(itemName, itemId, quantity, price);
        newItem.next = temp.next;
        temp.next = newItem;
    }

    void removeByItemId(int itemId) {
        if (head == null) {
            System.out.println("No items to remove.");
            return;
        }
        if (head.itemId == itemId) {
            head = head.next;
            System.out.println("Item removed.");
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.itemId != itemId) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Item not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Item removed.");
        }
    }

    void updateQuantity(int itemId, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                System.out.println("Quantity updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    void searchByItemId(int itemId) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                printItem(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    void searchByItemName(String itemName) {
        Item temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(itemName)) {
                printItem(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("Item not found.");
        }
    }

    void calculateTotalValue() {
        double total = 0;
        Item temp = head;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: ₹" + total);
    }

    void displayAll() {
        if (head == null) {
            System.out.println("No items in inventory.");
            return;
        }
        Item temp = head;
        while (temp != null) {
            printItem(temp);
            temp = temp.next;
        }
    }

    void sortByName(boolean ascending) {
        head = mergeSortByName(head, ascending);
    }

    void sortByPrice(boolean ascending) {
        head = mergeSortByPrice(head, ascending);
    }

    Item mergeSortByName(Item head, boolean ascending) {
        if (head == null || head.next == null) return head;
        Item middle = getMiddle(head);
        Item nextOfMiddle = middle.next;
        middle.next = null;
        Item left = mergeSortByName(head, ascending);
        Item right = mergeSortByName(nextOfMiddle, ascending);
        return sortedMergeByName(left, right, ascending);
    }

    Item sortedMergeByName(Item a, Item b, boolean ascending) {
        if (a == null) return b;
        if (b == null) return a;
        Item result;
        if (ascending ? a.itemName.compareToIgnoreCase(b.itemName) <= 0 : a.itemName.compareToIgnoreCase(b.itemName) > 0) {
            result = a;
            result.next = sortedMergeByName(a.next, b, ascending);
        } else {
            result = b;
            result.next = sortedMergeByName(a, b.next, ascending);
        }
        return result;
    }

    Item mergeSortByPrice(Item head, boolean ascending) {
        if (head == null || head.next == null) return head;
        Item middle = getMiddle(head);
        Item nextOfMiddle = middle.next;
        middle.next = null;
        Item left = mergeSortByPrice(head, ascending);
        Item right = mergeSortByPrice(nextOfMiddle, ascending);
        return sortedMergeByPrice(left, right, ascending);
    }

    Item sortedMergeByPrice(Item a, Item b, boolean ascending) {
        if (a == null) return b;
        if (b == null) return a;
        Item result;
        if (ascending ? a.price <= b.price : a.price > b.price) {
            result = a;
            result.next = sortedMergeByPrice(a.next, b, ascending);
        } else {
            result = b;
            result.next = sortedMergeByPrice(a, b.next, ascending);
        }
        return result;
    }

    Item getMiddle(Item head) {
        if (head == null) return head;
        Item slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    void printItem(Item item) {
        System.out.println("Name: " + item.itemName + ", ID: " + item.itemId + ", Quantity: " + item.quantity + ", Price: ₹" + item.price);
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        InventoryLinkedList inventory = new InventoryLinkedList();

        inventory.addAtEnd("Laptop", 101, 5, 55000);
        inventory.addAtBeginning("Mouse", 102, 20, 450);
        inventory.addAtEnd("Keyboard", 103, 10, 1200);
        inventory.addAtPosition(2, "Monitor", 104, 7, 8500);

        System.out.println("All Items:");
        inventory.displayAll();

        System.out.println("\nSearch by Item ID 101:");
        inventory.searchByItemId(101);

        System.out.println("\nSearch by Item Name 'Keyboard':");
        inventory.searchByItemName("Keyboard");

        System.out.println("\nUpdating quantity of Item ID 102 to 25:");
        inventory.updateQuantity(102, 25);
        inventory.displayAll();

        System.out.println("\nTotal Inventory Value:");
        inventory.calculateTotalValue();

        System.out.println("\nSorting by Name (Ascending):");
        inventory.sortByName(true);
        inventory.displayAll();

        System.out.println("\nSorting by Price (Descending):");
        inventory.sortByPrice(false);
        inventory.displayAll();

        System.out.println("\nRemoving Item with ID 103:");
        inventory.removeByItemId(103);
        inventory.displayAll();
    }
}
