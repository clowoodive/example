package clowoodive.example.designpattern.behavior;

import org.junit.jupiter.api.Test;

class MediatorClassTest {

    @Test
    void mediator() {
        Mediator mediator = new MediatorClass();
        Component component1 = new ConcreteComponent1(mediator);
        Component component2 = new ConcreteComponent2(mediator);
        Component component3 = new ConcreteComponent3(mediator);
        mediator.setComponent1(component1);
        mediator.setComponent2(component2);
        mediator.setComponent3(component3);

        component1.sendClick();
        component3.sendMove();
    }
}