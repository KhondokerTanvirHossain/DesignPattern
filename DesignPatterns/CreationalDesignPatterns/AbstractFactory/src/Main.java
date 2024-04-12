package DesignPatterns.CreationalDesignPatterns.AbstractFactory.src;

// Step 2: Define abstract product interfaces
interface Chair {
    void sitOn();
}

interface Sofa {
    void lieOn();
}

// Concrete product classes implementing these interfaces
class ModernChair implements Chair {
    public void sitOn() {
        System.out.println("Sitting on a modern chair");
    }
}

class VictorianSofa implements Sofa {
    public void lieOn() {
        System.out.println("Lying on a victorian sofa");
    }
}

// Step 3: Define the abstract factory interface
interface FurnitureFactory {
    Chair createChair();
    Sofa createSofa();
}

// Step 4: Implement concrete factory classes
class ModernFurnitureFactory implements FurnitureFactory {
    public Chair createChair() {
        return new ModernChair();
    }

    public Sofa createSofa() {
        return new VictorianSofa();
    }
}

// Step 5: Factory initialization code in the app
class Application {
    private Chair chair;
    private Sofa sofa;

    public Application(FurnitureFactory factory) {
        chair = factory.createChair();
        sofa = factory.createSofa();
    }

    public void useFurniture() {
        chair.sitOn();
        sofa.lieOn();
    }
}

// Step 6: Replace direct calls to product constructors with calls to the factory object
public class Main {
    public static void main(String[] args) {
        FurnitureFactory factory = new ModernFurnitureFactory();
        Application app = new Application(factory);
        app.useFurniture();
    }
}