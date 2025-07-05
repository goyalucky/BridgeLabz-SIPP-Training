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
        return fuelType.equalsIgnoreCase("Petrol") ? 5000 : 7000;
    }

    void printServiceDetails() {
        System.out.println("Car: " + brand + " " + model);
        System.out.println("Fuel: " + fuelType);
        System.out.println("Service Cost: ₹" + calculateServiceCost());
    }
}

class Bike extends Vehicle {
    Bike(String brand, String model, String fuelType) {
        super(brand, model, fuelType);
    }

    double calculateServiceCost() {
        return fuelType.equalsIgnoreCase("Petrol") ? 1500 : 2000;
    }

    void printServiceDetails() {
        System.out.println("Bike: " + brand + " " + model);
        System.out.println("Fuel: " + fuelType);
        System.out.println("Service Cost: ₹" + calculateServiceCost());
    }
}

class Truck extends Vehicle {
    Truck(String brand, String model, String fuelType) {
        super(brand, model, fuelType);
    }

    double calculateServiceCost() {
        return fuelType.equalsIgnoreCase("Diesel") ? 10000 : 12000;
    }

    void printServiceDetails() {
        System.out.println("Truck: " + brand + " " + model);
        System.out.println("Fuel: " + fuelType);
        System.out.println("Service Cost: ₹" + calculateServiceCost());
    }
}

public class GarageManagement {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Car("Honda", "City", "Petrol");
        vehicles[1] = new Bike("Yamaha", "R15", "Petrol");
        vehicles[2] = new Truck("Tata", "407", "Diesel");

        for (Vehicle v : vehicles) {
            v.printServiceDetails();
            System.out.println();
        }
    }
}
