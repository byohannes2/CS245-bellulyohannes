import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ElevatorSimulation {
    private static final Random random = new Random();
    //default
    public static void main(String[] args) {
        int elevatorsCount = 1;
        int floorsCount = 32;
        double passengerProbability = 0.03;
        int elevatorCapacity = 10;
        int duration = 500;

        // initializing elevators/floors
        List<Elevator> elevators = new ArrayList<>();
        List<Floor> floors = new ArrayList<>();

        for (int i = 0; i < elevatorsCount; i++) {
            elevators.add(new Elevator(elevatorCapacity, floorsCount));
        }
        for (int i = 0; i < floorsCount; i++) {
            floors.add(new Floor());
        }
        //System.out.println("Finished initializing.");
        // for loop for simulation
        for (int tick = 1; tick <= duration; tick++) {
            //System.out.println("Tick " + tick);
            for (Elevator elevator : elevators) {
                elevator.unloadingPassengers();
                elevator.loadingPassengers(floors);
            }
            for (Elevator elevator : elevators) {
                elevator.move();
            }
            for (Floor floor : floors) {
                if (random.nextDouble() < passengerProbability) {
                    int destinationFloor = random.nextInt(floorsCount);
                    while (destinationFloor == floor.getFloorNumber()) {
                        destinationFloor = random.nextInt(floorsCount);
                    }
                    floor.addPassenger(new Passenger(floor.getFloorNumber(), destinationFloor));
                }
            }
        }
        // this is to dereference
        //System.out.println("Simulation completed.");
    }
}
