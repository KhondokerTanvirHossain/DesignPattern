public class TextFile {
    private String name;

    public TextFile(String name) {
        this.name = name;
    }

    public String Open(){
        return ""+name+" open";
    }
    public String Save(){
        return ""+name+" save";
    }
}
