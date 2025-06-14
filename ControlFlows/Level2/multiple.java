package Assignments.ControlFlows.Level2;

import java.util.Scanner;

public class multiple {
    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        for (int i = 1; i < 100; i++) {
            if (i % number == 0)
                System.out.println(i);
        }
    }
}
