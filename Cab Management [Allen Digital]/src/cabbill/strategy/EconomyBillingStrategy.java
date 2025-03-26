package cabbill.strategy;

import cabbill.model.Trip;

public class EconomyBillingStrategy implements BillingStrategy{

    @Override
    public long calculateBill(Trip trip) {
        return 5 * trip.getDistance();
    }
}
