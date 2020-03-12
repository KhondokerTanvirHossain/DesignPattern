public class Main {
    public static void main(String[] args) {
        Builder woodHouseBuilder = new ConcreteBuilder();
        Director director = new Director(woodHouseBuilder);
        director.construct();
        Product house = woodHouseBuilder.build();
        house.display();
    }
}
