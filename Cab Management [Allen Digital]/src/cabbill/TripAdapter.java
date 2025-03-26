package cabbill;

import cabbill.enums.TripStatus;
import cabbill.enums.TripType;
import cabbill.model.Cab;
import cabbill.model.Driver;
import cabbill.model.Trip;

import java.util.HashMap;
import java.util.Map;

public class TripAdapter {
    Map<Driver, Cab> driverCabMap = new HashMap<>(); // driver name to cab mapping

    void addTrip(Driver driver, Long distance, TripStatus tripStatus, Long startTime, Long endTime, TripType tripType){
        Cab cab = driverCabMap.get(driver);
        cab.getBillingManager().addTrip(new Trip(cab, distance, tripStatus, startTime, endTime, tripType));
    }

    void addDriver(Driver driver, Cab cab){
        driverCabMap.put(driver, cab);
    }

    public long getBill(Driver driver){
        return driverCabMap.get(driver).getBillingManager().getDriverBill();
    }
}
