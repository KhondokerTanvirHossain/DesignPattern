package Bonus;

class Transport {}

class Car extends Transport {
    private int seats;
    private Engine engine;
    private boolean hasTripComputer;
    private boolean hasGPS;

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setTripComputer(boolean hasTripComputer) {
        this.hasTripComputer = hasTripComputer;
    }

    public void setGPS(boolean hasGPS) {
        this.hasGPS = hasGPS;
    }

    @Override
    public String toString() {
        return "Car [seats=" + seats + ", engine=" + engine.getType() + ", hasTripComputer=" + hasTripComputer
                + ", hasGPS=" + hasGPS + "]";
    }
}

class Manual extends Transport {
    private int seats;
    private String engine;
    private boolean hasTripComputer;
    private boolean hasGPS;

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setTripComputer(boolean hasTripComputer) {
        this.hasTripComputer = hasTripComputer;
    }

    public void setGPS(boolean hasGPS) {
        this.hasGPS = hasGPS;
    }

    @Override
    public String toString() {
        return "Manual [seats=" + seats + ", engine=" + engine + ", hasTripComputer=" + hasTripComputer
                + ", hasGPS=" + hasGPS + "]";
    }
}

interface Engine {
    String getType();
}

class SportEngine implements Engine {
    private String type;

    public SportEngine() {
        this.type = "Sport";
    }

    @Override
    public String getType() {
        return this.type;
    }
}

// Builder interface
interface Builder {
    void reset();
    Builder Seats(int number);
    Builder Engine(Engine engine);
    Builder TripComputer(boolean hasTripComputer);
    Builder GPS(boolean hasGPS);
    Transport build();
}

class CarBuilder implements Builder {
    private Car car;

    public CarBuilder() {
        this.reset();
    }

    public void reset() {
        this.car = new Car();
    }

    public Builder Seats(int number) {
        car.setSeats(number);
        return this;
    }

    public Builder Engine(Engine engine) {
        if (engine == null) {
            throw new IllegalArgumentException("Engine cannot be null");
        }
        car.setEngine(engine);
        return this;
    }

    public Builder TripComputer(boolean hasTripComputer) {
        car.setTripComputer(hasTripComputer);
        return this;
    }

    public Builder GPS(boolean hasGPS) {
        car.setGPS(hasGPS);
        return this;
    }

    public Car build() {
        Car product = this.car;
        this.reset();
        return product;
    }
}

class CarManualBuilder implements Builder {
    private Manual manual;

    public CarManualBuilder() {
        this.reset();
    }

    public void reset() {
        this.manual = new Manual();
    }

    public Builder Seats(int number) {
        manual.setSeats(number);
        return this;
    }

    public Builder Engine(Engine engine) {
        if (engine == null) {
            throw new IllegalArgumentException("Engine cannot be null");
        }
        manual.setEngine(engine.getType());
        return this;
    }

    public Builder TripComputer(boolean hasTripComputer) {
        manual.setTripComputer(hasTripComputer);
        return this;
    }

    public Builder GPS(boolean hasGPS) {
        manual.setGPS(hasGPS);
        return this;
    }

    public Manual build() {
        Manual product = this.manual;
        this.reset();
        return product;
    }
}

// Client code
public class Main {
    public static void main(String[] args) {

        // Building a car
        Transport car = new CarBuilder()
            .Seats(2)
            .Engine(new SportEngine())
            .TripComputer(true)
            .GPS(true)
            .build();
        System.out.println("Car built: " + car.toString());

        Transport manual = new CarManualBuilder()
            .Seats(2)
            .Engine(new SportEngine())
            .TripComputer(true)
            .GPS(true)
            .build();
        System.out.println("Manual built: " + manual.toString());
    }
}