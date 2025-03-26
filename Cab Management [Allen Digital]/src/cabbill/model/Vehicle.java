package cabbill.model;

import cabbill.enums.VehicleType;

public class Vehicle {
    String number;
    String model;
    VehicleType vehicleType;

    public Vehicle(String number, String model, VehicleType vehicleType) {
        this.number = number;
        this.model = model;
        this.vehicleType = vehicleType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
