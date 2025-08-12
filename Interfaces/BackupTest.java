import java.io.*;
class BackupData implements Serializable {
    String data = "Backup Info";
}
public class BackupTest {
    public static void main(String[] args) {
        BackupData b = new BackupData();
        System.out.println(b.data);
    }
}
