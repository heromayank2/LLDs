package CarRental.builder;

import CarRental.entities.Receipt;
import CarRental.entities.User;
import CarRental.entities.Vehicle;
import CarRental.enums.ReceiptStatus;
import CarRental.strategy.PricingStrategy.PricingStrategy;

public class ReceiptBuilder {

    User user;
    Integer days;
    Vehicle vehicle;
    ReceiptStatus status;
    PricingStrategy pricingStrategy;

    public ReceiptBuilder setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        return this;
    }

    public ReceiptBuilder setUser(User user) {
        this.user = user;
        return this;
    }

    public ReceiptBuilder setStatus(ReceiptStatus status) {
        this.status = status;
        return this;
    }

    public ReceiptBuilder setDays(Integer days) {
        this.days = days;
        return this;
    }

    public ReceiptBuilder setPricingStrategy(PricingStrategy pricingStrategy){
        this.pricingStrategy = pricingStrategy;
        return this;
    }

    public Receipt build(){
        Receipt receipt = new Receipt();
        receipt.setVehicle(vehicle);
        receipt.setUser(user);
        receipt.setStatus(status);
        receipt.setDays(days);
        receipt.setPricingStrategy(pricingStrategy);
        return receipt;
    }

}
