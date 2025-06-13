import java.util.Scanner;

public class Area {
    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);

        // Input base and height in inches
        System.out.print("Enter the base of the triangle in inches: ");
        double base = sc.nextDouble();
        System.out.print("Enter the height of the triangle in inches: ");
        double height = sc.nextDouble();

        // Calculate area in square inches
        double areaInInches = 0.5 * base * height;

        // Convert to square centimeters (1 inch = 2.54 cm, so 1 square inch = 6.4516 sq cm)
        double areaInCm = areaInInches * 6.4516;

        System.out.println("The area of the triangle is: " + areaInInches + " square inches");
        System.out.println("The area of the triangle is: " + areaInCm + " square centimeters");
    }
}
