import java.util.*;
class main{
    public static void main(String[] args) {
         double fee;
        double discountPercent;
        double discountAmount, finalFee;

        Scanner input = new Scanner(System.in);
        fee = input.nextDouble();
        discountPercent = input.nextDouble();

        discountAmount = (fee * discountPercent) / 100;
        finalFee = fee - discountAmount;
        System.out.println("The discount amount is INR" + discountAmount + "and final discounted fee is INR" + finalFee);
    }
}
