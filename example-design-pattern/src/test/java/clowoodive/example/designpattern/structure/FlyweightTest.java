package clowoodive.example.designpattern.structure;

import org.junit.jupiter.api.Test;

class FlyweightTest {

    @Test
    void flyweight() {
        Circle circle1 = new Circle(5, 10, 8, "circle", "red", "circle data");
        Circle circle2 = new Circle(7, 9, 5, "circle", "red", "circle data");

        System.out.println(circle1.getShapeType());
        System.out.println(circle2.getShapeType());
    }
}