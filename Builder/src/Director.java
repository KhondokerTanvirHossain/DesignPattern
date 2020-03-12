public class Director {
    private Builder houseBuilder;
    public Director(Builder builder){
        houseBuilder = builder;
    }
    public Product build(){
        return houseBuilder.build();
    }
    public void construct(){
        houseBuilder.buildRoof();
        houseBuilder.buildFloor();
        houseBuilder.buildBase();
    }
}
