import java.util.*;
public class Elevator {
    private int capacity;
    private List<Passenger> passengers;
    private int currentFloor;
    private String direction;
    private int floorsCount;
    public Elevator(int capacity, int floorsCount) {
        this.capacity = capacity;
        this.passengers = new ArrayList<>();
        this.currentFloor = 1;
        this.direction = "waiting";
        this.floorsCount = floorsCount;
    }
    public void unloadingPassengers() {
        List<Passenger> passengersComingOff = new ArrayList<>();
        for (Passenger passenger : passengers) {
            if (passenger.getDestinationFloor() == currentFloor) {
                passengersComingOff.add(passenger);
            }
        }
        passengers.removeAll(passengersComingOff);
    }
    public void loadingPassengers(List<Floor> floors) {
        Floor currFloor = floors.get(currentFloor - 1);
        List<Passenger> waitingPassengers = currFloor.getPassengersWaiting(direction);
        for (Passenger passenger : waitingPassengers) {
            if (passengers.size() < capacity) {
                passengers.add(passenger);
            } else {
                break;
            }
        }
        currFloor.removePassengers(waitingPassengers);
    }
    public void move() {
        if (direction.equals("up") && currentFloor < floorsCount) {
            currentFloor++;
        } else if (direction.equals("down") && currentFloor > 1) {
            currentFloor--;
        } else if (direction.equals("up")) {
            direction = "down";
        } else {
            direction = "up";
        }
    }
}

