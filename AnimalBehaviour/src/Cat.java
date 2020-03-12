public class Cat extends Animal {
    public Cat() {
        super();
        setSound("Meow");
        setFlyingType(new CantFlys());
    }

}
