public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();
        new BinaryObserver(subject);
        new OctalObserver(subject);
        new HexaObserver(subject);
        System.out.println(15);
        subject.setState(15);
        System.out.println(30);
        subject.setState(30);
    }
}
