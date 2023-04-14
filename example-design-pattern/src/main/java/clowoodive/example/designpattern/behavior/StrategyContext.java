package clowoodive.example.designpattern.behavior;

public class StrategyContext {

    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(int weight) {
        this.strategy.calcExpense(weight);
    }
}

interface Strategy {
    void calcExpense(int weight);
}

class ConcreteStrategy1 implements Strategy {

    @Override
    public void calcExpense(int weight) {
        System.out.println("strategy1 calculate weight : " + weight);
    }
}

class ConcreteStrategy2 implements Strategy {

    @Override
    public void calcExpense(int weight) {
        System.out.println("strategy2 calculate weight : " + weight);
    }
}