package clowoodive.example.designpattern.behavior;

import org.junit.jupiter.api.Test;

class TemplateMethodClassTest {

    @Test
    void templateMethod() {
        System.out.println("----- concrete1 -----");
        TemplateMethodClass concrete1 = new ConcreteClass1();
        concrete1.templateMethod();

        System.out.println("----- concrete2 -----");
        TemplateMethodClass concrete2 = new ConcreteClass2();
        concrete2.templateMethod();
    }
}