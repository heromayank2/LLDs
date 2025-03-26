package cabbill.builder;

import cabbill.model.Vehicle;
import cabbill.enums.VehicleType;

public class VehicleBuilder {

    String number;
    String model;
    VehicleType vehicleType;


    public VehicleBuilder setNumber(String number) {
        this.number = number;
        return this;
    }

    public VehicleBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public VehicleBuilder setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
        return this;
    }

    public Vehicle build() {
        return new Vehicle(number, model, vehicleType);
    }
}
