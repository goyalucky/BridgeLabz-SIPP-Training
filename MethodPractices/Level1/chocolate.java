package Assignments.MethodPractices.Level1;

import java.util.Scanner;

public class chocolate {
    public static int chocolatesPerChild(int totalChoco, int totalChild) {
        return totalChoco / totalChild;
    }
    public static int remainingChocolates(int totalChoco, int totalChild) {
        return totalChoco % totalChild;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Chocolates = sc.nextInt();
        int Children = sc.nextInt();

        int perChild = chocolatesPerChild(Chocolates, Children);
        int remaining = remainingChocolates(Chocolates, Children);

        System.out.println("Each child will get " + perChild + " chocolates.");
        System.out.println("Remaining chocolates: " + remaining);
  }
}
