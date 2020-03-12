public class Animal {
    private String name;
    private String sound;
    private int Weight;
    private Fly flyingType;
    public Animal(){}
    public Animal(String name, String sound, int weight) {
        this.name = name;
        this.sound = sound;
        Weight = weight;
    }

    public void setFlyingType(Fly flyingType) {
        this.flyingType = flyingType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public int getWeight() {
        return Weight;
    }

    public void setWeight(int weight) {
        Weight = weight;
    }
    public String tryToFly(){
        return flyingType.fly();
    }
    public void setFlyingAbility(Fly flyingType ){

    }
}
