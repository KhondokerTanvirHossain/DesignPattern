public abstract class Decorator implements Shape{

    protected Shape decoratedShape;

    public Decorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
    }
}
