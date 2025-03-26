package CarRental.entities;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    List<Vehicle> vehicleList;

    public Warehouse() {
        this.vehicleList = new ArrayList<>();
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleList.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicleList.remove(vehicle);
    }
}
