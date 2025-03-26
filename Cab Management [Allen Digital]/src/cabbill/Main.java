package cabbill;

import cabbill.enums.TripStatus;
import cabbill.enums.TripType;
import cabbill.enums.VehicleType;
import cabbill.managers.CabManager;
import cabbill.model.Cab;
import cabbill.model.Driver;
import cabbill.model.Vehicle;

public class Main {
    public static void main(String[] args) {

        CabManager cabManager = new CabManager();
        Driver d1 = cabManager.addDriver("Sachin", "9936673000", "D2389ER2HSJ");
        Driver d2 = cabManager.addDriver("Ramesg", "9936673011", "S2IU1292S22");

        Vehicle v1 = cabManager.addVehicle("KA-01-2222", "Maruti Suzuki", VehicleType.ECONOMY);
        Vehicle v2 = cabManager.addVehicle("KA-01-2223", "Ertiga", VehicleType.PREMIUM);

        Cab c1 = null;
        try{
            c1 = cabManager.mapDriverToVehicle(v1, d1);
        } catch (Exception e) {
            System.out.println(("Exception occurred while mapping driver to vehicle: " + e.getMessage()));
        }

        Cab c2 = null;
        try{
            c2 = cabManager.mapDriverToVehicle(v2, d1);
        } catch (Exception e) {
            System.out.println("Exception occurred while mapping driver to vehicle: " + e.getMessage());
        }

        TripAdapter tripAdapter = new TripAdapter();
        tripAdapter.addDriver(d1, c1);
        tripAdapter.addDriver(d2, c2);

        tripAdapter.addTrip(d1, 10L, TripStatus.COMPLETED, 1000L, 2000L, TripType.OUTSTATION); //10*5*2
        tripAdapter.addTrip(d1, 20L, TripStatus.CANCELLED_BY_USER, 1000L, 2000L, TripType.INTRACITY); //10

        System.out.println("Total billing for cab 1: " + tripAdapter.getBill(d1));


    }
}