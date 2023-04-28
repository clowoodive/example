package clowoodive.example.designpattern.creation;

import org.junit.jupiter.api.Test;

import javax.crypto.Mac;

import static org.junit.jupiter.api.Assertions.*;

class AbstractFactoryTest {

    @Test
    void abstractFactory() {
        GUIFactory factory = new MacFactory();
        OsApplication app = new OsApplication(factory);

        app.clickButton();
        app.clickChecbox();
    }
}