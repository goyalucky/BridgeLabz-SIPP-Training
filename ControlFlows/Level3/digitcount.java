package Assignments.ControlFlows.Level3;

import java.util.Scanner;

public class digitcount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if (number == 0) {
            System.out.println("The number of digits in " + number + " is: 1");
            return;
        }
        number = Math.abs(number);
        int count = 0;
        while (number != 0) {
            number /= 10;  
            count++;       
        }
        System.out.println("The number of digits is: " + count);
    }
}
