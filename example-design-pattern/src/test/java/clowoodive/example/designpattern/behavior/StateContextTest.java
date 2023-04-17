package clowoodive.example.designpattern.behavior;

import org.junit.jupiter.api.Test;

class StateContextTest {

    @Test
    void state() {
        StateContext stateContext = new StateContext();
        stateContext.stopAction();

        stateContext.playAction();

        stateContext.playAction();

        stateContext.stopAction();
    }
}