package clowoodive.example.designpattern.structure;

// 클라이언트에서 사용할 서비스의 공통 인터페이스
interface RoundThing {
    double getRadius();
}

// 비즈니스 로직을 포함하는 클라이언트 - 둥근 구멍
class RoundHole {

    private double radius;

    public RoundHole(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public boolean fits(RoundThing peg) {
        return this.getRadius() > peg.getRadius();
    }
}

// 클라이언트가 사용할 인터페이스를 따르는 서비스 - 둥근 못
class RoundPeg implements RoundThing {

    private double radius;

    public RoundPeg(double radius) {
        this.radius = radius;
    }

    @Override
    public double getRadius() {
        return radius;
    }
}

// 클라이언트가 사용 하려 하는 호환되지 않는 서비스 - 정사각형 못
class SquarePeg {

    private double width;

    public SquarePeg(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public double getSquare() {
        return Math.pow(this.width, 2);
    }
}

// 호환되지 않는 서비스를 래핑해서 공통 인터페이스를 제공하는 어댑터
class SquareAdaptor implements RoundThing {

    SquarePeg squarePeg;

    public SquareAdaptor(SquarePeg squarePeg) {
        this.squarePeg = squarePeg;
    }

    public void setSquarePeg(SquarePeg squarePeg) {
        this.squarePeg = squarePeg;
    }

    @Override
    public double getRadius() {
        // Math.sqrt(a^2 + b^2)에서 정사각형이므로 Math.sqrt(a^2 * 2)
        return Math.sqrt(Math.pow((squarePeg.getWidth() / 2), 2) * 2);
    }
}
