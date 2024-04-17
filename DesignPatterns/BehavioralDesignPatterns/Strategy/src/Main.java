package DesignPatterns.BehavioralDesignPatterns.Strategy.src;

// Strategy Interface
interface Strategy {
    int execute(int a, int b);
}

// Concrete Strategy Classes
class ConcreteStrategyAdd implements Strategy {
    public int execute(int a, int b) {
        return a + b;
    }
}

class ConcreteStrategySubtract implements Strategy {
    public int execute(int a, int b) {
        return a - b;
    }
}

class ConcreteStrategyMultiply implements Strategy {
    public int execute(int a, int b) {
        return a * b;
    }
}

// Context Class
class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int a, int b) {
        return strategy.execute(a, b);
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        Context context = new Context();

        // Assume these values are read from user input
        int firstNumber = 10;
        int secondNumber = 5;
        String action = "addition"; // or "subtraction", "multiplication"

        if (action.equals("addition")) {
            context.setStrategy(new ConcreteStrategyAdd());
            System.out.println("Strategy set to Addition");
        } else if (action.equals("subtraction")) {
            context.setStrategy(new ConcreteStrategySubtract());
            System.out.println("Strategy set to Subtraction");
        } else if (action.equals("multiplication")) {
            context.setStrategy(new ConcreteStrategyMultiply());
            System.out.println("Strategy set to Multiplication");
        }

        int result = context.executeStrategy(firstNumber, secondNumber);
        System.out.println("Result: " + result);
    }
}