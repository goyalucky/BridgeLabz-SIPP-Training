import java.io.*;

public class UpperToLower {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(inputFile), "UTF-8");
            BufferedReader reader = new BufferedReader(isr);

            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8");
            BufferedWriter writer = new BufferedWriter(osw);

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }

            reader.close();
            writer.close();
            System.out.println("Conversion completed successfully.");
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
    }
}
