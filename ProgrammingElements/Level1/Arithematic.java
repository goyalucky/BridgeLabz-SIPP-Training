import java.util.*;

public class Arithematic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();
        int add = number1 + number2;
        int sub = number1 - number2;
        int mul = number1 * number2;
        int div = number1 / number2;
        
        System.out.println("The addition, subtraction, multiplication and division value of 2 numbers " 
        + number1 + " and " + number2 + " is " 
        + add + ", " + sub + ", " + mul + ", and " + div);
    }
}
