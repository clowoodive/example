package clowoodive.example.designpattern.structure;

import org.junit.jupiter.api.Test;

class ProxyTest {

    @Test
    void proxy() {
        Service service = new RealService();
        ServiceProxy proxy = new ServiceProxy(service);

        // 원래 객체 사용
        proxy.method1();
        proxy.method2();

        // 프록시의 캐시 사용
        proxy.method1();
        proxy.method2();
    }
}