package cabbill.factory;

import cabbill.enums.VehicleType;
import cabbill.model.Cab;
import cabbill.model.Driver;
import cabbill.model.Vehicle;
import cabbill.strategy.EconomyBillingStrategy;
import cabbill.strategy.LuxuryBillingStrategy;

public class CabFactory {

    public Cab createCab(Driver driver, Vehicle vehicle){
        Cab cab;
        if(vehicle.getVehicleType().equals(VehicleType.ECONOMY)) {
            cab = new Cab(vehicle, driver, new EconomyBillingStrategy());
        }else if(vehicle.getVehicleType().equals(VehicleType.LUXURY)) {
            cab = new Cab(vehicle, driver, new LuxuryBillingStrategy());
        }else{
            cab = new Cab(vehicle, driver, new EconomyBillingStrategy());
        }
        return cab;
    }
}
