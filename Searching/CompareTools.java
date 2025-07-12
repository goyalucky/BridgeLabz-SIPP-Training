import java.io.*;

public class CompareTools {
    public static void main(String[] args) {
        int n = 1000000;

        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append("a");
        long end = System.currentTimeMillis();
        System.out.println("StringBuilder time: " + (end - start) + " ms");

        start = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < n; i++) sbf.append("a");
        end = System.currentTimeMillis();
        System.out.println("StringBuffer time: " + (end - start) + " ms");

        int wordCount = 0;
        try {
            FileReader fr = new FileReader("largefile.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null)
                wordCount += line.split("\\s+").length;
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("FileReader Error: " + e.getMessage());
        }
        System.out.println("Words using FileReader: " + wordCount);

        wordCount = 0;
        try {
            FileInputStream fis = new FileInputStream("largefile.txt");
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null)
                wordCount += line.split("\\s+").length;
            br.close();
            isr.close();
            fis.close();
        } catch (IOException e) {
            System.out.println("InputStreamReader Error: " + e.getMessage());
        }
        System.out.println("Words using InputStreamReader: " + wordCount);
    }
}
