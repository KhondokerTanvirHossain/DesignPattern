public class EndState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("End State");
        context.setState(this);
    }
}
