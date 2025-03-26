package elevator;

import elevator.strategy.NearestElevatorStrategy;

public class Main {
    public static void main(String[] args) {

        ElevatorManager elevatorManager = ElevatorManager.getInstance(2, 10, new NearestElevatorStrategy());
        elevatorManager.requestElevator(3,"up"); // 3
        elevatorManager.requestElevator(8,"down"); // 8
        elevatorManager.requestElevator(5,"down"); // 5

        elevatorManager.fetchStatus(); //

        try{
            elevatorManager.moveElevator(1);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            elevatorManager.moveElevator(2);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try{
            elevatorManager.moveElevator(1);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        elevatorManager.fetchStatus();


    }
}