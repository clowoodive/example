package clowoodive.example.designpattern.structure;

import org.junit.jupiter.api.Test;

class DecoratorTest {

    @Test
    void decorator() {
        DrinkMakerDecorator decorator = new ColdDecorator(
                new ShotDecorator(
                        new SizeDecorator(
                                new CoffeeMaker()
                        )
                )
        );

        decorator.makeDrink(2, 1, false);
        decorator.showDetail();
    }

}