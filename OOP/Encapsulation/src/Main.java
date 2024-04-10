package OOP.Encapsulation.src;

interface FlyingTransport {
    void fly(String origin, String destination, int passengers);
}

class Airplane implements FlyingTransport {
    @Override
    public void fly(String origin, String destination, int passengers) {
        System.out.println("Airplane flying from " + origin + " to " + destination + " with " + passengers + " passengers.");
    }
}

class Helicopter implements FlyingTransport {
    @Override
    public void fly(String origin, String destination, int passengers) {
        System.out.println("Helicopter flying from " + origin + " to " + destination + " with " + passengers + " passengers.");
    }
}

class DomesticatedGryphon implements FlyingTransport {
    @Override
    public void fly(String origin, String destination, int passengers) {
        System.out.println("Domesticated Gryphon flying from " + origin + " to " + destination + " with " + passengers + " passengers.");
    }
}

class Airport {
    void acceptFlyingTransport(FlyingTransport transport) {
        transport.fly("Origin", "Destination", 100);
    }
}

public class Main {
    public static void main(String[] args) {
        Airport airport = new Airport();
        airport.acceptFlyingTransport(new Airplane());
        airport.acceptFlyingTransport(new Helicopter());
        airport.acceptFlyingTransport(new DomesticatedGryphon());
    }
}