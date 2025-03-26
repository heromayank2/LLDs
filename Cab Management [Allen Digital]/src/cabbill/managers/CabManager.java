package cabbill.managers;

import cabbill.builder.DriverBuilder;
import cabbill.builder.VehicleBuilder;
import cabbill.factory.CabFactory;
import cabbill.model.Cab;
import cabbill.model.Driver;
import cabbill.model.Vehicle;
import cabbill.enums.VehicleType;
import cabbill.exceptions.DriverNotAvailableException;
import cabbill.exceptions.VehicleNotAvailableException;

import java.util.*;

public class CabManager {

    List<Vehicle> availableVehicleList;
    List<Driver> availableDriverList;
    Map<Driver, Cab> driverToCabMap;
    CabFactory cabFactory;

    public CabManager() {
        availableDriverList = new ArrayList<>();
        availableVehicleList = new ArrayList<>();
        driverToCabMap = new HashMap<>();
        cabFactory = new CabFactory();
    }

    public Vehicle addVehicle(String name, String number, VehicleType vehicleType) {
        System.out.println("Adding vehicle to the available list");
        VehicleBuilder vehicleBuilder = new VehicleBuilder();
        vehicleBuilder.setNumber(number)
                .setModel(name)
                .setVehicleType(vehicleType);

        Vehicle vehicle = vehicleBuilder.build();
        availableVehicleList.add(vehicle);
        return vehicle;
    }

    public Driver addDriver(String name, String number, String licenseNumber) {
        System.out.println("Adding driver to the available list");
        DriverBuilder driverBuilder = new DriverBuilder();
        String driverId = UUID.randomUUID().toString();
        driverBuilder.setPhoneNumber(number)
                .setName(name)
                .setDrivingLicense(licenseNumber)
                .setId(driverId);
        Driver driver = driverBuilder.build();
        availableDriverList.add(driver);
        return driver;
    }

    public Cab mapDriverToVehicle(Vehicle vehicle, Driver driver) throws DriverNotAvailableException, VehicleNotAvailableException {
        System.out.println("Mapping driver to vehicle");
        if(availableDriverList.contains(driver)){
            if(availableVehicleList.contains(vehicle)){
                //remove from list
                availableDriverList.remove(driver);
                availableVehicleList.remove(vehicle);
                Cab cab = cabFactory.createCab(driver, vehicle);
                System.out.println("Mapping driver to vehicle successful");
                driverToCabMap.put(driver, cab);
                return cab;

            }else{
                throw new VehicleNotAvailableException("Vehicle is not available");
            }
        }else{
            throw new DriverNotAvailableException("Driver is not available");
        }
    }


}
