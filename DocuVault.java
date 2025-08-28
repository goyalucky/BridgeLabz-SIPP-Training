import java.io.*;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class DocuVault {

    private static final String VAULT_DIR = "DocuVaultData";
    private static final String TRASH_DIR = VAULT_DIR + File.separator + "Trash";
    private static final String LOG_FILE = VAULT_DIR + File.separator + "activity.log";

    public static void main(String[] args) {
        createDirectories();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== DocuVault Secure File Manager ===");
            System.out.println("1. Upload Document");
            System.out.println("2. Read File Content");
            System.out.println("3. Append Content to File");
            System.out.println("4. Search Keyword in Files");
            System.out.println("5. Delete File (Move to Trash)");
            System.out.println("6. Show Total Storage Used");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String user = sc.nextLine();
                    System.out.print("Enter filename: ");
                    String filename = sc.nextLine();
                    uploadFile(user, filename, sc);
                    break;
                case 2:
                    System.out.print("Enter filename to read: ");
                    readFile(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Enter filename to append: ");
                    appendToFile(sc.nextLine(), sc);
                    break;
                case 4:
                    System.out.print("Enter keyword to search: ");
                    searchKeyword(sc.nextLine());
                    break;
                case 5:
                    System.out.print("Enter filename to delete: ");
                    deleteFile(sc.nextLine(), sc);
                    break;
                case 6:
                    showStorageUsage();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void createDirectories() {
        new File(VAULT_DIR).mkdirs();
        new File(TRASH_DIR).mkdirs();
    }

    private static void uploadFile(String username, String filename, Scanner sc) {
        File file = new File(VAULT_DIR, filename);
        System.out.println("Enter file content (end with 'END'): ");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            while (true) {
                String line = sc.nextLine();
                if (line.equalsIgnoreCase("END")) break;
                bw.write(line);
                bw.newLine();
            }
            logActivity(username, filename, "Uploaded");
            System.out.println("File uploaded successfully!");
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }

    private static void readFile(String filename) {
        File file = new File(VAULT_DIR, filename);
        if (!file.exists()) {
            System.out.println("File not found.");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            System.out.println("\n--- File Content ---");
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("--------------------");
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    private static void appendToFile(String filename, Scanner sc) {
        File file = new File(VAULT_DIR, filename);
        if (!file.exists()) {
            System.out.println("File not found.");
            return;
        }
        System.out.println("Enter content to append (end with 'END'): ");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            while (true) {
                String line = sc.nextLine();
                if (line.equalsIgnoreCase("END")) break;
                bw.write(line);
                bw.newLine();
            }
            logActivity("SYSTEM", filename, "Appended");
            System.out.println("Content appended successfully!");
        } catch (IOException e) {
            System.err.println("Error appending file: " + e.getMessage());
        }
    }

    private static void searchKeyword(String keyword) {
        File folder = new File(VAULT_DIR);
        File[] files = folder.listFiles((dir, name) -> !name.equals("activity.log") && !name.equals("Trash"));
        if (files == null) return;

        System.out.println("Files containing keyword '" + keyword + "':");
        boolean foundAny = false;

        for (File file : files) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.contains(keyword)) {
                        System.out.println(" - " + file.getName());
                        foundAny = true;
                        break;
                    }
                }
            } catch (IOException e) {
                System.err.println("Error searching file " + file.getName());
            }
        }

        if (!foundAny) System.out.println("No matches found.");
    }

    private static void deleteFile(String filename, Scanner sc) {
        File file = new File(VAULT_DIR, filename);
        if (!file.exists()) {
            System.out.println("File not found.");
            return;
        }

        System.out.print("Are you sure you want to delete (y/n)? ");
        String confirm = sc.nextLine();
        if (!confirm.equalsIgnoreCase("y")) {
            System.out.println("Deletion cancelled.");
            return;
        }

        File dest = new File(TRASH_DIR, filename);
        try {
            Files.move(file.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
            logActivity("SYSTEM", filename, "Deleted (Moved to Trash)");
            System.out.println("File moved to Trash.");
        } catch (IOException e) {
            System.err.println("Error moving file: " + e.getMessage());
        }
    }

    private static void showStorageUsage() {
        File folder = new File(VAULT_DIR);
        long totalSize = getFolderSize(folder);
        System.out.println("Total Storage Used: " + (totalSize / 1024.0) + " KB");
    }

    private static long getFolderSize(File folder) {
        long size = 0;
        File[] files = folder.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isFile() && !f.getName().equals("activity.log")) {
                    size += f.length();
                } else if (f.isDirectory() && !f.getName().equals("Trash")) {
                    size += getFolderSize(f);
                }
            }
        }
        return size;
    }
    private static void logActivity(String username, String filename, String action) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            bw.write(username + " | " + filename + " | " + action + " | " + time);
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Error writing log: " + e.getMessage());
        }
    }
}
