import java.util.function.Predicate;
public class TempAlert {
    public static void main(String[] args) {
        Predicate<Double> highTemp = t -> t > 30;
        System.out.println(highTemp.test(35.0));
    }
}
