public class FibonacciComparison {
    public static void main(String[] args) {
        int[] testValues = {10, 30, 50};

        for (int n : testValues) {
            long start, end;

            if (n <= 30) {
                start = System.nanoTime();
                int rec = fibonacciRecursive(n);
                end = System.nanoTime();
                System.out.println("Recursive Fibonacci(" + n + ") = " + rec + ", Time: " + (end - start) / 1_000_000.0 + " ms");
            } else {
                System.out.println("Recursive Fibonacci(" + n + "): Unfeasible");
            }

            start = System.nanoTime();
            int iter = fibonacciIterative(n);
            end = System.nanoTime();
            System.out.println("Iterative Fibonacci(" + n + ") = " + iter + ", Time: " + (end - start) / 1_000_000.0 + " ms\n");
        }
    }

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
