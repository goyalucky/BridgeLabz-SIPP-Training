import java.io.*;
import java.nio.file.*;

public class ImageByteArray {
    public static void main(String[] args) {
        String inputImage = "input.jpg";
        String outputImage = "output.jpg";

        try {
            FileInputStream fis = new FileInputStream(inputImage);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            byte[] imageBytes = baos.toByteArray();

            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            FileOutputStream fos = new FileOutputStream(outputImage);

            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            fis.close();
            baos.close();
            bais.close();
            fos.close();

            boolean isEqual = Files.mismatch(Path.of(inputImage), Path.of(outputImage)) == -1;
            System.out.println("Files are identical: " + isEqual);
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
    }
}
