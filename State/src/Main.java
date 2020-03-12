public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        StartState startState = new StartState();
        startState.doAction(context);

        EndState endState = new EndState();
        endState.doAction(context);

    }
}
