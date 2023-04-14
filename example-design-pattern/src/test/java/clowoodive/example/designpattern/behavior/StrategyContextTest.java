package clowoodive.example.designpattern.behavior;

import org.junit.jupiter.api.Test;

class StrategyContextTest {

    @Test
    void strategy() {
        StrategyContext strategyContext = new StrategyContext();

        System.out.println("----- strategy1 -----");
        ConcreteStrategy1 concreteStrategy1 = new ConcreteStrategy1();
        strategyContext.setStrategy(concreteStrategy1);
        strategyContext.executeStrategy(1);

        System.out.println("----- strategy2 -----");
        ConcreteStrategy2 concreteStrategy2 = new ConcreteStrategy2();
        strategyContext.setStrategy(concreteStrategy2);
        strategyContext.executeStrategy(2);
    }
}