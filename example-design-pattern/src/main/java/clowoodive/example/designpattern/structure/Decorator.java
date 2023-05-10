package clowoodive.example.designpattern.structure;

interface DrinkMaker {
    void makeDrink(int size, int shot, boolean isCold);

    void showDetail();
}

class CoffeeMaker implements DrinkMaker {

    private int size;

    private int shot;

    private boolean isCold;

    @Override
    public void makeDrink(int size, int shot, boolean isCold) {
        this.size = size;
        this.shot = shot;
        this.isCold = isCold;
    }

    @Override
    public void showDetail() {
        System.out.println("--- detail ---");
        System.out.println("Size : " + size);
        System.out.println("Shot : " + shot);
        System.out.println("Cold : " + isCold);
    }
}

class DrinkMakerDecorator implements DrinkMaker {

    private DrinkMaker maker;

    public DrinkMakerDecorator(DrinkMaker maker) {
        this.maker = maker;
    }

    @Override
    public void makeDrink(int size, int shot, boolean isCold) {
        maker.makeDrink(size, shot, isCold);
    }

    @Override
    public void showDetail() {
        maker.showDetail();
    }
}

class SizeDecorator extends DrinkMakerDecorator {

    public SizeDecorator(DrinkMaker maker) {
        super(maker);
    }

    @Override
    public void makeDrink(int size, int shot, boolean isCold) {
        super.makeDrink(addSize(size), shot, isCold);
    }

    private int addSize(int size) {
        System.out.println("size up.");
        return size + 1;
    }

    @Override
    public void showDetail() {
        super.showDetail();
    }
}

class ShotDecorator extends DrinkMakerDecorator {

    public ShotDecorator(DrinkMaker maker) {
        super(maker);
    }

    @Override
    public void makeDrink(int size, int shot, boolean isCold) {
        super.makeDrink(size, addShot(shot), isCold);
    }

    private int addShot(int shot) {
        System.out.println("add shot.");
        return shot + 1;
    }

    @Override
    public void showDetail() {
        super.showDetail();
    }
}

class ColdDecorator extends DrinkMakerDecorator {

    public ColdDecorator(DrinkMaker maker) {
        super(maker);
    }

    @Override
    public void makeDrink(int size, int shot, boolean isCold) {
        System.out.println("change cold.");
        super.makeDrink(size, shot, true);
    }

    @Override
    public void showDetail() {
        super.showDetail();
    }
}