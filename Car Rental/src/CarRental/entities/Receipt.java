package CarRental.entities;

import CarRental.enums.ReceiptStatus;
import CarRental.strategy.PricingStrategy.PricingStrategy;

public class Receipt {

    Vehicle vehicle;
    Integer days;
    ReceiptStatus status;
    User user;
    PricingStrategy pricingStrategy;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public ReceiptStatus getStatus() {
        return status;
    }

    public void setStatus(ReceiptStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPricingStrategy(PricingStrategy pricingStrategy){
        this.pricingStrategy = pricingStrategy;
    }

    public PricingStrategy getPricingStrategy(){
        return this.pricingStrategy;
    }
}
