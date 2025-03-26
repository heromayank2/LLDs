package CarRental.strategy.PricingStrategy;

import CarRental.entities.Receipt;

public class BikePricingStrategy implements PricingStrategy{
    public double calculatePrice(Receipt receipt){
        return receipt.getDays()*5;
    }
}
