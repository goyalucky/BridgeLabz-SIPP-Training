public class Vol {
    public static void main(String[] args) {
        double radiusKm = 6378.0; 
        double pi = Math.PI;
        double volKm3 = (4.0 / 3.0) * pi * Math.pow(radiusKm, 3);
        double conversionFactor = 0.23;
        double volumeMiles3 = volKm3 * conversionFactor;
        System.out.println("The volume of Earth in cubic kilometers is"+volKm3+" and cubic miles is "+ volumeMiles3);
    }
}

