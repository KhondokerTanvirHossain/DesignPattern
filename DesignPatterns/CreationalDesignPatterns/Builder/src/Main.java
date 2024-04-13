class Car {
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

class Manual {
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
        return "Manual [seats=" + seats + ", engine=" + engine + ", hasTripComputer=" + hasTripComputer
                + ", hasGPS=" + hasGPS + "]";
    }
}

// Builder interface
interface Builder {
    void reset();
    void setSeats(int number);
    void setEngine(Engine engine);
    void setTripComputer(boolean hasTripComputer);
    void setGPS(boolean hasGPS);
}

// Director

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
class CarBuilder implements Builder {
    private Car car;

    public CarBuilder() {
        this.reset();
    }

    public void reset() {
        this.car = new Car();
    }

    public void setSeats(int number) {
        car.setSeats(number);
    }

    public void setEngine(Engine engine) {
        if (engine == null) {
            throw new IllegalArgumentException("Engine cannot be null");
        }
        car.setEngine(engine);
    }

    public void setTripComputer(boolean hasTripComputer) {
        car.setTripComputer(hasTripComputer);
    }

    public void setGPS(boolean hasGPS) {
        car.setGPS(hasGPS);
    }

    public Car getProduct() {
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

    public void setSeats(int number) {
        manual.setSeats(number);
    }

    public void setEngine(Engine engine) {
        if (engine == null) {
            throw new IllegalArgumentException("Engine cannot be null");
        }
        manual.setEngine(engine);
    }

    public void setTripComputer(boolean hasTripComputer) {
        manual.setTripComputer(hasTripComputer);
    }

    public void setGPS(boolean hasGPS) {
        manual.setGPS(hasGPS);
    }

    public Manual getProduct() {
        Manual product = this.manual;
        this.reset();
        return product;
    }
}

class Director {
    public void setBuilder(Builder builder) {
    }

    public void constructSportsCar(Builder builder) {
        builder.reset();
        builder.setSeats(2);
        builder.setEngine(new SportEngine());
        builder.setTripComputer(true);
        builder.setGPS(true);
    }

    public void constructSUV(Builder builder) {
        // ...
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        Director director = new Director();

        // Building a car
        CarBuilder carBuilder = new CarBuilder();
        director.constructSportsCar(carBuilder);
        Car car = carBuilder.getProduct();
        System.out.println("Car built: " + car.toString());

        // Building a manual
        CarManualBuilder manualBuilder = new CarManualBuilder();
        director.constructSportsCar(manualBuilder);
        Manual manual = manualBuilder.getProduct();
        System.out.println("Manual built: " + manual.toString());
    }
}