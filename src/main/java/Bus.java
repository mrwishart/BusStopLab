import java.util.ArrayList;

public class Bus {

    private String destination;
    private int capacity;
    private ArrayList<Person> passengers;

     public Bus(String destination, int capacity){
         this.destination = destination;
         this.capacity = capacity;
         this.passengers = new ArrayList <>();
     }

     public int passengerCount(){
         return passengers.size();
     }

     public void addPassenger(Person person) {
         if (passengers.size() < capacity) {
             passengers.add(person);
         }
     }

     public void removePassenger(){
         if (!passengers.isEmpty()) {
             passengers.remove(0);
         }
     }
     public void pickUp(BusStop stop){
         Person person = stop.removePassenger();
         this.addPassenger(person);
     }
}
