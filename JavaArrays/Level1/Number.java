package Assignments.JavaArrays.Level1;
import java.util.*;
public class Number {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];
        for (int i = 0; i < 5; i++) {
            numbers[i] = sc.nextInt();
        }
        for (int i = 0; i < 5; i++) {
            if (numbers[i] > 0) {
                System.out.println(numbers[i] + " is Positive");
                if (numbers[i] % 2 == 0) {
                    System.out.println("It's Even");
                } else {
                    System.out.println("It's Odd");
                }
            } else if (numbers[i] < 0) {
                System.out.println(numbers[i] + " is Negative");
            } else {
                System.out.println(numbers[i] + " is Zero");
            }
        }
        int first = numbers[0];
        int last = numbers[4];
        if (first > last) {
            System.out.println(first + " is Greater than " + last);
        } else if (first < last) {
            System.out.println(first + " is Less than " + last);
        } else {
            System.out.println("Both are Equal");
        }

    }
}

