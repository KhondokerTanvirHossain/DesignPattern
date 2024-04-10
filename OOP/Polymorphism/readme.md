### Polymorphism

Polymorphism is a principle in OOP that allows objects of different types to be treated as objects of a parent type. It's like taking an animal from a bag - we don't know for sure what it is. However, if we cuddle it hard enough, the animal will emit a specific sound of joy, depending on its concrete class.

The program doesn't know the concrete type of the object contained inside the `a` variable; but, thanks to the special mechanism called polymorphism, the program can trace down the subclass of the object whose method is being executed and run the appropriate behavior.

Polymorphism is the ability of a program to detect the real class of an object and call its implementation even when its real type is unknown in the current context. You can also think of polymorphism as the ability of an object to "pretend" to be something else, usually a class it extends or an interface it implements. In our example, the dogs and cats in the bag were pretending to be generic animals.

```java
Animal[] bag = {new Cat(), new Dog()};

for (Animal a : bag) {
    a.makeSound();
}

// Output:
// Meow!
// Woof!
```
