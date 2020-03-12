public class ShapeMaker {

    void drawCircle(int radius){
        Circle circle = new Circle(radius);
        String str = circle.draw() + circle.CheckRadius();
        System.out.println(str);
    }
}
