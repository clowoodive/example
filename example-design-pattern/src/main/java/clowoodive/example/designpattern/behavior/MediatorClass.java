package clowoodive.example.designpattern.behavior;

interface Mediator {
    void notify(Component component, String event);

    void setComponent1(Component component);

    void setComponent2(Component component);

    void setComponent3(Component component);
}

public class MediatorClass implements Mediator {

    // 컴포넌트들의 리스트가 될 수도 있음
    private Component component1;

    private Component component2;

    private Component component3;


    @Override
    public void setComponent1(Component component) {
        this.component1 = component;
    }

    @Override
    public void setComponent2(Component component) {
        this.component2 = component;
    }

    @Override
    public void setComponent3(Component component) {
        this.component3 = component;
    }

    @Override
    public void notify(Component component, String event) {
        if (component instanceof ConcreteComponent1) {
            if (event.equals("click")) {
                reactOnClickComponent1();
            } else if (event.equals("move")) {
                reactOnMoveComponent1();
            }
        } else if (component instanceof ConcreteComponent2) {
            if (event.equals("click")) {
                reactOnClickComponent2();
            } else if (event.equals("move")) {
                reactOnMoveComponent2();
            }
        } else if (component instanceof ConcreteComponent3) {
            if (event.equals("click")) {
                reactOnClickComponent3();
            } else if (event.equals("move")) {
                reactOnMoveComponent3();
            }
        }
    }

    private void reactOnClickComponent1() {
        component2.receiveClick(" from component1");
        component3.receiveClick(" from component1");
    }

    private void reactOnMoveComponent1() {
        component2.receiveMove(" from component1");
        component3.receiveMove(" from component1");
    }

    private void reactOnClickComponent2() {
        component1.receiveClick(" from component2");
        component3.receiveClick(" from component2");
    }

    private void reactOnMoveComponent2() {
        component1.receiveMove(" from component2");
        component3.receiveMove(" from component2");
    }

    private void reactOnClickComponent3() {
        component1.receiveClick(" from component3");
        component2.receiveClick(" from component3");
    }

    private void reactOnMoveComponent3() {
        component1.receiveMove(" from component3");
        component2.receiveMove(" from component3");
    }
}

abstract class Component {
    protected Mediator mediator;


    public Component(Mediator mediator) {
        this.mediator = mediator;
    }

    abstract void sendClick();

    abstract void sendMove();

    abstract void receiveClick(String event);

    abstract void receiveMove(String event);
}

class ConcreteComponent1 extends Component {

    public ConcreteComponent1(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void sendClick() {
        System.out.println("Component1 send click");
        super.mediator.notify(this, "click");
    }

    @Override
    public void sendMove() {
        System.out.println("Component1 send move");
        super.mediator.notify(this, "move");
    }

    @Override
    public void receiveClick(String event) {
        System.out.println("Component1 receive click" + event);
    }

    @Override
    public void receiveMove(String event) {
        System.out.println("Component1 receive move" + event);
    }
}

class ConcreteComponent2 extends Component {

    public ConcreteComponent2(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void sendClick() {
        System.out.println("Component2 send click");
        super.mediator.notify(this, "click");
    }

    @Override
    public void sendMove() {
        System.out.println("Component2 send move");
        super.mediator.notify(this, "move");
    }

    @Override
    public void receiveClick(String event) {
        System.out.println("Component2 receive click" + event);
    }

    @Override
    public void receiveMove(String event) {
        System.out.println("Component2 receive move" + event);
    }
}

class ConcreteComponent3 extends Component {

    public ConcreteComponent3(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void sendClick() {
        System.out.println("Component3 send click");
        super.mediator.notify(this, "click");
    }

    @Override
    public void sendMove() {
        System.out.println("Component3 send move");
        super.mediator.notify(this, "move");
    }

    @Override
    public void receiveClick(String event) {
        System.out.println("Component3 receive click" + event);
    }

    @Override
    public void receiveMove(String event) {
        System.out.println("Component3 receive move" + event);
    }
}
