import java.util.Scanner;

public class sumuntil0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0, num;
        do {
            num = sc.nextDouble();
            total += num;
        } while (num != 0);
        System.out.println("Total sum is " + total);
    }
}
