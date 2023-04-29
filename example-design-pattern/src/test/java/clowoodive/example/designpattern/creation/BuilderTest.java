package clowoodive.example.designpattern.creation;

import org.junit.jupiter.api.Test;

class BuilderTest {

    @Test
    void builder() {
        CarDirector carDirector = new CarDirector();

        // Director로 Sedan 생성
        CarBuilder sedanBuilder = new CarBuilder();
        carDirector.constructSedan(sedanBuilder);
        Car sedanCar = sedanBuilder.getResult();
        System.out.println("Car built :\n" + sedanCar.info());

        // 수동으로 Suv 생성
        CarBuilder suvBuilder = new CarBuilder();
        suvBuilder.setCarType(CarType.Suv);
        suvBuilder.setSeats(6);
        suvBuilder.setEngine(new Engine(3.0, 0));
        suvBuilder.setNavigator(new Navigator());
        Car SuvCar = suvBuilder.getResult();
        System.out.println("Car built :\n" + SuvCar.info());

        // Director로 Truck Manual 생성
        CarManualBuilder manualBuilder = new CarManualBuilder();
        carDirector.constructTruck(manualBuilder);
        CarManual truckManual = manualBuilder.getResult();
        System.out.println("CarManual built :\n" + truckManual.print());
    }
}