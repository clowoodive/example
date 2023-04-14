package clowoodive.example.designpattern.behavior;

public abstract class TemplateMethodClass {

    public final void templateMethod() {
        step1();  // 공통 로직
        step2();  // 공통 로직
        hookMethod();  // 선택 오버라이드
        step3();  // 필수 오버라이드
        step4();  // 공통 로직
    }

    protected void step1() {
        System.out.println("template step1");
    }

    protected void step2() {
        System.out.println("template step2");
    }

    protected void hookMethod() {
        System.out.println("template hookMethod");
    }

    protected abstract void step3();

    protected void step4() {
        System.out.println("template step4");
    }
}

class ConcreteClass1 extends TemplateMethodClass {

    // hookMethod가 아니어도 필요에 따라 선택 오버라이드
    @Override
    public void step2() {
        System.out.println("concrete1 step2");
    }

    // 필수 오버라이드
    @Override
    public void step3() {
        System.out.println("concrete1 step3");
    }
}

class ConcreteClass2 extends TemplateMethodClass {

    // 선택 오버라이드
    @Override
    protected void hookMethod() {
        System.out.println("concrete2 hookMethod");
    }

    // 필수 오버라이드
    @Override
    public void step3() {
        System.out.println("concrete2 step3");
    }
}
