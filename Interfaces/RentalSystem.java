interface Vehicle {
    void rent();
    void returnVehicle();
}
class Car implements Vehicle {
    public void rent() { System.out.println("Car Rented"); }
    public void returnVehicle() { System.out.println("Car Returned"); }
}
class Bike implements Vehicle {
    public void rent() { System.out.println("Bike Rented"); }
    public void returnVehicle() { System.out.println("Bike Returned"); }
}
public class RentalSystem {
    public static void main(String[] args) {
        Vehicle v = new Car();
        v.rent(); v.returnVehicle();
        v = new Bike();
        v.rent(); v.returnVehicle();
    }
}
