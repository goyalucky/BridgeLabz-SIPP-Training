import java.util.*;
public class Area {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double base = sc.nextDouble();
        double height = sc.nextDouble();
        double areaCm = 0.5 * base * height;
        double areaInches = areaCm / (2.54 * 2.54);
        System.out.println("The Area of the triangle in sq in is" +areaInches + "and sq cm is" + areaCm);
    }
}
