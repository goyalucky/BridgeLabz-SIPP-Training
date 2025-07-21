import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product<? extends Category>> catalog = new ArrayList<>();

        // Creating products
        Product<BookCategory> book = new Product<>("Atomic Habits", 450.0, new BookCategory());
        Product<ClothingCategory> tshirt = new Product<>("White T-Shirt", 799.0, new ClothingCategory());
        Product<GadgetCategory> phone = new Product<>("OnePlus Nord CE 4", 25999.0, new GadgetCategory());

        // Adding to catalog
        catalog.add(book);
        catalog.add(tshirt);
        catalog.add(phone);

        System.out.println("=== 📦 Catalog Before Discount ===");
        for (Product<? extends Category> product : catalog) {
            product.displayInfo();
        }

        // Applying discounts
        MarketplaceUtils.applyDiscount(book, 10);     // 10% off
        MarketplaceUtils.applyDiscount(tshirt, 15);   // 15% off
        MarketplaceUtils.applyDiscount(phone, 5);     // 5% off

        System.out.println("\n=== 💸 Catalog After Discount ===");
        for (Product<? extends Category> product : catalog) {
            product.displayInfo();
        }
    }
}
