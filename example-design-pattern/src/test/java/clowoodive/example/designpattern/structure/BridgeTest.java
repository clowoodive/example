package clowoodive.example.designpattern.structure;

import org.junit.jupiter.api.Test;

class BridgeTest {

    @Test
    void bridge() {
        testDevice(new Tv());
        testDevice(new Radio());
    }

    private void testDevice(Device device) {
        System.out.println("Tests with simple remote.");
        SimpleRemote simpleRemote = new SimpleRemote(device);
        simpleRemote.power();
        device.printStatus();

        System.out.println("Tests with premium remote.");
        PremiumRemote premiumRemote = new PremiumRemote(device);
        premiumRemote.power();
        premiumRemote.mute();
        device.printStatus();
    }
}