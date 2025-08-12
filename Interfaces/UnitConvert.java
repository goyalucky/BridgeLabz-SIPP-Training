interface Converter {
    static double kmToMiles(double km) { return km * 0.621371; }
    static double kgToLbs(double kg) { return kg * 2.20462; }
}
public class UnitConvert {
    public static void main(String[] args) {
        System.out.println(Converter.kmToMiles(5));
        System.out.println(Converter.kgToLbs(10));
    }
}
