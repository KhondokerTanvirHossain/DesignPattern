package OOP.Inheritance.src;

interface FourLegged {
    void walk();
}

interface OxygenBreather {
    void breathe();
}

class Animal implements FourLegged, OxygenBreather {
    @Override
    public void walk() {
        System.out.println("Animal is walking on four legs.");
    }

    @Override
    public void breathe() {
        System.out.println("Animal is breathing oxygen.");
    }
}

class Cat extends Animal {
    @Override
    public void walk() {
        System.out.println("Cat is walking on four legs.");
    }

    @Override
    public void breathe() {
        System.out.println("Cat is breathing oxygen.");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal cat = new Cat();
        cat.walk();
        cat.breathe();
    }
}