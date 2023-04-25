package clowoodive.example.designpattern.behavior;

interface Handler {
    void setNext(Handler handler);

    boolean handle(String request);
}

abstract class BaseHandler implements Handler {

    Handler next;

    @Override
    public void setNext(Handler handler) {
        this.next = handler;
    }

    @Override
    public boolean handle(String request) {
        return false;
    }
}

class LogHandler extends BaseHandler {

    @Override
    public void setNext(Handler handler) {
        super.setNext(handler);
    }

    @Override
    public boolean handle(String request) {
        System.out.println("LogHandler - logging");
        if (this.next != null)
            return this.next.handle(request);

        return true;
    }
}

class PathCheckHandler extends BaseHandler {

    private String checkStr;

    public void setCheckString(String checkStr) {
        this.checkStr = checkStr;
    }

    private boolean isValidPath(String request) {
        return request.contains(checkStr);
    }

    @Override
    public void setNext(Handler handler) {
        super.setNext(handler);
    }

    @Override
    public boolean handle(String request) {
        if (isValidPath(request)) {
            System.out.println("PathCheckHandler - valid");
        } else {
            System.out.println("PathCheckHandler - invalid");
            return false;
        }

        if (this.next != null)
            return this.next.handle(request);
        else {
            return true;
        }
    }
}

class LengthCheckHandler extends BaseHandler {

    private int checkLengthMax;

    public void setCheckLengthMax(int lengthMax) {
        this.checkLengthMax = lengthMax;
    }

    private boolean isValidLength(String request) {
        return request.length() <= this.checkLengthMax;
    }

    @Override
    public void setNext(Handler handler) {
        super.setNext(handler);
    }

    @Override
    public boolean handle(String request) {
        if (isValidLength(request)) {
            System.out.println("LengthCheckHandler - valid");
        } else {
            System.out.println("LengthCheckHandler - invalid");
            return false;
        }

        if (this.next != null)
            return this.next.handle(request);
        else {
            return true;
        }
    }
}

public class ChainOfResponsibilityServer {

    private Handler handler;

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public boolean processRequest(String request) {
        System.out.println("------- request(" + request + ") process start -------");
        return this.handler.handle(request);
    }
}
