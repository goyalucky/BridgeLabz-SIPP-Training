public class Profit {
    public static void main(String[] args) {
        int cp = 129;
        int sp = 191;
        int profit = sp - cp;
        int per = (profit * 100) / cp;
        System.out.println("The Cost Price is INR 129 and Selling Price is INR 191");
        System.out.println("The Profit is INR " + profit + "and the Profit Percentage is "+ per);
    }
}
