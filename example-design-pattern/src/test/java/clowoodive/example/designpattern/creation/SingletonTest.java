package clowoodive.example.designpattern.creation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SingletonTest {

    @Test
    void singleton() {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(new SingletonThread()));
        }

        for (int i = 0; i < 10; i++) {
            threads.get(i).start();
        }

        // System.out 대기
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    class SingletonThread implements Runnable {
        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance();
            System.out.println(singleton.toString());
        }
    }
}