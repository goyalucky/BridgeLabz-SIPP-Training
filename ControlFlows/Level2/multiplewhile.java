package Assignments.ControlFlows.Level2;

import java.util.Scanner;

public class multiplewhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int counter = 1;

        while (counter < 100) {
            if (counter % number == 0)
                System.out.println(counter);
            counter++;
        }
    }
}
