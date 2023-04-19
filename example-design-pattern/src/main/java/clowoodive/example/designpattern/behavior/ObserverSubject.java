package clowoodive.example.designpattern.behavior;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface Subscriber {
    void update(String eventType, String eventMessage);
}

class EventManager {
    private Map<String, List<Subscriber>> subscribers = new HashMap<>();

    public void subscribe(String eventType, Subscriber subscriber) {
        List<Subscriber> subList = this.subscribers.get(eventType);
        if (subList == null) {
            subList = new ArrayList<>();
            subscribers.put(eventType, subList);
        }
        subList.add(subscriber);
    }

    public void unsubscribe(String eventType, Subscriber subscriber) {
        List<Subscriber> subList = this.subscribers.get(eventType);
        if (subList != null) {
            subList.remove(subscriber);
        }
    }

    protected void notify(String eventType, String eventMessage) {
        List<Subscriber> subList = this.subscribers.get(eventType);
        if (subList != null) {
            subList.forEach(subscriber -> subscriber.update(eventType, eventMessage));
        }
    }
}

public class ObserverSubject {

    private static final int UPPER_BOUND_GAUGE = 80;

    private static final int LOWER_BOUND_GAUGE = 20;

    public EventManager eventManager = new EventManager();

    private int gauge;

    public void setGauge(int gauge) {
        this.gauge = gauge;

        if (this.gauge >= UPPER_BOUND_GAUGE) {
            eventManager.notify("upper", "gauge is over " + UPPER_BOUND_GAUGE + ", now " + this.gauge);
        } else if (this.gauge <= LOWER_BOUND_GAUGE) {
            eventManager.notify("lower", "gauge is under " + LOWER_BOUND_GAUGE + ", now " + this.gauge);
        }
    }
}

class AlarmSubscriber implements Subscriber {
    @Override
    public void update(String eventType, String eventMessage) {
        System.out.println("AlarmSubscriber receive Type(" + eventType + ") Message(" + eventMessage + ")");
    }
}

class UpperAlarmSubscriber implements Subscriber {
    @Override
    public void update(String eventType, String eventMessage) {
        System.out.println("UpperAlarmSubscriber receive Type(" + eventType + ") Message(" + eventMessage + ")");
    }
}

