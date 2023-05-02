package clowoodive.example.designpattern.creation;

// Prototype
abstract class Shape {

    public String color;
    private int x; // 비공개 필드
    private int y; // 비공개 필드

    public Shape() {
    }

    public Shape(Shape origin) {
        if (origin != null) {
            this.x = origin.x; // 같은 클래스의 오브젝트는 비공개 필드 접근 가능
            this.y = origin.y;
            this.color = origin.color;
        }
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public abstract Shape clone();

    public boolean equals(Object object2) {
        if (!(object2 instanceof Shape))
            return false;
        Shape shape2 = (Shape) object2;
        return shape2.x == x && shape2.y == y && shape2.color.equals(color);
    }
}

class Circle extends Shape {

    public int radius;

    public Circle() {
    }

    public Circle(Circle origin) {
        super(origin);
        if (origin != null) {
            this.radius = origin.radius;
        }
    }

    @Override
    public Shape clone() {
        return new Circle(this);
    }

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Circle) || !super.equals(object2))
            return false;
        Circle shape2 = (Circle) object2;
        return shape2.radius == radius;
    }
}

class Rectangle extends Shape {

    public int width;

    public int height;

    public Rectangle() {
    }

    public Rectangle(Rectangle origin) {
        super(origin);
        if (origin != null) {
            this.width = origin.width;
            this.height = origin.height;
        }
    }

    @Override
    public Shape clone() {
        return new Rectangle(this);
    }

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Rectangle) || !super.equals(object2))
            return false;
        Rectangle shape2 = (Rectangle) object2;
        return shape2.width == width && shape2.height == height;
    }
}
