package clowoodive.example.designpattern.behavior;

import java.util.Stack;

class Originator {

    private int data;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Memento save() {
        return new Memento(data);
    }

    public void restore(Memento memento) {
        this.data = memento.getData();
    }
}

class Memento {

    private int data;

    public Memento(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}

class Caretaker {

    private Stack<Memento> stack = new Stack<>();

    public void push(Memento memento) {
        stack.push(memento);
    }

    public Memento pop() {
        if (stack.empty())
            return null;

        return stack.pop();
    }
}