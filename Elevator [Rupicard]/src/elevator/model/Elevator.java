package elevator.model;

import elevator.enums.ElevatorStatus;

public class Elevator {

    int elevatorId;
    ElevatorStatus elevatorStatus;
    int currentFloor;

    public Elevator(int id) {
        this.elevatorId = id;
        this.elevatorStatus = ElevatorStatus.IDLE;
        this.currentFloor = 0;
    }

    public ElevatorStatus getElevatorStatus() {
        return elevatorStatus;
    }

    public void setElevatorStatus(ElevatorStatus elevatorStatus) {
        this.elevatorStatus = elevatorStatus;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getElevatorId() {
        return elevatorId;
    }
}
