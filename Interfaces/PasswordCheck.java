interface SecurityUtils {
    static boolean isStrong(String p) {
        return p.length() >= 8 && p.matches(".*[A-Z].*") && p.matches(".*[0-9].*");
    }
}
public class PasswordCheck {
    public static void main(String[] args) {
        System.out.println(SecurityUtils.isStrong("Test1234"));
    }
}
