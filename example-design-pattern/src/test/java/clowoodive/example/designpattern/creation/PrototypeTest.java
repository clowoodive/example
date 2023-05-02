package clowoodive.example.designpattern.creation;

import org.junit.jupiter.api.Test;

class PrototypeTest {

    @Test
    void prototype() {
        Circle circle = new Circle();
        circle.setX(5);
        circle.setY(10);
        circle.color = "red";
        circle.radius = 15;

        Shape cloneCircle = circle.clone();
        if (circle == cloneCircle)
            System.out.println("circle and cloneCircle is same instance");
        else
            System.out.println("circle and cloneCircle is different instance");

        circle.radius = 20;
        if (circle.equals(cloneCircle))
            System.out.println("circle and cloneCircle has same value");
        else
            System.out.println("circle and cloneCircle has different value");

        if (cloneCircle.equals(circle))
            System.out.println("cloneCircle and circle has same value");
        else
            System.out.println("cloneCircle and circle has different value");
    }
}