import java.util.ArrayList;
import java.util.List;

public class Floor {
    private int floorNumber;
    private List<Passenger> passengers;
    public Floor() {
        this.passengers = new ArrayList<>();
    }
    public int getFloorNumber() {
        return floorNumber;
    }
    public List<Passenger> getPassengersWaiting(String direction) {
        List<Passenger> waitingPassengers = new ArrayList<>();
        for (Passenger passenger : passengers) {
            if (passenger.getDirection().equals(direction)) {
                waitingPassengers.add(passenger);
            }
        }
        return waitingPassengers;
    }
    public void removePassengers(List<Passenger> passengersToRemove) {
        passengers.removeAll(passengersToRemove);
    }
    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }
}

