package CarRental;

import CarRental.entities.Receipt;
import CarRental.entities.User;
import CarRental.entities.Vehicle;
import CarRental.entities.Warehouse;
import CarRental.enums.VehicleType;
import CarRental.manager.ReceiptManager;
import CarRental.manager.WarehouseManager;
import CarRental.strategy.VehicleSearchStrategy.SearchByTypeStrategy;

public class Main {
    public static void main(String[] args) {
        WarehouseManager warehouseManager = new WarehouseManager(new Warehouse(), new SearchByTypeStrategy());
        ReceiptManager receiptManager = new ReceiptManager();

        Vehicle v1 = new Vehicle("KA01CD1001", VehicleType.CAR);
        Vehicle v2 = new Vehicle("KA01CD1002", VehicleType.CAR);
        Vehicle v3 = new Vehicle("KA01CD1003", VehicleType.BIKE);
        Vehicle v4 = new Vehicle("KA01CD1004", VehicleType.BIKE);

        warehouseManager.addVehicle(v1);
        warehouseManager.addVehicle(v2);
        warehouseManager.addVehicle(v3);
        warehouseManager.addVehicle(v4);

        warehouseManager.searchVehicle("CAR");
        User u1 = new User("Jonas");
        Receipt r1;
        try{
            r1 = receiptManager.bookVehicle(v1, u1, 10);
            receiptManager.completeBooking(r1);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }


    }
}