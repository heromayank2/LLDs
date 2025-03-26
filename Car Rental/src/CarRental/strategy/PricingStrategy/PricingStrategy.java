package CarRental.strategy.PricingStrategy;

import CarRental.entities.Receipt;

public interface PricingStrategy {
    public double calculatePrice(Receipt receipt);
}
