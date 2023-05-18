package clowoodive.example.designpattern.structure;

interface Service {
    int method1();

    int method2();
}

class RealService implements Service {

    private final int a = 1;

    private final int b = 10;

    private final int c = 100;

    @Override
    public int method1() {
        System.out.println("RealService method1 call.");
        return a + b + c;
    }

    @Override
    public int method2() {
        System.out.println("RealService method2 call.");
        return c - b - a;
    }
}

class ServiceProxy implements Service {

    private Service service;

    private Integer cacheMethod1;

    private Integer cacheMethod2;

    public ServiceProxy(Service service) {
        this.service = service;
    }

    @Override
    public int method1() {
        if (cacheMethod1 == null) {
            cacheMethod1 = service.method1();
            return cacheMethod1;
        }

        System.out.println("ServiceProxy method1 call - using cache");
        return cacheMethod1;
    }

    @Override
    public int method2() {
        if (cacheMethod2 == null) {
            cacheMethod2 = service.method2();
            return cacheMethod2;
        }

        System.out.println("ServiceProxy method2 call - using cache");
        return cacheMethod2;
    }
}