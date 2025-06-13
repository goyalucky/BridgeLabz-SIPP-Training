import java.util.*;
public class QandR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();
        int que = number1/number2;
        int rem = number1%number2;
        System.out.println(" The Quotient is"+ que + "and Reminder is"+rem+ "of two number "+ number1+ "and "+ number2);
    }
}
