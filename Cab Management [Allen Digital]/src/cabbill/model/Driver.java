package cabbill.model;

public class Driver {
    String id;
    String name;
    String phoneNumber;
    String drivingLicense;

    public Driver(String id, String name, String phoneNumber, String drivingLicense) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.drivingLicense = drivingLicense;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }
}
