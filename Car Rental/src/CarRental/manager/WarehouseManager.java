package CarRental.manager;

import CarRental.entities.Vehicle;
import CarRental.entities.Warehouse;
import CarRental.strategy.VehicleSearchStrategy.VehicleSearchStrategy;

public class WarehouseManager {
    Warehouse warehouse;
    VehicleSearchStrategy vehicleSearchStrategy;

    public WarehouseManager(Warehouse warehouse, VehicleSearchStrategy vehicleSearchStrategy) {
        this.warehouse = warehouse;
        this.vehicleSearchStrategy = vehicleSearchStrategy;
    }

    public void addVehicle(Vehicle vehicle) {
        warehouse.addVehicle(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        warehouse.removeVehicle(vehicle);
    }

    public void searchVehicle(String type) {
        for(Vehicle vehicle: vehicleSearchStrategy.search(type, warehouse.getVehicleList())){
            System.out.println(vehicle.getNumber() + " " + vehicle.getVehicleType().name());
        }
    }
}
