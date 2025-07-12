import java.io.*;

public class ByteToCharStream {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("data.txt");
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            int ch;

            while ((ch = isr.read()) != -1) {
                System.out.print((char) ch);
            }

            isr.close();
            fis.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
