import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusStopTest {

    BusStop busStop;
    Person person;

    @Before
    public void before (){
        busStop = new BusStop("Eric");
        person = new Person();
    }

    @Test
    public void checkQueueCapacity(){
        assertEquals(0, busStop.queueCapacity());
    }

    @Test
    public void addPassengerToQueue(){
        busStop.addPassenger(person);
        assertEquals(1, busStop.queueCapacity());
    }

    @Test
    public void removePassengerToQueue(){
        busStop.addPassenger(person);
        busStop.addPassenger(person);
        assertEquals(2, busStop.queueCapacity());
        busStop.removePassenger();
        assertEquals(1, busStop.queueCapacity());
    }
}
