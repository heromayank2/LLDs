package elevator.strategy;

import elevator.model.Elevator;

import java.util.List;

public class NearestElevatorStrategy implements ElevatorStrategy{
    @Override
    public Elevator findElevator(List<Elevator> elevatorList, int requestedFloor) {
        Elevator selecetdElevator = null;
        int diff = 100;
        for(Elevator elevator : elevatorList){
            if(diff>Math.abs(elevator.getCurrentFloor()-requestedFloor)){
                diff = Math.abs(elevator.getCurrentFloor()-requestedFloor);
                selecetdElevator = elevator;
            }
        }
        return selecetdElevator;
    }
}
