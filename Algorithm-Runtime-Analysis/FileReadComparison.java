import java.io.*;

public class FileReadComparison {
    public static void main(String[] args) throws Exception {
        String filename = "large.txt";

        long start = System.nanoTime();
        FileReader fr = new FileReader(filename);
        while (fr.read() != -1) {}
        fr.close();
        long end = System.nanoTime();
        System.out.println("FileReader Time: " + (end - start) / 1_000_000.0 + " ms");

        start = System.nanoTime();
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filename));
        while (isr.read() != -1) {}
        isr.close();
        end = System.nanoTime();
        System.out.println("InputStreamReader Time: " + (end - start) / 1_000_000.0 + " ms");
    }
}
