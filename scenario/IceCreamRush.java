class Flavor {
    String name;
    int sold;

    Flavor(String name, int sold) {
        this.name = name;
        this.sold = sold;
    }

    public String toString() {
        return name + " - " + sold + " sold";
    }
}

public class IceCreamRush {
    public static void main(String[] args) {
        Flavor[] flavors = {
            new Flavor("Vanilla", 120),
            new Flavor("Chocolate", 180),
            new Flavor("Strawberry", 90),
            new Flavor("Mango", 75),
            new Flavor("Butterscotch", 110),
            new Flavor("Blueberry", 60),
            new Flavor("Pineapple", 95),
            new Flavor("Kesar Pista", 130)
        };

        bubbleSort(flavors);

        System.out.println("Flavors sorted by popularity:");
        for (Flavor flavor : flavors) {
            System.out.println(flavor);
        }
    }

    static void bubbleSort(Flavor[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j].sold < arr[j + 1].sold) {
                    Flavor temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
