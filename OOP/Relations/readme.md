# Relations Between Objects

In addition to inheritance and implementation, there are other types of relations between objects:

## Dependency

![alt text](image.png)

Dependency is the most basic and the weakest type of relations between classes. There is a dependency between two classes if some changes to the definition of one class might result in modifications to another class. Dependency typically occurs when you use concrete class names in your code.

## Association

![alt text](image-1.png)

Association is a relationship in which one object uses or interacts with another. In UML diagrams, the association relationship is shown by a simple arrow drawn from an object and pointing to the object it uses. Association can be seen as a specialized kind of dependency, where an object always has access to the objects with which it interacts.

```java
class Professor {
    Student student; // Association (& Dependency) between Professor and Student
    // ...

    void teach(Course c) { // Dependecy between Professor and Course
        // ...
        this.student.remember(c.getKnowledge());
    }
}
```

The `teach` method in the `Professor` class takes a `Course` object as an argument and uses its `getKnowledge` method. Any changes to `getKnowledge` could break the `Professor` class, creating a dependency. 

The `student` field in the `Professor` class represents an association with the `Student` class, as it's accessible to all `Professor` methods. However, if the `remember` method in `Student` changes, it could also break the `Professor` class, making `Student` both a dependency and an association.

## Aggregation

![alt text](image-2.png)

Aggregation is a specialized type of association that represents “one-to-many”, “many-to-many” or “whole-part” relations between multiple objects. Usually, under aggregation, an object “has” a set of other objects and serves as a container or collection.

## Composition

![alt text](image-3.png)

Composition is a specific kind of aggregation, where one object is composed of one or more instances of the other. The distinction between this relation and others is that the component can only exist as a part of the container.

Now that we've explored the various types of relationships between objects, let's examine how they all interconnect. This understanding will help clarify questions such as "What is the difference between aggregation and composition?" or "Is inheritance a type of dependency?"

- **Dependency**: Class A may be affected by changes in Class B.
- **Association**: Object A is aware of Object B. Class A depends on Class B.
- **Aggregation**: Object A is aware of Object B and consists of B. Class A depends on Class B.
- **Composition**: Object A is aware of Object B, consists of B, and manages B's lifecycle. Class A depends on Class B.
- **Implementation**: Class A defines methods declared in Interface B. Objects of Class A can be treated as objects of Interface B. Class A depends on Interface B.
- **Inheritance**: Class A inherits the interface and implementation of Class B but can extend it. Objects of Class A can be treated as objects of Class B. Class A depends on Class B.

![alt text](image-4.png)

These relationships between objects and classes range from the weakest (dependency) to the strongest (inheritance).
