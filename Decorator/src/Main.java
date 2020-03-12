public class Main {
    public static void main(String[] args) {
        Circle circle =  new Circle();
        RedDecoratedCircle redDecoratedCircle = new RedDecoratedCircle(circle);
        redDecoratedCircle.draw();
    }
}
