public class Factory {
    public Pet getPetType(String str){
        if (str.equals("Cat"))
            return new Cat();
        else if (str.equals("Dog"))
            return new Dog();
        else if (str.equals("Bird"))
            return new Bird();
        else return null;
    }
}
