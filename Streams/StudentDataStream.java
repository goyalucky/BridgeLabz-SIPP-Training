import java.io.*;

public class StudentDataStream {
    public static void main(String[] args) {
        String filename = "student_data.dat";

        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename));
            dos.writeInt(101);
            dos.writeUTF("Prashant Goyal");
            dos.writeDouble(8.7);
            dos.writeInt(102);
            dos.writeUTF("Lucky Goyal");
            dos.writeDouble(9.1);
            dos.close();
            System.out.println("Student data written to file.");
        } catch (IOException e) {
            System.out.println("Write Error: " + e.getMessage());
        }

        try {
            DataInputStream dis = new DataInputStream(new FileInputStream(filename));
            while (dis.available() > 0) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll: " + roll + ", Name: " + name + ", GPA: " + gpa);
            }
            dis.close();
        } catch (IOException e) {
            System.out.println("Read Error: " + e.getMessage());
        }
    }
}
