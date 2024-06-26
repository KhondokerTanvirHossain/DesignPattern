# Abstraction

Abstraction is a key concept in Object-Oriented Programming. It's the process of hiding the implementation details and showing only the functionality to the users. In other words, it deals with the outside view of an object (interface).

Most of the time when you’re creating a program with OOP, you shape objects of the program based on real-world objects. However, objects of the program don’t represent the originals with 100% accuracy (and it’s rarely required that they do). Instead, your objects only model attributes and behaviors of real objects in a specific context, ignoring the rest.

For example, an `Airplane` class could probably exist in both a flight simulator and a flight booking application. But in the former case, it would hold details related to the actual flight, whereas in the latter class you would care only about the seat map and which seats are available.

![alt text](image.png)

```java
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
```

Abstraction is a model of a real-world object or phenomenon, limited to a specific context, which represents all details relevant to this context with high accuracy and omits all the rest. This allows us to reduce complexity by splitting our system into smaller parts.
