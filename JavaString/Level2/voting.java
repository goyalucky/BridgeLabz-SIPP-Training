package JavaString.Level2;

import java.util.Scanner;

public class voting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 10; i++) {
            int age = sc.nextInt();
            System.out.println("Student " + i + (age >= 18 ? " can vote" : " cannot vote"));
        }
    }
}
