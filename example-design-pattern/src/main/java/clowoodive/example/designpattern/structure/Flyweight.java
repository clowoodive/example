package clowoodive.example.designpattern.structure;

import java.util.HashMap;
import java.util.Map;

class Circle {

    private int x;

    private int y;

    private int radius;

    private ShapeType shapeType;

    public Circle(int x, int y, int radius, String shape, String color, String longData) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.shapeType = ShapeTypeFactory.getShapeType(shape, color, longData);
    }

    public ShapeType getShapeType() {
        return shapeType;
    }
}

class Ellipse {

    private int x;

    private int y;

    private int shortRadius;

    private int longRadius;

    private ShapeType shapeType;

    public Ellipse(int x, int y, int shortRadius, int longRadius, String shape, String color, String longData) {
        this.x = x;
        this.y = y;
        this.shortRadius = shortRadius;
        this.longRadius = longRadius;
        this.shapeType = ShapeTypeFactory.getShapeType(shape, color, longData);
    }

    public ShapeType getShapeType() {
        return shapeType;
    }
}

// Flyweight
class ShapeType {

    private String shape;

    private String color;

    private String longData;

    public ShapeType(String shape, String color, String longData) {
        this.shape = shape;
        this.color = color;
        this.longData = longData;
    }
}

class ShapeTypeFactory {

    private static Map<String, ShapeType> shapeTypes = new HashMap<>();

    public static ShapeType getShapeType(String shape, String color, String longData) {
        ShapeType shapeType = shapeTypes.get(shape);
        if (shapeType == null) {
            shapeType = new ShapeType(shape, color, longData);
            shapeTypes.put(shape, shapeType);
            System.out.println("first generate shapeType :" + shape);
        }
        return shapeType;
    }
}