import java.util.Scanner;

public class sumfor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n >= 0) {
            int sum = 0;
            for (int i = 1; i <= n; i++)
                sum += i;
            int formula = n * (n + 1) / 2;
            System.out.println("Sum by for loop: " + sum);
            System.out.println("Sum by formula: " + formula);
        }
    }
}
