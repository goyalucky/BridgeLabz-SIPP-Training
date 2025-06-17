package Assignments.MethodPractices.Level2;

public class UnitConverter {
    public static double convertKmToMiles(double km) {
        double km2miles = 0.621371;
        return km * km2miles;
    }
    public static double convertMilesToKm(double miles) {
        double miles2km = 1.60934;
        return miles * miles2km;
    }
    public static double convertMetersToFeet(double meters) {
        double meters2feet = 3.28084;
        return meters * meters2feet;
    }
    public static double convertFeetToMeters(double feet) {
        double feet2meters = 0.3048;
        return feet * feet2meters;
    }
    public static void main(String[] args) {
        double km = 5.0;
        double miles = 3.0;
        double meters = 10.0;
        double feet = 30.0;

        System.out.println(km + " Km = " + convertKmToMiles(km) + " Miles");
        System.out.println(miles + " Miles = " + convertMilesToKm(miles) + " Km");
        System.out.println(meters + " Meters = " + convertMetersToFeet(meters) + " Feet");
        System.out.println(feet + " Feet = " + convertFeetToMeters(feet) + " Meters");
    }
}
