package cabbill.strategy;

import cabbill.model.Trip;

public class PremiumBillingStrategy implements BillingStrategy{

    @Override
    public long calculateBill(Trip trip) {
        return 12 * trip.getDistance();
    }
}
