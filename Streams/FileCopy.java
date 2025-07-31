import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileCopy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter source file name: ");
        String sourcePath = sc.nextLine();

        System.out.print("Enter destination file name: ");
        String destinationPath = sc.nextLine();

        File srcFile = new File(sourcePath);

        if (!srcFile.exists()) {
            System.out.println("Source file does not exist.");
            return;
        }

        try (FileInputStream fis = new FileInputStream(srcFile);
                FileOutputStream fos = new FileOutputStream(destinationPath)) {

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }

            System.out.println("File copied successfully.");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        sc.close();
    }
}
