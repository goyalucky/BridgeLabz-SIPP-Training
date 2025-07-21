public class MarketplaceUtils {
    public static <T extends Category> void applyDiscount(Product<T> product, double percentage) {
        double oldPrice = product.getPrice();
        double newPrice = oldPrice - (oldPrice * percentage / 100);
        product.setPrice(newPrice);
        System.out.println("✅ Discount of " + percentage + "% applied to " + product.getName());
    }
}
