public class Bird extends Animal {
    public Bird() {
        super();
        super.setSound("Twitter");
        setFlyingType(new ItFlys());
    }

}
