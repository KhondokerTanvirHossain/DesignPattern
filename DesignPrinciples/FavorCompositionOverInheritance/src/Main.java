package DesignPrinciples.FavorCompositionOverInheritance.src;

// BEFORE: Using inheritance
/*
class Transport {
    void deliver() {}
}

class Truck extends Transport {}
class Car extends Transport {}

class ElectricTruck extends Truck {}
class CombustionEngineTruck extends Truck {}

class AutopilotElectricTruck extends ElectricTruck {}
class AutopilotCombustionEngineTruck extends CombustionEngineTruck {}

class ElectricCar extends Car {}
class CombustionEngineCar extends Car {}

class AutopilotElectricCar extends ElectricCar {}
class AutopilotCombustionEngineCar extends CombustionEngineCar {}
*/

// AFTER: Using composition and aggregation
interface Engine {
    void move();
}

interface Driver {
    void navigate();
}

class CombustionEngine implements Engine {
    public void move() {
        System.out.println("Combustion engine is moving the vehicle.");
    }
}

class ElectricEngine implements Engine {
    public void move() {
        System.out.println("Electric engine is moving the vehicle.");
    }
}

class Human implements Driver {
    public void navigate() {
        System.out.println("Human is navigating the vehicle.");
    }
}

class Robot implements Driver {
    public void navigate() {
        System.out.println("Robot is navigating the vehicle.");
    }
}

class Transport {
    private Engine engine;
    private Driver driver;

    Transport(Engine engine, Driver driver) {
        this.engine = engine;
        this.driver = driver;
    }

    void deliver(String destination, String cargo) {
        System.out.println("Starting delivery of " + cargo + " to " + destination);
        driver.navigate();
        engine.move();
        System.out.println("Delivered " + cargo + " to " + destination);
    }
}


public class Main {
    public static void main(String[] args) {
        Transport truck = new Transport(new CombustionEngine(), new Human());
        Transport car = new Transport(new ElectricEngine(), new Robot());

        truck.deliver("Destination A", "Cargo A");
        car.deliver("Destination B", "Cargo B");
    }
}