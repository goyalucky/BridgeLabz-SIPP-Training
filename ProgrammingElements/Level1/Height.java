import java.util.*;
public class Height {
    public static void main(String[] args) {
          double heightCm;
        double Inches, feet, inches;
        Scanner input = new Scanner(System.in);
         heightCm = input.nextDouble();

        Inches = heightCm / 2.54;
        feet = (int)(Inches / 12);
        inches = Inches % 12;
        System.out.println("Your Height in feet is " + (int)feet + " feet and " + inches + " inches");
    }
}

