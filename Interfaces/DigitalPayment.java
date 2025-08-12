interface Payment {
    void pay();
}
class UPI implements Payment {
    public void pay() { System.out.println("Paid via UPI"); }
}
class CreditCard implements Payment {
    public void pay() { System.out.println("Paid via Credit Card"); }
}
public class DigitalPayment {
    public static void main(String[] args) {
        Payment p = new UPI();
        p.pay();
        p = new CreditCard();
        p.pay();
    }
}
