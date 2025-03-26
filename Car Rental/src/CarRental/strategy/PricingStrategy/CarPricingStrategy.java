package CarRental.strategy.PricingStrategy;

import CarRental.entities.Receipt;

public class CarPricingStrategy implements PricingStrategy{
    public double calculatePrice(Receipt receipt){
        return receipt.getDays()*10;
    }
}
