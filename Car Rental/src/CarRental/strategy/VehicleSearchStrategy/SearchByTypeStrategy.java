package CarRental.strategy.VehicleSearchStrategy;

import CarRental.entities.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class SearchByTypeStrategy implements VehicleSearchStrategy{

    @Override
    public List<Vehicle> search(String type, List<Vehicle> vehicleList){
        List<Vehicle> finalVehicleList = new ArrayList<>();
        for(Vehicle vehicle: vehicleList){
            if(vehicle.getVehicleType().name().equals(type)){
               finalVehicleList.add(vehicle);
            }
        }
        return finalVehicleList;
    }
}
