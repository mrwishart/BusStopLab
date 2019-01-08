import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusTest {

    Bus bus, smallBus;
    Person person;
    BusStop busStop;

    @Before
    public void beforeTest(){
        bus = new Bus("Clermiston", 75);
        smallBus = new Bus("Fife", 1);
        person = new Person();
        busStop = new BusStop("Clive");
        busStop.addPassenger(person);
        busStop.addPassenger(person);
        busStop.addPassenger(person);
    }

    @Test
    public void busStartsEmpty(){
        assertEquals(0, bus.passengerCount());
    }
    @Test
    public void canAddPassenger(){
        bus.addPassenger(person);
        assertEquals(1, bus.passengerCount());
    }

    @Test
    public void checkCapacity() {
        smallBus.addPassenger(person);
        smallBus.addPassenger(person);
        assertEquals(1, smallBus.passengerCount());
    }

    @Test
    public void canRemovePassenger(){
        bus.addPassenger(person);
        assertEquals(1, bus.passengerCount());
        bus.removePassenger();
        assertEquals(0, bus.passengerCount());
    }

    @Test
    public void wontRemovePassengerFromEmptyBus() {
        bus.removePassenger();
        assertEquals(0, bus.passengerCount());
    }

    @Test
    public void canPickUpPassengersFromBusStop() {
        assertEquals(0, bus.passengerCount());
        assertEquals(3, busStop.queueCapacity());
        bus.pickUp(busStop);
        assertEquals(1, bus.passengerCount());
        assertEquals(2, busStop.queueCapacity());
    }
}
