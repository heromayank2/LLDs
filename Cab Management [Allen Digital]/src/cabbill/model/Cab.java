package cabbill.model;

import cabbill.managers.BillingManager;
import cabbill.strategy.BillingStrategy;

public class Cab {
    Driver driver;
    Vehicle vehicle;
    BillingManager billingManager;

    public Cab(Vehicle vehicle, Driver driver, BillingStrategy billingStrategy) {
        this.vehicle = vehicle;
        this.driver = driver;
        billingManager = new BillingManager(billingStrategy);

    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public BillingManager getBillingManager() {
        return billingManager;
    }

    public void setBillingManager(BillingManager billingManager) {
        this.billingManager = billingManager;
    }
}
