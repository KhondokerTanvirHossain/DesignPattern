public class Main {
    public static void main(String[] args) {
        Animal kitty = new Cat();
        Animal doggy = new Dog();
        Animal twitter = new Bird();
        System.out.println(kitty.getSound());
        System.out.println(doggy.getSound());
        System.out.println(twitter.getSound());


        System.out.println(kitty.tryToFly());
    }
}
