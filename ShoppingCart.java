import java.util.*;

public class ShoppingCart {
    public static void main(String[] args) {
        HashMap<String, Integer> productPrices = new HashMap<>();
        productPrices.put("Book", 200);
        productPrices.put("Pen", 20);
        productPrices.put("Bag", 700);

        LinkedHashMap<String, Integer> cartOrder = new LinkedHashMap<>();
        cartOrder.put("Pen", 20);
        cartOrder.put("Book", 200);
        cartOrder.put("Bag", 700);

        TreeMap<String, Integer> sortedItems = new TreeMap<>(productPrices);

        System.out.println("HashMap: " + productPrices);
        System.out.println("LinkedHashMap: " + cartOrder);
        System.out.println("TreeMap: " + sortedItems);
    }
}
