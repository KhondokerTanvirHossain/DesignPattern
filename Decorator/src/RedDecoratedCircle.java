public class RedDecoratedCircle extends Decorator {
    public RedDecoratedCircle(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        super.draw();
        setBorder(decoratedShape);
    }
    void setBorder(Shape decoratedShape){
        System.out.println("Red Border Added");
    }
}
