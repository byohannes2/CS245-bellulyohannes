
public class Passenger {
    private int destination;
    private String direction;
    public Passenger(int currentFloor, int destinationFloor) {
        this.destination = destinationFloor;
        if (destinationFloor > currentFloor) {
            this.direction = "up";
        } else {
            this.direction = "down";
        }
    }
    public int getDestinationFloor() {
        return destination;
    }
    public String getDirection() {
        return direction;
    }
}
