public class Main {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop", 75000, "Dell"));
        electronicsStorage.addItem(new Electronics("Smartphone", 30000, "Samsung"));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Rice", 1500, "2025-01-10"));
        groceriesStorage.addItem(new Groceries("Milk", 50, "2024-08-01"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair", 2000, "Wood"));
        furnitureStorage.addItem(new Furniture("Table", 5000, "Metal"));

        System.out.println("=== Electronics ===");
        WarehouseUtils.displayAllItems(electronicsStorage.getItems());

        System.out.println("\n=== Groceries ===");
        WarehouseUtils.displayAllItems(groceriesStorage.getItems());

        System.out.println("\n=== Furniture ===");
        WarehouseUtils.displayAllItems(furnitureStorage.getItems());
    }
}
