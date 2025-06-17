import java.util.Scanner;

public class matrixoperations {
    public static double[][] createMatrix(int rows, int cols) {
        double[][] matrix = new double[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = (int) (Math.random() * 10);  
        return matrix;
    }
    public static void displayMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row)
                System.out.printf("%6.2f", val);
            System.out.println();
        }
        System.out.println();
    }
    public static double[][] transpose(double[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        double[][] trans = new double[cols][rows];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                trans[j][i] = matrix[i][j];
        return trans;
    }
    public static double determinant2x2(double[][] m) {
        return m[0][0] * m[1][1] - m[0][1] * m[1][0];
    }
    public static double determinant3x3(double[][] m) {
        return m[0][0] * (m[1][1] * m[2][2] - m[1][2] * m[2][1])
             - m[0][1] * (m[1][0] * m[2][2] - m[1][2] * m[2][0])
             + m[0][2] * (m[1][0] * m[2][1] - m[1][1] * m[2][0]);
    }
    public static double[][] inverse2x2(double[][] m) {
        double det = determinant2x2(m);
        if (det == 0) {
            System.out.println("Inverse not possible (determinant is zero).");
            return null;
        }
        double[][] inv = new double[2][2];
        inv[0][0] = m[1][1] / det;
        inv[0][1] = -m[0][1] / det;
        inv[1][0] = -m[1][0] / det;
        inv[1][1] = m[0][0] / det;
        return inv;
    }
    public static double[][] inverse3x3(double[][] m) {
        double det = determinant3x3(m);
        if (det == 0) {
            System.out.println("Inverse not possible (determinant is zero).");
            return null;
        }

        double[][] inv = new double[3][3];
        inv[0][0] = (m[1][1]*m[2][2] - m[1][2]*m[2][1]) / det;
        inv[0][1] = -(m[0][1]*m[2][2] - m[0][2]*m[2][1]) / det;
        inv[0][2] = (m[0][1]*m[1][2] - m[0][2]*m[1][1]) / det;

        inv[1][0] = -(m[1][0]*m[2][2] - m[1][2]*m[2][0]) / det;
        inv[1][1] = (m[0][0]*m[2][2] - m[0][2]*m[2][0]) / det;
        inv[1][2] = -(m[0][0]*m[1][2] - m[0][2]*m[1][0]) / det;

        inv[2][0] = (m[1][0]*m[2][1] - m[1][1]*m[2][0]) / det;
        inv[2][1] = -(m[0][0]*m[2][1] - m[0][1]*m[2][0]) / det;
        inv[2][2] = (m[0][0]*m[1][1] - m[0][1]*m[1][0]) / det;

        return inv;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[][] matrix3x3 = createMatrix(3, 3);
        System.out.println("Original 3x3 Matrix:");
        displayMatrix(matrix3x3);

        System.out.println("Transpose:");
        displayMatrix(transpose(matrix3x3));

        System.out.println("Determinant of 3x3 Matrix: " + determinant3x3(matrix3x3));

        System.out.println("Inverse of 3x3 Matrix:");
        double[][] inv3 = inverse3x3(matrix3x3);
        if (inv3 != null)
            displayMatrix(inv3);

        double[][] matrix2x2 = createMatrix(2, 2);
        System.out.println("Original 2x2 Matrix:");
        displayMatrix(matrix2x2);

        System.out.println("Determinant of 2x2 Matrix: " + determinant2x2(matrix2x2));

        System.out.println("Inverse of 2x2 Matrix:");
        double[][] inv2 = inverse2x2(matrix2x2);
        if (inv2 != null)
            displayMatrix(inv2);
    }
}
