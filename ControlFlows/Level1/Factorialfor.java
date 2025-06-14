import java.util.Scanner;

public class Factorialfor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), fact = 1;
        if (n >= 0) {
            for (int i = 1; i <= n; i++)
                fact *= i;
            System.out.println("Factorial is " + fact);
        }
    }
}
