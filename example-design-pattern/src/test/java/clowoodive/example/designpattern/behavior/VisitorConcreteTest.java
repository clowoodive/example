package clowoodive.example.designpattern.behavior;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class VisitorConcreteTest {

    @Test
    void visitor() {
        List<Shape> shapes = new ArrayList<>();
        Shape circle = new Circle();
        Shape triangle = new Triangle();

        shapes.add(circle);
        shapes.add(triangle);

        VisitorConcrete visitor = new VisitorConcrete();

        for (Shape shape : shapes) {
            shape.accept(visitor);
        }
    }
}