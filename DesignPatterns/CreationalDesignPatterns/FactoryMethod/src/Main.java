package DesignPatterns.CreationalDesignPatterns.FactoryMethod.src;

// Step 1: Common product interface
interface Product {
    void use();
}

// Step 2: Concrete Products
class ConcreteProductA implements Product {
    public void use() {
        System.out.println("Using product A");
    }
}

class ConcreteProductB implements Product {
    public void use() {
        System.out.println("Using product B");
    }
}

// Step 3: Creator class with factory method
abstract class Creator {
    public void someOperation() {
        Product product = factoryMethod();
        product.use();
    }

    protected abstract Product factoryMethod();
}

// Step 4: Concrete Creators
class ConcreteCreatorA extends Creator {
    protected Product factoryMethod() {
        return new ConcreteProductA();
    }
}

class ConcreteCreatorB extends Creator {
    protected Product factoryMethod() {
        return new ConcreteProductB();
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        Creator creatorA = new ConcreteCreatorA();
        creatorA.someOperation();

        Creator creatorB = new ConcreteCreatorB();
        creatorB.someOperation();
    }
}