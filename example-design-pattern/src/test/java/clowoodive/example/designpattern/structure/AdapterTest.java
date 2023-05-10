package clowoodive.example.designpattern.structure;

import org.junit.jupiter.api.Test;

class AdapterTest {

    @Test
    void adapter() {
        RoundHole roundHole = new RoundHole(10);
        System.out.println("roundHole radius : " + roundHole.getRadius());

        RoundThing fitRoundPeg = new RoundPeg(9);
        RoundThing bigRoundPeg = new RoundPeg(11);

        System.out.println(fitRoundPeg.getRadius() + " radius is fit to hole : " + roundHole.fits(fitRoundPeg));
        System.out.println(bigRoundPeg.getRadius() + " radius is fit to hole : " + roundHole.fits(bigRoundPeg));

        SquarePeg fitSquarePeg = new SquarePeg(14);
        SquarePeg bigSquarePeg = new SquarePeg(16);
        SquareAdaptor squareAdaptor = new SquareAdaptor(fitSquarePeg);

        System.out.println(squareAdaptor.getRadius() + " is fit to hole : " + roundHole.fits(squareAdaptor));
        squareAdaptor.setSquarePeg(bigSquarePeg);
        System.out.println(squareAdaptor.getRadius() + " is fit to hole : " + roundHole.fits(squareAdaptor));
    }
}