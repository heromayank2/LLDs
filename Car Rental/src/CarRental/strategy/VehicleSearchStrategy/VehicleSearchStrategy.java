package CarRental.strategy.VehicleSearchStrategy;

import CarRental.entities.Vehicle;

import java.util.List;

public interface VehicleSearchStrategy {
    List<Vehicle> search(String identifier, List<Vehicle> vehicleList);
}
