package clowoodive.example.designpattern.behavior;

interface Shape {

    void draw();

    void accept(Visitor visitor);
}

interface Visitor {

    void visit(Circle circle);

    void visit(Triangle triangle);
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("circle drawing");
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Triangle implements Shape {

    @Override
    public void draw() {
        System.out.println("triangle drawing");
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

public class VisitorConcrete implements Visitor {

    @Override
    public void visit(Circle circle) {
        System.out.println("circle 추가 작업");
        circle.draw();
    }

    @Override
    public void visit(Triangle triangle) {
        System.out.println("triangle 추가 작업");
        triangle.draw();
    }
}

