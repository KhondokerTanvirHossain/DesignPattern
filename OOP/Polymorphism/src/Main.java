package OOP.Polymorphism.src;

class Animal {
    void makeSound() {
        System.out.println("The animal makes a sound");
    }

    // Method overloading in the Animal class
    void eat(String food) {
        System.out.println("The animal eats " + food);
    }

    void eat(String food, int quantity) {
        System.out.println("The animal eats " + quantity + " units of " + food);
    }
}

class Cat extends Animal {
    // Method overriding in the Cat class
    @Override
    void makeSound() {
        System.out.println("The cat meows");
    }
}

class Dog extends Animal {
    // Method overriding in the Dog class
    @Override
    void makeSound() {
        System.out.println("The dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myAnimal = new Animal();
        Animal myCat = new Cat();
        Animal myDog = new Dog();

        myAnimal.makeSound();  // Outputs "The animal makes a sound"
        myCat.makeSound();     // Outputs "The cat meows"
        myDog.makeSound();     // Outputs "The dog barks"

        myAnimal.eat("food");  // Outputs "The animal eats food"
        myAnimal.eat("food", 2);  // Outputs "The animal eats 2 units of food"
    }
}
