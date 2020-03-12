public class StartState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("Start state");
        context.setState(this);
    }
}
