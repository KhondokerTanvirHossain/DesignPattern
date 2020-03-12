public class Product implements Plan {

    private String roof;
    private String floor;
    private String base;
    @Override
    public void setRoof(String roof) {
        this.roof = roof;
    }

    @Override
    public void setFloor(String floor) {
        this.floor = floor;
    }

    @Override
    public void setBase(String base) {
        this.base = base;
    }
    public void display(){
        System.out.println("House is Ready");
    }
}
