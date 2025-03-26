package elevator.strategy;

import elevator.model.Elevator;

import java.util.List;

public interface ElevatorStrategy {
    Elevator findElevator(List<Elevator> elevatorList, int requestedFloor);
}
