interface Sensitive {}
class UserData implements Sensitive {
    String info = "Secret";
}
public class SensitiveTest {
    public static void main(String[] args) {
        UserData u = new UserData();
        if (u instanceof Sensitive) System.out.println("Data is sensitive");
    }
}
