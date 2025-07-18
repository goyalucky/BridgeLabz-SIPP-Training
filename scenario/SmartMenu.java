import java.util.*;

class Dish {
    String name;
    String type; // e.g., "Veg", "Non-Veg", "Dessert"
    List<String> tags;

    Dish(String name, String type, List<String> tags) {
        this.name = name;
        this.type = type;
        this.tags = tags;
    }

    void printDetails() {
        System.out.println("Dish: " + name);
        System.out.println("Type: " + type);
        System.out.println("Tags: " + tags);
        System.out.println();
    }
}

public class SmartMenu {
    ArrayList<Dish> menu = new ArrayList<>();
    HashSet<String> dishNames = new HashSet<>();

    void addDish(String name, String type, List<String> tags) {
        if (!dishNames.contains(name.toLowerCase())) {
            Dish newDish = new Dish(name, type, tags);
            menu.add(newDish);
            dishNames.add(name.toLowerCase());
            System.out.println("Added dish: " + name);
        } else {
            System.out.println("Duplicate dish not added: " + name);
        }
    }

    void searchMenu(String keyword) {
        System.out.println("\nSearching for: " + keyword);
        keyword = keyword.toLowerCase();
        boolean found = false;

        for (Dish dish : menu) {
            if (dish.name.toLowerCase().contains(keyword)) {
                dish.printDetails();
                found = true;
            } else {
                for (String tag : dish.tags) {
                    if (tag.toLowerCase().contains(keyword)) {
                        dish.printDetails();
                        found = true;
                        break;
                    }
                }
            }
        }

        if (!found) {
            System.out.println("No dishes found with keyword: " + keyword);
        }
    }

    public static void main(String[] args) {
        SmartMenu restaurant = new SmartMenu();

        restaurant.addDish("Paneer Tikka", "Veg", Arrays.asList("spicy", "grilled", "starter"));
        restaurant.addDish("Butter Chicken", "Non-Veg", Arrays.asList("creamy", "spicy", "north-indian"));
        restaurant.addDish("Gulab Jamun", "Dessert", Arrays.asList("sweet", "milk-based", "soft"));
        restaurant.addDish("Paneer Tikka", "Veg", Arrays.asList("duplicate")); // duplicate name

        restaurant.searchMenu("spicy");
        restaurant.searchMenu("paneer");
        restaurant.searchMenu("chocolate");
    }
}
