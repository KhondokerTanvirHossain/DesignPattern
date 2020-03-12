public class Dog extends Animal {
    public Dog() {
        super();
        setSound("Bark");
        setFlyingType(new CantFlys());
    }
}
