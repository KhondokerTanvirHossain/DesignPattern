public class Main {
    public static void main(String[] args) {
        Factory factory = new Factory();
        Pet pet1 = factory.getPetType("Cat");
        System.out.println(pet1.getPet());
        Pet pet2 = factory.getPetType("Dog");
        System.out.println(pet2.getPet());
    }
}