package clowoodive.example.designpattern.structure;

import org.junit.jupiter.api.Test;

class CompositeTest {

    @Test
    void composite() {
        RentalProduct sofa = new SofaLeaf(1);
        RentalProduct smallRoom = new RoomLeaf(10);

        RentalProduct table = new TableLeaf(100);
        RentalProduct airConditioner = new AirConditionerLeaf(1000);
        RentalProduct largeRoom = new RoomLeaf(10000);
        RentalProduct roomComposite = new RentalComposite(largeRoom, airConditioner, table);

        RentalProduct rentalCompositeAll = new RentalComposite(sofa, smallRoom, roomComposite);

        int totalCost = rentalCompositeAll.calcCost(3);

        System.out.println("total cost is " + totalCost);
    }
}