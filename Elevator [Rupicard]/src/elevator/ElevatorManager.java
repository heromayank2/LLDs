package elevator;

import elevator.enums.ElevatorStatus;
import elevator.exceptions.FloorNotAvailableException;
import elevator.exceptions.NoMovingElevator;
import elevator.model.Elevator;
import elevator.strategy.ElevatorStrategy;

import java.util.*;

public class ElevatorManager {

    private static volatile ElevatorManager elevatorManager = null;

    public static ElevatorManager getInstance(Integer numberOfElevators, Integer floorCount, ElevatorStrategy elevatorStrategy){
        if(elevatorManager==null){
            synchronized (ElevatorManager.class){
                if(elevatorManager==null){
                    elevatorManager = new ElevatorManager(numberOfElevators, floorCount, elevatorStrategy);
                }
            }
        }
        return elevatorManager;
    }

    List<Elevator> idleElevators;
    ElevatorStrategy elevatorStrategy;
    Map<Integer, Elevator> movingElevatorMap = new HashMap<>();
    Queue<Integer> requestQueue = new LinkedList<>();
    Integer floorCount;

    ElevatorManager(Integer numberOfElevators, Integer floorCount, ElevatorStrategy elevatorStrategy){
        idleElevators = new ArrayList<>();
        for(int i=1; i<=numberOfElevators; i++){
            idleElevators.add(new Elevator(i));
        }
        this.elevatorStrategy = elevatorStrategy;
        this.floorCount = floorCount;
    }

    void requestElevator(int requestedFloor, String direction) {
        if(floorCount<requestedFloor){
            throw new FloorNotAvailableException("Invalid Floor Requested");
        }
        if(idleElevators.isEmpty()){
            requestQueue.add(requestedFloor);
            System.out.println("All Elevators are busy at the moment. Request added to queue");
            return;
        }
        Elevator elevator = elevatorStrategy.findElevator(this.idleElevators, requestedFloor);
        System.out.println("Elevator "+elevator.getElevatorId()+" is requested for Floor "+ requestedFloor);
        idleElevators.remove(elevator);
        elevator.setElevatorStatus(ElevatorStatus.MOVING);
        elevator.setCurrentFloor(requestedFloor);
        movingElevatorMap.put(elevator.getElevatorId(), elevator);
    }

    void moveElevator(int elevatorId) throws NoMovingElevator {
        if(movingElevatorMap.get(elevatorId)==null){
            throw new NoMovingElevator("Elevator is not moving at the moment");
        }
        Elevator elevator = movingElevatorMap.get(elevatorId);
        System.out.println("Elevator "+ elevator.getElevatorId()+ " moved to Floor "+ elevator.getCurrentFloor());
        elevator.setElevatorStatus(ElevatorStatus.IDLE);
        idleElevators.add(elevator);
        movingElevatorMap.remove(elevatorId);
        if(!requestQueue.isEmpty()) {
            System.out.println("Assigning the next request to the idle elevator");
            requestElevator(requestQueue.poll(), "UP");
        }
    }

    void fetchStatus(){
        for(Elevator elevator : idleElevators){
            System.out.println("Elevator "+elevator.getElevatorId()+" is in IDLE state at Floor "+elevator.getCurrentFloor());
        }
        for(Map.Entry<Integer, Elevator> entry : movingElevatorMap.entrySet()){
            System.out.println("Elevator "+entry.getKey()+" is in MOVING state to Floor "+entry.getValue().getCurrentFloor());
        }
    }
}
