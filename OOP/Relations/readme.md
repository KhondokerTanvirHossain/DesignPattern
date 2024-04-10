# Relations Between Objects

In addition to inheritance and implementation, there are other types of relations between objects:

## Dependency

Dependency is the most basic and the weakest type of relations between classes. There is a dependency between two classes if some changes to the definition of one class might result in modifications to another class. Dependency typically occurs when you use concrete class names in your code.

## Association

Association is a relationship in which one object uses or interacts with another. In UML diagrams, the association relationship is shown by a simple arrow drawn from an object and pointing to the object it uses. Association can be seen as a specialized kind of dependency, where an object always has access to the objects with which it interacts.

## Aggregation

Aggregation is a specialized type of association that represents “one-to-many”, “many-to-many” or “whole-part” relations between multiple objects. Usually, under aggregation, an object “has” a set of other objects and serves as a container or collection.

## Composition

Composition is a specific kind of aggregation, where one object is composed of one or more instances of the other. The distinction between this relation and others is that the component can only exist as a part of the container.

## Implementation

Implementation is when a class defines methods declared in an interface. Objects of the class can be treated as objects of the interface.
