# Design Patterns in Java

In software engineering, a design pattern is a general repeatable solution to a commonly occurring problem in software design. A design pattern isn't a finished design that can be transformed directly into code. It is a description or template for how to solve a problem that can be used in many different situations.

## Uses of Design Patterns

Design patterns can speed up the development process by providing tested, proven development paradigms. Effective software design requires considering issues that may not become visible until later in the implementation. Reusing design patterns helps to prevent subtle issues that can cause major problems and improves code readability for coders and architects familiar with the patterns.

Design patterns provide general solutions, documented in a format that doesn't require specifics tied to a particular problem. In addition, patterns allow developers to communicate using well-known, well understood names for software interactions. Common design patterns can be improved over time, making them more robust than ad-hoc designs.

This repository contains examples of design patterns implemented in Java. Each folder in the repository represents a different design pattern. Inside each folder, you'll find a Java implementation of the pattern and a `README.md` file explaining the pattern.

## Object-Oriented Programming (OOP)

Object-Oriented Programming (OOP) is a programming paradigm based on the concept of "objects", which can contain data and code: data in the form of fields (often known as attributes or properties), and code, in the form of procedures (often known as methods).

This repository also includes examples of OOP concepts implemented in Java. You can find these examples in the `OOP` folder. The OOP concepts covered include:

- [Polymorphism](./OOP/Polymorphism)
- [Encapsulation](./OOP/Encapsulation)
- [Inheritance](./OOP/Inheritance)
- [Abstraction](./OOP/Abstraction)
- [Relations](./OOP/Relations)

## Design Principles

Design principles guide us to design our software so that it is easy to understand, maintain, and enhance. Here are some key principles with examples:

- [Encapsulate What Varies](./DesignPrinciples/EncapsulateWhatVaries)
- [Program to an Interface, not an Implementation](./DesignPrinciples/ProgramToAnInterface)
- [Favor Composition Over Inheritance](./DesignPrinciples/FavorCompositionOverInheritance)

## SOLID Principles

SOLID is an acronym for the first five object-oriented design principles by Robert C. Martin. These principles make it easier to develop software that is easy to maintain, understand, and extend. Here are the SOLID principles with examples:

- [Single Responsibility Principle](./SOLID/SingleResponsibility)
- [Open/Closed Principle](./SOLID/OpenClosed)
- [Liskov Substitution Principle](./SOLID/LiskovSubstitution)
- [Interface Segregation Principle](./SOLID/InterfaceSegregation)
- [Dependency Inversion Principle](./SOLID/DependencyInversion)

## Design Patterns

The patterns are divided into three categories: Creational, Structural, and Behavioral.

### Creational Design Patterns

These design patterns are all about class instantiation. This pattern can be further divided into class-creation patterns and object-creational patterns. While class-creation patterns use inheritance effectively in the instantiation process, object-creation patterns use delegation effectively to get the job done.

- [Abstract Factory](./AbstractFactory)
- [Builder](./Builder)
- [Factory Method](./FactoryMethod)
- [Object Pool](./ObjectPool)
- [Prototype](./Prototype)
- [Singleton](./Singleton)

### Structural Design Patterns

These design patterns are all about Class and Object composition. Structural class-creation patterns use inheritance to compose interfaces. Structural object-patterns define ways to compose objects to obtain new functionality.

- [Adapter](./Adapter)
- [Bridge](./Bridge)
- [Composite](./Composite)
- [Decorator](./Decorator)
- [Facade](./Facade)
- [Flyweight](./Flyweight)
- [Private Class Data](./PrivateClassData)
- [Proxy](./Proxy)

### Behavioral Design Patterns

These design patterns are all about Class's objects communication. Behavioral patterns are those patterns that are most specifically concerned with communication between objects.

- [Chain of responsibility](./ChainOfResponsibility)
- [Command](./Command)
- [Interpreter](./Interpreter)
- [Iterator](./Iterator)
- [Mediator](./Mediator)
- [Memento](./Memento)
- [Null Object](./NullObject)
- [Observer](./Observer)
- [State](./State)
- [Strategy](./Strategy)
- [Template method](./TemplateMethod)
- [Visitor](./Visitor)

## Criticism

The concept of design patterns has been criticized by some in the field of computer science. The criticisms include targeting the wrong problem, lacking formal foundations, leading to inefficient solutions, and not differing significantly from other abstractions.

## Usage

To run the examples, navigate to the directory of the pattern you want to explore and compile the Java files.

```bash
cd strategy/src
javac *.java
java Main
```

## Contributing

Contributions are welcome. Please open an issue or submit a pull request.

## License

MIT