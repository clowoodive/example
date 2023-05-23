package clowoodive.example.designpattern.structure;

import org.junit.jupiter.api.Test;

class FacadeTest {

    @Test
    void facade() {
        Facade facade = new Facade();
        facade.processComplexData("input data");
    }
}