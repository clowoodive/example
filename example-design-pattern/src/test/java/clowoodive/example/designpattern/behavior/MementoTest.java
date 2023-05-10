package clowoodive.example.designpattern.behavior;

import org.junit.jupiter.api.Test;

class MementoTest {

    @Test
    void mementoTest() {
        Originator ori = new Originator();
        Caretaker caretaker = new Caretaker();

        ori.setData(10);
        System.out.println("save memento1 data : " + ori.getData());
        Memento save1 = ori.save();
        caretaker.push(save1);

        ori.setData(ori.getData() + 10);
        System.out.println("save memento2 data : " + ori.getData());
        Memento save2 = ori.save();
        caretaker.push(save2);

        ori.setData(ori.getData() + 10);
        System.out.println("now data : " + ori.getData());

        Memento restore1 = caretaker.pop();
        ori.restore(restore1);
        System.out.println("restore memento1 data : " + ori.getData());

        Memento restore2 = caretaker.pop();
        ori.restore(restore2);
        System.out.println("restore memento2 data : " + ori.getData());
    }
}