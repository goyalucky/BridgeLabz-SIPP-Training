import java.util.Scanner;

public class Euclidean {
    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return distance;
    }
    public static double[] findLineEquation(double x1, double y1, double x2, double y2) {
        double[] result = new double[2]; 
        double m = (y2 - y1) / (x2 - x1);
        double b = y1 - m * x1;

        result[0] = m;
        result[1] = b;

        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter x1: ");
        double x1 = sc.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = sc.nextDouble();
        System.out.print("Enter x2: ");
        double x2 = sc.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = sc.nextDouble();
        double distance = calculateDistance(x1, y1, x2, y2);
        System.out.printf("Euclidean Distance between (%.1f,%.1f) and (%.1f,%.1f) = %.3f\n", x1, y1, x2, y2, distance);
        if (x1 == x2) {
            System.out.println("The line is vertical (x = " + x1 + "). Slope is undefined.");
        } else {
            double[] lineEquation = findLineEquation(x1, y1, x2, y2);
            double m = lineEquation[0];
            double b = lineEquation[1];
            System.out.printf("Equation of the line: y = %.2fx + %.2f\n", m, b);
        }

        sc.close();
    }
}
