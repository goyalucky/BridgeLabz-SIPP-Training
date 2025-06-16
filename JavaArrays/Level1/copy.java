package Assignments.JavaArrays.Level1;

public class copy {
    public static void main(String[] args) {
          int[][] twoD = {
            {1, 2, 3},
            {4, 5, 6}
        };

        int rows = twoD.length;
        int cols = twoD[0].length;
        int[] oneD = new int[rows * cols];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                oneD[index++] = twoD[i][j];
            }
        }
        System.out.print("1D Array: ");
        for (int i = 0; i < oneD.length; i++)
            System.out.print(oneD[i] + " ");
    }
}
