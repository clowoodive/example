package clowoodive.example.designpattern.creation;

interface Builder {

    public static final int SEATS_DEFAULT = 2;

    void setCarType(CarType type);

    void setSeats(int seats);

    void setEngine(Engine engine);

    void setNavigator(Navigator navigator);
}

class CarBuilder implements Builder {

    private CarType type;

    private int seats;

    private Engine engine;

    private Navigator navigator;

    @Override
    public void setCarType(CarType type) {
        this.type = type;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    public Car getResult() {
        return new Car(type, seats, engine, navigator);
    }
}

class CarManualBuilder implements Builder {

    private CarType type;

    private int seats;

    private Engine engine;

    private Navigator navigator;

    @Override
    public void setCarType(CarType type) {
        this.type = type;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    public CarManual getResult() {
        return new CarManual(type, seats, engine, navigator);
    }
}

class CarDirector {

    public void constructSedan(Builder builder) {
        builder.setCarType(CarType.Sedan);
        builder.setSeats(4);
        builder.setEngine(new Engine(2.0, 0));
        builder.setNavigator(new Navigator());
    }

    public void constructTruck(Builder builder) {
        builder.setCarType(CarType.Truck);
        builder.setSeats(2);
        builder.setEngine(new Engine(4.0, 0));
        builder.setNavigator(null);
    }
}

class Car {

    private final CarType carType;

    private final int seats;

    private final Engine engine;

    private final Navigator navigator;

    public Car(CarType carType, int seats, Engine engine, Navigator navigator) {
        this.carType = carType;
        this.seats = seats <= 0 ? Builder.SEATS_DEFAULT : seats;
        this.engine = engine;
        this.navigator = navigator;
    }

    public String info() {
        String info = "";
        info += "Type of car: " + carType + "\n";
        info += "Count of seats: " + seats + "\n";
        info += "Engine: volume - " + engine.getVolume() + "; mileage - " + engine.getMileage() + "\n";
        if (this.navigator != null) {
            info += "Navigator: Functional" + "\n";
        } else {
            info += "Navigator: N/A" + "\n";
        }
        return info;
    }
}

class CarManual {
    private final CarType carType;

    private final int seats;

    private final Engine engine;

    private final Navigator navigator;

    public CarManual(CarType carType, int seats, Engine engine, Navigator navigator) {
        this.carType = carType;
        this.seats = seats <= 0 ? Builder.SEATS_DEFAULT : seats;
        this.engine = engine;
        this.navigator = navigator;
    }

    public String print() {
        String info = "";
        info += "Type of car: " + carType + "\n";
        info += "Count of seats: " + seats + "\n";
        info += "Engine: volume - " + engine.getVolume() + "; mileage - " + engine.getMileage() + "\n";
        if (this.navigator != null) {
            info += "Navigator: Functional" + "\n";
        } else {
            info += "Navigator: N/A" + "\n";
        }
        return info;
    }
}

enum CarType {
    Sedan, Suv, Truck
}

class Engine {

    private final double volume;

    private double mileage;

    private boolean started;

    public Engine(double volume, double mileage) {
        this.volume = volume;
        this.mileage = mileage;
    }

    public void on() {
        this.started = true;
    }

    public void off() {
        this.started = false;
    }

    public boolean isStarted() {
        return started;
    }

    public void go(double mileage) {
        if (started) {
            this.mileage += mileage;
        } else {
            System.out.println("not started engine");
        }
    }

    public double getVolume() {
        return volume;
    }

    public double getMileage() {
        return mileage;
    }
}

class Navigator {

    private String route;

    public Navigator() {
        route = "default destination";
    }

    public Navigator(String route) {
        this.route = route;
    }
}