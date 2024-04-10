package OOP.Abstraction.src;

abstract class Airplane {
    protected int speed;
    protected int altitude;
    protected double rollAngle;
    protected double pitchAngle;
    protected double yawAngle;

    abstract void fly();

    // Method to reverse the seat number
    abstract int reverseSeat(int n);
}

class FlightSimulatorAirplane extends Airplane {
    @Override
    void fly() {
        // Implementation of fly method for flight simulator
    }

    @Override
    int reverseSeat(int n) {
        // In flight simulator, we might not care about seat number
        return 0;
    }
}

class FlightBookingAirplane extends Airplane {
    private int[] seatMap;

    @Override
    void fly() {
        // In flight booking, we might not care about flying
    }

    @Override
    int reverseSeat(int n) {
        // Reverse the seat number in flight booking
        return seatMap.length - n;
    }
}

public class Main {
    public static void main(String[] args) {
        FlightBookingAirplane airplane = new FlightBookingAirplane();
        int reversedSeat = airplane.reverseSeat(5);
        System.out.println("Reversed seat number is: " + reversedSeat);
    }
}
