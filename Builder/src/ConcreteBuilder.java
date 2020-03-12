public class ConcreteBuilder implements Builder {
    private Product house;

    public ConcreteBuilder(){
        this.house = new Product();
    }
    @Override
    public void buildRoof() {
        house.setRoof("ROOF IS SET");
    }

    @Override
    public void buildFloor() {
        house.setFloor("FLOOR IS SET");
    }

    @Override
    public void buildBase() {
        house.setBase("BASE IS SET");
    }

    @Override
    public Product build() {
        return this.house;
    }
}
