package clowoodive.example.designpattern.behavior;

import org.junit.jupiter.api.Test;

class ObserverSubjectTest {

    @Test
    void observer() {
        ObserverSubject subject = new ObserverSubject();

        Subscriber alarmSubscriber = new AlarmSubscriber();
        subject.eventManager.subscribe("upper", alarmSubscriber);
        subject.eventManager.subscribe("lower", alarmSubscriber);

        Subscriber upperAlarmSubscriber = new UpperAlarmSubscriber();
        subject.eventManager.subscribe("upper", upperAlarmSubscriber);

        subject.setGauge(50);
        subject.setGauge(80);

        subject.eventManager.unsubscribe("upper", alarmSubscriber);
        subject.setGauge(90);
        subject.setGauge(19);
    }
}