package clowoodive.example.designpattern.behavior;

import org.junit.jupiter.api.Test;

class ChainOfResponsibilityServerTest {

    @Test
    void chainOfResponsibility() {
        ChainOfResponsibilityServer server = new ChainOfResponsibilityServer();
        LogHandler logHandler = new LogHandler();
        PathCheckHandler pathCheckHandler = new PathCheckHandler();
        pathCheckHandler.setCheckString("admin");
        LengthCheckHandler lengthCheckHandler = new LengthCheckHandler();
        lengthCheckHandler.setCheckLengthMax(15);

        server.setHandler(logHandler);
        logHandler.setNext(pathCheckHandler);
        pathCheckHandler.setNext(lengthCheckHandler);

        // all pass
        boolean case1 = server.processRequest("/case1/admin");
        System.out.println("case1 result : " + case1);

        // second handler fail
        pathCheckHandler.setCheckString("user");
        boolean case2 = server.processRequest("/case2/admin");
        System.out.println("case2 result : " + case2);

        // third handler fail
        lengthCheckHandler.setCheckLengthMax(10);
        boolean case3 = server.processRequest("/case3/user/login");
        System.out.println("case3 result : " + case3);
    }
}