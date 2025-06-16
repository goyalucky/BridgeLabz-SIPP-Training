package Assignments.JavaArrays.Level1;

import java.util.Scanner;

public class oddeven {
    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int[] odd = new int[num];
        int[] even = new int[num];
        int oddCount = 0, evenCount = 0;

        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0)
                even[evenCount++] = i;
            else
                odd[oddCount++] = i;
        }

        System.out.print("Even numbers: ");
        for (int i = 0; i < evenCount; i++)
            System.out.print(even[i] + " ");

        System.out.print("\nOdd numbers: ");
        for (int i = 0; i < oddCount; i++)
            System.out.print(odd[i] + " ");
    }
}
