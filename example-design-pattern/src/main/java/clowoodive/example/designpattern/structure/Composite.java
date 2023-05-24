package clowoodive.example.designpattern.structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface RentalProduct {
    int calcCost(int days);
}

class SofaLeaf implements RentalProduct {
    private int cost;

    public SofaLeaf(int cost) {
        this.cost = cost;
    }

    @Override
    public int calcCost(int days) {
        return cost * days;
    }
}

class TableLeaf implements RentalProduct {

    private int cost;

    public TableLeaf(int cost) {
        this.cost = cost;
    }

    @Override
    public int calcCost(int days) {
        return cost * days;
    }
}

class AirConditionerLeaf implements RentalProduct {

    private int cost;

    public AirConditionerLeaf(int cost) {
        this.cost = cost;
    }

    @Override
    public int calcCost(int days) {
        return cost * days;
    }
}

class RoomLeaf implements RentalProduct {
    private int cost;

    public RoomLeaf(int cost) {
        this.cost = cost;
    }

    @Override
    public int calcCost(int days) {
        return cost * days;
    }
}

class RentalComposite implements RentalProduct {

    private List<RentalProduct> rentalProducts = new ArrayList<>();

    public RentalComposite(RentalProduct... products) {
        rentalProducts.addAll(Arrays.asList(products));
    }

    @Override
    public int calcCost(int days) {
        return rentalProducts.stream().mapToInt(product -> product.calcCost(days)).sum();
    }
}

