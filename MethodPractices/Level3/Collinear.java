import java.util.Scanner;

public class Collinear {
    public static boolean isCollinearBySlope(int x1, int y1, int x2, int y2, int x3, int y3) {
        double slopeAB = (double)(y2 - y1) / (x2 - x1);
        double slopeBC = (double)(y3 - y2) / (x3 - x2);
        double slopeAC = (double)(y3 - y1) / (x3 - x1);

        return (slopeAB == slopeBC) && (slopeBC == slopeAC);
    }

    public static boolean isCollinearByArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        double area = 0.5 * (x1 * (y2 - y3)
                            + x2 * (y3 - y1)
                            + x3 * (y1 - y2));
        return area == 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 3 points (x1 y1 x2 y2 x3 y3):");
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int x3 = sc.nextInt();
        int y3 = sc.nextInt();

        boolean slopeCheck = isCollinearBySlope(x1, y1, x2, y2, x3, y3);
        boolean areaCheck = isCollinearByArea(x1, y1, x2, y2, x3, y3);

        if (slopeCheck && areaCheck) {
            System.out.println("The 3 points are Collinear.");
        } else {
            System.out.println("The 3 points are NOT Collinear.");
        }
    }
}
