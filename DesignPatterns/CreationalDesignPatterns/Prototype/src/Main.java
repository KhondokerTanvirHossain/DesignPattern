package DesignPatterns.CreationalDesignPatterns.Prototype.src;

import java.util.ArrayList;
import java.util.List;


abstract class Shape {
    int X;
    int Y;
    String color;

    Shape() {
        // ...
    }

    Shape(Shape source) {
        this.X = source.X;
        this.Y = source.Y;
        this.color = source.color;
    }

    abstract Shape clone();

    @Override
    public String toString() {
        return "Shape{" +
                "X=" + X +
                ", Y=" + Y +
                ", color='" + color + '\'' +
                '}';
    }
}

class Rectangle extends Shape {
    int width;
    int height;

    Rectangle() {
        // ...
    }

    Rectangle(Rectangle source) {
        super(source);
        this.width = source.width;
        this.height = source.height;
    }

    @Override
    Shape clone() {
        return new Rectangle(this);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "X=" + X +
                ", Y=" + Y +
                ", color='" + color + '\'' +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}

class Circle extends Shape {
    int radius;

    Circle() {
        // ...
    }

    Circle(Circle source) {
        super(source);
        this.radius = source.radius;
    }

    @Override
    Shape clone() {
        return new Circle(this);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "X=" + X +
                ", Y=" + Y +
                ", color='" + color + '\'' +
                ", radius=" + radius +
                '}';
    }
}

class Application {
    ArrayList<Shape> shapes = new ArrayList<>();

    Application() {
        Circle circle = new Circle();
        circle.X = 10;
        circle.Y = 10;
        circle.radius = 20;
        shapes.add(circle);

        Circle anotherCircle = (Circle) circle.clone();
        shapes.add(anotherCircle);

        Rectangle rectangle = new Rectangle();
        rectangle.width = 10;
        rectangle.height = 20;
        shapes.add(rectangle);
    }

    void businessLogic() {
        ArrayList<Shape> shapesCopy = new ArrayList<>();

        for (Shape s : shapes) {
            shapesCopy.add(s.clone());
        }

        for (Shape s : shapesCopy) {
            System.out.println(s);
        }

        // shapesCopy now contains exact copies of the shape array's children
    }
}

public class Main {
    public static void main(String[] args) {
        Application app = new Application();
        app.businessLogic();
    }
}
