public class Circle implements Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public String draw() {
        return "Draw a circle with radius ";
    }
    public String  CheckRadius(){
        if (radius > 0){
            return "" + radius;
        }
        else return null;
    }
}
