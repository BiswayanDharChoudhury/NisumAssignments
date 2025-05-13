import java.util.*;

// Base class representing a generic vehicle
class Vehicle {
    String brand;
    int price;

    // Method to set brand and price of the vehicle
    public void setBasicInfo(String brand, int price) {
        this.brand = brand;
        this.price = price;
    }

    // Method to display brand and price
    public void displayBasicInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Price: ₹" + price);
    }
}

// Car class inherits from Vehicle and adds a model field
class Car extends Vehicle {
    int modelYear;

    // Method to set complete info for a car
    public void setCarDetails(String brand, int price, int modelYear) {
        setBasicInfo(brand, price);
        this.modelYear = modelYear;
    }

    // Method to display car-specific information
    public void showCarDetails() {
        displayBasicInfo();
        System.out.println("Model Year: " + modelYear);
    }
}

// Bus class inherits from Vehicle and adds number of window glasses
class Bus extends Vehicle {
    int windowGlassCount;

    // Method to set complete info for a bus
    public void setBusDetails(String brand, int price, int windowGlassCount) {
        setBasicInfo(brand, price);
        this.windowGlassCount = windowGlassCount;
    }

    // Method to display bus-specific information
    public void showBusDetails() {
        displayBasicInfo();
        System.out.println("Number of Windows: " + windowGlassCount);
    }
}

// Main class with the program entry point
public class q14 {
    public static void main(String[] args) {
        // Create a Car object and set its details
        Car myCar = new Car();
        myCar.setCarDetails("Toyota", 1000000, 2022);

        System.out.println("========== CAR DETAILS ==========");
        myCar.showCarDetails();

        System.out.println();

        // Create a Bus object and set its details
        Bus myBus = new Bus();
        myBus.setBusDetails("Volvo", 3000000, 20);

        System.out.println("========== BUS DETAILS ==========");
        myBus.showBusDetails();
    }
}
