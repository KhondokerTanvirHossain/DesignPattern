package DesignPatterns.BehavioralDesignPatterns.Visitor.src;

interface Shape {
    void move(int x, int y);
    void draw();
    void accept(Visitor v);
}

class Dot implements Shape {
    public void move(int x, int y) {
        System.out.println("Dot moved to " + x + ", " + y);
    }

    public void draw() {
        System.out.println("Dot drawn.");
    }

    public void accept(Visitor v) {
        v.visitDot(this);
    }
}

class Circle implements Shape {
    public void move(int x, int y) {
        System.out.println("Circle moved to " + x + ", " + y);
    }

    public void draw() {
        System.out.println("Circle drawn.");
    }

    public void accept(Visitor v) {
        v.visitCircle(this);
    }
}

class Rectangle implements Shape {
    public void move(int x, int y) {
        System.out.println("Rectangle moved to " + x + ", " + y);
    }

    public void draw() {
        System.out.println("Rectangle drawn.");
    }

    public void accept(Visitor v) {
        v.visitRectangle(this);
    }
}

class CompoundShape implements Shape {
    public void move(int x, int y) {
        System.out.println("CompoundShape moved to " + x + ", " + y);
    }

    public void draw() {
        System.out.println("CompoundShape drawn.");
    }

    public void accept(Visitor v) {
        v.visitCompoundShape(this);
    }
}

interface Visitor {
    void visitDot(Dot d);
    void visitCircle(Circle c);
    void visitRectangle(Rectangle r);
    void visitCompoundShape(CompoundShape cs);
}

class XMLExportVisitor implements Visitor {
    public void visitDot(Dot d) {
        System.out.println("Exporting the dot's details in XML format.");
    }

    public void visitCircle(Circle c) {
        System.out.println("Exporting the circle's details in XML format.");
    }

    public void visitRectangle(Rectangle r) {
        System.out.println("Exporting the rectangle's details in XML format.");
    }

    public void visitCompoundShape(CompoundShape cs) {
        System.out.println("Exporting the CompoundShape's details in XML format.");
    }
}

class Application {
    Shape[] allShapes;

    void export() {
        XMLExportVisitor xmlExportVisitor = new XMLExportVisitor();
        for (Shape shape : allShapes) {
            shape.accept(xmlExportVisitor);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Application app = new Application();
        app.allShapes = new Shape[]{new Dot(), new Circle(), new Rectangle(), new CompoundShape()};
        app.export();
    }
}
