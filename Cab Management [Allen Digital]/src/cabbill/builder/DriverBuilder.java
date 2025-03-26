package cabbill.builder;

import cabbill.model.Driver;

public class DriverBuilder {

    String id;
    String name;
    String phoneNumber;
    String drivingLicense;

    public DriverBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public DriverBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public DriverBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }


    public DriverBuilder setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
        return this;
    }

    public Driver build() {
        return new Driver(id, name, phoneNumber, drivingLicense);
    }
}
