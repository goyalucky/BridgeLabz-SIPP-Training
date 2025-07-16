public class StringConcatPerformance {
    public static void main(String[] args) {
        int N = 1_000_000;

        long start = System.nanoTime();
        String str = "";
        for (int i = 0; i < N; i++) {
            str += "a";
        }
        long end = System.nanoTime();
        System.out.println("String: " + (end - start) / 1_000_000.0 + " ms");

        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("a");
        }
        end = System.nanoTime();
        System.out.println("StringBuilder: " + (end - start) / 1_000_000.0 + " ms");

        start = System.nanoTime();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < N; i++) {
            sbuf.append("a");
        }
        end = System.nanoTime();
        System.out.println("StringBuffer: " + (end - start) / 1_000_000.0 + " ms");
    }
}
