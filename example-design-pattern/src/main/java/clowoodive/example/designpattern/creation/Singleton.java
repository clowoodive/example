package clowoodive.example.designpattern.creation;

// 멀티 스레드 환경에서 안전한 예제
class Singleton {

    public int data = 0;

    private Singleton() {
    }

    public static Singleton getInstance() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException ex) {
//            ex.printStackTrace();
//        }
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        public static final Singleton INSTANCE = new Singleton();
    }
}


// 멀티 스레드 환경에서 안전하지 못한 예제
//class Singleton {
//    private static Singleton instance;
//
//    public int data = 0;
//
//    private Singleton() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    public static Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }
//}