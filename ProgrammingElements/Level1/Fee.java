public class Fee {
    public static void main(String[] args) {
        double fee = 125000;
        double discountPercent = 10;
        double discount = (fee * discountPercent) / 100;
        double discountedPrice = fee - discount;
        System.out.println("The discount amount is INR " + discount + "and final discounted fee is INR" + discountedPrice);
    }
}


