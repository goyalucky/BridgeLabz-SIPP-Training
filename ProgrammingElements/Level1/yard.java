import java.util.Scanner;

public class yard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double disFeet = sc.nextDouble();
        double disYards = disFeet / 3;
        double disMiles = disYards / 1760;
        System.out.println("The distance in yards is: " + disYards);
        System.out.println("The distance in miles is: " + disMiles);
    }
}
