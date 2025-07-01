import java.util.Scanner;

public class CoffeeCounterchronicles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final double gstrate = 0.05;
        while (true) {
            System.out.println("Enter Coffee Type(Roma, Nescafe, Cappuccino)");
            String coffeeType = sc.nextLine();

            if (coffeeType.equalsIgnoreCase("exit")) {
                System.out.println("Thank you");
                break;
            }
            double pricePerCup = 0.0;
            switch (coffeeType.toLowerCase()) {
                case "roma":
                    pricePerCup = 2.50;
                    break;
                case "nescafe":
                    pricePerCup = 3.75;
                    break;
                case "cappuccino":
                    pricePerCup = 3.50;
                    break;
                default:
                    System.out.println("Invalid coffee type. Please choose from Roma, Nescafe, or Cappuccino");
                    continue;
            }
            int q = 0;
            while (true) {
                System.out.print("Enter q: ");
                try {
                    q = Integer.parseInt(sc.nextLine());
                    if (q <= 0) {
                        System.out.println("Quantity must be a positive number. Please try again.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number for q.");
                }
            }

            double subTotal = pricePerCup * q;
            double gstAmount = subTotal * gstrate;
            double totalBill = subTotal + gstAmount;

            System.out.printf("Coffee Type:", coffeeType);
            System.out.printf("Quantity: %d%n", q);
            System.out.printf("Price per cup: $%.2f%n", pricePerCup);
            System.out.printf("Sub-total: $%.2f%n", subTotal);
            System.out.printf("GST (%.0f%%): $%.2f%n", (gstrate * 100), gstAmount);
            System.out.printf("Total Bill: $%.2f%n", totalBill);
        }
    }
}
