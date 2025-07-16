import java.util.*;

abstract class Vehicle {
    String brand;
    String model;
    String fuelType;

    Vehicle(String brand, String model, String fuelType) {
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
    }

    abstract double calculateServiceCost();
    abstract void printServiceDetails();
}

class Car extends Vehicle {
    Car(String brand, String model, String fuelType) {
        super(brand, model, fuelType);
    }

    double calculateServiceCost() {
        return 5000;
    }

    void printServiceDetails() {
        System.out.println("Car Service -> " + brand + " " + model + ", Fuel: " + fuelType + ", Cost: ₹" + calculateServiceCost());
    }
}

class Bike extends Vehicle {
    Bike(String brand, String model, String fuelType) {
        super(brand, model, fuelType);
    }

    double calculateServiceCost() {
        return 1500;
    }

    void printServiceDetails() {
        System.out.println("Bike Service -> " + brand + " " + model + ", Fuel: " + fuelType + ", Cost: ₹" + calculateServiceCost());
    }
}

class Truck extends Vehicle {
    Truck(String brand, String model, String fuelType) {
        super(brand, model, fuelType);
    }

    double calculateServiceCost() {
        return 10000;
    }

    void printServiceDetails() {
        System.out.println("Truck Service -> " + brand + " " + model + ", Fuel: " + fuelType + ", Cost: ₹" + calculateServiceCost());
    }
}

public class VehicleManagement {
    public static void main(String[] args) {
        List<Vehicle> garage = new ArrayList<>();
        garage.add(new Car("Toyota", "Fortuner", "Diesel"));
        garage.add(new Bike("Honda", "Shine", "Petrol"));
        garage.add(new Truck("Tata", "LPT", "Diesel"));

        for (Vehicle v : garage) {
            v.printServiceDetails();
        }
    }
}
