import java.util.Scanner;

public class Factorialwhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), fact = 1, i = 1;
        if (n >= 0) {
            while (i <= n) {
                fact *= i;
                i++;
            }
            System.out.println("Factorial is " + fact);
        }
    }
}
