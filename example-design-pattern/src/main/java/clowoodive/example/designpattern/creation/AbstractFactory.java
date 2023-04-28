package clowoodive.example.designpattern.creation;

interface GUIFactory {

    Button createButton();

    Checkbox createCheckbox();
}

class WindowsFactory implements GUIFactory {

    @Override
    public Button createButton() {
        System.out.println("create WindowsButton");
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        System.out.println("create WindowsChecbox");
        return new WindowsCheckbox();
    }
}

class MacFactory implements GUIFactory {

    @Override
    public Button createButton() {
        System.out.println("create MacButton");
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        System.out.println("create MacCheckbox");
        return new MacCheckbox();
    }
}

interface Button {

    void push();
}

class WindowsButton implements Button {

    @Override
    public void push() {
        System.out.println("WindowsButton pushed.");
    }
}

class MacButton implements Button {

    @Override
    public void push() {
        System.out.println("MacButton pushed.");
    }
}

interface Checkbox {

    void checkToggle();
}

class WindowsCheckbox implements Checkbox {

    @Override
    public void checkToggle() {
        System.out.println("WindowsCheckbox checked.");
    }
}

class MacCheckbox implements Checkbox {

    @Override
    public void checkToggle() {
        System.out.println("MacCheckbox checked.");
    }
}

class OsApplication {

    private Button button;
    private Checkbox checkbox;

    public OsApplication(GUIFactory factory) {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }

    public void clickButton() {
        this.button.push();
    }

    public void clickChecbox() {
        this.checkbox.checkToggle();
    }
}